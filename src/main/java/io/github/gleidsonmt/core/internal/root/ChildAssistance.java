package io.github.gleidsonmt.core.internal.root;

import javafx.scene.Node;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  16/05/2024
 */
public interface ChildAssistance {

    void close();

    void close(Node node);

    void close(int index);

}
