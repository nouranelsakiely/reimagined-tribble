/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint_test_program;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

/**
 *
 * @author user
 */
public class Triangle extends Shape{

    public Triangle(){
        super();
    }
   public Triangle(int x1,int y1,int x2,int y2,Color color)
    {
        super(x1,y1,x2,y2,color);
    }
    @Override
    public void draw(Graphics g) {
       g.setColor (getColor());
       Polygon p = new Polygon(new int[] {getX2(),(getX2()+getX1())/2,getX1()}, new int[] {getY2(),(getX2()-getX1())/10,getY1()},3);
       g.drawPolygon(p);
    }

    @Override
    Shape copy() {
        return new Triangle(x1,y1,x2,y2,myColor);
    }
    
}
