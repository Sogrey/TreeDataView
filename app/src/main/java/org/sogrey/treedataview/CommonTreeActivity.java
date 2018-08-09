package org.sogrey.treedataview;

import android.os.Bundle;
import android.widget.ListView;

import org.sogrey.treedataview.adapter.CommonTreeAdapter;
import org.sogrey.treedataview.base.BaseActivity;
import org.sogrey.treedataview.bean.TreeItemBean;
import org.sogrey.views.treeview.Node;

import java.util.ArrayList;

public class CommonTreeActivity extends BaseActivity {
    ListView mLstTreeView;
    private CommonTreeAdapter mCommonTreeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_tree);
        mLstTreeView = findViewById(R.id.lstTreeView);
        initAdapter();
    }


    private void initAdapter() {
        mCommonTreeAdapter = new CommonTreeAdapter(mLstTreeView, this, mTreeData,
                2, R.drawable.ic_checkbox_checked, R.drawable.ic_checkbox_uncheck);
        mCommonTreeAdapter.setOnItemCheckedListener(new CommonTreeAdapter.OnItemCheckedListener() {
            @Override
            public void post(ArrayList<TreeItemBean> seletcedNodes, int position, Node node, boolean isCheck) {

            }
        });
        mLstTreeView.setAdapter(mCommonTreeAdapter);
    }
}
