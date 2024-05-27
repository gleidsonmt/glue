package io.github.gleidsonmt.core.internal.root;

import io.github.gleidsonmt.core.internal.root.foreground.IForeground;
import javafx.scene.Node;
import javafx.scene.layout.Region;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  16/05/2024
 */
public class IChildAssistance implements ChildAssistance {

    private IRoot root;
    private IForeground foreground;

    int priority = 0; // 0 layout children 1 dialogs 2 boxes

    public IChildAssistance(IRoot root) {
        this.root = root;
        this.foreground = root.getForeground();
    }

    public enum TYPE {
        BOX, DIALOG, FLOAT
    }

    @Override
    public void close() {
        this.root.getChildren().remove(this.root.getChildren().size() -1);
        foreground.close();
    }

    @Override
    public void close(Node node) {
        this.root.getChildren().remove(node);
        foreground.close();
    }

    @Override
    public void close(int index) {
        this.root.getChildren().remove(index);
        foreground.close();
    }

    public void show(TYPE type, Node node) {

        if (node instanceof Region r)  {
            r.setMaxWidth(Region.USE_PREF_SIZE);
            r.setMaxHeight(Region.USE_PREF_SIZE);
        }

//        foreground.toFront();
//        root.getChildren().add(node);

        switch (type){

            case DIALOG ->  {
                foreground.show();
                root.getChildren().add(node);
            }
        }
//        node.toFront();

    }
}
