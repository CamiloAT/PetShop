package co.edu.uptc.PetShop.view;

import javax.swing.*;
import co.edu.uptc.PetShop.view.menu.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;

import co.edu.uptc.PetShop.model.Pet;

public class Dashboard extends JFrame {
	private Toolkit toolkit;
	private Dimension dimension;
	private SavePet savePet;
	private DeletePet deleteBook;
	private SearchBook searchBook;
	private ListBooks listBooks;
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
		searchBook = new SearchBook(listener);
		listBooks = new ListBooks(listener);

	}

	public void visibleDeleteMenu() {
		getContentPane().add(deleteBook);
		deleteBook.setVisible(true);
		searchBook.setVisible(false);
		listBooks.setVisible(false);
		savePet.setVisible(false);
	}

	public void visibleSearchMenu() {
		getContentPane().add(searchBook);
		searchBook.setVisible(true);
		savePet.setVisible(false);
		deleteBook.setVisible(false);
		listBooks.setVisible(false);

	}

	public void visibleListMenu() {
		getContentPane().add(listBooks);
		listBooks.setVisible(true);
		savePet.setVisible(false);
		deleteBook.setVisible(false);
		searchBook.setVisible(false);

	}

	public void visibleCreateMenu() {
		savePet.setVisible(true);
		listBooks.setVisible(false);
		deleteBook.setVisible(false);
		searchBook.setVisible(false);
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
    	listBooks.fillTable(pets);
    }
    
    public String getCategoryList() {
    	return listBooks.getCategoryList();
    }
}
