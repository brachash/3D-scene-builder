package Elements;

import java.awt.Color;

import primitives.Point3D;
import primitives.Vector;

public class PointLight extends Light
{

    protected Point3D _position;
    protected double _kc;
    protected double _kl;
    protected double _kq;
    PointLight()
    {
        super();
        _position=new Point3D();
        _kc=1;
        _kl=0;
        _kq=0;
    }
   public PointLight(Color color1,Point3D Point3D1,double a,double b,double c)
    {
        super(color1);
        _position=new Point3D(Point3D1);
        if(a<0)
            _kc=0;
        if(a>1)
            _kc=1;
        else
            _kc=a;

        if(b<0)
            _kl=0;
        if(b>1)
            _kl=1;
        else
            _kl=b;

        if(c<0)
            _kq=0;
        if(c>1)
            _kq=1;
        else
            _kq=c;
    }
    PointLight(PointLight pointLight)
    {
        _position=pointLight.get_position();
        _kc=pointLight.get_kc();
        _kl=pointLight.get_kl();
        _kq=pointLight.get_kq();
    }

    public Point3D get_position()
    {
        return _position;
    }

    public void set_position(Point3D position)
    {
        this._position = new Point3D(position);
    }

    public double get_kc()
    {
        return _kc;
    }

    public void set_kc(double kc)
    {
        this._kc = kc;
    }

    public double get_kl()
    {
        return _kl;
    }

    public void set_kl(double kl)
    {
        this._kl = kl;
    }

    public double get_kq()
    {
        return _kq;
    }

    public void set_kq(double kq)
    {
        this._kq = kq;
    }

    @Override
    public String toString() {
        return "PointLight [_position=" + _position + ", _kc=" + _kc + ", _kl=" + _kl + ", _kq=" + _kq + "]";
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        PointLight other = (PointLight) obj;
        if (Double.doubleToLongBits(_kc) != Double.doubleToLongBits(other._kc))
            return false;
        if (Double.doubleToLongBits(_kl) != Double.doubleToLongBits(other._kl))
            return false;
        if (Double.doubleToLongBits(_kq) != Double.doubleToLongBits(other._kq))
            return false;
        if (_position == null) {
            if (other._position != null)
                return false;
        } else if (!_position.equals(other._position))
            return false;
        return true;
    }

    public Color getIntensity(Point3D point)
    {
        double d=_position.distance(point);
        Color i0=this.get_color();
        double mechane=_kc+_kl*d+_kq*d*d;
        double red=i0.getRed()/mechane;
        red=red>255?255:red;
        red=red<0?0:red;
        double green=i0.getGreen()/Math.max(mechane, 1);
        green=green>255?255:green;
        green=green<0?0:green;
        double blue=i0.getBlue()/Math.max(mechane, 1);
        blue=blue>255?255:blue;
        blue=blue<0?0:blue;
        Color il=new Color((int)red,(int)green,(int)blue);
        return il;
    }

    public  Vector getL(Point3D point)
    {
        Vector l=new Vector(_position,point);
        l.normalize();
        return l;

    }


}
