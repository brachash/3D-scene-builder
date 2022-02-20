package tests;
import static org.junit.Assert.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import Geometries.Plane;
import Geometries.Triangle;
import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class TriangleTest {

    @Test
    public void testTriangleNormal()
    {
        Material m=new Material();

        Vector answer = new Vector(0,0, -1);
        Point3D directionPoint = new Point3D(0, 0, -1);
        Point3D planePoint = new Point3D(0, 100, -200);
        Point3D normalPoint = new Point3D(1, 1, -200);

        Vector direction = new Vector(directionPoint);

        Plane plane = new Plane(Color.white,m, planePoint, direction);

        Vector vector = plane.getNormal(normalPoint);
        assertEquals(answer, vector);
    }

    @Test
    public void testGetNormal()
    {
        Material m=new Material();
        Triangle temp=new Triangle(new Color(100,100,100),m,new Point3D(1, 2, 3),new Point3D(2,4,6),new Point3D(3, 4, 5));
        Point3D p=new Point3D();
        Vector vec=new Vector(temp.getNormal(p));
        Vector v1=new Vector(2,-4,2);
        v1.normalize();
        assertEquals(v1.toString(), vec.toString());
    }


    @Test
    public void testTriangleIntersections() {
        Material m=new Material();


        List<Point3D> answerList = new ArrayList<Point3D>();
        Point3D answerPoint = new Point3D(0, 0, -200);
        answerList.add(answerPoint);


        Point3D p1 = new Point3D(0, 100, -200);
        Point3D p2 = new Point3D(100, -100, -200);
        Point3D p3 = new Point3D(-100, -100, -200);

        Triangle t1 = new Triangle(Color.white,m, p1, p2, p3);
        Triangle t2 = new Triangle(t1);


        Point3D centerPoint = new Point3D(0,0,0);
        Vector vector = new Vector(0, 0, -5);
        Ray ray = new Ray(centerPoint, vector);

        List<Point3D> list = new ArrayList<Point3D>();
        list = t2.findIntersections(ray);
        assertEquals(answerList, list);
    }

}

