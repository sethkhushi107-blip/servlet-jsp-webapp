CREATE DATABASE company;
USE company;

CREATE TABLE Employee (
    EmpID INT PRIMARY KEY,
    Name VARCHAR(50),
    Salary DOUBLE
);

INSERT INTO Employee VALUES
(101, 'Rahul', 50000),
(102, 'Priya', 60000),
(103, 'Aman', 55000);
