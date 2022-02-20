package Elements;

import java.awt.Color;
import primitives.Point3D;
import primitives.Vector;

public class AmbientLight {

    protected Color _color;
    protected double _ka;

    public AmbientLight()
    {
        this._color=new Color(255,255,255);//white
        this._ka=0.1;
    }

    public AmbientLight(Color color,double ka)
    {
        this._color=new Color(color.getRed(),color.getGreen(),color.getBlue());
		/*if (ka<=1.0 && ka>=0)
			this._ka=ka;
		else*/
        this._ka = Math.max(0,Math.min(ka,1));//between 0-1
    }

    public AmbientLight(int a,int b,int c)
    {
        this._color = new Color(a,b,c);
        this._ka = 0.1;
    }

    public AmbientLight(AmbientLight a)
    {
        this._color = a.getColor();
        this._ka = a.getKa();
    }

    public Color getColor()
    {
        return _color;
    }

    public void setColor(Color color)
    {
        this._color = color;
    }

    public double getKa()
    {
        return this._ka;
    }

    public void setKa(double ka)
    {
        if (ka<1.0 && ka>0)
            this._ka = ka;
    }


    @Override
    public String toString() {
        return "AmbientLight [_color=" + _color + ", _ka=" + _ka + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AmbientLight other = (AmbientLight) obj;
        if (_color == null) {
            if (other._color != null)
                return false;
        } else if (!_color.equals(other._color))
            return false;
        if (Double.doubleToLongBits(_ka) != Double.doubleToLongBits(other._ka))
            return false;
        return true;
    }

    public Color getIntensity(Point3D point)//return new color
    {
        Color intensity= new Color((int)(this._color.getBlue() * this._ka+this._color.getRed() * this._ka+this._color.getGreen() * this._ka));
        return intensity ;
    }


}
