# Java Persistence

## It was learned how data persistence works in an information system, using a relational database as a form of storage. It was possible to connect java with a database through a driver.

<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#Overviwe">Overviwe</a>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
    </li>
    <li><a href="#Topics-reviewed">Topics reviewed</a></li>
    <li><a href="#Acquired-skills">Acquired skills</a></li>
  </ol>
</details>



<!-- Overviwe -->
## Overviwe

In this repository you will find a brief summary of what was learned in the [platzi](https://platzi.com/cursos/java-persistencia/) course of Java SE data persistence.

---------

In the following link, you will find a repository related to the java persistence course.

https://github.com/DiBarrera/java-gatos-api


---------

Topics such as the types of databases, the essential concept of a relational database were understood: That they are related to each other through a hierarchy and how to work on them by applying CRUD actions.

---------

This repository is divided into the following parts.
* The steps to clone the repository and be able to view it.
* The main topics seen in the course.
* Skills acquired at the end of the course.



<!-- GETTING STARTED -->
## Getting Started

## Setup

- Fork this repo
- Clone this repo

```shell
$ mkdir java-persistence
$ cd java-persistence
$ git clone https://github.com/DiBarrera/java-persistencia.git
```

You will find the following files:

- **The src directory** containing the main files of the project development.

### For this repository, MySQL was used as a database.

### For this repository, NetBeans was used as IDE.

### Xampp is a package that contains various tools for creating web applications: an apache web server, the MySQL database, PHPMyAdmin, and PHP.

### Installation of MySQL:

- To install it, we go to the following link: https://www.apachefriends.org/es/download.html
- Select the installer according to our operating system.
- To install our database we will use a manager called XAMPP, a software that contains the apache web server, mysql as the database, php as the backend language and proftpD as the ftp server.
- In this case, we only need to use mysql as the database and apache to manage our database from the PhpMyAdmin web tool.
- Once the installer is downloaded, we follow the steps for its installation.
- Once the installation is finished, launch XAMPP.
- In the Manage Servers tab. Select the web and database server and click on Start.
- You will notice if these services are turned whene the icons turn in green.
- When the services are started, in a web browser we go to the following link: http://localhost or http://localhost/dashboard/ 
- Click on phpMyAdmin at the top right of the menu to open the phpMyAdmin manager or click on the next link: http://localhost/phpmyadmin
- Now we can manage our MySQL database.

### Connection to MySQL from Java

- In our IDE, where our project is, we locate the Source Package directory.
- Create the main java file.
- It souhld have the next lines of code in it:
- #### Main.java
```markdown
public class Main {
  public static void main(String[] args) {
  
  }
}
``` 
- Next, in our IDE, where our project is, we locate the dependency directory.
- Right click -> Add dependency -> In the Query field, we write: mysql-connector-java -> select the latest version -> click on add.
- Then, in the Project section, we locate the Source packages directory -> expand it -> right click on New -> Java Class -> Name the class.
- Inside the created file, type following lines of code:
- #### Connecion.java
```markdown
public class Connection {
  public Connection get_connection() {
    Connection connection = null;
    try {
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/app_name", "root", "");
      if(connection != null) {
        System.outprintln("Successful connection")
      }
    } catch(SQLException e) {
        System.out.println(e);
    }
    return connection;
  }
}
``` 
- We go back to our Main.java file, and add the following lines isnde the Main class.
- #### Main.java
```markdown
public class Main {
  public static void main(String[] args) {
    Connection connection = new Connection();
    try(Connection cnx = connection.get_connection()) {
    
    } catch(Exception e) {
      System.out.println(e);
    }
  }
}
``` 
- Be sure to have all the necesary imports.
- Then we click on the "paly" green icon to run the program. We will be asked what is the Available Main Classes.
- Successful connection







<!-- Topics reviewed -->
## Topics reviewed

For a better understanding of the following topics, two projects were developed in this repository, a program for sending, editing and deleting messages and a program to connect with a public API.

### Topics

- Data persistence.
- Relational databases.
- MySQL.
- DDL (Data Definition Language).
- Connection to MySQL from Java.
- DAO (Data Access Object).
- CRUD Acctions.
- Data insertion. 
- Data reading. 
- Deletion of data. 
- Data update.
- HTTP and its methods.
- GET, POST, PUT or PATCH and DELETE.
- Use of API Keys.
- List data from a public API.
- Show API data.
- Save data to public API.
- List saved data. 
- Delete data from the API.



 <!-- Acquired skills -->
## Acquired skills

- Know and understand data persistence.
- Create databases and generate connection.
- Generate CRUD operations.
- Mastering persistence in rest APIs.



---------
