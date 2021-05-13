package spring5_mybatis_study.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring5_mybatis_study.dto.Student;
import spring5_mybatis_study.resulthandler.StudentResultHandler;
import spring5_mybatis_study.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	private final String namespace = "spring5_mybatis_study.mapper.StudentMapper";

	@Autowired
	private SqlSession sqlSession;

	@Override
	public Map<Integer, String> selectStudentForMap(int studId) {
		Map<Integer, String> map = new HashMap<>();
		StudentResultHandler resultHandler = new StudentResultHandler(map);

		sqlSession.select(namespace + ".selectStudentForMap", studId, resultHandler);
		return map;
	}

	@Override
	public Map<Integer, Student> selectStudentForMap2(int studId) {
		Map<Integer, Student> map = new HashMap<>();
		ResultHandler<Student> handler = new ResultHandler<Student>() {

			@Override
			public void handleResult(ResultContext<? extends Student> resultContext) {
				Student student = resultContext.getResultObject();
				map.put(student.getStudId(), student);
			}
		};
		sqlSession.select(namespace + ".selectStudentForMap", studId, handler);
		return map;
	}

	@Override
	public Map<Integer, Student> selectStudentForMap() {
		Map<Integer, Student> map = new HashMap<>();
		ResultHandler<Student> handler = new ResultHandler<Student>() {

			@Override
			public void handleResult(ResultContext<? extends Student> resultContext) {
				Student student = resultContext.getResultObject();
				map.put(student.getStudId(), student);
			}
		};
		// list<Student> -> handler -> Map<Integer, Student> map
		sqlSession.select(namespace + ".selectStudentForMap", handler);
		return map;
	}

}
