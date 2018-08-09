package org.sogrey.treedataview.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.fastjson.JSON;

import org.sogrey.treedataview.bean.TreeItemBean;
import org.sogrey.treedataview.utils.AssetsUtils;
import org.sogrey.views.treeview.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sogrey on 2018/8/9.
 */

public class BaseActivity extends AppCompatActivity {
    protected ArrayList<Node> mTreeData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }
    private void initData() {
        AssetsUtils assetsUtils = new AssetsUtils();
        String treeData = assetsUtils.readAssetsText(this, "tree.json");
        List<TreeItemBean> treeItemBeanList = JSON.parseArray(treeData, TreeItemBean.class);
        mTreeData = getNodelis(treeItemBeanList);
    }

    private ArrayList<Node> getNodelis(List<TreeItemBean> treeItemBeanList) {
        ArrayList<Node> nodeList = new ArrayList<>();
        if (treeItemBeanList != null && treeItemBeanList.size() > 0) {
            for (TreeItemBean treeItemBean : treeItemBeanList) {
                Node node = new Node(treeItemBean.getId(), treeItemBean.getPid(), treeItemBean.getName());
                node.setBean(treeItemBean);
                nodeList.add(node);
            }
        }
        return nodeList;
    }
}
