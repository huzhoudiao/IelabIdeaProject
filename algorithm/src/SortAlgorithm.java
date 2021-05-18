public class SortAlgorithm {
    public static void bubbleSort(int[] datas){
        for (int i = 0; i < datas.length - 1; i++) {
            for (int j = 0; j < datas.length - 1 - i; j++) {
                if(datas[j] > datas[j+1]){
                    int temp = datas[j+1];
                    datas[j+1] = datas[j];
                    datas[j] = temp;
                }
            }
        }

    }
    public static void insertSort(int[] datas){

        for (int i = 1; i < datas.length; i++) {
            int temp = datas[i];
            int j;
            for (j = i-1; j >= 0 ; j--) {
               if(temp < datas[j]){
                   datas[j+1] = datas[j];
               }
               else{
                   break;
               }
            }
            datas[j+1] = temp;
        }
    }
    public static void shellSort(int[] datas){
        int d = datas.length / 3 + 1;
        while(d >= 1){
            for (int i = d; i < datas.length; i++) {
                int temp = datas[i];
                int j = i - d;
                while(j >= 0 && temp < datas[j]){
                    datas[j+d] = datas[j];
                    j-=d;
                }
                datas[j+d] = temp;
            }
            d = d / 3;
        }
    }
    public static void selectSort(int[] datas){
        for (int i = 0; i < datas.length; i++) {
            int min = datas[i];
            for (int j = i+1; j < datas.length; j++) {
                if(datas[j] < min){
                    int t = datas[j];
                    datas[j] = min;
                    min = t;
                }
            }
            datas[i] = min;
        }
    }
}
