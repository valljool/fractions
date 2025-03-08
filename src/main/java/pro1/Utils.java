package pro1;

public class Utils {
    public static long gcd(long a, long b){
        while (b != 0){
            long tmp = a%b;
            a = b;
            b = tmp;
        }


        return a;
    }

    public static void generateLine(){
        for(int i = 0; i < 10; i++){
            System.out.print('-');
        }
        System.out.println();
    }

}
