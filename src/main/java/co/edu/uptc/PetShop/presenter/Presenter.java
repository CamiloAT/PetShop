package co.edu.uptc.PetShop.presenter;

import co.edu.uptc.PetShop.requests.*;
import co.edu.uptc.PetShop.view.Dashboard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Presenter implements ActionListener {
    private final Dashboard dashboard;
    private final DeleteRequest deleteRequest;
    private final UpdateRequest updateRequest;
    private final DetailsRequest detailsRequest;

    public Presenter() {
        dashboard = new Dashboard(this);
        deleteRequest = new DeleteRequest();
        updateRequest = new UpdateRequest();
        detailsRequest = new DetailsRequest();
    }

    public static void main(String[] args) {
        new Presenter();
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
            case "show":
                this.requestDetails();
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

    private void requestDetails() {
        detailsRequest.requestDetails(Long.valueOf(dashboard.getShowDetails().getIdPet()));
        dashboard.showMessage(detailsRequest.getResponse());
    }

    public void requestUpdate() {
        updateRequest.requestUpdate(dashboard.getUpdatePet().getInputId(), dashboard.getUpdatePet().getInputName(), dashboard.getUpdatePet().getCategory());
        dashboard.setMessage(updateRequest.getMessage());
    }
}
