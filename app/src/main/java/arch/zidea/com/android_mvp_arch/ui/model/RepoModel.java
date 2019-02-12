package arch.zidea.com.android_mvp_arch.ui.model;

import arch.zidea.com.android_mvp_arch.ui.decorator.Visitable;
import arch.zidea.com.android_mvp_arch.ui.factory.TypeFactory;

public class RepoModel implements Visitable {

    private String title;

    public RepoModel(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int type(TypeFactory typeFactory) {
        return typeFactory.type(this);
    }
}
