package Geometries;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Plane extends Geometry implements FlatGeometry{

    protected Point3D _p;
    protected Vector _normal;



    // ***************** Constructors ********************** //
    public Plane()
    {
        super();
        this._p = new Point3D();
        this._normal = new Vector();
    }
    public Plane(Color color, Material material,Point3D p, Vector v)
    {
        super(color,material);
        this._p = new Point3D(p);
        this._normal = new Vector(v);
    }
    public Plane(Plane p)
    {
        super(p._color,p._material);
        this._p = new Point3D(p._p);
        this._normal = new Vector(p._normal);
    }
    public Plane(Point3D _p, Vector _normal) {
        this._p = _p;
        this._normal = _normal;
    }

    // ***************** Getters/Setters ********************** //
    public Point3D get_p() { return this._p; }

    public Vector get_normal() { return this._normal; }
    public void set_p(Point3D _p) { this._p = _p; }
    public void set_normal(Vector _normal) { this._normal = _normal; }


    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Plane other = (Plane) obj;
        if (_p == null) {
            if (other._p != null)
                return false;
        } else if (!_p.equals(other._p))
            return false;
        if (_normal == null) {
            if (other._normal != null)
                return false;
        } else if (!_normal.equals(other._normal))
            return false;
        return true;
    }


    @Override
    public String toString() {
        return "Plane{" +
                "_p=" + _p +
                ", _normal=" + _normal +
                '}';
    }

    public Vector getNormal(Point3D p)
        {
            return this._normal;
        }



   /* public List<Point3D> findIntersections (Ray myRay)
    {
        List<Point3D> list = new ArrayList<Point3D>();
        //System.out.println("this._v"+this._v+"myRay.getDirection()"+myRay.getDirection());
        double vn = myRay.getDirection().dotProduct(this._normal);
        //if the ray is parallel to the plane there is not any intersection point:
        if(vn == 0)
            return list;
        //else:
        Vector vector = new Vector(myRay.getPOO().substract(this._p));
        double t = -(this._normal.dotProduct(vector)) / vn;
        Point3D newPoint = new Point3D(myRay.getDirection().scale(t).getHead());
        System.out.println(myRay.getPOO().add(newPoint));
        list.add(new Point3D(myRay.getPOO().add(newPoint)));
        return list;

    }*/
    public ArrayList<Point3D> findIntersections (Ray Ray1)
    {
//	System.out.println("plane");
        ArrayList<Point3D> intersectionPoints = new ArrayList<Point3D>();
        if(this._normal. dotProduct( Ray1.getDirection())==0)
            return intersectionPoints;
        Vector vector = new Vector(Ray1.getDirection());
        double nv = vector.dotProduct(this._normal);
        if (nv != 0)
        {
            Vector P0 = new Vector(Ray1.getPOO());
            P0=P0.substract(new Vector(this._p));
            double t = -(this._normal.dotProduct(P0) / nv);
            vector= vector.scale(t);
            Point3D newPoint = new Point3D(vector.getHead());
            Point3D point = new Point3D(Ray1.getPOO());
            point=point.add(newPoint);
            if(t<0)
                return intersectionPoints;
            point=point.add(newPoint);
            intersectionPoints.add(point);

        }
        return intersectionPoints;
    }

}