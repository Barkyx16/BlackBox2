import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class RacecarExampleTest {

    private Class<RacecarExample> classUnderTest;

    @SuppressWarnings("unchecked")
    public RacecarExampleTest(Object classUnderTest) {
        this.classUnderTest = (Class<RacecarExample>) classUnderTest;
    }

    // Define all classes to be tested
    @Parameterized.Parameters
    public static Collection<Object[]> cartClassUnderTest() {
        Object[][] classes = {
                {RacecarExample.class},
                {RacecarError1.class},
                {RacecarError2.class},
                {RacecarError3.class}
        };
        return Arrays.asList(classes);
    }

    private RacecarExample createRacecar() throws Exception {
        Constructor<RacecarExample> constructor = classUnderTest.getConstructor();
        return constructor.newInstance();
    }

    RacecarExample racecar;

    @org.junit.Before
    public void setUp() throws Exception {
        racecar = createRacecar();
    }

    @Test
    public void test1() {
        racecar.setDefaults();
        boolean result = racecar.willFinish(50);
        assertEquals(42.5, racecar.fuelPercentageRemaining, 0);
        assertTrue(result);
    }

    @Test
    public void test2() {
        racecar.setDefaults();
        boolean result = racecar.willFinish(125);
        assertEquals(35.0, racecar.fuelPercentageRemaining, 0);
        assertTrue(result);
    }

    @Test
    public void test3() {
        racecar.setDefaults();
        boolean result = racecar.willFinish(200);
        assertEquals(20.0, racecar.fuelPercentageRemaining, 0);
        assertTrue(result);
    }

    @Test
    public void test4() {
        racecar.setDefaults();
        racecar.needToPit = true;
        boolean result = racecar.willFinish(100);
        assertEquals(100.0, racecar.fuelPercentageRemaining, 0);
        assertFalse(result);
    }

    @Test
    public void test5() {
        racecar.setDefaults();
        boolean result = racecar.willFinish(100);
        assertEquals(35.0, racecar.fuelPercentageRemaining, 0);
        assertTrue(result);
    }

    @Test
    public void test6() {
        racecar.setDefaults();
        racecar.fuelPercentageRemaining = 100.0;
        boolean result = racecar.willFinish(100);
        assertTrue(result);
    }

    @Test
    public void test7() {
        racecar.setDefaults();
        racecar.fuelPercentageRemaining = 0.0;
        boolean result = racecar.willFinish(100);
        assertFalse(result);
    }

    @Test
    public void test8() {
        racecar.setDefaults();
        racecar.fuelPercentageRemaining = 25.0;
        boolean result = racecar.willFinish(50);
        assertTrue(result);
    }

    @Test
    public void test9() {
        racecar.setDefaults();
        racecar.fuelPercentageRemaining = 3.0;
        boolean result = racecar.willFinish(200);
        assertFalse(result);
    }

    @Test
    public void test10() {
        racecar.setDefaults();
        boolean result = racecar.willFinish(99);
        assertEquals(42.5, racecar.fuelPercentageRemaining, 0);
        assertTrue(result);
    }

    @Test
    public void test11() {
        racecar.setDefaults();
        boolean result = racecar.willFinish(100);
        assertEquals(35.0, racecar.fuelPercentageRemaining, 0);
        assertTrue(result);
    }

    @Test
    public void test12() {
        racecar.setDefaults();
        boolean result = racecar.willFinish(150);
        assertEquals(20.0, racecar.fuelPercentageRemaining, 0);
        assertTrue(result);
    }

    @Test
    public void test13() {
        racecar.setDefaults();
        boolean result = racecar.willFinish(151);
        assertEquals(20.0, racecar.fuelPercentageRemaining, 0);
        assertTrue(result);
    }

    @Test
    public void test14() {
        racecar.setDefaults();
        racecar.fuelPercentageRemaining = 19.9;
        boolean result = racecar.willFinish(100);
        assertFalse(result);
    }

    @Test
    public void test15() {
        racecar.setDefaults();
        racecar.fuelPercentageRemaining = 20.0;
        boolean result = racecar.willFinish(100);
        assertFalse(result);
    }

    @Test
    public void test16() {
        racecar.setDefaults();
        racecar.fuelPercentageRemaining = 20.1;
        boolean result = racecar.willFinish(100);
        assertTrue(result);
    }
}

