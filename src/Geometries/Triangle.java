package Geometries;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import primitives.*;
import primitives.Point3D;

import java.util.Objects;

public class Triangle extends Geometry implements FlatGeometry{
    protected Point3D p1;
    protected Point3D p2;
    protected Point3D p3;
    // ***************** Constructors ********************** //
    public Triangle(){
        super(new Color(0, 0, 0), new Material());
        this.p1 = new Point3D();
        this.p2 = new Point3D();
        this.p3 = new Point3D();
    }

    public Triangle(Point3D p1, Point3D p2, Point3D p3) {
        super(new Color(0, 0, 0), new Material());
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
   }
    public Triangle(Color color, Material material, Point3D p1, Point3D p2, Point3D p3)
    {
        super(color,material);
        this.p1 = new Point3D(p1);
        this.p2 = new Point3D(p2);
        this.p3 = new Point3D(p3);
    }

    public Triangle(Triangle other)
    {
        super(other.getColor(),other.get_material());
        this.p1 = new Point3D(other.getP1());
        this.p2 = new Point3D(other.getP2());
        this.p3 = new Point3D(other.getP3());
    }




    @Override
    public int hashCode() {
        return Objects.hash(getP1(), getP2(), getP3());
    }


    //getters and setters
    public Point3D getP1() { return p1; }

    public Point3D getP2() { return p2; }

    public Point3D getP3() { return p3; }

    public void setP1(Point3D p1) { this.p1 = p1; }

    public void setP2(Point3D p2) { this.p2 = p2; }

    public void setP3(Point3D p3) { this.p3 = p3; }
    @Override
    public String toString() {
        return "Triangle{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                ", p3=" + p3 +
                '}';
    }
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Triangle other = (Triangle) obj;
        if (p1 == null) {
            if (other.p1 != null)
                return false;
        } else if (!p1.equals(other.p1))
            return false;
        if (p2 == null) {
            if (other.p2 != null)
                return false;
        } else if (!p2.equals(other.p2))
            return false;
        if (p3 == null) {
            if (other.p3 != null)
                return false;
        } else if (!p3.equals(other.p3))
            return false;
        return true;
    }
    public Vector getNormal(Point3D p)
    {
        Vector v1 = new Vector(p1,p2);
        Vector v2 = new Vector(p1,p3);
        Vector v = v2.crossProduct(v1);
        v.normalize();
        v.scale(-1);
        return v;
    }
    @Override
    public List<Point3D> findIntersections (Ray ray)
    {
        Vector v = this.getNormal(new Point3D());
        List<Point3D> intersectionPoints = new ArrayList<Point3D>();
        Plane p = new Plane(this.getColor(),this.get_material(),this.p1,v);
        intersectionPoints = p.findIntersections(ray);
        if (intersectionPoints.isEmpty())
            return intersectionPoints;

        Triangle tr1 = new Triangle(this.getColor(),this.get_material(), ray.getPOO(), p1, p2);
        Vector N1 = new Vector(tr1.getNormal(new Point3D()));
        Triangle tr2 = new Triangle(this.getColor(),this.get_material(), ray.getPOO(), p2, p3);
        Vector N2 = new Vector(tr2.getNormal(new Point3D()));
        Triangle tr3 = new Triangle(this.getColor(),this.get_material(), ray.getPOO(), p3, p1);
        Vector N3 = new Vector(tr3.getNormal(new Point3D()));

        Vector v1 = new Vector(intersectionPoints.get(0));
        Vector v2=new Vector(ray.getPOO());
        Vector sign=new Vector(v1.substract(v2));
        if (((sign.dotProduct(N1) >= 0) && (sign.dotProduct(N2) >= 0)
                && (sign.dotProduct(N3) >= 0)) || ((sign.dotProduct(N1) < 0) &&
                (sign.dotProduct(N2) < 0) && (sign.dotProduct(N3) < 0)))
            return intersectionPoints;
        intersectionPoints.clear();
        return intersectionPoints;
    }
}
