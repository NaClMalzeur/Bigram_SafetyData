import java.util.Map;
import java.util.Objects;

public class Bigram {
    // Premier mot du bigram donné
    private final String motA;
    // Second mot du bigram donné
    private final String motB;

    // Résultat du calcul de significance
    private double significance;


    // Constructeur de la classe Bigram
    public Bigram(String motA,
                  String motB) {
        this.motA = motA;
        this.motB = motB;
        this.significance = 0.0;
    }

    public double getSignificance() {
        return significance;
    }

    /*
     * Methode calculant la valeur de la significance du bigram, si il est apparu suffisamment de fois
     * Input : int : nombre d'apparitions minimal pour que ce soit un cl-location
     *         Map<String, Integer> : Map dont les clés sont les différents mots et la valeur le nombre de fois où
     *         ce mot apparait dans le texte
     * Output : None
     */
    public void calcSignificance (Long countBigramAB,
                                  Map<String,Integer> everyWordCount){
            int countMotA = everyWordCount.get(motA);
            int countMotB = everyWordCount.get(motB);
            int N = 0;
            for(Map.Entry<String, Integer> entry : everyWordCount.entrySet()){
                N+= entry.getValue();
            }
            this.significance = Math.log10((double)(countBigramAB * N)/(countMotA * countMotB));
    }

    @Override
    public String toString(){
        return this.motA + " " + this.motB + "  Significance : " + this.significance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bigram bigram = (Bigram) o;
        return motA.equals(bigram.motA) && motB.equals(bigram.motB);
    }

    @Override
    public int hashCode() {
        return Objects.hash(motA, motB);
    }
}
