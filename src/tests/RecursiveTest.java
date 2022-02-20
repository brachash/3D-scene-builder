//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package tests;

import Elements.SpotLight;
import Geometries.Sphere;
import Geometries.Triangle;
import primitives.Material;
import primitives.Point3D;
import primitives.Vector;
import Renderer.ImageWriter;
import Renderer.Render;
import Scene.Scene;
import java.awt.Color;
import org.junit.Test;

public class RecursiveTest {
    public RecursiveTest() {
    }

    @Test
    public void recursiveTest1() {
        Scene scene = new Scene();
        scene.setScreenDistance(200.0D);
        Sphere sphere = new Sphere(500.0D, new Point3D(0.0D, 0.0D, -1000.0D));
        sphere.get_material().set_nShininess(20.0D);
        sphere.setEmmission(new Color(0, 0, 100));
        sphere.get_material().set_kt(0.5D);
        scene.addGeometry(sphere);
        Sphere sphere2 = new Sphere(250.0D, new Point3D(0.0D, 0.0D, -1000.0D));
        sphere2.get_material().set_nShininess(20.0D);
        sphere2.setEmmission(new Color(100, 20, 20));
        sphere2.get_material().set_kt(0.0D);
        scene.addGeometry(sphere2);
        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200.0D, -200.0D, -150.0D), new Vector(2.0D, 2.0D, -3.0D), 0.1D, 1.0E-6D, 5.0E-7D));
        ImageWriter imageWriter = new ImageWriter("OurRecursive Test", 500, 500, 500, 500);
        Render render = new Render(scene, imageWriter);
        render.renderImage();
        imageWriter.writeToimage();
    }

    @Test
    public void jvrecursiveTest() {
        Scene scene = new Scene();
        scene.setScreenDistance(200.0D);
        Sphere sphere = new Sphere(500.0D, new Point3D(0.0D, 0.0D, -1000.0D));
        sphere.get_material().set_nShininess(20.0D);
        sphere.setEmmission(Color.RED);
        sphere.get_material().set_kt(0.5D);
        scene.addGeometry(sphere);
        Sphere sphere2 = new Sphere(250.0D, new Point3D(0.0D, 0.0D, -1000.0D));
        sphere2.get_material().set_nShininess(20.0D);
        sphere2.setEmmission(Color.BLUE);
        sphere2.get_material().set_kt(0.0D);
        scene.addGeometry(sphere2);
        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200.0D, -200.0D, -150.0D), new Vector(2.0D, 2.0D, -3.0D), 0.1D, 1.0E-6D, 5.0E-7D));
        ImageWriter imageWriter = new ImageWriter("YBEAJVRecursive Test", 500, 500, 500, 500);
        Render render = new Render(scene, imageWriter);
        render.renderImage();
        imageWriter.writeToimage();
    }

    @Test
    public void recursiveTest3() {
        Scene scene = new Scene();
        scene.setScreenDistance(200.0D);
        Sphere sphere = new Sphere(new Color(0, 0, 100), 300.0D, new Point3D(-550.0D, -500.0D, -1000.0D));
        Material material = new Material();
        material.set_nShininess(20.0D);
        material.set_kt(0.5D);
        sphere.set_material(new Material(material));
        scene.addGeometry(sphere);
        Sphere sphere2 = new Sphere(new Color(100, 20, 20), 150.0D, new Point3D(-550.0D, -500.0D, -1000.0D));
        Material material2 = new Material();
        material2.set_nShininess(20.0D);
        material2.set_kt(0.0D);
        sphere2.set_material(new Material(material2));
        scene.addGeometry(sphere2);
        Triangle triangle = new Triangle(new Color(20, 20, 20), new Material(), new Point3D(1500.0D, -1500.0D, -1500.0D), new Point3D(-1500.0D, 1500.0D, -1500.0D), new Point3D(200.0D, 200.0D, -375.0D));
        Triangle triangle2 = new Triangle(new Color(20, 20, 20), new Material(), new Point3D(1500.0D, -1500.0D, -1500.0D), new Point3D(-1500.0D, 1500.0D, -1500.0D), new Point3D(-1500.0D, -1500.0D, -1500.0D));
        Material material3 = new Material();
        material3.set_kr(1.0D);
        triangle.set_material(new Material(material3));
        Material material4 = new Material();
        material4.set_kr(0.5D);
        triangle2.set_material(new Material(material4));
        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);
        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200.0D, 200.0D, -150.0D), new Vector(-2.0D, -2.0D, -3.0D), 1.0E-5D, 5.0E-6D, 0.1D));
        ImageWriter imageWriter = new ImageWriter("Recursive Test3", 500, 500, 500, 500);
        Render render = new Render(scene, imageWriter);
        render.renderImage();
        imageWriter.writeToimage();
    }
}
