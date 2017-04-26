package painter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



 public class Painter 
 {
    JButton clearBtn, blackBtn, BlueBtn,greenBtn,redBtn, magentaBtn, undoBtn,redoBtn,penBtn,bucketBtn,saveBtn,plusBtn,minBtn,whiteBtn;
    draw drawArea= new draw();
    
     ActionListener actionListener= new ActionListener() 
     {
        
        public void actionPerformed(ActionEvent e) 
        {
            if(e.getSource()== clearBtn)
            {
                drawArea.clear();
            }else if(e.getSource()== blackBtn)
            {
                drawArea.black();
            }else if(e.getSource()== BlueBtn)
            {
                drawArea.blue();
            }else if(e.getSource()== greenBtn)
            {
                drawArea.green();
            }else if(e.getSource()== redBtn)
            {
                drawArea.red();
            }else if(e.getSource()== magentaBtn)
            {
                drawArea.magenta();
            }else if(e.getSource()==saveBtn)
            {
                try {
                    drawArea.save();
                } catch (IOException ex) {
                    Logger.getLogger(Painter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(e.getSource()==plusBtn)
            {
                drawArea.plus();
            }
            else if(e.getSource()==minBtn)
            {
                drawArea.min();
            }
            else if(e.getSource()==whiteBtn)
            {
                drawArea.white();
            }
            else if(e.getSource()==undoBtn)
            {
                drawArea.undo();
            }
            else if(e.getSource()==redoBtn)
            {
                drawArea.redo();
            }
            else if(e.getSource()==bucketBtn)
            {
                drawArea.bucket();
            }
            
            
        }
    };
    public static void main(String[] args) throws IOException  
    {
      
        new Painter().show();
    }
    public void show() throws IOException
    {
    //drawArea.image= ImageIO.read(new File("c:/users/unouser/desktop/photo.png"));
    // creat main frame
        JFrame frame= new JFrame("Painter");
        Container content = frame.getContentPane();
        // set layout on content pane
        content.setLayout(new BorderLayout());
        // creat draw area
         //draw drawArea= new draw();
        // add to contect pane
        content.add(drawArea, BorderLayout.CENTER);
        
        //creat controls to apply colors and call clear feature
        JPanel controls = new JPanel();
        JPanel down =new JPanel();
        
        JPanel ch= new JPanel();
        penBtn= new JButton("paint brush");
        penBtn.addActionListener(actionListener);
        bucketBtn=new JButton("Bucket");
        bucketBtn.addActionListener(actionListener);
        plusBtn=new JButton("+");
        plusBtn.addActionListener(actionListener);
        minBtn=new JButton("-");
        minBtn.addActionListener(actionListener);
        ch.add(penBtn);
        ch.add(bucketBtn);
        ch.add(plusBtn);
        ch.add(minBtn);

        content.add(ch,BorderLayout.EAST);
        
        JPanel west =new JPanel();
        saveBtn= new JButton("Save");
        saveBtn.addActionListener(actionListener);
        west.add(saveBtn);
        content.add(west,BorderLayout.WEST);

        //down menue
        undoBtn= new JButton("Undo");
        undoBtn.addActionListener(actionListener);
        redoBtn= new JButton("redo");
        redoBtn.addActionListener(actionListener);
        down.add(undoBtn);
        down.add(redoBtn);
        content.add(down,BorderLayout.SOUTH);

         //upper menue
        clearBtn= new JButton("Clear");
        clearBtn.addActionListener(actionListener);
        
        blackBtn= new JButton();
        blackBtn.setBackground(Color.BLACK);
        blackBtn.addActionListener(actionListener);

        BlueBtn= new JButton();
        BlueBtn.setBackground(Color.BLUE);
        BlueBtn.addActionListener(actionListener);

        greenBtn= new JButton();
        greenBtn.setBackground(Color.GREEN);
        greenBtn.addActionListener(actionListener);

        redBtn= new JButton();
        redBtn.setBackground(Color.RED);
        redBtn.addActionListener(actionListener);

        magentaBtn= new JButton();
        magentaBtn.setBackground(Color.MAGENTA);
        magentaBtn.addActionListener(actionListener);
        
        whiteBtn= new JButton();
        whiteBtn.setBackground(Color.WHITE);
        whiteBtn.addActionListener(actionListener);
        // add to panel
        controls.add(greenBtn);
        controls.add(BlueBtn);
        controls.add(blackBtn);
        controls.add(redBtn);
        controls.add(magentaBtn);
        controls.add(whiteBtn);

        //controls.add(clearBtn);
        
        // add to content pane
        content.add(controls,BorderLayout.NORTH);
        frame.setSize(1000, 1000);
        //can close frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //show the swing paint
        frame.setVisible(true);

    }
   
    
}