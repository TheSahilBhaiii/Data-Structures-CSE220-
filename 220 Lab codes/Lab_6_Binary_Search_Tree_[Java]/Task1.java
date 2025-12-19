//Before starting to work on this design the Tree in the Tester code 
// Complete the lowestCommonAncestor method
public class Task1 {

    //======================TASK#1======================
    // This method takes only 3 parameter first one is root
    // and second & third parameter are as 2 integers
    // You'll need to find the lowest common ancestor of them and return it
    public static Integer lowestCommonAncestor( BSTNode root, Integer x, Integer y ){

        while(root!=null){
            if(root.elem>x && root.elem>y){
                root=root.left;
            }
            else if(root.elem<x && root.elem<y){
                root=root.right;
            }
            else {
                return root.elem;
            }
        }
        return null; //remove this line
    }
    //==================================================

}
