package com.example.uppgift_11a_regformular;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;

import java.util.Timer;

public class HelloController {

    Printer printer = new Printer();

    @FXML
    protected TextField Förnamn;

    @FXML
    protected TextField Efternamn;

    @FXML
    protected TextField Mailadress;

    @FXML
    protected Label RubrikNy;

    @FXML
    protected Label RubrikKlar;

    protected String personUppgifter = "";

    @FXML
    protected void onRegistreraButtonClick() {

        RubrikKlar.setVisible(false);

        if (Förnamn.getText().trim().isEmpty() || Efternamn.getText().trim().isEmpty() || Mailadress.getText().trim().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.setContentText("Fel vid inmatning av personuppgifter");
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.show();

            System.out.println("Registrera klickad");

        } else {

            personUppgifter = Förnamn.getText().trim() + ", " + Efternamn.getText().trim() + ", " + Mailadress.getText().trim().toLowerCase();
            printer.printTofile(personUppgifter + "\n");

            RubrikKlar.setVisible(true);
            RubrikNy.setVisible(false);

            // Text message switch-pause to show form completed message for 1.5 seconds
            //----------------------------------------------------------------------------
            PauseTransition visiblePause1 = new PauseTransition(Duration.seconds(1.5));
            PauseTransition visiblePause2 = new PauseTransition(Duration.seconds(1.5));

            visiblePause1.setOnFinished(event -> RubrikKlar.setVisible(false));
            visiblePause2.setOnFinished(event -> RubrikNy.setVisible(true));

            visiblePause1.play();
            visiblePause2.play();
            //----------------------------------------------------------------------------

            Förnamn.setText("");
            Efternamn.setText("");
            Mailadress.setText("");

            System.out.println("Registrera klickad");
        }
    }

    @FXML
    protected void onAvbrytButtonClick() {

        RubrikKlar.setVisible(false);

        if (!Förnamn.getText().trim().isEmpty() || !Efternamn.getText().trim().isEmpty() || !Mailadress.getText().trim().isEmpty()) {

            Förnamn.setText("");
            Efternamn.setText("");
            Mailadress.setText("");

            System.out.println("Avbryt klickad");

        } else {
            System.out.println("Avbryt klickad");
            System.exit(0);
        }

    }
}