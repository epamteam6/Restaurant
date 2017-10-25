package controllers.client;

import controllers.MainApp;
import javafx.fxml.FXML;

import java.awt.*;

public class RootController implements Controller
{
    //Elements of System menu
    @FXML
    MenuItem singInItem;
    @FXML
    MenuItem regItem;
    @FXML
    MenuItem singOutItem;
    @FXML
    MenuItem closeItem;

    private MainApp mainApp;

    public RootController()
    {

    }

    @FXML
    private void initialize()
    {

    }

    public void setMainApp(MainApp mainApp)
    {
        this.mainApp = mainApp;
    }

    @FXML
    private void handleSingIn()
    {
        mainApp.showSignInWindow();
    }
}
