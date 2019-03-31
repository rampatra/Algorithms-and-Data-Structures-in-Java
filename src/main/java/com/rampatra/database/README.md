# Relational Database (WIP)

A __relational database__ is a digital database based on
the [relational model](https://en.wikipedia.org/wiki/Relational_model) of
data. In simple words, it is a collection of data items with pre-defined 
relationships between them. These items are organized as a set of tables,
with columns and rows. Each column stores some specific attribute of an object/entity and the
row represents a specific object/entity.

A software system used to maintain relational databases is a __relational
database management system (RDBMS)__, for e.g., MySQL, Oracle DB, PostgreSQL, etc. 
Virtually all relational database systems use __SQL (Structured Query Language)__ 
for querying and maintaining the database.

## Basic Definitions

1. Primary Key

2. Candidate Key

3. Composite Key

4. Prime/Non-prime attribute

## Types of SQL commands

1. DDL
2. DML
3. DCL
4. TCL

| Type	| Command List      |
|-------|-------------------|
| DDL	|   CREATE          |
|       |   DROP            |
|       |  ALTER            |
|       |  RENAME           |
|       |  TRUNCATE         |
|       |                   |
| DML	|   SELECT          |
|       |    INSERT         |
|       |    UPDATE         |
|       |    DELETE         |
|       |                   |
| DCL	| GRANT             |
|       |  REVOKE           |
|       |                   |
| TCL	| START TRANSACTION |
|       |  COMMIT           |
|       |  ROLLBACK         |

## Types of Joins

1. Inner Join
2. Left Outer Join
3. Right Outer Join
4. Full Join
5. Self Join

## Normalization Forms

1. 1NF
2. 2NF
3. 3NF
4. BCNF
5. 4NF
6. 5NF

#### 1NF

Required conditions:

a. All values should be atomic (non-breakable).  
b. There should be a candidate key or a composite key (basically you should be able to uniquely identify all records in the table).

 