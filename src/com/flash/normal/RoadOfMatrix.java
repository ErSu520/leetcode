package com.flash.normal;

public class RoadOfMatrix {

    static boolean solution(char[][] board, String word) {
        if(board == null || word == null){
            return false;
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == word.charAt(0)){
                    boolean[][] flags = new boolean[board.length][board[0].length];
                    flags[i][j] = true;
                    int x = i, y = j;
                    int dx = 0, dy=0;
                    int index = 1;
                    while(true){
                        if(index >= word.length()){
                            return true;
                        }
                        // 向左找
                        if(x > 0 && flags[x-1][y] == false && board[x-1][y] == word.charAt(index)){
                            flags[x-1][y] = true;
                            x--;
                            index++;
                            dx = -1;
                        }else if(x < board.length-1 && flags[x+1][y] == false && board[x+1][y] == word.charAt(index)){
                            flags[x+1][y] = true;
                            x++;
                            index++;
                            dx = 1;
                        }else if(y > 0 && flags[x][y-1] == false && board[x][y-1] == word.charAt(index)){
                            flags[x][y-1] = true;
                            y--;
                            index++;
                            dy = -1;
                        }else if(y < board[0].length-1 && flags[x][y+1] == false && board[x][y+1] == word.charAt(index)){
                            flags[x][y+1] = true;
                            y++;
                            index++;
                            dy = 1;
                        }else{
                            x-=dx;
                            y-=dy;
                            if(dx == 0 && dy == 0) {
                                break;
                            }
                            dx = dy = 0;
                        }
                    }
                }
            }
        }
        return false;
    }

    static void advance(){

    }

    public static void main(String[] args) {
        System.out.println(solution(new char[][]{
                {'A', 'B'},
                {'C', 'D'}
       }, "ABCD"));
    }

}
