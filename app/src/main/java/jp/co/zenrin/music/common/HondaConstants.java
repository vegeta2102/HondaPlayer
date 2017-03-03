package jp.co.zenrin.music.common;

/**
 * @Author: Hoang Vu
 * @Date:   2017/02/23
 */

public final class HondaConstants {

    public static final int PERMISSION_REQUEST_CODE = 1;
    public static final String READ_EXTERNAL_STORAGE = "android.permission.READ_EXTERNAL_STORAGE";
    // Save preference define constant
    public static final String PREFERENCE_MEDIA_PLAYER = "MEDIA_PLAYER";
    public static final String PREFERENCE_TRACK_LIST = "TRACK_ARRAY_LIST";
    public static final String PREFERENCE_TRACK_INDEX = "TRACK_INDEX";
    public static final String PREFERENCE_MPL_SERVICE_STATUS = "MPL_SERVICE_STATUS";

    //
    public static final String BROADCAST_PLAY_NEW_TRACK = "jp.co.zenrin.music.HondaConstants.PLAY_NEW_TRACK";
    public static final String BROADCAST_PLAY_RESTORE_TRACK = "jp.co.zenrin.music.HondaConstants.PLAY_RESTORE_TRACK";
    public static final String BROADCAST_PLAY_NEXT_TRACK = "jp.co.zenrin.music.HondaConstants.BROADCAST_PLAY_NEXT_TRACK";
    public static final String BROADCAST_PLAY_PREVIOUS_TRACK = "jp.co.zenrin.music.HondaConstants.BROADCAST_PLAY_PREVIOUS_TRACK";
    public static final String BROADCAST_PLAY_STOP_TRACK = "jp.co.zenrin.music.HondaConstants.BROADCAST_PLAY_STOP_TRACK";
    public static final int WAIT_LENGTH = 5000;
    public static final int WAIT_CLOSE_LENGTH = 5000;
    public static final String DETECTED_SCREEN_IPOD = "DETECTED_SCREEN_IPOD";
    public static final String DETECTED_SCREEN_INTERNET_AUDIO = "DETECTED_SCREEN_INTERNET_AUDIO";


}
