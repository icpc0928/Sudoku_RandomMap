package com.gameSudoku;

public class SudokuCheckQuestion {

    int[] ansList = {1,2,3,4,5,6,7,8,9};

    public boolean checkQuestion(int[][] questionGrid, int[][] answerGrid){
        int i=0, j=0, k=0;
        int[][]     tempAnsGrid = new int [questionGrid.length][questionGrid[0].length];
        boolean[][] isGridEmpty = new boolean[questionGrid.length][questionGrid[0].length];
        for(int a = 0; a < questionGrid.length; a++){
            for(int b = 0; b < questionGrid[0].length; b++){
                tempAnsGrid[a][b] = questionGrid[a][b];             //複製到tempAnsGrid
                isGridEmpty[a][b] = questionGrid[a][b] == 0;        //原來這樣也可以@@ㄏㄏ
            }
        }



        loopI: for( ;i < questionGrid.length; )
        {
            loopJ: for( ; j < questionGrid[0].length; )
            {
                loopK: for( ; k < ansList.length ;)
                {
                    if(isGridEmpty[i][j]){
                        //dothemath
                        if(checkAns()){
                            //set tempAnsGrid
                            //j++;
                        }
                    }else{
                        if(j == 8){
                            i++;
                            j=0;
                            break loopJ;
                        }else{
                            j++;
                            break loopK;
                        }

                    }
                }
            }
        }

        //--->重來
        //如果k值從0~8都不適配 ->
        //1.  if(j=0)=> i--  j=8(length-1)  else j--     (取得上一個[i][j]
        //2.  k = [i][j]  (如果[i][j] == 9 則再重複1.)     (k為index，正好不用再+1 ，意思就是如果原本[i][j]=1 ，k=1就是從2開始跑迴圈
        //如果k值適配 是否應該繼續判斷其他可能? 還是直接跳出k迴圈j++? (是否需要紀錄甚麼，拿來檢查第二種解法的可能)
        //1.

        //每填完一個數字 i++ or j++

        return false;
    }



    private boolean checkAns(){
        boolean isAnsOK = false;

        return isAnsOK;
    }
}
