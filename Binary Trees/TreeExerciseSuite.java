import java.util.*;

// Basic Node class for the exercises
class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class TreeExerciseSuite {

    // =================================================================
    // SECTION A: EXERCISE SOLUTIONS
    // Write your code inside these functions.
    // =================================================================

    /**
     * Exercise 5.3 [cite: 355]
     * Construct a tree of height 3 and minimum number of 9 nodes.
     * Returns the root of the constructed tree.
     */
    public static Node exercise_5_3_constructTree() {
        Node a=new Node(1);
        Node b=new Node(1);
        Node c=new Node(1);
        Node d=new Node(1);
        Node e=new Node(1);
        Node f=new Node(1);
        Node g=new Node(1);
        Node h=new Node(1);
        Node i=new Node(1);

        a.left=b;
        a.right=c;
        b.left=d;
        b.right=e;
        c.left=f;
        c.right=g;
        d.left=h;
        d.right=i;

        return a; 
    }

    /**
     * Exercise 5.4 [cite: 357]
     * Print Pre-order, In-order, and Post-order traversals.
     */
    public static void exercise_5_4_traversals(Node root) {
        System.out.print("Pre-order: ");
        if(root==null){
            return;
        }
        System.out.print(root+" ");
        System.out.print(root.left+" ");
        System.out.print(root.right+" ");
        
        System.out.println();
        
        System.out.print("In-order: ");
        System.out.print(root.left+" ");
        System.out.print(root+" ");
        System.out.print(root.right+" ");
        System.out.println();

        System.out.print("Post-order: ");
        System.out.print(root.left+" ");
        System.out.print(root.right+" ");
        System.out.print(root+" ");
        System.out.println();
    }

    /**
     * Exercise 5.5 [cite: 368]
     * Convert an array into a binary tree (Sequential to Dynamic).
     * Array format: [null, root, left, right, left-of-left, etc.]
     */
    public static Node exercise_5_5_arrayToTree(Integer[] arr) {
        Node root=new Node(arr[1]);
        for(int i=0;i<arr.length;i++){
            root.left=new Node(arr[2*i]);
            root.right=new Node(arr[2*i+1]);
            root=root.next;
        }
        return null;
    }

    /**
     * Exercise 5.6 [cite: 371]
     * Check if a tree is Symmetric (mirror of itself).
     */
    public static boolean exercise_5_6_isSymmetric(Node root) {
        if(root==null){
            return true;
        }
        return isMirror(root.left,root.right);
    }
    public static boolean isMirror(Node a,Node b){
        if(a==null && b==null){
            return true;
        }
        if(a==null || b==null){
            return false;
        }
        return (a.data==b.data)&&isMirror(a.left,b.right)&&isMirror(a.right, b.left);
    }
 
    /**
     * Exercise 5.8 [cite: 396]
     * Check if two trees are identical.
     */
    public static boolean exercise_5_8_isIdentical(Node root1, Node root2) {
        if(a==null && b==null){
            return true;
        }
        if(a==null || b==null){
            return false;
        }
        return (a.data==b.data)&&exercise_5_8_isIdentical(a.left,b.right)&&exercise_5_8_isIdentical(a.right, b.left);
    }

    /**
     * Exercise 5.9 [cite: 405]
     * Convert the tree into its mirror.
     */
    public static void exercise_5_9_convertToMirror(Node root) {
        exercise_5_9_convertToMirror(root.left);
        exercise_5_9_convertToMirror(root.right);

        Node temp=root.left;
        root.left=root.right;
        root.right=temp;
    }

    /**
     * Exercise 5.10 [cite: 434]
     * Check if the tree is Height Balanced.
     * (Diff between left and right subtree height is not more than 1).
     */
    public static boolean exercise_5_10_isBalanced(Node root) {
        return checkHeight(root)!=-1;
    }
    public static int checkHeight(Node root){
        if(root==null){
            return 0;
        }
        int leftH=checkHeight(root.left);
        if(leftH==-1){
            return -1;
        }
        int rightH=checkHeight(root.right);
        if(rightH==-1){
            return -1;
        }

        if(Math.abs(leftH-rightH)>1){
            return -1;
        }
        return Math.max(leftH,rightH)+1;
    }

