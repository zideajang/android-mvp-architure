package arch.zidea.com.android_mvp_arch.ui.viewholder;

import android.view.View;
import android.widget.TextView;

import arch.zidea.com.android_mvp_arch.R;
import arch.zidea.com.android_mvp_arch.ui.base.BaseViewHolder;
import arch.zidea.com.android_mvp_arch.ui.model.TipModel;
import butterknife.BindView;
import butterknife.ButterKnife;

public class TipViewHolder extends BaseViewHolder<TipModel> {

    private ViewHolder mViewHolder;

    public TipViewHolder(View itemView) {
        super(itemView);

        mViewHolder = new ViewHolder(itemView);
    }

    @Override
    public void bindViewData(TipModel data) {
        mViewHolder.tipMessageTextView.setText(data.getMessage());

    }

    static class ViewHolder{
        @BindView(R.id.panel_tip_textView)
        TextView tipMessageTextView;

        ViewHolder(View view){
            ButterKnife.bind(this,view);
        }
    }
}
