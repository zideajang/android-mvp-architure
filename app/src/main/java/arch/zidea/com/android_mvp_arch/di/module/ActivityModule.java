package arch.zidea.com.android_mvp_arch.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import arch.zidea.com.android_mvp_arch.di.ActivityContext;
import arch.zidea.com.android_mvp_arch.di.PerActivity;
import arch.zidea.com.android_mvp_arch.page.feed.FeedMvpPresenter;
import arch.zidea.com.android_mvp_arch.page.feed.FeedMvpView;
import arch.zidea.com.android_mvp_arch.page.feed.FeedPresenter;
import arch.zidea.com.android_mvp_arch.page.main.MainMvpPresenter;
import arch.zidea.com.android_mvp_arch.page.main.MainMvpView;
import arch.zidea.com.android_mvp_arch.page.main.MainPresenter;
import arch.zidea.com.android_mvp_arch.utils.rx.AppSchedulerProvider;
import arch.zidea.com.android_mvp_arch.utils.rx.SchedulerProvider;
import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity mActivity) {
        this.mActivity = mActivity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }


    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> provideMainPresenter(
            MainPresenter<MainMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    FeedMvpPresenter<FeedMvpView> provideFeedPresenter(
            FeedPresenter<FeedMvpView> presenter
    ){
        return presenter;
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }
}
