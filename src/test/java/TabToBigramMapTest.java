import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TabToBigramMapTest {

    private String[] textNorm1, textNorm2;
    @BeforeEach
    void setUp() {
        // 5 bigrams, tous uniques
        textNorm1 = new String[]{"un", "chat", "a", "traverse", "la", "route"};
        // 8 bigrams, pour 12 suites de deux mots, et 5 mots différents
        textNorm2 = new String[]{"un", "le", "une", "a", "le", "la", "un", "le", "le", "une", "un", "le", "une"};
    }

    @Test
    void createBigramMap() {
        Map<String, Map<String, Bigram>> map1= TabToBigramMap.createBigramMap(textNorm1);
        Map<String, Map<String, Bigram>> map2= TabToBigramMap.createBigramMap(textNorm2);

        assertEquals(5, map1.size());
        assertEquals(5, map2.size());

        int nbBigramsMap1 = 0;
        for(Map.Entry<String, Map<String, Bigram>> entry : map1.entrySet()){
            for(Map.Entry<String, Bigram> bigram : entry.getValue().entrySet()){
                nbBigramsMap1++;
            }
        }

        int nbBigramsMap2 = 0;
        for(Map.Entry<String, Map<String, Bigram>> entry : map2.entrySet()){
            for(Map.Entry<String, Bigram> bigram : entry.getValue().entrySet()){
                nbBigramsMap2++;
            }
        }
        assertEquals(5, nbBigramsMap1);
        assertEquals(8, nbBigramsMap2);
    }
}