package paint_test_program;

//import com.sun.prism.paint.Color;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.util.Vector;
import javax.swing.*;
     
//create a jframe subclass called drawframe to provide a GUI for the user
public class DrawFrame extends JFrame{

    private final int WIDTH = 600;
    private final int HEIGHT = 300;
    
  //  JFrame frame = new JFrame("demo") ;
    
    private JButton undo;              //clear last shape button
    private JButton redo;
    private JButton copy;
    private JButton clear;            //clear all button
    private JButton move;
    private JButton delete;
    
    private JComboBox selectbox;
    
    private JComboBox colorsbox;      //  lists all available colors
    private JComboBox shapesbox;      //  lists all available shapes
    
    private JCheckBox filledbox;      //fill shapes on/off
            
    private JPanel selectionPanel;    //panel for mouse co-ordinates (status)
    private JPanel selectionPanel2;
    private JPanel selectionPanel3;
    
    //
    private static final String [] shapesToDraw = {"Line","Rectangle","Oval","Triangle"};
    private static final String [] thirteen = {"Black","Blue","Cyan","Dark Gray","Gray","Green",
                                                "Light Gray","Magenta","Orange","Pink","Red","White","Yellow"};
    private static final Color [] colors = {Color.BLACK,Color.BLUE,Color.CYAN,Color.DARK_GRAY,Color.GRAY,Color.GREEN,
                                            Color.LIGHT_GRAY,Color.MAGENTA,Color.ORANGE,Color.PINK,Color.RED,Color.WHITE,Color.YELLOW};
    
    private JLabel labelSelect;
    
    private JTextField coords;   //text field for status bar mouse coordintes
    private JPanel panelText;
    //create graphics panel and add it to the center
    private DrawPanel graphicsPanel;
    
