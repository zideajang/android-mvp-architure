package arch.zidea.com.android_mvp_arch.custom;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class ScrollSpeedLinearLayoutManger extends LinearLayoutManager {
    public ScrollSpeedLinearLayoutManger(Context context) {
        super(context);
    }

    public ScrollSpeedLinearLayoutManger(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    @Override
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
        super.smoothScrollToPosition(recyclerView, state, position);
//        RecyclerView.SmoothScroller smoothScroller = new

    }
}
