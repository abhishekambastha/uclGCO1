package pieces;

import java.util.Scanner;

/*
 * Nitty gritty details left for now
 * 
 * pawn is allowed to move 2 steps from its home position !
 * pawn can move a diagonal step to kill an opponent
 * 
 * some swapping is allowed between pieces -- check rules castling
 * 
 * validation of which player to move
 * 
 * terminate the game if either of the kings gets killed 
 * 
 * kinghts can jump !!! --- the knight can jump now
 * 
 * 
 * */
public class VirtualChess {

	public static final int numCols = 8;
	public static final int numRows = 8;

	public static int whiteScore = 0;
	public static int blackScore = 0;
	/*
	 * main execution!!
	 */
	public static void main(String... args){
		AbstractPiece[][] chessboard = new AbstractPiece[numCols][numRows];
		//populate ChessBoard
		for(int rows=0; rows<numRows;rows++){
			for(int cols=0; cols<numCols; cols++){
				if(rows==0){
					switch(cols){
					case 0: 
						chessboard[rows][cols] = new rook(true); break;
					case 1:
						chessboard[rows][cols] = new knight(true); break;
					case 2:
						chessboard[rows][cols] = new bishop(true); break;
					case 3:
						chessboard[rows][cols] = new queen(true); break;
					case 4:
						chessboard[rows][cols] = new king(true); break;
					case 5:
						chessboard[rows][cols] = new bishop(true); break;
					case 6:
						chessboard[rows][cols] = new knight(true); break;
					case 7:
						chessboard[rows][cols] = new rook(true); break;
					default:
						break;
					}
				}
				else if(rows==1){
					chessboard[rows][cols] = new pawn(true);
				}
				else if(rows==6){
					chessboard[rows][cols] = new pawn(false);
				}

				else if(rows ==7){
					switch(cols){
					case 0: 
						chessboard[rows][cols] = new rook(false); break;
					case 1:
						chessboard[rows][cols] = new knight(false); break;
					case 2:
						chessboard[rows][cols] = new bishop(false); break;
					case 3:
						chessboard[rows][cols] = new queen(false); break;
					case 4:
						chessboard[rows][cols] = new king(false); break;
					case 5:
						chessboard[rows][cols] = new bishop(false); break;
					case 6:
						chessboard[rows][cols] = new knight(false); break;
					case 7:
						chessboard[rows][cols] = new rook(false); break;
					default:
						break;
					}
				}

				else{
					chessboard[rows][cols] = null;
				}

			}
		}

		printBoard(chessboard);

		Scanner scan = new Scanner(System.in);

		//infinite loop for players
		boolean firstPlayer = true;
		while(true){
			if (firstPlayer){
				System.out.print("\nFirst Player Your Move? :");
				firstPlayer = false;
			}else{
				System.out.print("\nSecond Player Your Move? :");
				firstPlayer = true;
			}
			String move = scan.nextLine();
			if(move.equals("exit")){
				System.out.println("GoodBye !");
				break;
			}
			move(chessboard, move);
			printBoard(chessboard);
			System.out.println("White Score: " + whiteScore);
			System.out.println("Black Score: " + blackScore);
		}
		scan.close();
	}

	/*
	 * print
	 */
	public static void printBoard(AbstractPiece[][] chessboard){

		//print col names
		System.out.print("\t");
		for(int i=0; i<numCols; i++){
			System.out.print((char)('A'+i));
			System.out.print(' ');
			System.out.print("\t");
		}
		System.out.print("\n");

		for(int rows=numRows-1; rows >=0; rows--){
			for(int cols=0; cols<numCols; cols++){
				//print row number
				if(cols==0){
					System.out.print((rows+1) + "\t");
				}

				if(chessboard[rows][cols] != null){
					chessboard[rows][cols].draw();
					System.out.print("\t");
				}else{
					System.out.print("\t");
				}

				//print a new line after col finishes
				if(cols==7){
					System.out.print("\n\n");
				}
			}

		}
	}
	/*
	 * validation step
	 */
	public static boolean isValid(AbstractPiece[][] chessboard, int srcCol, int srcRow, int destCol, int destRow){

		boolean isPattern = chessboard[srcRow][srcCol].isMoveValid(srcRow, srcCol, destRow, destCol);

		boolean isPathClear = true;
		isPathClear &= checkVerticalPath(chessboard, srcCol, srcRow, destCol, destRow);
		isPathClear &= checkHorizontalPath(chessboard, srcCol, srcRow, destCol, destRow);
		isPathClear &= checkDiagonalPath(chessboard, srcCol, srcRow, destCol, destRow);

		boolean[] destinationCheck = {true, false};
		destinationCheck = checkDestination(chessboard, srcCol, srcRow, destCol, destRow);

		boolean isDestinationClear = destinationCheck[0];
		boolean opponentAtDest = destinationCheck[1];

		if(!isDestinationClear){
			isDestinationClear = (opponentAtDest)? true: false;
		}

		if(opponentAtDest){
			//increase Score
			if(chessboard[srcRow][srcCol].isWhite()){
				whiteScore+= chessboard[destRow][destCol].relativeValue();
			}else{
				blackScore+= chessboard[destRow][destCol].relativeValue();
			}
		}

		//handle pawn exceptional case here for diagonal movement.
		return isPattern&isPathClear&isDestinationClear;	
	}

