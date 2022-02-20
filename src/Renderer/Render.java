package Renderer;
import java.awt.Color;

import Renderer.ImageWriter;
import primitives.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Iterator;
import Geometries.*;
import Scene.*;
import Elements.*;
import java.util.Map;
import java.util.Map.Entry;

public class Render
{

    protected Scene _scene;
    protected ImageWriter _imageWriter;
    int RECURSION_LEVEL=3;

    /*...............................constractors...............................*/

    /**
     * c-tor receives Scene,ImageWriter
     * @param Scene1-Scene
     * @param ImageWriter1-ImageWriter
     */
    public Render(Scene Scene1,ImageWriter ImageWriter1)
    {
        this._scene=Scene1;
        this._imageWriter=ImageWriter1;
    }


    /*.........................................getters/setters....................*/

    /**
     * get_scene
     * @return Scene
     */
    public Scene get_scene()
    {
        return new Scene( _scene);
    }


    public void set_scene(Scene scene)
    {
        this._scene = new Scene(scene);
    }

    /**
     * get_imageWriter
     * @return ImageWriter
     */
    public ImageWriter get_imageWriter()
    {
        return _imageWriter;
    }

    /**
     *
     * @param _imageWriter
     */
    public void set_imageWriter(ImageWriter _imageWriter)
    {
        this._imageWriter = new ImageWriter(_imageWriter);
    }
    /*.......................................Color.......................................*/


    public Color addColor(Color color1,Color color2)
    {
        int red=color1.getRed()+color2.getRed();
        red=red>255?255:red;
        int green=color1.getGreen()+color2.getGreen();
        green=green>255?255:green;
        int blue=color1.getBlue()+color2.getBlue();
        blue=blue>255?255:blue;
        return new Color(red, green, blue);
    }

    /**
     * multiply color with scalar
     * @param color-Color
     * @param scale-double
     * @return Color
     */
    public Color scaleColor(Color color,double scale)
    {
        int a=color.getRed();
        a=(int)(a*scale);
        a=a>255?255:a;
        int b=color.getGreen();
        b=(int)(b*scale);
        b=b>255?255:b;
        int c=color.getBlue();
        c=(int)(c*scale);
        c=c>255?255:c;
        Color colorNew= new Color(a,b,c);
        return colorNew;
    }

    /**
     * placment the color
     * @param color-Color
     * @return Color
     */
    public Color putColor(Color color)
    {
        int a=color.getRed();
        a=a>255?255:a;
        int b=color.getGreen();
        b=b>255?255:b;
        int c=color.getBlue();
        c=c>255?255:c;
        Color colorNew= new Color(a,b,c);
        return colorNew;
    }


    /*..........................................functions.....................*/




    /**
     * The function allows the addition of interval to the view plane
     * @param interval-int
     */
    public void printGrid(int interval)
    {
        for(int i=1;i<this._imageWriter.getWidth();i++)
        {
            for(int j=1;j<this._imageWriter.getHeight();j++)
            {
                if((i%interval!=0)&&(j%interval!=0));
                else
                    this._imageWriter.writePixel(i, j, Color.WHITE);
            }
        }
        this._imageWriter.writeToimage();

    }



    private Map<Geometry, ArrayList<Point3D>> getSceneRayIntersections(Ray ray)
    {

        Iterator<Geometry> geometries = this._scene.getGeometriesIterator();
        Map<Geometry, ArrayList<Point3D>> intersectionPoints = new HashMap<Geometry, ArrayList<Point3D>>();
        while (geometries.hasNext())
        {
            Geometry geometry = geometries.next();
            ArrayList<Point3D> geometryIntersectionPoints = (ArrayList<Point3D>) geometry.findIntersections(ray);
            if (!geometryIntersectionPoints.isEmpty())
                intersectionPoints.put(geometry, geometryIntersectionPoints);
        }
        return intersectionPoints;
    }

    /**
     * Returns the closest intersection point of the geometric
     * @param intersectionPoints-Map<Geometry, ArrayList<Point3D>>
     * @return Entry<Geometry, Point3D>
     */
    /////////////////////////////////////


