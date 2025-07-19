/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.util.Scanner;
import model.Book;

public class LibraryView {
    private final Scanner sc = new Scanner(System.in);

    public void showMainMenu() {
        System.out.println("\n===== LIBRARY MENU =====");
        System.out.println("1. Add new book");
        System.out.println("2. View all books");
        System.out.println("0. Exit");
        System.out.print("Your choice: ");
    }

    public int getChoice() {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public Book inputBook() {
        Book b = new Book();
        System.out.print("Enter book ID: ");
        b.setIdBook(sc.nextLine());

        System.out.print("Enter book name: ");
        b.setNameBook(sc.nextLine());

        System.out.print("Enter price: ");
        b.setPrice(Integer.parseInt(sc.nextLine()));

        System.out.print("Enter type: ");
        b.setType(sc.nextLine());

        System.out.print("Enter author: ");
        b.setAuthor(sc.nextLine());

        System.out.print("Enter publisher: ");
        b.setPublisher(sc.nextLine());

        return b;
    }
}