    /**
     * Exercise 5.11 [cite: 448]
     * Check if every node value equals the sum of its children.
     */
    public static boolean exercise_5_11_childrenSumProperty(Node root) {
       if(root==null || (root.left==null && root.right==null)){
        return true;
       }
       int sum=0;
       if(root.left!=null){
        sum+=root.left.data;
       }
       if(root.right!=null){
        sum+=root.right.data;
       }
       return (root.data==sum) && exercise_5_11_childrenSumProperty(root.left) && exercise_5_11_childrenSumProperty(root.right);
    }

    /**
     * Exercise 5.12 [cite: 464]
     * Find the largest value in each level.
     */
    public static void exercise_5_12_largestInEachLevel(Node root) {
        // TODO: Write your code here
    }

    /**
     * Exercise 5.13 [cite: 481]
     * Check if the tree has duplicate values.
     */
    public static boolean exercise_5_13_hasDuplicates(Node root) {
        // TODO: Write your code here
        return false;
    }

    /**
     * Exercise 5.14 [cite: 503]
     * Print all nodes at distance k from root.
     */
    public static void exercise_5_14_printNodesAtDistanceK(Node root, int k) {
       if(root==null){
        return;
       }
       if(k==0){
        System.out.println(root.data);
        return;
       }
       exercise_5_14_printNodesAtDistanceK(root.left, k-1);
       exercise_5_14_printNodesAtDistanceK(root.right, k-1);
    }

    /**
     * Exercise 5.15 [cite: 511]
     * Print ancestors of a given key.
     */
    public static boolean exercise_5_15_printAncestors(Node root, int target) {
        if(root==null){
            return false;
        }
        if(root.data==target){
            return true;
        }
        if(exercise_5_15_printAncestors(root.left, target)||exercise_5_15_printAncestors(root.right, target)){
            System.out.println(root.data+ " ");
            return true;
        }
        return false;
    }

    /**
     * Exercise 5.16 [cite: 519]
     * Print all nodes having exactly one child.
     */
    public static void exercise_5_16_printSingleChildNodes(Node root) {
        // TODO: Write your code here
    }

    /**
     * Exercise 5.17 [cite: 533]
     * Check if it is a Skewed Binary Tree.
     */
    public static boolean exercise_5_17_isSkewed(Node root) {
        // TODO: Write your code here
        return false;
    }

    /**
     * Exercise 5.18 [cite: 549]
     * Find the minimum depth of the tree.
     */
    public static int exercise_5_18_minDepth(Node root) {
        // TODO: Write your code here
        return 0;
    }

    /**
     * Exercise 5.19 [cite: 557]
     * Print all full nodes (nodes with both left and right children).
     */
    public static void exercise_5_19_printFullNodes(Node root) {
        // TODO: Write your code here
    }

    /**
     * Exercise 5.20 [cite: 565]
     * Print path from root to a given node x.
     */
    public static void exercise_5_20_printPathToX(Node root, int x) {
        // TODO: Write your code here
    }

