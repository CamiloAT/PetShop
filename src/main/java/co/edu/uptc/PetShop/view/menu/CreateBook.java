package co.edu.uptc.PetShop.view.menu;



import javax.swing.*;

import co.edu.uptc.PetShop.view.myComponents.ButtonDefault;

import java.awt.*;
import java.awt.event.*;

public class CreateBook extends JPanel {

    private JLabel title;
    private JTextField inputTitle;
    private JLabel isbn;
    private JTextField inputISBN;
    private JLabel volume;
    private JTextField inputVolume;
    private JLabel quantuty;
    private JTextField inputQuantity;
    private JLabel editorial;
    private JTextField inputEditorial;
    private JLabel selectLibrary;
    private JComboBox library;
    private JLabel selectCampus;
    private JComboBox campus;
    private JLabel nameAutor;
    private JTextField inputNameAutor;
    private JLabel lastNameAutor;
    private JTextField inputLastNameAutor;
    private JLabel biographyAutor;
    private JTextArea inputBiographyAutor;
    private ButtonDefault create;

    public CreateBook(ActionListener listener) {
        setBackground(new Color(241, 239, 239));
        initComponents(listener);
    }

    public void initComponents(ActionListener listener) {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        title = new JLabel("Ingrese el titulo del libro: ");
        add(title, constraints);
        constraints.gridx = 1;
        inputTitle = new JTextField(20);
        add(inputTitle, constraints);
        inputTitle.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (c == '?' || c == '!') {
                    e.consume();
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
        constraints.gridy = 1;
        isbn = new JLabel("Ingrese el ISBN del libro: ");
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
        constraints.gridy = 2;
        volume = new JLabel("Volumen del libro: ");
        add(volume, constraints);
        constraints.gridx = 1;
        inputVolume = new JTextField(20);
        add(inputVolume, constraints);
        inputVolume.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
                    e.consume();
                }
            }
        });
        constraints.gridx = 0;
        constraints.gridy = 3;
        quantuty = new JLabel("cantidad del libros: ");
        add(quantuty, constraints);
        constraints.gridx = 1;
        inputQuantity = new JTextField(20);
        add(inputQuantity, constraints);
        inputQuantity.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
                    e.consume();
                }
            }
        });


        constraints.gridx = 0;
        constraints.gridy = 4;
        nameAutor = new JLabel("Nombre del autor: ");
        add(nameAutor, constraints);
        constraints.gridx = 1;
        inputNameAutor = new JTextField(20);
        add(inputNameAutor, constraints);
        inputNameAutor.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && c != KeyEvent.VK_SPACE) {
                    e.consume();
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
        constraints.gridy = 5;
        lastNameAutor = new JLabel("Apellido del autor: ");
        add(lastNameAutor, constraints);
        constraints.gridx = 1;
        inputLastNameAutor = new JTextField(20);
        add(inputLastNameAutor, constraints);
        inputLastNameAutor.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && c != KeyEvent.VK_SPACE) {
                    e.consume();
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
        constraints.gridy = 6;
        editorial = new JLabel("Editorial: ");
        add(editorial, constraints);
        constraints.gridx = 1;
        inputEditorial = new JTextField(20);
        add(inputEditorial, constraints);

        constraints.gridx = 0;
        constraints.gridy = 7;
        biographyAutor = new JLabel("Biografia del autor: ");
        add(biographyAutor, constraints);
        constraints.gridx = 1;
        inputBiographyAutor = new JTextArea(5, 20);
        add(inputBiographyAutor, constraints);


        constraints.gridx = 0;
        constraints.gridy = 8;
        selectCampus = new JLabel("Seleccione la sede");
        add(selectCampus, constraints);
        constraints.gridx = 1;
        campus = new JComboBox(new String[]{"Tunja", "Chiquinquira", "Sogamoso", "Duitama"});
        add(campus, constraints);

        String[][]subcCampus = {
                {
                "Ciencias Agropecuarias",
                "Ciencias",
                "Ciencias de la Educación",
                "Ciencias Económicas y Administrativas",
                "Ciencias de la Salud",
                "Derecho y Ciencias Sociales",
                "Ingeniería",
                "Facultad Estudios a Distancia"
        }, {
                "Ciencias Económicas y Administrativas",
                "Ciencias de la Educación"
        },{
                "Ciencias Económicas y Administrativas",
                "Ingeniería"
        },{
                "Ciencias Económicas y Administrativas",
                "Ingeniería",
                "Ciencias de la Educación"
        }
        };

        constraints.gridx = 0;
        constraints.gridy = 9;
        campus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = campus.getSelectedIndex();
                library.setModel(new DefaultComboBoxModel<>(subcCampus[selectedIndex]));
            }
        });


        selectLibrary = new JLabel("Seleccione el Campus");
        add(selectLibrary, constraints);
        constraints.gridx = 1;
        library = new JComboBox();
        add(library, constraints);

        constraints.gridy = 10;
        constraints.gridwidth = 2;

        create = new ButtonDefault("Crear Libro");
        create.setActionCommand("create");
        create.addActionListener(listener);
        add(create, constraints);

        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titleText = inputTitle.getText().trim();
                String ISBNText = inputISBN.getText().trim();
                String volumeText = inputVolume.getText().trim();
                String nameAutorText = inputNameAutor.getText().trim();
                String lastNameAutorText = inputLastNameAutor.getText().trim();
                String biographyAutorText = inputBiographyAutor.getText().trim();

                if (titleText.isEmpty() || ISBNText.isEmpty() || volumeText.isEmpty() ||
                        nameAutorText.isEmpty() || lastNameAutorText.isEmpty() || biographyAutorText.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

    }

    public JTextField getInputTitle() {
        return inputTitle;
    }

    public JTextField getInputISBN() {
        return inputISBN;
    }

    public JTextField getInputVolume() {
        return inputVolume;
    }

    public JTextField getInputLastNameAutor() {
        return inputLastNameAutor;
    }

    public JTextField getInputNameAutor() {
        return inputNameAutor;
    }

    public JTextArea getInputBiographyAutor() {
        return inputBiographyAutor;
    }



    public JComboBox getLibrary() {
        return library;
    }

    public JComboBox getCampus() {
        return campus;
    }

    public JTextField getInputQuantity() {
        return inputQuantity;
    }

    public JTextField getInputEditorial() {
        return inputEditorial;
    }


}
