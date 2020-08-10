package javaFiles.controllers;

import javaFiles.Scenes;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class Progress
{
    Scenes scenes = new Scenes();

    public void backButtonClicked(MouseEvent mouseEvent) throws IOException
    {
        scenes.showHomeScene();
    }
}
