package Servicii;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentS {
    private static StudentS inst = null;
    private StudentS() {}
    public static StudentS getInst() {
        if(inst == null) {
            inst = new StudentS();
        }
        return inst;
    }
    public void addStud(int id, String univ, String fac, String spec, String nume, double medie) throws IOException{
        Audit.afisareQuery("addStud", Thread.currentThread().getName());
        String dbUrl = "jdbc:mysql://localhost:3306/pao?useSSL=false";
        String user = "root";
        String password = "12345";
        try {
            Connection myConnection = DriverManager.getConnection(dbUrl, user, password);
            Statement myStatement = myConnection.createStatement();
            String sqlQuery = "insert into student values(" + id + "," + "'" + univ + "'" + "," + "'" + fac + "'" + "," + "'" + spec + "'" + "," + "'" + nume + "'" + "," + medie +");";
            System.out.println(sqlQuery);
            myStatement.execute(sqlQuery);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void updateStud(int id, String nume) {
        String dbUrl = "jdbc:mysql://localhost:3306/pao?useSSL=false";
        String user = "root";
        String password = "12345";
        try {
            Connection myConnection = DriverManager.getConnection(dbUrl, user, password);
            Statement myStatement = myConnection.createStatement();
            String sqlQuery = "update student " + "set nume=" + "'" + nume + "'" + " where id=" + id;
            myStatement.execute(sqlQuery);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void deleteStud(int id) {
        String dbUrl = "jdbc:mysql://localhost:3306/pao?useSSL=false";
        String user = "root";
        String password = "12345";
        try {
            Connection myConnection = DriverManager.getConnection(dbUrl, user, password);
            Statement myStatement = myConnection.createStatement();
            String sqlQuery = "delete from student where id=" + id;
            myStatement.execute(sqlQuery);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public String showStud() throws IOException {
        Audit.afisareQuery("showStud", Thread.currentThread().getName());
        String dbUrl = "jdbc:mysql://localhost:3306/pao?useSSL=false";
        String user = "root";
        String password = "12345";
        String res = "";
        try {
            Connection myConnection = DriverManager.getConnection(dbUrl, user, password);
            Statement myStatement = myConnection.createStatement();
            String sqlQuery = "select * from student order by medie DESC";
            ResultSet myResultSet = myStatement.executeQuery(sqlQuery);
            while(myResultSet.next()) {
                res += myResultSet.getString("id") + " " + myResultSet.getString("nume_univ") + " " + myResultSet.getString("nume_fac") + " " + myResultSet.getString("nume_spec") + " " + myResultSet.getString("nume") + " " + myResultSet.getString("medie") + "\n";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return res;
    }
}
