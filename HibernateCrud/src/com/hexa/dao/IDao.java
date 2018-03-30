package com.hexa.dao;

import com.hexa.entity.Student;

public interface IDao {
	public int addStudent(Student stu); 
    public Student getStudent(int sid);
	public int updateStudent(int sid, int marks);
	public int updateStudent(Student stu);
   public int deleteStudent(int sid);	
}
