package Geometries;
import java.awt.Color;

import primitives.Material;
import primitives.Point3D;
import primitives.Vector;

public abstract class RadialGeometry extends Geometry {

    protected double _radius;

    // ***************** Constructors ********************** //

    public RadialGeometry() {
        super();
        this._radius=0;
    }
    public RadialGeometry(Color color, Material material,double radius)
    {
        super(color,material);
        this._radius = radius;
    }
    public RadialGeometry(double _radius) { this._radius = _radius; }
    public RadialGeometry(RadialGeometry radius)
    {
        super(radius.getColor(),radius.get_material());
        this._radius = radius._radius;
    }

    // ***************** Getters/Setters ********************** //
    public double getRradius() { return _radius; }

    public void setRradius(double _radius) { this._radius = _radius; }

    public abstract Vector getNormal(Point3D sec);

}