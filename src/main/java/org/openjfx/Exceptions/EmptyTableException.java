package org.openjfx.Exceptions;

import javafx.application.Platform;
import org.openjfx.Model.ErrorMessage;

import java.io.IOException;

public class EmptyTableException extends Exception {

    String errorMessage;

    //Denne klassen skulle egentlig bli splittet i flere exceptions, men det rakk vi ikke, derfor dårlig navngivning og bruk.
    //Jobben den gjør er å sende exceptionstrengen videre til ErrorMessage (popup med beskjed hva feilen er).


    public EmptyTableException (String message){
        this.errorMessage=message;
    }

    public void showErrorGUI (String message){
        Platform.runLater(() -> {
            try {
                new ErrorMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
    public void showErrorGUI() {
        Platform.runLater(() -> {
            try {
                new ErrorMessage(errorMessage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}


