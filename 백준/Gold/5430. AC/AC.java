import java.util.*;
 
public class Main {
 
    static int n;
    static String p, x;
    static boolean errorCheck;
    static int start, end;
    static String arr[];
    static boolean reverse;
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
 
        int t = scan.nextInt();
        for(int i = 0; i < t; i++) {
            p = scan.next();
            n = scan.nextInt();
            x = scan.next();
            
            start = 0;
            end = n - 1;
            reverse = false;
            
            makeArr();
            if(!startCommand()) System.out.println("error");
            else printArr();
        }
    }
    
    public static boolean startCommand() {
        for(int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if(c == 'R') {
                int temp = start;
                start = end;
                end = temp;
                reverse = !reverse;
            } else {
                n--;
                if(reverse) start--;
                else start++;
                if(n < 0) return false;
            }
        }    
        return true;
    }
    
    public static void printArr() {
        System.out.print("[");
        if(reverse) {
            for(int i = start; i >= end; i--) {
                if(i == end) System.out.print(arr[i]);
                else System.out.print(arr[i] + ",");
            }
        } else {
            for(int i = start; i <= end; i++) {
                if(i == end) System.out.print(arr[i]);
                else System.out.print(arr[i] + ",");
            }
        }
        System.out.println("]");
    }
    
    public static void makeArr() {
        x = x.substring(1, x.length() - 1);
        arr = x.split(",");
    }
}
