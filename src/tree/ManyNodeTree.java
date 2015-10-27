package tree;
import java.sql.SQLException;
import java.util.ArrayList;  
import java.util.List;  
import pachong2.biao2;
  
public class ManyNodeTree {
	 /** 树根*/  
    private ManyTreeNode root;  
      
    /** 
     * 构造函数 
     */  
    public ManyNodeTree()  
    {  
        root = new ManyTreeNode(new TreeNode("root"));  
    }  
      
    /** 
     * 生成一颗多叉树，根节点为root 
     *  
     * @param treeNodes 生成多叉树的节点集合 
     * @return ManyNodeTree 
     */  
    public ManyNodeTree createTree(List<TreeNode> treeNodes)  
    {  
        if(treeNodes == null || treeNodes.size() < 0)  
            return null;  
          
        ManyNodeTree manyNodeTree =  new ManyNodeTree();  
          
        //将所有节点添加到多叉树中  
        for(TreeNode treeNode : treeNodes)  
        {  
            if(treeNode.getParentId().equals("root"))  
            {  
                //向根添加一个节点  
                manyNodeTree.getRoot().getChildList().add(new ManyTreeNode(treeNode));  
            }  
            else  
            {  
                addChild(manyNodeTree.getRoot(), treeNode);  
            }  
        }  
          
        return manyNodeTree;  
    }  
      
    /** 
     * 向指定多叉树节点添加子节点 
     *  
     * @param manyTreeNode 多叉树节点 
     * @param child 节点 
     */  
    public void addChild(ManyTreeNode manyTreeNode, TreeNode child)  
    {  
        for(ManyTreeNode item : manyTreeNode.getChildList())  
        {  
            if(item.getData().getNodeId().equals(child.getParentId()))  
            {  
                //找到对应的父亲  
                item.getChildList().add(new ManyTreeNode(child));  
                break;  
            }  
            else  
            {  
                if(item.getChildList() != null && item.getChildList().size() > 0)  
                {  
                    addChild(item, child);  
                }                 
            }  
        }  
    }  
      
    /** 
     * 遍历多叉树  
     *  
     * @param manyTreeNode 多叉树节点 
     * @return  
     */  
    public String iteratorTree(ManyTreeNode manyTreeNode,int i,StringBuilder leafbuffer)  
    {  
        StringBuilder buffer = new StringBuilder();  
        int m=1;
        if(manyTreeNode != null)   
        {     
            for (ManyTreeNode index : manyTreeNode.getChildList())   
            {  
            	if (i == 0)
            		buffer.append("\n\r");
            	buffer.append(index.getData().getNodeId()+ ",");  
                  
                if (index.getChildList() != null && index.getChildList().size() > 0 )   
                {     
                	buffer.append("(");
                    buffer.append(iteratorTree(index,i+1,leafbuffer));  
                    buffer.append(")");
                }  
                else{
                	if(m % 4 == 0)
                	leafbuffer.append(index.getData().getNodeId()+","+"\n\r");
                	else
                	leafbuffer.append(index.getData().getNodeId()+",");
                	m++;
                }
            }   
            	
        } 
        return buffer.toString();  
    } 
    
    
    
    
  
      
    public ManyTreeNode getRoot() {  
        return root;  
    }  
  
    public void setRoot(ManyTreeNode root) {  
        this.root = root;  
    }  
      
      public String treeCre(StringBuilder leafbuffer) throws SQLException
      {
    	  List<TreeNode> treeNodes = new ArrayList<TreeNode>();
    	  List<biao2> data =  new ArrayList<>();
  		  sta2 dui = new sta2();
  		  data = dui.getAllData();
  		  treeNodes.add(new TreeNode("A股", "root"));
  		  treeNodes.add(new TreeNode("B股", "root"));
  		  treeNodes.add(new TreeNode("H股", "root"));
  		  treeNodes.add(new TreeNode("N股", "root"));
  		  treeNodes.add(new TreeNode("ST股", "root"));
    	  for(int i=0;i<data.size();i++){
    		  treeNodes.add(new TreeNode(data.get(i).getzi(), data.get(i).getfu()));
    	  }
    	  ManyNodeTree tree = new ManyNodeTree();
		 // System.out.println(tree.iteratorTree(tree.createTree(treeNodes).getRoot(), 0,leafbuffer));
    	  return tree.iteratorTree(tree.createTree(treeNodes).getRoot(), 0,leafbuffer);
      }
 

}