	public static boolean checkVerticalPath(AbstractPiece[][] chessboard, int srcCol, int srcRow, int destCol, int destRow){

		if((destCol - srcCol)!=0 || (chessboard[srcRow][srcCol] instanceof knight)){
			return true;  // movement is not vertical
		}
		boolean isPathClear = true;
		int sign = (int)Math.signum(destRow - srcRow); 
		int row = srcRow;

		if(sign>0){							//vertical case +
			while(isPathClear && row<(destRow-1)){
				isPathClear = (chessboard[++row][srcCol] == null);
			}
		}else if(sign<0){					//vertical case -
			while(isPathClear && row>(destRow+1)){
				isPathClear = (chessboard[--row][srcCol] == null);
			}
		}
		return isPathClear;
	}

	public static boolean checkHorizontalPath(AbstractPiece[][] chessboard, int srcCol, int srcRow, int destCol, int destRow){

		if((destRow - srcRow)!=0|| (chessboard[srcRow][srcCol] instanceof knight)){
			return true;  // movement is not horizontal
		}
		boolean isPathClear = true;
		int sign = (int)Math.signum(destCol - srcCol); 
		int col = srcCol;
		if(sign>0){							//move to right +
			while(isPathClear && col<(destCol-1)){
				isPathClear = (chessboard[srcRow][++col] == null);
			}
		}else if(sign<0){					//move to left -
			while(isPathClear && col>(destCol+1)){
				isPathClear = (chessboard[srcRow][--col] == null);
			}
		}
		return isPathClear;
	}

	public static boolean checkDiagonalPath(AbstractPiece[][] chessboard, int srcCol, int srcRow, int destCol, int destRow){
		//deal with 4 cases

		if(Math.abs(destCol - srcCol)!=Math.abs(destRow-srcRow)|| (chessboard[srcRow][srcCol] instanceof knight)){
			return true;  // movement is not diagonal
		}
		int horizontal = (int)Math.signum(destCol - srcCol);
		int vertical = (int)Math.signum(destRow - srcRow);

		boolean isPathClear = true;

		int row = srcRow;
		int col = srcCol;

		if(horizontal>0 & vertical>0){
			while(isPathClear && (row<(destRow-1) && col<(destCol-1))){
				isPathClear = (chessboard[++row][++col] == null);
			}// ++ case
		}

		if(horizontal>0 & vertical<0){
			while(isPathClear && (row<(destRow+1) && col>(destCol-1))){
				isPathClear = (chessboard[--row][++col] == null);
			}
		}		// +-

		if(horizontal<0 & vertical<0){
			while(isPathClear && (row>(destRow+1) && col>(destCol+1))  ){
				isPathClear = (chessboard[--row][--col] == null);
			}	//--

		}
		if(horizontal<0 & vertical>0){
			while(isPathClear && (row>(destRow-1) && col<(destCol+1))  ){
				isPathClear = (chessboard[++row][--col] == null);			}
		}	//-+
		return isPathClear;
	}

	public static void move(AbstractPiece[][] chessboard, String move){

		int srcRow = 0;
		int destRow = 0;

		int srcCol =0;
		int destCol=0;

		String[] components = move.split(" ");

		srcCol = (components[0].charAt(0) - 'a');
		destCol = (components[2].charAt(0) - 'a');

		srcRow = (components[0].charAt(1) - '1');
		destRow = (components[2].charAt(1) - '1');

		boolean validMove = isValid(chessboard, srcCol, srcRow, destCol, destRow);
		System.out.println(validMove);

		if(validMove){
			chessboard[destRow][destCol] = chessboard[srcRow][srcCol];
			chessboard[srcRow][srcCol] = null;
		}
	}
	/*
	 * destination!!!
	 */
	public static boolean[] checkDestination(AbstractPiece[][] chessboard, int srcCol, int srcRow, int destCol, int destRow){
		boolean[] destCheck = new boolean[2];
		destCheck[0] = true;	//for obstruction at destination
		destCheck[1] = false;   //for opponent

		destCheck[0] = (chessboard[destRow][destCol]==null);

		//check for opponent if destination occupied, XOR for isWhite
		if(!destCheck[0]){
			destCheck[1] = (chessboard[srcRow][srcCol].isWhite()) ^ (chessboard[destRow][destCol].isWhite());
		}
		return destCheck;
	}
}