    protected Map<Geometry, Point3D> getClosestPointWithoutSuper(Map<Geometry, List<Point3D>> intersectionPoints) {
        double distance = Double.MAX_VALUE;
        Point3D P0 = _scene.getCamera().getPo();
        Map<Geometry, Point3D> minDistancePoint = new HashMap<Geometry, Point3D>();

        for (Entry<Geometry, List<Point3D>> entry : intersectionPoints.entrySet())
            for (Point3D point : entry.getValue())
                if (P0.distance(point) < distance) {
                    minDistancePoint.clear();
                    minDistancePoint.put(entry.getKey(), new Point3D(point));
                    distance = P0.distance(point);
                }
        //System.out.println(minDistancePoint);
        return minDistancePoint;
    }

    ////////////////////////////////////

    private Entry<Geometry, Point3D> getClosestPoint(Map<Geometry, ArrayList<Point3D>> intersectionPoints)
    {
        double distance = Double.MAX_VALUE;
        Point3D P0 = _scene.getCamera().getPo();
        Map<Geometry, Point3D> minDistancePoint  = new HashMap<Geometry, Point3D>();;
        if(intersectionPoints.isEmpty())
            System.out.println("!! it is empty");
        for (Entry<Geometry, ArrayList<Point3D>> entry : intersectionPoints.entrySet())
        {
            for (Point3D point: entry.getValue())
            {
                if (P0.distance(point) < distance)
                {
                    minDistancePoint.clear();
                    minDistancePoint.put(entry.getKey(), new Point3D(point));
                    distance = P0.distance(point);
                }
            }
        }
        Entry<Geometry,Point3D>entry=minDistancePoint.entrySet().iterator().next();
        return entry;
    }

    /**
     * return defuseLight
     * @param kd-double
     * @param normal-Vector
     * @param vecL-Vector
     * @param intensity-Color
     * @return Color
     */

    private Color calcDiffusiveComp(double kd,Vector normal,Vector vecL,Color intensity)
    {
        normal.normalize();
        vecL.normalize();
        double k= Math.abs(normal.dotProduct(vecL));
        double k1=k*kd;
        if(k1>1)
            k1=1;
        Color defuse=scaleColor(intensity,k1);
        return defuse;
    }

    /**
     * return specularLight
     * @param ks-double
     * @param vector-Vector
     * @param normal-Vector
     * @param vecL-Vector
     * @param shininess-double
     * @param intensity-Color
     * @return Color
     */
    private Color calcSpecularComp(double ks,Vector vector,Vector normal,Vector vecL,double shininess,Color intensity)
    {
        vector.normalize();
        normal.normalize();
        vecL.normalize();
        double R1=vecL.dotProduct(normal);
        Vector R2=normal.scale(R1);
        R2=R2.scale(2);
        Vector R=vecL.substract(R2);
        double k=vector.dotProduct(R);
        if (k<0)
            k=0;
        else
            k=Math.pow(k,shininess);
        double k1=k*ks;
        if(k1>1)
            k1=1;
        if(k1<0)
            k1=0;
        Color specular= scaleColor(intensity,k1);
        return specular;

    }

    /**
     * return ReflectedRay-R
     * @param N-Vector
     * @param point-Point3D
     * @param ray-Ray
     * @return Ray
     */
    private Ray constructReflectedRay(Vector N,Point3D point,Ray ray)
    {
        N.normalize();
        Vector D=new Vector(ray.getDirection());
        D.normalize();
        double x=D.dotProduct(N);
        Vector y=N.scale(x*(-2));
        Vector R=D.add(y);
        Point3D point1 = new Point3D(point);
        point1.add(R);
        return  new Ray(point1,R);
    }

    /**
     * return RefractedRay-R
     * @param N-Vector
     * @param point-Point3D
     * @param D-Ray
     * @return Ray
     */
    private Ray constructRefractedRay(Vector N,Point3D point,Ray D )
    {
        D.getDirection().normalize();
        Vector temp=new Vector(D.getDirection());

        Point3D help=new Point3D(point);
        help.add(temp);
        return new Ray(help,D.getDirection());
    }
    /**
     *
     * return reflectedEntry/refractedEntry Closest intersection point
     * @param R-Ray
     * @return Entry<Geometry, Point3D>
     */
    private Entry<Geometry, Point3D> findClosestIntersection(Ray R)
    {
        Map<Geometry, ArrayList<Point3D>> intersections=getSceneRayIntersections(R);
        if (intersections.isEmpty())
        {
            return null;
        }
        return getClosestPoint(intersections);

    }

