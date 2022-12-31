import java.util.ArrayList;

public class Task_4 {
    public static void main(String[] args) {
        System.out.println(essay(10,7, "hello my name is Bessie and this is my essay"));
        System.out.println(split("((()))"));
        System.out.println(split("((()))(())(()())"));
        System.out.println(toSnakeCase("helloEdabit"));
        System.out.println(toCamelCase("is_modal_open"));
        System.out.println(overTime(new double[] {16, 18, 30, 1.8}));
        System.out.println(BMI("55 kilos", "1.65 meters"));
        System.out.println(BMI("154 pounds", "2 meters"));
        System.out.println(bugger(39));
        System.out.println(bugger(999));
        System.out.println(toStarShorthand("abbccc"));
        System.out.println(toStarShorthand("77777geff"));
        System.out.println(doesRhyme("Sam I am!", "Green eggs and ham."));
        System.out.println(doesRhyme("You are off to the races", "a splendid day."));
        System.out.println(trouble(451999277, 1177722899));
        System.out.println(countUniqueBooks("AZYWABBCATTTA", 'A'));

    }
//    Эссе содержит N слов (1≤N≤100), разделенных пробелами. Каждое слово имеет
//    длину от 1 до 15 символов включительно и состоит только из прописных или
//    строчных букв. Согласно инструкции к заданию, эссе должно быть
//    отформатировано очень специфическим образом: каждая строка должна содержать
//    не более K (1≤K≤80) символов, не считая пробелов.
    public static String essay(int n, int k, String text) { // №1
        StringBuilder res = new StringBuilder();
        int i = 0;
        for(String str : text.split(" ")) {
            if(str.length() > k)
                return "Error";
            else if(i != 0 && i + str.length() <= k) {
                res.append(" ");
                i += str.length();
            }
            else {
                if(i != 0)
                    res.append("\n");
                i = str.length();
            }
            res.append(str);
        }
        return res.toString();
    }


//    Напишите функцию, которая группирует строку в кластер скобок. Каждый кластер
//    должен быть сбалансирован.
    public static String split(String str) { // №2
        int a = 0, b = 0, start = 0;
        ArrayList<String> res = new ArrayList<>();
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(')
                a += 1;
            if(str.charAt(i) == ')') {
                b += 1;
                if(a == b) {
                    res.add(str.substring(start, i+1));
                    start = i+1;
                }
            }
        }
        return res.toString();
    }


//    Cоздайте две функции toCamelCase () и toSnakeCase (), каждая из которых берет
//    одну строку и преобразует ее либо в camelCase, либо в snake_case.
    public static String toCamelCase(String text) { // №3
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == '_') {
                str.append(Character.toUpperCase(text.charAt(i + 1)));
                i++;
            }
            else
                str.append(text.charAt(i));
        }
        return str.toString();
    }

    public static String toSnakeCase(String text) {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < text.length(); i++) {
            if(Character.isUpperCase(text.charAt(i))) {
                str.append("_" + Character.toLowerCase(text.charAt(i)));
            }
            else
                str.append(text.charAt(i));
        }
        return str.toString();
    }


//    Напишите функцию, которая вычисляет сверхурочную работу и оплату, связанную
//    с сверхурочной работой.
    public static String overTime(double[] array) { // №4
        StringBuilder str = new StringBuilder("$");
        double pay;
        if(array[1] <= 17.0)
            pay = (array[1] - array[0]) * array[2];
        else
            pay = (17 - array[0]) * array[2] + (array[1] - 17) * array[2] * array[3];
        str.append(String.format("%.2f", pay));
        return str.toString();
    }


//    Индекс массы тела (ИМТ) определяется путем измерения вашего веса в
//    килограммах и деления на квадрат вашего роста в метрах
    public static String BMI(String weight_str, String height_str){
        String[] arr_weight = weight_str.split(" ");
        double weight_db = Double.parseDouble(arr_weight[0]);
        String type_of_weight = arr_weight[1];

        String[] arr_height = height_str.split(" ");
        double height_db = Double.parseDouble(arr_height[0]);
        String type_of_height = arr_height[1];

        if(type_of_weight.charAt(0) == 'p')
            weight_db /= 2.205;
        if (type_of_height.charAt(0) == 'i')
            height_db/= 39.37;

        double bmi = weight_db/ (height_db*height_db);

        if(bmi >= 25)
            return (Math.round(bmi*10)/10d + " Overweight");
        else if (bmi < 18.5)
            return (Math.round(bmi*10d)/10d + " Underweight");
        else
            return (Math.round(bmi*10d)/10d + " Normal weight");
    }


