import java.util.HashMap;
import java.util.Map;

public class TabToBigramMap {
    /*
    * Fonction qui vas créer une map de Bigram pour en analysant tous les mots un à un et
    * comptera les apparitions de chacun.
    * Input : String[] : un tableau de chaine de caractères comportant tous les mots du texte à la suite.
    * Output : Map<String, Map<String, Bigram> : Une première map qui vas recenser tous les mots uniques du texte en clé
    * et qui y associera à chacun une seconde map, dont la clé sera le second mot d'un bigram. La valeur de cette map
    * sera un objet Bigram décrit dans la classe correspondante
     */
    public static Map<String, Map<String, Bigram>> createBigramMap (String[] tableWords){
        Map<String, Map<String, Bigram>> bigramMap = new HashMap<String, Map<String, Bigram>>();

        for(int i = 0; i < tableWords.length - 1; i++){
            String motA = tableWords[i];
            String motB = tableWords[i+1];
            // Si le mot courant est déjà apparu dans le texte (est déjà contenu dans un Bigram)
            if(bigramMap.containsKey(motA)) {
                Map<String, Bigram> secondMap = bigramMap.get(motA);
                // Si le bigram est déjà apparu dans le texte.
                if(secondMap.containsKey(motB)){
                    secondMap.get(motB).addCountBigram();
                }else{
                    Bigram bigramToAdd = new Bigram(motA,motB);
                    secondMap.put(motB, bigramToAdd);
                }
            }else{
                Map<String, Bigram> secondMapToAdd = new HashMap<String, Bigram>();
                Bigram bigramToAdd = new Bigram(motA,motB);
                secondMapToAdd.put(motB, bigramToAdd);
                bigramMap.put(motA, secondMapToAdd);
            }
        }

        return bigramMap;
    }
}
