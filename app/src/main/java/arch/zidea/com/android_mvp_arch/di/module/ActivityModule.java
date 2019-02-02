package arch.zidea.com.android_mvp_arch.di.module;

import android.support.v7.app.AppCompatActivity;

import dagger.Module;

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity mActivity) {
        this.mActivity = mActivity;
    }
}
