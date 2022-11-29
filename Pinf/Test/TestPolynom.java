

import org.junit.jupiter.api.Test;


import java.rmi.server.ExportException;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;


public class TestPolynom {

    @Test
    void testPolynom() {
        Polynom polynom = new Polynom(new double[]{3, 3, 3, 3, 3});
        // 187

        //assertEquals(Arrays.toString(new double[] {3, 6, 9, 12, 0}),Arrays.toString(polynom.firstDerivations()));
    }
}
