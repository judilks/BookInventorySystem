package serviceimpl;

import dao.BookDao;
import model.Book;
import service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    BookDao bookDao;

    public BookServiceImpl(BookDao bookDao){
        this.bookDao = bookDao;
    }

    @Override
    public boolean registerCopy(Book book) {
        boolean result = false;
        if(book==null)
            result = false;
        else{
            if(book.getId() != null && book.getTitle() != null){
                result = checkBooksForSameId(book);
                if(result)
                    result = bookDao.registerBook(book);
            }
        }
        return result;
    }

    private boolean checkBooksForSameId(Book book){
        boolean result = true;
        List<Book> books;
        books = bookDao.getBooks();
        if(books.size()>0){
            for (Book tempBook: books) {
                if(tempBook.getId().equals(book.getId()))
                    result = false;
            }
        }
        return result;
    }
}
