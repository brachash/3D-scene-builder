package primitives;

import static primitives.Util.*;

public class Coordinate {
    //private static final double EPSILON = 0.0000001;
    protected double _coord;

    public static Coordinate ZERO = new Coordinate(0.0);

    /********** Constructors ***********/
    public Coordinate(double coord) {
        // if it too close to zero make it zero
        _coord = alignZero(coord);
    }

    public Coordinate(Coordinate other) {
        _coord = other.getCoordinate();
    }

    /************** Getters/Setters *******/

    public double getCoordinate()
    {
        return _coord;
    }

    public void setCoordinate(double coordinate)
    {
        this._coord = coordinate;
    }

    /*************** Admin *****************/
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Coordinate other = (Coordinate) obj;
        if (Double.doubleToLongBits(_coord) != Double.doubleToLongBits(other._coord))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "" + _coord;
    }

    /************** Operations ***************/
    public Coordinate subtract(Coordinate other) {
        return new Coordinate(usubtract(_coord, other._coord));
    }

    public Coordinate add(Coordinate other) {
        return new Coordinate(uadd(_coord, other._coord));
    }

    public Coordinate scale(double num) {
        return new Coordinate(uscale(_coord, num));
    }

    public Coordinate multiply(Coordinate other) {
        return new Coordinate(uscale(_coord, other._coord));
    }



//////////add for me


    public double add1(Coordinate sec)
    {
        return this._coord+sec.getCoordinate();
    }

    /**
     * Subtraction values
     * @param sec
     * @return
     */
    public double substract1(Coordinate sec)
    {
        return this._coord-sec.getCoordinate();
    }

    /**
     *
     * @param sec
     * @return this multiplied by sec
     */
    public double mult1(Coordinate sec)
    {
        return this._coord*sec.getCoordinate();
    }

}
