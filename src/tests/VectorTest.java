package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import primitives.Vector;

public class VectorTest {

    @Test
    public void testAdd()
    {
        Vector v1=new Vector(1.0,1.0,1.0);
        Vector v2=new Vector(2.0,2.0,2.0);
        Vector check=v1.add(v2);
        Vector v3=new Vector(3.0,3.0,3.0);
        assertEquals(v3,check);
    }

    @Test
    public void testSubtract()
    {
        Vector v1=new Vector(5.0,5.0,5.0);
        Vector v2=new Vector(2.0,2.0,2.0);
        Vector check=v1.substract(v2);
        Vector v3=new Vector(3.0,3.0,3.0);
        assertEquals(v3,check);
    }

    @Test
    public void testScaling()
    {
        Vector v1=new Vector(5.0,5.0,5.0);
        Vector v2=new Vector(10.0,10.0,10.0);
        assertEquals(v2,v1.scale(2));
    }

    @Test
    public void testCrossProduct()
    {
        Vector v1=new Vector(1,2,3);
        Vector v2=new Vector(2,3,4);
        Vector v4=new Vector();
        v4=v1.crossProduct(v2);
        Vector v3=new Vector(-1,2,-1);
        assertEquals(v3,v4);
    }

    @Test
    public void testLength()
    {
        Vector v1=new Vector(1,2,3);
        double lenght=Math.sqrt(14);
        assertEquals(lenght,v1.length(),0.0);
    }

    @Test
    public void testNormalize()
    {
        Vector v1=new Vector(1,2,3);
        double lenght=Math.sqrt(14);
        Vector v3=new Vector(1/lenght,2/lenght,3/lenght);
        v1.normalize();
        assertEquals(v3.toString(),v1.toString());
    }

    @Test
    public void testDotProduct()
    {
        Vector v1=new Vector(5.0,5.0,5.0);
        Vector v2=new Vector(2.0,2.0,2.0);
        double ans=v1.dotProduct(v2);
        assertEquals(30,ans,0.01);
    }

    @Test
    public void VectorDotProduct2()
    {
        Vector temp1 = new Vector(3.0,3.0,3.0);
        Vector temp2 = new Vector(3.0,3.0,3.0);
        double help = temp1.dotProduct(temp2);
        double temp3 = 27;
        assertEquals(temp3,help, 0.0);
    }

}
