package com.graduation.demo.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 用于生成树状菜单
 */
public class TreeNode {
    private Long menuNo;
    private Long parentNo;
    private String title;
    private String icon = null;
    private String href;
    private Boolean spread = false;
    private List<TreeNode> children = new ArrayList<>();

    public TreeNode() {
    }

    public TreeNode(Long menuNo, Long parentNo, String title, String href) {
        this.menuNo = menuNo;
        this.parentNo = parentNo;
        this.title = title;
        this.href = href;
    }

    public Long getMenuNo() {
        return menuNo;
    }

    public void setMenuNo(Long menuNo) {
        this.menuNo = menuNo;
    }

    public Long getParentNo() {
        return parentNo;
    }

    public void setParentNo(Long parentNo) {
        this.parentNo = parentNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Boolean getSpread() {
        return spread;
    }

    public void setSpread(Boolean spread) {
        this.spread = spread;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }
}
