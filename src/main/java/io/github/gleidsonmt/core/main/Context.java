package io.github.gleidsonmt.core.main;


import io.github.gleidsonmt.core.internal.root.freeze.Freeze;
import io.github.gleidsonmt.core.internal.root.freeze.alert.Alert;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  16/05/2024
 */
public interface Context {

    Root root();

    Assets assets();

    Freeze freeze();

    /**
     * Enable ScenicView and CSSFX
     * ScenicView is a fast way to view your app in execution.
     * CSSFX allow you to write and modify css when the application is running.
     */
    void enableTools();

}
