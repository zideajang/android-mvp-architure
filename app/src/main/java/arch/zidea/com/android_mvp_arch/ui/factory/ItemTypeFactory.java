package arch.zidea.com.android_mvp_arch.ui.factory;

import android.util.Log;
import android.view.View;

import arch.zidea.com.android_mvp_arch.R;
import arch.zidea.com.android_mvp_arch.ui.base.BaseViewHolder;
import arch.zidea.com.android_mvp_arch.ui.factory.TypeFactory;
import arch.zidea.com.android_mvp_arch.ui.model.RepoModel;
import arch.zidea.com.android_mvp_arch.ui.model.TipModel;
import arch.zidea.com.android_mvp_arch.ui.viewholder.RepoViewHolder;
import arch.zidea.com.android_mvp_arch.ui.viewholder.TipViewHolder;

public class ItemTypeFactory implements TypeFactory {

    public static final int PANEL_SEPERATOR =
            R.layout.panel_repo;

    public static final int PANEL_TIP =
            R.layout.panel_tip;


    @Override
    public int type(RepoModel repoModel) {
        return PANEL_SEPERATOR;
    }

    @Override
    public int type(TipModel tipModel) {
        return PANEL_TIP;
    }

    @Override
    public BaseViewHolder createViewHolder(int type, View itemView) {
        switch (type){
            case PANEL_SEPERATOR:
                return new RepoViewHolder(itemView);

            case PANEL_TIP:
                return new TipViewHolder(itemView);
            default:
                return null;
        }
    }
}
