package org.sogrey.treedataview.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.sogrey.treedataview.R;
import org.sogrey.treedataview.bean.TreeItemBean;
import org.sogrey.views.treeview.Node;
import org.sogrey.views.treeview.TreeListViewAdapter;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

/**
 * Created by Sogrey on 2018/8/9.
 */

public class CommonTreeAdapter extends TreeListViewAdapter {

    int checkbox_checked, checkbox_uncheck;

    public CommonTreeAdapter(ListView mTree, Context context, List<Node> datas, int defaultExpandLevel, int checkbox_checked, int checkbox_uncheck) {
        super(mTree, context, datas, defaultExpandLevel, R.drawable.ic_collapsing_999, R.drawable.ic_expanding_999);
        this.checkbox_checked = checkbox_checked;
        this.checkbox_uncheck = checkbox_uncheck;
    }

    @Override
    public View getConvertView(final Node node, final int position, View convertView, ViewGroup parent) {
        View view;
        final ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_common_tree, null);
            holder = new ViewHolder();
            holder.tv_tree_title = view.findViewById(R.id.tv_tree_title);
            holder.iv_tree_icon = view.findViewById(R.id.iv_tree_icon);
            holder.cb_tree_choose = view.findViewById(R.id.cb_tree_choose);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }

        if (node.isChecked()) {
            node.setChecked(true);
            holder.cb_tree_choose.setImageResource(checkbox_checked);
        } else {
            node.setChecked(false);
            holder.cb_tree_choose.setImageResource(checkbox_uncheck);
        }

        holder.cb_tree_choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isChecked = node.isChecked();
                isChecked = !isChecked;
                Log.e("XXX", "是否选中：" + isChecked);
                node.setChecked(isChecked);
                setChecked(node, isChecked);
                if (isChecked) {
                    holder.cb_tree_choose.setImageResource(checkbox_checked);
                } else {
                    holder.cb_tree_choose.setImageResource(checkbox_uncheck);
                }
                //选中状态监听
//                if (mOnItemCheckedListener != null) {
//                    UserInfo.UserInfoData.ModelsBean modelsBean = (UserInfo.UserInfoData.ModelsBean) node.getBean();
//                    selecteModelSizeOfUndownload = 0;
//                    mOnItemCheckedListener.post(getSelectedModelIdAndFileName(getAllNodes(), modelsBean), selecteModelSizeOfUndownload, position,node, isChecked);
//                }

            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandOrCollapse(position);
            }
        });
        if (exPandositions.contains(node.getId() + "")) {
            expand(position);
            exPandositions.remove(node.getId() + "");
        }
        if (node.getIcon() == -1) {
            holder.iv_tree_icon.setVisibility(View.INVISIBLE);
        } else {
            holder.iv_tree_icon.setVisibility(View.VISIBLE);
            holder.iv_tree_icon.setImageResource(node.getIcon());
        }

        holder.tv_tree_title.setText(node.getName());
        return view;
    }

    List<String> exPandositions = new ArrayList<>();

    public void expandIds(List<String> positions) {
        exPandositions.addAll(positions);
        notifyDataSetChanged();
//        exPandositions.clear();
    }

    class ViewHolder {
        ImageView iv_tree_icon, cb_tree_choose;
        TextView tv_tree_title;
    }

    private OnItemCheckedListener mOnItemCheckedListener;

    public void setOnItemCheckedListener(OnItemCheckedListener mOnItemCheckedListener) {
        this.mOnItemCheckedListener = mOnItemCheckedListener;
    }

    public interface OnItemCheckedListener {
        /**
         * @param seletcedNodes 选中的节点数据
         * @param position      位置索引
         * @param node          item数据
         * @param isCheck       是否选中 true 选中，false 取消选中
         */
        void post(ArrayList<TreeItemBean> seletcedNodes, int position, Node node, boolean isCheck);
    }
}
