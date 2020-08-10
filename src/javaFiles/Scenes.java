package javaFiles;

import javaFiles.controllers.AddingMoreInfoController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Scenes
{
   private static Stage stage =  new Stage();



    public void showActivityScene() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("/resources/fxml/activities.fxml"));

        Stage stage = Main.getStage();
        Scene scene = new Scene(root);

        stage.setResizable(false);
        stage.setTitle("Activities");
        stage.setScene(scene);
        stage.show();
    }

    public void showHomeScene() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("/resources/fxml/home.fxml"));

        Stage stage = Main.getStage();
        Scene scene = new Scene(root);

        stage.setResizable(false);
        stage.setTitle("Home");
        stage.setScene(scene);
        stage.show();
    }

    public void showProgress() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("/resources/fxml/progress.fxml"));

        Stage stage = Main.getStage();
        Scene scene = new Scene(root);

        stage.setResizable(false);
        stage.setTitle("Home");
        stage.setScene(scene);
        stage.show();
    }

    public static Stage getPopUpStage()
    {
        return stage;
    }
}
