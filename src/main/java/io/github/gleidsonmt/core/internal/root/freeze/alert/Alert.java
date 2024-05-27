package io.github.gleidsonmt.core.internal.root.freeze.alert;

import io.github.gleidsonmt.core.internal.root.freeze.Action;
import javafx.scene.layout.Region;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  20/05/2024
 */
public interface Alert {

    Alert title(String title);

    Alert message(String text);

    Alert content(Region content);

    Alert build();

    Alert actions(Action... actions);

    Alert type(AlertType type);

    Alert type(String type);

    Alert decoration(boolean decoration);

    void show();

    void close();
}
