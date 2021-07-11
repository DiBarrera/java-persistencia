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
      <a href="#Basics">Basics</a>
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

---------

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

---------

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
- ### Java connector.
- Next, what we need is a connector that allows us to generate the connection with java and the MySQL database engine.
- First, in our IDE, where our project is, we locate the dependency directory.
- Right click -> Add dependency -> In the Query field, we write: mysql-connector-java -> select the latest version -> click on add.
- You can see in the projects panel, inside our dependencies folder, ther's now the connectors installed.
- <img src="/docs/java-persistence-connectors.png" alt="connector"/>
- Then, in the Project section, we locate the Source packages directory -> expand it -> right click on New -> Java Class -> Name the class.
- Inside the created file, type following lines of code:
- #### Conexion.java
```markdown
public class Conexion {
    public Connection get_connection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajes_app", "root", "");
            if (connection != null) {
                System.out.println("conexion exitosa");
            }
        } catch(SQLException e) {
            System.out.println(e);
        }
        return connection;
    }
}
``` 
- We go back to our Main.java file, and add the following lines isnde the Inicio class.
- #### Inicio.java
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
- Before running the program, with our database manager, we turn on Apache, and MySQL.
- Then we click on the "paly" green icon to run the program. We will be asked which is our main class to run the program, we choose our Inicio class as our main class to run the program.
- Successful connection
- <img src="/docs/java-persistence-connection.png" alt="connection"/>



<!-- Basics -->
## Basics

## Here are some steps that were followed in the course, to achieve the CRUD actions with the database.
These steps are written so that the reader can get an idea of how the application was created to achieve the main objectives of the course. Although the repository contains the completed application in its entirety.

---------

### CRUD, inserting data in our database.

- To begin with, we´re going to create serveral files or classes.java to performe the connection with the database, first we´ll create a file that will be our Data Access Object.
- We name it like MensajesDAO.java.
- Then, we create a class that will be the intermediate between the main munu and the access file. We name it mensajesService.java
- Finally we create the class that will have the basic structure to perform CRUD operations, we name it mensajes.java.
- <img src="/docs/java-persistence-files.png" alt="files"/>
---------
- After creating the necessary lines in the files MensajesDAO and MensajesService for the flow and logic of the application, we will have the necessary to make our first insertion of data in the database.
- For that, we run the program in the IDE, we recive the next output:
- <img src="/docs/java-persistence-output1.png" alt="output 1"/>
- Type 1 to write a message.
- <img src="/docs/java-persistence-output2.png" alt="output 2"/>
- We'll be asked to write the author's name.
- <img src="/docs/java-persistence-output3.png" alt="output 3"/>
- Type Enter to insert the data.
- <img src="/docs/java-persistence-output4.png" alt="output 4"/>
- We end the program process by typing the option 5.
- <img src="/docs/java-persistence-output5.png" alt="output 5"/>
- Now, we go to our phpmyadmin panel, we go to our database messages_app, we can see that the message has been sent to the database.
- <img src="/docs/java-persistence-output6.png" alt="output 6"/>

---------

### CRUD, retrieving data.

- For data recovery we are going to work with MensajesDAO and mensajesService.
- For MensajesDAO.java, we create the method leerMensajesDB.
- #### MensajesDAO.java
```markdown
public static void leerMensajesDB(){
        Conexion db_connect = new Conexion();
        
        PreparedStatement ps=null;
        ResultSet rs=null;
        
        try(Connection conexion = db_connect.get_connection())  {        
            String query="SELECT * FROM mensajes";
            ps=conexion.prepareStatement(query);
            rs=ps.executeQuery();
            
            while(rs.next()){
                System.out.println("ID: "+rs.getInt("id_mensaje"));
                System.out.println("Mensaje: "+rs.getString("mensaje"));
                System.out.println("Autor: "+rs.getString("autor_mensaje"));
                System.out.println("Fecha: "+rs.getString("fecha_mensaje"));
                System.out.println("");
            }
        }catch(SQLException e){
            System.out.println("no se pudieron recuperar los mensajes");
            System.out.println(e);
        }
    }
}
``` 
- In mensajesService, inside our main class mensajeService, we call the method created in MensajesDAO with a method that we name listarMensajes.
- #### mensajesService.java.
```markdown
public class mensajesService {
    public static void crearMensaje(){
      // Lines to execute the application
    }
    
    public static void listarMensajes(){
        MensajesDAO.leerMensajesDB();
    }
}
``` 
- Now we run the program, we'll recive the instructions that we already see in the insertion data section.
- <img src="/docs/java-persistence-output7.png" alt="output 7"/>
- Just type 2, to lost the existing messages, this will even include the previously created message.
- <img src="/docs/java-persistence-output8.png" alt="output 8"/>

---------

### CRUD, retrieving data.

- For data deleting, the user will be asked for the id of the message to be deleted, that id will be taken to MensajesDAO and MensajesDAO will "request" the database to delete the message from the id entered.
- For MensajesDAO.java, we create the method borrarMensajeDB, and inside our class MensajeDAO we write the next code.
- #### MensajesDAO.java
```markdown
public class MensajesDAO {
    
    public static void crearMensajeDB(Mensajes mensaje){
        // Lines to create message
    }
    
    public static void leerMensajesDB(){
        // Lines to recover messages
    }
    
    public static void borrarMensajeDB(int id_mensaje){
        Conexion db_connect = new Conexion();
        
        try(Connection conexion = db_connect.get_connection())  {
        PreparedStatement ps=null;
        
            try {
                String query="DELETE FROM mensajes WHERE id_mensaje = ?";
                ps=conexion.prepareStatement(query);
                ps.setInt(1, id_mensaje);
                ps.executeUpdate();
                System.out.println("el mensaje ha sido borrado");
            }catch(SQLException e) {
                System.out.println(e);
                 System.out.println("no se pudo borrar el mensaje");
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }
}
``` 
- In mensajesService, inside our main class mensajeService, we create a class name borrarMensaje, from there, we will call the method borrarMensajeDB from MensajesDAO.
- #### mensajesService.java.
```markdown
public class mensajesService {
    public static void crearMensaje(){
      // Lines to create a message
    }
    
    public static void listarMensajes(){
      // Lines to list messages
    }
    public static void borrarMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("indica el ID del mensaje a borrar");
        int id_mensaje= sc.nextInt();
        MensajesDAO.borrarMensajeDB(id_mensaje);
    }    
}
``` 
- Before we start to delete messages, just to test, create a random message as test subject, in this case we have this message with the id 5.
- <img src="/docs/java-persistence-output9.png" alt="output 9"/>
- Which is also inserted in the database.
- <img src="/docs/java-persistence-output10.png" alt="output 10"/>
- Now we run the program, we'll recive the instructions that we already see in the listing data section.
- We type 3 to delete a message, we will be asked for the id of the message to delete.
- <img src="/docs/java-persistence-output11.png" alt="output 11"/>
- In this escenario, we type 5, the id of the fifth message.
- We will receive a response that the message has been deleted successfully.
- <img src="/docs/java-persistence-output12.png" alt="output 12"/>
- Also this action affect the database, the message is no longer stored.
- Just create a new message, and you can see that it is identified with id 6. The message of id 5 has been deleted.
- <img src="/docs/java-persistence-output13.png" alt="output 13"/>

---------
---------
---------




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



<!-- Basics -->
## Basics



 <!-- Acquired skills -->
## Acquired skills

- Know and understand data persistence.
- Create databases and generate connection.
- Generate CRUD operations.
- Mastering persistence in rest APIs.



---------
