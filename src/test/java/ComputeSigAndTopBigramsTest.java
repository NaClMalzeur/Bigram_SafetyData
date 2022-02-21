import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ComputeSigAndTopBigramsTest {

//    private  Map<String, Integer> everyWordCount;
//    private Map<String, Map<String, Bigram>> bigramMap;
//    private Bigram big1, big2, big3;
//    private Map<String,Bigram> tmpMapUn, tmpMapDeux;
//    @BeforeEach
//    void setUp() {
//        bigramMap = new HashMap<String, Map<String, Bigram>>();
//        big1 = new Bigram("un", "deux");
//        big2 = new Bigram("deux", "un");
//        big2.addCountBigram();
//        big3 = new Bigram("un", "trois");
//        big3.addCountBigram();
//        big3.addCountBigram();
//        tmpMapUn = new HashMap<String, Bigram>();
//        tmpMapUn.put("deux", big1);
//        tmpMapUn.put("trois", big3);
//        tmpMapDeux = new HashMap<String, Bigram>();
//        tmpMapDeux.put("deux", big2);
//
//        bigramMap.put("un", tmpMapUn);
//        bigramMap.put("deux", tmpMapDeux);
//
//
//        everyWordCount = new HashMap<String, Integer>();
//        everyWordCount.put("un", 6);
//        everyWordCount.put("deux", 3);
//        everyWordCount.put("trois", 3);
//    }
//
//    @AfterEach
//    void tearDown() {
//        bigramMap.clear();
//        everyWordCount.clear();
//        tmpMapDeux.clear();
//        tmpMapUn.clear();
//    }
//
//    @Test
//    void compute() {
//        ArrayList<Bigram> topBigrams = ComputeSigAndTopBigrams.compute(bigramMap, everyWordCount, 1, 3);
//
//        assertEquals(3, topBigrams.size());
//
//        topBigrams = ComputeSigAndTopBigrams.compute(bigramMap, everyWordCount, 2, 2);
//
//        assertEquals(2, topBigrams.size());
//
//        topBigrams = ComputeSigAndTopBigrams.compute(bigramMap, everyWordCount, 3, 1);
//
//        assertEquals(1, topBigrams.size());
//    }
}