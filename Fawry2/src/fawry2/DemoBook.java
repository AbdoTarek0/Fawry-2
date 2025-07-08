/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fawry2;

/**
 *
 * @author ZaRZoR
 */
public class DemoBook extends Book {
    public DemoBook(String isbn, String title, int publishedYear) {
        super(isbn, title, publishedYear, 0.0);
    }

    @Override
    public boolean isForSale() {
        return false; 
    }

    @Override
    public double purchase(int quantity, String email, String address) {
        throw new RuntimeException("Error: " + getTitle() + " is a demo book and not available for purchase.");
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("  Type: Demo Book (NOT FOR SALE)");
    }
}
