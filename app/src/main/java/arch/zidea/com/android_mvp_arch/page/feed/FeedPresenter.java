package arch.zidea.com.android_mvp_arch.page.feed;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import arch.zidea.com.android_mvp_arch.data.AppRepository;
import arch.zidea.com.android_mvp_arch.page.base.BasePresenter;
import arch.zidea.com.android_mvp_arch.ui.model.RepoModel;
import arch.zidea.com.android_mvp_arch.utils.rx.SchedulerProvider;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class FeedPresenter<V extends FeedMvpView> extends BasePresenter<V> implements FeedMvpPresenter<V>{

    private static final String TAG = "FeedPresenter";

    @Inject
    public FeedPresenter(AppRepository appRepository, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(appRepository, schedulerProvider, compositeDisposable);
    }

    @Override
    public void loadList(final int page) {

        Disposable disposable = Observable.timer(1000,TimeUnit.MILLISECONDS)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {

                        Log.d(TAG, "accept: " + page);

                        List<RepoModel> mList = new ArrayList<>();
                        int amount = 15;
                        if(page < 3) {
                            for (int i = (page - 1) * amount; i < page * amount; i++) {
                                mList.add(new RepoModel("标题" + i));
                            }
                            getMvpView().showList(mList);

                        }else {
                            getMvpView().showList(new ArrayList<RepoModel>());
                        }

                    }
                });

        getCompositeDisposable().add(disposable);

    }
}
