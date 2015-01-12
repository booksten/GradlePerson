package com.blende.model.basemodel;

import org.joda.time.DateTime;

public interface BaseModel {
	int getId();
	void setId(int id);
	
	DateTime getDateCreated();
	void setDateCreated(DateTime dateCreated);

	DateTime getDateModified();
	void setDateModified(DateTime dateModified);

	String getCreatedBy();
	void setCreatedBy(String createdBy);
	
	String getModifiedBy();
	void setModifiedBy(String modifiedBy);
}
