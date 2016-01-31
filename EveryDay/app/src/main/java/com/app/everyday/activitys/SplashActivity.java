package com.app.everyday.activitys;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import com.app.everyday.R;
import com.app.everyday.utils.eventbus.EventBusModel;

import butterknife.Bind;

/**
 * Author：YJQ on 2016/1/20 16:56
 * Eamil：yujiaqi@fenzotech.com
 * Description:
 */
public class SplashActivity extends BaseActivity implements MediaPlayer.OnCompletionListener {

    @Bind(R.id.layout_video)
    RelativeLayout layoutVideo;
    private VideoView videoView;

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initLayout() {

        RelativeLayout.LayoutParams layoutParams=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        videoView=new VideoView(mActivity);
        videoView.setLayoutParams(layoutParams);
        layoutVideo.addView(videoView);
        Uri uri = Uri.parse("android.resource://" + mActivity.getPackageName() + "/" + R.raw.launch_movie);
        videoView.setVideoURI(uri);
        videoView.start();
        //videoView.setMediaController(new MediaController(mActivity));
        videoView.setOnCompletionListener(this);


    }

    @Override
    protected void initLogic() {

    }

    @Override
    public void onEventAsync(EventBusModel ebModel) {

    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        startActivity(new Intent(mActivity, MainActivity.class));
        mActivity.finish();

    }
}
