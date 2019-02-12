package arch.zidea.com.android_mvp_arch.page.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import arch.zidea.com.android_mvp_arch.R;
import arch.zidea.com.android_mvp_arch.page.base.BaseActivity;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainMvpView{

    @Inject
    MainMvpPresenter<MainMvpView> mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);
    }

    @Override
    protected void setUp() {

    }

    @Override
    public void openLoginActivity() {

    }
}
