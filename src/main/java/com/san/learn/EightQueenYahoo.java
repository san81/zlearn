
package com.san.learn;

public class EightQueenYahoo {

    /*
    Eight Queens puzzle

    |--|--|--|--|--|--|--|--|
    |  |  |  |  |  | X|  |  |
    |--|--|--|--|--|--|--|--|
    |  |  | X|  |  |  |  |  |
    |--|--|--|--|--|--|--|--|
    |  |  |  |  | X|  |  |  |
    |--|--|--|--|--|--|--|--|
    |  |  |  |  |  |  |  | X|
    |--|--|--|--|--|--|--|--|
    | X|  |  |  |  |  |  |  |
    |--|--|--|--|--|--|--|--|
    |  |  |  | X|  |  |  |  |
    |--|--|--|--|--|--|--|--|
    |  | X|  |  |  |  |  |  |
    |--|--|--|--|--|--|--|--|
    |  |  |  |  |  |  | X|  |
    |--|--|--|--|--|--|--|--|

    Find one arrangement of eight chess queens on an 8×8 chessboard so that
    no two queens threaten each other.

    */


     int board[8][8] = new int[8][8];
     //cell with even j index are white
     //cell with odd j index are black

    //-1 indicates a q position


    class Find8QPositions {

        
        
        public int[][] findGivenQCountWPositions(int qCount) {
        
            
           
             for(int i=0;i<board.length;i++){
                for(int j=0;j<board.length;j++){
                    if(!isItThreaten(board,i,j)){
                        board[i][j]=-1;
                        counter++;
                        if(qCount>0){
                            findGivenQCountWPositions(qCount-1);
                        }
                    }
                    
                }    
            }        
            
             
        }
        
        public boolea isItThreaten(int[][] board, int i, int j){
            boolean isThreaten=false;
            for( int x=0;x<board.lenght;x++){
                if(board[i][x]==-1){
                    isThreaten=true;
                    return isThreaten;
                }
            }
            
            for( int x=0;x<board[i].lenght;x++){
                if(board[x][j]==-1){
                    isThreaten=true;
                    return isThreaten;
                }
            }
            
            //diagnal line
            int x=i+1;
            int y=j+1;
            while(x<board.length && y<board.length){
                    if(board[x][y]==-1){
                        isThreaten=true;
                        return isThreaten;
                    }
                    x++;
                    y++;
            }
            
            
            x=i-1;
            y=j-1;
            while(x>=0 && y>=0){
                    if(board[x][y]==-1){
                        isThreaten=true;
                        return isThreaten;
                    }
                    x--;
                    y--;
            }
            
            return  isThreaten;
            
        }
        

    }
}
