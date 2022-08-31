package com.jobready.learnJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Demo {

	public static void main(String[] args) {

		// Before anything, I must add the Java mysql connector to the project's build
		// path. To do this, I create another folder inside the project (I named this
		// one "lib"), and add the Java mysql connector to it. To do this, I have to
		// create a folder in the project by right-clicking the project, and going to
		// New -> Folder, then, I go to wherever the java connector is on my system and
		// I can copy it and paste it inside this folder. After doing that, I
		// right-click the project again, go to build path -> configure build path ->
		// libraries tab -> click Class Path -> java build path -> Class (if I don't
		// create a module?) and then the Add JARs button. Then I navigate to the folder
		// where I saved the connector in (in this cqase the lib folder), add it, then
		// click Apply and close

		// First thing we need is a connection object. The url string must start as
		// "jdbc:", followed by the name of the database (provider?): "mysql://",
		// followed by the server address, which can be the url of the server, or the ip
		// address, followed by a colon (:), followed by the port number and a slash
		// (/), followed by the name of the database.
		String url = "jdbc:mysql://127.0.0.1:3306/employees_database";
		String username = "root";
		String password = "Tyugh$$77";
		try {
			Connection conn = DriverManager.getConnection(url, username, password);

			// Create a statement object to send to the DB
			Statement statement = conn.createStatement();

			// Execute statement object and add it to ResultSet object
			ResultSet resultSet = statement.executeQuery("SELECT * FROM employees_tbl");

			int salaryTotal = 0;
			// Process the result
			while (resultSet.next()) {
				System.out.println(resultSet.getString("name"));

				// Can also do something like this, getInt() instead of getString() to be able
				// to do operations on the number fields. Otherwise, if we do getString() it
				// will get the salary as a string.
				salaryTotal += resultSet.getInt("salary");
			}
			System.out.println(salaryTotal);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
