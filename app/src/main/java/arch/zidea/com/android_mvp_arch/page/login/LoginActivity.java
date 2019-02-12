package arch.zidea.com.android_mvp_arch.page.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import arch.zidea.com.android_mvp_arch.R;
import arch.zidea.com.android_mvp_arch.page.base.BaseActivity;

public class LoginActivity extends BaseActivity implements LoginActivityView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    protected void setUp() {

    }

    @Override
    public void openMainActivity() {

    }
}
