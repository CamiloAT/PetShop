package co.edu.uptc.view.menu;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import co.edu.uptc.view.myComponents.ButtonDefault;

public class DeleteBook extends JPanel {
    private JLabel isbn;
    private JLabel selectCampus;
    private JTextField inputISBN;
    private JComboBox campus;
    private ButtonDefault delete;

    public DeleteBook(ActionListener listener) {
        setBackground(new Color(241, 239, 239));
        initComponents(listener);
    }
    public void initComponents(ActionListener listener){
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10,10,10,10);
        constraints.anchor = GridBagConstraints.WEST;

        isbn = new JLabel("Ingrese el ISBN del libro a eliminar");
        add(isbn,constraints);
        constraints.gridx = 1;
        inputISBN = new JTextField(20);
        add(inputISBN,constraints);
        inputISBN.addKeyListener(new KeyAdapter() {
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
        selectCampus = new JLabel("Seleccione Campus");
        add(selectCampus,constraints);
        constraints.gridx = 1;
        campus = new JComboBox(new String[]{"Tunja", "Chiquinquira", "Sogamoso", "Duitama"});
        add(campus,constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        delete = new ButtonDefault("Eliminar Libro");
        delete.setActionCommand("delete");
        delete.addActionListener(listener);
        add(delete,constraints);
    }

}
