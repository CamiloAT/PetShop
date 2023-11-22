package co.edu.uptc.view;

import javax.swing.*;
import co.edu.uptc.view.menu.SavePet;
import co.edu.uptc.view.menu.DeleteBook;
import co.edu.uptc.view.menu.ListBooks;
import co.edu.uptc.view.menu.MainMenu;
import co.edu.uptc.view.menu.SearchBook;

import java.awt.*;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame {
    private Toolkit toolkit;
    private Dimension dimension;
    private SavePet savePet;
    private DeleteBook deleteBook;
    private SearchBook searchBook;
    private ListBooks listBooks;
    private MainMenu mainMenu;
    public Dashboard(ActionListener listener){
        toolkit = Toolkit.getDefaultToolkit();
        dimension = toolkit.getScreenSize();
        initPanels(listener);
        setSize(dimension);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void initPanels(ActionListener listener){
        mainMenu = new MainMenu(this);
        setJMenuBar(mainMenu);
        savePet = new SavePet(listener);
        getContentPane().add(savePet);
        deleteBook = new DeleteBook(listener);
        searchBook = new SearchBook(listener);
        listBooks = new ListBooks();

    }
    public void visibleDeleteMenu(){
        getContentPane().add(deleteBook);
        deleteBook.setVisible(true);
        searchBook.setVisible(false);
        listBooks.setVisible(false);
        savePet.setVisible(false);
    }
    public void visibleSearchMenu(){
        getContentPane().add(searchBook);
        searchBook.setVisible(true);
        savePet.setVisible(false);
        deleteBook.setVisible(false);
        listBooks.setVisible(false);

    } public void visibleListMenu(){
        getContentPane().add(listBooks);
        listBooks.setVisible(true);
        savePet.setVisible(false);
        deleteBook.setVisible(false);
        searchBook.setVisible(false);

    }
    public void visibleCreateMenu(){
        savePet.setVisible(true);
        listBooks.setVisible(false);
        deleteBook.setVisible(false);
        searchBook.setVisible(false);
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

   
}
