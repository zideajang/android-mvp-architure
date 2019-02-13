package arch.zidea.com.android_mvp_arch.ui.factory;

import android.view.View;

import arch.zidea.com.android_mvp_arch.ui.base.BaseViewHolder;
import arch.zidea.com.android_mvp_arch.ui.model.RepoModel;
import arch.zidea.com.android_mvp_arch.ui.model.TipModel;

public interface TypeFactory {
    int type(RepoModel repoModel);
    int type(TipModel tipModel);
    BaseViewHolder createViewHolder(int type, View itemView);
}
