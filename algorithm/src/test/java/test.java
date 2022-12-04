import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Eliot
 */

public class test {


    @Test
    public void topK(){
        int[] a = {4,8,11,5,6,22,15,2,3,9,4,15,16,27,19,20,1,3,30};
        quick(a,0,a.length-1);

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
