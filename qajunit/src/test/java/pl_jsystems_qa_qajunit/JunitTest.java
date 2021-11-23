package pl_jsystems_qa_qajunit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static java.lang.Integer.parseInt;
import static org.junit.jupiter.api.Assertions.*;

public class JunitTest {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("====beforeAll====");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("====After All====");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("====beforeEach====");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("====AfterEach====");
    }

    private static final String STRING_TESTOWY = "stringTestowy";

    @Tags({@Tag("junit"),@Tag("smoke"),@Tag("string")})
    @DisplayName("First test")
    @Test
    public void firstTest() {


        assertEquals(2+3,5);
        assertNotEquals(2 + 2,5);
        assertTrue(STRING_TESTOWY.contains("st"));
        assertTrue(STRING_TESTOWY.endsWith("wy"));
        assertEquals(STRING_TESTOWY, "stringTestowy");
    }

    @Test
    public void junitTest() {
        System.out.println(0.2*0.2);
//        assertEquals(0.2*0.2, 0.04);

        double result = new BigDecimal("0.2").multiply(new BigDecimal("0.2")).doubleValue();
        assertEquals(result, 0.04);
    }

    @Tags({@Tag("junit"),@Tag("string")})
    @Test
    public void stringTest() {

        String simpleString = "simpleString";
        String simple = "simpleString";

        String simpleString_2 = new String ("simpleString");
        String simpleString_3 = new String ("simpleString");

        assertSame("simpleString",simpleString);
        assertSame(simple, simpleString);
        assertEquals(simple, simpleString);

    // assertTrue(simpleString == simpleString_3); //sprawdza referencje, czy to jest ten sam obiekt
        assertTrue(simpleString.equals(simpleString_3));

        assertEquals(simpleString, simpleString_2);
        assertEquals(simpleString_3, simpleString_2);
    }

    @Tag("junit")
    @Test
    public void googleTruthTest() {
        assertThat(STRING_TESTOWY).contains("ingT");

    }
    @Tags({@Tag("junit"),@Tag("zadania")})
    @DisplayName("Zadanie 1")
    @Test
    public void zad1() {
        String resultString = "Wordpress powers 100% of the internet";
        String expectedString = "Wordpress powers [number]% of the internet";
        assertThat(resultString).startsWith("Wordpress powers ");
        assertThat(resultString).endsWith("% of the internet");
        assertThat(resultString).matches("Wordpress powers \\d+% of the internet");
        String result = resultString.replace("Wordpress powers ","").replace("% of the internet","");
        assertThat(result).matches("^\\d+$");
        int intResult = new Integer(result);
        assertThat(intResult>=0);
        assertThat(intResult).isLessThan(101);


//        String resultsubstr1 = resultString.replace("Wordpress powers ","");
//        String result2 = resultsubstr1.replace("% of the internet","");
//
//       int number = Integer.parseInt(result2);
//
//       assertTrue(number>0);
//       assertTrue(number<=100);
    }

    @Tags({@Tag("junit"),@Tag("nested")})
    @DisplayName("Nested")
    @Nested
    public class NestedTest {

        @DisplayName("List test")
        @Test
        public void listTest() {
            List<Integer> result = Arrays.asList(1,2,3,4,5);
            List<Integer> expected = Arrays.asList(3,4,5);

            assertThat(result).containsAnyIn(expected);
            assertTrue(result.containsAll(expected));
            assertThat(result).hasSize(5);
            assertThat((result)).containsAnyOf(1,2);
         }
        @DisplayName("Exception test")
        @Test
        public void exceptionTest() {
            GamePlay gamePlay = new GamePlay();
            Assertions.assertThrows(IllegalArgumentException.class, () -> gamePlay.play(0));
        }

    }
}
