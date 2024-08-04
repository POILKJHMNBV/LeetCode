package com.example.sort;

import java.util.Arrays;
import java.util.Objects;

/**
 * 排序工具类
 */
public final class SortUtil {

    private SortUtil() {}

    /**
     * 选择排序
     */
    public static void selectionSort(int[] array) {
        int length = array.length;
        if (length == 0 || length == 1) {
            return;
        }
        for (int i = 0; i < length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);
        }
    }

    /**
     * 插入排序
     */
    public static void insertSort0(int[] array) {
        int length = array.length;
        if (length == 0 || length == 1) {
            return;
        }
        for (int i = 1; i < length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j - 1] > array[j]) {
                    swap(array, j - 1, j);
                }
            }
        }
    }

    /**
     * 插入排序
     */
    public static void insertSort(int[] array) {
        int length = array.length;
        if (length == 0 || length == 1) {
            return;
        }
        for (int i = 1; i < length; i++) {
            int temp = array[i];
            int j;
            for (j = i; j > 0; j--) {
                if (array[j - 1] > temp) {
                    array[j] = array[j - 1];
                } else {
                    break;
                }
            }
            array[j] = temp;
        }
    }

    /**
     * 冒泡排序
     */
    public static void bubbleSort(int[] array) {
        int length = array.length;
        if (length == 0 || length == 1) {
            return;
        }
        int end = length - 1;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < end; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
            end--;
        }
    }

    /**
     * 归并排序
     */
    public static void mergeSort(int[] array) {
        int length = array.length;
        merge(array, 0, length - 1);
    }

    private static void merge(int[] array, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2;
        merge(array, left, mid);
        merge(array, mid + 1, right);
        mergeOfTwoSortedArray(array, left, mid, right);
    }

    private static void mergeOfTwoSortedArray(int[] array, int left, int mid, int right) {
        // 创建临时数组用于归并
        int len = right - left + 1;
        int[] temp = new int[len];
        System.arraycopy(array, left, temp, 0, len);

        // 开始归并
        // i,j分别指向临时数组中前后两个有序数组的起始位置
        int i = 0;
        int j = mid - left + 1;
        for (int k = 0; k < len; k++) {
            // 先写i和j数组越界的情况
            if (i == mid - left + 1) {
                array[left + k] = temp[j];
                j++;
            } else if (j == len) {
                array[left + k] = temp[i];
                i++;
            } else if(temp[i] <= temp[j]) {
                // 为了保证归并排序的稳定性，此处必须小于等于
                array[left + k] = temp[i];
                i++;
            } else {
                array[left + k] = temp[j];
                j++;
            }
        }
    }

    /**
     * 快速排序
     */
    public static void quickSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(int[] array, int l, int r) {
        if (l < r) {
            swap(array, l + (int) (Math.random() * (r - l + 1)), r);
            int[] p = partition(array, l, r);
            quickSort(array, l, p[0] - 1);
            quickSort(array, p[1] + 1, r);
        }
    }

    private static int[] partition(int[] array, int l, int r) {
        int less = l - 1;
        int more = r;
        while (l < more) {
            if (array[l] < array[r]) {
                swap(array, ++less, l++);
            } else if (array[l] > array[r]) {
                swap(array, --more, l);
            } else {
                l++;
            }
        }
        swap(array, more, r);
        return new int[]{less + 1, more};
    }

    /**
     * 堆排序
     */
    public static void heapSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        int length = array.length;
        for (int i = 0; i < length; i++) {
            heapInsert(array, i);
        }
        int heapSize = array.length;
        swap(array, 0, --heapSize);
        while (heapSize > 0) {
            heapify(array, 0, heapSize);
            swap(array, 0, --heapSize);
        }
    }

    private static void heapInsert(int[] array, int index) {
        while (array[index] > array[(index - 1) / 2]) {
            swap(array, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    /**
     * 向下调整堆
     */
    private static void heapify(int[] array, int index, int heapSize) {
        int left = 2 * index + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && array[left + 1] > array[left] ? left + 1 : left;
            largest = array[largest] > array[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(array, index, largest);
            index = largest;
            left = 2 * index + 1;
        }
    }

    /**
     * 基数排序(桶排序)
     * @param array 待排序的数组
     */
    public static void bucketSort(int[] array) {
        Objects.requireNonNull(array);
        if (array.length < 2) {
            return;
        }
        bucketSort(array, 0, array.length - 1, maxBits(array));
    }

    /**
     * 实现某一特定区间的桶排序
     * @param array 待排序的数组
     * @param left 左边界
     * @param right 右边界
     * @param digit 数组最大值的位数
     */
    private static void bucketSort(int[] array, int left, int right, int digit) {
        final int radix = 10;
        int i = 0, j = 0;
        int[] bucket = new int[right - left + 1];

        // 数组最大值有多少位，就进出桶多少次
        for (int k = 1; k <= digit; k++) {

            // count[0] 当前位(d位)是0的数字有多少个
            // count[1] 当前位(d位)是1的数字有多少个
            int[] count = new int[radix];
            for (i = left; i <= right; i++) {
                j = getDigit(array[i], k);
                count[j]++;
            }

            // 当前为 <=d 的数字有多少个
            for (i = 1; i < radix; i++) {
                count[i] += count[i - 1];
            }

            // 从右往左遍历，开始出桶
            for (i = right; i >= left; i--) {
                j = getDigit(array[i], k);
                bucket[count[j] - 1] = array[i];
                count[j]--;
            }

            // 将桶中数据拷贝回原数组，完成一次入桶，出桶
            for (i = left, j = 0; i <= right; i++, j++) {
                array[i] = bucket[j];
            }
        }
    }

    /**
     * 求数组中最大值的位数
     */
    private static int maxBits(int[] array) {
        Arrays.sort(array);
        int res = 0, max = array[array.length - 1];
        while (max != 0) {
            res++;
            max /= 10;
        }
        return res;
    }

    /**
     * 获取数字某个进制位上的数字
     */
    private static int getDigit(int x, int d) {
        return ((x / ((int) Math.pow(10, d - 1))) % 10);
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
