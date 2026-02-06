1. Database Create

  CREATE DATABASE employee_db;

2. Select Database

  USE employee_db;

3. Table Create 
 
  CREATE TABLE employee (
      id INT NOT NULL AUTO_INCREMENT,
      name VARCHAR(50),
      email VARCHAR(50),
      salary DOUBLE,
      PRIMARY KEY (id)
  );
