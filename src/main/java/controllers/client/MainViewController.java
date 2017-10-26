package controllers.client;

import controllers.MainApp;
import javafx.fxml.FXML;

public class MainViewController implements Controller
{
    MainApp mainApp;

    public MainViewController()
    {
    }

    public void setMainApp(MainApp mainApp)
    {
        this.mainApp = mainApp;
    }

    public void applyInterface()
    {
    }

    @FXML
    private void initialize()
    {

    }
}