    // =================================================================
    // SECTION B: MAIN TEST RUNNER
    // Uncomment lines below to test specific exercises.
    // =================================================================
    public static void main(String[] args) {
        TreeExerciseSuite solver = new TreeExerciseSuite();
        
        System.out.println("--- Starting Tree Exercise Tests ---");

        // --- TEST 5.3: Construct Tree ---
        // Node t3 = exercise_5_3_constructTree();
        // System.out.println("Ex 5.3: Tree constructed.");

        // --- TEST 5.4: Traversals (Using a dummy tree) ---
        // Node t4 = buildTestTree1(); 
        // System.out.println("\n--- Ex 5.4 Output ---");
        // exercise_5_4_traversals(t4);

        // --- TEST 5.5: Array to Tree ---
        // Integer[] input5 = {null, 15, 25, 35, 10, 35, 15, 18}; // Index 0 is null to make math 1-based
        // Node t5 = exercise_5_5_arrayToTree(input5);
        // System.out.println("\n--- Ex 5.5 Output ---");
        // System.out.println("Root: " + (t5 != null ? t5.data : "null"));

        // --- TEST 5.6: Symmetric Tree ---
        // Node t6 = buildSymmetricTree();
        // System.out.println("\n--- Ex 5.6 Output ---");
        // System.out.println("Is Symmetric: " + exercise_5_6_isSymmetric(t6)); // Expected: true

        // --- TEST 5.8: Identical Trees ---
        Node t8a = buildTestTree1();
        Node t8b = buildTestTree1();
        System.out.println("\n--- Ex 5.8 Output ---");
        System.out.println("Are Identical: " + exercise_5_8_isIdentical(t8a, t8b)); // Expected: true

        // --- TEST 5.9: Mirror ---
        // Node t9 = buildTestTree1();
        // System.out.println("\n--- Ex 5.9 Output ---");
        // exercise_5_9_convertToMirror(t9);
        // System.out.println("Mirror conversion run (verify via debug or print).");

        // --- TEST 5.10: Balanced ---
        // Node t10 = buildUnbalancedTree();
        // System.out.println("\n--- Ex 5.10 Output ---");
        // System.out.println("Is Balanced: " + exercise_5_10_isBalanced(t10)); // Expected: false

        // --- TEST 5.11: Sum Property ---
        // Node t11 = buildSumTree();
        // System.out.println("\n--- Ex 5.11 Output ---");
        // System.out.println("Follows Sum Property: " + exercise_5_11_childrenSumProperty(t11)); // Expected: true

        // --- TEST 5.12: Largest in Level ---
        // Node t12 = buildTestTree1();
        // System.out.println("\n--- Ex 5.12 Output ---");
        // exercise_5_12_largestInEachLevel(t12);

        // --- TEST 5.13: Duplicates ---
        // Node t13 = buildDuplicateTree();
        // System.out.println("\n--- Ex 5.13 Output ---");
        // System.out.println("Has Duplicates: " + exercise_5_13_hasDuplicates(t13)); // Expected: true

        // --- TEST 5.14: Print Distance K ---
        // Node t14 = buildTestTree1();
        // System.out.println("\n--- Ex 5.14 Output (Dist 2) ---");
        // exercise_5_14_printNodesAtDistanceK(t14, 2);

        // --- TEST 5.15: Ancestors ---
        // Node t15 = buildTestTree1();
        // System.out.println("\n--- Ex 5.15 Output (Target 60) ---");
        // exercise_5_15_printAncestors(t15, 60);

        // --- TEST 5.16: Single Child Nodes ---
        // Node t16 = buildSingleChildTree();
        // System.out.println("\n--- Ex 5.16 Output ---");
        // exercise_5_16_printSingleChildNodes(t16);

        // --- TEST 5.17: Skewed ---
        // Node t17 = buildSkewedTree();
        // System.out.println("\n--- Ex 5.17 Output ---");
        // System.out.println("Is Skewed: " + exercise_5_17_isSkewed(t17)); // Expected: true

        // --- TEST 5.18: Min Depth ---
        // Node t18 = buildTestTree1();
        // System.out.println("\n--- Ex 5.18 Output ---");
        // System.out.println("Min Depth: " + exercise_5_18_minDepth(t18));

        // --- TEST 5.19: Full Nodes ---
        // Node t19 = buildTestTree1();
        // System.out.println("\n--- Ex 5.19 Output ---");
        // exercise_5_19_printFullNodes(t19);

        // --- TEST 5.20: Path to X ---
        // Node t20 = buildTestTree1();
        // System.out.println("\n--- Ex 5.20 Output (To 60) ---");
        // exercise_5_20_printPathToX(t20, 60);
    }

    // =================================================================
    // SECTION C: HELPER FUNCTIONS TO BUILD TEST TREES
    // =================================================================

    // Helper: Standard Tree (Page 93 Example)
    private static Node buildTestTree1() {
        Node root = new Node(70);
        root.left = new Node(50);
        root.right = new Node(90);
        root.left.left = new Node(40);
        root.left.right = new Node(60);
        return root;
    }

    // Helper: Symmetric Tree (Page 95 Ex 5.6)
    private static Node buildSymmetricTree() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
        root.right.right = new Node(3);
        return root;
    }

    // Helper: Unbalanced Tree
    private static Node buildUnbalancedTree() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        return root;
    }

    // Helper: Sum Tree (Page 96 Ex 5.11)
    private static Node buildSumTree() {
        Node root = new Node(10);
        root.left = new Node(4);
        root.right = new Node(6); // Modified to be valid: 4+6=10
        return root;
    }

    // Helper: Tree with duplicates
    private static Node buildDuplicateTree() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2); // Duplicate
        return root;
    }
    
    // Helper: Skewed Tree
    private static Node buildSkewedTree() {
        Node root = new Node(10);
        root.left = new Node(8);
        root.left.left = new Node(7);
        return root;
    }

    // Helper: Tree with single child node
    private static Node buildSingleChildTree() {
        Node root = new Node(2);
        root.left = new Node(3);
        root.right = new Node(5);
        root.left.right = new Node(6); // 3 has only one child
        root.right.left = new Node(7);
        root.right.right = new Node(8);
        return root;
    }
}