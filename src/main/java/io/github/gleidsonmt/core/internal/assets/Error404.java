package io.github.gleidsonmt.core.internal.assets;

import io.github.gleidsonmt.core.internal.errors.AppContentError;
import io.github.gleidsonmt.core.internal.root.freeze.alert.AlertType;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.input.DragEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  24/05/2024
 */
public class Error404 extends VBox {

    public Error404(String subtitle, String name) {
        this(subtitle, name, AlertType.INFO);
    }
    public Error404(String subtitle, String name, AlertType type) {
        this.setAlignment(Pos.TOP_CENTER);
        this.setPadding(new Insets(10));

        this.setPadding(new Insets(10));

        this.setSpacing(10);

        Label text = new Label(subtitle);
        text.setWrapText(true);

        System.out.println("name = " + name);
//        Label fileName = new Label("\"" + applicationError.getFileName() + "\"");
        Label fileName = new Label("what");
        fileName.setWrapText(true);
        fileName.getStyleClass().addAll("bold", "text-14");
        fileName.getStyleClass().add("text-success");

        Label forZeroFour = new Label("404");
        forZeroFour.getStyleClass().addAll("txt-" + type.name().toLowerCase(), "bold");
        forZeroFour.setStyle("-fx-font-size: 100px");

        Hyperlink solution = new Hyperlink("Find solution");

        getChildren().addAll(text, forZeroFour,  fileName);
    }

    public Error404(AppContentError error) {
        this.setAlignment(Pos.TOP_CENTER);
        this.setPadding(new Insets(10));

        this.setPadding(new Insets(10));

        this.setSpacing(10);

        Label text = new Label(error.getLocalizedMessage());
        text.setWrapText(true);
        text.setTextAlignment(TextAlignment.CENTER);
        text.setWrapText(true);

//        Label fileName = new Label("\"" + applicationError.getFileName() + "\"");
        Label fileName = new Label(String.format("'%s'", error.getFileName()));
        fileName.setWrapText(true);

        fileName.getStyleClass().addAll("bold", "text-14");
        fileName.getStyleClass().add("text-success");

        Label forZeroFour = new Label("404");
        forZeroFour.getStyleClass().addAll("txt-danger", "bold");
        forZeroFour.setStyle("-fx-font-size: 100px");

        Hyperlink solution = new Hyperlink("Find solution");
        solution.getStyleClass().addAll("txt-danger", "bold", "text-14");

        getChildren().addAll(text, forZeroFour, solution, fileName);
    }


}
