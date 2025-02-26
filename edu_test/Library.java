package edu_test;
public class Library {
    private Book[] books;
    private Member[] members;
    private int bookCount;
    private int memberCount;

    public Library(int maxBooks, int maxMembers) {
        books = new Book[maxBooks];
        members = new Member[maxMembers];
        bookCount = 0;
        memberCount = 0;
    }

    public void addBook(Book book) {
        if (bookCount < books.length) {
            books[bookCount++] = book;
        } else {
            System.out.println("Library is full. Cannot add more books.");
        }
    }

    public void addMember(Member member) {
        if (memberCount < members.length) {
            members[memberCount++] = member;
        } else {
            System.out.println("Library is full. Cannot add more members.");
        }
    }

    public void borrowBook(String isbn, Member member) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getIsbn().equals(isbn) && books[i].isAvailable()) {
                books[i].setAvailable(false);
                System.out.println(member.getName() + " borrowed " + books[i].getTitle());
                return;
            }
        }
        System.out.println("Book not available.");
    }

    public void returnBook(String isbn, Member member) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getIsbn().equals(isbn) && !books[i].isAvailable()) {
                books[i].setAvailable(true);
                System.out.println(member.getName() + " returned " + books[i].getTitle());
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public Member findMemberById(String memberId) {
        for (int i = 0; i < memberCount; i++) {
            if (members[i].getMemberId().equals(memberId)) {
                return members[i];
            }
        }
        return null;
    }

    public int getBookCount() {
        return bookCount;
    }

    public int getMemberCount() {
        return memberCount;
    }
}

