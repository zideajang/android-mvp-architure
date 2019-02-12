package arch.zidea.com.android_mvp_arch.page.feed;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import arch.zidea.com.android_mvp_arch.R;
import arch.zidea.com.android_mvp_arch.page.base.BaseActivity;
import arch.zidea.com.android_mvp_arch.ui.base.MultiRecyclerViewAdapter;
import arch.zidea.com.android_mvp_arch.ui.decorator.Visitable;
import arch.zidea.com.android_mvp_arch.ui.model.RepoModel;
import butterknife.BindView;
import butterknife.ButterKnife;

public class FeedActivity extends BaseActivity implements FeedMvpView{

    @Inject
    FeedMvpPresenter<FeedMvpView> mPresenter;
    @Inject
    LinearLayoutManager linearLayoutManager;

    @BindView(R.id.feed_recyeclerView)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);

        mPresenter.loadList();

    }

    @Override
    protected void setUp() {

    }

    @Override
    public void showList(List<RepoModel> list
    ) {
        mRecyclerView.setLayoutManager(linearLayoutManager);
        List<Visitable> mList = new ArrayList<>();
        mList.addAll(list);
        MultiRecyclerViewAdapter adapter = new MultiRecyclerViewAdapter(mList);
        mRecyclerView.setAdapter(adapter);
    }
}