    /**
     * print the shadow of a object
     * @param light-Light
     * @param point-Point3D
     * @param geometry-Geometry
     * @return true or fulse
     */
    private boolean occluded(Light light, Point3D point, Geometry geometry)
    {
        Vector lightDirection =new Vector( light.getL(point));
        lightDirection=lightDirection.scale(-1);

        Point3D geometryPoint = new Point3D(point);
        Vector epsVector = new Vector(geometry.getNormal(point));
        epsVector=epsVector.scale(2);
        geometryPoint.add(epsVector);
        Ray lightRay = new Ray(geometryPoint, lightDirection);
        Map<Geometry, ArrayList<Point3D>> intersectionPoints =getSceneRayIntersections(lightRay);
        // Flat geometry cannot self intersect
        if (true)
        {
            intersectionPoints.remove(geometry);
        }
        for (Entry<Geometry, ArrayList<Point3D>> entry: intersectionPoints.entrySet())
            if (entry.getKey().get_material().get_kt() == 0)
                return true;
        return false;
    }

    /**
     * recursive calcColor
     * @param geometry-Geometry
     * @param point-Point3D
     * @param inRay-Ray
     * @return Color
     */
    private Color calcColor(Geometry geometry, Point3D point, Ray inRay)
    {
        return calcColor(geometry, point, inRay, 0);
    }

    /**
     * Calculates the color of the object
     * @param geometry-Geometry
     * @param point-Point3D
     * @return Color
     */
    private Color calcColor(Geometry geometry, Point3D point,Ray inRay,int level )
    {
        if (level == RECURSION_LEVEL) return new Color(0, 0, 0);
        //ambientLight
        Color ambientLight = _scene.getAmbientLight().getIntensity(point);

        //emissionLight
        Color emissionLight = geometry.getEmission();
        Iterator<Light> lights = _scene.getLightsIterator();

        Color diffuseLight = new Color(0,0,0);
        Color specularLight = new Color(0,0,0);
        Color reflectedLight=new Color(0,0,0);
        Color refractedLight=new Color(0,0,0);

        while (lights.hasNext())
        {
            Light light = lights.next();
            if (!this.occluded(light, point, geometry))
            {
                //diffuseLight
                diffuseLight = addColor(diffuseLight, calcDiffusiveComp(geometry.get_material().get_kd(),geometry.getNormal(point),  light.getL(point),  light.getIntensity(point)));

                //specularLight
                specularLight = addColor(specularLight, calcSpecularComp(geometry.get_material().get_ks(),new Vector(point, _scene.getCamera().getPo()),geometry.getNormal(point),  light.getL(point), geometry.get_material().get_nShininess(),  light.getIntensity(point)));
            }

        }

        //Recursive call for a reflected ray
        Ray reflectedRay = new Ray(constructReflectedRay(geometry.getNormal(point), point, inRay));
        Entry<Geometry,Point3D> reflectedEntry= findClosestIntersection(reflectedRay);
        if(reflectedEntry!=null)
        {
            Color reflectedColor = putColor(calcColor(reflectedEntry.getKey(), reflectedEntry.getValue(), reflectedRay,level+1));
            reflectedLight= scaleColor(reflectedColor,geometry.get_material().get_kr());
        }


        // Recursive call for a refracted ray
        Ray refractedRay = new Ray(constructRefractedRay(geometry.getNormal(point), point, inRay));
        Entry<Geometry,Point3D> refractedEntry = findClosestIntersection(refractedRay);
        if(refractedEntry!=null)
        {
            Color refractedColor =putColor(calcColor(refractedEntry.getKey(), refractedEntry.getValue(), refractedRay,level+1));
            refractedLight= scaleColor(refractedColor,geometry.get_material().get_kt());

        }

        int red= ambientLight.getRed()+ emissionLight.getRed()+diffuseLight.getRed()+specularLight.getRed()+reflectedLight.getRed() +refractedLight.getRed();
        red=red>255?255:red;
        int green=ambientLight.getGreen() + emissionLight.getGreen()+diffuseLight.getGreen()+specularLight.getGreen()+reflectedLight.getGreen() +refractedLight.getGreen();
        green=green>255?255:green;
        int blue=ambientLight.getBlue()+ emissionLight.getBlue()+diffuseLight.getBlue()+specularLight.getBlue()+reflectedLight.getBlue() +refractedLight.getBlue();
        blue=blue>255?255:blue;
        Color I0 = new Color (red,green,blue);
        return I0;
    }

////////////////////////////////
public void renderImageWithOutSuper() {
    for (int i = 0; i < this._imageWriter.getHeight(); i++)
        for (int j = 0; j < this._imageWriter.getWidth(); j++) {
            Ray ray = this._scene.getCamera().constructRayThroughPixel(_imageWriter.getNx(), _imageWriter.getNy(), i, j, this._scene.getScreenDistance(),
                            _imageWriter.getWidth(), _imageWriter.getHeight());
            Map<Geometry, List<Point3D>> intersectionPoints = getSceneRayIntersection(ray);
            if (intersectionPoints.isEmpty())
                _imageWriter.writePixel(i, j, this._scene.getBackground());
            else {
                Map<Geometry, Point3D> closestPoint = getClosestPointWithoutSuper(intersectionPoints);
                _imageWriter.writePixel(i, j, calcColor(closestPoint.entrySet().iterator().next().getKey(), closestPoint.entrySet().iterator().next().getValue(), ray));
            }
        }
}

