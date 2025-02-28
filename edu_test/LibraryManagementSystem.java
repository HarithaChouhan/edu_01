package edu_test;

import java.util.Scanner;

public class LibraryManagementSystem {
    private static Library library = new Library(100, 100); // Maximum of 100 books and 100 members
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeLibrary();
        int choice;

        do {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    addMember();
                    break;
                case 3:
                    borrowBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    private static void initializeLibrary() {
        library.addBook(new Book("1984", "George Orwell", "123456789"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "987654321"));
        library.addMember(new Member("Alice", "M001"));
        library.addMember(new Member("Bob", "M002"));
    }

    private static void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        System.out.print("Enter book ISBN: ");
        String isbn = scanner.nextLine();
        library.addBook(new Book(title, author, isbn));
        System.out.println("Book added successfully!");
    }

    private static void addMember() {
        System.out.print("Enter member name: ");
        String name = scanner.nextLine();
        System.out.print("Enter member ID: ");
        String memberId = scanner.nextLine();
        library.addMember(new Member(name, memberId));
        System.out.println("Member added successfully!");
    }

    private static void borrowBook() {
        System.out.print("Enter ISBN of the book to borrow: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter member ID: ");
        String memberId = scanner.nextLine();
        Member member = library.findMemberById(memberId);
        if (member != null) {
            library.borrowBook(isbn, member);
            System.out.println("Book borrowed successfully!");
        } else {
            System.out.println("Member not found.");
        }
    }

    private static void returnBook() {
        System.out.print("Enter ISBN of the book to return: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter member ID: ");
        String memberId = scanner.nextLine();
        Member member = library.findMemberById(memberId);
        if (member != null) {
            library.returnBook(isbn, member);
            System.out.println("Book returned successfully!");
        } else {
            System.out.println("Member not found.");
        }
    }
}
