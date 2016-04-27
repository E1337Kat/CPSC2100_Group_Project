/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
*  Most credit for this code goes to :
*  http://java-demos.blogspot.in/2012/09/setting-background-image-in-jframe.html
*  I did add in a little bit of my own additions in file locating
*  and the actual file.
*/
package GUIPackage;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.JPanel;
/**
 *
 * @author Ellie Peterson
 */

/**
 *   The purpose of this class is to simply provide
 *   a background image on the panels that hold all 
 *   the real data.
 */
public class JPanelwithBackground extends JPanel {
    private final Image backgroundImage;

    // Some code to initialize the background image.
    // Here, we use the constructor to load the image. This
    // can vary depending on the use case of the panel.
    public JPanelwithBackground() throws IOException {
        
        //Sets the background image from the relative path and *should* work on any given system ideally...
        ClassLoader cl = getClass().getClassLoader();
        String fileName = File.separator + "res" + File.separator + "Background.png";
        InputStream ir = getClass().getResourceAsStream(fileName);
        ImageInputStream imageInput = ImageIO.createImageInputStream(ir);
        BufferedImage bufImage = ImageIO.read(imageInput);
        backgroundImage = bufImage;
    }

    /*
    *    This method 
    *
    *
    */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the background image.
        g.drawImage(backgroundImage, 0, 0, this);
    }
}
