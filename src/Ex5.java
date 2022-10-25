public class Ex5 {
    public static void main(String[] args){
        System.out.println(operation(24, 15, 9));
        System.out.println(operation(24, 26, 2));
        System.out.println(operation(24, 48, 2));
        System.out.println(operation(24, 12, 2));
        System.out.println(operation(15, 11, 11));
    }
    public static String operation(int n,int a,int b){
        if (a+b == n){
            return "added";
        } else if (a - b == n){
            return "substracted";
        } else if (a*b==n){
            return "multiplied";
        } else if (a/b==n){
            return "devided";
        } else {
            return "none";
        }
    }
}
