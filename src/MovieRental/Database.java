package MovieRental;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tshepo95
 */
import java.sql.*;

public class Database {
    
    static Connection con;
    static Statement st;
    static PreparedStatement pst;
    static ResultSet rs;
    

    public static void main(String[] args) {
        
        Connect();
        createTables(con);
    }
    
          
    public static Connection Connect(){
    
    
    try{
            //Connecting to the database
            String dbURL = "jdbc:ucanaccess://C:/Users/Tshepo95/CPUT School Work/Applications Development Practice 2/Project 2/Database/theDB/Database.accdb";
            String username = "";
            String password = "";
            con = DriverManager.getConnection(dbURL, username, password);
            
            System.out.println("Successfully connected to database.");
            
        }
        
        catch(SQLException e){
            
            System.out.println(e);
            System.out.println("Unable to connect to database."); 
        }
    
    return con;
    }
    
    public static void createTables(Connection conn)
    {
        try
        {
            //Creating tables
            String create_table_cust = "create table CUSTOMER (custNumber INTEGER CONSTRAINT customer_custnum_pk PRIMARY KEY, firstName VARCHAR(30) CONSTRAINT customer_fName_nn NOT NULL, surname VARCHAR(30) CONSTRAINT customer_surname_nn NOT NULL, phoneNum VARCHAR(20) CONSTRAINT customer_phoneNum_uk UNIQUE, credit INTEGER)";
            System.out.println("Creating CUSTOMER table.");
            String create_table_dvd = "create table DVD(dvdNumber INTEGER CONSTRAINT dvd_dvdNum_pk PRIMARY KEY, title VARCHAR(30) CONSTRAINT dvd_title_uk UNIQUE, category VARCHAR(30) CONSTRAINT dvd_category_nn NOT NULL, price INTEGER)";
            System.out.println("Creating DVD table.");
            String create_table_rental = "create table RENTAL(rentalNumber INTEGER CONSTRAINT rental_rentalNum_pk PRIMARY KEY, dateRented DATE CONSTRAINT rental_drented_nn NOT NULL, dateReturned DATE CONSTRAINT rental_dreturned_nn NOT NULL, custNumber INTEGER CONSTRAINT rental_custNum_fk REFERENCES CUSTOMER(custNumber), dvdNumber INTEGER CONSTRAINT rental_dvdNum_fk REFERENCES DVD(dvdNumber), totalPenaltyCost INTEGER)";
            System.out.println("Creating RENTAL table.");
            st = con.createStatement();
            st.executeUpdate(create_table_cust);
            st.executeUpdate(create_table_dvd);
            st.executeUpdate(create_table_rental);
            
            System.out.println("The tables have been created.");
            
            st.close();
            con.close();
        }
        catch(SQLException e)
        {
            System.out.println("Couldn't create tables.");
            System.out.println(e);
        }
    }
    
    public static void insert()
    {
        String ins = "Insert INTO CUSTOMER(custNumber, firstName, surname, phoneNum, credit) VALUES(10005, 'Tshepo', 'Sepadile', '07887', 100)";
        try{
        pst = con.prepareStatement(ins);
        pst.executeUpdate();
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        
    }
    
   
}

