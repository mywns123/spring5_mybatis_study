package spring5_mybatis_study.mapper;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring5_mybatis_study.config.ContextRoot;
import spring5_mybatis_study.dto.PhoneNumber;
import spring5_mybatis_study.dto.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ContextRoot.class })

public class StudentMapperTest {

	private static final Log log = LogFactory.getLog(StudentMapperTest.class);

	@Autowired
	private StudentMapper mapper;
	
	@After
	public void tearDown() throws Exception {
		System.out.println();
	}
	
	@Test
	public void testSelectStudentById() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Student student = new Student();
		student.setStudId(1);
		Student selectStudent = mapper.selectStudentById(student);
		
		log.debug(selectStudent.toString());
		Assert.assertNotNull(student);
	}

	@Test
	public void testSelectStudentByIdWithResultMap(){
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Student student = new Student();
		student.setStudId(1);
		Student selectStudent = mapper.selectStudentByIdWithResultMap(student);
		
		log.debug(selectStudent.toString());
		Assert.assertNotNull(selectStudent);
	}
	
	@Test
	public void testselectStudentByAll(){
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		List<Student> list = mapper.selectStudentByAll();
		Assert.assertNotNull(list);
	
		list.stream().forEach(System.out::println);
		list.stream().forEach(s -> log.debug(s.toString()));
	}
	
	@Test
	public void test04insertStudent() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		Calendar newDate = GregorianCalendar.getInstance();
		newDate.set(1990, 2, 28);
		
		Student student = new Student();
		student.setStudId(3);
		student.setName("홍길동3");
		student.setEmail("lee@test.co.kr");
		student.setPhone(new PhoneNumber("010-1234-1234"));
		student.setDob(newDate.getTime());
		
		int res = mapper.insertStudent(student);
		Assert.assertEquals(1, res);
	}
	
	@Test
	public void test06deleteStudent() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		int deleteStudent = mapper.deleteStudent(3);
		Assert.assertSame(1, deleteStudent);
	}
	
	@Test
	public void test05updateStudent() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Student student = new Student();
		student.setStudId(1);
		student.setName("Timothy");
		student.setEmail("test@test.co.kr");
		student.setPhone(new PhoneNumber("987-1234-1234"));
		student.setDob(new Date());
		
		int result = mapper.updateStudent(student);
		Assert.assertSame(1, result);		
	}
	
	@Test
	public void testSelectStudentByAllForListHashmap() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Map<String, Object>> list = mapper.selectStudentByAllForListHashmap();
		Assert.assertNotNull(list);
		
		for(Map<String, Object> map : list ){
			for(Entry<String, Object> e : map.entrySet()) {
				log.debug(String.format("%s -> %s", e.getKey(), e.getValue()));
			}
		}
	}
	
	@Test
	public void test10selectStudentByIdAssociation() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Student student = new Student();
		student.setStudId(1);
		Student selectStudent = mapper.selectStudentByIdAssociation(student);
		Assert.assertNotNull(selectStudent);
		log.debug(selectStudent.toString());

	}
	
	
	
	
}
