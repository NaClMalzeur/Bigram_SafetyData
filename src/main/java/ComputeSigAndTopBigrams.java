import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;

public class ComputeSigAndTopBigrams {
    /*
    * Fonction qui va indiquer à chacun des objets Bigram de calculer leur significance.
    * Elle récupèrera en même temps les k bigrams ayant la plus haute significance.
    * Input : Map<String, Map<String, Bigram>> : Une première map qui vas recenser tous les mots uniques du texte en clé
    * et qui y associera à chacun une seconde map, dont la clé sera le second mot d'un bigram. La valeur de cette map
    * sera un objet Bigram décrit dans la classe correspondante
    *         Map<String, Integer> : Map dont les clés sont les différents mots et la valeur le nombre de fois où
    * ce mot apparait dans le texte
    *         int : le nombre minimal d'apparition des bigrams pour qu'il soit une co-location
    *         int : le nombre de bigrams à afficher par le programme
     */
    public static ArrayList<Bigram> compute(Map<String, Map<String, Bigram>> bigramMap,
                                            Map<String, Integer> everyWordCount,
                                            int minCount,
                                            int k){
        ArrayList<Bigram> topBigrams = new ArrayList<Bigram>();

        long bigramsCount = 0;
        for(Map.Entry<String, Map<String, Bigram>> entry : bigramMap.entrySet()){
            for(Map.Entry<String, Bigram> bigram : entry.getValue().entrySet()){
                bigram.getValue().calcSignificance(minCount, everyWordCount);
                // Pour tous les k premiers bigrams apparaissant plus de minCount fois
                if(bigramsCount < k &&
                        bigram.getValue().isActive()){
                    topBigrams.add(bigram.getValue());
                    topBigrams.sort(Comparator.comparing(Bigram::getSignificance));
                    bigramsCount++;
                }else{
                    if(bigram.getValue().isActive() &&
                            topBigrams.get(0).getSignificance() < bigram.getValue().getSignificance()){
                        topBigrams.remove(0);
                        topBigrams.add(bigram.getValue());
                        topBigrams.sort(Comparator.comparing(Bigram::getSignificance));
                    }
                }
            }
        }

        return topBigrams;
    }
}
