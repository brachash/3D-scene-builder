package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class RayTest {

    @Test
    public void testEquals()
    {
        Point3D p = new Point3D(0,0,0);
        Vector v1 = new Vector(1,2,3);
        Ray r1 = new Ray(p,v1);
        Ray r2 = new Ray(r1);
        Vector v2 = new Vector(2,3,4);
        Ray r3 = new Ray(p,v2);
        r2.setDirection(v2);
        assertEquals(r3,r2);
    }

}
