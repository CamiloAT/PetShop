package co.edu.uptc.PetShop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import co.edu.uptc.PetShop.model.Pet;
import co.edu.uptc.view.Dashboard;

@SpringBootApplication
public class PetShopApplication implements ActionListener {
//    private Dashboard dashBoard;
    public PetShopApplication() {
//    	dashBoard = new Dashboard(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String source= e.getActionCommand();
		switch (source) {
		case "save":
//			this.savePet(new Pet());
			break;

		default:
			break;}
		}
		
	public static void main(String[] args) {
//		new PetShopApplication();

		SpringApplication.run(PetShopApplication.class, args);
}

}
