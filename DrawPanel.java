
package paint_test_program;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
//import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.applet.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DrawPanel extends JPanel
{
    public ArrayList<Shape> shapes;
    public ArrayList<Shape> clearedShapes;
    
    
    public enum ShapeType {LINE,RECTANGLE,OVAL,TRIANGLE};
    private int shapeType;
    public Shape currentShape;
    public Shape justCut;
    public Color currentColor ;
    
    private JLabel statusLabel;
    
    
    public DrawPanel()
    {
        shapes = new ArrayList<Shape>(10);
        clearedShapes = new ArrayList<Shape>(10);
        
        
        //setShapeType(ShapeType.LINE);   // initially draw line
        shapeType = getShapeType();
        
        
        
        currentShape = null;
        
        currentColor = Color.BLACK;
        
        setBackground(Color.WHITE);
        
        MouseHandler mouseHandler = new MouseHandler();
        this.addMouseListener(mouseHandler);
        this.addMouseMotionListener (mouseHandler);    
    }
    @Override
    public void paintComponent (Graphics g)
    {
        super.paintComponent(g);
        
        for (int i=0; i< shapes.size(); i++)
        {
            shapes.get(i).draw(g);
        }
        if (currentShape != null)
        {
            currentShape.draw(g);
        }
       
    }
    public void setShapeType (int type)
    {
        shapeType = type;
    }
    public int getShapeType()
    {
      return shapeType;
    }
    
    public void setCurrentColor (Color color)
    {
        currentColor = color;
    }
    
    
    public void undoLastShape()
    {
        if (shapes != null)
        {
                      //remove  a shape then add it to clearedshapes
            clearedShapes.add(shapes.remove(shapes.size()-1));
            repaint();     //called to refresh drawing
        } 
       
    }
    public void clearDrawing()
    {
        shapes.clear();
        repaint();        
    }
    public void RedoLastShape()
    {
        if (clearedShapes != null)
        {     
            shapes.add(clearedShapes.remove(clearedShapes.size()-1));
            repaint();     //called to refresh drawing
        }
        
    }
    public void CopyLastShape()
    {
        if( shapes != null )
        {
        justCut = shapes.get(shapes.size() - 1); 
        currentShape = justCut.copy();
        currentShape.moveBy(10, 20, 10, 10);
        shapes.add(currentShape);
        repaint();
        }
    }
    public void MoveLastShape()
    {
       if( shapes != null )
        {
        justCut = shapes.get(shapes.size() - 1); 
        currentShape = justCut;
        currentShape.moveBy(10, 20, 10, 10);
        shapes.add(currentShape);
        repaint();
        }
       //currentShape.moveShape();
       
    }
    public void DeleteLastShape()
    {
        if (shapes != null)
        {
                      //remove  a shape then add it to clearedshapes
            clearedShapes.add(shapes.remove(shapes.size()-1));
            repaint();     //called to refresh drawing
        }
        repaint();        
    }
    public ArrayList<Shape> getShape()
    {
        return this.shapes;
    }
    
    private class MouseHandler extends MouseAdapter implements MouseMotionListener
    {
        @Override
        public void mousePressed(MouseEvent event)
        {
            switch (shapeType)
            {
                case 0:
                    currentShape = new Line (event.getX(),event.getY(),
                            event.getX(),event.getY(),currentColor);
                    break;
                case 1:
                    currentShape = new Rectangle (event.getX(),event.getY(),
                            event.getX(),event.getY(),currentColor);
                    
                    
                    break;
                case 2:
                    currentShape = new Oval (event.getX(),event.getY(),
                            event.getX(),event.getY(),currentColor);
                    break;
                case 3:
                    currentShape = new Triangle (event.getX(),event.getY(),event.getX(),event.getY(),currentColor);
                    break;
            }
        }
        @Override
        public void mouseReleased(MouseEvent event)
        {
            if(currentShape != null)
            {
                currentShape.setX2(event.getX());
                currentShape.setY2(event.getY());
                
                //add shape to arraylist
                shapes.add(currentShape);
                
                currentShape = null;
                repaint();      //update drawing with new shape
                
            }
        }
        @Override
        public void mouseDragged (MouseEvent event)
        {
            if(currentShape != null)
            {
                currentShape.setX2(event.getX());
                currentShape.setY2(event.getY());
                repaint();        
            }
        }
        @Override
        public void mouseMoved (MouseEvent event)
        {
            
        }
    }
}
