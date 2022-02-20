package Elements;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.ArrayList;

public class Camera {
    protected Point3D _po;
    protected Vector _vUp;
    protected Vector _vRight;
    protected Vector _vToward;

    // ***************** Constructors ********************** //
    public Camera()
    {
        this._po = new Point3D(0,0,0);
        this._vUp = new Vector(0,1,0);
        this._vToward = new Vector(0,0,-1);
        this._vRight = new Vector(_vToward.crossProduct(_vUp));

    }
    public Camera(Point3D po, Vector vUp, Vector vToward)
    {
        this._po = new Point3D(po);
        this._vUp = new Vector(vUp);
        this._vToward = new Vector(vToward);
        this._vRight = new Vector(_vToward.crossProduct(_vUp));

    }
    public Camera(Point3D po,Vector vUp, Vector vRight,Vector vToward)
    {
        this._po = new Point3D(po);
        this._vUp = new Vector(vUp);
        this._vRight = new Vector(vRight);
        this._vToward = new Vector(vToward);
    }

    public Camera(Camera sec)
    {
        this._po = new Point3D(sec.getPo());
        this._vUp = new Vector(sec.getVUp());
        this._vRight = new Vector(sec.getVRight());
        this._vToward = new Vector(sec.getVToward());
    }
    public Camera(Vector vUp, Vector vToward)
    {
        _po=new Point3D();
        this._vUp = new Vector(vUp);
        this._vToward = new Vector(vToward);
        this._vRight = new Vector(_vToward.crossProduct(_vUp));
    }
    // ***************** Getters/Setters ********************** //

    public Point3D getPo()
    {
        return _po;
    }

    public void setPo(Point3D po)
    {
        this._po = po;
    }

    public Vector getVUp()
    {
        return _vUp;
    }

    public void setVUp(Vector vUp)
    {
        this._vUp = vUp;
    }

    public Vector getVRight()
    {
        return _vRight;
    }

    public void setVRight(Vector vRight)
    {
        this._vRight = vRight;
    }

    public Vector getVToward()
    {
        return _vToward;
    }

    public void setVToward(Vector vToward)
    {
        this._vToward = vToward;
    }

    // ***************** Operations ******************** //

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Camera other = (Camera) obj;
        if (_po == null) {
            if (other._po != null)
                return false;
        } else if (!_po.equals(other._po))
            return false;
        if (_vRight == null) {
            if (other._vRight != null)
                return false;
        } else if (!_vRight.equals(other._vRight))
            return false;
        if (_vToward == null) {
            if (other._vToward != null)
                return false;
        } else if (!_vToward.equals(other._vToward))
            return false;
        if (_vUp == null) {
            if (other._vUp != null)
                return false;
        } else if (!_vUp.equals(other._vUp))
            return false;
        return true;
    }
    public String toString()
    {
        return "Camera po=" + _po + ", _vUp=" + _vUp + ", _vRight=" + _vRight + ", _vToward=" + _vToward + "";
    }

    public Ray constructRayThroughPixel(double d, double e, double x, double y, double screenDist, double screenWidth,double screenHeight)
    {
        double rx=screenWidth/d;
        double ry=screenHeight/e;
        double tempX=(x-(d/2.0))*rx+(rx/2.0);
        double tempY=(y-(e/2.0))*ry+(ry/2.0);
        Vector vec = new Vector(_po.add(_vToward.scale(screenDist)).add(_vRight.scale(tempX).substract(_vUp.scale(tempY))));
        Point3D tempPoint = new Point3D(vec.getHead());
        Ray ray = new Ray(tempPoint, vec);
        return new Ray (new Point3D(0,0,0),vec);
    }

    /**
     * part 11-adding super sumpling
     * Construct  rays through a pixel, 4 rays for superSumpling
     * @param d-double
     * @param e-double
     * @param x-double
     * @param y-double
     * @param screenDist-double
     * @param screenWidth-double
     * @param screenHeight-double
     * @return ArrayList<Ray>
     */
    public ArrayList<Ray> constructRayThroughPixelSuper(double d, double e, double x, double y, double screenDist, double screenWidth, double screenHeight)
    {
        ArrayList<Ray> rays=new ArrayList<Ray>();
        double rx=screenWidth/d;
        double ry=screenHeight/e;
        double tempX=(x-(d/2.0))*rx;
        double tempY=(y-(e/2.0))*ry;

        //point up  right
        double urX=tempX+rx;
        double urY=tempY;
        Vector vec1 = new Vector(_po.add(_vToward.scale(screenDist)).add(_vRight.scale(urX).substract(_vUp.scale(urY))));
        Point3D tempPoint1 = new Point3D(vec1.getHead());
        Ray rayUR = new Ray(tempPoint1, vec1);
        rays.add(rayUR);

        //point down left
        double dlX=tempX;
        double dlY=tempY+ry;
        Vector vec2 = new Vector(_po.add(_vToward.scale(screenDist)).add(_vRight.scale(dlX).substract(_vUp.scale(dlY))));
        Point3D tempPoint2= new Point3D(vec2.getHead());
        Ray rayDL = new Ray(tempPoint2, vec2);
        rays.add(rayDL);

        //point up left
        double ulX=tempX;
        double ulY=tempY;
        Vector vec3 = new Vector(_po.add(_vToward.scale(screenDist)).add(_vRight.scale(ulX).substract(_vUp.scale(ulY))));
        Point3D tempPoint3= new Point3D(vec3.getHead());
        Ray rayUL = new Ray(tempPoint3, vec3);
        rays.add(rayUL);

        //point down right
        double drX=tempX;
        double drY=tempY;
        Vector vec4 = new Vector(_po.add(_vToward.scale(screenDist)).add(_vRight.scale(drX).substract(_vUp.scale(drY))));
        Point3D tempPoint4= new Point3D(vec4.getHead());
        Ray rayDR = new Ray(tempPoint4, vec4);
        rays.add(rayDR);

        return rays;

    }
}
