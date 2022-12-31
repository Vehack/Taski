import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;


public class Task_5 {
    public static void main(String[] args) {
        System.out.println(encrypt("Hello"));
        System.out.println(decrypt(new int[] {72, 33, -73, 84, -12, -3, 13, -13, -68}));
        System.out.println();

        System.out.println(canMove("ладья", "A8", "H8"));
        System.out.println(canMove("ферзь", "C4", "D6"));
        System.out.println();

        System.out.println(canComplete("butl", "beautifulqq"));
        System.out.println(canComplete("bbutl", "beautiful"));
        System.out.println();

        System.out.println(sumDigProd(1, 2, 3, 4, 5, 6));
        System.out.println();

        System.out.println(sameVowelGroup("toe", "ocelot", "maniac"));
        System.out.println();

        System.out.println(validateCard(1234567890123452L));
        System.out.println();

        System.out.println(numToEng(126));
        System.out.println();

        System.out.println(getSHA256Hash("password123"));
        System.out.println();

        System.out.println(correctTitle("jOn SnoW, kINg IN thE noRth."));
        System.out.println();

        hexLattice(19);
        System.out.println();
        hexLattice(21);
        System.out.println();
    }


    //1. шифратор и дешифратор Первая буква строки или первый элемент массива представляет собой символьный код
    //этой буквы. Следующие элементы-это различия между символами
    public static String encrypt(String s) {
        int[] cryptoMassive = new int[s.length()]; // массив, размерность которого равна длине строки
        cryptoMassive[0] = s.charAt(0); // добавляем в массив 1 символ, запишется код из табл ASCII
        for (int i = 1; i < s.length(); i++) { // начинаем со 2 эл
            cryptoMassive[i] = s.charAt(i) - s.charAt(i - 1); // разность символа с пред. символом
        }
        return Arrays.toString(cryptoMassive);
    }
    public static StringBuilder decrypt(int[] cryptoMassive) {
        StringBuilder line = new StringBuilder(cryptoMassive.length); //строка на вывод
        int sum = cryptoMassive[0]; // сумма эл. массива, доб. 1 эл
        line.append((char) sum); // добавляем 1 символа
        for (int i = 1; i < cryptoMassive.length; i++) {
            sum += cryptoMassive[i]; // суммируем со следующим
            line.append((char) sum); // добавляем в строку символ с таким индексом
        }
        return line;
    }

    //2. шахматы Создайте функцию, которая принимает имя шахматной фигуры, ее положение и
    //целевую позицию. Функция должна возвращать true, если фигура может двигаться
    //к цели, и false, если она не может этого сделать.
    public static boolean canMove(String name, String a, String b) {
        // разбиваем a и b на координаты
        char[] x = a.toCharArray(); // a = A8   x[0] = A    x[1] = 8
        char[] y = b.toCharArray(); // b = H8   y[0] = H    x[1] = 8

        // описываем все возможные ходы для каждой фигуры, по правилам шахмат
        return switch (name) {
            case ("пешка") -> ((int) x[0] == (int) y[0]) && (Math.abs((int) x[1] - (int) y[1]) == 1);
            case ("конь") ->
                    (Math.abs((int) x[0] - (int) y[0]) == 1) && (Math.abs((int) x[1] - (int) y[1]) == 2) || (Math.abs((int) x[0] - (int) y[0]) == 2) && (Math.abs((int) x[1] - (int) y[1]) == 1);
            case ("слон") -> (Math.abs((int) x[0] - (int) y[0]) == Math.abs((int) x[1] - (int) y[1]));
            case ("ладья") -> (x[0] == y[0]) || (x[1] == y[1]);
            case ("ферзь") ->
                    (Math.abs((int) x[0] - (int) y[0]) == Math.abs((int) x[1] - (int) y[1])) || (x[0] == y[0]) || (x[1] == y[1]);
            case ("король") -> (Math.abs((int) x[0] - (int) y[0]) <= 1) && (Math.abs((int) x[1] - (int) y[1]) <= 1);
            default -> false;
        };
    }

    //3. завершённость строки bl. Входная строка может быть завершена, если можно добавить дополнительные
    //буквы, и никакие буквы не должны быть удалены, чтобы соответствовать слову.
    public static boolean canComplete(String subline, String line) {
        int count = 0; // счетчик совпадений
        for (int i = 0; i < line.length(); i++) { // идем по строке
            if (line.charAt(i) == subline.charAt(count)) { // проверяем совпадение с подстрокой
                count++;
                if (subline.length() == count) // если вся подстрока совпадает то true
                    return true;
            }
        }
        return false;
    }

    //4. Создайте функцию, которая принимает числа в качестве аргументов, складывает их
    //вместе и возвращает произведение цифр до тех пор, пока ответ не станет длиной
    //всего в 1 цифру.
    public static int sumDigProd(int... massive) {
        int number = 0; // сумма цифр
        for (int i : massive) { // складываем числа
            number += i;
        }
        return bugger(number);
    }
    public static int bugger(int number) {
        while (number > 9) { // пока number не цифра, а число
            int tempNumber = 1; // производение цифр
            while (number > 0) {
                tempNumber *= number % 10; // умножаем цифры
                number /= 10; // уменьшаем
            }
            number = tempNumber; // number становится текущим произведением
        }
        return number;
    }


