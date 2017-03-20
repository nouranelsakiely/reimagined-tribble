package npaint;

import java.awt.Color;
import java.awt.Stroke;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author noura
 */
public class Circle extends ConcreteShape implements Shape{
    protected int radius;

    public Circle() {
    }

    public Circle(Color color, Color border_color, Stroke stroke) {
        super(color, border_color, stroke);
    }
    
    @Override
    public void Draw() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Get_Color() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Get_Area() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
