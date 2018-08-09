package org.sogrey.treedataview.utils;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * assets 文件操作-读取
 * Created by Sogrey on 2018/8/8.
 */

public class AssetsUtils {
    /**
     * 读取文本文件返回字符串
     * @param context 上下文
     * @param fileName 文件名（包含路径）
     * @return
     */
    public String readAssetsText(Context context, String fileName) {
        try {
            InputStream is = context.getAssets().open(fileName);
            String text = InputStream2String(is);
//            LogUtil.E(text);
            return text;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String InputStream2String(InputStream is) throws IOException {
        InputStreamReader reader = new InputStreamReader(is);
        BufferedReader bufferedReader = new BufferedReader(reader);
        StringBuffer buffer = new StringBuffer("");
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            buffer.append(str);
//            buffer.append("\n");
        }
        return buffer.toString();
    }

}
