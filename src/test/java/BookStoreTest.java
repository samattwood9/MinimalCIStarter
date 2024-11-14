import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class BookStoreTest {

    private BookStore bookstore;

    @BeforeEach
    void setUp() {
        bookstore = new BookStore();
    }

    @Test
    void addBook_ValidBook_IsAdded() {
        // arrange
        Book book = new Book("STORM IN A TEACUP", 7.99);

        // act
        bookstore.addBook(book);

        // assert
        assertTrue(bookstore.getBooks().contains(book));
    }

    @Test
    void testAddAndFindBook_ValidBook_IsAddedAndFound() {
        // Create a new book
        String bookTitle = "Howl's Moving Castle";
        Book book = new Book(bookTitle, 10.99);

        // Add book to bookstore
        // TODO: You can make this test fail by adding a line or two here... Have a go at breaking it
        // (HINT) You don't need to make any additional assertions
        bookstore.addBook(book);

        // Find book in bookstore
        Book found = bookstore.findBook(bookTitle);

        // Confirm that the added book can be found
        assertNotNull(found, "The book should be found.");
        assertEquals(book, found, "The found book should be equivalent to the one that was added");
    }

    // TODO: Comment this in an raise a pull request, notice how the failing build is flagged before merging the changes in
    /* @Test
    void aFailingTest() {
        fail();
    } */
}