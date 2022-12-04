import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Eliot
 */


public class Sort {

    @Test
    public void bubbleSort() {
        int[] a = {5, 4, 3, 2, 1};
        for (int i = 0; i < a.length - 1; i++) {
            boolean flag = false;//没有发生交换,数组排序已完成
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    flag = true;//发生交换
                }
            }
            if (!flag) {
                //没有发生交换直接退出循环
                break;
            }
            System.out.println("第" + (i + 1) + "次循环:" + Arrays.toString(a));
        }
    }

    @Test
    public void selectionSort() {
        int[] a = {5, 4, 3, 2, 1};
        for (int i = 0; i < a.length - 1; i++) {
            int min = a[i];
            for (int j = i + 1; j < a.length; j++) {
                if (min > a[j]) {
                    swap(a, i, j);
                }
            }
            System.out.println("第" + (i + 1) + "次循环:" + Arrays.toString(a));
        }
    }

    @Test
    public void insertSort() {
        int[] a = {5, 4, 3, 2, 1};
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            int j = i - 1;
            while (j >= 0) {
                if (temp < a[j]) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
                j--;
            }
            a[j + 1] = temp;
            System.out.println("第" + i + "次循环:" + Arrays.toString(a));
        }
    }

    @Test
    public void quickSort() {
        int[] a = {5, 3, 7, 2, 9, 8, 1, 4};
        quick(a, 0, a.length - 1);
    }

    private void quick(int[] a, int l, int h) {
        if (l >= h) {
            return;
        }
        int p = partition(a, l, h);
        quick(a, l, p - 1);
        quick(a, p + 1, h);
    }

    private int partition(int[] a, int l, int h) {
        int pv = a[h];
        int i = l;
        for (int j = i; j < h; j++) {
            if (a[j] < pv) {
                swap(a, i, j);
                i++;
            }
        }
        swap(a, i, h);
        System.out.println(Arrays.toString(a));
        return i;
    }



    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}













