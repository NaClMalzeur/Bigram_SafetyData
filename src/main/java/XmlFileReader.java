import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.text.Normalizer;

public class XmlFileReader {
    /*
    * Fonction qui va lire un fichier xml, traiter toutes ses balises <p> pour obtenir un texte unique
    * (en minuscule et sans accents). La fonction va ensuite séparer tous les mots par les espaces ou la ponctuation.
    * Input : String : le chemin du fichier xml à analyser
    * Output : String : le texte complet à analyser
     */
    public static String reader(String filePath){
        // Lecture du fichier xml
        File file = new File(filePath);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
                .newInstance();

        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        Document document = null;
        try {
            document = documentBuilder.parse(file);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Ce fichier n'existe pas.");
            System.exit(0);
        }

        // Creation d'une chaine de caractère unique regroupant toutes les balises <p>
        String text = "";
        if(document != null) {
            org.w3c.dom.NodeList texts = document.getElementsByTagName("p");
            for(int i = 0; i < texts.getLength(); i++){
                text += texts.item(i).getTextContent();
            }
        }

        return text;
    }

    /*
     * Fonction qui va normaliser le format du texte (enlever les accents et caractères spécifiques à la langue)
     * puis séparer tous les mots par les espaces ou la ponctuation.
     * Input : String : le texte complet à traiter
     * Output : String[] : Tableau de chaine de caractère comprenant tous les mots du texte normalisé
     */
    public static String[] normalizeText(String text){
        // Transformation du texte en minuscule
        text = text.toLowerCase();
        // Transformation du texte pour enlever les accents
        text = Normalizer.normalize(text, Normalizer.Form.NFD);
        text = text.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        // Séparation de la chaine de textes par en mots (ponctuation, apostrophe et espaces)
        String[] tableWords = text.split("[^\\wœ]+");

        return tableWords;
    }
}
