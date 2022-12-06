

import org.junit.jupiter.api.Test;


import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;


public class TestPolynom {

    @Test
    void testDerivationPolynomMinus(){
        Polynom polynom = new Polynom(new double[] { 3.0, 2.0, -4.0, 3.0, 2.0 });
        assertEquals("f'(x) = 8.0x^3 + 9.0x^2 - 8.0x + 2.0", polynom.toString());
    }
}
