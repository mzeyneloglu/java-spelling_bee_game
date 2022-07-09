module com.example.userjavafxspelling {
    requires javafx.controls;
    requires javafx.fxml;



    opens com.example.userjavafxspelling to javafx.fxml;
    exports com.example.userjavafxspelling;
}