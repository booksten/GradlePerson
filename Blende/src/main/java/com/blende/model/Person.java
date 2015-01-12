package com.blende.model;

import org.joda.time.DateTime;

import com.blende.model.basemodel.BaseModel;

import javax.persistence.*;

@Entity
@Table(name = "TSM_PERSON")
public class Person implements BaseModel {

	private int id;
	private String firstName;
	private String middleName;
    private String lastName;
    private String userName;
    private String password;
    private String address;
    private int zipCode;
    private String state;
    private String city;
    private DateTime dateModified;
    private String modifiedBy;
    private DateTime dateCreated;
    private String createdBy;
    private Role role;
    
   
	
	@Id
	@GeneratedValue()
	@Column(name="ID", nullable = false, insertable = true, updatable = true)
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	
	@Basic
    @Column(name = "FIRST_NAME", nullable = true, insertable = true, updatable = true, length = 45)
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    @Basic
    @Column(name = "MIDDLE_NAME", nullable = true, insertable = true, updatable = true, length = 45)
    public String getMiddleName() { return middleName; }
    public void setMiddleName(String middleName) { this.middleName = middleName;}
    
    @Basic
    @Column(name = "ADDRESS", nullable = true, insertable = true, updatable = true, length = 45)
    public String getAddress() {return address;}
	public void setAddress(String address) { this.address = address; }
	
	@Basic
    @Column(name = "ZIP_CODE", nullable = true, insertable = true, updatable = true)
	public int getZipCode() { return zipCode; }
	public void setZipCode(int zipCode) { this.zipCode = zipCode; }
	
	@Basic
    @Column(name = "STATE", nullable = true, insertable = true, updatable = true, length = 2)
	public String getState() { return state; }
	public void setState(String state) { this.state = state; }
	
	@Basic
    @Column(name = "CITY", nullable = true, insertable = true, updatable = true, length = 30)
	public String getCity() { return city;}
	public void setCity(String city) { this.city = city;}
	
	@Basic
    @Column(name = "LAST_NAME", nullable = true, insertable = true, updatable = true, length = 45)
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
	
    @Basic
    @Column(name = "USER_NAME", nullable = true, insertable = true, updatable = true, length = 45)
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
	
    @Basic
    @Column(name = "PASSWORD", nullable = true, insertable = true, updatable = true, length = 45)
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

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
	
    @ManyToOne
   	@JoinColumn(name = "ROLE_ID")
    public Role getRole() {return role;}
	public void setRole(Role role) {this.role = role;}
    
   
    

}
