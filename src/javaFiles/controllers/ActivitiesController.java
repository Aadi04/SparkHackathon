package javaFiles.controllers;

import javaFiles.Main;
import javaFiles.Scenes;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ActivitiesController implements Initializable
{
    Scenes scenes = new Scenes();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }

    public void onBackButtonClicked(MouseEvent mouseEvent) throws IOException
    {
        scenes.showHomeScene();
    }
}
