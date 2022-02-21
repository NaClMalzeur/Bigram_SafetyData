import java.util.*;

public class AppBigram {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        String input;

        // Demande du fichier XML à lire
        System.out.println("Entrez le chemin du fichier xml a analyser \n " +
                "(racine : src/main/resources/XML/) \n" +
                "(src/main/resources/XML/zola_germinal_short.xml par defaut) : \n");
        String xml = "src/main/resources/XML/zola_germinal_short.xml";
        input = scan.nextLine();
        if(!input.equals("")){
            xml = "src/main/resources/XML/" + input;
        }

        // Demande du nombre k de bigram à afficher
        System.out.println("Entrez le nombre k de bigrams a afficher (10 par defaut) : \n");
        int k = 10;
        input = scan.nextLine();
        if(input.matches("\\d+")){
            k = Integer.getInteger(input);
        }

        // Demande du minCount
        System.out.println("Entrez le nombre minCount d'apparition minimale de bigrams (3 par defaut) : \n");
        long minCount = 3;
        input = scan.nextLine();
        if(input.matches("\\d+")){
            minCount = Integer.getInteger(input);
        }

        // Conversion du fichier XML en tableau de String contenant tous les mots du texte à la suite
        String text = XmlFileReader.reader(xml);
        String[] tableWords = XmlFileReader.normalizeText(text);

        // Calcul du nombre occurrence de chacun des mots dans le texte
        Map<String, Integer> everyWordCount = CountOfEveryWords.count(tableWords);

        // Creation et compte des bigrams à partir du tableau de mots
        Map<Bigram, Long> bigramMap = TabToBigramMap.createBigramMap(tableWords);


        // Calcul de la significance de chacun des bigrams

        List<Bigram> topBigrams = new ArrayList<Bigram>();
        topBigrams = ComputeSigAndTopBigrams.compute(bigramMap, everyWordCount, minCount, k);


        // Affichage des top k bigrams co-location
        System.out.println("Voici les " + k + " bigrams de plus hautes significance : \n");
        PrintTopBigrams.print(topBigrams);

    }
}
