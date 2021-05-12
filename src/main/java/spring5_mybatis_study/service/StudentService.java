package spring5_mybatis_study.service;

import java.util.Map;

import spring5_mybatis_study.dto.Student;

public interface StudentService {
	Map<Integer, Student> selectStudentForMap();
	
	Map<Integer, String> selectStudentForMap(int studId);
	Map<Integer, Student> selectStudentForMap2(int studId);
	
}
