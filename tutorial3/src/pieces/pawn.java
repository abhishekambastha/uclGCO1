package pieces;
/*
 * pawn class
 */
public class pawn extends AbstractPiece{
	/*
	 * constructor hehe
	 */
	public pawn(boolean isWhite) {
		super(isWhite);
	}

	/*
	 * (non-Javadoc)
	 * @see pieces.AbstractPiece#draw()
	 */
	public void draw(){
		if(this.isWhite()){
			System.out.print("\u2659");
		}else{
			System.out.print("\u265F");
		}
	}
	/*
	 * (non-Javadoc)
	 * @see pieces.AbstractPiece#isMoveValid(int, int, int, int)
	 */
	public boolean isMoveValid(int srcRow, int srcCol, int destRow, int destCol){
		int sign = (this.isWhite())?1:-1;   //if white direction is up to down and vice-versa

		//check for home position and allow two forward steps here

		if(((destCol - srcCol)==0) && (destRow-srcRow == 1*sign)){
			return true;
		}else{
			return false;
		}


	}
	/*
	 * (non-Javadoc)
	 * @see pieces.AbstractPiece#relativeValue()
	 */
	public int relativeValue(){
		return 1;
	}
}
