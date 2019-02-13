package arch.zidea.com.android_mvp_arch.ui.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
import java.util.WeakHashMap;

import arch.zidea.com.android_mvp_arch.ui.base.interfaces.OnLoadMoreListener;
import arch.zidea.com.android_mvp_arch.ui.factory.ItemTypeFactory;
import arch.zidea.com.android_mvp_arch.ui.decorator.Visitable;
import arch.zidea.com.android_mvp_arch.ui.factory.TypeFactory;

public class MultiRecyclerViewAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private static final String TAG = "MultiRecyclerViewAdapte";

    List<Visitable> mData;
    TypeFactory typeFactory;
    LayoutInflater layoutInflater;

    private OnLoadMoreListener mOnLoadMoreListener;

    private boolean mIsAutoLoadMore = false;
    private boolean isLoadingMore = false;

    WeakHashMap<Integer,BaseViewHolder> hashMap = new WeakHashMap<>();

    public void setOnLoadMoreListener(OnLoadMoreListener mOnLoadMoreListener) {
        this.mOnLoadMoreListener = mOnLoadMoreListener;
    }

    public MultiRecyclerViewAdapter(List<Visitable> mData) {

        this.mData = mData;
        this.typeFactory = new ItemTypeFactory();

    }

    public void enableIsAutoLoadMore(){
        mIsAutoLoadMore = true;
    }

    public List<Visitable> getmData() {
        return mData;
    }

    public void setmData(List<Visitable> mData) {
        this.mData = mData;
    }

    public boolean isLoadingMore() {
        return isLoadingMore;
    }

    public void setLoadingMore(boolean loadingMore) {
        isLoadingMore = loadingMore;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        layoutInflater = (LayoutInflater) parent.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(viewType,parent,false);

        return typeFactory.createViewHolder(viewType,view);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.bindViewData(mData.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        return mData.get(position).type(typeFactory);
    }


    @Override
    public int getItemCount() {
        return (mData != null ? mData.size() : 0);
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        final RecyclerView.LayoutManager layoutManager  = recyclerView.getLayoutManager();

        startLoadMore(recyclerView,layoutManager);
    }



    private void startLoadMore(RecyclerView recyclerView, final RecyclerView.LayoutManager layoutManager){
        if(!mIsAutoLoadMore){
            return;
        }

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(newState == RecyclerView.SCROLL_STATE_IDLE){
                    if(layoutManager instanceof LinearLayoutManager){
                        LinearLayoutManager linearManager = (LinearLayoutManager) layoutManager;

                        int lastVisibleItem = linearManager.findLastVisibleItemPosition();
                        int totalItemCount = getItemCount();

                        if( lastVisibleItem  >= totalItemCount - 3 ){
                            Log.d(TAG, "onScrollStateChanged: 加载数据");

                            if(!isLoadingMore){
                                scrollLoadMore();
                                isLoadingMore = true;
                            }

                        }
                        
                    }
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                Log.d(TAG, "onScrolled: " + dy);
            }
        });

    }

    private void scrollLoadMore(){
        mOnLoadMoreListener.onLoadMore(false);
    }


}
