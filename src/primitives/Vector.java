package primitives;
import java.util.Objects;

public class Vector {
   protected Point3D head;

    /********** Constructors ***********/
    public Vector() {
        this.head = new Point3D();
    }

    public Vector(Point3D point) {
        this.head = new Point3D(point);
    }

    public Vector(Point3D pt1, Point3D pt2) {

        setHead(new Point3D(
                pt2.getX().subtract(pt1.getX()),
                pt2.getY().subtract(pt1.getY()),
                pt2.getZ().subtract(pt1.getZ())));
    }

    public Vector(double x, double y, double z) {
        this.head = new Point3D(x, y, z);
    }

    public Vector(Vector other) {
        setHead(other.getHead());
    }

    /************** Getters/Setters *******/
    public Point3D getHead() {
        return new Point3D(head);
    }

    public void setHead(Point3D _head)
    {
        this.head = new Point3D(_head);
    }

    // ***************** Administration  ******************** //

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vector other = (Vector) obj;
        if (head == null) {
            if (other.head != null)
                return false;
        } else if (!head.equals(other.head))
            return false;
        return true;
    }


    @Override
    public int hashCode() {
        return Objects.hash(getHead());
    }

    @Override
    public String toString() {
        return "Vector{" +
                "head=" + head +
                '}';
    }

    /************** Operations ***************/
    public Vector add(Vector v)
    {
        Point3D help =head.add(v.getHead());
        return new Vector(help);
    }

    public Vector substract(Vector v)
    {
        Point3D help =head.substract(v.getHead());
        return new Vector(help);
    }

    public Vector scale(double scalingFactor)
    {
        Coordinate helpX=new Coordinate(scalingFactor*head.getX().getCoordinate());
        Coordinate helpY=new Coordinate(scalingFactor*head.getY().getCoordinate());
        Coordinate helpZ=new Coordinate(scalingFactor*head.getZ().getCoordinate());
        Point3D temp=new Point3D(helpX,helpY,helpZ);
        return new Vector(temp);
    }

    public Vector crossProduct(Vector v)
    {
        Point3D cross = new Point3D();

        double coord1=(this.head.Y.mult1(v.head.Z));
        double coord2=(this.head.Z.mult1(v.head.Y));
        cross.setX(coord1-coord2);

        coord1=(this.head.Z.mult1(v.head.X));
        coord2=(this.head.X.mult1(v.head.Z));
        cross.setY(coord1-coord2);

        coord1=(this.head.X.mult1(v.head.Y));
        coord2=(this.head.Y.mult1(v.head.X));
        cross.setZ(coord1-coord2);

        return new Vector(cross);
    }
    public double dotProduct(Vector vector)
    {
        double dotX= head.X.mult1(vector.head.X);
        double dotY= head.Y.mult1(vector.head.Y);
        double dotZ= head.Z.mult1(vector.head.Z);
        return dotX+dotY+dotZ;
    }

    public double length()
    {
        Point3D first000 = new Point3D(0,0,0);
        return this.head.distance(first000);

    }
    public void normalize(){
        double temp=length();
        if (temp==0) return;
        head.setX(head.getX().getCoordinate()/temp);
        head.setY(head.getY().getCoordinate()/temp);
        head.setZ(head.getZ().getCoordinate()/temp);
    }
}