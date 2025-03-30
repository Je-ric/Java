import java.util.Arrays;

public class Main1 {
    public static void main(String[] args) {
        int[] origArray = {10, 22, 10, 20, 11, 22};
        Arrays.sort(origArray);

        int uniqueCount = 1;
        for (int i = 1; i < origArray.length; i++) {
            if (origArray[i] != origArray[i - 1]) {
                uniqueCount++;
            }
        }

        int[] newArray = new int[uniqueCount];
        newArray[0] = origArray[0];
        int newIndex = 1;

        for (int i = 1; i < origArray.length; i++) {
            if (origArray[i] != origArray[i - 1]) {
                newArray[newIndex] = origArray[i];
                newIndex++;
            }
        }

        System.out.println(Arrays.toString(newArray));
    }
}
