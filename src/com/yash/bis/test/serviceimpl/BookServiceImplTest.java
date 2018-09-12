package serviceimpl;

import dao.BookDao;
import model.Book;
import org.junit.Test;
import org.mockito.Mockito;
import service.BookService;

import java.util.Arrays;

import static org.junit.Assert.*;

public class BookServiceImplTest {

    @Test
    public void testRegisterCopy_GivenNull_ReturnFail(){
        BookDao bookDao = Mockito.mock(BookDao.class);
        Book book = new Book("A long dark");
        Mockito.when(bookDao.registerBook(book)).thenReturn(true);
        BookService bookService = new BookServiceImpl(bookDao);
        boolean result = bookService.registerCopy(null);
        assertEquals(result, false);
    }

    @Test
    public void testRegisterCopy_GivenBook_ReturnSuccess(){
        BookDao bookDao = Mockito.mock(BookDao.class);
        Book book = new Book("A long dark");
        Mockito.when(bookDao.registerBook(book)).thenReturn(true);
        BookService bookService = new BookServiceImpl(bookDao);
        boolean result = bookService.registerCopy(book);
        assertEquals(result, true);
    }

    @Test
    public void testRegisterCopy_GivenBookWithSameTitle_ReturnSuccess(){
        BookDao bookDao = Mockito.mock(BookDao.class);
        Book book = new Book("A long dark");
        Book book2 = new Book("A long dark");
        Mockito.when(bookDao.registerBook(book)).thenReturn(true);
        Mockito.when(bookDao.getBooks()).thenReturn(Arrays.asList(book2));
        BookService bookService = new BookServiceImpl(bookDao);
        boolean result = bookService.registerCopy(book);
        assertEquals(result, true);
    }

    @Test
    public void testRegisterCopy_GivenIdenticalBooks_ReturnFail(){
        BookDao bookDao = Mockito.mock(BookDao.class);
        Book book = new Book("A long dark");
        Mockito.when(bookDao.registerBook(book)).thenReturn(true);
        Mockito.when(bookDao.getBooks()).thenReturn(Arrays.asList(book));
        BookService bookService = new BookServiceImpl(bookDao);
        boolean result = bookService.registerCopy(book);
        assertEquals(result, false);
    }

    @Test
    public void testRegisterCopy_GivenDifferentBooks_ReturnSuccess(){
        BookDao bookDao = Mockito.mock(BookDao.class);
        Book book = new Book("A long dark");
        Book book2 = new Book("The outsiders");
        Mockito.when(bookDao.registerBook(book)).thenReturn(true);
        Mockito.when(bookDao.getBooks()).thenReturn(Arrays.asList(book2));
        BookService bookService = new BookServiceImpl(bookDao);
        boolean result = bookService.registerCopy(book);
        assertEquals(result, true);
    }

}