package Geometries;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Sphere extends RadialGeometry {

    protected Point3D _center;

    public Sphere()
    {
        super();
        this._center = new Point3D();
    }

    public Sphere(Color color, Material material,double radius, Point3D center)
    {
        super(color,material,radius);
        this._center = new Point3D(center);
    }
    public Sphere(Color _color, double radius, Point3D _center)
    {
        super(_color, new Material(), radius);
        this._center = new Point3D(_center);
    }

    public Sphere(Sphere sec)
    {
        super(sec.getColor(),sec.get_material(),sec.getRradius());
        this._center = new Point3D(sec.getCenter());
    }


    public Sphere(double radius, Point3D _center)
    {
        super(new Color(0,0,0),new Material(), radius);
        this._center = new Point3D(_center);
    }

    // ***************** Getters/Setters ********************** //
    public Point3D getCenter()
    {
        return _center;
    }

    public void setCenter(Point3D center)
    {
        this._center = center;
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Sphere other = (Sphere) obj;
        if (_center == null) {
            if (other._center != null)
                return false;
        } else if (!_center.equals(other._center))
            return false;
        return true;
    }
    public String toString()
    {
        return "Sphere [_center=" + _center + "]";
    }

    public Vector getNormal(Point3D p)
    {
        Vector vector = new Vector(_center,p);
        vector.normalize();
        return vector;
    }

    public List<Point3D> findIntersections (Ray myRay)
    {
        List<Point3D> mylist = new ArrayList<Point3D>();
        Point3D p = null, p1 = null, p2 = null;
        Point3D temp=_center.substract(myRay.getPOO());
        Vector L = new Vector(temp);
        double tm = L.dotProduct(myRay.getDirection());
        double d=Math.sqrt(Math.pow(L.length(),2)-Math.pow(tm,2));
        if (d > this._radius)//nothing
            return mylist;
        else
        if(d == this._radius)//only one
        {
            p = new Point3D(myRay.getPOO().add(myRay.getDirection().scale(tm).getHead()));
            mylist.add(p);
            return mylist;
        }
        else//two
        {
            double th = Math.sqrt(this._radius * this._radius - d*d);
            double t1 = tm - th, t2 = tm + th;
            if (t1 > 0)
            {
                p1 = new Point3D(myRay.getPOO().add(myRay.getDirection().scale(t1).getHead()));
                mylist.add(p1);
            }
            if (t2 > 0)
            {
                p2 = new Point3D(myRay.getPOO().add(myRay.getDirection().scale(t2).getHead()));
                mylist.add(p2);
            }
            return mylist;
        }
    }
}