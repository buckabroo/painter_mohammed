package painter;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

/**
 *
 * @author unouser
 */
 public class draw extends JComponent 
 {
     int x=1;
     //image which we are going to draw
     public Image image;
     // Graphics2D object--> used to draw on
     public Graphics2D g2;
     //mouse coordinates
     private int currentX, currentY, oldX, oldY;
     
     public draw() 
     {
         setDoubleBuffered(false);
         addMouseListener(new MouseAdapter(){
                public void mousePressed(MouseEvent e)
                {
                    // save coordinates x,y when mouse is pressed
                    oldX= e.getX();
                    oldY=e.getY();
                    
                }
         });
         
         addMouseMotionListener(new MouseMotionAdapter(){
             public void mouseDragged(MouseEvent e)
             {
                 //cordinates x,y when drag mouse
                 currentX= e.getX();
                 currentY=e.getY();
                 if (g2!=null)
                 {
                     //draw line if g2 context not null
                     g2.drawLine(oldX, oldY, currentX, currentY);
                     //refresh draw area to repaint
                     repaint();
                     // store cureent coordinates x,y as olds x,y
                     oldX=currentX;
                     oldY=currentY;
                 }
             }
         });
     }

    @Override
    protected void paintComponent(Graphics g) 
    {
        if(image == null)
        {
            //image to draw null--> we creat
            image = createImage(getSize().width,getSize().height);
            g2=(Graphics2D)image.getGraphics();
            //enable antialiasing
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            // clear draw area
            clear();
        }
        g.drawImage(image, 0, 0, null);
    }
    // exposed method
    public void clear()
    {
        g2.setPaint(Color.white);
        // draw white on entire draw area to clear
        g2.fillRect(0, 0, getSize().width, getSize().height);
        g2.setPaint(Color.black);
        repaint();
    }
    public void red()
    {
        g2.setPaint(Color.red);
    }
    public void black()
    {
        g2.setPaint(Color.black);
        
    }
    public void magenta()
    {
       g2.setPaint(Color.magenta);
  
    }
    public void green()
    {
       g2.setPaint(Color.green);
 
    }
    public void blue()
    {
       g2.setPaint(Color.blue);

    }
    public void save() throws IOException 
    {
        ImageIO.write((RenderedImage) image, "PNG", new File("c:/users/unouser/desktop/newPhoto.png") );
    }
    public void plus()
    {
        x=x+1;
         g2.setStroke(new BasicStroke(x));
    }
    public void white()
    {
     g2.setPaint(Color.white);
    }
    public void min()
    {
        x=x-1;
        g2.setStroke(new BasicStroke(x));
    }
    public void redo()
    {
    }
    public void undo()
    {
    }

    void bucket() 
    {
        
    }
 }