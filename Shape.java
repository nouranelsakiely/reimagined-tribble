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
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class Shape extends JPanel
{
    public int x1,y1,x2,y2; 
    public int width,height;
    public Color myColor;   // color of this shape
    
    public Shape()
    {
        this(0,0,0,0,Color.BLACK);  // initialize values with 0
    }
    public Shape(int x1,int y1,int x2,int y2, Color color)
    {
        this.x1=x1;
        this.y1=y1;
        this.x2=x2;
        this.y2=y2;
        this.myColor=color;
    }
    public void setX1(int x1)
    {
        this.x1 = (x1 >= 0 ? x1 : 0);
    }
    public int getX1()
    {
        return x1;
    }
    public void setX2(int x2)
    {
        this.x2 = (x2 >= 0 ? x2 : 0);
    }
    public int getX2()
    {
        return x2;
    }
    public void setY1(int y1)
    {
        this.y1 = (y1 >= 0 ? y1 : 0);
    }
    public int getY1()
    {
        return y1;
    }
    
    public void setY2(int y2)
    {
        this.y2 = (y2 >= 0 ? y2 : 0);
    }
    public int getY2()
    {
        return y2;
    }
   
    public void setColor(Color color)
    {
        this.myColor = color;
    }
    public Color getColor()
    {
        return myColor;
    }
    void moveBy(int dx, int dy,int dx2, int dy2)
    {
        x1 += dx;
        y1 += dy;
        x2 += dx2;
        y2 += dy2;
    }
    public abstract void draw (Graphics g);
    
    //public abstract void moveShape();
    abstract Shape copy();
    
}

