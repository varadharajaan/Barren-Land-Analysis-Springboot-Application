package barrenland.demo;


import barrenland.demo.Exception.IntegerPraserException;
import barrenland.demo.Service.BarrenFertileLandImpl;
import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 * @author Varadharajan on 2019-09-16 23:13
 * @project name: barren-land
 */
public class BrandLandAnalysisTest {

    BarrenFertileLandImpl bla = new BarrenFertileLandImpl();

    public BrandLandAnalysisTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }


    @Test
    public void testMain() {
    }


    @Test
    public void testFindFertileLand() {
        String[] strSTDIN = {"0 292 399 307"};
        String STDOUT = "116800 116800 ";


        assertEquals(STDOUT, bla.parseFertileFoundLand(strSTDIN));

    }


    @Test
    public void testFindFertileLand2() {
        String[] strSTDIN = {"48 192 351 207", "48 392 351 407", "120 52 135 547", "260 52 275 547"};
        String STDOUT = "22816 192608 ";


        assertEquals(STDOUT, bla.parseFertileFoundLand(strSTDIN));

    }


    @Test
    public void testFindFertileLand3() {
        String[] strSTDIN = {"0 0 399 599"};
        String STDOUT = "No fertile land available.";


        assertEquals(STDOUT, bla.parseFertileFoundLand(strSTDIN));

    }


    @Test
    public void testFindFertileLand4() {
        String[] strSTDIN = {"0 0 1 1"};
        String STDOUT = "239996 ";


        assertEquals(STDOUT, bla.parseFertileFoundLand(strSTDIN));

    }


    @Test
    public void testFindFertileLand5() {
        String[] strSTDIN = {"0 0 0 599"};
        String STDOUT = "239400 ";


        assertEquals(STDOUT, bla.parseFertileFoundLand(strSTDIN));

    }


    @Test
    public void testFindFertileLand6() {
        String[] strSTDIN = {"0 0 0 599", "2 0 2 599"};
        String STDOUT = "600 238200 ";


        assertEquals(STDOUT, bla.parseFertileFoundLand(strSTDIN));

    }


    @Test
    public void testFindFertileLand7() {
        String[] strSTDIN = {"0 0 0 599", "2 0 2 599", "3 2 399 3"};
        String STDOUT = "600 794 236612 ";


        assertEquals(STDOUT, bla.parseFertileFoundLand(strSTDIN));

    }


    @Test
    public void testFindFertileLand8() {
        String[] strSTDIN = {"0 0 0 599", "2 0 2 599", "3 2 399 3", "5 0 5 1"};
        String STDOUT = "4 600 788 236612 ";


        assertEquals(STDOUT, bla.parseFertileFoundLand(strSTDIN));

    }


    @Test
    public void testFindFertileLand9() {
        String[] strSTDIN = {"0 0 0 599", "0 0 399 0", "399 0 399 599", "0 599 399 599"};
        String STDOUT = "238004 ";


        assertEquals(STDOUT, bla.parseFertileFoundLand(strSTDIN));

    }

    @Test
    public void testFindFertileLand10() {
        String[] strSTDIN = {"0 0 0 599", "2 0 2 599", "3 2 399 3", "5 0 5 1", "10 4 12 599"};
        String STDOUT = "4 600 788 4172 230652 ";


        assertEquals(STDOUT, bla.parseFertileFoundLand(strSTDIN));

    }

    @Test(expected = IntegerPraserException.class)
    public void testException() {
        String[] strSTDIN = {"ya ya ya ya"};
        bla.parseFertileFoundLand(strSTDIN);

    }

}
