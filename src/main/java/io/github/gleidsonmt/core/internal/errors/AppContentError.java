package io.github.gleidsonmt.core.internal.errors;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  17/05/2024
 */
public class AppContentError extends Exception {

    private String fileName;
    private String method;
    private String clazz;

    public AppContentError(String fileName, String message) {
        super(message);
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public String getMethod() {
        return method;
    }

    public String getClazz() {
        return clazz;
    }
}
