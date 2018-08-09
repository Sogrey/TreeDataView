package org.sogrey.views.treeview;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Node<T,B> implements Serializable {

    /**
     * 传入的实体对象
     */
    public B bean;
    /**
     * 设置开启 关闭的图片
     */
    public int iconExpand=-1, iconNoExpand = -1;

    private T id;
    /**
     * 根节点pId为0
     */
    private T pId ;
    /**
     * 节点标题
     */
    private String name;

    /**
     * 当前的级别
     */
    private int level;

    /**
     * 是否展开
     */
    private boolean isExpand = false;

    private int icon = -1;

    /**
     * 下一级的子Node
     */
    private List<Node> children = new ArrayList<>();

    /**
     * 父Node
     */
    private Node parent;
    /**
     * 是否被checked选中
     */
    private boolean isChecked;

    /**
     * 是否为新添加的

     */
    public boolean isNewAdd = true;

    /**
     * 该分组下的人数
     */
    private int count;

    /**
     * 是否是人，1=true, 0=false
     */
    private int isPeople;

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }

    public Node() {}
    public Node(T id, T pId, String name) {
        super();
        this.id = id;
        this.pId = pId;
        this.name = name;
    }
    public Node(T id, T pId, String name,String phone) {
        super();
        this.id = id;
        this.pId = pId;
        this.name = name;
    }

    public Node(T id, T pId, String name, B bean) {
        super();
        this.id = id;
        this.pId = pId;
        this.name = name;
        this.bean = bean;
    }

    public Node(T id, T pId, String name, int count) {
        this.id = id;
        this.pId = pId;
        this.name = name;
        this.count = count;
    }

    public Node(T id, T pId, String name, int count, int isPeople) {
        this.id = id;
        this.pId = pId;
        this.name = name;
        this.count = count;
        this.isPeople = isPeople;
    }

    public int getIcon()
    {
        return icon;
    }

    public void setIcon(int icon)
    {
        this.icon = icon;
    }

    public T getId()
    {
        return id;
    }

    public void setId(T id)
    {
        this.id = id;
    }

    public T getpId()
    {
        return pId;
    }

    public void setpId(T pId)
    {
        this.pId = pId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isExpand() {
        return isExpand;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getIsPeople() {
        return isPeople;
    }

    public void setIsPeople(int isPeople) {
        this.isPeople = isPeople;
    }

    public B getBean() {
        return bean;
    }

    public void setBean(B bean) {
        this.bean = bean;
    }

    /**
     * 是否为跟节点
     *
     * @return
     */
    public boolean isRoot() {
        return parent == null;
    }

    /**
     * 判断父节点是否展开
     *
     * @return
     */
    public boolean isParentExpand() {
        if (parent == null)
            return false;
        return parent.isExpand();
    }

    /**
     * 是否是叶子界点
     *
     * @return
     */
    public boolean isLeaf()
    {
        return children.size() == 0;
    }

    /**
     * 获取level
     */
    public int getLevel() {

        return parent == null ? 0 : parent.getLevel() + 1;
    }

    /**
     * 设置展开
     *
     * @param isExpand
     */
    public void setExpand(boolean isExpand) {
        this.isExpand = isExpand;
        if (!isExpand) {
            for (Node node : children) {
                node.setExpand(isExpand);
            }
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "bean=" + bean +
                ", id=" + id +
                ", pId=" + pId +
                ", name='" + name +
                ", level=" + level +
                ", icon=" + icon +
                ", parent=" + parent +
                ", isChecked=" + isChecked +
                ", isNewAdd=" + isNewAdd +
                ", count=" + count +
                ", isPeople=" + isPeople +
                '}';
    }
}