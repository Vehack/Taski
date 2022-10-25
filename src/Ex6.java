public class Ex6 {
    public static void main(String[] args) {
        System.out.println(ctoa('A'));
        System.out.println(ctoa('v'));
        System.out.println(ctoa(']'));
        System.out.println(ctoa('+'));
    }

    public static int ctoa(char ct) {
        return (int) ct;
    }
}
