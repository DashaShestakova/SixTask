import com.epam.idea.task.six.data.BookCreator;
import com.epam.idea.task.six.model.Book;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class BookCreatorTest {

    public static final List<Book> EXPECTED_BOOKlIST = Arrays.asList(
            new Book("Crime and Punishment", "Fyodor Dostoevsky", 1866, 672, "Russian"),
            new Book("The Count of Monte Cristo", "Alexander Duma", 1844, 1350, "French"),
            new Book("The Call of the Wild", "Jack London", 1903, 232,  "English"));
    public static final String STRING_OF_BOOKS = "Crime and Punishment, Fyodor Dostoevsky, 1866, 672, Russian\n" +
            "The Count of Monte Cristo, Alexander Duma, 1844, 1350, French\n" +
            "The Call of the Wild, Jack London, 1903, 232, English";

    public static final Book EXPECTED_BOOK = new Book("Crime and Punishment", "Fyodor Dostoevsky", 1866, 672, "Russian");
    public static final String STRING_OF_BOOK = "Crime and Punishment, Fyodor Dostoevsky, 1866, 672, Russian";

    @Test
    public void testCreateBookShouldCreateObjectBookFromString(){
        BookCreator bookCreator = new BookCreator();

        List<Book> createdBookList = bookCreator.createBookList(STRING_OF_BOOKS);

        Assert.assertEquals(createdBookList, EXPECTED_BOOKlIST);
    }

    @Test
    public void testCreateBookListShouldCreateListOfBookObjectsFromString(){
        BookCreator bookCreator = new BookCreator();

        Book createdBook = bookCreator.createBook(STRING_OF_BOOK);

        Assert.assertEquals(createdBook, EXPECTED_BOOK);
    }
}
