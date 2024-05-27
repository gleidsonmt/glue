package io.github.gleidsonmt.core.internal.root.freeze.alert;

import io.github.gleidsonmt.core.internal.root.ChildAssistance;
import io.github.gleidsonmt.core.internal.root.freeze.Action;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  22/05/2024
 */
public class AlertContainer extends StackPane {

    private String title;
    private VBox content = new VBox();
    private boolean decoration = true;
    private ChildAssistance childAssistance;

    public AlertContainer(ChildAssistance childAssistance, AlertType type, String title, String message, boolean decoration, Action... actions) {
        this.title = title;
        this.decoration = decoration;
        this.childAssistance  = childAssistance;
        getStyleClass().addAll("alert-container");

        if (decoration) {
            this.getChildren().addAll(createBackground(type), createContainer(message, type, actions));
        } else {
            this.getChildren().addAll( createContainer(message, type, actions));
        }


//        setPrefSize(400, 300);
        setPrefWidth(400);
    }

    public AlertContainer(ChildAssistance childAssistance, AlertType type, String title, Region content, boolean decoration, Action... actions) {
        this.childAssistance  = childAssistance;
        this.title = title;
        this.decoration = decoration;
        getStyleClass().addAll("alert-container");

        if (decoration) {
            this.getChildren().addAll(createBackground(type), createContainer(content, type, actions));
        } else {
            this.getChildren().addAll( createContainer(content, type, actions));
        }

//        setPrefSize(400, 300);
        setPrefWidth(400);
    }

    private StackPane createBackground(AlertType type) {
        StackPane background = new StackPane();
        background.getStyleClass().addAll("alert-background");

        switch (type) {
            case DANGER -> background.getStyleClass().add("alert-background-danger");
            case SUCCESS -> background.getStyleClass().add("alert-background-success");
            case WARNING -> background.getStyleClass().add("alert-background-warning");
            case INFO -> background.getStyleClass().add("alert-background-info");
        }

        StackPane.setAlignment(background, Pos.CENTER);
        background.setTranslateY(-20);

        return background;
    }

    private VBox createContainer(Region region, AlertType type, Action... actions) {
        VBox container = new VBox();
        container.getStyleClass().addAll("alert-content");
        container.setAlignment(Pos.CENTER);
        container.getChildren().addAll(createTitle(this.title), createSeparator(), region, createSeparator(), createActions(type, actions));
        return container;
    }

    private VBox createContainer(String _message, AlertType type, Action... actions) {
        VBox container = new VBox();
        container.getStyleClass().addAll("alert-content");
        container.setAlignment(Pos.CENTER);
        Label message = new Label(_message);
        message.setWrapText(true);
        VBox.setMargin(message, new Insets(10));
        container.getChildren().addAll(createTitle(this.title), createSeparator(), message, createSeparator(), createActions(type, actions));
        container.setFocusTraversable(false);
        return container;
    }

    public Region createSeparator() {
        Separator container = new Separator();
        VBox.setMargin(container, new Insets(0,10,0,10));
        return container;
    }

    private Label createTitle(String text) {
        Label container = new Label(text);
        container.getStyleClass().addAll("bold", "h4");
        container.setPadding(new Insets(5));
        VBox.setMargin(container, new Insets(10));

        return container;
    }

    public Region createActions(AlertType type, Action... actions) {

        HBox container = new HBox();

        if (actions.length > 0) {

            for (Action action : actions) {
                Button button = new Button(action.type().name().toUpperCase());
                button.getStyleClass().add(action.type().name().toUpperCase());
                button.addEventFilter(ActionEvent.ACTION, e -> childAssistance.close(this));
                button.addEventHandler(ActionEvent.ACTION, action.eventHandler());
                container.getChildren().add(button);

                switch (action.type()) {
                    case CANCEL -> button.setCancelButton(true);
                    case OK, CONFIRM -> button.setDefaultButton(true);
                }
            }
        } else {
            Button button = new Button("Ok");
            button.setDefaultButton(true);
            button.addEventHandler(ActionEvent.ACTION, e -> childAssistance.close(this));
//            button.setOnAction(e -> childAssistance.close(this));
            container.getChildren().setAll(button);
//            button.getScene().
        }

        switch (type) {
            case DANGER -> container.getChildren().forEach(e -> e.getStyleClass().add("btn-danger"));
            case WARNING -> container.getChildren().forEach(e -> e.getStyleClass().add("btn-warning"));
            case SUCCESS -> container.getChildren().forEach(e -> e.getStyleClass().add("btn-success"));
            case INFO -> container.getChildren().forEach(e -> e.getStyleClass().add("btn-info"));
        }

        container.setAlignment(Pos.CENTER);
        VBox.setMargin(container, new Insets(10));
        return container;
    }

    public void initialFocus() {

    }
}
