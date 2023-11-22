package co.edu.uptc.view.menu;

import co.edu.uptc.view.Dashboard;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JMenuBar;

public class MainMenu extends JMenuBar {
    private MyMenuItem create;
    private MyMenuItem delete;
    private MyMenuItem search;
    private MyMenuItem list;
    private Dashboard dashBoard;


    public MainMenu(Dashboard dashBoard){
        this.dashBoard = dashBoard;
        initMenu();
    }
    public void initMenu(){
        initCreate();
        initDelete();
        initSearch();
        initList();
    }

    public void initCreate(){
        create = new MyMenuItem("Guardar Mascota");
        this.add(create);
        create.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dashBoard.visibleCreateMenu();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
    public void initDelete(){
        delete = new MyMenuItem("Eliminar Libro");
        this.add(delete);
        delete.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dashBoard.visibleDeleteMenu();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
    public void initList(){
        list = new MyMenuItem("listar Libros");
        this.add(list);
        list.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dashBoard.visibleListMenu();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
    public void initSearch(){
        search = new MyMenuItem("Buscar Libro");
        this.add(search);
        search.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dashBoard.visibleSearchMenu();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
}
