module io.github.gleidsonmt.core {
    requires javafx.controls;
    requires javafx.fxml;

    requires scenicView;
    requires fr.brouillard.oss.cssfx;

    requires org.jetbrains.annotations;

    opens io.github.gleidsonmt.core to javafx.fxml;
    exports io.github.gleidsonmt.core;
    exports io.github.gleidsonmt.core.main;

    exports io.github.gleidsonmt.core.internal.root.freeze.alert;
}