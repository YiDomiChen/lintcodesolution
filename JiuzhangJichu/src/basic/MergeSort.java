package basic;

public class MergeSort {
    
    public void sortIntegers(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }
        int[] tmp = new int[A.length];
        mergeSort(A, 0, A.length - 1, tmp);
        
    }
    
    public void mergeSort(int[] A, int start, int end, int[] tmp) {
        if (start >= end) {
            return;
        }
        
        mergeSort(A, start, (start + end) / 2, tmp);
        mergeSort(A, (start + end) / 2 + 1, end, tmp);
        merge(A, start, (start + end) / 2, end, tmp);
    }
    
    public void merge(int[] A, int start, int mid, int end, int[] tmp) {
        int leftIndex = start;
        int rightIndex = mid + 1;
        int index = start;
        while (leftIndex <= mid && rightIndex <= end) {
            if (A[leftIndex] < A[rightIndex]) {
                tmp[index++] = A[leftIndex];
                leftIndex++;
            } else {
                tmp[index++] = A[rightIndex];
                rightIndex++;
            }
        }
        
        while (leftIndex <= mid) {
            tmp[index++] = A[leftIndex++];
        }
        while (rightIndex <= end) {
            tmp[index++] = A[rightIndex++];
            
        }
        
        for (int i = start; i <= end; i++) {
            A[i] = tmp[i];
        }
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = {2,6,1,8,9,20,1,7,4,3};
        MergeSort ms = new MergeSort();
        ms.sortIntegers(nums);
        for (int num : nums) {
            System.out.print(num + ",");
        }
    }

}
