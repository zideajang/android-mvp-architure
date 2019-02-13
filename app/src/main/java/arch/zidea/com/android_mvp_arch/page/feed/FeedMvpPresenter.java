package arch.zidea.com.android_mvp_arch.page.feed;

import arch.zidea.com.android_mvp_arch.page.base.MvpPresenter;

public interface FeedMvpPresenter<V extends FeedMvpView> extends MvpPresenter<V> {
    void loadList(int page);
}
