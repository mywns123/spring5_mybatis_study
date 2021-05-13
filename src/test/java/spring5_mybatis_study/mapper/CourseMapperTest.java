package spring5_mybatis_study.mapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring5_mybatis_study.config.ContextRoot;
import spring5_mybatis_study.dto.Course;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ContextRoot.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CourseMapperTest {

	private static final Log log = LogFactory.getLog(CourseMapperTest.class);

	@Autowired
	private CourseMapper mapper;

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test01SelectCourseByCondition() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tutorId", 1);

		List<Course> list = mapper.selectCourseByCondition(map);
		Assert.assertNotNull(list);
		list.stream().forEach(s -> log.debug(s.toString()));
	}

	@Test
	public void test02SelectCourseByCondition() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("CourseName", "%java%");

		List<Course> list = mapper.selectCourseByCondition(map);
		Assert.assertNotNull(list);
		list.stream().forEach(s -> log.debug(s.toString()));
	}

	@Test
	public void test03SelectCourseByCondition() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		GregorianCalendar cal = new GregorianCalendar(2013, 1, 1);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startDate", cal.getTime());

		List<Course> list = mapper.selectCourseByCondition(map);
		Assert.assertNotNull(list);
		list.stream().forEach(s -> log.debug(s.toString()));
	}

	@Test
	public void test04SelectCaseCourses() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		Map<String, Object> map = new HashMap<String, Object>();		
		map.put("searchBy", "Tutor");
		map.put("tutorId", 1);

		List<Course> list = mapper.selectCaseCourses(map);
		Assert.assertNotNull(list);
		list.stream().forEach(s -> log.debug(s.toString()));
		
		map.replace("searchBy", "CourseName");
		map.remove("tutorId");
		map.put("name", "%java%");
		list = mapper.selectCaseCourses(map);
		Assert.assertNotNull(list);
		list.stream().forEach(s -> log.debug(s.toString()));		
	}
	
	@Test
	public void test05SelectWhereCourses() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<Course> list = mapper.selectWhereCourses(map);
		Assert.assertNotNull(list);
		list.stream().forEach(s -> log.debug(s.toString()));
		
		map.put("tutorId", 1);		
		list = mapper.selectWhereCourses(map);
		list.stream().forEach(s -> log.debug(s.toString()));
		
		map.put("CourseName", "%java%");
		list = mapper.selectWhereCourses(map);
		list.stream().forEach(s -> log.debug(s.toString()));
		
		map.clear();
		map.put("endDate", new Date());
		list = mapper.selectWhereCourses(map);
		list.stream().forEach(s -> log.debug(s.toString()));		
	}

	@Test
	public void test06SelectWhereCourses() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<Course> list = mapper.selectTrimCourses(map);
		Assert.assertNotNull(list);
		list.stream().forEach(s -> log.debug(s.toString()));
		
		map.put("tutorId", 1);		
		list = mapper.selectTrimCourses(map);
		Assert.assertNotNull(list);
		list.stream().forEach(s -> log.debug(s.toString()));
		
		map.clear();
		map.put("CourseName", "%java%");
		list = mapper.selectTrimCourses(map);
		Assert.assertNotNull(list);
		list.stream().forEach(s -> log.debug(s.toString()));
		
		map.clear();
		map.put("tutorId", 1);	
		list = mapper.selectTrimCourses(map);
		Assert.assertNotNull(list);
		list.stream().forEach(s -> log.debug(s.toString()));		
	}
	
	@Test
	public void test07SelectCoursesForeachbyTutors() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		List<Integer> tutorIds =new ArrayList<Integer>();
		tutorIds.add(1);
		tutorIds.add(2);		
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tutorIds", tutorIds);	
		
		List<Course> list = mapper.selectCoursesForeachbyTutors(map);
		Assert.assertNotNull(list);
		list.stream().forEach(s -> log.debug(s.toString()));
	}
	
	@Test
	public void test08insertCourses() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
	
		List<Course> tutors = new ArrayList<Course>();
		tutors.add(new Course(4, "mysql", "database", new Date(), new Date(), 3));
		tutors.add(new Course(5, "mysql", "database", new Date(), new Date(), 3));
		tutors.add(new Course(6, "mariaDb", "database", new Date(), new Date(), 4));
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tutors", tutors);	
		
		int res = mapper.insertCourses(map);
		Assert.assertEquals(3, res);		
	}
	
	@Test
	public void test09deleteCourses() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
	
		List<Integer> curseIds = Arrays.asList(4,5,6);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("curseIds", curseIds);	
		
		int res = mapper.deleteCourses(map);
		Assert.assertEquals(3, res);	
	}
	
	@Test
	public void test10updateSetCourses() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
	
		Map<String, Object> map = new HashMap<String, Object>();		
		map.put("courseId", 1);
		map.put("tutorId", 4);		
		
		int res = mapper.updateSetCourses(map);
		Assert.assertSame(1, res);
	}
		
	
	
}
