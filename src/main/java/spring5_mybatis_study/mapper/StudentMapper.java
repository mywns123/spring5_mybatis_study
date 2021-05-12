package spring5_mybatis_study.mapper;

import java.util.List;
import java.util.Map;

import spring5_mybatis_study.dto.Student;

public interface StudentMapper {
	Student selectStudentById(Student student);

	Student selectStudentByIdWithResultMap(Student student);

	List<Student> selectStudentByAll();

	int insertStudent(Student student);

	int deleteStudent(int id);

	int updateStudent(Student student);

	List<Map<String, Object>> selectStudentByAllForListHashmap();

	Student selectStudentByIdAssociation(Student student);

	int insertEnumStudent(Student student);

	Student selectStudentByMap(Map<String, String> map);

	List<Student> selectAllStudentByMap(Map<String, String> map);

	Map<Integer, String> selectStudentForMap(Student student);
}
