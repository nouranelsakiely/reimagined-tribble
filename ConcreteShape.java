/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package npaint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Stroke;

/**
 *
 * @author noura
 */
public abstract class ConcreteShape {
    private int x;
    private int y;
    private int length;
    private int width;
    private Color color;
    private Stroke border_type;
    private Color border_color;
    private boolean selected;
    
    public ConcreteShape(){
        this.color = Color.WHITE;
        this.border_color = Color.BLACK;
        this.border_type = new BasicStroke(1);
        this.selected = false;
    }
    
    public ConcreteShape(Color color,Color border_color, Stroke stroke){       
        this.color = color;
        this.border_color = border_color; 
        this.border_type = stroke;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public Color getColor() {
        return color;
    }

    public Stroke getBorder_type() {
        return border_type;
    }

    public Color getBorder_color() {
        return border_color;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setBorder_type(Stroke border_type) {
        this.border_type = border_type;
    }

    public void setBorder_color(Color border_color) {
        this.border_color = border_color;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
