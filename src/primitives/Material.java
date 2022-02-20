package primitives;

import java.util.Objects;

public class Material {
    private double _kd;
    private double _ks;
    private double _kr;
    private double _kt;
    private double _nShininess;

    public Material()
    {
        _kd=1;
        _ks=1;
        _nShininess=19;
        _kr=0;
        _kt=0;
    }
    public Material(double kd1, double kr1, double kt1,double ks1,double nShininess1)
    {
        if(kd1<0)
            _kd=0;
        if(kd1>1)
            _kd=1;
        else
            _kd=kd1;

        if(ks1<0)
            _ks=0;
        if(ks1>1)
            _ks=1;
        else
            _ks=ks1;
        if(kr1<0)
            _kr=0;
        if(kr1>1)
            _kr=1;
        else
            _kr=kr1;

        if(kt1<0)
            _kt=0;
        if(kt1>1)
            _kt=1;
        else
            _kt=kt1;
        if(nShininess1<0)
            _nShininess=0;
        if(nShininess1>1)
            _nShininess=1;
        else
            _nShininess=nShininess1;

    }
    public Material( Material Material1)
    {
        _kd=Material1._kd;
        _ks=Material1._ks;
        _kr=Material1._kr;
        _kt=Material1._kt;
        _nShininess=Material1._nShininess;
    }

    public Material(double kd1, double ks1, double nShininess1) {
    _kd=kd1;
    _ks=ks1;
    _nShininess=nShininess1;
    }

    public double get_kd() { return _kd; }

    public void set_kd(double _kd) { this._kd = _kd; }

    public double get_ks() { return _ks; }

    public void set_ks(double _ks) { this._ks = _ks; }

    public double get_kr(){return _kr;}

    public void set_kr(double _kr){this._kr=_kr;}

    public double get_kt(){return _kt;}

    public void set_kt(double _kt){this._kt=_kt;}

    public double get_nShininess() { return _nShininess; }

    public void set_nShininess(double _nShininess) { this._nShininess = _nShininess; }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Material other = (Material) obj;
        if (Double.doubleToLongBits(_kd) != Double.doubleToLongBits(other._kd))
            return false;
        if (Double.doubleToLongBits(_kr) != Double.doubleToLongBits(other._kr))
            return false;
        if (Double.doubleToLongBits(_ks) != Double.doubleToLongBits(other._ks))
            return false;
        if (Double.doubleToLongBits(_kt) != Double.doubleToLongBits(other._kt))
            return false;
        if (Double.doubleToLongBits(_nShininess) != Double.doubleToLongBits(other._nShininess))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(get_kd(), get_ks(), get_nShininess());
    }

    @Override
    public String toString() { return "Material [_kd=" + _kd + ", _ks=" + _ks + ", _nShininess=" + _nShininess + ", _kr=" + _kr + ", _kt=" + _kt
            + "]";}
}