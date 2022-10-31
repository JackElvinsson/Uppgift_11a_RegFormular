package com.example.uppgift_11a_regformular;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class HelloController {

    Printer printer = new Printer();

    @FXML
    protected TextField Förnamn;

    @FXML
    protected TextField Efternamn;

    @FXML
    protected TextField Mailadress;

    protected String personUppgifter = "";

    @FXML
    protected void onRegistreraButtonClick() {

        if (Förnamn.getText().trim().isEmpty() || Efternamn.getText().trim().isEmpty() || Mailadress.getText().trim().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.setContentText("Fel vid inmatning av personuppgifter");
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.show();

            System.out.println("Registrera klickad");

        } else {

            personUppgifter = Förnamn.getText() + "," + Efternamn.getText() + "," + Mailadress.getText();
            printer.printTofile(personUppgifter);
        }
    }
    @FXML
    protected void onAvbrytButtonClick() {

        if (!Förnamn.getText().trim().isEmpty() || !Efternamn.getText().trim().isEmpty() || !Mailadress.getText().trim().isEmpty()) {

            Förnamn.setText("");
            Efternamn.setText("");
            Mailadress.setText("");

            System.out.println("Avbryt klickad");
        }

    }
}