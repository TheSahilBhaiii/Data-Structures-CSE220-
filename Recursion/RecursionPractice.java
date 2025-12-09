public class RecursionPractice {

    public static void main(String[] args) {

        int n = 5; // change if needed

        // ---------------- Run functions by uncommenting ----------------

         //printNameNTimes(1,n);
          //print1ToN(n);
         //printNTo1(n);
         //print1ToN_Backtrack(n);
        printNTo1_Backtrack(n);

        // ----------------------------------------------------------------
    }

    // 1️⃣ Print Name 5 times
    static void printNameNTimes(int i,int n) {
        if(i>5){
            return;
        }
        System.out.println("Sahil");
        printNameNTimes(i+1, n);      
    }

    // 2️⃣ Print linearly from 1 to N
    static void print1ToN(int n){
        if(n<1){
            return;
        }                 
        
        print1ToN(n-1);              //printing later means reverse stack
        System.out.println(n);
    }
    

    // 3️⃣ Print from N to 1
    static void printNTo1(int n) {
        if(n<1){
            return;
        }
        System.out.println(n);      //printing before means reverse stack
        printNTo1(n-1);
    }

    // 4️⃣ Print linearly from 1 to N (Backtracking)
    static void print1ToN_Backtrack(int n) {
        if(n<1){
            return;
        }
        print1ToN_Backtrack(n-1);
        System.out.println(n);
        
    }

    // 5️⃣ Print from N to 1 (Backtracking)
    static void printNTo1_Backtrack(int n) {
        if(n<1){
            return;
        }
        System.out.println(n);
        printNTo1_Backtrack(n-1);
    }
}
