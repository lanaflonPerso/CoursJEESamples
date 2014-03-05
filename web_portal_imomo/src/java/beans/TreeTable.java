/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;


import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import java.io.Serializable;  
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
/**
 *
 * @author andreea.mihet
 */
@ManagedBean(name = "treeTableBean")
public class TreeTable implements Serializable {
    
    private static final Logger logger = Logger.getLogger(TreeTable.class.getName());  
  
    private TreeNode root;  
  
    private Document selectedDocument;  
      
    /**
     *
     */
    public TreeTable() {  
        root = new DefaultTreeNode("root", null);

        //level 1  
        TreeNode documents = new DefaultTreeNode(new Document("Documents", "-", "Folder"), root);
        TreeNode pictures = new DefaultTreeNode(new Document("Pictures", "-", "Folder"), root);  
        //level 2  
        TreeNode work = new DefaultTreeNode(new Document("Work", "-", "Folder"), documents);                     
        TreeNode barca = new DefaultTreeNode("picture", new Document("barcelona.jpg", "30 KB", "JPEG Image"), pictures);
    }  
      
    public TreeNode getRoot() {  
        return root;          
    }  
      
    public Document getSelectedDocument() {  
        return selectedDocument;  
    }  
  
    public void setSelectedDocument(Document selectedDocument) {  
        this.selectedDocument = selectedDocument;  
    }  
}
