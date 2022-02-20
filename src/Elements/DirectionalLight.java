package Elements;

import java.awt.Color;

import primitives.Point3D;
import primitives.Vector;

public class DirectionalLight extends Light {
    protected Vector _direction;

    DirectionalLight() {
        super();
        _direction = new Vector(0,0,1);
    }


    public DirectionalLight(Color color1, Vector vector1) {
        super(color1);
        _direction = new Vector(vector1);
    }
    DirectionalLight(DirectionalLight directionalLight)
    {
        _direction=directionalLight.get_direction();
    }

    public Vector get_direction() {
        return _direction;
    }


    public void set_direction(Vector direction) {
        this._direction = direction;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        DirectionalLight other = (DirectionalLight) obj;
        if (_direction == null) {
            if (other._direction != null)
                return false;
        } else if (!_direction.equals(other._direction))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "DirectionalLight [_direction=" + _direction + "]";
    }

    public Color getIntensity(Point3D point)
    {
        return _color;
    }

    public  Vector getL(Point3D point)
    {
        Vector normal=new Vector(_direction);
        normal.normalize();
        return normal;
    }

}
