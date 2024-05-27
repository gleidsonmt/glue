package io.github.gleidsonmt.core.internal;


import io.github.gleidsonmt.core.internal.assets.IAssets;
import io.github.gleidsonmt.core.internal.root.ContextEvent;
import io.github.gleidsonmt.core.internal.root.IRoot;
import io.github.gleidsonmt.core.internal.root.freeze.Freeze;
import io.github.gleidsonmt.core.internal.root.freeze.IFreeze;
import io.github.gleidsonmt.core.internal.root.freeze.alert.Alert;
import io.github.gleidsonmt.core.internal.root.freeze.alert.IAlert;
import io.github.gleidsonmt.core.main.Assets;
import io.github.gleidsonmt.core.main.Context;
import io.github.gleidsonmt.core.main.Root;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  16/05/2024
 */
public class IContext implements Context {

    private final Assets assets;
    private final IRoot root;
    private final Alert alert;

    private Freeze freeze;

    public IContext(Class<?> clazz) {
        assets = new IAssets(clazz);

        this.root = new IRoot();
        this.alert = new IAlert((IRoot) this.root);
    }

    public void fireEvent(ContextEvent contextEvent) {
        ((IRoot) this.root).fireEvent(contextEvent);
    }

    @Override
    public Assets assets() {
        return assets;
    }

    @Override
    public Freeze freeze() {
        if (freeze == null) freeze = new IFreeze(root);
        return freeze;
    }



    private boolean enableTools;

    public boolean isEnableTools() {
        return enableTools;
    }

    @Override
    public void enableTools() {
        this.enableTools = true;
    }

    @Override
    public Root root() {
        return root;
    }
}
