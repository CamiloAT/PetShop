package co.edu.uptc.PetShop.view.menu;

import javax.swing.*;

import co.edu.uptc.PetShop.view.myComponents.ButtonDefault;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ShowDetails extends JPanel {
    private JLabel idPet;
    private JTextField inputIdPet;
    private ButtonDefault delete;

    public ShowDetails(ActionListener listener) {
        setBackground(new Color(241, 239, 239));
        initComponents(listener);
    }
    public void initComponents(ActionListener listener){
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10,10,10,10);
        constraints.anchor = GridBagConstraints.WEST;

        idPet = new JLabel("Ingrese el id de la mascota que desea buscar ");
        add(idPet,constraints);
        constraints.gridx = 1;
        inputIdPet = new JTextField(20);
        add(inputIdPet, constraints);
        inputIdPet.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
                    e.consume();
                }
            }
        });

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        delete = new ButtonDefault("Buscar Detalles");
        delete.setActionCommand("show");
        delete.addActionListener(listener);
        add(delete,constraints);


    }

    public String getIdPet(){
        return inputIdPet.getText();
    }



}
