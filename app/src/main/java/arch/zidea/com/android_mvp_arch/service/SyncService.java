package arch.zidea.com.android_mvp_arch.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class SyncService extends Service {

    private static final String TAG = "SyncService";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
