package Servicii;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SpecializareS {
    private static SpecializareS inst = null;
    private SpecializareS() {}
    public static SpecializareS getInst() {
        if(inst == null) {
            inst = new SpecializareS();
        }
        return inst;
    }
    public void addSpec(int id, String univ, String fac, String nume) throws IOException {
        Audit.afisareQuery("addSpec", Thread.currentThread().getName());
        String dbUrl = "jdbc:mysql://localhost:3306/pao?useSSL=false";
        String user = "root";
        String password = "12345";
        try {
            Connection myConnection = DriverManager.getConnection(dbUrl, user, password);
            Statement myStatement = myConnection.createStatement();
            String sqlQuery = "insert into specializare values(" + id + "," + "'" + fac + "'" + "," + "'" + univ + "'" + "," + "'" + nume + "'" + ");";
            myStatement.execute(sqlQuery);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void updateSpec(int id, String nume) {
        String dbUrl = "jdbc:mysql://localhost:3306/pao?useSSL=false";
        String user = "root";
        String password = "12345";
        try {
            Connection myConnection = DriverManager.getConnection(dbUrl, user, password);
            Statement myStatement = myConnection.createStatement();
            String sqlQuery = "update specializare " + "set nume=" + "'" + nume + "'" + " where id=" + id;
            myStatement.execute(sqlQuery);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void delSpec(int id) {
        String dbUrl = "jdbc:mysql://localhost:3306/pao?useSSL=false";
        String user = "root";
        String password = "12345";
        try {
            Connection myConnection = DriverManager.getConnection(dbUrl, user, password);
            Statement myStatement = myConnection.createStatement();
            String sqlQuery = "delete from specializare where id=" + id;
            myStatement.execute(sqlQuery);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public String showSpec() throws IOException {
        Audit.afisareQuery("showSpec", Thread.currentThread().getName());
        String dbUrl = "jdbc:mysql://localhost:3306/pao?useSSL=false";
        String user = "root";
        String password = "12345";
        String res = "";
        try {
            Connection myConnection = DriverManager.getConnection(dbUrl, user, password);
            Statement myStatement = myConnection.createStatement();
            String sqlQuery = "select * from specializare;";
            ResultSet myResultSet = myStatement.executeQuery(sqlQuery);
            while(myResultSet.next()) {
                res += myResultSet.getString("id") + " " + myResultSet.getString("nume_univ") + " " + myResultSet.getString("nume_fac") + " " + myResultSet.getString("nume") + "\n";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return res;
    }
}
