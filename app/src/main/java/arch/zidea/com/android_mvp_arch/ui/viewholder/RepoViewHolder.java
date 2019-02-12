package arch.zidea.com.android_mvp_arch.ui.viewholder;

import android.view.View;
import android.widget.TextView;

import arch.zidea.com.android_mvp_arch.R;
import arch.zidea.com.android_mvp_arch.ui.base.BaseViewHolder;
import arch.zidea.com.android_mvp_arch.ui.model.RepoModel;
import butterknife.BindView;
import butterknife.ButterKnife;

public class RepoViewHolder extends BaseViewHolder<RepoModel> {

    private ViewHolder mViewHolder;

    public RepoViewHolder(View itemView) {
        super(itemView);
        if(mViewHolder == null){
            mViewHolder = new ViewHolder(itemView);
            itemView.setTag(mViewHolder);
        }else {
            mViewHolder = (ViewHolder) itemView.getTag();
        }
    }

    @Override
    public void bindViewData(RepoModel data) {
        mViewHolder.repoTitleTextView.setText(data.getTitle());
    }

    static class ViewHolder{
        @BindView(R.id.panel_repo_title)
        TextView repoTitleTextView;

        ViewHolder(View view){
            ButterKnife.bind(this,view);
        }
    }
}
