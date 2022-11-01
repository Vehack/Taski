public class Main {
    public static void main(String[] args) {
        System.out.println(remainder(15,8)); //Оператор, способный обеспечить остаток от операции деления.
        System.out.println(triArea(7,4));//основание и высоту треугольника и возвращает его площадь.
        System.out.println(anims(5,2,8));//возвращает общее количество ног всех животных.
        System.out.println(profi(0.2, 50, 9));//возвращает true, если prob * prize > pay;
        System.out.println(operation(24, 15, 9));//a и b:они должны быть сложены,вычитаны,умножены или разделены, чтобы получить N.
        System.out.println(operation(15, 11, 11));
        System.out.println(ctoa('A'));//ASCII переданного символа
        System.out.println(ctoa(']'));
        System.out.println(upto(3));//сумму всех чисел до него и включая его
        System.out.println(tr(8, 10));//аксимальное значение третьего ребра треугольника
        System.out.println(sumOfCubes(new int[]{3, 4, 5}));//массив чисел и возвращает сумму его кубов
        System.out.println(sumOfCubes(new int[]{2}));
        System.out.println(abcmath(5, 2, 1));//Добавьте A к себе B раз – Проверьте, делится ли результат на C
        System.out.println(abcmath(1, 2, 3));
    }

    public static int remainder(int first, int second){
        return first%second;
    }


    public static int triArea(int osn,int vis){
        return (osn*vis)/2;
    }

    public static int anims(int chick,int cows,int pigs){
        return chick*2+cows*4+pigs*4;
    }

    public static boolean profi(double prob,int prize,int pay){
        return prob*prize>pay;
    }

    public static String operation(int n,int a,int b) {
        if (a + b == n) {
            return "added";
        } else if (a - b == n) {
            return "substracted";
        } else if (a * b == n) {
            return "multiplied";
        } else if (a / b == n) {
            return "devided";
        } else {
            return "none";
        }
    }

    public static int ctoa(char ct) {
        return (int) ct;
    }

    public static int upto(int n){
        return n*(n+1)/2;
    }

    public static int tr(int pr,int vr){
        return pr+vr-1;
    }

    public static int sumOfCubes(int[] array) {
        int sum = 0;
        for (int i : array)
            sum += i * i * i;
        return sum;
    }

    public static boolean abcmath(int a, int b, int c) {
        for (int i = 0; i < b; i++) {
            a += a;
        }
        return a % c == 0;
    }


}
