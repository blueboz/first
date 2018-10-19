import java.util.Scanner;

public class Main<main> {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a+"->"+b);
        }
    }

    public static long fun(int n,int m){
        long sum=0;
        if(n%(2*m)==0){
            boolean flag=false;
            for(int i=1;i<=n;i++){
                sum+=(i*(flag?1:-1));
                if(i%m==0){
                    flag=!flag;
                }
            }
        }
        return sum;
    }
}

