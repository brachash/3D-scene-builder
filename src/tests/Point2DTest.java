package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import primitives.Coordinate;
import primitives.Point2D;

public class Point2DTest {

    @Test
    public void testGet()
    {
        Coordinate c=new Coordinate(3);
        Coordinate d=new Coordinate(5);
        Point2D p=new Point2D(c,d);
        assertEquals(3,p.getX().getCoordinate(),0.0);
        assertEquals(5,p.getY().getCoordinate(),0.0);
    }

    @Test
    public void testSet()
    {
        Coordinate c=new Coordinate(3);
        Coordinate d=new Coordinate(5);
        Point2D p=new Point2D();
        p.setX(c);
        p.setY(d);
        assertEquals(3,p.getX().getCoordinate(),0.0);
        assertEquals(5,p.getY().getCoordinate(),0.0);
    }

    @Test
    public void testEquals()
    {
        Coordinate c=new Coordinate(3);
        Coordinate d=new Coordinate(5);
        Point2D p=new Point2D(c,d);
        Point2D p2=new Point2D(c,d);
        assertTrue( p.equals(p2));
    }


}

