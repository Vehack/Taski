public class Ex1 {
    public static void main(String[] args) {
        System.out.println(remainder(15,8));
        System.out.println(remainder(3,4));
        System.out.println(remainder(-9,45));
        System.out.println(remainder(5,5));
    }

    public static int remainder(int first, int second){
        return first%second;
    }
}

