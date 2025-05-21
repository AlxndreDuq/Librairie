public class Book {
    String titre;
    String auteur;
    int anneePublication;

    public Book(String titre, String auteur, int anneePublication) {
        if(isNullOrEmpty(titre) || isNullOrEmpty(auteur)){
            throw new IllegalArgumentException("Titre ou auteur invalide lors de la création du livre");
        }
        this.titre = titre;
        this.auteur = auteur;
        this.anneePublication = anneePublication;
    }

    private boolean isNullOrEmpty(String s){
        return s == "" || s == null;
    }
}