    //5. Напишите функцию, которая выбирает все слова, имеющие все те же гласные (в
    //любом порядке и / или количестве), что и первое слово, включая первое слово.
    public static List<String> sameVowelGroup(String... lines) {
        List<String> result = new ArrayList<>(); // результат
        Set<Character> set = new HashSet<>(); // массив уникальных элементов
        result.add(lines[0]); // добавляем 1 слово
        String word1 = lines[0].replaceAll("[^aeiouy]", ""); // находим гласные через рег выраж
        for (int i = 0; i < word1.length(); i++)
            set.add(word1.charAt(i)); // вносим гласные в уник. массив
        for (int i = 1; i < lines.length; i++) {
            String word2 = lines[i].replaceAll("[^aeiouy]", ""); // находим гласные
            boolean k = true; // флаг, встречаются ли в слове гласные из 1 слова
            for (char c : word2.toCharArray())  // сравниваем гласные с гласными из уник. массива
                if (!set.contains(c)) { //если нет то false
                    k = false;
                    break;
                }
            if (k) // если встречаются то добавляем в результат
                result.add(lines[i]);
        }
        return result;
    }

    //6. Создайте функцию, которая принимает число в качестве аргумента и возвращает
    //true, если это число является действительным номером кредитной карты, а в
    //противном случае-false.
    public static boolean validateCard(Long number) {
        if (number < Math.pow(10, 14) || number >= Math.pow(10, 20)) {
            return false;
        }
        // шаг 1 - находим контрольную сумму
        int checkSum = (int) (number % 10);
        String num = number.toString();
        num = num.substring(0, num.length() - 1); // удаляем последний символ
        // шаг 2-3-4, идем по числу в обратном порядке, и сразу же складываем найденные цифры
        int sum = 0;
        for (int i = num.length() - 1; i >= 0; i--) {
            int doubleInt = Integer.parseInt(num.substring(i, i + 1));
            if ((num.length() - i) % 2 == 1) {
                doubleInt *= 2; // удваиваем
                if (doubleInt > 9) { // если больше 1 цифры
                    doubleInt = doubleInt % 10 + (doubleInt / 10) % 10; // складываем вместе
                }
            }
            sum += doubleInt;
        }
        // шаг 5 - сравниваем число с контрольной цифрой
        return (10 - (sum % 10)) == checkSum;
    }

    //7. Напишите функцию, которая принимает положительное целое число от 0 до 999
    //включительно и возвращает строковое представление этого целого числа,
    //написанное на английском языке
    public static String numToEng (int n) {
        String[] digits = new String[] {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                "eleven", "twelve", "thirten", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] des = new String[] {"twenty ", "thirty ", "fourty ", "fifty ", "sixty ", "seventy ", "eighty ", "ninety "};
        if (n == 0) {
            return "zero";
        }
        var res = new StringBuilder();
        int s_100 = n / 100;
        int s_011 = n - s_100 * 100;
        int s_001 = n % 10;
        if (s_100 != 0) {
            res.append(digits[s_100 - 1]);
            res.append(" hundred ");
        }
        if (s_011 < 20) {
            res.append(des[s_011 - 1]);
        }
        else {
            res.append(des[s_011 / 10 - 2]);
            if (s_001 != 0)
                res.append(digits[s_001 - 1]);
        }
        int n1 = res.length() - 1;
        if (res.charAt(n1) == ' ')
            res.deleteCharAt(n1);
        return res.toString();
    }

    //8. Создайте функцию, которая возвращает безопасный хеш SHA-256 для данной строки.
    //Хеш должен быть отформатирован в виде шестнадцатеричной цифры.
    public static String getSHA256Hash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256"); //дайджест сообщений, экземпляр класса, который выч. хеш-функцию
            byte[] hashInBytes = md.digest(input.getBytes(StandardCharsets.UTF_8)); // вычисление хеш-функции в байтах
            StringBuilder sb = new StringBuilder();
            for (byte b : hashInBytes) {
                sb.append(String.format("%02x", b)); // байты в hex
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace(); //если SHA-256 недоступен
        }
        return null;
    }

    //9. Напишите функцию, которая принимает строку и возвращает строку с правильным
    //регистром для заголовков символов в серии "Игра престолов"
    public static String correctTitle(String s) {
        String[] words = new String[]{"in", "and", "the", "of"}; // слова которые не нужно трогать
        String[] arr = s.split(" "); // строку делим на слова
        StringBuilder res = new StringBuilder();
        for (String x : arr) {
            x = x.toLowerCase(); // слово в нижий регистр
            if (Arrays.asList(words).contains(x)) { //если слово запрещенное
                if (x.charAt(x.length() - 1) != '.') // если не конец то добавляем пробел
                    res.append(x + " ");
                else
                    res.append(x); // или просто добавляем
            } else {
                if (x.charAt(x.length() - 1) != '.')
                    res.append(x.substring(0, 1).toUpperCase() + x.substring(1) + " "); // сначала все в нижний регистр (265) потом 1-ый символ в верх
                else
                    res.append(x.substring(0, 1).toUpperCase() + x.substring(1));
            }
        }
        return res.toString();
    }


    //10. Гексогон. Напишите функцию, которая принимает целое число n и возвращает "недопустимое", если
    //n не является центрированным шестиугольным числом или его иллюстрацией в виде
    //многострочной прямоугольной строки в противном случае
    public static void hexLattice(int n) {
        for (int i = 1; n >= 1; i++) { // Центрированное шестиугольное число
            if (n == 1) {
                n = i;
                break;
            }
            n -= i * 6;
        }
        if (n < 0) {
            System.out.println("Invalid");
        }

        int space = 1 + (n - 1) * 2; // экватор

        for(int i = 0; i < space;){
            int repeatTimes = Math.abs(++i - n); // кол-во повторений
            System.out.println(" ".repeat(repeatTimes) + "o ".repeat(space - repeatTimes) + "\n");

        }
    }
}
