package co.edu.uptc.PetShop.view.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyMenuItem extends JMenu implements MouseListener{
    private Dimension dimension;
    private Toolkit toolkit;
    public MyMenuItem(String text){
        setText(text);
        this.setHorizontalTextPosition(0);
        toolkit = Toolkit.getDefaultToolkit();
        dimension = toolkit.getScreenSize();
        this.setForeground(Color.white);
        this.setHorizontalTextPosition(this.CENTER);
        setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        setPreferredSize(new Dimension(dimension.width/5,40));
        addMouseListener(this);
        setColor(new Color(25, 23, 23));
    }



    public void setColor(Color color){
        setOpaque(true);
        setBackground(color);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        setColor(Color.GRAY);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        setColor(Color.GRAY);
    }


    @Override
    public void mouseReleased(MouseEvent e) {
        setColor(new Color(25, 23, 23));
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        setColor( Color.GRAY);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setColor(new Color(25, 23, 23));
    }

}
