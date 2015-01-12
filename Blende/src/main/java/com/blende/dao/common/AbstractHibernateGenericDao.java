package com.blende.dao.common;

import com.blende.model.basemodel.BaseModel;
import com.blende.support.AuthenticationInfo;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;

import java.util.List;

public abstract class AbstractHibernateGenericDao<T extends BaseModel> extends AbstractHibernateDao implements GenericDao<T> {

    private final Class<T> clazz;

    private final String RECORD_COUNT_HQL;
    private final String FIND_ALL_HQL;
    private final String DELETE_HQL;

    @Autowired
    protected AuthenticationInfo authenticationInfo;

    @SuppressWarnings("unchecked")
	public AbstractHibernateGenericDao()
    {
        this.clazz = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), AbstractHibernateGenericDao.class);
        this.RECORD_COUNT_HQL = "select count(*) from " + this.clazz.getName();
        this.FIND_ALL_HQL = "from " + this.clazz.getName() + " t ";
        this.DELETE_HQL = "delete from " + this.clazz.getName() + " t where t.Id = :id";
    }

    @SuppressWarnings("unchecked")
	@Override
    public T findOne(int id) {
        return (T)getSession().get(clazz,id);
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<T> findAll() {
        return getSession().createQuery(FIND_ALL_HQL).list();
    }

    @Override
    public T create(T entity) {
        DateTime now = DateTime.now(DateTimeZone.UTC);
        entity.setDateCreated(now);
        entity.setDateModified(now);
        entity.setCreatedBy(authenticationInfo.getUserName());
        getSession().save(entity);
        return entity;
    }

    @Override
    public T update(T entity) {
        entity.setDateModified(DateTime.now(DateTimeZone.UTC));
        getSession().merge(entity);
        return entity;
    }

    @Override
    public void delete(T entity) {
        getSession().delete(entity);
    }

    @Override
    public void deleteById(int entityId) {
        getSession().createQuery(DELETE_HQL)
                .setInteger("id",entityId)
                .executeUpdate();
    }

    @Override
    public long count() {
        return (long) getSession().createQuery(RECORD_COUNT_HQL)
                .uniqueResult();
    }
}
