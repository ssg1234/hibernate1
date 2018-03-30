package com;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.zone.ZoneRulesProvider;
import java.util.Set;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate d1=LocalDate.now();
		System.out.println(d1);
		LocalTime d2=LocalTime.now();
		System.out.println(d2);
		LocalDateTime d3=LocalDateTime.now();
		System.out.println(d3);
		Set<String> ss =ZoneRulesProvider.getAvailableZoneIds();
		ss.forEach(val->System.out.println(val));
		LocalDateTime d4=LocalDateTime.now(ZoneId.of("America/Cuiaba"));
		System.out.println("time of america"+d4);
		LocalDateTime d=LocalDateTime.of(d1,d2);
		System.out.println(d);
		//String str = "1986-04-08";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		//LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
		LocalDate d7=LocalDate.now();
		
		System.out.println("User="+d1.format(formatter));
		DateTimeFormatter format = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);
		LocalDateTime d6=LocalDateTime.now();
		d6.format(format);
		System.out.println(d6);
		
		  
		

	}

}
