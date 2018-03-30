package com.hexa.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("onroll emp")
public class Onroll extends Employee {
   public double bonus;

   public double getBonus() {
	   return bonus;
   }

   public void setBonus(double bonus) {
	this.bonus = bonus;
   }

}
