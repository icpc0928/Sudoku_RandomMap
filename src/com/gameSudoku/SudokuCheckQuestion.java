package com.gameSudoku;

public class SudokuCheckQuestion {

    int[] ansList = {1,2,3,4,5,6,7,8,9};

    public int[][] checkQuestion(int[][] questionGrid, int[][] answerGrid){
        int i=0, j=0, k=0;
        boolean isForward = true;
        int[][]     tempAnsGrid = new int [questionGrid.length][questionGrid[0].length];
        boolean[][] isGridEmpty = new boolean[questionGrid.length][questionGrid[0].length];
        for(int a = 0; a < questionGrid.length; a++){
            for(int b = 0; b < questionGrid[0].length; b++){
                tempAnsGrid[a][b] = questionGrid[a][b];             //複製到tempAnsGrid
                isGridEmpty[a][b] = questionGrid[a][b] == 0;        //原來這樣也可以@@ㄏㄏ
            }
        }



        loopI:
        for( ;i < questionGrid.length; )
        {
            loopJ:
            for( ;j < questionGrid[0].length; )
            {
//                System.out.println("debug: "+i + j );
                if(isGridEmpty[i][j])
                {
//                    System.out.println("hi");
                    isForward = true;
                    if(tempAnsGrid[i][j] == 0)
                        k = 0;
                    else if(tempAnsGrid[i][j] == 9)
                    {
                        isForward = false;
                        i = ((j == 0) && (i != 0)) ? (i - 1) : i;
                        j = (j != 0) ? (j - 1) : (i != 0) ? 8 : 0;
                        tempAnsGrid[i][j] = 0;
                        break loopJ;
                    }
                    else
                    {
                        k = tempAnsGrid[i][j];
                        tempAnsGrid[i][j] = 0;
                    }

//                    System.out.println("debuK: " + k);
                    loopK:
                    for (; k < ansList.length; )
                    {
                        if(checkAns(i, j, k, tempAnsGrid))
                        {
                            tempAnsGrid[i][j] = ansList[k];
                            i = (j == 8) ? (i + 1) : i;
                            j = (j == 8) ? 0 : (j + 1);
                            break loopK;
                        }
                        else if(k == 8)     //back
                        {
                            i = (j == 0 && i != 0) ? (i - 1) : i;
                            j = (j != 0) ? (j - 1) : (i != 0) ? 8 : 0;
                            isForward = false;
                            break loopK;
                        }
                        else    //keepGoing
                        {
                            k++;
                        }
                    }
                }
                else if(isForward || (i + j) == 0)
                {
                    isForward = true;
                    i = (j == 8) ? (i + 1) : i;
                    j = (j == 8) ? 0 : (j + 1);
                    break loopJ;
                }
                else if(!isForward)
                {
//                    System.out.println("DEBUG");
                    i = ((j == 0) && (i != 0)) ? (i - 1) : i;
//                    j = ((j == 0) && (i != 0)) ? 8 : (j == 0) && (i == 0) ? 0 : (j - 1);
                    j = (j != 0) ? (j - 1) : (i != 0) ? 8 : 0;
                    break loopJ;
                }
                else
                {
//                    System.out.printf("Debug");
                    break loopI;
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
        System.out.println("DONE!!!!!!!!!");




        return tempAnsGrid;
    }



    //doTheMath Here
    private boolean checkAns(int i, int j, int k, int[][]tempAnsGrid){
        boolean isAnsOK = true;
        //檢查小格 先取得該小格最左上角位置  [(i / 3) * 3][(j / 3) * 3]
        int tempI = (i / 3) * 3;
        int tempJ = (j / 3) * 3;

        for(int x = 0; x < 9; x++){
            //檢查橫向 || 檢查縱向
            if(tempAnsGrid[i][x] == ansList[k] || tempAnsGrid[x][j] == ansList[k]){
                isAnsOK = false;
                break;
            }
            //檢查小格
            if(x < 3){
                for(int z = 0; z < 3; z++)
                {
                    if(tempAnsGrid[tempI + x][tempJ + z] == ansList[k]){
                        isAnsOK = false;
                        break;
                    }
                }
            }
        }
        return isAnsOK;
    }
}
