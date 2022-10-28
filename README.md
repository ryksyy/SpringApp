# SpringApp
A simple Java Spring application for managing students and their courses through a HTML form. App components will be data-models and service for courses/students, Rest API, and a file manager.
Below is a more detailed explanation of each component.

#Data-models
The application requires a model for student-data which will be one class that contains the name, age, unique id (in similar fashion as OAMK with the login name they assign you), acquired credits and which courses the student is enrolled in.
For courses there will be a parent class that holds following information about the course: credits, course name, unique course id and teacher  
The class will have two sub classes classroom, and online. 
Classroom will hold the following specifications: classroom, weekday, starting time, lecture length 
Online only holds the “zoom link” and “recording links”

#Services
These classes hold all the objects created from models and they handle possible manipulation of 
data
