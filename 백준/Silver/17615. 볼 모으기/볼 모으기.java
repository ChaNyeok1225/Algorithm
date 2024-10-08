import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {

        int n = Integer.parseInt(br.readLine());

        char[] ch = br.readLine().toCharArray();


        boolean rflag = false;
        boolean bflag = false;
        int rcnt = 0;
        int bcnt = 0;
        for(int i = 0; i < n; i++) {
            if(ch[i] == 'R') {
                if(rflag) {
                    rcnt++;
                }

                if(!bflag) {
                    bflag = true;
                }
            }
            else {
                if(bflag) {
                    bcnt++;
                }

                if(!rflag) {
                    rflag = true;
                }
            }
        }

        int answer = Math.min(rcnt, bcnt);


        rflag = false;
        bflag = false;
        rcnt = 0;
        bcnt = 0;
        for(int i = n-1; i >= 0; i--) {
            if(ch[i] == 'R') {
                if(rflag) {
                    rcnt++;
                }

                if(!bflag) {
                    bflag = true;
                }
            }
            else {
                if(bflag) {
                    bcnt++;
                }

                if(!rflag) {
                    rflag = true;
                }
            }
        }

        answer = Math.min(answer,Math.min(rcnt, bcnt));

        System.out.println(answer);

    }
}