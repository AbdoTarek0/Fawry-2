/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fawry2;
import java.time.Year;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
/**
 *
 * @author ZaRZoR
 */
public class Bookstore {
     private final Map<String, Book> inventory; 
     
    public Bookstore() {
        this.inventory = new HashMap<>();
    }

    public void addBook(Book book) {
        Objects.requireNonNull(book, "Book cannot be null.");
        if (inventory.containsKey(book.getISBN())) {
            throw new IllegalArgumentException("Book with ISBN " + book.getISBN() + " already exists in inventory.");
        }
        inventory.put(book.getISBN(), book);
        System.out.println("Added to inventory: " + book.getTitle() + " (ISBN: " + book.getISBN() + ")");
    }

    public List<Book> removeOutdatedBooks(int years) {
        if (years < 0) {
            throw new IllegalArgumentException("Years threshold cannot be negative.");
        }
        List<Book> removedBooks = new ArrayList<>();
        int currentYear = Year.now().getValue();

        for (String isbn : new ArrayList<>(inventory.keySet())) {
            Book book = inventory.get(isbn);
            if (book != null && (currentYear - book.getPublishedYear()) >= years) {
                removedBooks.add(inventory.remove(isbn));
                System.out.println("Removed outdated book: " + book.getTitle() + " (Published: " + book.getPublishedYear() + ")");
            }
        }
        return removedBooks;
    }


    public double buyBook(String isbn, int quantity, String email, String address) {
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new IllegalArgumentException("ISBN cannot be empty for purchase.");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive for purchase.");
        }

        Book bookToBuy = inventory.get(isbn);
        if (bookToBuy == null) {
            throw new RuntimeException("Error: Book with ISBN " + isbn + " not found in inventory.");
        }

        if (!bookToBuy.isForSale()) {
            throw new RuntimeException("Error: '" + bookToBuy.getTitle() + "' is not for sale.");
        }

        double paidAmount = bookToBuy.purchase(quantity, email, address);
        System.out.println("Successfully purchased " + quantity + "x " + bookToBuy.getTitle() + ". Total paid: $" + String.format("%.2f", paidAmount));
        return paidAmount;
    }

    public void displayAllBooks() {
        if (inventory.isEmpty()) {
            System.out.println("Bookstore inventory is currently empty.");
            return;
        }
        System.out.println("\n--- Current Bookstore Inventory (" + inventory.size() + " books) ---");
        inventory.values().forEach(book -> {
            book.displayDetails();
            System.out.println("--------------------");
        });
        System.out.println("--- End of Inventory ---\n");
    }
}
