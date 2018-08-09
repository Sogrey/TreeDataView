package org.sogrey.treedataview.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.sogrey.treedataview.R;
import org.sogrey.treedataview.bean.TreeItemBean;
import org.sogrey.views.treeview.LineTimeAdapter;
import org.sogrey.views.treeview.Node;

import java.util.List;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

/**
 * Created by Sogrey on 2018/8/9.
 */

public class LineTreeAdapter extends LineTimeAdapter {

    public LineTreeAdapter(ListView mTree, Context context, List<Node> datas, int defaultExpandLevel, int iconExpand, int iconNoExpand) {
        super(mTree, context, datas, defaultExpandLevel, iconExpand, iconNoExpand);
    }

    @Override
    public View getConvertView(final Node node, final int position, View convertView, ViewGroup parent) {
        View view;
        final ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_line_tree, null);
            holder = new ViewHolder();
            holder.lyt_tree_root = (LinearLayout) view.findViewById(R.id.lyt_tree_root);
            holder.tv_tree_title = (TextView) view.findViewById(R.id.tv_tree_title);
            holder.iv_tree_icon = (ImageView) view.findViewById(R.id.iv_tree_icon);
            holder.iv_tree_iconbg = (ImageView) view.findViewById(R.id.iv_tree_iconbg);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandOrCollapse(position);
            }
        });
        if (node.getIcon() == -1) {
            holder.iv_tree_icon.setVisibility(View.INVISIBLE);
        } else {
            holder.iv_tree_icon.setVisibility(View.VISIBLE);
            holder.iv_tree_icon.setImageResource(node.getIcon());
        }
        holder.tv_tree_title.setText(node.getName());
        //是否是第一个
        //是否是最后一个
//        是否无子集
        if (position == 0) {//第一个
            holder.iv_tree_iconbg.setBackgroundResource(R.drawable.ic_treeview_frist);
        } else if (position == getVisibleNodes().size() - 1) {//最后一个
            holder.iv_tree_iconbg.setBackgroundResource(R.drawable.ic_treeview_last);
        } else {
            holder.iv_tree_iconbg.setBackgroundResource(R.drawable.ic_treeview_nomal);
        }
        if (getVisibleNodes().size() - 1 == 0) {//只有一个显示
            holder.iv_tree_iconbg.setBackgroundResource(R.color.transparent);
        }
        List children = node.getChildren();
        if (children == null || children.isEmpty()) {
            holder.iv_tree_iconbg.setImageResource(R.drawable.ic_treeview_nochild);
        } else {
            holder.iv_tree_iconbg.setImageResource(R.drawable.ic_treeview_onlyone);
        }
//        int level = node.getLevel();
//        holder.lyt_tree_root.setBackgroundResource(bg_root_colores[level % bg_root_colores.length]);
        return view;
    }

    class ViewHolder {
        LinearLayout lyt_tree_root;
        ImageView iv_tree_iconbg, iv_tree_icon;
        TextView tv_tree_title;
    }
}
