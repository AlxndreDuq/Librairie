import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Library {
    List<Book> livres;

    public Library() {
        this.livres = new ArrayList<Book>() {};
    }

    public void addBook(Book b){
        if (b == null){
            throw new IllegalArgumentException("Le livre est invalide");
        }
        this.livres.add(b);
    }

    public void deleteBook(String t){
        if (t == null || t == ""){
            throw new IllegalArgumentException("Le livre est invalide");
        }

        if(!this.livres.removeIf(livre -> livre.titre.equalsIgnoreCase(t))){
            throw new NoSuchElementException("Livre non trouvé, il n'a donc pas pu être supprimé");
        }
    }

    public Book searchBook(String titre){
        return this.livres.stream()
                .filter(livre -> livre.titre.equalsIgnoreCase(titre))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Livre avec le titre '" + titre + "' non trouvé"));
    }

    public void displayBooks(){
        this.livres.forEach(livre -> System.out.println(livre.titre + " by " + livre.auteur + " (" + livre.anneePublication + ")"));
    }

}
