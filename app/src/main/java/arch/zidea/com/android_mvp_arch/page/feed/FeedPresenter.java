package arch.zidea.com.android_mvp_arch.page.feed;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import arch.zidea.com.android_mvp_arch.data.AppRepository;
import arch.zidea.com.android_mvp_arch.page.base.BasePresenter;
import arch.zidea.com.android_mvp_arch.ui.model.RepoModel;
import arch.zidea.com.android_mvp_arch.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;

public class FeedPresenter<V extends FeedMvpView> extends BasePresenter<V> implements FeedMvpPresenter<V>{

    @Inject
    public FeedPresenter(AppRepository appRepository, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(appRepository, schedulerProvider, compositeDisposable);
    }

    @Override
    public void loadList() {

        List<RepoModel> mList = new ArrayList<>();
        mList.add(new RepoModel("标题1"));
        mList.add(new RepoModel("标题2"));
        mList.add(new RepoModel("标题3"));
        mList.add(new RepoModel("标题4"));
        mList.add(new RepoModel("标题5"));

        getMvpView().showList(mList);
    }
}
