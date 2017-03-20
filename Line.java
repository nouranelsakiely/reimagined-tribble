/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package npaint;

import java.awt.Point;
import java.awt.Stroke;

/**
 *
 * @author noura
 */
public class Line extends ConcreteShape implements Shape{
    protected Point start_point;
    protected Point end_point;
    protected enum Line_Style{
        Dotted,
        Solid,
        Dashed,
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
