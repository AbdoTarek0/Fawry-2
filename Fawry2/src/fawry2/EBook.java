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
public class EBook extends Book {
    private final String fileType;

    public EBook(String isbn, String title, int publishedYear, double price, String fileType) {
        super(isbn, title, publishedYear, price);
        if (fileType == null || fileType.trim().isEmpty()) {
            throw new IllegalArgumentException("File type cannot be empty for an EBook.");
        }
        this.fileType = fileType;
    }

    public String getFileType() {
        return fileType;
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
        System.out.println("Purchased " + quantity + "x EBook: " + getTitle() + " (File Type: " + fileType + ").");
        
        MailService.sendEBook(this, email);

        return getPrice() * quantity;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("  Type: EBook");
        System.out.println("  File Type: " + fileType);
    }
}
