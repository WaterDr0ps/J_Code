package nuist_1.JavaTask;

public class Java_10_21 {
    public static void main(String[] args) {
        int[] A = {4, 3, 6};
        int[] B = {4, 0, -2, 8};
        int[] newC = new int[A.length + B.length];
        mergeArray(A, B, newC);
        printArray(newC);
        invertArray(newC);
        printArray(newC);
        System.out.println(countPrime(newC));
    }

    //合并
    public static void mergeArray(int[] A, int[] B, int[] newC) {
        for (int i = 0; i < newC.length; i++) {
            if (i < A.length) {
                newC[i] = A[i];
            } else {
                newC[i] = B[i - A.length];
            }
        }
    }

    //逆置
    public static void invertArray(int[] arr) {
        for (int i = 0, j = arr.length - 1; j - i > 0; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    //统计素数
    public static int countPrime(int[] arr) {
        int count = 0;
        boolean flag = true;
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr[i] + 1; j < arr.length - 1; j++) {
                if (arr[i] % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
            }
        }
        return count;
    }

    //遍历
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
