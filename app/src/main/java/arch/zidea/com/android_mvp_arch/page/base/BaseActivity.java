package arch.zidea.com.android_mvp_arch.page.base;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;

import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity
        implements MvpView, BaseFragment.Callback{

    private ProgressDialog mProgressDialog;
    private Unbinder mUnBinder;


}
