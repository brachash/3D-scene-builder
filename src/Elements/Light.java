package Elements;

import java.awt.Color;
import primitives.Point3D;
import primitives.Vector;

public abstract class Light
{

    protected Color _color;


    //..............................................c-tors...................................../////

    Light()
    {
        _color=new Color(0,0,0);
    }

    Light(Color color1)
    {
        int red=color1.getRed();
        red=red>255?255:red;
        int green=color1.getGreen();
        green=green>255?255:green;
        int blue=color1.getBlue();
        blue=blue>255?255:blue;
        _color=new Color(red,green,blue);
    }


    Light(Light light)
    {
        int color1=light.get_color().getRed();
        color1=color1>255?255:color1;
        int color2=light.get_color().getGreen();
        color2=color2>255?255:color2;
        int color3=light.get_color().getBlue();
        color3=color3>255?255:color3;
        _color=new Color (color1,color2,color3);
    }

    /*............................................getters/setters..............................*/


    public Color get_color()
    {
        return _color;
    }


    public void set_color(Color color)
    {
        this._color = color;
    }



    @Override
    public String toString()
    {
        return "Light [_color=" + _color + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Light other = (Light) obj;
        if (_color == null) {
            if (other._color != null)
                return false;
        } else if (!_color.equals(other._color))
            return false;
        return true;
    }


    /*.....................................................functions............................*/
    public abstract Color getIntensity(Point3D point);
    public abstract Vector getL(Point3D point);
}
