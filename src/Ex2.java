public class Ex2 {
    public static void main(String[] args ){
        System.out.println(triArea(3,2));
        System.out.println(triArea(7,4));
        System.out.println(triArea(10,10));
    }

    public static int triArea(int osn,int vis){
        return (osn*vis)/2;
    }
}