    protected Map<Geometry, List<Point3D>> getSceneRayIntersection(Ray ray) {//for every geometry return the name geometry and list with the intersectionsPoints
        Iterator<Geometry> geometries = this._scene.getGeometriesIterator();
        Map<Geometry, List<Point3D>> intersectionPoints = new HashMap<Geometry, List<Point3D>>();

        while (geometries.hasNext()) {
            Geometry geometry = geometries.next();
            ArrayList<Point3D> geometryIntersectionPoints = (ArrayList<Point3D>) geometry.findIntersections(ray);
            if (!(geometryIntersectionPoints.isEmpty()))
                intersectionPoints.put(geometry, geometryIntersectionPoints);
        }
        return intersectionPoints;
    }

    /////////////////////////////

    /**
     * Produces the actual image and builds with the imageWriter image file
     * with superSumpling improvement
     */
    public void renderImage()
    {
        for(int i=0;i<this._imageWriter.getHeight();i++)
        {
            for(int j=0;j<this._imageWriter.getWidth();j++)
            {
                Ray ray = this._scene.getCamera().constructRayThroughPixel
                        (_imageWriter.getNx(), _imageWriter.getNy(),i,j,this._scene.getScreenDistance(), _imageWriter.getWidth(),_imageWriter.getHeight());
                Map<Geometry, ArrayList<Point3D>> intersectionPoints = getSceneRayIntersections(ray);
                if (intersectionPoints.isEmpty())
                    _imageWriter.writePixel(i,j, this._scene.getBackground());
                else
                {
                    Color color=new Color(0,0,0);

                    //super
                    ArrayList<Ray> raysSuper = this._scene.getCamera().constructRayThroughPixelSuper
                            (_imageWriter.getNx(), _imageWriter.getNy(),i,j,this._scene.getScreenDistance(), _imageWriter.getWidth(),_imageWriter.getHeight());
                    for (Iterator<Ray> iterator = raysSuper.iterator(); iterator.hasNext();)
                    {
                        Ray help = iterator.next();
                        Map<Geometry, ArrayList<Point3D>>intersectionPointsSuper=getSceneRayIntersections(help);
                        if(intersectionPointsSuper.isEmpty())
                        {
                            color=addColor(color,_scene.getBackground());
                        }
                        else
                        {
                            Entry<Geometry,Point3D> closestPoint = getClosestPoint(intersectionPointsSuper);
                            color=addColor(color,calcColor(closestPoint.getKey(),closestPoint.getValue(),help));
                        }
                    }

                    int red=color.getRed()/4;
                    int green=color.getGreen()/4;
                    int blue=color.getBlue()/4;

                    //middle

                    Entry<Geometry,Point3D> closestPoint = getClosestPoint(intersectionPoints);
                    Color middle=calcColor(closestPoint.getKey() ,closestPoint.getValue(), ray);
                    red+= middle.getRed();
                    red=red/2;
                    green+=middle.getGreen();
                    green=green/2;
                    blue+=middle.getBlue();
                    blue=blue/2;
                    Color superSampling=new Color(red, green, blue);
                    _imageWriter.writePixel(i, j, superSampling) ;
                }
            }
        }
    }
}