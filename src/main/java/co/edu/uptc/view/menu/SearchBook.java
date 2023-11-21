package co.edu.uptc.view.menu;



import javax.swing.*;

import co.edu.uptc.view.myComponents.ButtonDefault;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SearchBook extends JPanel {
    private JLabel isbn;
    private JLabel selectCampus;
    private JTextField inputISBN;
    private JComboBox campus;
    private ButtonDefault search;

    private JTable table;
    private Object[][]data;
    private String[]column;

    public SearchBook(ActionListener listener) {
        setBackground(new Color(241, 239, 239));
        this.column = new  String[]{"Titulo","Autor","ISBN","Sede"};
        this.data = new Object[][]{new Object[]{"Cien años de soledad","Gabriel Garcia Marquez",412, "Duitama"},
                {"Cien años de soledad","Gabriel Garcia Marquez",412, "Duitama"}
        };
        initComponents(listener);
    }
    public void initComponents(ActionListener listener){
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10,10,10,10);
        constraints.anchor = GridBagConstraints.WEST;
        isbn = new JLabel("Ingrese el ISBN del libro a buscar");
        add(isbn, constraints);
        constraints.gridx = 1;
        inputISBN = new JTextField(20);
        add(inputISBN, constraints);
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
        add(campus, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        search = new ButtonDefault("Buscar Libro");
        search.setActionCommand("search");
        search.addActionListener(listener);
        add(search,constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        table = new JTable(data, column);
        table.setBackground(new Color(25, 23, 23));
        table.setFont(new Font(Font.DIALOG, Font.BOLD, 10));
        table.setForeground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane,constraints);

    }

}
