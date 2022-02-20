package Elements;

import java.awt.Color;

import primitives.Point3D;
import primitives.Vector;

public class SpotLight  extends PointLight
{
    Vector _direction;


    //...............................................c-tors..............................//
    public SpotLight()
    {
        super();
        _direction=new Vector();
    }

    public SpotLight(Color color, Point3D position, Vector direction, double kc, double kl, double kq) {
        super(color, position, kc, kl, kq);
        this._direction = new Vector(direction);
    }

    public SpotLight(SpotLight spotLight)
    {
        super(spotLight._color, spotLight._position, spotLight._kc, spotLight._kl, spotLight._kq);
        _direction=spotLight.get_direction();
    }
    public SpotLight(Color color, Point3D position, Vector direction)
    {
        super();

    }




    //.................................................getters/setters.............................//

    public Vector get_direction()
    {
        return _direction;
    }

    public void set_direction(Vector direction)
    {
        this._direction = new Vector(direction);
    }
    @Override
    public String toString() {
        return "SpotLight [_direction=" + _direction + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        SpotLight other = (SpotLight) obj;
        if (_direction == null) {
            if (other._direction != null)
                return false;
        } else if (!_direction.equals(other._direction))
            return false;
        return true;
    }

//...................................................functions..............................//
    public  Vector getL(Point3D point)
    {
        return super.getL(point);

    }
    public  Color getIntensity(Point3D point)
    {
        Vector L=new Vector(getL(point));
        Vector D=new Vector (_direction);
        L.normalize();
        D.normalize();
        double d=_position.distance(point);
        Color i0=this.get_color();
        double mechane=_kc+_kl*d+_kq*d*d;
        int red=(int)((i0.getRed()*(D.dotProduct(L)))/Math.max(mechane, 1)) ;
        if(red<0)
            red=0;
        red=red>=255?255:red;
        int green=(int)((i0.getGreen()*(D.dotProduct(L)))/Math.max(mechane, 1)) ;
        if(green<0)
            green=0;
        green=green>=255?255:green;
        int blue=(int) ((i0.getBlue()*(D.dotProduct(L)))/Math.max(mechane, 1)) ;
        if(blue<0)
            blue=0;
        blue=blue>=255?255:blue;
        Color il=new Color(red, green, blue);

        return il;
    }



}
