public class Ex9 {
    public static void main(String[] args) {
        System.out.println(sumOfCubes(new int[]{3, 4, 5}));
        System.out.println(sumOfCubes(new int[]{2}));
    }

    public static int sumOfCubes(int[] array) {
        int sum = 0;
        for (int i : array)
            sum += i * i * i;
        return sum;
    }
}