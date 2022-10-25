public class Ex3 {
    public static void main(String[] args){
        System.out.println(anims(2,3,5));
        System.out.println(anims(1,2,3));
        System.out.println(anims(5,2,8));
    }

    public static int anims(int chick,int cows,int pigs){
        return chick*2+cows*4+pigs*4;
    }
}
