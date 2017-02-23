package jp.co.zenrin.music.play;

import android.app.Activity;
import android.app.Application;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;

/**
 * Created by v_hoang@zenrin-datacom.net on 2017/02/23.
 */

public class HondaPlayApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // Register to be informed of activities starting up
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                // If new activity is created,force its orientation to portrait
                activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }
}
