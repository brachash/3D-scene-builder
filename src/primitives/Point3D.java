package primitives;
import java.util.Objects;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Point3D extends Point2D{
    protected Coordinate Z;

    /********** Constructors ***********/

    public Point3D() {
        super();
        this.Z = new Coordinate(Coordinate.ZERO);
    }
    public Point3D(Coordinate x, Coordinate y, Coordinate z) {
        super(x, y);
        this.Z = new Coordinate(z);
    }
    public Point3D(double x, double y, double z) {
        super(x,y);
        this.Z = new Coordinate(z);
    }
    public Point3D(Point3D other) {
        super(other.getX(),other.getY());
        this.Z = new Coordinate(other.Z);
    }

    /************** Getters/Setters *******/
    public Coordinate getZ() {
        return Z;
    }

    public void setZ(Coordinate z) {
        this.Z = z;
    }
    public void setZ(double z){this.Z=new Coordinate(z);}// ***************** Administration  ******************** //
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!super.equals(o))
            return false;
        if (getClass() != o.getClass())
            return false;
        Point3D other = (Point3D) o;
        if (Z == null) {
            if (other.Z != null)
                return false;
        } else if (!Z.equals(other.Z))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getZ());
    }

    @Override
    public String toString() {
        return "Point3D{" +
                "Z=" + Z +
                ", X=" + X +
                ", Y=" + Y +
                '}';
    }
    /************** Operations ***************/
    public Vector substract(Vector v)
    {
        double x = this.X.substract1(v.getHead().getX());
        double y = this.Y.substract1(v.getHead().getY());
        double z = this.Z.substract1(v.getHead().getZ());
        return new Vector(x,y,z);
    }

    public Point3D substract(Point3D temp)
    {
        Point3D help= new Point3D();
        help.setX(new Coordinate(X.getCoordinate()-temp.getX().getCoordinate()));
        help.setY(new Coordinate(Y.getCoordinate()-temp.getY().getCoordinate()));
        help.setZ(new Coordinate(Z.getCoordinate()-temp.getZ().getCoordinate()));
        return help;

    }


    public Vector add(Vector v) {
        double x = this.X.add1(v.getHead().getX());
        double y = this.Y.add1(v.getHead().getY());
        double z = this.Z.add1(v.getHead().getZ());
        return new Vector(x,y,z);

    }
    public Point3D add(Point3D temp)
    {
        Point3D help= new Point3D();
        help.setX(new Coordinate(X.getCoordinate()+temp.getX().getCoordinate()));
        help.setY(new Coordinate(Y.getCoordinate()+temp.getY().getCoordinate()));
        help.setZ(new Coordinate(Z.getCoordinate()+temp.getZ().getCoordinate()));
        return help;

    }
    public double distance(Point3D p)
    {
        double x=Math.pow(this.X._coord-p.X._coord,2);
        double y=Math.pow(this.Y._coord-p.Y._coord,2);
        double z=Math.pow(this.Z._coord-p.Z._coord,2);
        return Math.sqrt(x+y+z);
    }

}