    //constructor
    public DrawFrame()
    {
        createGraphicsPanel();
        createSelectionPanel();
        
                
        
        // set title and size and exit and set to visible
        this.setTitle("JavaDrawings");
        this.setSize(WIDTH,HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setVisible(true);
    }
    private void createSelectionPanel()
    {
        selectionPanel = new JPanel();
        selectionPanel2 = new JPanel();
        
        
        undo = new JButton("Undo");
        clear = new JButton("Clear");
        redo = new JButton("Redo");
        copy = new JButton("Copy");
        move = new JButton("Move");
        delete = new JButton("Delete");
        
        
        
       // String[] arr = graphicsPanel.shapes.toArray(new String[graphicsPanel.shapes.size()]);
        selectbox = new JComboBox();
        selectbox.setMaximumRowCount(10);
        
        for (int i = 0; i < graphicsPanel.shapes.size(); i++)
        {
            selectbox.addItem(graphicsPanel.shapes.get(i));
        }
        
        colorsbox = new JComboBox(thirteen);
        colorsbox.setMaximumRowCount(10);
        shapesbox = new JComboBox(shapesToDraw);
        shapesbox.setMaximumRowCount(3);  
        
        filledbox = new JCheckBox("Filled");
        
        selectionPanel.add(undo);
        selectionPanel.add(redo);
        
        selectionPanel.add(clear);
        
        selectionPanel.add(colorsbox);
        selectionPanel.add(shapesbox);
        selectionPanel.add(filledbox);
        this.add(selectionPanel,BorderLayout.NORTH);
        
        
        selectionPanel2.add(delete);
        selectionPanel2.add(copy);
        selectionPanel2.add(move);
        this.add(selectionPanel2,BorderLayout.WEST);
        
       
        UndoButtonListener buttonHandler = new UndoButtonListener(); 
        undo.addActionListener( buttonHandler );
        
        ClearButtonListener buttonHandler2 = new ClearButtonListener();
        clear.addActionListener( buttonHandler2 );
        
        RedoButtonListener buttonHandler3 = new RedoButtonListener();
        redo.addActionListener( buttonHandler3 );
        
        CopyButtonListener buttonHandler4 = new CopyButtonListener();
        copy.addActionListener( buttonHandler4 );
        
        MoveButtonListener buttonHandler5 = new MoveButtonListener();
        move.addActionListener( buttonHandler5 );
        
        DeleteButtonListener buttonHandler6 = new DeleteButtonListener();
        delete.addActionListener( buttonHandler6 );
        
        ColorsBoxHandler handler = new ColorsBoxHandler();
        colorsbox.addItemListener( handler );
        
        ShapesBoxHandler handler2 = new ShapesBoxHandler();
        shapesbox.addItemListener( handler2 );
        
        CheckBoxHandler handler3 = new CheckBoxHandler();
        filledbox.addItemListener( handler3 );
        
        SelectBoxHandler handler4 = new SelectBoxHandler();
        selectbox.addItemListener( handler4 );
         
    }
    private void createGraphicsPanel()
    {
        //instantiate the drawing panel
        graphicsPanel = new DrawPanel();
        //add graphics panel to center
        add(graphicsPanel,BorderLayout.CENTER);
    }
    
    private class UndoButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed (ActionEvent event)
        {
           if (event.getActionCommand().equals("Undo")){
                graphicsPanel.undoLastShape();
            } 
        }
    }
    private class ClearButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed (ActionEvent event)
        {
            if (event.getActionCommand().equals("Clear")){
                graphicsPanel.clearDrawing();
            }
        }
    }
    private class RedoButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed (ActionEvent event)
        {
           if (event.getActionCommand().equals("Redo")){
                graphicsPanel.RedoLastShape();
            } 
        }
    }
    private class CopyButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed (ActionEvent event)
        {
           if (event.getActionCommand().equals("Copy")){
                graphicsPanel.CopyLastShape();
            } 
        }
    }
    private class MoveButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed (ActionEvent event)
        {
           if (event.getActionCommand().equals("Move")){
                graphicsPanel.MoveLastShape();
            } 
        }
    }
    private class DeleteButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed (ActionEvent event)
        {
           if (event.getActionCommand().equals("Delete")){
                graphicsPanel.DeleteLastShape();
            } 
        }
    }
    private class ColorsBoxHandler implements ItemListener
    {
        @Override
        public void itemStateChanged (ItemEvent event)
        {
            if ( event.getStateChange() == ItemEvent.SELECTED )
            {
                //if event source is combo box colors pass in colorArray at index selected.
                if ( event.getSource() == colorsbox)
                {
                    graphicsPanel.setCurrentColor
                        (colors[colorsbox.getSelectedIndex()]);
                }
            }
        }
    }
    private class ShapesBoxHandler implements ItemListener
    {
        @Override
        public void itemStateChanged (ItemEvent event)
        {
            if ( event.getStateChange() == ItemEvent.SELECTED )
            {
                if ( event.getSource() == shapesbox)
                {
                    graphicsPanel.setShapeType(shapesbox.getSelectedIndex());
                }
            }
        }
    }
    private class CheckBoxHandler implements ItemListener
    {
        @Override
        public void itemStateChanged (ItemEvent event)
        {
            // process filled checkbox events
            if ( event.getSource() == filledbox )
            {
                boolean checkFill=filledbox.isSelected() ? true : false; //
               
            }
        }
    }
    private class SelectBoxHandler implements ItemListener
    {
        @Override
        public void itemStateChanged (ItemEvent event)
        {
            if ( event.getStateChange() == ItemEvent.SELECTED )
            {
                if ( event.getSource() == selectbox)
                {
                   
                    
                }
            }
        }
    }
    private class TextFieldHandler implements ActionListener
    {
        @Override
        public void actionPerformed (ActionEvent event)
        {
            
        }
    }
    public static void main(String[] args) {
        
        DrawFrame draw;
        draw = new DrawFrame();
    }
    
}
