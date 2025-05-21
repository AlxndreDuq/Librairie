import org.junit.jupiter.api.*;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    private Library lib;

    @BeforeEach
    void setUp() {
        this.lib = new Library();
    }
    @Test
    void addBook() {
        assertThrows(IllegalArgumentException.class, () -> lib.addBook(null));
        assertThrows(IllegalArgumentException.class, () -> lib.addBook(new Book(null, "", 2015)));
        assertDoesNotThrow(()->lib.addBook(new Book("Azerty", "Moi", 2025)));
    }

    @Test
    void deleteBook() {
        lib.addBook(new Book("Azerty", "Moi", 2025));

        assertThrows(IllegalArgumentException.class, () -> lib.deleteBook(null));
        assertThrows(NoSuchElementException.class, () -> lib.deleteBook("livreQuiNexistePas"));
        assertDoesNotThrow(()->lib.deleteBook("Azerty"));
    }

    @Test
    void searchBook() {
        lib.addBook(new Book("Azerty", "Moi", 2025));
        assertThrows(NoSuchElementException.class, () -> lib.searchBook("livreQuiNexistePas"));
        assertDoesNotThrow(()->lib.searchBook("Azerty"));
    }

    @Test
    void displayBooks() {
        lib.addBook(new Book("Azerty", "Moi", 2025));
        lib.addBook(new Book("ijsbdv", "iuh", 2015));
        lib.addBook(new Book("mmmmq", "pdohz", 2010));
        assertDoesNotThrow(()->lib.displayBooks());
    }
}