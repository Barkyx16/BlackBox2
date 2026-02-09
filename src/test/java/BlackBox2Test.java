import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BlackBox2Test {

    private Class<RacecarExample> classUnderTest;
    private RacecarExample racecar;

    @SuppressWarnings("unchecked")
    public BlackBox2Test(Object classUnderTest) {
        this.classUnderTest = (Class<RacecarExample>) classUnderTest;
    }

    // Same implementations as the example test
    @Parameterized.Parameters
    public static Collection<Object[]> cartClassUnderTest() {
        return Arrays.asList(new Object[][]{
                {RacecarExample.class},
                {RacecarError1.class},
                {RacecarError2.class},
                {RacecarError3.class}
        });
    }

    private RacecarExample createRacecar() throws Exception {
        Constructor<RacecarExample> constructor = classUnderTest.getConstructor();
        return constructor.newInstance();
    }

    @Before
    public void setUp() throws Exception {
        racecar = createRacecar();
    }

    // --------------------------------------------------
    // YOUR BLACK-BOX TESTS START HERE
    // --------------------------------------------------

    @Test
    public void sanityCheck_runsAgainstAllImplementations() {
        racecar.setDefaults();
        assertNotNull(racecar);
    }

    @Test
    public void bb_needToPit_true_refuels_and_returnsFalse() {
        racecar.setDefaults();
        racecar.needToPit = true;

        boolean result = racecar.willFinish(100);

        assertEquals(100.0, racecar.fuelPercentageRemaining, 0.0);
        assertFalse(result);
    }

    @Test
    public void bb_avgSpeed_99() {
        racecar.setDefaults();

        boolean result = racecar.willFinish(99);

        assertEquals(42.5, racecar.fuelPercentageRemaining, 0.0);
        assertTrue(result);
    }
}
