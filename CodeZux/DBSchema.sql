-- creating AuthTable : only authentication
create table userAuth(uid int,  foreign key(uid) references userProfile(uid), password varchar(16));

-- creating userprofile table
create table userProfile(uid int primary key, name varchar(30), mobile_number BigInt(12), dob datetime, college varchar(20), email_id varchar(40), city varchar(10), state varchar(15), pin int);


-- creating course table
create table courses(course_id int primary key, course_name varchar(10), recommend_period_day int, total_point int);

-- creating test table
create table test(test_id int primary key, course_id int, foreign key(course_id) references courses(course_id) , name varchar(10), label varchar(10), point int, total_mark int);

-- creating assignment table
create table assignment(assignment_id int primary key, course_id int, foreign key(course_id) references courses(course_id), name varchar(20), label varchar(10), point int, total_mark int);

-- creating content table
create table content(content_id int primary key, course_id int, test_id int, assignment_id int,content_name varchar(30), label varchar(10), point int, foreign key(course_id) references courses(course_id), foreign key(test_id) references test(test_id), foreign key(assignment_id) references assignment(assignment_id));

-- create table course_taken : relation between course and user
create table course_taken(uid int, course_id int, on_date datetime, foreign key(uid) references userProfile(uid), foreign key(course_id) references courses(course_id));

-- create table test_taken : relationship between user and test
create table test_taken(uid int, test_id int, mark_secured int, ondate datetime, foreign key(uid) references userProfile(uid), foreign key(test_id) references test(test_id));

-- create table assignment_taken : relationship between user and assignment
create table assignment_taken(uid int, assignment_id int, on_date datetime, mark_secured int, foreign key(uid) references userProfile(uid), foreign key(assignment_id) references assignment(assignment_id));

-- content completed: relationship between user and content
create table content_covered(uid int, content_id int, on_datetime datetime, foreign key(uid) references userProfile(uid), foreign key(content_id) references content(content_id));