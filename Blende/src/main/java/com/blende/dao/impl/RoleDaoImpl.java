package com.blende.dao.impl;

import org.springframework.stereotype.Repository;

import com.blende.dao.RoleDao;
import com.blende.dao.common.AbstractHibernateGenericDao;
import com.blende.model.Role;

@Repository
public class RoleDaoImpl extends AbstractHibernateGenericDao<Role> implements RoleDao {

}
