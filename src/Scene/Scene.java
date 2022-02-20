package Scene;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Elements.AmbientLight;
import Elements.Camera;
import Elements.Light;
import Geometries.Geometry;

public class Scene {

    protected String _sceneName;
    protected Color _background;
    protected AmbientLight _ambientLight;
    protected List<Geometry> _geometries;
    protected Camera _camera;
    protected double _screenDistance;
    protected ArrayList <Light> _lights;

    // ***************** Constructors ********************** //
    /**
     * default constructor
     */
    public Scene()
    {
        this._sceneName = " ";
        this._background = Color.black;
        this._ambientLight = new AmbientLight();
        this._geometries = new ArrayList<Geometry>();
        this._camera = new Camera();
        this._screenDistance = 150;
        this._lights=new ArrayList<Light>();

    }

    public Scene(String sceneName, Color background, AmbientLight ambientLight,
                 Camera camera, double screenDistance,ArrayList<Light> lights)
    {
        this._sceneName = sceneName;
        this._background = background;
        this._ambientLight = new AmbientLight(ambientLight);
        this._geometries = new ArrayList<Geometry>();
        this._camera = camera;
        this._screenDistance = screenDistance;
        this._lights=new ArrayList<Light>(lights);

    }

    public Scene(Scene s)
    {
        this._sceneName = s.getSceneName();
        this._background = s.getBackground();
        this._ambientLight = s.getAmbientLight();
        this._geometries = s.getGeometries();
        this._camera = s.getCamera();
        this._screenDistance = s.getScreenDistance();
        this._lights=new ArrayList<Light>(s._lights);

    }


    public String getSceneName()
    {
        return _sceneName;
    }

    public void setSceneName(String sceneName)
    {
        if (sceneName == null)
            _sceneName = new String();
        else
            this._sceneName = new String(sceneName);
    }

    public Color getBackground()
    {
        return new Color(_background.getRGB());
    }


    public void setBackground(Color background)
    {
        if (_background == null)
            this._background = new Color(255,255,255);
        else
            this._background =new Color(background.getRGB());
    }
    public AmbientLight getAmbientLight() {return  _ambientLight; }

    public void set_ambientLight(AmbientLight ambientLight)
    {
        this._ambientLight = ambientLight;
    }

    public ArrayList<Geometry> getGeometries()
    {
        ArrayList<Geometry> list = new ArrayList<Geometry>();
        for (Iterator<Geometry> iterator = this._geometries.iterator(); iterator.hasNext();)
        {
            Geometry next = iterator.next();
            list.add(next);
        }
        return list;
    }
    public void setGeometries(ArrayList<Geometry> geometries)
    {
        if(geometries == null)
            this._geometries = new ArrayList<Geometry>();
        this._geometries = new ArrayList<Geometry>(geometries);
    }
    public Camera getCamera()
    {
        return new Camera(_camera);
    }

    public void setCamera(Camera camera)
    {
        this._camera = new Camera(camera);
    }

    public double getScreenDistance()
    {
        return _screenDistance;
    }

    public void setScreenDistance(double screenDistance)
    {
        this._screenDistance = screenDistance;
    }

    public ArrayList<Light> get_lights()
    {
        return _lights;
    }

    public void set_lights(ArrayList<Light> lights)
    {
        this._lights = lights;
    }


    public void addGeometry(Geometry geomtry)
    {
        this._geometries.add(geomtry);
    }

    public List<Geometry> addGeometryreturn(Geometry geometries)
    {
        this._geometries.add(geometries);
        return _geometries;
    }

    public Iterator<Geometry>getGeometriesIterator()
    {
        return _geometries.iterator();
    }

    public List<Light> addLights (Light light )
    {
        this._lights.add(light);
        return this._lights;

    }

    public void addLight(Light lights)
    {
        this._lights.add(lights);
    }

    public Iterator<Light>getLightsIterator()
    {
        return _lights.iterator();
    }
}