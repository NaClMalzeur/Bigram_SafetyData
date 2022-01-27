import java.util.ArrayList;

public class PrintTopBigrams {
    /*
    * Fonction qui affiche en format texte sur la console les k bigrams ayant le plus haut score.
    * Input : ArrayList<Bigram> : Liste des k bigrams à la significance la plus élevée.
    * Output : None
     */
    public static void print (ArrayList<Bigram> topBigrams){
        // Affichage de la liste par la fin, car le tri est inversé.
        for(int i = topBigrams.size()-1; i >= 0; i--){
            System.out.println(topBigrams.get(i).toString() + "\n");
        }
    }
}
