select * from ADDRESSES;
select * from STUDENTS;
select * from TUTORS;
select * from COURSES;
select * from COURSE_ENROLLMENT;
select * from user_pics;

delete  from user_pics where id >2;
delete  from  students where stud_id >2;

select stud_id, name, email, dob, phone
from STUDENTS
where stud_id = 1;

insert into user_pics(id, name, pic, bio)
values (#{id}, #{name}, #{pic}, #{bio});

select id, name, pic, bio
from user_pics
where id = 1;

delete 
from user_pics
where id = 1;
select stud_id, name, email, dob,
	substring(phone,1,3)as f, 
	substring(phone,5,3)as m, 
	substring(phone,9,4)as l 
from STUDENTS
where stud_id = 1;

insert into students(stud_id, name, email, phone, dob)
values ();



update students 
set name , email , phone , dob 
where stud_id =1;

select stud_id, name, email, phone, dob,
	   a.addr_id, street, city, state, zip, country
  from STUDENTS s join addresses a
    on s.addr_id  = a.addr_id 
 where stud_id =1;

 /*1:N*/
select t.tutor_id, t.name as tutor_name,
	   email, c.course_id, c.name, description, start_date, end_date
  from tutors t join courses c on t.tutor_id= c.tutor_id
 where t.tutor_id= 1;

select course_id, name, description, start_date, end_date, tutor_id
from courses;

select course_id, name, description, start_date, end_date, tutor_id
from courses
where course_id =1;

select course_id, name, description, start_date, end_date, tutor_id
from courses
where name like '%java%';

select course_id, name, description, start_date, end_date, tutor_id
from courses
where start_date >= '2013-02-01';

select course_id, name, description, start_date, end_date, tutor_id
from courses
where end_date <= '2013-07-01';

select course_id, name, description, start_date, end_date, tutor_id
from courses
where start_date >= '2013-02-01' and end_date <= '2013-07-01';


insert into courses(course_id, name, description, start_date, end_date, tutor_id)
values ();

delete from courses where course_id in(5,6);
   