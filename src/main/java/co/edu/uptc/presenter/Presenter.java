package co.edu.uptc.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.uptc.PetShop.model.Pet;
import co.edu.uptc.request.HttpDemand;
import co.edu.uptc.view.Dashboard;

public class Presenter implements ActionListener {
	
	private Dashboard dashBoard;
	public Presenter() {
		dashBoard = new Dashboard(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		switch (source) {
		case "save":
			HttpDemand save= new HttpDemand();
			save.requestSave(new Pet(dashBoard.getName(),dashBoard.getCategory()));	
			dashBoard.setMessage(save.getMessage());
			break;

		default:
			break;
		}
	}

	public static void main(String[] args) {
		new Presenter();
	}

}
