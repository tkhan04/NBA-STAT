package nba_statComparator;

import javax.swing.*;
import java.sql.*;

public class jdbc{

    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/?user=root";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "Rahib2004";


    public static String getPosition(String player){
        String pos = null;

        String query ="SELECT POS FROM `player_stats`.`all_stats_nba_player_props_tool_nba_stats_202324_all_stats_nba` WHERE NAME = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, player);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    pos = resultSet.getString("POS");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pos;
    }


    public static String getTeam(String player) {
        String team = null;
        String query = "SELECT TEAM FROM `player_stats`.`all_stats_nba_player_props_tool_nba_stats_202324_all_stats_nba` WHERE NAME = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, player);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    team = resultSet.getString("TEAM");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return team;
    }

    public static double getPoints(String player) {
        double points = 0.0;
        String query = "SELECT PPG FROM `player_stats`.`all_stats_nba_player_props_tool_nba_stats_202324_all_stats_nba` WHERE NAME = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, player);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    points = resultSet.getDouble("PPG");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return points;
    }

    public static double getAssists(String player) {
        double assists = 0.0;
        String query = "SELECT APG FROM `player_stats`.`all_stats_nba_player_props_tool_nba_stats_202324_all_stats_nba` WHERE NAME = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, player);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    assists = resultSet.getDouble("APG");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return assists;
    }

    public static double getRebounds(String player) {
        double Rebounds = 0.0;
        String query = "SELECT RPG FROM `player_stats`.`all_stats_nba_player_props_tool_nba_stats_202324_all_stats_nba` WHERE NAME = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, player);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Rebounds = resultSet.getDouble("RPG");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Rebounds;
    }



    public static boolean checkPlayerExist(String player) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("SELECT * FROM `player_stats`.`all_stats_nba_player_props_tool_nba_stats_202324_all_stats_nba` WHERE NAME = ?");

            preparedStatement.setString(1, player);
            ResultSet resultSet = preparedStatement.executeQuery();

           if(!resultSet.next()){
               return false;
           }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    public static boolean serverDown() {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return true;
        }
    }





    public static void main(String[] args) {
        if(jdbc.serverDown()){
            System.out.print("not working");
        }
        else{
            System.out.print("working");
        }
    }
}