package com.jbk.springBoot_simple.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.springBoot_simple.entity.Student;

@RestController
public class StudentController {
	
	List<Student> list=new ArrayList<>();
    
	@PostMapping(value="/saveStudent")
	public boolean saveStudent(@RequestBody Student student) {
		list.add(student);
		return true;
	}
	
	@GetMapping(value="/getAllStudents")
	public List<Student> getAllStudents() {
		return list;
		
	}
	
	@GetMapping(value="/getStudentById/{id}")
	public Student getStudentById(@PathVariable int id){
		Student student=null;
		for (Student stud : list) {
			if(stud.getStudentId()==id){
				student=stud;
				break;
			}
		}
		 return student;
	}
	
	@PutMapping(value="/updateStudent")
	public String updateStudentById(@RequestBody Student st) {
	     String msg="Student not exist";
		for(Student s: list)
		{
			if(s.getStudentId()==st.getStudentId())
			{
				list.remove(s);
			    list.add(st);
			    msg="updated";
			    break;
			}
		}
		return msg;
	}
		@DeleteMapping(value="/deleteStudentById/{id}")
		public String deleteStudentByName(@PathVariable int  id) {
			String msg="Student not exists";
			for(Student s:list)
			{
				if(s.getStudentId()==id)
				{
					list.remove(s);
					System.out.println("Deleted");
					msg="Deleted";
					break;
				}
			}
			return msg;
		}
	
}

