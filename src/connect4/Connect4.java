package connect4;

import java.io.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;

public class Connect4 extends JFrame implements Runnable {
    boolean animateFirstTime = true;
    Image image;
    Graphics2D g;
    Piece ptr;
    int player1value = 0; 
    int player2value = 0;
      int player1total = 0; 
    int player2total = 0;

    public static void main(String[] args) {
        Connect4 frame = new Connect4();
        frame.setSize(Window.WINDOW_WIDTH, Window.WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public Connect4() {
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {

                if (e.BUTTON1 == e.getButton() ) {
                    int x = e.getX()-Window.getX(0);
                    int y = e.getY()-Window.getY(0);
                    if(x>0 && x<Window.getWidth2() && y>0 && y<Window.getHeight2())
               Board.AddPiece(x,y);
//         System.out.println(e.getX()-27/150);
//          System.out.println(e.getY()-69/134);
                }

                if (e.BUTTON3 == e.getButton()) {
                     int x = e.getX()-Window.getX(0);
                    int y = e.getY()-Window.getY(0);
                    if(x>0 && x<Window.getWidth2() && y>0 && y<Window.getHeight2())
                       Board.FlipPiece(x,y);
                     //Board.RemovePiece(x,y); 
                       }
                repaint();
            }
        });
            

    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {

        repaint();
      }
    });

    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseMoved(MouseEvent e) {

        repaint();
      }
    });

        addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {
                if (e.VK_UP == e.getKeyCode()) {
                      
                } else if (e.VK_DOWN == e.getKeyCode()) {
                } else if (e.VK_LEFT == e.getKeyCode()) {
                } else if (e.VK_RIGHT == e.getKeyCode()) {
                } else if (e.VK_ESCAPE == e.getKeyCode()) {
                    reset();
                }
                repaint();
            }
        });
        init();
        start();
    }
    Thread relaxer;
////////////////////////////////////////////////////////////////////////////
    public void init() {
        requestFocus();
    }
////////////////////////////////////////////////////////////////////////////
    public void destroy() {
    }
////////////////////////////////////////////////////////////////////////////
    public void paint(Graphics gOld) {
        if (image == null || Window.xsize != getSize().width || Window.ysize != getSize().height) {
            Window.xsize = getSize().width;
            Window.ysize = getSize().height;
            image = createImage(Window.xsize, Window.ysize);
            g = (Graphics2D) image.getGraphics();
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
        }
//fill background
        
        g.setColor(Color.cyan);
        g.fillRect(0, 0, Window.xsize, Window.ysize);

        int x[] = {Window.getX(0), Window.getX(Window.getWidth2()), Window.getX(Window.getWidth2()), Window.getX(0), Window.getX(0)};
        int y[] = {Window.getY(0), Window.getY(0), Window.getY(Window.getHeight2()), Window.getY(Window.getHeight2()), Window.getY(0)};
//fill border
        g.setColor(Color.white);
        g.fillPolygon(x, y, 4);
// draw border
        g.setColor(Color.red);
        g.drawPolyline(x, y, 5);

        if (animateFirstTime) {
            gOld.drawImage(image, 0, 0, null);
            return;
        }
        
        Board.Draw(g);
        if(Board.CheckWin()){
             g.setColor(Color.cyan);
    g.setFont(new Font("Andy",Font.PLAIN,40));
     if (Player.GetCurrentPlayer().getColor() == Color.black){
    g.drawString("player 1 WIN", 150,120);
     player1value = Board.getPlayerTotal();
     }
      else {
   g.drawString("player 2 WIN 'black'", 150,120);
       player2value = Board.getPlayerTotal();
     }
        }
         
    //    ptr.draw(g, 4, 2,75,67);
    g.setColor(Color.BLACK);
    g.setFont(new Font("Andy",Font.PLAIN,20));
    if (Player.GetCurrentPlayer().getColor() == Color.red)
   g.drawString("player 1 turn 'red'", 200,65);
    else 
   g.drawString("player 2 turn 'black'", 200,65);
  g.setColor(Color.BLACK);
    g.setFont(new Font("Andy",Font.PLAIN,20));
    g.drawString("player 2: " + player2total  , 400,65);
    g.drawString("player 1: " + player1total , 50,65);
    
        gOld.drawImage(image, 0, 0, null);
    }

////////////////////////////////////////////////////////////////////////////
// needed for     implement runnable
    public void run() {
        while (true) {
            animate();
            repaint();
            double seconds = .1;    //time that 1 frame takes.
            int miliseconds = (int) (1000.0 * seconds);
            try {
                Thread.sleep(miliseconds);
            } catch (InterruptedException e) {
            }
        }
    }
    
/////////////////////////////////////////////////////////////////////////
    public void reset() {
        Board.Reset();
        Player.Reset();
            player1total+=player1value;
       player2total+=player2value;
       player1value = 0;
       player2value = 0;
         
    }
/////////////////////////////////////////////////////////////////////////
    public void animate() {

        if (animateFirstTime) {
            animateFirstTime = false;
            if (Window.xsize != getSize().width || Window.ysize != getSize().height) {
                Window.xsize = getSize().width;
                Window.ysize = getSize().height;
            }

            reset();

        }
//        if(!Board.player1())
//               Board.Animate();
//          if(!Board.player2() )
//               Board.Animate2();
    }

////////////////////////////////////////////////////////////////////////////
    public void start() {
        if (relaxer == null) {
            relaxer = new Thread(this);
            relaxer.start();
        }
    }
////////////////////////////////////////////////////////////////////////////
    public void stop() {
        if (relaxer.isAlive()) {
            relaxer.stop();
        }
        relaxer = null;
    }

}

 

 