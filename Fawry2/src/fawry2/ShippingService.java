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
public class ShippingService {
    public static void shipBook(PaperBook book, String address) {
        System.out.println("--- Shipping Service ---");
        System.out.println("  Shipping " + book.getTitle() + " (ISBN: " + book.getISBN() + ") to address: " + address);
        System.out.println("  (Shipment initiated)");
        System.out.println("------------------------");
    }
}
