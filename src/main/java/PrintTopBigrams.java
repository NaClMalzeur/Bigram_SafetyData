import java.util.ArrayList;
import java.util.List;

public class PrintTopBigrams {
    /*
    * Fonction qui affiche en format texte sur la console les k bigrams ayant le plus haut score.
    * Input : ArrayList<Bigram> : Liste des k bigrams à la significance la plus élevée.
    * Output : None
     */
    public static void print (List<Bigram> topBigrams){
        // Affichage de la liste
        topBigrams.stream().forEach(System.out::println);
    }
}
