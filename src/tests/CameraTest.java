package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import Elements.Camera;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class CameraTest {


    @Test
    public void testConstructor()
    {
        Point3D P0=new Point3D(0,0,0);
        Vector vUp=new Vector(new Point3D(0,1,0));
        Vector vTo=new Vector(new Point3D(0,0,1));
        Camera camera = new Camera(P0,vUp,vTo);
        Vector vRight = new Vector(-1,0,0);
        assertEquals(vRight, camera.getVRight());
    }

    @Test
    public void testConstructRay1() {

        Vector vup = new Vector(0, 1, 0);
        Vector vto = new Vector(0, 0, -1);
        Point3D p0 = new Point3D();
        Camera camera = new Camera(p0, vup, vto);

        Ray ray = camera.constructRayThroughPixel(3, 3, 3.0, 3.0, 100, 150, 150);
        Point3D centerPoint = new Point3D(100,-100,-100);
        Vector direction = new Vector(0.5773502691896257, -0.5773502691896257, -0.5773502691896257);

        Ray answer = new Ray(centerPoint, direction);
        assertEquals(answer, ray);
    }

}