package primitives;
import java.util.Objects;
public class Ray {
    private Point3D _POO;
    private Vector _direction;

    public Ray() {
        super();
        _POO=new Point3D();
        _direction=new Vector();
    }
    public Ray(Point3D POO, Vector direction)
    {
        this._POO = new Point3D(POO);
        this._direction = new Vector(direction);
        this._direction.normalize();
    }

    public Ray(Ray other)
    {
        this._POO=new Point3D(other.getPOO());
        this._direction=new Vector(other.getDirection());
        this._direction.normalize();

    }

    // ***************** Getters/Setters ********************** //
    public Point3D getPOO() { return _POO; }

    public Vector getDirection() { return _direction; }

    public void setPOO(Point3D _POO) { this._POO = _POO; }

    public void setDirection(Vector _direction) {
        _direction.normalize();
        this._direction = new Vector(_direction);
    }
    // ***************** Administration  ******************** //
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Ray other = (Ray) obj;
        if (_POO == null) {
            if (other._POO != null)
                return false;
        } else if (!_POO.equals(other._POO))
            return false;
        if (_direction == null) {
            if (other._direction != null)
                return false;
        } else if (!_direction.equals(other._direction))
            return false;
        return true;
    }
    @Override
    public String toString() {
        super.toString();
        return "Ray{" + "_POO=" + _POO + ", _direction=" + _direction + '}';
    }

}