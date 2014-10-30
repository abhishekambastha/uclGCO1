package pieces;

/*
 * Queen
 */
public class queen extends AbstractPiece{
	/*
	 * Construct the Queen!!!
	 */
	public queen(boolean isWhite) {
		super(isWhite);
	}

	/*
	 * (non-Javadoc)
	 * @see pieces.AbstractPiece#draw()
	 */
	public void draw(){
		if(this.isWhite()){
			System.out.print("\u2655");
		}else{
			System.out.print("\u265B");
		}
	}
	/*
	 * (non-Javadoc)
	 * @see pieces.AbstractPiece#isMoveValid(int, int, int, int)
	 */
	public boolean isMoveValid(int srcRow, int srcCol, int destRow, int destCol){
		if(Math.abs(destCol - srcCol) == Math.abs(destRow - srcRow)){
			return true;
		}else if(((destCol - srcCol)==0) || ((destRow - srcRow)==0)){
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
		return 9;
	}
}
