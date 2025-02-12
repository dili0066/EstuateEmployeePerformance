# EstuateEmployeePerformance
Overview

This is a web-based application for managing employee performance reviews. It is built using Java technologies and provides an interface for administrators and employees to track performance metrics.

Tech Stack

Backend: Java, Servlets, JDBC

Frontend: JSP, HTML, CSS

Database: MySQL

IDE: Eclipse

Server: Apache Tomcat

Prerequisites

Ensure you have the following installed before running the project:

Java Development Kit (JDK 8 or higher)

Eclipse IDE for Java EE Developers

Apache Tomcat Server (Version 9 or higher)

MySQL Database Server

MySQL JDBC Driver

Installation and Setup

1. Clone the Repository
$ git clone <repository-url>
$ cd employee-performance-webapp
2. Configure the Database

Create a database in MySQL:
CREATE DATABASE estuate;
3. Import the provided SQL script (database.sql) to set up tables.

Update database connection details in DBConnection.java:

private static final String URL = "jdbc:mysql://localhost:3306/employee_performance";
private static final String USER = "root";
private static final String PASSWORD = "your_password";


3. Set Up in Eclipse

Open Eclipse and import the project (File -> Import -> Existing Projects into Workspace).

Configure Apache Tomcat Server in Eclipse.

Add the project to the configured server.

4. Deploy and Run the Application

Start Apache Tomcat from Eclipse.

Open your browser and go to:

http://localhost:8080/employee-performance

Features

Employee login and dashboard

Performance review submission

Admin panel for managing employees

Reports and analytics

Troubleshooting

Ensure MySQL service is running.

Verify Tomcat is correctly configured in Eclipse.

Check DBConnection.java for correct database credentials.

Contact

For any issues, please contact [dilidilp8644@example.com].


