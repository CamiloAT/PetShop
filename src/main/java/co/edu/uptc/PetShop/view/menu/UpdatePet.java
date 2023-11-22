package co.edu.uptc.PetShop.view.menu;



import co.edu.uptc.PetShop.view.myComponents.ButtonDefault;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class UpdatePet extends JPanel {
    private JLabel idPet;
    private JTextField inputId;
    private JLabel namePet;
    private JTextField inputName;
    private JLabel categoryPet;
    private JComboBox category;
    private ButtonDefault update;

    public UpdatePet(ActionListener listener) {
        setBackground(new Color(241, 239, 239));
        initComponents(listener);
    }
    public void initComponents(ActionListener listener){
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10,10,10,10);
        constraints.anchor = GridBagConstraints.WEST;

        idPet = new JLabel("Ingrese el id de la mascota a actualizar");
        add(idPet,constraints);
        constraints.gridx = 1;
        inputId = new JTextField(20);
        add(inputId,constraints);
        inputId.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
                    e.consume();
                }
            }
        });
        constraints.gridx=0;
        constraints.gridy=1;
        namePet = new JLabel("Ingrese el nombre de la mascota");
        add(namePet,constraints);
        constraints.gridx = 1;
        inputName = new JTextField(20);
        add(inputName,constraints);

        constraints.gridx=0;
        constraints.gridy=2;
        categoryPet = new JLabel("Seleccione la categoria de la mascota");
        add(categoryPet,constraints);
        constraints.gridx = 1;
        category = new JComboBox(new String[]{"Gato", "Perro", "Ave",});
        add(category,constraints);


        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        update = new ButtonDefault("Actualizar");
        update.setActionCommand("update");
        update.addActionListener(listener);
        add(update,constraints);
    }

    public String getCategory() {
        return category.getSelectedItem().toString();
    }

    public Long getInputId() {
        return Long.valueOf(inputId.getText());
    }

    public String getInputName() {
        return inputName.getText().toString();
    }
}
