/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MovieRental;

import javax.swing.JOptionPane;

/**
 *
 * @author Shaun
 */
public class TestClass {
    public static void main(String[]args){
       int a = JOptionPane.showConfirmDialog(null, "Thank you for returning the movie\n"+
            "We hope you enjoyed it!!\n\n"+
            "Your current balance is R"+11.20+"\nWould you like to deposit money into your account?",
            "Movie returned", JOptionPane.YES_NO_CANCEL_OPTION);
        System.out.println(a);
//        String v = JOptionPane.showInputDialog(null, "Enter a, b or c: ");
//        char val = v.toLowerCase().charAt(0);
//        while((val != 'a') && (val != 'b') && (val != 'c')){
//            v = javax.swing.JOptionPane.showInputDialog(null, "ERROR\nPlese choose within the provided options\nEnter a, b or c: ");
//            val = v.toLowerCase().charAt(0);
//        }
//        
//        System.out.println(val);
    }    
}
