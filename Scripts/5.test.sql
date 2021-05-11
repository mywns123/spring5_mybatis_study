select * from ADDRESSES;
select * from STUDENTS;
select * from TUTORS;
select * from COURSES;
select * from COURSE_ENROLLMENT;

select stud_id, name, email, dob, phone
from STUDENTS
where stud_id = 1;

select stud_id, name, email, dob,
	substring(phone,1,3)as f, 
	substring(phone,5,3)as m, 
	substring(phone,9,4)as l 
from STUDENTS
where stud_id = 1;

insert into students(stud_id, name, email, phone, dob)
values ();

delete  from  students where stud_id =1;

update students 
set name , email , phone , dob 
where stud_id =1;

select stud_id, name, email, phone, dob,
	   a.addr_id, street, city, state, zip, country
  from STUDENTS s join addresses a
    on s.addr_id  = a.addr_id 
 where stud_id =1;



