package com.fcrom.dmart.in.BaseActivity;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import android.view.WindowManager;

import com.fcrom.dmart.in.R;

/**
 * Created by anamika.chavan on 15-01-2018.
 */

public class CustomDialog extends Dialog {
    public CustomDialog(Context context) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_dialog);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        AnimatedGifImageView animatedGifImageView = (AnimatedGifImageView) findViewById(R.id.animatedGifImageView);
        animatedGifImageView.setAnimatedGif(R.drawable.loadingcircle,
                AnimatedGifImageView.TYPE.STREACH_TO_FIT);
    }
}
