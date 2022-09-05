package com.flash.easy;

public class ReverseWord {

    static String solution1(String s){
        StringBuilder builder = new StringBuilder(s.length());
        char pre = '~';
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == ' ' && pre == ' '){
                continue;
            }
            builder.append(c);
            pre = c;
        }
        return builder.toString();
    }

    static String solution(String s){
        StringBuilder builder = new StringBuilder(s.length());
        boolean flag = false;
        String[] strs = s.split(" ");
        for(int i=strs.length-1;i>-1;i--){
            if(strs[i].length() != 0){
                if(flag) builder.append(" ");
                builder.append(strs[i]);
                flag = true;
            }
        }
        return builder.toString();
    }

    static String solution2(String s){
        char[] string = new char[s.length()];
        int index = -1;
        char cur;
        for(int i=0;i<s.length();i++){
            cur = s.charAt(i);
            if(cur == ' ' && (index == -1 || string[index] == ' ')){
                continue;
            }
            string[++index] = cur;
        }
        return new String(string);
    }

    public static void main(String[] args) {
        System.out.println(solution("the sky is blue"));
    }

}
