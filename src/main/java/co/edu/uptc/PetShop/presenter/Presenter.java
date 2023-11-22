package co.edu.uptc.PetShop.presenter;
import co.edu.uptc.PetShop.requests.DeleteRequest;
import co.edu.uptc.PetShop.requests.ListRequest;
import co.edu.uptc.PetShop.requests.SaveRequest;
import co.edu.uptc.PetShop.requests.UpdateRequest;
import co.edu.uptc.PetShop.view.Dashboard;
import org.hibernate.sql.Update;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Presenter implements ActionListener {
	private Dashboard dashboard;
	private DeleteRequest deleteRequest;
	private UpdateRequest updateRequest;

	public Presenter() {
		dashboard = new Dashboard(this);
		deleteRequest = new DeleteRequest();
		updateRequest = new UpdateRequest();
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
			case "List":
				this.requestList();
				break;
				case "update":
				this.requestUpdate();
				break;
			default:

				break;
		}
	}

	public void requestSave() {
		SaveRequest save = new SaveRequest();
		save.requestSave(dashboard.getName(), dashboard.getCategory());

		dashboard.setMessage(save.getMessage());
	}

	public void requestDelete() {
		dashboard.setInfRequestDelete(deleteRequest.requestDelete(dashboard.getIdPetDelete()));
		deleteRequest.setMessage();
	}

	private void requestList() {
		ListRequest list = new ListRequest(dashboard.getCategoryList());
		dashboard.fillListTable(list.getPets());
	}

	public void requestUpdate(){
		updateRequest.requestUpdate(dashboard.getUpdatePet().getInputId(),dashboard.getUpdatePet().getInputName(),dashboard.getUpdatePet().getCategory());
		dashboard.setMessage(updateRequest.getMessage());
	}


	public static void main(String[] args) {
		new Presenter();
	}
}
