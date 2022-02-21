import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BigramTest {

//    private Bigram big1, big2, big3;
//    private Map<String, Integer> everyWordCount;
//    @BeforeEach
//    void setUp() {
//        big1 = new Bigram("un", "deux");
//        big2 = new Bigram("deux", "un");
//        //big2.addCountBigram();
//        big3 = new Bigram("un", "trois");
//        //big3.addCountBigram();
//        //big3.addCountBigram();
//
//        everyWordCount = new HashMap<String, Integer>();
//        everyWordCount.put("un", 6);
//        everyWordCount.put("deux", 3);
//        everyWordCount.put("trois", 3);
//    }
//
//    @AfterEach
//    void tearDown() {
//        everyWordCount.clear();
//    }
//
//    @Test
//    void addCountBigram() {
//        assertEquals(1, big1.getCountBigramAB());
//        assertEquals(2, big2.getCountBigramAB());
//        assertEquals(3, big3.getCountBigramAB());
//
//
//        big3.addCountBigram();
//        assertEquals(4, big3.getCountBigramAB());
//    }
//
//    @Test
//    void calcSignificance() {
//        double sigBig1 = -0.1761;
//        double sigBig2 = 0.1249;
//        double sigBig3 = 0.3010;
//
//        big1.calcSignificance(1, everyWordCount);
//        big2.calcSignificance(1, everyWordCount);
//        big3.calcSignificance(1, everyWordCount);
//
//        assertEquals(sigBig1, big1.getSignificance(),0.001);
//        assertEquals(sigBig2, big2.getSignificance(),0.001);
//        assertEquals(sigBig3, big3.getSignificance(),0.001);
//    }
}