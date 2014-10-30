package tutorialTwo;
import java.io.IOException;
import java.util.Scanner;


//implement validPlayer & handle nailed It case
//implement input Validation !


public class VirtualChess {
	public enum Chessmen{
		WHITE_KING,
		WHITE_QUEEN,
		WHITE_ROOK,
		WHITE_KNIGHT,
		WHITE_BISHOP,
		WHITE_PAWN,
		BLACK_KING,
		BLACK_QUEEN,
		BLACK_ROOK,
		BLACK_KNIGHT,
		BLACK_BISHOP,
		BLACK_PAWN,
		EMPTY
	}

	public static void main(String args[]) throws
	IOException{

		Chessmen[][] chessboard= new Chessmen[8][8];	//[rows][cols]

		//populate ChessBoard
		for(int rows=0; rows<8;rows++){
			for(int cols=0; cols<8; cols++){
				if(rows==0){
					switch(cols){
					case 0: 
						chessboard[rows][cols] = Chessmen.WHITE_ROOK; break;
					case 1:
						chessboard[rows][cols] = Chessmen.WHITE_KNIGHT; break;
					case 2:
						chessboard[rows][cols] = Chessmen.WHITE_BISHOP; break;
					case 3:
						chessboard[rows][cols] = Chessmen.WHITE_QUEEN; break;
					case 4:
						chessboard[rows][cols] = Chessmen.WHITE_KING; break;
					case 5:
						chessboard[rows][cols] = Chessmen.WHITE_BISHOP; break;
					case 6:
						chessboard[rows][cols] = Chessmen.WHITE_KNIGHT; break;
					case 7:
						chessboard[rows][cols] = Chessmen.WHITE_ROOK; break;
					default:
						break;
					}
				}
				else if(rows==1){
					chessboard[rows][cols] = Chessmen.WHITE_PAWN;
				}
				else if(rows==6){
					chessboard[rows][cols] = Chessmen.BLACK_PAWN;
				}

				else if(rows ==7){
					switch(cols){
					case 0: 
						chessboard[rows][cols] = Chessmen.BLACK_ROOK; break;
					case 1:
						chessboard[rows][cols] = Chessmen.BLACK_KNIGHT; break;
					case 2:
						chessboard[rows][cols] = Chessmen.BLACK_BISHOP; break;
					case 3:
						chessboard[rows][cols] = Chessmen.BLACK_QUEEN; break;
					case 4:
						chessboard[rows][cols] = Chessmen.BLACK_KING; break;
					case 5:
						chessboard[rows][cols] = Chessmen.BLACK_BISHOP; break;
					case 6:
						chessboard[rows][cols] = Chessmen.BLACK_KNIGHT; break;
					case 7:
						chessboard[rows][cols] = Chessmen.BLACK_ROOK; break;
					default:
						break;
					}
				}

				else{
					chessboard[rows][cols] = Chessmen.EMPTY;
				}

			}

		}

		printBoard(chessboard);
		@SuppressWarnings("resource")
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

			//Runtime.getRuntime().exec("clear");  //for POSIX
			printBoard(chessboard);
		}
		//scan.close();
	}

	public static void printBoard(Chessmen[][] chessboard){


		//print col names
		
		System.out.print("\t");
		for(int i=0; i<8; i++){
			System.out.print((char)('A'+i));
			System.out.print(' ');
			System.out.print("\t");
		}
		System.out.print("\n");

		for(int rows=7; rows >=0; rows--){
			for(int cols=0; cols<8; cols++){
				//print row number
				if(cols==0){
					System.out.print((rows+1) + "\t");
				}

				switch(chessboard[rows][cols]){
				case WHITE_KING: System.out.print("\u2654\t");break;
				case WHITE_QUEEN: System.out.print("\u2655\t");break;
				case WHITE_KNIGHT: System.out.print("\u2658\t");break;
				case WHITE_BISHOP: System.out.print("\u2657\t");break;
				case WHITE_ROOK: System.out.print("\u2656\t");break;
				case WHITE_PAWN: System.out.print("\u2659\t");break;
				case BLACK_KING: System.out.print("\u265A\t");break;
				case BLACK_QUEEN: System.out.print("\u265B\t");break;
				case BLACK_KNIGHT: System.out.print("\u265E\t");break;
				case BLACK_BISHOP: System.out.print("\u265D\t");break;
				case BLACK_ROOK: System.out.print("\u265C\t");break;
				case BLACK_PAWN: System.out.print("\u265F\t");break;
				case EMPTY: System.out.print("  \t");break;
				}

				//print a new line after col finishes
				if(cols==7){
					System.out.print("\n\n");
				}
			}
		}
	}

	public static void move(Chessmen[][] chessboard, String move){

		int oldRow = 0;
		int newRow = 0;

		int oldCol =0;
		int newCol=0;

		String[] components = move.split(" ");

		oldCol = (components[0].charAt(0) - 'a');
		newCol = (components[2].charAt(0) - 'a');

		oldRow = (components[0].charAt(1) - '1');
		newRow = (components[2].charAt(1) - '1');

		//System.out.println("You Move ("+ oldRow + "," + oldCol + ") to (" + newRow +"," + newCol +")" );

		boolean truth = isValid(chessboard, oldRow, oldCol, newRow, newCol);
		System.out.println(truth);
		if(truth){
			chessboard[newRow][newCol] = chessboard[oldRow][oldCol];
			chessboard[oldRow][oldCol] = Chessmen.EMPTY;
		}


	}

	public static boolean isValid(Chessmen[][] chessboard, int oldJ, int oldI, int newJ, int newI){
		// i is col , j is row
		boolean movePattern = false; //checks for the movement pattern of pieces
		boolean isPathClear = false; // checks if path is clear 
		boolean isDestinationClear = false;


		//check movement pattern 
		switch(chessboard[oldJ][oldI]){
		case WHITE_PAWN:									//can move only one step ahead
			if(((newI - oldI)==0) && (newJ-oldJ == 1)){
				movePattern = true;
			}else{
				movePattern = false;
			}
			break;
		case WHITE_ROOK: 									//can move horizontally or vertically
			if(((newI - oldI)==0) || ((newJ - oldJ)==0)){
				movePattern = true;
			}else{
				movePattern = false;
			}
			break;
		case WHITE_KNIGHT:									//moves in L shape
			if((Math.abs(newI-oldI)==2)&& (Math.abs(newJ-oldJ)==1) || (Math.abs(newI-oldI)==1)&& (Math.abs(newJ-oldJ)==2)){
				movePattern = true;
			}else{
				movePattern = false;
			}
			break;
		case WHITE_BISHOP:									//no of steps in x = no. of steps in y
			if(Math.abs(newI - oldI) == Math.abs(newJ - oldJ)){
				movePattern = true;
			}else{
				movePattern = false;
			}
			break;
		case WHITE_KING:									//no of steps in x & y is atmost 1
			if((Math.abs(newI - oldI)<2) && (Math.abs(newJ - oldJ)<2)  ){
				movePattern = true;
			}else{
				movePattern = false;
			}
			break;
		case WHITE_QUEEN: 
			if(Math.abs(newI - oldI) == Math.abs(newJ - oldJ)){
				movePattern = true;
			}else if(((newI - oldI)==0) || ((newJ - oldJ)==0)){
				movePattern = true;
			}else{
				movePattern = false;
			}
			break;
		case BLACK_PAWN:
			if(((newI - oldI)==0) && (oldJ-newJ == 1)){
				movePattern = true;
			}else{
				movePattern = false;
			}
			break;
		case BLACK_ROOK: 
			if(((newI - oldI)==0) || ((newJ - oldJ)==0)){
				movePattern = true;
			}else{
				movePattern = false;
			}
			break;
		case BLACK_KNIGHT: 
			if((Math.abs(newI-oldI)==2)&& (Math.abs(newJ-oldJ)==1) || (Math.abs(newI-oldI)==1)&& (Math.abs(newJ-oldJ)==2)){
				movePattern = true;
			}else{
				movePattern = false;
			}
			break;
		case BLACK_BISHOP: 
			if(Math.abs(newI - oldI) == Math.abs(newJ - oldJ)){
				movePattern = true;
			}else{
				movePattern = false;
			}
			break;
		case BLACK_KING: 
			if((Math.abs(newI - oldI)<2) && (Math.abs(newJ - oldJ)<2)  ){
				movePattern = true;
			}else{
				movePattern = false;
			}
			break;
		case BLACK_QUEEN: 
			if(Math.abs(newI - oldI) == Math.abs(newJ - oldJ)){
				movePattern = true;
			}else if(((newI - oldI)==0) || ((newJ - oldJ)==0)){
				movePattern = true;
			}else{
				movePattern = false;
			}
			break;
		case EMPTY: 
			movePattern = false;
			break;

		}


		//switch case for checking path
		switch(chessboard[oldJ][oldI]){
		case WHITE_PAWN: 
			if(chessboard[newJ][newI] == Chessmen.EMPTY){
				isPathClear = true; 
			}else{
				isPathClear=false;
			}
			break;
		case WHITE_ROOK: 
			if((Math.abs(newI - oldI) == 0)){   //vertical case
				boolean truth = true;
				int sign = (int)Math.signum(newJ - oldJ);
				int j = oldJ;
				if(sign>0){
					while(truth && j<(newJ-1)){
						if(chessboard[++j][oldI] == Chessmen.EMPTY){
							truth = true;
						} else{
							truth = false;
							break;
						}
					}
				}else if(sign<0){
					while(truth && j>(newJ+1)){
						if(chessboard[--j][oldI] == Chessmen.EMPTY){
							truth = true;
						} else{
							truth = false;
							break;
						}
					}
				}
				isPathClear = truth;
			} else if((Math.abs(newJ - oldJ) == 0)){   //horizontal case
				boolean truth = true;
				int sign = (int)Math.signum(newI - oldI);
				int i = oldI;
				if(sign>0){
					while(truth && i<(newI-1)){
						if(chessboard[oldJ][++i] == Chessmen.EMPTY){
							truth = true;
						} else{
							truth = false;
							break;
						}
					}
				}else if(sign<0){
					while(truth && i>(newI+1)){
						if(chessboard[oldJ][--i] == Chessmen.EMPTY){
							truth = true;
						} else{
							truth = false;	
						}
					}
				}
				isPathClear = truth;
			}
			break;
		case WHITE_KNIGHT : 
			isPathClear = true; //trival case as Pawn
			break;

		case WHITE_BISHOP:
			int horizontal = (int)Math.signum(newI - oldI);
			int vertical = (int)Math.signum(newJ - oldJ);
			boolean truth = true;
			int i = oldI;
			int j = oldJ;
			if(horizontal>0 && vertical>0){
				while(truth && (i<(newI-1) && j<(newJ-1))  ){
					if(chessboard[++j][++i] == Chessmen.EMPTY){
						truth = true;

					}else{
						truth = false;
						break;
					}
				}// ++ case
			}
			if(horizontal>0 && vertical<0){
				while(truth && (i<(newI-1) && j>(newJ+1))  ){
					if(chessboard[--j][++i] == Chessmen.EMPTY){
						truth = true;

					}else{
						truth = false;
						break;
					}
				}
			}
			if(horizontal<0 && vertical<0){
				while(truth && (i>(newI+1) && j>(newJ+1))  ){
					if(chessboard[--j][--i] == Chessmen.EMPTY){
						truth = true;

					}else{
						truth = false;
						break;
					}
				}

			}
			if(horizontal<0 && vertical>0){
				while(truth && (i>(newI+1) && j<(newJ-1))  ){
					if(chessboard[++j][--i] == Chessmen.EMPTY){
						truth = true;

					}else{
						truth = false;
						break;
					}
				}
			}
			isPathClear = truth;

			break;
		case WHITE_QUEEN :
			if((newI-oldI)==0 || (newJ-oldJ)==0){
				//rook's code
				if((Math.abs(newI - oldI) == 0)){   //vertical case
					boolean truth1 = true;
					int sign = (int)Math.signum(newJ - oldJ);
					int j1 = oldJ;
					if(sign>0){
						while(truth1 && j1<(newJ-1)){
							if(chessboard[++j1][oldI] == Chessmen.EMPTY){
								truth1 = true;
							} else{
								truth1 = false;
							}
						}
					}else if(sign<0){
						while(truth1 && j1>(newJ+1)){
							if(chessboard[--j1][oldI] == Chessmen.EMPTY){
								truth1 = true;
							} else{
								truth1 = false;
							}
						}
					}
					isPathClear = truth1;
				} else if((Math.abs(newJ - oldJ) == 0)){   //horizontal case
					boolean truth1 = true;
					int sign = (int)Math.signum(newI - oldI);
					int i1 = oldI;
					if(sign>0){
						while(truth1 && i1<(newI-1)){
							if(chessboard[oldJ][++i1] == Chessmen.EMPTY){
								truth1 = true;
							} else{
								truth1 = false;
							}
						}
					}else if(sign<0){
						while(truth1 && i1>(newI+1)){
							if(chessboard[oldJ][--i1] == Chessmen.EMPTY){
								truth1 = true;
							} else{
								truth1 = false;
							}
						}
					}
					isPathClear = truth1;
				}				
			} else{
				//bishop's code
				int horizontal1 = (int)Math.signum(newI - oldI);
				int vertical1 = (int)Math.signum(newJ - oldJ);
				boolean truth1 = true;
				int i1 = oldI;
				int j1 = oldJ;
				if(horizontal1>0 && vertical1>0){
					while(truth1 && (i1<(newI-1) && j1<(newJ-1))  ){
						if(chessboard[++j1][++i1] == Chessmen.EMPTY){
							truth1 = true;

						}else{
							truth1 = false;
							break;
						}
					}// ++ case
				}
				if(horizontal1>0 && vertical1<0){
					while(truth1 && (i1<(newI-1) && j1>(newJ+1))  ){
						if(chessboard[--j1][++i1] == Chessmen.EMPTY){
							truth1 = true;

						}else{
							truth1 = false;
							break;
						}
					}
				}
				if(horizontal1<0 && vertical1<0){
					while(truth1 && (i1>(newI+1) && j1>(newJ+1))  ){
						if(chessboard[--j1][--i1] == Chessmen.EMPTY){
							truth1 = true;

						}else{
							truth1 = false;
							break;
						}
					}

				}
				if(horizontal1<0 && vertical1>0){
					while(truth1 && (i1>(newI+1) && j1<(newJ-1))  ){
						if(chessboard[++j1][--i1] == Chessmen.EMPTY){
							truth1 = true;

						}else{
							truth1 = false;
							break;
						}
					}
				}
				isPathClear = truth1;

				break;

			}

			break;
		case WHITE_KING: 
			isPathClear = true;
			break;
		case BLACK_PAWN: 
			if(chessboard[newJ][newI] == Chessmen.EMPTY){
				isPathClear = true; 
			}else{
				isPathClear=false;
			}
			break;
		case BLACK_ROOK: 
			if((Math.abs(newI - oldI) == 0)){   //vertical case
				boolean truth1 = true;
				int sign = (int)Math.signum(newJ - oldJ);
				int j1 = oldJ+ sign;
				if(sign>0){
					while(truth1 && j1<newJ){
						if(chessboard[j1++][oldI] == Chessmen.EMPTY){
							truth1 = true;
						} else{
							truth1 = false;
						}
					}
				}else if(sign<0){
					while(truth1 && j1>newJ){
						if(chessboard[j1--][oldI] == Chessmen.EMPTY){
							truth1 = true;
						} else{
							truth1 = false;
						}
					}
				}
				isPathClear = truth1;
			} else if((Math.abs(newJ - oldJ) == 0)){   //horizontal case
				boolean truth1 = true;
				int sign = (int)Math.signum(newI - oldI);
				int i1 = oldI+sign;
				if(sign>0){
					while(truth1 && i1<newI){
						if(chessboard[oldJ][i1++] == Chessmen.EMPTY){
							truth1 = true;
						} else{
							truth1 = false;
						}
					}
				}else if(sign<0){
					while(truth1 && i1>newI){
						if(chessboard[oldJ][i1--] == Chessmen.EMPTY){
							truth1 = true;
						} else{
							truth1 = false;
						}
					}
				}
				isPathClear = truth1;
			}

			break;
		case BLACK_KNIGHT : 
			isPathClear = true;
			break;
		case BLACK_BISHOP: 
			int horizontal1 = (int)Math.signum(newI - oldI);
			int vertical1 = (int)Math.signum(newJ - oldJ);
			boolean truth1 = true;
			int i1 = oldI + horizontal1;
			int j1 = oldJ + vertical1;
			if(horizontal1>0 && vertical1>0){
				while(truth1 && (i1<newI && j1<newJ)  ){
					if(chessboard[j1++][i1++] == Chessmen.EMPTY){
						truth1 = true;

					}else{
						truth1 = false;
						break;
					}
				}// ++ case
			}
			if(horizontal1>0 && vertical1<0){
				while(truth1 && (i1<newI && j1>newJ)  ){
					if(chessboard[j1--][i1++] == Chessmen.EMPTY){
						truth1 = true;

					}else{
						truth1 = false;
						break;
					}
				}
			}
			if(horizontal1<0 && vertical1<0){
				while(truth1 && (i1>newI && j1>newJ)  ){
					if(chessboard[j1--][i1--] == Chessmen.EMPTY){
						truth1 = true;

					}else{
						truth1 = false;
						break;
					}
				}

			}
			if(horizontal1<0 && vertical1>0){
				while(truth1 && (i1>newI && j1<newJ)  ){
					if(chessboard[j1++][i1--] == Chessmen.EMPTY){
						truth1 = true;

					}else{
						truth1 = false;
						break;
					}
				}
			}
			isPathClear = truth1;


			break;
		case BLACK_QUEEN : 
			if((newI-oldI)==0 || (newJ-oldJ)==0){
				//rook's code
				if((Math.abs(newI - oldI) == 0)){   //vertical case
					boolean truth11 = true;
					int sign = (int)Math.signum(newJ - oldJ);
					int j11 = oldJ + sign;
					if(sign>0){
						while(truth11 && j11<newJ){
							if(chessboard[j11++][oldI] == Chessmen.EMPTY){
								truth11 = true;
							} else{
								truth11 = false;
							}
						}
					}else if(sign<0){
						while(truth11 && j11>newJ){
							if(chessboard[j11--][oldI] == Chessmen.EMPTY){
								truth11 = true;
							} else{
								truth11 = false;
							}
						}
					}
					isPathClear = truth11;
				} else if((Math.abs(newJ - oldJ) == 0)){   //horizontal case
					boolean truth11 = true;
					int sign = (int)Math.signum(newI - oldI);
					int i11 = oldI + sign;
					if(sign>0){
						while(truth11 && i11<newI){
							if(chessboard[oldJ][i11++] == Chessmen.EMPTY){
								truth11 = true;
							} else{
								truth11 = false;
							}
						}
					}else if(sign<0){
						while(truth11 && i11>newI){
							if(chessboard[oldJ][i11--] == Chessmen.EMPTY){
								truth11 = true;
							} else{
								truth11 = false;
							}
						}
					}
					isPathClear = truth11;
				}				
			} else{
				//bishop's code
				int horizontal11 = (int)Math.signum(newI - oldI);
				int vertical11 = (int)Math.signum(newJ - oldJ);
				boolean truth11 = true;
				int i11 = oldI + horizontal11;
				int j11 = oldJ + vertical11;
				if(horizontal11>0 && vertical11>0){
					while(truth11 && (i11<newI && j11<newJ)  ){
						if(chessboard[j11++][i11++] == Chessmen.EMPTY){
							truth11 = true;

						}else{
							truth11 = false;
							break;
						}
					}// ++ case
				}
				if(horizontal11>0 && vertical11<0){
					while(truth11 && (i11<newI && j11>newJ)  ){
						if(chessboard[j11--][i11++] == Chessmen.EMPTY){
							truth11 = true;

						}else{
							truth11 = false;
							break;
						}
					}
				}
				if(horizontal11<0 && vertical11<0){
					while(truth11 && (i11>newI && j11>newJ)  ){
						if(chessboard[j11--][i11--] == Chessmen.EMPTY){
							truth11 = true;

						}else{
							truth11 = false;
							break;
						}
					}

				}
				if(horizontal11<0 && vertical11>0){
					while(truth11 && (i11>newI && j11<newJ)  ){
						if(chessboard[j11++][i11--] == Chessmen.EMPTY){
							truth11 = true;

						}else{
							truth11 = false;
							break;
						}
					}
				}
				isPathClear = truth11;

				break;

			}

			break;
		case BLACK_KING: 
			isPathClear = true;
			break;
		case EMPTY: break;
		}


		//destination Check
		if(chessboard[newJ][newI] == Chessmen.EMPTY){
			isDestinationClear = true;
		}else{
			isDestinationClear = false;
		}

		boolean initialIsWhite = false;
		boolean initialIsBlack = false;
		switch(chessboard[oldJ][oldI]){
		case WHITE_PAWN:
		case WHITE_BISHOP:
		case WHITE_KNIGHT:
		case WHITE_ROOK:
		case WHITE_QUEEN:
		case WHITE_KING: 
			initialIsWhite = true;
			initialIsBlack = false;
			break;
		case BLACK_PAWN:
		case BLACK_BISHOP:
		case BLACK_KNIGHT:
		case BLACK_ROOK:
		case BLACK_QUEEN:
		case BLACK_KING: 
			initialIsWhite = false;
			initialIsBlack = true;
			break;
		case EMPTY: break;
		}

		boolean finalIsWhite = false;
		boolean finalIsBlack = false;
		switch(chessboard[newJ][newI]){
		case WHITE_PAWN:
		case WHITE_BISHOP:
		case WHITE_KNIGHT:
		case WHITE_ROOK:
		case WHITE_QUEEN:
		case WHITE_KING: 
			finalIsWhite = true;
			finalIsBlack = false;
			break;
		case BLACK_PAWN:
		case BLACK_BISHOP:
		case BLACK_KNIGHT:
		case BLACK_ROOK:
		case BLACK_QUEEN:
		case BLACK_KING: 
			finalIsWhite = false;
			finalIsBlack = true;
			break;
		case EMPTY: break;
		}

		if(isDestinationClear == false){
			if((initialIsWhite & finalIsBlack) || (initialIsBlack&finalIsWhite)){
				if(isPathClear){
					System.out.println("Nailed It");
					isDestinationClear = true;
				}
			}
		}

		//special Case of pawn !!
		if(chessboard[oldJ][oldI] == Chessmen.WHITE_PAWN){
			if(((newJ-oldJ)==1)&&(Math.abs(newI-oldI)==1) && finalIsBlack ){
				System.out.println("Nailed It! ");
				return true;
			}
		}else if(chessboard[oldJ][oldI] == Chessmen.BLACK_PAWN){
			if(((newJ-oldJ)==-1)&&(Math.abs(newI-oldI)==1) && finalIsWhite ){
				isDestinationClear = true;
				isPathClear = true;
				movePattern = true;
				System.out.println("Nailed It! ");
			}
		}
		return movePattern&isPathClear &isDestinationClear;
	}
}
