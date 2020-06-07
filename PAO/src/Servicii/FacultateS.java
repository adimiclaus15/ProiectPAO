package Servicii;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class FacultateS {
    private static FacultateS inst = null;
    private FacultateS() {}
    public static FacultateS getInst() {
        if(inst == null) {
            inst = new FacultateS();
        }
        return inst;
    }
    public void addFac(int id, String univ, String nume, String adresa) throws IOException {
        Audit.afisareQuery("addFac", Thread.currentThread().getName());
        String dbUrl = "jdbc:mysql://localhost:3306/pao?useSSL=false";
        String user = "root";
        String password = "12345";
        try {
            Connection myConnection = DriverManager.getConnection(dbUrl, user, password);
            Statement myStatement = myConnection.createStatement();
            String sqlQuery = "insert into facultate values(" + id + "," + "'" + univ + "'" + "," + "'" + nume + "'" + "," + "'" + adresa + "');";
            myStatement.execute(sqlQuery);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void updateFac(int id, String nume) {

        String dbUrl = "jdbc:mysql://localhost:3306/pao?useSSL=false";
        String user = "root";
        String password = "12345";
        try {
            Connection myConnection = DriverManager.getConnection(dbUrl, user, password);
            Statement myStatement = myConnection.createStatement();
            String sqlQuery = "update facultate " + "set nume=" + "'" + nume + "'" + " where id=" + id;
            myStatement.execute(sqlQuery);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void deleteFac(int id) {
        String dbUrl = "jdbc:mysql://localhost:3306/pao?useSSL=false";
        String user = "root";
        String password = "12345";
        try {
            Connection myConnection = DriverManager.getConnection(dbUrl, user, password);
            Statement myStatement = myConnection.createStatement();
            String sqlQuery = "delete from facultate where id=" + id;
            myStatement.execute(sqlQuery);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public String showFac() throws IOException {
        Audit.afisareQuery("showFac", Thread.currentThread().getName());
        String dbUrl = "jdbc:mysql://localhost:3306/pao?useSSL=false";
        String user = "root";
        String password = "12345";
        String res = "";
        try {
            Connection myConnection = DriverManager.getConnection(dbUrl, user, password);
            Statement myStatement = myConnection.createStatement();
            String sqlQuery = "select * from facultate;";
            ResultSet myResultSet = myStatement.executeQuery(sqlQuery);
            while(myResultSet.next()) {
                res += myResultSet.getString("id") + " " + myResultSet.getString("nume_univ") + " " + myResultSet.getString("nume") + " " + myResultSet.getString("adresa") + "\n";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return res;
    }
}
