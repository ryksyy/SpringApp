# SpringApp
A simple Java Spring application for managing students and their courses through a HTML form. App components will be data-models and service for courses/students, Rest API, and a file manager.
There is a thunderclient export in the root for easy testing of the API and the text/ folder has some text documents preloaded with data
Below is a more detailed explanation of each component.

# Data-models
The application requires a model for student-data which will be one class that contains the name, age, unique id (in similar fashion as OAMK with the login name they assign you), acquired credits and which courses the student is enrolled in.
For courses there will be a parent class that holds following information about the course: credits, course name, unique course id and teacher  
The class will have two sub classes classroom, and online. 
Classroom will hold the following specifications: classroom, weekday, starting time, lecture length 
Online only holds the “zoom link” and “recording links”

# Services
These classes hold all the objects created from models and they handle possible manipulation of 
data

# Rest
This handles http requests and calls services as needed. There won't be full documentation here but a thunderclient
export is included in the repo which has everything ready to go
Available requests:
POST
/addOnlineCourse
/addStudent
/addClassCourse
/enroll
GET
/getStudents
/getClassRoomCourses
/searchCourseById
/searchStudentbyId
/getStudentsOn        (get which students are on a course)
/getStudentsCourses   (get which courses a student is enrolled in)

# File Manager
Instead of using a proper database this practice project will load and save data-model data from a text file.
The program loads data from file whenever needed and writes data whenever new objects are added or a student gets enrolled

# HTML "frontend"
Very basic static webpage that has all the methods listed under Rest implemented in simple ways
main drawback of this is that post methods dont create a response on the page, but you can verify that changes are happening from the text files

I realize being able to add duplicate courses and students is bad but I feel this project should be good enough for the scope of this course
