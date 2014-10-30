package pieces;

/*
 * Bishop Clas
 */

public class bishop extends AbstractPiece{
	/*
	 * Constructor
	 */
	public bishop(boolean isWhite) {
		super(isWhite);
	}

	/*
	 * (non-Javadoc)
	 * @see pieces.AbstractPiece#draw()
	 */
	public void draw(){
		if(this.isWhite()){
			System.out.print("\u2657");
		}else{
			System.out.print("\u265D");
		}
	}
/*
 * (non-Javadoc)
 * @see pieces.AbstractPiece#isMoveValid(int, int, int, int)
 */
	public boolean isMoveValid(int srcRow, int srcCol, int destRow, int destCol){
		if(Math.abs(destCol - srcCol) == Math.abs(destRow - srcRow)){
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
		return 3;
	}
}
