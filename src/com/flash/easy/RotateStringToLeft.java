package com.flash.easy;


/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 */
public class RotateStringToLeft {

    static String solution(String s, int n) {
        char[] chars = s.toCharArray();
        chars = reverse(chars, 0, n);
        chars = reverse(chars, n, chars.length);
        chars = reverse(chars, 0, chars.length);
        return new String(chars);
    }

    /**
     * 反转数组中的某一序列
     * 范围 [start, end)
     * @param chars
     * @param start
     * @param end
     * @return
     */
    static char[] reverse(char[] chars, int start, int end){
        int addition = end + start;
        int half = addition/2;
        addition--;
        char temp;
        for(int i=start;i<half;i++){
            temp = chars[i];
            chars[i] = chars[addition - i];
            chars[addition - i] = temp;
        }
        return chars;
    }

    public static void main(String[] args) {
        System.out.println(solution("abcdefg", 2));
    }

}
