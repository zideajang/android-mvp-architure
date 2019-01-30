package arch.zidea.com.android_mvp_arch.ui.base;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

import arch.zidea.com.android_mvp_arch.ui.decorator.Visitable;

public abstract class BaseViewHolder<T extends Visitable> extends RecyclerView.ViewHolder {

    private SparseArray<View> mViews;
    private View mItemView;

    public BaseViewHolder(View itemView) {
        super(itemView);
        mItemView = itemView;
        mViews = new SparseArray<>();
    }

    /**
     * 根据id 获取视图
     * @param resId
     * @return
     */
    public View getView(int resId){
        View view = mViews.get(resId);

        if(view == null){
            view = mItemView.findViewById(resId);
            mViews.put(resId, view);
        }
        return view;
    }

    /**
     * 将数据与视图绑定
     * @param data
     */
    public abstract void bindViewData(T data);

}
