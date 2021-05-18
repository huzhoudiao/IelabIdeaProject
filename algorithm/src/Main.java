import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] datas = new int[]{4,3,1,7,3,8,9};
//        SortAlgorithm.bubbleSort(datas);
        SortAlgorithm.selectSort(datas);
        String result = Arrays.toString(datas);
        System.out.println(result);
        int[] test;

    }
}
