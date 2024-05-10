module com.example.brisca {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.brisca to javafx.fxml;
    exports com.example.brisca;
}