public class Ex4 {
    public static void main(String[] args){
        System.out.println(profi(0.2, 50, 9));
        System.out.println(profi(0.9, 1, 2));
        System.out.println(profi(0.9, 3, 2));
    }
    public static boolean profi(double prob,int prize,int pay){
        return prob*prize>pay;
    }
}
