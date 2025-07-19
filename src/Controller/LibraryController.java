package Controller;

import View.LibraryView;
import java.util.*;
import model.*;

public class LibraryController {
    private LibraryView view = new LibraryView();
    private List<Book> books = new ArrayList<>();

    public void run() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            view.showMainMenu();
            int choice = view.getChoice();
            switch (choice) {
                case 1 -> addBook();
                case 2 -> viewBooks();
                case 0 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private void addBook() {
        Book b = view.inputBook();
        books.add(b);
        System.out.println("Book added successfully!");
    }

    private void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the system.");
        } else {
            System.out.println("Danh sach hien co:");
            for (Book b : books) {
                System.out.println(b);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("===== LIBRARY MANAGEMENT SYSTEM =====");
        LibraryController controller = new LibraryController();
        controller.run();
    }
}
