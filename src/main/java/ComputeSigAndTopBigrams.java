import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    public static List<Bigram> compute(Map<Bigram, Long> bigramMap,
                                            Map<String, Integer> everyWordCount,
                                            Long minCount,
                                            int k){
        List<Bigram> topBigrams = new ArrayList<Bigram>();
        System.out.println(bigramMap.size());
        bigramMap = bigramMap.entrySet().stream()
                .filter( x -> x.getValue() >= minCount).collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));
        bigramMap.entrySet().stream().forEach(x -> x.getKey().calcSignificance(x.getValue(),everyWordCount));
        topBigrams = bigramMap.keySet().stream()
                .sorted(Collections.reverseOrder(Comparator.comparing(Bigram::getSignificance)))
                .limit(k)
                .collect(Collectors.toList());
        System.out.println(topBigrams.size());


        return topBigrams;
    }
}
