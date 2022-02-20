package tests;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;
import Elements.SpotLight;
import Elements.PointLight;
import Geometries.Sphere;
import Geometries.Triangle;
import primitives.Material;
import primitives.Point3D;
import primitives.Vector;
import Renderer.ImageWriter;
import Renderer.Render;
import Scene.Scene;

public class Lighting {

/*
    @Test
    public void emmissionTest(){

        Scene scene = new Scene();
        scene.setScreenDistance(50);
        scene.addGeometry(new Sphere(50, new Point3D(0.0, 0.0, -50)));

        Triangle triangle = new Triangle(new Point3D( 100, 0, -49),
                new Point3D(  0, 100, -49),
                new Point3D( 100, 100, -49));


        Triangle triangle2 = new Triangle(new Point3D( 100, 0, -49),
                new Point3D(  0, -100, -49),
                new Point3D( 100,-100, -49));
        triangle2.setEmmission(new Color (50, 200, 50));

        Triangle triangle3 = new Triangle(new Point3D(-100, 0, -49),
                new Point3D(  0, 100, -49),
                new Point3D(-100, 100, -49));
        triangle3.setEmmission(new Color (50, 50, 200));

        Triangle triangle4 = new Triangle(new Point3D(-100, 0, -49),
                new Point3D(  0,  -100, -49),
                new Point3D(-100, -100, -49));
        triangle4.setEmmission(new Color (200, 50, 50));

        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);
        scene.addGeometry(triangle3);
        scene.addGeometry(triangle4);

        ImageWriter imageWriter = new ImageWriter("Emmission test", 500, 500, 500, 500);

        Render render = new Render(scene, imageWriter);

        render.renderImage();
        render.printGrid(50);
        render.getImageWriter().writeToimage();
    }



    @Test
    public void spotLightTest2(){

        Scene scene = new Scene();
        scene.setScreenDistance(200);
        Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));
        sphere.get_material().set_nShininess(20);
        sphere.setEmmission(new Color(0, 0, 100));
        scene.addGeometry(sphere);

        Triangle triangle = new Triangle(new Point3D(-125, -225, -260),
                new Point3D(-225, -125, -260),
                new Point3D(-225, -225, -270));

        triangle.setEmmission(new Color (0, 0, 100));
        triangle.get_material().set_nShininess(4);
        scene.addGeometry(triangle);

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150),
                new Vector(2, 2, -3), 0.1, 0.00001, 0.000005));

        ImageWriter imageWriter = new ImageWriter("Spot test 2", 500, 500, 500, 500);

        Render render = new Render(scene, imageWriter);

        render.renderImage();
        render.getImageWriter().writeToimage();

    }


    @Test
    public void spotLightTest(){

        Scene scene = new Scene();
        Sphere sphere = new Sphere(800, new Point3D(0.0, 0.0, -1000));
        sphere.get_material().set_nShininess(20);
        sphere.setEmmission(new Color(0, 0, 100));
        scene.addGeometry(sphere);
        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -100),
                new Vector(2, 2, -3), 0, 0.00001, 0.000005));

        ImageWriter imageWriter = new ImageWriter("Spot test", 500, 500, 500, 500);

        Render render = new Render(scene, imageWriter);

        render.renderImage();
        render.getImageWriter().writeToimage();

    }


    @Test
    public void pointLightTest(){

        Scene scene = new Scene();
        Sphere sphere = new Sphere (800, new Point3D(0.0, 0.0, -1000));
        sphere.get_material().set_nShininess(20);
        sphere.setEmmission(new Color(0, 0, 100));
        scene.addGeometry(sphere);
        scene.addLight(new PointLight(new Color(255,100,100), new Point3D(-200, -200, -100),
                0, 0.00001, 0.000005));

        ImageWriter imageWriter = new ImageWriter("Point test", 500, 500, 500, 500);

        Render render = new Render(scene, imageWriter);

        render.renderImage();
        render.getImageWriter().writeToimage();


    }
    //���
   @Test
    public void spotLightTest3(){


		/*
		 *
		 *
		 *
		Scene scene = new Scene();
		scene.set_screenDistance(50);
		scene.addGeometry(new Sphere(50, new Point3D(0.0, 0.0, -50)));

		Triangle triangle = new Triangle(new Point3D( 100, 0, -49),
				 						 new Point3D(  0, 100, -49),
				 						 new Point3D( 100, 100, -49));


		Triangle triangle2 = new Triangle(new Point3D( 100, 0, -49),
				 			 			  new Point3D(  0, -100, -49),
				 			 			  new Point3D( 100,-100, -49));
		triangle2.setEmmission(new Color (50, 200, 50));

		Triangle triangle3 = new Triangle(new Point3D(-100, 0, -49),
				 						  new Point3D(  0, 100, -49),
				 						  new Point3D(-100, 100, -49));
		triangle3.setEmmission(new Color (50, 50, 200));

		Triangle triangle4 = new Triangle(new Point3D(-100, 0, -49),
				 			 			  new Point3D(  0,  -100, -49),
				 			 			  new Point3D(-100, -100, -49));
		triangle4.setEmmission(new Color (200, 50, 50));

		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		scene.addGeometry(triangle3);
		scene.addGeometry(triangle4);

		ImageWriter imageWriter = new ImageWriter("Emmission test", 500, 500, 500, 500);

		Render render = new Render(scene, imageWriter);

		render.renderImage();
		render.printGrid(50);
		render.get_imageWriter().writeToimage();
		 */
      /*  Scene scene = new Scene();
        scene.setScreenDistance(50);

        Triangle triangle = new Triangle(new Point3D(  3500,  3500, -2000),
                new Point3D( -3500, -3500, -1000),
                new Point3D(  3500, -3500, -2000));

        Triangle triangle2 = new Triangle(new Point3D(  3500,  3500, -2000),
                new Point3D( -3500,  3500, -1000),
                new Point3D( -3500, -3500, -1000));

        //Triangle trianglett = new Triangle(new Point3D( 100, 0, -49),
        //	  new Point3D(  0, -100, -49),
        //  new Point3D( 100,-100, -49));
//trianglett.setEmmission(new Color (50, 200, 50));


        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100),
                new Vector(-2, -2, -3), 0, 0.000001, 0.0000005));


        ImageWriter imageWriter = new ImageWriter("Spot test 3", 500, 500, 500, 500);

        Render render = new Render(scene, imageWriter);

        render.renderImage();
        render.printGrid(50);
        render.getImageWriter().writeToimage();

    }
    //���

    @Test
    public void pointLightTest2(){

        Scene scene = new Scene();
        Sphere sphere = new Sphere(800, new Point3D(0.0, 0.0, -1000));
        sphere.get_material().set_nShininess(20);
        sphere.setEmmission(new Color(0, 0, 100));

        Triangle triangle = new Triangle(new Point3D(  3500,  3500, -2000),
                new Point3D( -3500, -3500, -1000),
                new Point3D(  3500, -3500, -2000));

        Triangle triangle2 = new Triangle(new Point3D(  3500,  3500, -2000),
                new Point3D( -3500,  3500, -1000),
                new Point3D( -3500, -3500, -1000));

        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);

        scene.addLight(new PointLight(new Color(255, 100, 100), new Point3D(200, 200, -100),
                0, 0.000001, 0.0000005));


        ImageWriter imageWriter = new ImageWriter("Point test 2", 500, 500, 500, 500);

        Render render = new Render(scene, imageWriter);

        render.renderImage();
        render.getImageWriter().writeToimage();

    }
*/

