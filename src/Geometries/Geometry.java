package Geometries;
import java.awt.Color;
import java.util.List;
import java.awt.Color;
import java.util.List;

import primitives.*;

import primitives.Vector;
public abstract class Geometry {
    protected Color _color;
    protected Material _material;

    // ***************** Constructors ********************** //

    public Geometry()
    {
        this._color = new Color(0);
        this._material=new Material();
    }

    public Geometry(int color,double kd1,double ks1,double nShininess1)
    {
        this._color = new Color(color);
        this._material= new Material(kd1,ks1,nShininess1);

    }

    public Geometry(Color color,Material material1)

    {
        this._color = color;
        this._material= new Material(material1);

    }


    // ***************** Getters/Setters ********************** //
    public Color getColor()
    {
        return _color;
    }

    public void setColor(Color color)
    {
        this._color = color;
    }

    public Material get_material()
    {
        return _material;
    }

    public void set_material(Material material)
    {
        this._material = material;
    }



    // ***************** Operations ******************** //


    @Override
    /**
     * Print the details of the object
     */
    public String toString()
    {
        return "Geometry [_color=" + _color + ", _material=" + _material + "]";
    }


    @Override
    /**
     * @return true if the @param obj equals to this.
     */
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Geometry other = (Geometry) obj;
        if (_color == null) {
            if (other._color != null)
                return false;
        } else if (!_color.equals(other._color))
            return false;
        if (_material == null) {
            if (other._material != null)
                return false;
        } else if (!_material.equals(other._material))
            return false;
        return true;    }

    public abstract Vector getNormal(Point3D sec);

    public abstract List<Point3D> findIntersections (Ray myRay);
    public Color getEmission() {
        return this._color;
    }
    public void setEmmission(Color color1)
    {
        this._color = color1;
    }


}