package controllers;

import controllers.client.Controller;
import controllers.client.SignInController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application
{
    private Stage primaryStage;
    private BorderPane rootLayout;

    public void start(Stage primaryStage) throws Exception
    {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Restaurant app");
        
        initRootLayout();
        showMainWindow();
    }

    private void initRootLayout()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void showMainWindow()
    {
        // TODO: 25.10.2017
    }

    public void showSignInWindow()
    {
        try
        {
            Stage dialogStage = new Stage();
            SignInController controller = (SignInController) createController("/SignInWindow.fxml", null,
                    null, dialogStage,false);

            controller.setDialogStage(dialogStage);
            dialogStage.show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        launch(args);
    }


    private Controller createController(String loaderResource, String titleElement,
                                        String imageLocation, Stage dialogStage, boolean isResizable) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(loaderResource));
        AnchorPane pane = loader.load();

        dialogStage.setTitle(/*elementName(titleElement)*/"TODO TITLE NAMES LOC");

        dialogStage.setResizable(isResizable);
        dialogStage.initModality(Modality.WINDOW_MODAL);

        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(pane);
        dialogStage.setScene(scene);
        //dialogStage.getIcons().add(new Image(imageLocation));

        return loader.getController();
    }
}
