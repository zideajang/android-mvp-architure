package arch.zidea.com.android_mvp_arch.page.main;

import javax.inject.Inject;

import arch.zidea.com.android_mvp_arch.data.AppRepository;
import arch.zidea.com.android_mvp_arch.data.network.ApiService;
import arch.zidea.com.android_mvp_arch.page.base.BasePresenter;
import arch.zidea.com.android_mvp_arch.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;

public class MainPresenter<V extends MainMvpView> extends BasePresenter<V>
        implements MainMvpPresenter<V>  {

    @Inject
    public MainPresenter(AppRepository appRepository,
                         SchedulerProvider schedulerProvider,
                         CompositeDisposable compositeDisposable) {
        super(appRepository, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onDrawerOptionAboutClick() {

    }
}
