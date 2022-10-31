module com.example.uppgift_11a_regformular {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.uppgift_11a_regformular to javafx.fxml;
    exports com.example.uppgift_11a_regformular;
}