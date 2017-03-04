package com.java.service;


import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class TreeTest {
    private Integer id ;
    private Integer pId ;
    private String name;
    private List<TreeTest> children;
    public TreeTest() {
        
    }
    public TreeTest(Integer id, Integer pId, String name) {
        super();
        this.id = id;
        this.pId = pId;
        this.name = name;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getpId() {
        return pId;
    }
    public void setpId(Integer pId) {
        this.pId = pId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    
    public List<TreeTest> getChildren() {
        return children;
    }
    public void setChildren(List<TreeTest> children) {
        this.children = children;
    }
    
    @Override
    public String toString() {
        return "TreeTest [id=" + id + ", pId=" + pId + ", name=" + name
                + ", children=" + children + "]";
    }
    

   
    //递归树
    public static List<TreeTest> getChildren(Map<Integer,TreeTest> trees,Integer id,Integer leve){
        List<TreeTest> list = new ArrayList<TreeTest>();

        for (TreeTest tree : trees.values()) {
            if(id == tree.getpId()){            
                System.out.println("-递归" + tree.toString());
                List<TreeTest> chidren = getChildren(trees,tree.getId(),++leve);
                list.add(tree);//本身
                tree.setChildren(chidren);//子节点
                leve--;
            }
            
        }
        return list;
    }

    
    //测试数据
    
    public static void main(String[] args) {
        Map<Integer,TreeTest> map = new HashMap<Integer,TreeTest>();
        
        TreeTest terr1 = new TreeTest(1,0,"一级父节点");
        TreeTest terr2 = new TreeTest(2,1,"一级1子节点");
        TreeTest terr3 = new TreeTest(3,2,"一级2子节点");
        TreeTest terr4 = new TreeTest(4,0,"二级父节点");
        TreeTest terr5 = new TreeTest(5,4,"二级1子节点");
        TreeTest terr6 = new TreeTest(6,4,"二级1子节点2");
        TreeTest terr7 = new TreeTest(7,3,"一级3子节点");
        TreeTest terr8 = new TreeTest(8,5,"二级2子节点");
        
        
        map.put(terr1.getId(), terr1);
        map.put(terr2.getId(), terr2);
        map.put(terr3.getId(), terr3);
        map.put(terr4.getId(), terr4);
        map.put(terr5.getId(), terr5);
        map.put(terr6.getId(), terr6);
        map.put(terr7.getId(), terr7);
        map.put(terr8.getId(), terr8);
        List<TreeTest> li =  getChildren(map,0,1);
        
        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("name", "根节点");
        resultMap.put("children", li);
        resultMap.put("id", -1);
        resultMap.put("pId", 0);
        System.out.println(JSON.toJSON(li));
        System.out.println(JSON.toJSON(resultMap));
    }
}
