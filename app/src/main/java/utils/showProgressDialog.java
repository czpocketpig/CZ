package utils;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by Administrator on 2017/10/27.
 */

public class showProgressDialog  {
    private static ProgressDialog mProgressDialog;

    /**
     * 显示ProgressDialog
     * @param context
     * @param message  表示等待时的提示信息如“加载中。。。”
     */
    public static void showProgressDialog(Context context, String message){
        if(mProgressDialog == null){
            mProgressDialog = ProgressDialog.show(context, "", message);
        }else {
            mProgressDialog.show();
        }
    }

    /**
     * 关闭ProgressDialog
     */
    public static void dismissProgressDialog(){
        if(mProgressDialog != null){
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
    }



}
