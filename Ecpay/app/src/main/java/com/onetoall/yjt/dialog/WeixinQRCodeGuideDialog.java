package com.onetoall.yjt.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.onetoall.yjt.R;
import com.onetoall.yjt.utils.UMEvent;
import com.onetoall.yjt.utils.UMEventUtil;

/**
 * Created by qinwei on 2016/11/1 14:03
 * email:qinwei_it@163.com
 */

public class WeixinQRCodeGuideDialog extends Dialog {
    public WeixinQRCodeGuideDialog(Context context) {
        super(context, R.style.DialogTransparentFullscreenStyle);
    }

    public WeixinQRCodeGuideDialog(Context context, int themeResId) {
        super(context, R.style.DialogTransparentFullscreenStyle);
    }

    protected WeixinQRCodeGuideDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_weixin_qr_code_guide);
        findViewById(R.id.mGuideCloseLabel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UMEventUtil.onEvent(WeixinQRCodeGuideDialog.this.getContext(), UMEvent.wechatscodefunknow);
                dismiss();
            }
        });
        translucentStatus();
    }

    protected void translucentStatus() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            // Translucent status bar
            window.setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }
}