/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fawry2;
import java.util.List;

/**
 *
 * @author ZaRZoR
 */
public class Fawry2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       System.out.println("--- Welcome to Quantum Bookstore Test Suite ---");
        Bookstore quantumBookstore = new Bookstore();

        System.out.println("\n--- Adding Books to Inventory ---");
        try {
            quantumBookstore.addBook(new PaperBook("978-0321765723", "Effective Java", 2018, 45.00, 10));
            quantumBookstore.addBook(new EBook("978-1234567890", "The AI Revolution", 2023, 29.99, "PDF"));
            quantumBookstore.addBook(new DemoBook("DEMO-001", "Sample Preview", 2020));
            quantumBookstore.addBook(new PaperBook("978-0134685994", "Clean Code", 2008, 38.50, 5));
            quantumBookstore.addBook(new EBook("978-9876543210", "Quantum Computing Basics", 2024, 55.00, "EPUB"));
            quantumBookstore.addBook(new PaperBook("978-0596007019", "Head First Java", 2005, 30.00, 1));
            quantumBookstore.addBook(new PaperBook("978-0486284714", "Flatland", 1884, 12.00, 3));
            System.out.println("Initial inventory setup complete.");
        } catch (IllegalArgumentException e) {
            System.err.println("Error adding book: " + e.getMessage());
        }

        quantumBookstore.displayAllBooks();

        System.out.println("\n--- Testing Book Purchases ---");

        try {
            System.out.println("\nAttempting to buy 2x 'Effective Java' (Paper Book)...");
            double paid = quantumBookstore.buyBook("978-0321765723", 2, "customer@example.com", "123 Main St, Anytown");
            System.out.println("Purchase successful! Total paid: $" + String.format("%.2f", paid));
        } catch (RuntimeException e) {
            System.err.println("Purchase failed: " + e.getMessage());
        }

        try {
            System.out.println("\nAttempting to buy 1x 'The AI Revolution' (EBook)...");
            double paid = quantumBookstore.buyBook("978-1234567890", 1, "digitalbuyer@email.com", "N/A");
            System.out.println("Purchase successful! Paid: $" + String.format("%.2f", paid));
        } catch (RuntimeException e) {
            System.err.println("Purchase failed: " + e.getMessage());
        }

        try {
            System.out.println("\nAttempting to buy 1x 'Sample Preview' (Demo Book)...");
            quantumBookstore.buyBook("DEMO-001", 1, "demo@example.com", "N/A");
        } catch (RuntimeException e) {
            System.err.println("Purchase failed as expected: " + e.getMessage());
        }

        try {
            System.out.println("\nAttempting to buy 2x 'Head First Java' (Paper Book) - only 1 in stock...");
            quantumBookstore.buyBook("978-0596007019", 2, "stockcheck@example.com", "456 Oak Ave");
        } catch (RuntimeException e) {
            System.err.println("Purchase failed as expected: " + e.getMessage());
        }

        try {
            System.out.println("\nAttempting to buy a non-existent book...");
            quantumBookstore.buyBook("NON-EXISTENT-ISBN", 1, "noone@example.com", "789 Pine Ln");
        } catch (RuntimeException e) {
            System.err.println("Purchase failed as expected: " + e.getMessage());
        }

        quantumBookstore.displayAllBooks();

        System.out.println("\n--- Testing Removal of Outdated Books ---");
        List<Book> removedBooksList = quantumBookstore.removeOutdatedBooks(10);
        System.out.println("\nSuccessfully removed " + removedBooksList.size() + " outdated book(s).");
        removedBooksList.forEach(book -> System.out.println("  Removed: " + book.getTitle() + " (Published: " + book.getPublishedYear() + ")"));

        quantumBookstore.displayAllBooks();

        System.out.println("\n--- Quantum Bookstore Test Suite Concluded ---");
    }
    
}
