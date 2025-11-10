## Code Setup

This application uses java and psqlJDBC.(the dependency had already been included in `pom.xml`)

To run it, one could either execute directly in the repo by changing postgreSQL connection detail(user,password,database name) to the desired one inside `src/main/java/Main.java` or copy the package folder `src/main/java/dbinteract` to ones own java project, and import package `dbinteract`, and initialize the class `dbinteract.StudentDB(<connection object>)` to invoke the four functions(methods) specified in specification

The sample invokation is as follows:

```
import dbinteract.StudentDB;


//...

Connection desired_connection_object = DriverManager.getConnection(url, user, password);

//...


StudentDB db = StudentDB(desired_connection_object);

db.getAllStudents();
//...

```


## Database Initialization

The initialization of creating tables and insert initial values are pack into one .sql file, inside root `PostgreInit.sql`

One can copy/open its query into pgAdmin and execute in a desired database, which would complete the postgre side of setup


## Demonstration

YoutubeVideo: https://www.youtube.com/watch?v=L5Dob-B-S-8





