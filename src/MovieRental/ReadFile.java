/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MovieRental;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Banele Mlamleli
 */
public class ReadFile{

    public ObjectInputStream objectInputStreamCustomer;
    public ObjectInputStream objectInputStreamMovies;
    public ObjectInputStream objectInputStreamRental;
    public FileInputStream fileInputStreamCustomer;
    public FileInputStream fileInputStreamMovies;
    public FileInputStream fileInputStreamRental;
    public Scanner scannerCustomer;
    public Scanner scannerMovies;
    public Scanner scannerRental;
    Customer customer;
    Rental rental;
    DVD dvd;
    
    ArrayList<Customer> custArrayList = new ArrayList<>();
    ArrayList<DVD> dvdArrayList = new ArrayList<>();
    ArrayList<Rental> rentalArrayList = new ArrayList<>();

    //Opening files for reading
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
            fileInputStreamRental = new FileInputStream("/home/shaun/Documents/PROGRAMMING/Java/Projects/MovieRental/src/Assets/Rental.ser");
            objectInputStreamRental = new ObjectInputStream(fileInputStreamRental);
            
            //scannerRental = new Scanner(objectInputStreamRental);
            System.out.println("Files successfully read!");
        } catch (IOException error) {
            JOptionPane.showMessageDialog(null, error.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
        }
    }

    //Closing the files after being opened
    public void closeFile() {
        try {
            fileInputStreamCustomer.close();
            fileInputStreamMovies.close();
            fileInputStreamRental.close();
            objectInputStreamCustomer.close();
            objectInputStreamMovies.close();
            objectInputStreamRental.close();
            scannerCustomer.close();
            scannerMovies.close();
            scannerRental.close();
            System.out.println("Files closed!");
        } catch (IOException error) {
            JOptionPane.showMessageDialog(null, error.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //read data into array lists
    public void readData(){
        try{
            while(true){
                //customer = (Customer) objectInputStreamCustomer.readObject();
                //dvd = (DVD) objectInputStreamMovies.readObject();
                rental = (Rental) objectInputStreamRental.readObject();
                System.out.println(rental.toString());
            }
        }catch(EOFException eofe){
            System.out.println(eofe.fillInStackTrace());
        } catch (ClassNotFoundException | IOException ex) {
            Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[]args) throws IOException{
        ReadFile rf = new ReadFile();
        rf.openFile();
        rf.readData();
        rf.closeFile();
    }
}