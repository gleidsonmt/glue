package io.github.gleidsonmt.core.internal.root;

import io.github.gleidsonmt.core.App;
import io.github.gleidsonmt.core.internal.errors.AppContentError;
import io.github.gleidsonmt.core.internal.root.freeze.alert.AlerStructure;
import io.github.gleidsonmt.core.main.Context;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  20/05/2024
 */
public class ContextEvent extends Event {

    public static final EventType<ContextEvent> ALL = new EventType<>("ALL");

    public static final EventType<ContextEvent> DIALOG_OPEN = new EventType<>(ALL, "DIALOG_OPEN");
    public static final EventType<ContextEvent> DIALOG_CLOSE = new EventType<>(ALL, "DIALOG_CLOSE");

    public static final EventType<ContextEvent> ALERT_OPEN = new EventType<>(ALL, "ALERT_OPEN");
    public static final EventType<ContextEvent> ALERT_CLOSE = new EventType<>(ALL, "ALERT_CLOSE");


    public ContextEvent(EventType<ContextEvent> eventType, AppContentError applicationError) {
        super(eventType);

        Context context = (Context) System.getProperties().get("context");
//        System.out.println("context = " + context);
//        System.out.println("applicationError = " + applicationError.getMessage());
//
//        System.out.println("applicationError = " + applicationError.getLocalizedMessage());
//        System.out.println("applicationError = " + applicationError.getCause());
//        System.out.println("applicationError = " + applicationError.getCause().getMessage());
//
//
//        VBox container = new VBox();
//        container.setPadding(new Insets(10));
//        container.setAlignment(Pos.TOP_CENTER);
//        container.setPrefSize(100, 100);
////        container.getStyleClass().add("bg-red");
//
//        Label text = new Label(applicationError.getCause().getLocalizedMessage());
//        text.setWrapText(true);
//
//        Label fileName = new Label("\"" + applicationError.getFileName() + "\"");
//        fileName.getStyleClass().addAll("bold", "text-18");
//        fileName.getStyleClass().add("text-success");
//
//        VBox scrollContent = new VBox();
//        ScrollPane scrollPane = new ScrollPane(scrollContent);
//        scrollPane.setMinHeight(200);
//
////        Text text = new Text();
////
//
//        Text _text = new Text(applicationError.getStackTrace()[0].getClassName());
//        _text.getStyleClass().addAll("bold", "text-18");
////        for (StackTraceElement line : applicationError.getStackTrace()) {
////            Text _text = new Text(line.getClassName());
//            scrollContent.getChildren().add(_text);
////            text.setText(text.getText() + line.getClassName() + " " );
////        }
//
//
//        Label forZeroFour = new Label("404");
//        forZeroFour.getStyleClass().addAll("txt-danger", "bold");
//        forZeroFour.setStyle("-fx-font-size: 100px");
//
////        applicationError.printStackTrace();
//
////        TextFlow textFlow = new TextFlow(text);
//        container.setSpacing(10);
//        container.getChildren().addAll(text, forZeroFour, fileName);
//        context.freeze().alert().show(applicationError.getLocalizedMessage(), container);

    }
}
