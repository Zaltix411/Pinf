

import org.junit.jupiter.api.Test;


import java.rmi.server.ExportException;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;


public class TestPolynom {

    @Test
    void testPolynom() {
        Polynom polynom = new Polynom(new double[]{2.0, 0.0, 0.0});
        polynom.getZeropoints();
        assertEquals("[2.0]",polynom.getZeropoints().toString());

    }
}
