package io.github.gleidsonmt.core.internal.root;

import io.github.gleidsonmt.core.internal.root.foreground.IForeground;
import io.github.gleidsonmt.core.main.Layout;
import io.github.gleidsonmt.core.main.Root;
import javafx.scene.layout.StackPane;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  17/05/2024
 */
public class IRoot extends StackPane implements Root {

    private final IForeground IForeground;
    private final StackPane container;
    private Layout layout;

    public IRoot() {
        IForeground = new IForeground();
        container = new StackPane();
        this.getChildren().setAll(IForeground, container);
        setStyle("-fx-background-color: blue;");
    }

    public IForeground getForeground() {
        return this.IForeground;
    }

    public StackPane getContainer() {
        return container;
    }

    @Override
    public void setLayout(Layout layout) {
        this.layout = layout;
        container.getChildren().addAll(layout.getRoot());
    }


}
