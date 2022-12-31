import java.util.Arrays;

public class Task_2 {

    public static void main(String[] args) {

        System.out.println(repeat("los", 3));//t1
        System.out.println(differenceMaxMin(new int[]{10, 4, 1, 4, -10, -50, 32, 21})); //t2
        System.out.println(isAvgWhole(new int[]{1,2,3,4}));//t3
        System.out.println(cumulativeSum(new int[]{1, 2, 3}));//t4
        System.out.println(cumulativeSum(new int[]{1, -2, 3}));
        System.out.println(getDecimalPlaces("43.20"));//t5
        System.out.println(getDecimalPlaces("400"));
        System.out.println(getDecimalPlaces("3.1"));
        System.out.println(Fibonacci(3));//t6
        System.out.println(Fibonacci(7));
        System.out.println(Fibonacci(12));
        System.out.println(isValid("59001"));//t7
        System.out.println(isValid("853.7"));
        System.out.println(isValid("732 32"));
        System.out.println(isValid("393939"));
        System.out.println(isStrangePair("sparkling", "groups"));//t8
        System.out.println(isStrangePair("bush", "hubris"));
        System.out.println(isStrangePair("", ""));
        System.out.println(isPrefix("automation", "auto-"));//t9
        System.out.println(isSuffix("arachnophobia", "-phobia"));
        System.out.println(isPrefix("retrospect", "sub-"));
        System.out.println(isSuffix("vocation", "-logy"));
        System.out.println(boxSeq(0));//t10
        System.out.println(boxSeq(1));
        System.out.println(boxSeq(2));


    }

    //Создайте функцию, которая повторяет каждый символ в строке n раз.
    public static String repeat(String s, int n) {
        char[] inputString = s.toCharArray();
        String result = "";
        for (int i = 0; i < inputString.length; i++) {
            for (int j = 0; j < n; j++) {
                result += inputString[i];
            }
        }
        return result;
    }

    //Создайте функцию, которая принимает массив и возвращает разницу между
    //самыми большими и самыми маленькими числами
    public static int differenceMaxMin(int[] array) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i : array) {
            if (i < min)
                min = i;
            if (i > max)
                max = i;
        }
        return max - min;
    }

    //Создайте функцию, которая принимает массив в качестве аргумента и возвращает
    //true или false в зависимости от того, является ли среднее значение всех элементов
    //массива целым числом или нет
    public static boolean isAvgWhole(int[] array){
        double sumArray = 0; //сумма элементов массива
        for (int i : array){
            sumArray += i;
        }
        return (sumArray % array.length  == 0); //проверка на целочисленность
    }

    //Создайте метод, который берет массив целых чисел и возвращает массив, в
    //котором каждое целое число является суммой самого себя + всех предыдущих
    //чисел в массиве
    public static String cumulativeSum(int[] array) {
        int[] result; //массив из суммы предыдущих элементов
        result = new int[array.length];
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            result[i] = sum;
        }
        return Arrays.toString(result);
    }

    //Создайте функцию, которая возвращает число десятичных знаков, которое имеет
    //число (заданное в виде строки). Любые нули после десятичной точки
    //отсчитываются в сторону количества десятичных знаков.
    public static int getDecimalPlaces(String s) {
        int result = 0; //цифры после запятой
        for (int i = s.length() - 1; i > 0; i--) //обратный цикл, считает до точки
            if (s.charAt(i) == '.')
                result = s.length() - i - 1;
        return result;
    }

    //Создайте функцию, которая при заданном числе возвращает соответствующее
    //число Фибоначчи
    public static int Fibonacci(int n) {
        int[] array = new int[n];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i < array.length; ++i) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[array.length-1];
    }
    //Почтовые индексы состоят из 5 последовательных цифр. Учитывая строку,
    //напишите функцию, чтобы определить, является ли вход действительным
    //почтовым индексом. Действительный почтовый индекс выглядит следующим
    //образом:
    //– Должно содержать только цифры (не допускается использование нецифровых цифр).
    //– Не должно содержать никаких пробелов.
    //– Длина не должна превышать 5 цифр.
    public static boolean isValid(String s) {
        return (s.length() == 5 && s.replaceAll("[\\D]", "").length() == 5);
    }

    //Пара строк образует странную пару, если оба из следующих условий истинны:
    //– Первая буква 1-й строки = последняя буква 2-й строки.
    //– Последняя буква 1-й строки = первая буква 2-й строки.
    //– Создайте функцию, которая возвращает true, если пара строк представляет собой
    //странную пару, и false в противном случае
    public static boolean isStrangePair(String s1, String s2) {
        s1 = " " + s1 + " "; // на случай, если поступят пустые строки
        s2 = " " + s2 + " "; //
        return (s1.charAt(1) == s2.charAt(s2.length() - 2) && s2.charAt(1) == s1.charAt(s1.length() - 2));
        // возвращает true, если 1[1] = 2[l] и 1[l] = 2[1]
    }

    //Создайте две функции: isPrefix(word, prefix-) и isSuffix (word, -suffix).
    //– isPrefix должен возвращать true, если он начинается с префиксного аргумента.
    //– isSuffix должен возвращать true, если он заканчивается аргументом суффикса.
    //– В противном случае верните false.
    public static boolean isPrefix(String s1, String s2) {
        return (s1.substring(0, s2.length() - 1).equals(s2.substring(0, s2.length() - 1)));
        //берем подстроку длинной s2 в s1 в начале, сравниваем с s2, если равные, возвращает true
    }

    public static boolean isSuffix(String s1, String s2) {
        return (s1.substring(s1.length() - s2.length() + 1).equals(s2.substring(1)));
        //тоже самое только, берет подстроку с конца
    }

    //Создайте функцию, которая принимает число (шаг) в качестве аргумента и
    //возвращает количество полей на этом шаге последовательности.
    public static int boxSeq(int n) {
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            //если шаг нечетный(1) => +3
            if (i % 2 == 1) {
                sum += 3;
            }
            //если шаг четный(2) => -1
            if (i % 2 == 0) {
                sum -= 1;
            }
        }

        return sum;
    }


}
