package io.github.gleidsonmt.core.internal.root.freeze.alert;

import io.github.gleidsonmt.core.internal.root.IChildAssistance;
import io.github.gleidsonmt.core.internal.root.IRoot;
import io.github.gleidsonmt.core.internal.root.freeze.Action;
import io.github.gleidsonmt.core.internal.root.freeze.ActionType;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  20/05/2024
 */
public class IAlert implements Alert {


    private AlertType type = AlertType.INFO;

    protected boolean cancelAction  = false;


    /////
    private final IChildAssistance childAssistance;

    private AlertContainer alertContainer;
    private String title;
    private Region content;
    protected Action[] actions;
    private boolean decoration = true;

    public IAlert(IRoot root) {
        childAssistance = new IChildAssistance(root);
    }

    @Override
    public Alert title(String title) {
        this.title = title;
        return this;
    }

    private String message;

    @Override
    public Alert message(String text) {
        this.message = text;
        return this;
    }

    @Override
    public Alert content(Region _content) {
        this.content = _content;
        return this;
    }

    @Override
    public Alert build() {

        if (title == null) {
            throw new RuntimeException("Title cannot be null");
        }

        if (message == null && content == null) {
            throw new RuntimeException("Content and message cannot be null");
        }

        if (actions == null ) {
            actions = new Action[]{};
        }

        if (content == null) {
            alertContainer = new AlertContainer(
                    childAssistance, type, title, message, decoration, actions
            );
        } else  {
            alertContainer = new AlertContainer(
                    childAssistance, type, title, content, decoration, actions
            );
        }

        return this;
    }

    @Override
    public Alert actions(Action... actions) {
        this.actions = actions;
        return this;
    }

    @Override
    public Alert type(AlertType type) {
        this.type = type;
        return this;
    }

    @Override
    public Alert type(String type) {
        AlertType alertType = Arrays.stream(AlertType.values()).filter(el -> el.name().equalsIgnoreCase(type)).findAny().get();
        type(alertType);
        return this;
    }

    @Override
    public Alert decoration(boolean decoration) {
        this.decoration = decoration;
        return this;
    }

    @Override
    public void show() {
        childAssistance.show(IChildAssistance.TYPE.DIALOG, alertContainer);
        alertContainer.requestFocus();
    }

    @Override
    public void close() {
        childAssistance.close();
    }
}
