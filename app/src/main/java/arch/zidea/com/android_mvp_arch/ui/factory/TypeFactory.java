package arch.zidea.com.android_mvp_arch.ui.factory;

import android.view.View;

import arch.zidea.com.android_mvp_arch.ui.base.BaseViewHolder;
import arch.zidea.com.android_mvp_arch.ui.model.RepoModel;

public interface TypeFactory {
    int type(RepoModel repoModel);
    BaseViewHolder createViewHolder(int type, View itemView);
}
