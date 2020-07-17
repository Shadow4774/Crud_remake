# Project: Crud_remake


# Premise
Confronted and discussed within the team of 3 people, the individual settings of the project,
pros and cons with respect to the methods and strategies for development.
The complete project structure was decided, integrating various solutions, and adopted as a solution for the group.
Working in a group it was agreed and defined the way of working, developing, modifying,
testing and dividing the work on the code for the subsequent merge of the activities carried out by individuals within a single project. 



# Roles

DEV1: Persistence and repository manager 
Preparation of the production Oracle database (persisted) and of the test DB.
Implementation of classes and bean repositories for both production and tests.

DEV2: Controller Manager 
Documents the actions that will be developed in the front-end part.
He develops the controllers that will be used for the persistence and repository part and to perform the tests. 
It prepares a series of controller tests, testing the calls to the actions, the format and the content of the returned json.

DEV3: UX JSP Manager 
Develops the UX of the project, compartmentalizing the development.



# Servlet-CRUD-Maven
Application for personal records managment with CRUD implementation and followings technologies: 
Java Servlets, Java Server Pages(JSP), JSTL, Java database Connectivity(JDBC), Oracle XE 11g, Apache Tomcat Server



# Steps
Creation on Eclipse of a dynamic web project
Converting the DWP into a Maven project
Adding the necessary dependencies to the pom (javax servlet, jstl, ojdbc8, junit, json, maven)
Creation of test servlets, to verify the operation of the Tc9 server
Java class creation of 'User' entity
Creation of static helper class for connection to the DB
Creation of primary servlet for sorting requests and achievement test)
Login component on jsp application with password encryption component.
Creation of jsp pages for data acquisition and visualization
Creation of static class DBActions, for writing sql queries and sending them to the DB
Creating pathing between jsp pages and primary processRequest function for sorting
Switch creation between primary function and specialized functions (user creation, cancellation, modification etc)
Implemented a server-side filtered search via specific class and jsp page.
Provision for testing the initial mock data to develop unit tests.



# Author 
Marco Tugnizza, Attilio Dell'Anno, Salvatore Licata



# Technologies 
Servlet
Java Database Connectivity (JDBC) ver.19.6.0.0
JSP Standard Tag Library (JSTL)
Hamcrest-all ver.1.3
Json-simple ver.1.1.1
Mockito-core ver.2.8.47

# Repository 
https:\\mvnrepository.com

# Application Servers 
Apache Tomcat v9.0.30

# DB 
Oracle Express 11g,
Oracle Sql Developer 11g

# Build Tool
Eclipse 2019-12,
Maven 3.6.3

# URI GitHub
https://github.com/Shadow4774/Crud_remake.git