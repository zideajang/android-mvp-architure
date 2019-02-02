package arch.zidea.com.android_mvp_arch.page.base;

import com.androidnetworking.error.ANError;

public interface MvpPresenter<V extends MvpView>{
    void onAttach(V mvpView);

    void onDetach();

    void handleApiError(ANError error);

}
