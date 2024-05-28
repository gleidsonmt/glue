package io.github.gleidsonmt.core;

import io.github.gleidsonmt.core.main.Classe;
import io.github.gleidsonmt.core.main.Context;
import io.github.gleidsonmt.core.main.Launcher;
import io.github.gleidsonmt.core.main.Layout;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  16/05/2024
 */
public class App extends Launcher {

    @Override
    public void build(Context context) throws Exception {

        context.root().setLayout(new Layout() {

            private StackPane root = new StackPane();
            {
                ImageView imageView = new ImageView();
                imageView.setImage(context.assets().getImage("imae.png"));
                root.getChildren().add(imageView);
            }


            @Override
            public void setView() {

            }

            @Override
            public Region getRoot() {
                return root;
            }
        });

        context.enableTools();
    }

    public static void main(String[] args) {
//        System.exit(0);
        launch(args);

    }
}
