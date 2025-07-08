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
public class MailService {
     public static void sendEBook(EBook book, String email) {
        System.out.println("--- Mail Service ---");
        System.out.println("  Sending EBook '" + book.getTitle() + "' (" + book.getFileType() + ") to email: " + email);
        System.out.println("  (Email sent successfully)");
        System.out.println("--------------------");
    }
}
