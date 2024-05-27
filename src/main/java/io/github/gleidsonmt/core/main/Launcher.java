package io.github.gleidsonmt.core.main;

import fr.brouillard.oss.cssfx.CSSFX;
import io.github.gleidsonmt.core.App;
import io.github.gleidsonmt.core.internal.IContext;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.scenicview.ScenicView;
//import org.scenicview.ScenicView;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  16/05/2024
 */
public abstract class Launcher extends Application {

    private IContext context = new IContext(this.getClass());

    @Override
    public final void start(Stage stage) throws Exception {
        System.getProperties().put("context", context);

        Scene scene = new Scene((Parent) context.root(), 800, 750);

//        System.out.println("App.class.getResource(\"css/alerts.css\") = " + App.class.getResource("css/alerts.css"));
        scene.getStylesheets().addAll(
                getStylesheet("css/colors.css"),
//                context.assets().getStylesheet("skins.css"),
                getStylesheet("css/skeleton.css"),
                getStylesheet("css/buttons.css"),
                getStylesheet("css/text_field.css"),
                getStylesheet("css/checkbox.css"),
                getStylesheet("css/forms.css"),
                getStylesheet("css/bootstrap.css"),
                getStylesheet("css/hyperlink.css"),
                getStylesheet("css/progressbar.css"),
                getStylesheet("css/typographic.css"),
                getStylesheet("css/properties.css"),
                getStylesheet("css/immersive_scroll.css"),
                getStylesheet("css/alerts.css")
        );
//
        stage.setScene(scene);

        build(context);


        stage.show();

        if (context.isEnableTools()) {
            System.out.println("scene = " + scene);
            ScenicView.show(((Parent) context.root()).getScene());
            CSSFX.start(scene);
        }


//        System.out.println("context.assets().getImage(\"background.jpg\") = " + context.assets().getImage("background.jpg"));
    }

    private String getStylesheet(String name) {
        return App.class.getResource(name).toExternalForm();
    }

    @Override
    public void stop() throws Exception {
        Platform.exit();
    }

    public abstract void build(Context context) throws Exception;
}
