package com.hexa.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user_contact")
public class Contact extends User {
    	private String email;

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
    	

	}

