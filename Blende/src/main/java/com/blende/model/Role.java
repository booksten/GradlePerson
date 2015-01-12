package com.blende.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.joda.time.DateTime;

import com.blende.model.basemodel.BaseModel;

@Entity
@Table(name = "TSM_ROLE")
public class Role implements BaseModel {
	private int id;
    private DateTime dateModified;
    private String modifiedBy;
    private DateTime dateCreated;
    private String createdBy;
    
    @Id
	@GeneratedValue()
	@Column(name="ID", nullable = false, insertable = true, updatable = true)
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	
	@Basic
    @Column(name = "DATE_CREATED", nullable = true, insertable = true, updatable = true)
	public DateTime getDateCreated() { return dateCreated; }
	public void setDateCreated(DateTime dateCreated) { this.dateCreated = dateCreated; }

	@Basic
    @Column(name = "DATE_MODIFIED", nullable = true, insertable = true, updatable = true)
	public DateTime getDateModified() { return dateModified; }
    public void setDateModified(DateTime dateModified) {this.dateModified = dateModified;}
    

    @Basic
    @Column(name = "CREATED_BY", nullable = true, insertable = true, updatable = true, length = 45)
	public String getCreatedBy() { return createdBy; }

	public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }

	@Basic
    @Column(name = "MODIFIED_BY", nullable = true, insertable = true, updatable = true, length = 45)
	public String getModifiedBy() { return modifiedBy; }
    public void setModifiedBy(String modifiedBy) { this.modifiedBy = modifiedBy; }
}
