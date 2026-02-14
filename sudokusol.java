public class sudokusol {

    public static boolean issafe( int row , int col ,char [][] board , int numb ){
        for( int i = 0 ; i<board.length ; i++){
            if(board[row][i] == (char)(numb +'0')){
                return false;
            }
            if(board[i][col] == (char)(numb + '0')){
                return false;
            }
        }

        int nr = (row/3)*3;
        int nc = (col/3)*3;

        for( int i = nr ; i<nr+3 ; i++){
            for ( int j = nc ; j<nc+3 ; j++){
                if ( board[i][j] == (char)(numb + '0') ){
                    return false;
                }
            }
        }

        return true;

    }

    public static void printBoard(char [] [] board){
        for ( int i = 0 ; i<9 ; i++){
            for( int j = 0 ; j< 9 ; j++){
                System.out.print(board [i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static boolean helper( int row , int col , char [][] board ) {

        // base case 
        if ( row == board.length ){
            return true;
        }

        int nrow =0;
        int ncol =0;

        if ( col == board.length-1){
            nrow = row +1;
            ncol = 0;
        } else{
            nrow = row;
            ncol = col + 1;

        }

        if ( board[row][col] == '.'){
            for ( int i = 1 ; i<=9 ; i++){
                if (issafe(  row , col ,board , i )){
                    board[row][col] = (char)( i+ '0');
                    if(helper( nrow , ncol , board )){
                        return true;
                    }else{
                        board[row][col] ='.';
                    }


                }
            }
            
        } else {
            if (helper( nrow ,ncol,  board )){
                return true;
            }

        }
        return false;
     }
        public static void main(String args[]){
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
       if ( helper(0 , 0 , board)){
         printBoard(board);
        
       } else{
        System.out.println("No solution exist .");
       }
    }
}
