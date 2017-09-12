package basic;

public class QuickSort {
    
    public void sortIntegers(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }
        quickSort(A, 0, A.length - 1);
    }
    
    public void quickSort(int[] A, int start, int end) {
        if (start >= end) {
            return;
        }
        
        int left = start, right = end;
        // 1: pivot should be the value at the middle of the array. 
        int pivot = A[(start + end) / 2];
        // 2: while compare left & right, it should be <= instead of <
        while (left <= right) {
            // 3: while compare A[left/right] with pivot, it should be </>, not <=/>= 
            while (left <= right && A[left] < pivot) {
                left++;
            }
            while (left <= right && A[right] > pivot) {
                right--;
            }
            
            if (left <= right) {
                int tmp = A[left];
                A[left] = A[right];
                A[right] = tmp;
                left++;
                right--;
            }
        }
        
        quickSort(A, start, right);
        quickSort(A, left, end);
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = {3,4,1,2,5};
        QuickSort ms = new QuickSort();
        ms.sortIntegers(nums);
        for (int num : nums) {
            System.out.print(num + ",");
        }
    }

}
