package Servicii;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UniversitateS {
    private static UniversitateS inst = null;
    private UniversitateS() {}
    public static UniversitateS getInst() {
        if(inst == null) {
            inst = new UniversitateS();
        }
        return inst;
    }
    public void addUniv(int id, String nume, String adresa) throws IOException{
        Audit.afisareQuery("addUniv", Thread.currentThread().getName());
        String dbUrl = "jdbc:mysql://localhost:3306/pao?useSSL=false";
        String user = "root";
        String password = "12345";
        try {
            Connection myConnection = DriverManager.getConnection(dbUrl, user, password);
            Statement myStatement = myConnection.createStatement();
            ///System.out.println("Conexiune realizata");
            String sqlQuery = "insert into universitate values(" + id + "," + "'" + nume + "'" + "," + "'" + adresa + "');";
            myStatement.execute(sqlQuery);
            ///System.out.println("Universitate adaugata");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void updateUniv(int id, String nume) {
        String dbUrl = "jdbc:mysql://localhost:3306/pao?useSSL=false";
        String user = "root";
        String password = "12345";
        try {
            Connection myConnection = DriverManager.getConnection(dbUrl, user, password);
            Statement myStatement = myConnection.createStatement();
            String sqlQuery = "update universitate " + "set nume=" + "'" + nume + "'" + " where id=" + id;
            myStatement.execute(sqlQuery);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void deleteUniv(int id) {
        String dbUrl = "jdbc:mysql://localhost:3306/pao?useSSL=false";
        String user = "root";
        String password = "12345";
        try {
            Connection myConnection = DriverManager.getConnection(dbUrl, user, password);
            Statement myStatement = myConnection.createStatement();
            String sqlQuery = "delete from universitate where id=" + id;
            myStatement.execute(sqlQuery);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public String showUniv() throws IOException {
        Audit.afisareQuery("addUniv", Thread.currentThread().getName());
        String dbUrl = "jdbc:mysql://localhost:3306/pao?useSSL=false";
        String user = "root";
        String password = "12345";
        String res = "";
        try {
            Connection myConnection = DriverManager.getConnection(dbUrl, user, password);
            Statement myStatement = myConnection.createStatement();
            String sqlQuery = "select * from universitate;";
            ResultSet myResultSet = myStatement.executeQuery(sqlQuery);
            while(myResultSet.next()) {
                res += myResultSet.getString("id") + " " + myResultSet.getString("nume") + " " + myResultSet.getString("adresa") + "\n";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return res;
    }
}
