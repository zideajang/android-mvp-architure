package arch.zidea.com.android_mvp_arch.page.main;

import arch.zidea.com.android_mvp_arch.page.base.MvpPresenter;

public interface MainMvpPresenter <V extends MainMvpView> extends MvpPresenter<V> {
    void onDrawerOptionAboutClick();
}
