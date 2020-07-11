package com.gameSudoku;

import java.util.Arrays;

public class SudokuQuestionMaker {

    public int[][] makeQuestion(int[][] ansGrid, int questions){
        int[][] questionGrid = new int[9][9];
        for(int i = 0; i < questionGrid.length; i++){
            for(int j = 0; j < questionGrid[0].length; j++){
                questionGrid[i][j] = ansGrid[i][j];
            }
        }

        for(int i = 0; i < questions; ){

            int grid1 = (int)(Math.random() * 9);
            int grid2 = (int)(Math.random() * 9);
            if(questionGrid[grid1][grid2] != 0){
                questionGrid[grid1][grid2] = 0;
                i++;
            }
        }

        return questionGrid;
    }


}
