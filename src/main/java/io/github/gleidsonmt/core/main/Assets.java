package io.github.gleidsonmt.core.main;

import javafx.scene.image.Image;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

import java.net.URL;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  16/05/2024
 */
public interface Assets {
    /**
     * Get the image in build folder, without explicit the path
     * Supported formats [.png, .jpg, .jpeg]
     * @param imageName The name of the image
     * @return The image
     */
    Image getImage(String imageName);

    /**
     * Get the image in build folder, without explicit the path
     * * Supported formats same as @see #getImage(String)
     * @param logoName The name of the logo
     * @return The logo
     */
    Image getLogo(String logoName);

    /**
     * Get the stylesheet in build folder, without explicit the path
     * @param stylesheetName The name of the stylesheet
     * @return The stylesheet.
     */
    String getStylesheet(@NotNull String stylesheetName);

    @Deprecated(forRemoval = true)
    URL getResource(String url);

    @ApiStatus.Experimental
    String getFont(String fontName) throws Exception;

    @ApiStatus.Experimental
    String getFont(String fontDir, String fontName) throws Exception;

}
