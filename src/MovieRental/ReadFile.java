/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MovieRental;

import java.io.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.JOptionPane;

/**
 * @author Tshepo Sepadile
 * @author Banele Mlamleli
 */
public class ReadFile{

    private ObjectInputStream objectInputStreamCustomer;
    private ObjectInputStream objectInputStreamMovies;
    private ObjectInputStream objectInputStreamRental;
    
    private ObjectOutputStream objOutputStreamCustomer;
    private ObjectOutputStream objOutputStreamMovies;
    private ObjectOutputStream objOutputStreamRental;
    
    private FileOutputStream fileOutputStreamCustomers;
    private FileOutputStream fileOutputStreamMovies;
    private FileOutputStream fileOutputStreamRental;
    
    private FileInputStream fileInputStreamCustomer;
    private FileInputStream fileInputStreamMovies;
    private FileInputStream fileInputStreamRental;
    
    Customer customer;
    Rental rental;
    DVD dvd;
    
    //Arraylist to populate with data from the serialized object file
    public static ArrayList<Customer> customerArraylist = new ArrayList<>();
    public static ArrayList<DVD> dvdArraylist = new ArrayList<>();
    public static ArrayList<Rental> rentalArraylist = new ArrayList<>();
    
    //Opening serialized files for reading
    public void openFile() {
        try {
            //Customer data
            fileInputStreamCustomer = new FileInputStream("/home/shaun/Documents/PROGRAMMING/Java/Projects/MovieRental/src/Assets/Customers.ser");
            objectInputStreamCustomer = new ObjectInputStream(fileInputStreamCustomer);
            //scannerCustomer = new Scanner(objectInputStreamCustomer);
            
            //Movie data
            fileInputStreamMovies = new FileInputStream("/home/shaun/Documents/PROGRAMMING/Java/Projects/MovieRental/src/Assets/Movies.ser/");
            objectInputStreamMovies = new ObjectInputStream(fileInputStreamMovies);
            //scannerMovies = new Scanner(objectInputStreamMovies);
            
            //Rental data
            //fileInputStreamRental = new FileInputStream("/home/shaun/Documents/PROGRAMMING/Java/Projects/MovieRental/src/Assets/Rental.ser");
            //objectInputStreamRental = new ObjectInputStream(fileInputStreamRental);
            
        } catch (IOException error) {
            JOptionPane.showMessageDialog(null, error.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
        }
    }

    //Closing the files after being opened
    public void closeFile() {
        try {
            fileInputStreamCustomer.close();
            objectInputStreamCustomer.close();
            objectInputStreamMovies.close();
            fileInputStreamMovies.close();
            //fileInputStreamRental.close();            
            //objectInputStreamRental.close();
        } catch (IOException error) {
            JOptionPane.showMessageDialog(null, error.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //read data into array lists
    public void readCustomerSerializedData(){
        openFile();
        try{
            //reading data from Customer.ser file
            while(true){
                customer = (Customer) objectInputStreamCustomer.readObject();
                customerArraylist.add(customer);
            }
        }catch(EOFException eofe){
            System.out.println("customer end-of-file reached");
        } catch (ClassNotFoundException | IOException ex) {
            Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeFile();
    }
    
    //read data into Dvd array lists
    public void readDvdSerializedData(){
        openFile();
        try{
            //reading data from Movies.ser file
            while(true){
                dvd = (DVD) objectInputStreamMovies.readObject();
                dvdArraylist.add(dvd);
            }
        }catch(EOFException eofe){
            System.out.println("Dvd end-of-file reached");
        } catch (ClassNotFoundException | IOException ex) {
            Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeFile();
    }
    
        //read data into array lists
    public void readRentalSerializedData(){
        openFile();
        try{
            //reading data from Rental.ser file
            while(true){
                rental = (Rental) objectInputStreamRental.readObject();
                rentalArraylist.add(rental);
            }
        }catch(EOFException eofe){
            System.out.println("Rental end-of-file reached");
        } catch (ClassNotFoundException | IOException ex) {
            Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeFile();
    }
}