package FetchingTestData.DataFromDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatabaseDrivenAutomation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // Set up WebDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // Open a connection to the database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "ADMIN", "password123*");

            // Query the database to retrieve test data
            String sql = "SELECT username, password FROM users WHERE role = user";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "user");
            ResultSet resultSet = statement.executeQuery();

            // Iterate through the result set and perform automation for each user
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");

                // Selenium WebDriver Automation - Open web application
                driver.get("https://demoqa.com/login");

                // Find and interact with elements using retrieved test data
                WebElement usernameField = driver.findElement(By.id("username"));
                WebElement passwordField = driver.findElement(By.id("password"));
                WebElement loginButton = driver.findElement(By.id("loginButton"));

                usernameField.sendKeys("RoseBell");
                passwordField.sendKeys("Password123*");
                loginButton.click();

                
            }

            // Close the database connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
        	
            e.printStackTrace();
            
        } finally {
        	
            // Close the browser
            driver.quit();
        }
    }

	}


