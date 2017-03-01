package jp.co.zenrin.music.notification;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;

import java.util.Calendar;
import java.util.Date;

import jp.co.zenrin.music.service.AINotificationIntentService;

/**
 * Created by v_hoang on 2/28/2017.
 */

public class AIRecommendReceiver extends WakefulBroadcastReceiver {

    private static final String ACTION_START_NOTIFICATION_SERVICE = "ACTION_START_NOTIFICATION_SERVICE";
    private static final String ACTION_DELETE_NOTIFICATION = "ACTION_DELETE_NOTIFICATION";

    private static final int NOTIFICATIONS_INTERVAL_IN_MINUTE = 1;


    public static void setupNotify(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        PendingIntent alarmIntent = getStartPendingIntent(context);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                getTriggerAt(new Date()), AlarmManager.INTERVAL_FIFTEEN_MINUTES/60, alarmIntent);
    }

    /**
     * Cancel send notification
     * @param context
     */
    public static void cancelNotify(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        PendingIntent alarmIntent = getStartPendingIntent(context);
        alarmManager.cancel(alarmIntent);
    }

    /**
     * Get trigger time
     * @param now
     * @return time of trigger
     */
    private static long getTriggerAt(Date now) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        return calendar.getTimeInMillis();
    }

    /**
     *
     * @param context
     * @return
     */
    private static PendingIntent getStartPendingIntent(Context context) {
        Intent intent = new Intent(context, AIRecommendReceiver.class);
        intent.setAction(ACTION_START_NOTIFICATION_SERVICE);
        return PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
    }

    /**
     *
     * @param context
     * @return
     */
    public static PendingIntent getDeleteIntent(Context context) {
        Intent intent = new Intent(context, AIRecommendReceiver.class);
        intent.setAction(ACTION_DELETE_NOTIFICATION);
        return PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Intent serviceIntent = null;

        if (ACTION_START_NOTIFICATION_SERVICE.equals(action)) {
            Log.i(getClass().getSimpleName(), "onReceive from alarm, starting notification service");
            serviceIntent = AINotificationIntentService.createIntentStartNotificationService(context);

        }else if (ACTION_DELETE_NOTIFICATION.equals(action)) {
            Log.i(getClass().getSimpleName(), "onReceive delete notification action, starting notification service to handle delete");
            serviceIntent = AINotificationIntentService.createIntentDeleteNotification(context);
        }

        if (serviceIntent != null) {
            // Start the service, keeping the device awake while it is launching.
            startWakefulService(context, serviceIntent);
            //serviceIntent.setClass(context, MainActivity.class);
            //serviceIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //context.startActivity(serviceIntent);
        }
    }
}