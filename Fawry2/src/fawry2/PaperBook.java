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
public class PaperBook extends Book {
     private int stock; 

    public PaperBook(String isbn, String title, int publishedYear, double price, int stock) {
        super(isbn, title, publishedYear, price);
        if (stock < 0) {
            throw new IllegalArgumentException("Stock cannot be negative.");
        }
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    @Override
    public boolean isForSale() {
        return true;
    }

    @Override
    public double purchase(int quantity, String email, String address) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive for purchase.");
        }
        if (stock < quantity) {
            throw new RuntimeException("Error: Not enough stock for " + getTitle() + ". Available: " + stock + ", Requested: " + quantity + "."); 
        }

        stock -= quantity;  
        System.out.println("Purchased " + quantity + "x Paper Book: " + getTitle() + ". Remaining stock: " + stock);
        
        ShippingService.shipBook(this, address);

        return getPrice() * quantity;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("  Type: Paper Book");
        System.out.println("  Stock: " + stock);
    }
}
