package tests;

import static org.junit.Assert.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import Geometries.Sphere;
import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class SphereTest {

    @Test
    public void testGetNormal()
    {
        Material m=new Material();

        Color c=new Color(255);
        Point3D p=new Point3D(1,0,3);
        Sphere s=new Sphere(c,m,4,p);
        Point3D p3=new Point3D(2,0,-1);
        Vector v2=new Vector(p3);
        v2.normalize();
        Point3D p2=new Point3D(3,0,2);
        assertEquals(v2, s.getNormal(p2));
    }
    @Test
    public void testSphereNormal()
    {
        Material m=new Material();

        Vector answer = new Vector(0.7071067811865475, 0.7071067811865475, 0.0);

        Point3D p1 = new Point3D(0, 0, -400);
        Point3D p2 = new Point3D(1,1, -400);

        Sphere sphere = new Sphere(Color.white,m, 200, p1);

        Vector vector = sphere.getNormal(p2);
        assertEquals(answer, vector);
    }

    @Test
    public void testSphereIntersections() {

        Material m=new Material();

        // creating the expected values
        List<Point3D> answerList1 = new ArrayList<Point3D>();
        List<Point3D> answerList2 = new ArrayList<Point3D>();

        Point3D answerPoint1 = new Point3D(0, 0, -200);
        Point3D answerPoint2 = new Point3D(0, 0, -600);

        answerList2.add(answerPoint1);
        answerList2.add(answerPoint2);


        // building the spheres

        Point3D p1 = new Point3D(0, 0, -400);
        Point3D p2 = new Point3D(p1);
        Point3D centerPoint = new Point3D(0,0,0);

        Vector direction1 = new Vector(50, -50, -50);
        Vector direction2 = new Vector(0, 0, -5);
        Sphere sphere1 = new Sphere(Color.white,m, 200, p1);
        Sphere sphere2 = new Sphere(Color.white,m, 200, p2);

        // building the ray that will intersect the spheres

        Ray ray1 = new Ray(centerPoint, direction1);
        Ray ray2 = new Ray(centerPoint, direction2);

        // testing the findIntersection functions
        List<Point3D> list1 = new ArrayList<Point3D>();
        list1 = sphere1.findIntersections(ray1);
        assertEquals(answerList1, list1);

        List<Point3D> list2 = new ArrayList<Point3D>();
        list2 = sphere2.findIntersections(ray2);
        assertEquals(answerList2, list2);
    }
    @Test
    public void testFindIntersections() throws Exception
    {
        Material m=new Material();

        Color color = new Color(0,0,0);
        Sphere sphere=new Sphere(color,m, 2.0,new Point3D(0,0,-3));
        ArrayList<Point3D> myintersectionPoints=(ArrayList<Point3D>) sphere.findIntersections(new Ray(new Point3D(0,0,0), new Vector(0, 0,-1)));
        ArrayList<Point3D> intersectionPoints=new ArrayList<Point3D>();
        intersectionPoints.add(new Point3D(0,0,-1));
        intersectionPoints.add(new Point3D(0,0,-5));
        assertTrue(myintersectionPoints.containsAll(intersectionPoints));

        Sphere sphere1=new Sphere(color,m,2.0,new Point3D(0.0,0.0,-3.0));
        ArrayList<Point3D> myintersectionPoints1=(ArrayList<Point3D>) sphere1.findIntersections(new Ray (new Point3D(0,0,-3), new Vector(0,0,1)));
        ArrayList<Point3D> intersectionPoints1=new ArrayList<Point3D>();
        intersectionPoints1.add(new Point3D(0.0,0.0,-1.0));
        assertEquals(intersectionPoints1,myintersectionPoints1);

        Sphere sphere2=new Sphere(color,m, 1.0,new Point3D(0.0,0.0,3.0));
        ArrayList<Point3D> myintersectionPoints2=(ArrayList<Point3D>) sphere2.findIntersections(new Ray(new Point3D(), new Vector(0,1,0)));
        ArrayList<Point3D> intersectionPoints2=new ArrayList<Point3D>();
        assertEquals(intersectionPoints2,myintersectionPoints2);

        Sphere sphere3=new Sphere  (color,m, 50.0,new Point3D(0.0,0.0,-150));
        ArrayList<Point3D> myResult3=(ArrayList<Point3D>) sphere3.findIntersections(new Ray(new Point3D(0,0,0), new Vector(250, 250,-150)));
        ArrayList<Point3D> result3=new ArrayList<Point3D>();
        assertEquals(result3,myResult3);

        Sphere sphere4=new Sphere(color,m,2 ,new Point3D(0,0,-3));
        ArrayList<Point3D> myintersectionPoints4=(ArrayList<Point3D>) sphere4.findIntersections(new Ray(new Point3D(0,0,-3), new Vector(0, 0,-1)));
        ArrayList<Point3D> intersectionPoints4=new ArrayList<Point3D>();
        intersectionPoints4.add(new Point3D(0,0,-5));
        assertTrue(myintersectionPoints4.containsAll(intersectionPoints4));
    }
}
