
import org.junit.jupiter.api.Test;

import java.rmi.server.ExportException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPolynom {

    @Test
    void testInput0() {
        Polynom polynom = new Polynom(new double[] {4, 2, 4, 2, 2});
        assertEquals(Arrays.toString(new double[] {2.0,8.0,6.0,16.0,0.0}), Arrays.toString(polynom.firstDerivation()));
    }

}
