/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint_test_program;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
        
public class Line extends Shape 
{
    
   
    public Line()
    {
        super();
        
    }
    public Line(int x1,int y1,int x2,int y2, Color color)
    {
        super(x1,y1,x2,y2,color); 
        
    }
    
    @Override
    Shape copy()
    {
    return new Line(x1,y1,x2,y2,myColor);
    }
    
    @Override
    public void draw(Graphics g)
    {
       g.setColor (getColor());
       
       g.drawLine( getX1(), getY1(), getX2(), getY2() );
    }

    /*@Override
    public void moveShape() 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates. 
    }*/
    
}
