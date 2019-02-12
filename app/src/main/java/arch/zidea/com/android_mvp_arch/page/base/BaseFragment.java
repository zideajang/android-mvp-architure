package arch.zidea.com.android_mvp_arch.page.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import arch.zidea.com.android_mvp_arch.di.component.ActivityComponent;
import arch.zidea.com.android_mvp_arch.utils.CommonUtils;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment implements MvpView{

    private BaseActivity mActivity;
    private Unbinder mUnBinder;
    private ProgressDialog mProgressDialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUp(view);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof BaseActivity){
            BaseActivity activity = (BaseActivity) context;
            this.mActivity = activity;
            activity.onFragmentAttached();
        }
    }

    @Override
    public void showLoading() {
        hideLoading();
        mProgressDialog = CommonUtils.showLoadingDialog(this.getContext());
    }

    @Override
    public void hideLoading() {
        if(mProgressDialog != null && mProgressDialog.isShowing()){
            mProgressDialog.cancel();
        }
    }


    @Override
    public void onError(int resId) {

    }

    @Override
    public void onError(String message) {
        if(mActivity != null){
            mActivity.onError(message);
        }
    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void showMessage(int resId) {

    }

    @Override
    public boolean isNetworkConnected() {
        return false;
    }

    @Override
    public void hideKeyboard() {

    }

//    public ActivityComponent getActivityComponent(){
//        if(mActivity != null){
//
//        }
//    }


    public BaseActivity getBaseActivity(){
        return mActivity;
    }

    public void setUnBinder(Unbinder unBinder){
        mUnBinder = unBinder;
    }

    protected abstract void setUp(View view);

    @Override
    public void onDestroy() {
        if(mUnBinder != null){
            mUnBinder.unbind();
        }
        super.onDestroy();
    }

    public interface Callback {

        void onFragmentAttached();

        void onFragmentDetached(String tag);
    }
}
