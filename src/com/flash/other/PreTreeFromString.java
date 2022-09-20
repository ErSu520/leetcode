package com.flash.other;


/**
 *  树型结构存储方式为 1(2(3,4(,5)),6(7,))
 *  求其中序遍历结果
 */
public class PreTreeFromString {

    static void solution(char[] tree, int start, int end){
        if(start > end){
            return;
        }
        if(start == end){
            if(tree[start] > '0' && tree[start] <= '9') {
                System.out.print(tree[start]);
            }
            return;
        }
        int middle = middle(tree, start+1, end);
        int diff = tree[end] == ')' ? 1 : 0;
        solution(tree, start+1+diff, middle);
        System.out.print(tree[start]);
        solution(tree, middle+2, end-diff);
    }

    static int middle(char[] tree, int start, int end){
        if(start == end){
            return start;
        }
        int middle = start, preSign = -1;
        for(int i=start;i<end;i++){
            if(tree[i] == '('){
                preSign ++;
            } else if (tree[i] == ')') {
                preSign --;
            }else if (tree[i] == ',' && preSign == 0) {
                middle = i-1;
                break;
            }
        }
        return middle;
    }

    public static void main(String[] args) {
        String string = "1(2(3,4(,5)),6(7,))";
        solution(string.toCharArray(), 0, string.length()-1);
    }

}
