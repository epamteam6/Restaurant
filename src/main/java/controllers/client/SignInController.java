package controllers.client;

import controllers.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignInController implements Controller
{
    @FXML
    Label usernameLabel;
    @FXML
    Label passwordLabel;

    @FXML
    TextField usernameField;
    @FXML
    PasswordField passwordField;

    @FXML
    Button CancelButton;
    @FXML
    Button OkButton;

    private Stage dialogStage;

    private MainApp mainApp;

    public SignInController()
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

    public void setDialogStage(Stage dialogStage)
    {
        this.dialogStage = dialogStage;
    }

    @FXML
    private void handleCancel()
    {
        dialogStage.close();
    }
    
    @FXML
    private void handleOk()
    {
        // TODO: 25.10.2017  
    }
    
    private boolean isInputValid()
    {
        // TODO: 25.10.2017  
        return false;
    }
}
