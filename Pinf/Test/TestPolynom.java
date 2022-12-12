package Pinf.Test;


import Pinf.PolynomBechnung.src.Polynom;
import org.testng.annotations.Test;



import static org.junit.Assert.assertEquals;


public class TestPolynom {

    @Test
    void testPolynom() {
        Polynom polynom = new Polynom(new double[]{-1.0, 4.0, 1.0});
        polynom.getZeropoints();
        assertEquals("[2.0]",polynom.getZeropoints().toString());

    }
}
