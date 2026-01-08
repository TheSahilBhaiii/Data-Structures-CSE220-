public class Summer25 {

//BINARY TREE PROBLEM
public static String findPath(Node root.int seq[]){
    
    return helper(root,seq,0);
}

public static String helper(Node node, int[] seq,int index){
    if(node==null){
        return "LOST";
    }

    if(node.elem!=seq[index]){
        return "LOST";
    }

    if(index==seq.length-1){
        if(node.left==null && node.right==null){
            return "ESCAPED";
        }
        else{
            return "TRAPPED";
        }
    }
    String leftResult=helper(node.left,seq,index+1);
    String rightResult=helper(node.right,seq,index+1);

    if(leftResult.equals("ESCAPED") || rightResult.equals("Escaped")){
        return "ESCAPED";
    }
   if (leftResult.equals("TRAPPED") || rightResult.equals("TRAPPED")) {
            return "TRAPPED";
        }

        return "LOST";
}
}
