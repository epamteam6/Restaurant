package controllers;

import controllers.client.Controller;
import controllers.client.MainViewController;
import controllers.client.RootController;
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

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Restaurant app");
        
        initRootLayout();
        initMainView();
    }

    private void initRootLayout()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/RootLayout.fxml"));
            rootLayout = loader.load();

            RootController controller = loader.getController();
            controller.setMainApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void initMainView()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/MainView.fxml"));
            AnchorPane mainWind = loader.load();

            rootLayout.setCenter(mainWind);

            MainViewController controller = loader.getController();
            controller.setMainApp(this);

            controller.applyInterface();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void showSignInWindow()
    {
        try
        {
            Stage dialogStage = new Stage();
            SignInController controller = (SignInController) createController("/SignInWindow.fxml", null,
                    null, dialogStage,false);
            controller.setMainApp(this);

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
        loader.setLocation(MainApp.class.getResource(loaderResource));
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
