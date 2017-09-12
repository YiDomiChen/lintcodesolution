/**
 * 
 * @LintCode:
 * @Description: TODO
 * @Difficulty: 
 * @Category: 
 * @Author: Yi Chen
 * @CreatedTime: Sep 1, 2017
 * @LastEditTime: Sep 1, 2017
 *
 */
package chapter7;

public class SortColorsII {
    
    
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        if (k == -1) {
            return;
        }
        if (colors == null || colors.length == 0) {
            return;
        }
        rainbowSort(colors, 0, colors.length - 1, 1, k);
    }
    
    // Time Complexity O(nlogk)
    public void rainbowSort(int[] colors, int left, int right, 
                            int colorFrom, int colorTo) {
        if (colorFrom == colorTo) {
            return;
        }
        if (left >= right) {
            return;
        }
        
        int colorMid = (colorFrom + colorTo) / 2;    // do the color type partition like merge sort 
        int pl = left, pr = right;
        while (pl <= pr) {    // do the color element partition like quick sort
            while (pl <= pr && colors[pl] <= colorMid) {
                pl++;
            }
            while (pl <= pr && colors[pr] > colorMid) {
                pr--;
            }
            if (pl <= pr) {
                int tmp = colors[pl];
                colors[pl] = colors[pr];
                colors[pr] = tmp;
                pl++;
                pr--;
            }
        }
        
        rainbowSort(colors, left, pr, colorFrom, colorMid);
        rainbowSort(colors, pl, right, colorMid + 1, colorTo);
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }

}
