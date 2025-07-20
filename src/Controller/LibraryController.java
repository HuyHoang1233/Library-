package Controller;

import View.LibraryView;
import model.*;

import java.util.*;

public class LibraryController {
    private final LibraryView view = new LibraryView();

    private final List<Book> books = new ArrayList<>();
    private final List<Borrow> borrows = new ArrayList<>();
   private final List<model.Reader> readerList = new ArrayList<>();

    private List<Author> authorList;

    public LibraryController() {
        loadAuthors(); // load authors from file
    }

    // ======================== MAIN ========================
    public static void main(String[] args) {
        System.out.println("===== LIBRARY MANAGEMENT SYSTEM =====");
        LibraryController controller = new LibraryController();
        controller.run();
    }

    // ======================== MAIN MENU ========================
    public void run() {
        while (true) {
            view.showMainMenu();
            int choice = view.getChoice();
            switch (choice) {
                case 1 -> addBook();
                case 2 -> viewBooks();
                case 3 -> addBorrow();
                case 4 -> viewBorrows();
                case 5 -> addAuthor();
                case 6 -> viewAuthor();
                case 7 -> addReader();
                case 8 -> viewReader();
                case 0 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    // ======================== BOOK ========================
    private void addBook() {
        Book b = view.inputBook();
        books.add(b);
        System.out.println("Book added successfully!");
    }

    private void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the system.");
        } else {
            System.out.println("Danh sách sách hiện có:");
            for (Book b : books) {
                System.out.println(b);
            }
        }
    }

    // ======================== BORROW ========================
    private void addBorrow() {
        Borrow b = view.inputBorrow();
        borrows.add(b);
        System.out.println("Borrow record added!");
    }

    private void viewBorrows() {
        if (borrows.isEmpty()) {
            System.out.println("No borrow records.");
        } else {
            for (Borrow b : borrows) {
                System.out.println(b);
            }
        }
    }

    // ======================== READER ========================
    private void addReader() {
        model.Reader reader = view.inputReader();

        readerList.add(reader);
        FileUtils.writeToFile("readers.dat", readerList);
        System.out.println("Reader added successfully!");
    }

    private void viewReader() {
        if (readerList.isEmpty()) {
            System.out.println("No readers found.");
        } else {
           for (model.Reader r : readerList) {

                System.out.println(r);
            }
        }
    }

    // ======================== AUTHOR ========================
    private void loadAuthors() {
        Object data = FileUtils.readFromFile("authors.dat");
        if (data instanceof List<?>) {
            authorList = (List<Author>) data;
        } else {
            authorList = new ArrayList<>();
        }
    }

    private void saveAuthors() {
        FileUtils.writeToFile("authors.dat", authorList);
    }

    private void addAuthor() {
        Author author = view.inputAuthor();
        if (!authorList.contains(author)) {
            authorList.add(author);
            saveAuthors();
            System.out.println("Author added successfully!");
        } else {
            System.out.println("Author already exists.");
        }
    }

    private void viewAuthor() {
        if (authorList.isEmpty()) {
            System.out.println("No authors available.");
        } else {
            System.out.println("--- Author List ---");
            for (Author author : authorList) {
                System.out.println(author);
            }
        }
    }
}
