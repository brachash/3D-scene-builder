package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import primitives.Point3D;
import primitives.Vector;

public class Point3DTest {

    @Test
    public void testAdd()
    {
        Point3D p1=new Point3D(1,2,3);
        Vector p2=new Vector(1,1,1);
        Point3D p3=new Point3D(2,3,4);
        assertEquals(p3,p1.add(p2).getHead());
    }

    @Test
    public void testSubtractVector()
    {
        Point3D p1=new Point3D(1,2,3);
        Vector p2=new Vector(1,1,1);
        Point3D p3=new Point3D(0,1,2);
        assertEquals(p3,p1.substract(p2).getHead());
    }

    @Test
    public void testSubtractPoint3D()
    {
        Point3D p1=new Point3D(1,2,3);
        Point3D p2=new Point3D(1,1,1);
        Point3D p3=new Point3D();
        p3=p1.substract(p2);
        Point3D p4=new Point3D(0,1,2);
        assertEquals(p4,p3);
    }

    @Test
    public void testDistancePoint3D()
    {
        Point3D p1=new Point3D(1,2,3);
        Point3D p2=new Point3D(1,1,1);
        double d1 = p1.distance(p2);
        assertEquals(d1, Math.sqrt(5),0.1);
    }
}

