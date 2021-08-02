
/* 
Part 1, Question A
*/
select s.*
From Student s, enrolled e, course c
Where s.SID = e.StudentID AND e.CourseID = c.CID AND s.Career = 'UGRD' AND c.CourseNr > 400;

/*
Part 1, Question B
*/
select s.LastName, s.SID, c.Department
From Student s, enrolled e, course c
Where s.SID = e.StudentID AND e.CourseID = c.CID AND s.SSN IS NULL;

--Part 1, Question C

Select CID, CourseName, Department
From course
Where CourseName LIKE 'Theory%' OR CourseName LIKE '%Analysis';

--Part 1, Question D
--way one
Select S.LASTNAME, S.FIRSTNAME, S.SID
From Student s
Where s.SID NOT IN 
(   select studentID
	From Enrolled
)

-- way two
Select S.LASTNAME, S.FIRSTNAME, S.SID
From Student s
LEFT JOIN Enrolled e ON e.studentID = s.SID
where e.StudentID IS NULL

-- Part 2
-- par2 A
Select model, year
From Cars 
Where make = 'Honda' OR price >= 22000;

--Part 2 B
Select *
From Cars
Where make != 'Kia' OR price >=12000;
--part 2 C
Insert into Cars values (50,'Kia', 12000, '01/20/2019');

--part 2 D
Select model, year
From Cars 
natural join Dealer on cid = did 
where drevenue < 1000000 AND dstate = 'MA';

--part 2 E

select model
From Cars
Right outer Join Warranty on cid = wid
Where cost <5500 AND Worigin IS NULL;


