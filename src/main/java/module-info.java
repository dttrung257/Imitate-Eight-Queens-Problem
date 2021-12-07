module sample.eightqueenalgo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens sample.eightqueenalgo to javafx.fxml;
    exports sample.eightqueenalgo;
}