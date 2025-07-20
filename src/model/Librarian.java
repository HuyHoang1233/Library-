package model;

import java.io.Serializable;

public class Librarian extends User implements Serializable {
    public Librarian(String username, String password) {
        super(username, password);
    }

    @Override
    public void showMenu() {
        System.out.println("=== Librarian Menu ===");
        System.out.println("1. Add new book");
        System.out.println("2. View all books");
        System.out.println("3. Manage readers");
        System.out.println("0. Exit");
    }

    @Override
    public String toString() {
        return "Librarian [username=" + username + ", password=" + password + "]";
    }
}
