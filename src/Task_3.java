import java.util.ArrayList;

public class Task_3 {
    public static void main(String[] args) {
        int[] arr1 = new int[] {1, 3, 4, 4, 4};
        int[] arr2 = new int[] {2, 5, 7};

        System.out.println(solutions(0, 0, -1));//1
        System.out.println(findZip("all zip files are zipped"));//2
        System.out.println(checkPerfect(97));//3
        System.out.println(flipEndChars("Cat, dog, and mouse."));//4
        System.out.println(isValidHexCode("#CCCCCC"));//5
        System.out.println(same(arr1, arr2)); // 6
        System.out.println(isKaprekar(13)); // 7
        System.out.println(longestZero("000100")); // 8
        System.out.println(nextPrime(12)); // 9
        System.out.println(rightTriangle(3, 4, 5)); // 10

    }


    //Квадратное уравнение ax 2 + bx + c = 0 имеет либо 0, либо 1, либо 2 различных
    //решения для действительных значений x. учитывая a, b и c, вы должны вернуть
    //число решений в уравнение.
    public static  String solutions(int a, int b, int c){
        if (a != 0) {
            int d = b * b - 4 * a * c;
            if (d == 0) {
                return "1";
            }
            if (d > 0) {
                return "2";
            } else {
                return "0";
            }
        }
        else {
            String g = "Error";
            return g;
        }
    } // 1

    //Напишите функцию, которая возвращает позицию второго вхождения " zip " в
    //строку, или -1, если оно не происходит по крайней мере дважды. Ваш код должен
    //быть достаточно общим, чтобы передать все возможные случаи, когда "zip" может
    //произойти в строке
    public static int findZip(String s){
        int z = s.indexOf("zip");
        return s.indexOf("zip",z+1);
    } // 2

    //Создайте функцию, которая проверяет, является ли целое число совершенным
    //числом или нет. Совершенное число - это число, которое можно записать как
    //сумму его множителей, исключая само число.
    public static boolean checkPerfect(int n){
        int sum = 0;
        for (int i = 1; i < n; i++){
            if (n % i == 0){
                sum += i;
            }
        }
        if (sum == n)
            return true;
        return false;
    } // 3

    //Создайте функцию, которая принимает строку и возвращает новую строку с
    //заменой ее первого и последнего символов, за исключением трех условий:
    public static String flipEndChars(String s){
        char firstchar = s.charAt(0);
        char secondchar = s.charAt(s.length() -1);
        if (firstchar == secondchar){
            return "Two's a pair.";
        }
        if (s.length()<2){
            return "Incompatible.";
        }
        else{
            String sub = s.substring(1,s.length()-1);
            return secondchar + sub + firstchar;
        }
    } // 4

    //Создайте функцию, которая определяет, является ли строка допустимым
    //шестнадцатеричным кодом
    public static boolean isValidHexCode (String s) {
        return  s.matches("#[0-9A-Fa-f]{6}");
    } // 5

    //Напишите функцию, которая возвращает true, если два массива имеют одинаковое
    //количество уникальных элементов, и false в противном случае.
    public static boolean same(int[] arr1, int[] arr2) {
        return unique_count(arr1) == unique_count(arr2);
    }

    public static int unique_count(int[] arr) {
        ArrayList<Integer> unique = new ArrayList<>(0);

        for (int i = 0; i < arr.length; i++) {
            if (!unique.contains(arr[i])) {
                unique.add(arr[i]);
            }
        }
        return unique.size();
    } // 6


    //Число Капрекара-это положительное целое число, которое после возведения в
    //квадрат и разбиения на две лексикографические части равно сумме двух
    //полученных новых чисел:
    //– Если количество цифр квадратного числа четное, то левая и правая части будут иметь
    //одинаковую длину.
    //– Если количество цифр квадратного числа нечетно, то правая часть будет самой длинной
    //половиной, а левая-самой маленькой или равной нулю, если количество цифр равно 1.– Учитывая положительное целое число n, реализуйте функцию, которая возвращает true,
    //если это число Капрекара, и false, если это не так.
    public static boolean isKaprekar(int n) {
        String nSqr = Integer.toString(n * n);
        String pS1 = nSqr.substring(0, nSqr.length() / 2);
        String pS2 = nSqr.substring(nSqr.length() / 2);

        int pI1 = Integer.parseInt(pS1);
        int pI2 = Integer.parseInt(pS2);

        return (pI1 + pI2 == n);

    }

     // 7

    //Напишите функцию, которая возвращает самую длинную последовательность
    //последовательных нулей в двоичной строке.
    public static String longestZero(String s) {
        String line = "";
        String maxLen = "";
        for(int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == '0') {
                line += '0';
            }
            else{
                if (line.length() > maxLen.length()) {
                    maxLen = line;
                }
                line = "";
            }
        }
        return maxLen;
    }// 8

    //Если задано целое число, создайте функцию, которая возвращает следующее
    //простое число. Если число простое, верните само число.
    public static int nextPrime(int num) {
        int result = 0;
        for(int i = num; i <= 100; i ++){
            boolean isPrime = true;

            for(int j = 2; j < i; j++){

                if(i % j == 0){
                    isPrime = false;
                    break;
                }
            }

            if( (isPrime)){
                result = i;
                break;
            }

        }
        return result;

    } // 9

    //Учитывая три числа, x, y и z, определите, являются ли они ребрами
    //прямоугольного треугольника
    public static boolean rightTriangle(float x, float y, float z) {
        x *= x;
        y *= y;
        z *= z;
        return ((x == y + z) || (y == x + z) || (z == y + x)) && (x != 0) && (y != 0) && (z != 0);

    } // 10


}
