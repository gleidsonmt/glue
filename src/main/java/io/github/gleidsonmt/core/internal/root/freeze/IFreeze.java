package io.github.gleidsonmt.core.internal.root.freeze;

import io.github.gleidsonmt.core.internal.root.IRoot;
import io.github.gleidsonmt.core.internal.root.freeze.alert.Alert;
import io.github.gleidsonmt.core.internal.root.freeze.alert.IAlert;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  20/05/2024
 */
public class IFreeze implements Freeze {

    private IRoot root;
    private Alert alert;

    public IFreeze(IRoot root) {
        this.root = root;
    }

    public Alert alert() {
        if (alert == null) alert = new IAlert(root);
        return alert;
    }

}
