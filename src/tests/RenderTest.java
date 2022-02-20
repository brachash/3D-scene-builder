package tests;
import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import Elements.DirectionalLight;
import Elements.PointLight;
import Elements.SpotLight;
import Geometries.Sphere;
import Geometries.Triangle;
import primitives.Point3D;
import primitives.Vector;
import Renderer.ImageWriter;
import Renderer.Render;
import Scene.Scene;
import primitives.Material;

public class RenderTest {

    @Test
    public void basicRendering(){
        Material m=new Material();
        Scene scene = new Scene();

        scene.addGeometry(new Sphere(Color.blue,m, 50, new Point3D(0.0, 0.0, -150)));

        Triangle triangle = new Triangle(Color.red,m,new Point3D( 100, 0, -149),
                new Point3D(  0, 100, -149),
                new Point3D( 100, 100, -149));

        Triangle triangle2 = new Triangle(Color.green,m,new Point3D( 100, 0, -149),
                new Point3D(  0, -100, -149),
                new Point3D( 100,-100, -149));

        Triangle triangle3 = new Triangle(Color.orange,m,new Point3D(-100, 0, -149),
                new Point3D(  0, 100, -149),
                new Point3D(-100, 100, -149));

        Triangle triangle4 = new Triangle(Color.pink,m,
                new Point3D(-100, 0, -149),
                new Point3D(  0,  -100, -149),
                new Point3D(-100, -100, -149));

        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);
        scene.addGeometry(triangle3);
        scene.addGeometry(triangle4);

        ImageWriter imageWriter = new ImageWriter("Render test", 500, 500, 500, 500);

        Render render = new Render(scene, imageWriter);

        render.renderImage();
        render.printGrid(50);
        imageWriter.writeToimage();


    }
    @Test
    public void basicRendering1()
    {
        Scene scene = new Scene();
        ImageWriter imageWriter = new ImageWriter("Render test2", 500, 500, 10, 10);

        Render render = new Render(scene, imageWriter);
        render.printGrid(50);
        imageWriter.writeToimage();
    }


}
