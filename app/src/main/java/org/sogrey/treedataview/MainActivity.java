package org.sogrey.treedataview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.alibaba.fastjson.JSON;

import org.sogrey.treedataview.bean.TreeItemBean;
import org.sogrey.treedataview.utils.AssetsUtils;
import org.sogrey.views.treeview.Node;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void go2CommonTreeActivity(View view) {
        startActivity(new Intent(this, CommonTreeActivity.class));
    }

    public void go2LineTreeActivity(View view) {
        startActivity(new Intent(this, LineTreeActivity.class));
    }
}
