package io.github.gleidsonmt.core.internal.root.foreground;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  17/05/2024
 */
public class IForeground extends StackPane implements Foreground {

    private final Timeline timeline;

    public IForeground() {
        this.timeline = new Timeline();

        this.setBackground(
                new Background(
                        new BackgroundFill(
                                Color.gray(0.5),
//                                Color.RED,
                                CornerRadii.EMPTY,
                                Insets.EMPTY)
                )
        );
//        setStyle("-fx-background-color: red;");
    }

    private final EventHandler<KeyEvent> escape = keyEvent -> {
        if (keyEvent.getCode() == KeyCode.ESCAPE) {
            close();
        }
    };

    @Override
    public void show() {
        System.out.println("this.getOpacity() = " + this.getOpacity());
        this.getScene().addEventFilter(KeyEvent.KEY_RELEASED, escape);
        this.toFront();

        timeline.getKeyFrames().setAll(
                new KeyFrame(Duration.ZERO, new KeyValue(
                        this.opacityProperty(), 0
                )),
                new KeyFrame(Duration.millis(200), new KeyValue(
                        this.opacityProperty(), 0.5
                ))
        );
        timeline.setOnFinished(null);
        timeline.play();
    }

    @Override
    public void close() {
        System.out.println(" close " );
        this.getScene().removeEventFilter(KeyEvent.KEY_RELEASED, escape);
        timeline.getKeyFrames().setAll(
                new KeyFrame(Duration.ZERO, new KeyValue(
                        this.opacityProperty(), this.getOpacity()
                )),
                new KeyFrame(Duration.millis(200), new KeyValue(
                        this.opacityProperty(), 0.0
                ))
        );
        timeline.setOnFinished(e -> {
//            this.root.removeIf(child -> child.getStyleClass().contains("dialog-box"));
            this.toBack();
            this.setOpacity(1D);
        });
        timeline.play();
    }

}
