package Geometries;
import java.awt.Color;
import java.util.List;

import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Cylinder extends RadialGeometry{

    protected Point3D _axisPoint;
    protected Vector _axisDirection;

    // ***************** Constructors ********************** //
    public Cylinder()
    {
        super();
        this._axisPoint = new Point3D();
        this._axisDirection = new Vector();
    }
    public Cylinder(Color color, Material material,double radius, Point3D axisPoint, Vector axisDirection)
    {
        super(color,material,radius);
        this._axisPoint = new Point3D(axisPoint);
        this._axisDirection = new Vector(axisDirection);
    }
    public Cylinder(Cylinder sec)
    {
        super(sec.getColor(), sec.get_material(),sec.getRradius());
        this._axisPoint = new Point3D(sec.getAxisPoint());
        this._axisDirection = new Vector(sec.getAxisDirection());
    }
    // ***************** Getters/Setters ********************** //
    public Point3D getAxisPoint()
    {
        return _axisPoint;
    }

    public void setAxisPoint(Point3D axisPoint)
    {
        this._axisPoint = axisPoint;
    }

    public Vector getAxisDirection()
    {
        return _axisDirection;
    }

    public void setAxisDirection(Vector axisDirection)
    {
        this._axisDirection = axisDirection;
    }

    // ***************** Operations ******************** //

    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cylinder other = (Cylinder) obj;
        if (_axisDirection == null) {
            if (other._axisDirection != null)
                return false;
        } else if (!_axisDirection.equals(other._axisDirection))
            return false;
        if (_axisPoint == null) {
            if (other._axisPoint != null)
                return false;
        } else if (!_axisPoint.equals(other._axisPoint))
            return false;
        return true;
    }
    public String toString()
    {
        return "Cylinder [_axisPoint=" + _axisPoint + ", _axisDirection=" + _axisDirection + "]";
    }

    public Vector getNormal(Point3D sec)
    {
        return this._axisDirection;
    }
    public List<Point3D> findIntersections (Ray myRay)
    {
        return null;
    }

}
