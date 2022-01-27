import java.util.HashMap;
import java.util.Map;

public class CountOfEveryWords {
    /*
    * Fonction qui calcule le nombre d'occurrences de chacun des mots du texte
    * Input : String[] : Tableau de chaine de caractère comprenant tous les mots du texte
    * Output : Map<String, Integer> : Map dont les clés sont les différents mots et la valeur le nombre de fois où
    * ce mot apparait dans le texte
    * */
    public static Map<String, Integer> count (String[] tableWords){
        Map<String, Integer> everyWordCount = new HashMap<String, Integer>();
        for(String word : tableWords){
            everyWordCount.put(word, everyWordCount.getOrDefault(word,0) + 1);
        }
        return everyWordCount;
    }
}
