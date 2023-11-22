package co.edu.uptc.PetShop.presenter;

import co.edu.uptc.PetShop.model.Pet;
import co.edu.uptc.PetShop.requests.DeleteRequest;
import co.edu.uptc.PetShop.requests.SaveRequest;
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
		case "save":
			this.requestSave();
			break;
		default:

			break;
		}
	}
	public void requestSave(){
    	SaveRequest save= new SaveRequest();
		save.requestSave(new Pet(dashboard.getName(),dashboard.getCategory()));	
		dashboard.setMessage(save.getMessage());
    }

    public void requestDelete(){
        dashboard.setInfRequestDelete(deleteRequest.requestDelete(dashboard.getIdPetDelete())); 
        deleteRequest.setMessage();
    }

    public static void main(String[] args) {
        new Presenter();
    }
}
