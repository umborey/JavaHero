package com.piseth.java.school.service;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	public Connection DbConnect() {
		String url = "jdbc:postgresql://localhost/village";
        String driver = "org.postgresql.Driver";
        String user = "village_adm";
        String pass = "village123";
        try{
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, user, pass);
            if(conn == null){
                System.out.println("Connection is not established");
            }
            return conn;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return null;
	}
}
