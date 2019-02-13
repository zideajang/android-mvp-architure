package arch.zidea.com.android_mvp_arch.page.feed;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import arch.zidea.com.android_mvp_arch.R;
import arch.zidea.com.android_mvp_arch.page.base.BaseActivity;
import arch.zidea.com.android_mvp_arch.ui.base.MultiRecyclerViewAdapter;
import arch.zidea.com.android_mvp_arch.ui.base.interfaces.OnLoadMoreListener;
import arch.zidea.com.android_mvp_arch.ui.decorator.Visitable;
import arch.zidea.com.android_mvp_arch.ui.model.RepoModel;
import arch.zidea.com.android_mvp_arch.ui.model.TipModel;
import butterknife.BindView;
import butterknife.ButterKnife;

public class FeedActivity extends BaseActivity implements FeedMvpView{

    private static final String TAG = "FeedActivity";

    @Inject
    FeedMvpPresenter<FeedMvpView> mPresenter;
    @Inject
    LinearLayoutManager linearLayoutManager;

    @BindView(R.id.feed_recyeclerView)
    RecyclerView mRecyclerView;

    int page = 1;

    private MultiRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));

        setUp();

        mPresenter.onAttach(this);
        mPresenter.loadList(page);

    }

    @Override
    protected void setUp() {
        mRecyclerView.setLayoutManager(linearLayoutManager);
        List<Visitable> mList = new ArrayList<>();
        adapter = new MultiRecyclerViewAdapter(mList);
        adapter.enableIsAutoLoadMore();
        adapter.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(boolean isReload) {
                mPresenter.loadList(page);
            }
        });
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void showList(List<RepoModel> list
    ) {

        if(adapter != null){
            List<Visitable> mList = adapter.getmData();

            if(list.size() == 0){
                mList.add(new TipModel("没有更多数据"));
            }else {

                mList.addAll(list);

                if(adapter.isLoadingMore()){
                    adapter.setLoadingMore(false);
                }
                Log.d(TAG, "showList: " + mList.size());
//                mRecyclerView.smoothScrollToPosition(mList.size());
                page++;
                mPresenter.loadList(page);
            }
            adapter.notifyDataSetChanged();

        }


    }
}
