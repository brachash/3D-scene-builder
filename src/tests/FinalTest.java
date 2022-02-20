
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package tests;
import Elements.Light;
import Elements.DirectionalLight;

import Elements.SpotLight;
import Geometries.Sphere;
import Geometries.Plane;

import Geometries.Triangle;
import primitives.*;
import Renderer.ImageWriter;
import Renderer.Render;
import Scene.Scene;
import java.awt.Color;
import org.junit.Test;
import primitives.Point3D;
import primitives.Vector;

public class FinalTest {
    public FinalTest() {
    }

   @Test
    public void finalTest() {
        Scene scene = new Scene();
        scene.setScreenDistance(100);
        scene.setBackground(new Color(0,0,0));

        Sphere s3=new Sphere(new Color(254, 248, 68),new Material(),120,new Point3D(60,100,-210));
        Sphere s4=new Sphere(new Color(180,215,215),new Material(),120,new Point3D(-60,100,-210));
        Sphere s5=new Sphere(new Color(255,204,229),new Material(),120,new Point3D(0,150,-210));
        Material m=new Material();
        m.set_kr(0.9);

        Sphere s111=new Sphere(new Color(102,51,0),new Material(),40,new Point3D(60,-1000,-210));
        Plane p = new Plane(new Color(33, 33, 33),m, new Point3D(0, -700 , 0),new Vector(0,-1,0));
        scene.addGeometry(p);

        for(int i=0;i<80;i++) {
            scene.addGeometry(new Sphere(new Color(222, 143, 34),new Material(),20+i*2,new Point3D(0,-700+i*10,-300)));
        }
        scene.addGeometry(s3);
        scene.addGeometry(s4);
        scene.addGeometry(s5);

       scene.addGeometry(s111);

        Light L=new DirectionalLight(new Color(70,70,70),new Vector(1,-1,0));
        scene.addLight(L);

        ImageWriter imageWriter = new ImageWriter("final test1", 500, 500, 500, 500);
        Render render = new Render(scene, imageWriter);
        render.renderImageWithOutSuper();
        //render.printGrid(50);
        render.get_imageWriter().writeToimage();
    }

}