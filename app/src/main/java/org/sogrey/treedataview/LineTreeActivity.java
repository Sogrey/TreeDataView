package org.sogrey.treedataview;

import android.os.Bundle;
import android.widget.ListView;

import org.sogrey.treedataview.adapter.LineTreeAdapter;
import org.sogrey.treedataview.base.BaseActivity;

public class LineTreeActivity extends BaseActivity {
    ListView mLstTreeView;
    private LineTreeAdapter mLineTreeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_tree);
        mLstTreeView = findViewById(R.id.lstTreeView);
        mLstTreeView.setDivider(null);
        initAdapter();
    }


    private void initAdapter() {
        mLineTreeAdapter = new LineTreeAdapter(mLstTreeView, this, mTreeData,
                0, R.drawable.ic_treeview_open, R.drawable.ic_treeview_close);
        mLstTreeView.setAdapter(mLineTreeAdapter);
    }
}
