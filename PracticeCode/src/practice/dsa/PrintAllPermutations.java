package practice.dsa;

public class PrintAllPermutations {

    public static void main(String[] args) {
        String str = "ABC";

        backtrack(str, 0, str.length() - 1);
    }

    private static void backtrack(String str, int l, int r) {
        if (l == r) {
            System.out.println(str);
        } else 
        {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                backtrack(str, l + 1, r);
                str = swap(str, l, i);
            }
        }

    }

    private static String swap(String a, int i, int j) {
        char[] output = a.toCharArray();
        char temp = output[i];
        output[i] = output[j];
        output[j] = temp;

        return String.valueOf(output);
    }

}
