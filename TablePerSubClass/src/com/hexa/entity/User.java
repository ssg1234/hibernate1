package com.hexa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class User {
	@Id
  private int uid;
  private String uname;
  
  public int getUid() {
	  return uid;
  }
  public void setUid(int uid) {
	  this.uid = uid;
  }
  public String getUname() {
	  return uname;
  }
  public void setUname(String uname) {
	  this.uname = uname;
  }
  
}
