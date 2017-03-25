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
public class Rectangle extends Shape {
    
    public Rectangle()
    {
    super();
    
    }
    public Rectangle(int x1,int y1,int x2,int y2,Color color)
    {
        super(x1,y1,x2,y2,color);
    }

    @Override
    public void draw(Graphics g) {
       g.setColor (getColor());
       
       g.drawRect( getX1(), getY1(), getX2(), getY2() );
    }
    public void fill(Graphics g)
    {
        g.fillRect(getX1(),getY1(), getX2(), getY2());
        
    }
    @Override
    Shape copy() {
        return new Rectangle(x1,y1,x2,y2,myColor);
    }
    
}
