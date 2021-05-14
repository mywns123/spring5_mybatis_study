
-- procedure
select *
from tutors t left join courses c 
on t.tutor_id = c.tutor_id ;

-- 교수가 개설한 교과목 수를 구하시오.
select t.name as tutors , count(c.name) as total
  from tutors t left join courses c 
	on t.tutor_id = c.tutor_id
 group by t.name;

select t.name as tutors , count(c.name) as total
  from tutors t left join courses c 
	on t.tutor_id = c.tutor_id
 where t.tutor_id = 1;

select * from TUTORS;
select * from COURSES;

DROP PROCEDURE IF EXISTS mybatis_study.course_total;

DELIMITER $$
$$
CREATE PROCEDURE mybatis_study.course_total(in t_id int)
BEGIN
	select t.name as tutor , count(c.name) as total
	  from tutors t left join courses c 
		on t.tutor_id = c.tutor_id
	 where t.tutor_id = t_id;	
END$$
DELIMITER ;

call course_total(4);

DROP PROCEDURE IF EXISTS mybatis_study.course_total_group;

DELIMITER $$
$$
CREATE PROCEDURE course_total_group()
BEGIN
	select t.name as tutor , count(c.name) as total
	  from tutors t left join courses c 
		on t.tutor_id = c.tutor_id
	 group by t.tutor_id;	
END$$
DELIMITER ;

call course_total_group();