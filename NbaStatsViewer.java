package org.rahib.nba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.sqlite.JDBC;

public class NbaStatsViewer{
	public static void main(String[] args){

		
		String url = "jdbc:sqlite:/Users/tkhan/Documents/NBA.db";  
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {

            conn = DriverManager.getConnection(url);
            
            System.out.println("Connected to the database successfully!");

            stmt = conn.createStatement();

            String sql = "SELECT * FROM nba"; 
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("RANK");  
                String name = rs.getString("NAME");  

                System.out.println("ID: " + id + ", Name: " + name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
	
	}
}