package tests;

import static org.junit.Assert.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import Geometries.Plane;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
import primitives.Material;

public class PlaneTest {

    @Test
        public void testPlaneNormal()
        {
            Material m=new Material();
            Vector answer = new Vector(0,0, -1);
            Point3D directionPoint = new Point3D(0, 0, -1);
            Point3D planePoint = new Point3D(0, 100, -200);
            Point3D normalPoint = new Point3D(1, 1, -200);
            Vector direction = new Vector(directionPoint);
            Plane plane = new Plane(Color.white,m, planePoint, direction);
            Vector vector = new Vector( plane.getNormal(normalPoint));
            assertEquals(answer, vector);

        }

    @Test
    public void testGetNormal() {
        Material m=new Material();
        Vector v = new Vector(1, 2, 3);
        Point3D p1 = new Point3D(4, 5, 6);
        Color c = new Color(255);
        Plane p = new Plane(c,m, p1, v);
        assertEquals(v, p.getNormal(p1));
    }


    @Test
    public void testPlaneIntersections() {
        Material m=new Material();


        List<Point3D> answerList = new ArrayList<Point3D>();
        Point3D answerPoint = new Point3D(0, 0, -200);
        answerList.add(answerPoint);


        Point3D directionPoint = new Point3D(0, 0, -1);
        Point3D planePoint = new Point3D(0, 100, -200);

        Vector direction = new Vector(directionPoint);

        Plane plane = new Plane(Color.white,m, planePoint, direction);

        // building the ray that will intersect the plane

        Point3D centerPoint = new Point3D(0, 0, 0);
        Vector vector = new Vector(0, 0, -5);
        Ray ray = new Ray(centerPoint, vector);

        // testing the findIntersection function

        List<Point3D> list = new ArrayList<Point3D>();
        list = plane.findIntersections(ray);
        assertEquals(answerList, list);
    }

}
