package co.edu.uptc.PetShop.view;

import co.edu.uptc.PetShop.view.menu.*;

import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.*;

import co.edu.uptc.PetShop.model.Pet;

public class Dashboard extends JFrame {
	private Toolkit toolkit;
	private Dimension dimension;
	private SavePet savePet;
	private DeletePet deleteBook;
	private UpdatePet updatePet;
	private ListPets listPets;
	private ShowDetails showDetails;
	private MainMenu mainMenu;


	public Dashboard(ActionListener listener) {
		toolkit = Toolkit.getDefaultToolkit();
		dimension = toolkit.getScreenSize();
		initPanels(listener);
		setSize(dimension);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void initPanels(ActionListener listener) {
		mainMenu = new MainMenu(this);
		setJMenuBar(mainMenu);
		savePet = new SavePet(listener);
		getContentPane().add(savePet);
		deleteBook = new DeletePet(listener);
		updatePet = new UpdatePet(listener);
		listPets = new ListPets(listener);
		showDetails = new ShowDetails(listener);
	}

	public void visibleDeleteMenu() {
		getContentPane().add(deleteBook);
		deleteBook.setVisible(true);
		updatePet.setVisible(false);
		listPets.setVisible(false);
		savePet.setVisible(false);
		showDetails.setVisible(false);
	}

	public void visibleSearchMenu() {
		getContentPane().add(updatePet);
		updatePet.setVisible(true);
		savePet.setVisible(false);
		deleteBook.setVisible(false);
		listPets.setVisible(false);
		showDetails.setVisible(false);
	}

	public void visibleListMenu() {
		getContentPane().add(listPets);
		listPets.setVisible(true);
		savePet.setVisible(false);
		deleteBook.setVisible(false);
		updatePet.setVisible(false);
		showDetails.setVisible(false);
	}

	public void visibleShowMenu() {
		getContentPane().add(showDetails);
		showDetails.setVisible(true);
		listPets.setVisible(false);
		deleteBook.setVisible(false);
		updatePet.setVisible(false);
		savePet.setVisible(false);
	}
	public void visibleCreateMenu() {
		savePet.setVisible(true);
		savePet.deleteMessage();
		listPets.setVisible(false);
		deleteBook.setVisible(false);
		updatePet.setVisible(false);
		showDetails.setVisible(false);
	}

	public ShowDetails getShowDetails() {
		return showDetails;
	}

	public String getIdPetDelete() {
		return deleteBook.getIdPetDelete();
	}

	public void setInfRequestDelete(String message) {
		deleteBook.setInfRequestDelete(message);
	}

	public String getName() {
		return savePet.getName();
	}

	public String getCategory() {
		return savePet.getCategory();
	}

	public void setMessage(String message) {
		savePet.setMessage(message);
	}

	public void fillListTable(List<Pet> pets) {
		listPets.fillTable(pets);
	}

	public String getCategoryList() {
		return listPets.getCategoryList();
	}

	public UpdatePet getUpdatePet() {
		return updatePet;
	}
	public static void showMessage(String message) {
		JOptionPane.showMessageDialog(null, "Detalles mascota: " + message, "Detalles Mascota ", JOptionPane.INFORMATION_MESSAGE);
	}
}
