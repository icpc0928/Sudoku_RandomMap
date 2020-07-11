package com.gameSudoku;

public class Sudoku {

    public static void main(String[] args){
        SudokuAnsMaker ansMaker = new SudokuAnsMaker();
        SudokuQuestionMaker questionMaker = new SudokuQuestionMaker();
        int[][] answerGrid = ansMaker.makeAnswer();
        int[][] questionGrid = questionMaker.makeQuestion(answerGrid, 40);



        //列印answerGrid結果
        printGrid(answerGrid);
        //列印questionGrid結果
        printGrid(questionGrid);


    }

    private static void printGrid(int[][] grid) {
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
