// program to  use add , replace ,search, display,exit books
import java.util.Scanner;
public class Book {
        private int bookID;
        private String title;
        private String author;
        private boolean isAvailable;

        // Constructor to initialize book attributes
        public Book(int bookID, String title, String author, boolean isAvailable) {
            this.bookID = bookID;
            this.title = title;
            this.author = author;
            this.isAvailable = isAvailable;
        }

        // Getters and setters for book attributes
        public int getBookID() {
            return bookID;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public boolean isAvailable() {
            return isAvailable;
        }

        public void setAvailable(boolean isAvailable) {
            this.isAvailable = isAvailable;
        }

        // Method to display book details
        public void displayBook() {
            System.out.println("Book ID: " + bookID);
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
            System.out.println();
        }
    }

    // Library class
    class Library {
        private Book[] books;
        private int bookCount;

        // Constructor to initialize the library with a fixed size
        public Library() {
            this.books = new Book[5];
            this.bookCount = 0;
        }

        // Method to add a book to the library
        public void addBook(Book book) {
            if (bookCount < books.length) {
                books[bookCount] = book;
                bookCount++;
                System.out.println("Book added successfully.");
            } else {
                System.out.println("Library is full. Cannot add more books.");
            }
        }

        // Method to replace book details by bookID
        public void replaceBook(int bookID, String newTitle, String newAuthor) {
            for (int i = 0; i < bookCount; i++) {
                if (books[i].getBookID() == bookID) {
                    books[i].setTitle(newTitle);
                    books[i].setAuthor(newAuthor);
                    System.out.println("Book details updated.");
                    return;
                }
            }
            System.out.println("Book with ID " + bookID + " not found.");
        }

        // Method to search for a book by ID
        public void searchBook(int bookID) {
            for (int i = 0; i < bookCount; i++) {
                if (books[i].getBookID() == bookID) {
                    books[i].displayBook();
                    return;
                }
            }
            System.out.println("Book with ID " + bookID + " not found.");
        }

        // Method to display all books in the library
        public void displayBooks() {
            if (bookCount == 0) {
                System.out.println("No books in the library.");
            } else {
                for (int i = 0; i < bookCount; i++) {
                    books[i].displayBook();
                }
            }
        }
    }

    // Main class to manage the library system
    class BookManagementSystem {
        public static void main(String[] args) {
            Library library = new Library();
            Scanner obj = new Scanner(System.in);
            int choice;

            do {
                System.out.println("\nLibrary Management System");
                System.out.println("1. Add Book");
                System.out.println("2. Replace Book");
                System.out.println("3. Search Book by ID");
                System.out.println("4. Display All Books");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = obj.nextInt();

                switch (choice) {
                    case 1:
                        // Add a new book
                        System.out.print("Enter Book ID: ");
                        int id = obj.nextInt();
                        obj.nextLine(); // Consume newline
                        System.out.print("Enter Book Title: ");
                        String title = obj.nextLine();
                        System.out.print("Enter Book Author: ");
                        String author = obj.nextLine();
                        Book newBook = new Book(id, title, author, true);
                        library.addBook(newBook);
                        break;

                    case 2:
                        // Replace book details
                        System.out.print("Enter Book ID to replace: ");
                        int bookID = obj.nextInt();
                        obj.nextLine(); // Consume newline
                        System.out.print("Enter new Title: ");
                        String newTitle = obj.nextLine();
                        System.out.print("Enter new Author: ");
                        String newAuthor = obj.nextLine();
                        library.replaceBook(bookID, newTitle, newAuthor);
                        break;

                    case 3:
                        // Search for a book by ID
                        System.out.print("Enter Book ID to search: ");
                        int searchID = obj.nextInt();
                        library.searchBook(searchID);
                        break;

                    case 4:
                        // Display all books
                        library.displayBooks();
                        break;

                    case 5:
                        // Exit the program
                        System.out.println("Exiting Library Management System.");
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 5);
        }
    }

