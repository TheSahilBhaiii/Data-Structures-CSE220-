public class Spring25 {

    //BINARY TREE PROBLEM 
    public static int second_max(Node root){
        int maxholder[]={0,0};

        helper(root,maxholder);

        return maxholder[1];
    }
    public void helper(Node root,int [] arr){
        if(root==null){
            return;
        }
        int val=(int)root.elem;

        if(val>arr[0]){
            arr[1]=arr[0];
            arr[0]=val;
        }
        if(val>arr[1] && val!=arr[0]){
            arr[1]=val;
        }
        helper(root.left,arr);
        helper(root.right,arr);
    }

    
}
