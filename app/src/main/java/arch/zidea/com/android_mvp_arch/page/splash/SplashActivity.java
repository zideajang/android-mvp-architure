package arch.zidea.com.android_mvp_arch.page.splash;

import android.os.Bundle;

import arch.zidea.com.android_mvp_arch.R;
import arch.zidea.com.android_mvp_arch.page.base.BaseActivity;

public class SplashActivity extends BaseActivity implements SplashActivityView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void setUp() {

    }

    @Override
    public void openMainActivity() {

    }
}
