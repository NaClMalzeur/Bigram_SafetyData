import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class XmlFileReaderTest {

    private String text1, text2;
    private String[] textNorm1, textNorm2;
    @BeforeEach
    void setUp() {

        text1 = "Un chat, à traversé la route.";
        textNorm1 = new String[]{"un", "chat", "a", "traverse", "la", "route"};

        text2 = "un le : une; à! le/ là ... un-le le une < un > le (une)";
        textNorm2 = new String[]{"un", "le", "une", "a", "le", "la", "un", "le", "le", "une", "un", "le", "une"};
    }

    @Test
    void normalizeText() {

        String[] tabTxt1 = XmlFileReader.normalizeText(text1);
        String[] tabTxt2 = XmlFileReader.normalizeText(text2);

        assertArrayEquals(textNorm1, tabTxt1);
        assertArrayEquals(textNorm2, tabTxt2);
    }
}