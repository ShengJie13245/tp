package bookkeeper;

import java.util.ArrayList;

public class BookList {
    private final ArrayList<Book> bookList;
    private final String listName;

    public BookList(String listName) {
        this.listName = listName;
        this.bookList = new ArrayList<Book>();
    }

    public String getListName() {
        return listName;
    }

    public ArrayList<Book> getBookList() {
        return bookList;
    }

    public void addBook(Book book) {
        bookList.add(book);
    }

    public Book findBookByTitle(String title) {
        for (Book book : bookList) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    public ArrayList<Book> findBooksByKeyword(String keyword){
        ArrayList<Book> filteredBookList = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getTitle().contains(keyword)) {
                filteredBookList.add(book);
            }
        }
        return filteredBookList;
    }

    public ArrayList<Book> findBooksByCategory(String category){
        ArrayList<Book> filteredBookList = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getCategory().equalsIgnoreCase(category)) {
                filteredBookList.add(book);
            }
        }
        return filteredBookList;
    }

    public void removeBook(Book book) {
        bookList.remove(book);
    }

    /**
     * Prints all books in the bookList.
     * First prints the book title, followed by the remaining attributes indented.
     */
    public void viewBookList() {

        if (bookList.isEmpty()) {
            Formatter.printBorderedMessage("Book List Empty!");
            return;
        }

        Formatter.printBookList(bookList);
    }
}
