package io.github.gleidsonmt.core.internal.assets;

import io.github.gleidsonmt.core.internal.IContext;
import io.github.gleidsonmt.core.internal.errors.AppContentError;
import io.github.gleidsonmt.core.internal.root.ContextEvent;
import io.github.gleidsonmt.core.internal.root.freeze.Action;
import io.github.gleidsonmt.core.internal.root.freeze.ActionType;
import io.github.gleidsonmt.core.internal.root.freeze.alert.AlertType;
import io.github.gleidsonmt.core.main.Assets;
import javafx.scene.image.Image;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  16/05/2024
 */
public class IAssets implements Assets {

    private final Class<?> loaderClass;

    public IAssets(Class<?> clazz) {
        this.loaderClass = clazz;
    }

    private enum Type {
        CSS, IMG, FONT, LOGO
    }

    @Override
    public Image getImage(String imageName) {

        if (!imageName.contains(".png")
                || !imageName.contains(".jpg")
                || !imageName.contains(".jpeg")
        ) {
            errorWrongType(imageName);
            return null;
        }

        File file = getFile(Type.IMG, imageName);

        if (file != null) {
            try {
                return new Image(new FileInputStream(file));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        return null;
    }

    @Override
    public Image getLogo(String logoName) {
        File file = getFile(Type.LOGO, logoName);

        try {
            return new Image(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    private File getFile(Type type, String name) {

        String pathBuild = "./build/resources/main/";
        String module = loaderClass.getModule().getName().replaceAll("\\.", "/");

        String low = type.toString().toLowerCase();
        module += (!name.contains("/") ? "/" + low + "/" : "/" + low);
        File file = new File(pathBuild + module + name);

        if (file.exists()) {
            return file;
        } else {

            AppContentError error = new AppContentError(name,"Building folder or resources doens't exist or contains the file.");

            IContext context = (IContext) System.getProperties().get("context");
            context.freeze().alert()
                    .type(AlertType.DANGER)
                    .decoration(true)
                    .title("Could not find this file")
                    .content(new Error404(error))
                    .build()
                    .show();

            context.fireEvent(new ContextEvent(ContextEvent.ALERT_OPEN, error));

            return null;
        }
    }

    public void errorWrongType(String name) {

        AppContentError error = new AppContentError(name,"Could not find this file, because don't exist file with this extension in build folder.");

        IContext context = (IContext) System.getProperties().get("context");
        context.freeze().alert()
                .type(AlertType.DANGER)
                .decoration(true)
                .title("Incorrect file type.")
                .content(new Error404(error))
                .build()
                .show();

        context.fireEvent(new ContextEvent(ContextEvent.ALERT_OPEN, error));
    }

    @Override
    public String getStylesheet(@NotNull String stylesheetName) {

        if (!stylesheetName.contains(".css")) {
            errorWrongType(stylesheetName);
            return "";
        }

        File file = getFile(Type.CSS, stylesheetName);

        if (file != null) {
            try {
                URL url = new URL("file:" + file.getAbsolutePath());
                return url.toExternalForm();
            } catch (IOException e) {

//            throw new RuntimeException(e);
//                return null;
            }
        }

////      example of url
////      file:/C:/Users/Gleidson/IntelliJIDEAProjects/Light/build/resources/main/io/github/gleidsonmt/light/css/immersive_scroll.css
//

        return "";
    }

    public URL getResource(String resource) {
        return null;
    }

    @Override
    public String getFont(String fontName) throws Exception {
        return "";
    }

    @Override
    public String getFont(String fontDir, String fontName) throws Exception {
        return "";
    }


}
