package Controller;

import View.LibraryView;
import java.util.*;
import model.*;


public class LibraryController {
    
    private LibraryView view = new LibraryView();
    private List<Book> books = new ArrayList<>();
    private List<Borrow> borrows = new ArrayList<>();
    private List<Reader> readerList = new ArrayList<>();
    private List<Publisher> publisherList = new ArrayList<>();
    private List<Librarian> librarianList = new ArrayList<>();

    public void run() {
        Scanner sc = new Scanner(System.in);
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
                case 9 -> view.inputPublisher();
                case 10 -> view.viewAllPublishers(); 
                case 11 -> inputLibrarian(sc);
                case 12 -> viewAllLibrarians();
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
    private void viewBorrows() {
        view.displayBorrows(borrows);
    }
  
    private void addBorrow() {
        Borrow b = view.inputBorrow(); 
     borrows.add(b);  
        System.out.println("Borrow record added!");
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
    private void viewReader() {
    if (readerList.isEmpty()) {
        System.out.println("No readers found.");
    } else {
        for (Reader r : readerList) {
            System.out.println(r);
        }
    }
}
    private void addReader() {
    Reader reader = view.inputReader();
    readerList.add(reader);
    FileUtils.writeToFile("readers.dat", readerList); // Ghi lại file
}
    
    public static void main(String[] args) {
        System.out.println("===== LIBRARY MANAGEMENT SYSTEM =====");
        LibraryController controller = new LibraryController();
        controller.run();
    }
    
    
    private List<Author> authorList;
    
    
        private void loadLibrarians() {
                Object data = FileUtils.readFromFile("librarians.dat");
        if (data != null && data instanceof List<?>) {
            librarianList = (List<Librarian>) data;
        } else {
            librarianList = new ArrayList<>();
        }
    }

private void saveLibrarians() {
    FileUtils.writeToFile("librarians.dat", librarianList);
}

public void inputLibrarian(Scanner sc) {
    try {
        System.out.print("Enter ID: "); String id = sc.nextLine().trim();
        System.out.print("Enter Name: "); String name = sc.nextLine().trim();
        System.out.print("Enter Email: "); String email = sc.nextLine().trim();
        System.out.print("Enter Username: "); String username = sc.nextLine().trim();
        System.out.print("Enter Password: "); String password = sc.nextLine().trim();
        System.out.print("Enter Role: "); String role = sc.nextLine().trim();

        Librarian librarian = view.inputLibrarian();
        for (Librarian l : librarianList) {
            if (l.getId().equalsIgnoreCase(librarian.getId())) {
                System.out.println("❌ Duplicate ID. Librarian not added.");
                return;
            }
        }
        
        librarianList.add(librarian);
        saveLibrarians();
        System.out.println(" Added librarian.");
    } catch (IllegalArgumentException e) {
        System.out.println(" Invalid input: " + e.getMessage());
        FileUtils.writeToFile("librarians.dat", librarianList);

    }
}
private void loadReaders() {
    Object data = FileUtils.readFromFile("readers.dat");
    if (data != null && data instanceof List<?>) {
        readerList = (List<Reader>) data;
    } else {
        readerList = new ArrayList<>();
    }
}


public void viewAllLibrarians() {
    if (librarianList == null || librarianList.isEmpty()) {
        System.out.println("️ No librarians found.");
        return;
    }
    System.out.println(" Librarians List:");
    for (Librarian l : librarianList) {
        System.out.println(l);
    }
}

    public LibraryController() {
        loadAuthors(); // load từ file
        loadPublishers();//them
        loadLibrarians();//them
        loadReaders(); // them

    }

    public void loadAuthors() {
    Object data = FileUtils.readFromFile("authors.dat");
    if (data != null && data instanceof List<?>) {
        authorList = (List<Author>) data;
    } else {
        authorList = new ArrayList<>();
    }
}

    public void saveAuthors() {
        FileUtils.writeToFile("authors.dat", authorList);
    }

    public void addAuthor(Author author) {
        if (!authorList.contains(author)) {
            authorList.add(author);
            saveAuthors(); // Ghi file ngay sau khi thêm
        }
    }

    public List<Author> getAuthorList() {
        return authorList;
    }
    public void addAuthor() {
    Author author = view.inputAuthor();
    authorList.add(author);
    FileUtils.writeToFile("authors.dat", authorList);
    System.out.println("Author added successfully!");
}

public void viewAuthor() {
    if (authorList.isEmpty()) {
        System.out.println("No authors available.");
        return;
    }
    System.out.println("--- Author List ---");
    for (Author author : authorList) {
        System.out.println(author);
    }
}
public void loadPublishers() {
    Object data = FileUtils.readFromFile("publishers.dat"); // ✅ ĐÃ SỬA Ở ĐÂY
    if (data != null && data instanceof List<?>) {          // ✅ ĐÃ SỬA Ở ĐÂY
        publisherList = (List<Publisher>) data;             // ✅ ĐÃ SỬA Ở ĐÂY
    } else {
        System.out.println("File not found or invalid. Returning empty list.");
        publisherList = new ArrayList<>();
    }
}

public void savePublishers() {
    FileUtils.writeToFile("publishers.dat", publisherList);
}

public void addPublisher(Publisher p) {
    publisherList.add(p);
    savePublishers();
}

public List<Publisher> getAllPublishers() {
    return publisherList;
}

}
