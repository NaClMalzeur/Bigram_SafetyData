import java.util.Map;

public class Bigram {
    // Premier mot du bigram donné
    private String motA;
    // Second mot du bigram donné
    private String motB;

    // Nombre de fois où le bigram est apparu dans le texte
    private int countBigramAB;

    // Résultat du calcul de significance
    private double significance;

    // Indique si le bigram apparait sufficient de fois
    private boolean isActive;

    // Constructeur de la classe Bigram
    public Bigram(String motA,
                  String motB) {
        this.motA = motA;
        this.motB = motB;
        this.countBigramAB = 1;
        this.significance = 0.0;
        this.isActive = false;
    }

    public double getSignificance() {
        return significance;
    }

    public int getCountBigramAB() {
        return countBigramAB;
    }

    public boolean isActive() {
        return isActive;
    }

    // Methode qui indique à l'objet que le bigram est apparu une fois de plus
    public void addCountBigram(){
        this.countBigramAB ++;
    }

    /*
     * Methode calculant la valeur de la significance du bigram, si il est apparu suffisamment de fois
     * Input : int : nombre d'apparitions minimal pour que ce soit un cl-location
     *         Map<String, Integer> : Map dont les clés sont les différents mots et la valeur le nombre de fois où
     *         ce mot apparait dans le texte
     * Output : None
     */
    public void calcSignificance (int minCount,
                                  Map<String,Integer> everyWordCount){
        if(this.countBigramAB >= minCount) {
            this.isActive = true;
            int countMotA = everyWordCount.get(motA);
            int countMotB = everyWordCount.get(motB);
            int N = 0;
            for(Map.Entry<String, Integer> entry : everyWordCount.entrySet()){
                N+= entry.getValue();
            }
            this.significance = Math.log10((double)(countBigramAB * N)/(countMotA * countMotB));
        }
    }

    @Override
    public String toString(){
        return this.motA + " " + this.motB + "  Significance : " + this.significance;
    }
}
