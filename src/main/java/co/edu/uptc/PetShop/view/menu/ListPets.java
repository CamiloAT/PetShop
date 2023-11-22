package co.edu.uptc.PetShop.view.menu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import co.edu.uptc.PetShop.model.Pet;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class ListPets extends JPanel {

    private static final long serialVersionUID = 1L;
	private JLabel categoryLabel;
    private JComboBox categoryField;
    private ButtonDefault listButton;
    private JTable petsTable;
    private DefaultTableModel tableModel;
    private String[]column;

    public ListPets(ActionListener listener) {
        setBackground(new Color(241, 239, 239));
        this.column = new String[]{"ID", "Nombre", "Categoria"};
		this.tableModel = new DefaultTableModel();
		this.tableModel.setColumnIdentifiers(column);
		this.petsTable = new JTable(tableModel);
        initComponents(listener);
    }
    
    public void setData(Object[][] data) {
		tableModel.setDataVector(data, column);
	}
    
    public void initComponents(ActionListener listener){
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10,10,10,10);
        constraints.anchor = GridBagConstraints.WEST;
        categoryLabel = new JLabel("Ingrese la categoria de la mascota a buscar");
        add(categoryLabel, constraints);
        constraints.gridx = 1;
        categoryField =  new JComboBox(new String[] { "Gato", "Perro", "Ave", "Conejo"});
        add(categoryField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        listButton = new ButtonDefault("Listar mascotas");
        listButton.setActionCommand("List");
        listButton.addActionListener(listener);
        add(listButton,constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        petsTable.setBackground(new Color(25, 23, 23));
        petsTable.setFont(new Font(Font.DIALOG, Font.BOLD, 10));
        petsTable.setForeground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(petsTable);
        this.add(scrollPane,constraints);
    }
    
    public void fillTable(List<Pet> pets) {
    	tableModel = (DefaultTableModel) petsTable.getModel();
		tableModel.setRowCount(0);
		petsTable.repaint();
    	for (Pet pet : pets) {
			this.addPet(pet);
		}
    }
    
    private void addPet(Pet pet) {
    	Object[] newPet = {""+pet.getId(), pet.getName(), pet.getCategory()};
		tableModel.addRow(newPet);
	}
    
    public String getCategoryList() {
    	 return (String) categoryField.getSelectedItem();
    }
}
