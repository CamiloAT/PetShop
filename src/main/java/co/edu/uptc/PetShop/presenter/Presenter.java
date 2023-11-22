package co.edu.uptc.PetShop.presenter;

import co.edu.uptc.PetShop.requests.DeleteRequest;
import co.edu.uptc.PetShop.view.Dashboard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Presenter implements ActionListener{
    private Dashboard dashboard;
    private DeleteRequest deleteRequest;

    public Presenter() {
        dashboard = new Dashboard(this);
        deleteRequest = new DeleteRequest();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		switch (source) {
		case "delete": 
			this.requestDelete();
			break;
		default:

			break;
		}
	}

    public void requestDelete(){
        dashboard.setInfRequestDelete(deleteRequest.requestDelete(dashboard.getIdPetDelete())); 
        deleteRequest.setMessage();
    }

    public static void main(String[] args) {
        new Presenter();
    }
}
