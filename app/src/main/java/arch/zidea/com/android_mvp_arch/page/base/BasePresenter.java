package arch.zidea.com.android_mvp_arch.page.base;

import com.androidnetworking.error.ANError;

import javax.inject.Inject;

import arch.zidea.com.android_mvp_arch.data.AppRepository;
import arch.zidea.com.android_mvp_arch.data.network.ApiService;
import arch.zidea.com.android_mvp_arch.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;

public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

    private final AppRepository appRepository;
    private final SchedulerProvider mSchedulerProvider;
    private final CompositeDisposable mCompositeDisposable;

    private V mMvpView;

    @Inject
    public BasePresenter(AppRepository appRepository,
                         SchedulerProvider schedulerProvider,
                         CompositeDisposable compositeDisposable) {
        this.appRepository = appRepository;
        this.mSchedulerProvider = schedulerProvider;
        this.mCompositeDisposable = compositeDisposable;
    }

    @Override
    public void onAttach(V mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void onDetach() {
        mCompositeDisposable.dispose();
        mMvpView = null;
    }

    public boolean isViewAttached() {
        return mMvpView != null;
    }

    public V getMvpView() {
        return mMvpView;
    }

    public AppRepository getAppRepository() {
        return appRepository;
    }

    public SchedulerProvider getSchedulerProvider() {
        return mSchedulerProvider;
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }


    @Override
    public void handleApiError(ANError error) {

    }
}
