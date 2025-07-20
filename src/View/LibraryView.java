/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import model.*;
import java.util.Scanner;
import model.Book;
import model.Reader;

public class LibraryView {
    private final Scanner sc = new Scanner(System.in);

    public void showMainMenu() {
        System.out.println("\n===== LIBRARY MENU =====");
        System.out.println("1. Add new book");
        System.out.println("2. View all books");
        System.out.println("3. Add borrow record "); //them
        System.out.println("4. View all borrows "); //them
        System.out.println("5. Add new author");        // <== thêm dòng này
        System.out.println("6. View all authors");      // <== thêm dòng này
        System.out.println("7. Add new reader"); //them
        System.out.println("8. View all readers");//them
        System.out.println("0. Exit");
        System.out.print("Your choice: ");
    }
public void displayBorrows(List<Borrow> borrows) {
    if (borrows.isEmpty()) {
        System.out.println("No borrow records found.");
    } else {
        System.out.println("--- Borrow List ---");
        for (Borrow b : borrows) {
            System.out.println(b);
        }
    }
}
    public int getChoice() {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    public void displayReaders(List<Reader> readers) {
    if (readers.isEmpty()) {
        System.out.println("No readers found.");
    } else {
        System.out.println("--- Reader List ---");
        for (Reader r : readers) {
            System.out.println(r);
        }
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
    public Borrow inputBorrow() {
    System.out.print("Enter Borrow ID: ");
    String idBorrow = sc.nextLine();

    System.out.print("Enter Reader ID: ");
    String idReader = sc.nextLine();

    System.out.print("Enter Book ID: ");
    String idBook = sc.nextLine();
    
    System.out.println("Enter Reader ID:"); {
}

    Date lendDate = new Date(); // ngày mượn hiện tại
    Calendar cal = Calendar.getInstance();
    cal.setTime(lendDate);
    cal.add(Calendar.DAY_OF_MONTH, 7); // cộng 7 ngày làm ngày trả
    Date dueDate = cal.getTime();

    String overtime = "No";

    // Giả sử bạn đã có constructor Borrow(String idReader, String idBook, Date lendDate, Date dueDate, String overtime)
    return new Borrow(idReader, idBook, lendDate, dueDate, overtime);
    
}
    
    
    public Author inputAuthor() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter author name: ");
    String name = sc.nextLine();
    
    System.out.print("Enter workplace: ");
    String workplace = sc.nextLine();
    
    Author author = new Author();
    author.setName(name);
    author.setWorkplace(workplace);
    
    return author;
}
    
    public Reader inputReader() {
    System.out.print("Enter Reader ID: ");
    String idReader = sc.nextLine();
    System.out.print("Enter Username: ");
    String username = sc.nextLine();
    System.out.print("Enter Password: ");
    String password = sc.nextLine();
    System.out.print("Enter Reader Type: ");
    String type = sc.nextLine();
    System.out.print("Enter Sex: ");
    String sex = sc.nextLine();
    
    return new Reader(username, password, idReader, type, sex);
}
}