//    Создайте функцию, которая принимает число и возвращает его мультипликативное
//    постоянство, которое представляет собой количество раз, которое вы должны
//    умножать цифры в num, пока не достигнете одной цифры
    public static int bugger(int number) { // №6
        int count = 0, newNumber = 1;
        StringBuilder strNumber = new StringBuilder(Integer.toString(number));
        while(strNumber.length() > 1) {
            for(int i = 0; i < strNumber.length(); i++) {
                newNumber *= Character.getNumericValue(strNumber.charAt(i));
            }
            strNumber.setLength(0);
            strNumber.append(newNumber);
            newNumber = 1;
            count ++;
        }
        return count;
    }


    //Напишите функцию, которая преобразует строку в звездную стенографию. Если
    //символ повторяется n раз, преобразуйте его в символ*n.
    public static String toStarShorthand(String str) { // №7
        if(str.length() == 0)
            return "";
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            int j = i, count = 1;
            while(str.length()-1 > j && str.charAt(i) == str.charAt(j+1)) {
                j++;
                count++;
            }
            i = j;
            res.append(str.charAt(i));
            if(count != 1) {
                res.append("*" + count);
            }
        }
        return res.toString();
    }


    //Создайте функцию, которая возвращает true, если две строки рифмуются, и false в
    //противном случае. Для целей этого упражнения две строки рифмуются, если
    //последнее слово из каждого предложения содержит одни и те же гласные.
    public static boolean doesRhyme(String str1, String str2) { // №8
        char[] vowels = new char[] {'a','e','i','o','u','y'};
        StringBuilder vowels1 = new StringBuilder();
        StringBuilder vowels2 = new StringBuilder();
        for(int i = str1.lastIndexOf(" ") + 1; i < str1.length(); i++) {
            for(int j = 0; j < vowels.length; j++) {
                if (Character.toLowerCase(str1.charAt(i)) == vowels[j])
                    vowels1.append(Character.toLowerCase(str1.charAt(i)));
            }
        }
        for(int i = str2.lastIndexOf(" ") + 1; i < str2.length(); i++) {
            for (int j = 0; j < vowels.length; j++) {
                if (Character.toLowerCase(str2.charAt(i)) == vowels[j])
                    vowels2.append(Character.toLowerCase(str2.charAt(i)));
            }
        }
        return vowels1.compareTo(vowels2) == 0;
    }


    //Создайте функцию, которая принимает два целых числа и возвращает true, если
    //число повторяется три раза подряд в любом месте в num1 и то же самое число
    //повторяется два раза подряд в num2.
    public static boolean trouble(int num1, int num2) { // №9
        String strNum1 = Integer.toString(num1);
        String strNum2 = Integer.toString(num2);
        for(int i = 2; i < strNum1.length(); i++) {
            if(strNum1.charAt(i) == strNum1.charAt(i-1) && strNum1.charAt(i) == strNum1.charAt(i-2)) {
                int repeatable = strNum1.charAt(i);
                for (int n = 1; n < strNum2.length(); n++) {
                    if (repeatable == strNum2.charAt(n) && repeatable == strNum2.charAt(n-1))
                        return true;
                }
            }
        }
        return false;
    }


    //Предположим, что пара одинаковых символов служит концами книги для всех
    //символов между ними. Напишите функцию, которая возвращает общее количество
    //уникальных символов (книг, так сказать) между всеми парами концов книги.
    public static int countUniqueBooks(String stringSequence, char bookEnd) { // №10
        ArrayList<Character> unique = new ArrayList<>();
        int count = 0;
        boolean countEnd = false;
        for(int i = 0; i < stringSequence.length(); i++) {
            if(stringSequence.charAt(i) == bookEnd) {
                countEnd = !countEnd;
            }
            if(countEnd) {
                if(!unique.contains(stringSequence.charAt(i))) {
                    unique.add(stringSequence.charAt(i));
                    count++;
                }
            }
        }
        return --count;
    }

}
