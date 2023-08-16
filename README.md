# DatabaseDrivenAutomation
In the above exmaple
 JDBC  was used to establish a connection to the database.
Test data will be retrieved from the database table users where the role is "user."
 iteration through the result set and  automation for each user using the retrieved data will be performed.
After completing the automation for each user,  the database resources and the browser are closed.

In a real life scenario the database connection details (jdbc:mysql://localhost:3306/testdb, "username", "password") will be replaced with an actual database connection information and  the SQL query and column names (username, password, role) will be adjusted according to the company's database schema.

Note: A database driver (such as MySQL Connector/J) should beadded to the project's dependencies.
