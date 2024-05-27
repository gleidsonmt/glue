package io.github.gleidsonmt.core.internal.root.freeze;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  04/05/2024
 */
public record Action(ActionType type, EventHandler<ActionEvent> eventHandler) {


}
