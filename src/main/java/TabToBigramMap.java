import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TabToBigramMap {
    /*
    * Fonction qui vas créer une map de Bigram pour en analysant tous les mots un à un et
    * comptera les apparitions de chacun.
    * Input : String[] : un tableau de chaine de caractères comportant tous les mots du texte à la suite.
    * Output : Map<String, Map<String, Bigram> : Une première map qui vas recenser tous les mots uniques du texte en clé
    * et qui y associera à chacun une seconde map, dont la clé sera le second mot d'un bigram. La valeur de cette map
    * sera un objet Bigram décrit dans la classe correspondante
     */
    public static Map<Bigram, Long>  createBigramMap (String[] tableWords){
        Map<Bigram, Long> bigramMap = new HashMap<Bigram, Long>();
        List<Bigram> bigramList = new ArrayList<Bigram>();

        for(int i = 0; i < tableWords.length - 1; i++) {
            String motA = tableWords[i];
            String motB = tableWords[i + 1];
            Bigram bg = new Bigram(motA,motB);
            bigramList.add(bg);
        }

        System.out.println("List size = " + bigramList.size());
        bigramMap = bigramList.stream()
                .collect(Collectors.groupingBy(
                        Function.identity()
                        , Collectors.counting() ));
        System.out.println("Map size = " + bigramMap.size());
        bigramMap.forEach((k, v) -> System.out.println("Key : " + k.toString() + ", Value : " + v));

        return bigramMap;
    }
}
