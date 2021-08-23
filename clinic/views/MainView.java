package clinic.views;

import clinic.controllers.OperationController;
import clinic.views.menus.Receptor;
import clinic.views.menus.main.MainMenu;

public class MainView implements Receptor {

    public void interact(OperationController controller) {
        this.interact();
//        this.write();
//        switch (this.getConsole().readInteger("Selecciona una opcion")){
//            case 1:
//                new ManagementUserView().interact(controller.getUserManagementController());
//                break;
//            case 2:
//                new ManagementProcedureView().interact(controller.getManagementProcedureController());
//                break;
//            case 3:
//                new ManagementStatisticsView().interact(controller.getManagementInformationController());
//                break;
//            case 4:
//            default:
//                controller.exit();
//                break;
//        }
    }

    @Override
    public void interact() {
        new MainMenu();
    }
}
