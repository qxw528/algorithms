import com.algo.utils.AlgorithmsSortUtils;

/**
 * Created by qiusir on 10/25/17.
 */
public class Main {

    private AlgorithmsSortUtils algorithmsSortUtils;

    public Main() {
        this.algorithmsSortUtils = new AlgorithmsSortUtils();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.shellSort();
    }

    private void mergeArray() {
        int[] arrayA = {23,47,81,95};
        int[] arrayB = {7,14,39,55,62,74};
        int[] arrayC = new int[10];

        algorithmsSortUtils.merge(arrayA,4,arrayB,6,arrayC);
        display(arrayC);
    }


    public void display(int[] array) {
        for (int i = 0, len = array.length;i<len;i++) {
            System.out.println(array[i] + "");
        }
    }

    public void display(long[] array) {
        for (int i = 0, len = array.length;i<len;i++) {
            System.out.println(array[i] + "");
        }
    }

    private void shellSort() {
        long[] elements = {10,89,6,34,23,67,34,99,3,24,67};
        algorithmsSortUtils.shellSort(elements,elements.length);
        display(elements);
    }
}
