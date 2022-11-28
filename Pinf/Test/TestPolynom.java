package Pinf.Test;

import Pinf.PolynomBechnung.src.Polynom;
import org.testng.annotations.Test;

import java.rmi.server.ExportException;
import java.util.Arrays;

import static org.testng.Assert.assertEquals;


public class TestPolynom {

    @Test
    void testInput0() {
        Polynom polynom = new Polynom(new double[] {3,3,3,3,3});
        assertEquals("f(x) =", polynom.firstDerivations());
    }

}
