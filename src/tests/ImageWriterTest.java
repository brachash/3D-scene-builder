package tests;

import java.awt.Color;
import org.junit.Test;
import Renderer.ImageWriter;

public class ImageWriterTest {

    @Test
    public void gridTest()
    {
        ImageWriter image = new ImageWriter("image1",500, 500, 500, 500);
        for(int i=0; i<500; i++)
        {
            for(int j = 0; j<500; j++)
            {
                if(i%50 == 0 || j%50 == 0)
                    image.writePixel(i, j, Color.white);
                else
                    image.writePixel(i, j, Color.black);
            }
        }
        image.writeToimage();
    }
}