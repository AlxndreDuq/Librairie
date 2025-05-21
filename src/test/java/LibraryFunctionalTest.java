import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryFunctionalTest {

    @Test
    void functionalTest(){
        Library lib = new Library();
        assertDoesNotThrow(()->lib.addBook(new Book("1984", "George Orwell", 1949)));
        assertDoesNotThrow(()->lib.addBook(new Book("Dune", "Frank Herbert", 1965)));
        assertDoesNotThrow(()->lib.deleteBook("1984"));
        assertDoesNotThrow(()->lib.displayBooks());
        assertEquals(1, lib.livres.size());
        assertEquals("Dune", lib.livres.get(0).titre);
    }

}