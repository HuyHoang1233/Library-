package Controller;

import View.LibraryView;
import java.util.*;
import model.*;

public class LibraryController {
    private LibraryView view = new LibraryView();
    private List<Book> books = new ArrayList<>();
    private List<Borrow> borrows = new ArrayListArrayList<>();
    private List<Reader> readerlist = new ArrayList<>();


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
                case 0 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
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

    public LibraryController() {
        loadAuthors(); // load từ file
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


}private void addBook() {
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
