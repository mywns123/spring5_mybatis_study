package spring5_mybatis_study.mapper;

import java.util.List;
import java.util.Map;

import spring5_mybatis_study.dto.Course;

public interface CourseMapper {

	/* 동적 SQL - if조건 */
	List<Course> selectCourseByCondition(Map<String, Object> map);

	/* 동적 SQL - choose조건 */
	List<Course> selectCaseCourses(Map<String, Object> map);
	
	/* 동적 SQL - where조건 */
	List<Course> selectWhereCourses(Map<String, Object> map);
	
	/* 동적 SQL - where조건 */
	List<Course> selectTrimCourses(Map<String, Object> map);
	
	/* 동적 SQL - foreach조건 */
	List<Course> selectCoursesForeachbyTutors(Map<String, Object> map);
	
	/* foreach */
	int insertCourses(Map<String, Object> map);
	
	/* foreach */
	int deleteCourses(Map<String, Object> map);
	
	/* foreach */
	int updateSetCourses(Map<String, Object> map);
	
	/* Transaction */
	int insertCourse(Course course);
	
	/* Transaction */
	int deleteCourse(int courseId);
	
	
}


