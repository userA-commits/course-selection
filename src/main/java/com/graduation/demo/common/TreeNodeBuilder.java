package com.graduation.demo.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TreeNodeBuilder {
    /**
     * 将权限列表更新为树状结构
     */
    public static List<TreeNode> build(List<TreeNode> treeNodes, Long topPNo){
        List<TreeNode> nodes = new ArrayList<>();

        for(TreeNode n1: treeNodes){
            if(Objects.equals(n1.getParentNo(), topPNo)){
                nodes.add(n1);
            }
        }
        for(TreeNode n2 : nodes){
            for(TreeNode n3 : treeNodes){
                if(Objects.equals(n2.getMenuNo(), n3.getParentNo())){
                    n2.getChildren().add(n3);
                }
            }
        }

        return nodes;
    }
}
