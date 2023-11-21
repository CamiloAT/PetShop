package co.edu.uptc.view.menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import co.edu.uptc.view.myComponents.ButtonDefault;

public class SavePet extends JPanel {

    private JLabel lblName;
    private JTextField name;
    private JLabel selectCategory;
    private JComboBox category;
    private ButtonDefault save;

    public SavePet(ActionListener listener) {
        setBackground(new Color(241, 239, 239));
        initComponents(listener);
    }

    public void initComponents(ActionListener listener) {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        lblName = new JLabel("Ingrese Nombre De La Mascota: ");
        add(lblName, constraints);
        constraints.gridx = 1;
        name = new JTextField(20);
        add(name, constraints);
        name.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                for (int i = 0; i < 65; i++) {
                	if ( c==i) {
                        e.consume();
                    }
				}
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        constraints.gridx = 0;
        constraints.gridy = 2;
        selectCategory = new JLabel("Seleccione Una Categoria");
        add(selectCategory, constraints);
        constraints.gridx = 1;
        category = new JComboBox(new String[]{"Gato", "Perro", "Ave",});
        add(category, constraints);
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        save = new ButtonDefault("Guardar Mascota");
        save.setActionCommand("save");
        save.addActionListener(listener);
        add(save, constraints);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titleText = name.getText().trim();
                if (titleText.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor Ingrese un nombre", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public String getName() {
        return name.getText();
    }

    public String getCategory() {
        return (String) category.getSelectedItem();
    }



}
