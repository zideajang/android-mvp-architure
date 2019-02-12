package arch.zidea.com.android_mvp_arch.page.feed;

import java.util.List;

import arch.zidea.com.android_mvp_arch.page.base.MvpView;
import arch.zidea.com.android_mvp_arch.ui.decorator.Visitable;
import arch.zidea.com.android_mvp_arch.ui.model.RepoModel;

public interface FeedMvpView extends MvpView {
    void showList(List<RepoModel> list);
}
