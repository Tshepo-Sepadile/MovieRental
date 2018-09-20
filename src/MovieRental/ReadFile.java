/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MovieRental;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Banele Mlamleli
 */
public class ReadFile {

    public ObjectInputStream objectInputStreamCustomer;
    public ObjectInputStream objectInputStreamMovies;
    public ObjectInputStream objectInputStreamRental;
    public FileInputStream fileInputStreamCustomer;
    public FileInputStream fileInputStreamMovies;
    public FileInputStream fileInputStreamRental;
    public Scanner scannerCustomer;
    public Scanner scannerMovies;
    public Scanner scannerRental;
    
    ArrayList<Customer> custArrayList = new ArrayList<>();
    ArrayList<DVD> dvdArrayList = new ArrayList<>();
    ArrayList<Rental> rentalArrayList = new ArrayList<>();

    //Opening files for reading
    public void openFile() {
        try {
            //Customer data
            fileInputStreamCustomer = new FileInputStream("/home/shaun/Documents/PROGRAMMING/Java/Projects/MovieRental/src/Assets/Customers.ser");
            objectInputStreamCustomer = new ObjectInputStream(fileInputStreamCustomer);
            scannerCustomer = new Scanner(objectInputStreamCustomer);
            
            //Movie data
            fileInputStreamMovies = new FileInputStream("/home/shaun/Documents/PROGRAMMING/Java/Projects/MovieRental/src/Assets/Movies.ser/");
            objectInputStreamMovies = new ObjectInputStream(fileInputStreamMovies);
            scannerMovies = new Scanner(objectInputStreamMovies);
            
            //Rental data
            fileInputStreamRental = new FileInputStream("/home/shaun/Documents/PROGRAMMING/Java/Projects/MovieRental/src/Assets/rental.ser");
            objectInputStreamRental = new ObjectInputStream(fileInputStreamRental);
            scannerRental = new Scanner(objectInputStreamRental);
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
    }
    
    public static void main(String[]args){
        ReadFile rf = new ReadFile();
    }
}