package com.hexa.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category {
	private int cid;
	private String cname;
}
