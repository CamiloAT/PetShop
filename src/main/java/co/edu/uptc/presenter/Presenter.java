package co.edu.uptc.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.uptc.PetShop.model.Pet;
import co.edu.uptc.request.HttpDemand;
import co.edu.uptc.view.Dashboard;

public class Presenter implements ActionListener {
	
	private Dashboard dashboard;
	public Presenter() {
		dashboard = new Dashboard(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		switch (source) {
		case "save":
			this.requestSave();
			break;

		default:
			break;
		}
	}
    public void requestSave(){
    	HttpDemand save= new HttpDemand();
		save.requestSave(new Pet(dashboard.getName(),dashboard.getCategory()));	
		dashboard.setMessage(save.getMessage());
    }

	public static void main(String[] args) {
		new Presenter();
	}

}