    @Test
    public void shadowTest(){

            Scene scene = new Scene();
            Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));
            sphere.get_material().set_nShininess(20);
            sphere.setEmmission(new Color(0, 0, 100));

            scene.addGeometry(sphere);

            Triangle triangle = new Triangle(new Point3D(  3500,  3500, -2000),
                    new Point3D( -3500, -3500, -1000),
                    new Point3D(  3500, -3500, -2000));

            Triangle triangle2 = new Triangle(new Point3D(  3500,  3500, -2000),
                    new Point3D( -3500,  3500, -1000),
                    new Point3D( -3500, -3500, -1000));

            scene.addGeometry(triangle);
            scene.addGeometry(triangle2);

            scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100),
                    new Vector(-2, -2, -3), 0, 0.000001, 0.0000005));


            ImageWriter imageWriter = new ImageWriter("shadow test", 500, 500, 500, 500);

            Render render = new Render(scene, imageWriter);

            render.renderImage();
            render.get_imageWriter().writeToimage();

        }


        @Test
        public void pointLightTest1(){

            Scene scene = new Scene();
            scene.setScreenDistance(100);
            Sphere sphere = new Sphere (new Color(0,0,100),new Material(), 800, new Point3D(0,0,-1000));
            Material m=new Material();
            m.set_nShininess(20);
            sphere.set_material(m);
            scene.addGeometry(sphere);
            scene.addLight(new PointLight(new Color(255,100,100), new Point3D(-200, -200,-100),//-200, -200, -100),
                    0, 0.00001, 0.000005));

            ImageWriter imageWriter = new ImageWriter("Point Test1 new", 500, 500, 500, 500);

            Render render = new Render(scene, imageWriter);

            render.renderImage();
            //	render.printGrid(50);
            imageWriter.writeToimage();

        }


        @Test
        public void pointLightTest2(){
            Scene scene = new Scene();
            scene.setScreenDistance(100);
            Sphere sphere = new Sphere (new Color(0,0,100),new Material(), 800, new Point3D(0,0, -1000));
            Material m=new Material();
            m.set_nShininess(20);
            sphere.set_material(m);


            Triangle triangle = new Triangle(new Color(0,0,0), new Material(), new Point3D(  3500, 3500, -2000),
                    new Point3D( -3500, -3500, -1000),  new Point3D(3500, -3500, -2000) );
            Triangle triangle2 = new Triangle(new Color(0,0,0),new Material(), new Point3D(   3500, 3500, -2000),
                    new Point3D(   -3500, 3500, -1000), new Point3D( -3500, -3500, -1000));

            scene.addGeometry(triangle);
            scene.addGeometry(triangle2);

            scene.addLight(new PointLight(new Color(255,100,100), new Point3D(-200,200, -100),
                    0, 0.000001, 0.0000005));


            ImageWriter imageWriter = new ImageWriter("Point Test2 new", 500, 500, 500, 500);
            Render render = new Render(scene, imageWriter);

            render.renderImage();
            //	render.printGrid(50);
            imageWriter.writeToimage();
        }




        @Test
        public void spotLightTest1(){

            Scene scene = new Scene();
            scene.setScreenDistance(100);
            Sphere sphere = new Sphere (new Color(0,0,100),new Material(),800, new Point3D(0,0, -1000));

            Material m=new Material();
            m.set_nShininess(20);
            sphere.set_material(m);
            scene.addGeometry(sphere);
            sphere.setEmmission(new Color(0, 0, 100));


            scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -100),  new Vector(2, 2, -3),0, 0.00001, 0.000005));
            ImageWriter imageWriter = new ImageWriter("Spot Test1 new", 500, 500, 500, 500);

            Render render = new Render(scene, imageWriter);

            render.renderImage();
            //	render.printGrid(50);
            imageWriter.writeToimage();
        }

        @Test
        public void spotLightTest2(){

            Scene scene = new Scene();
            scene.setScreenDistance(200);

            Sphere sphere = new Sphere (new Color(0,0,100),500, new Point3D(0,0,-1000));

            Material m=new Material();
            m.set_nShininess(20);
            sphere.set_material(m);
            scene.addGeometry(sphere);

            Triangle triangle = new Triangle(new Color (0, 0, 100),
                    new Material(), new Point3D(-125, -225, -260),
                    new Point3D(-225, -125, -260),
                    new Point3D(-225, -225, -270)
            );

            Material m1=new Material();
            m1.set_nShininess(4);
            triangle.set_material(m);
            scene.addGeometry(triangle);

            scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150),
                    new Vector(2, 2, -3),   0.1, 0.00001, 0.000005));

            ImageWriter imageWriter = new ImageWriter("Spot Test2 new", 500, 500, 500, 500);

            Render render = new Render(scene, imageWriter);

            render.renderImage();
            //render.printGrid(50);
            imageWriter.writeToimage();
        }

        @Test
        public void spotLightTest3(){


            Scene scene = new Scene();
            scene.setScreenDistance(100);

            Triangle triangle = new Triangle(new Color(0,0,0),new Material(),
                    new Point3D(  3500,  3500, -2000),
                    new Point3D( -3500, -3500, -1000),
                    new Point3D(  3500, -3500, -2000)
            );



            Triangle triangle2 = new Triangle(new Color(0,0,0),new Material(),
                    new Point3D(  3500,  3500, -2000),
                    new Point3D( -3500,  3500, -1000),
                    new Point3D( -3500, -3500, -1000)
            );

            scene.addGeometry(triangle);
            scene.addGeometry(triangle2);

            scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100),
                    new Vector(-2, -2, -3),0, 0.000001, 0.0000005));


            ImageWriter imageWriter = new ImageWriter("Spot Test3 new", 500, 500, 500, 500);

            Render render = new Render(scene, imageWriter);

            render.renderImage();
            //	render.printGrid(50);
            imageWriter.writeToimage();

        }






    }