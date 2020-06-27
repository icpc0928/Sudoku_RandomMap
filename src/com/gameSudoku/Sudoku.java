package com.gameSudoku;

import java.util.Arrays;

public class Sudoku {

    static int[][] grid =
    {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, },
            {0, 0, 0, 0, 0, 0, 0, 0, 0, },
            {0, 0, 0, 0, 0, 0, 0, 0, 0, },
            {0, 0, 0, 0, 0, 0, 0, 0, 0, },
            {0, 0, 0, 0, 0, 0, 0, 0, 0, },
            {0, 0, 0, 0, 0, 0, 0, 0, 0, },
            {0, 0, 0, 0, 0, 0, 0, 0, 0, },
            {0, 0, 0, 0, 0, 0, 0, 0, 0, },
            {0, 0, 0, 0, 0, 0, 0, 0, 0, },
    };
    static int limit_times = 10000;



    public static void main(String[] arg){

        int limit_x = 0;
        for(int x = 0; x < 9 ; x++) {
            System.out.println("---------------"+x+"----------------");
            inLine: for (int line = 0; line < grid[x].length; line++) {              //第一列的內文
                int temp;
                int limit_line = 0;
                do {
                    temp = (int) (Math.random() * 9) + 1;
                    boolean isColSame = false;
                    boolean isRowSame = false;
                    boolean isGridSame = false;
                    for (int col = 0; col <= line; col++) {
                        if (temp == grid[x][col]) {
                            isColSame = true;
                            break;
                        }
                    }
                    for (int row = 0; row < grid.length; row++) {
                        if (temp == grid[row][line] && row != x) {
                            isRowSame = true;  //可能會遇到自己
                            break;
                        }
                    }
                    int[] littleGrid = {x / 3, line / 3};
                    for (int i = 0; i < 3; i++) {
                        if (temp == grid[littleGrid[0] * 3    ][i + littleGrid[1] * 3] ) isGridSame = true;   //要避免遇到自己
                        if (temp == grid[littleGrid[0] * 3 + 1][i + littleGrid[1] * 3] ) isGridSame = true;   //要避免遇到自己
                        if (temp == grid[littleGrid[0] * 3 + 2][i + littleGrid[1] * 3] ) isGridSame = true;   //要避免遇到自己
                    }
                    if(!isColSame && !isGridSame && !isRowSame){
                        grid[x][line] = temp;
                    }
                    limit_line++;
                } while (grid[x][line] == 0 && limit_line < limit_times );

                if(limit_line == limit_times){      //極限重製_1  重算該行
                    for(int i = 0; i < 9; i++){     //清空該行
                        grid[x][i] = 0;
                    }
                    x--;
                    limit_x++;

                    break inLine;
                }
                if(limit_x == 10 ){                  //極限重製_2 表格重算
                    x = -1;
                    limit_x = 0;
                    for(int i = 0; i < 9; i++){     //清空所有數據
                        for(int j = 0; j < 9; j++){
                            grid[i][j] = 0;
                        }
                    }
                    break;
                }
            }
        }

        //列印結果
        for(int i = 0; i < 9; i++){
            if(i % 3 == 0)System.out.println(" -------------------------");
            for(int j = 0; j < 9; j++){
                if(j % 3 == 0){
                    System.out.print(" | " + grid[i][j]);
                }else{
                    System.out.print(" " + grid[i][j]);
                }
                if(j == 8)System.out.print(" |");
            }
            System.out.println();
        }
        System.out.println(" -------------------------");
    }
}
