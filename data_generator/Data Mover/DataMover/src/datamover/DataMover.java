/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datamover;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author roxin
 */
public class DataMover {

    private static Connection connect;
    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        generateShelter("/data/shelter.txt");
    }

    private static void generateShelter(String fileName) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String sCurrentLine;
            String filePath = new File("").getAbsolutePath();
            filePath = filePath.concat(fileName);
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            connect = DriverManager.getConnection("jdbc:mysql://localhost/buswaydb?"
                        + "user=root&password=");
            
            while ((sCurrentLine = br.readLine()) != null) {
                String input = sCurrentLine;
                String[] temp = input.split(",");

                // statements allow to issue SQL queries to the database
                statement = connect.createStatement();

                // preparedStatements can use variables and are more efficient
                preparedStatement = connect
                        .prepareStatement("insert into  buswaydb.shelters values (default, ?, ?, ?)");
                // parameters start with 1
                preparedStatement.setString(1, temp[0]);
                preparedStatement.setInt(2, Integer.parseInt(temp[2]));
                preparedStatement.setInt(3, Integer.parseInt(temp[1]));
                preparedStatement.executeUpdate();
            }
        } catch (IOException ex) {
            Logger.getLogger(DataMover.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataMover.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DataMover.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
