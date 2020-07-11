package com.gameSudoku;

import java.util.Arrays;

public class SudokuAnsMaker {

    int[][] grid =
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
    int limit_times = 100;

    public int[][] makeAnswer(){

        int limit_x = 0;
        for(int line = 0; line < 9 ; line++) {
            System.out.println("---------------"+line+"----------------");
            inLine: for (int inline = 0; inline < grid[line].length; inline++) {              //第一列的內文
                int temp;
                int limit_line = 0;
                do {
                    temp = (int) (Math.random() * 9) + 1;
                    boolean isColSame = false;
                    boolean isRowSame = false;
                    boolean isGridSame = false;
                    for (int col = 0; col <= inline; col++) {
                        if (temp == grid[line][col]) {
                            isColSame = true;
                            break;
                        }
                    }
                    for (int row = 0; row < grid.length; row++) {
                        if (temp == grid[row][inline] && row != line) {
                            isRowSame = true;  //可能會遇到自己
                            break;
                        }
                    }
                    int[] littleGrid = {line / 3, inline / 3};
                    for (int i = 0; i < 3; i++) {
                        if (temp == grid[littleGrid[0] * 3    ][i + littleGrid[1] * 3] ) isGridSame = true;   //要避免遇到自己
                        if (temp == grid[littleGrid[0] * 3 + 1][i + littleGrid[1] * 3] ) isGridSame = true;   //要避免遇到自己
                        if (temp == grid[littleGrid[0] * 3 + 2][i + littleGrid[1] * 3] ) isGridSame = true;   //要避免遇到自己
                    }
                    if(!isColSame && !isGridSame && !isRowSame){
                        grid[line][inline] = temp;
                    }
                    limit_line++;
                } while (grid[line][inline] == 0 && limit_line < limit_times );

                if(limit_line == limit_times){      //重製_1  重算該行
                    for(int i = 0; i < 9; i++){     //清空該行
                        grid[line][i] = 0;
                    }
                    line--;
                    limit_x++;

                    break inLine;
                }
                if(limit_x == limit_times ){                  //重製_2 表格重算
                    line = -1;
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

//        //列印結果
//        for(int i = 0; i < 9; i++){
//            if(i % 3 == 0)System.out.println(" -------------------------");
//            for(int j = 0; j < 9; j++){
//                if(j % 3 == 0){
//                    System.out.print(" | " + grid[i][j]);
//                }else{
//                    System.out.print(" " + grid[i][j]);
//                }
//                if(j == 8)System.out.print(" |");
//            }
//            System.out.println();
//        }
//        System.out.println(" -------------------------");

        return grid;
    }
}
