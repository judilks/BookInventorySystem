package dao;

import model.Book;

import java.util.List;

public interface BookDao {
    boolean registerBook(Book book);

    List<Book> getBooks();
}
