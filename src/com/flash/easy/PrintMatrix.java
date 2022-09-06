package com.flash.easy;

import java.util.Arrays;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 */
public class PrintMatrix {

    /**
     * 按照模拟的方向向前遍历
     * 这样的解法会有问题，例如 最后一行或是一列时，会来回打印
     * 只能不断的解决边界case
     * @param matrix
     * @return
     */
    static int[] solution1(int[][] matrix){
        if(matrix.length == 0 || matrix[0].length == 0){
            return new int[0];
        }
        final int LEFT = 1, TOP = 2, RIGHT = 3, BOTTOM = 4;

        int[] ret = new int[matrix.length * matrix[0].length];
        int index = 0;
        int x = 0, y = 0;
        int left = 0, top = 0, right = matrix[0].length-1, bottom = matrix.length-1;
        int direction = RIGHT;
        // 开始遍历
        while ((left < right || top < bottom)) {
            ret[index++] = matrix[y][x];
            if (y == top && x < right) {
                x++;
                if (direction != RIGHT) {
                    left++;
                }
                direction = RIGHT;
            } else if (x == right && y < bottom) {
                y++;
                if (direction != BOTTOM) {
                    top++;
                }
                direction = BOTTOM;
            } else if (y == bottom && x > left) {
                x--;
                if (direction != LEFT) {
                    right--;
                }
                direction = LEFT;
            } else if (x == left && y > top) {
                y--;
                if (direction != TOP) {
                    bottom--;
                }
                direction = TOP;
            }
        }
        // 将最后一个点录入
        if(ret[ret.length - 1] == 0) {
            ret[ret.length - 1] = matrix[y][x];
        }
        return ret;
    }

    /**
     *  改进@method{solution1} 直接将每个方向的遍历改为for循环
     * @param matrix
     * @return
     */
    static int[] solution(int[][] matrix){
        // 判断输入是否合法
        if(matrix.length == 0 || matrix[0].length == 0){
            return new int[0];
        }
        // 定义结果变量
        int[] ret = new int[matrix.length * matrix[0].length];
        // 开始执行算法
        int index = 0;
        int left = 0, top = 0, right = matrix[0].length-1, bottom = matrix.length-1;
        while (true) {
            for(int i=left;i<=right;i++) ret[index++] = matrix[top][i];
            top++;
            if(top > bottom) break;
            for(int i=top;i<=bottom;i++){
                ret[index++] = matrix[i][right];
            }
            right--;
            if(left > right) break;
            for(int i=right;i>=left;i--){
                ret[index++] = matrix[bottom][i];
            }
            bottom--;
            if(top > bottom) break;
            for(int i=bottom;i>=top;i--){
                ret[index++] = matrix[i][left];
            }
            left++;
            if(left > right) break;
        }
        // 输出结果
        return ret;
    }

    /**
     * 遍历过的数字改为0
     * 耗时较长
     * @param matrix
     * @return
     */
    static int[] solution2(int[][] matrix){
        // 判断输入是否合法
        if(matrix.length == 0 || matrix[0].length == 0){
            return new int[0];
        }
        // 定义结果变量
        int[] ret = new int[matrix.length * matrix[0].length];
        // 开始执行算法
        final int NAF = Integer.MIN_VALUE;
        int index = 0;
        int x = 0, y = 0, ax = 0, ay =0;
        do {
            // 重置变量
            ax = 0;
            ay = 0;
            // 采集数据
            ret[index++] = matrix[y][x];
            matrix[y][x] = NAF;
            //探测方向
            if(x-1 < 0 || matrix[y][x-1] == NAF){
                ax += 1;
            }
            if(y-1 < 0 || matrix[y-1][x] == NAF){
                ay += 1;
            }
            if(x+1 >= matrix[0].length || matrix[y][x+1] == NAF){
                ax -= 1;
            }
            if(y+1 >= matrix.length || matrix[y+1][x] == NAF){
                ay -= 1;
            }
            if(ax == ay){
                x+=ax;
            }else{
                y+=ay;
                if(ax + ay != 0) {
                    x+=ax;
                }
            }
        }while (ax != 0 || ay != 0);
        // 输出结果
        return ret;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(solution(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}})));
        System.out.println(Arrays.toString(solution(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
    }


}
