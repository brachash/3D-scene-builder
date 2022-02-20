package primitives;

import java.util.Objects;

public class Point2D {
    protected Coordinate X;
    protected Coordinate Y;

    /********** Constructors ***********/
    public Point2D() {
        this.X = new Coordinate(Coordinate.ZERO);
        this.Y = new Coordinate(Coordinate.ZERO);
    }

    public Point2D(Coordinate X, Coordinate Y) {
        this.X = new Coordinate(X);
        this.Y = new Coordinate(Y);
    }
    public Point2D(Point2D other){
        this.X = new Coordinate(other.getX());
        this.Y = new Coordinate(other.getY());
    }
    public Point2D(double x, double y)
    {
        this.X = new Coordinate(x);
        this.Y = new Coordinate(y);
    }

    /************** Getters/Setters *******/


    public Coordinate getX() { return X; }

    public void setX(Coordinate X) { this.X = new Coordinate(X);
    }
    public void setX(double x)
    {
        this.X = new Coordinate(x);
    }


    public Coordinate getY() {
        return Y;
    }

    public void setY(Coordinate Y) {
        this.Y = new Coordinate(Y);
    }
    public void setY(double y)
    {
        this.Y = new Coordinate(y);
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
        Point2D other = (Point2D) obj;
        if (X == null)
        {
            if (other.X!= null)
                return false;
        } else if (!X.equals(other.X))
            return false;
        if (Y == null)
        {
            if (other.Y != null)
                return false;
        } else if (!Y.equals(other.Y))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }

    @Override
    public String toString() {
        return "Point2D{" +
                "X=" + X +
                ",Y=" + Y +
                '}';
    }

    /************** Operations ***************/
/*
    public Coordinate add(Point2D a) {
        return a.X.add(a.Y);
    }

    public Point2D subtract(Point2D a, Point2D b) {
        Point2D c = new Point2D();
        c.X = a.X.subtract(b.X);
        c.Y = a.Y.subtract(b.Y);
        return c;
    }
    public Point2D mult(Point2D a) {
        Point2D c = new Point2D();
        c.X = a.X.multiply(a.X);
        c.Y = a.Y.multiply(a.Y);
        return c;
    }
    public double distance(Point2D a, Point2D b){
        Point2D c=new Point2D();
        c=subtract(a,b);
        c=mult(c);
        Coordinate res=getX();
        res=add(c);
        return Math.sqrt(res._coord);
    }
*/
}