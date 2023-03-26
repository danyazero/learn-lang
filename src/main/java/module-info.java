module com.danyazero.learnlang {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.danyazero.learnlang to javafx.fxml;
    exports com.danyazero.learnlang;
}