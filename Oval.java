/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint_test_program;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author user
 */
public class Oval extends Shape {

    public Oval()
    {
     super();
    }
    public Oval(int x1,int y1,int x2,int y2,Color color)
    {
    super(x1,y1,x2,y2,color);
            
    }
            
    @Override
    public void draw(Graphics g) {
       g.setColor (getColor());
       
       g.drawOval( getX1(), getY1(), getX2(), getY2() );
    }

    @Override
    Shape copy() {
        return new Oval(x1,y1,x2,y2,myColor);
        
        
    }
    
    
}
