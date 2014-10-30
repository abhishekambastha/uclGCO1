package pieces;

/*
 * Rook
 */
public class rook extends AbstractPiece{
	/*
	 * construct rook
	 */
	public rook(boolean isWhite) {
		super(isWhite);
	}
	/*
	 * (non-Javadoc)
	 * @see pieces.AbstractPiece#draw()
	 */
	public void draw(){
		if(this.isWhite()){
			System.out.print("\u2656");
		}else{
			System.out.print("\u265C");
		}
	}
	/*
	 * (non-Javadoc)
	 * @see pieces.AbstractPiece#isMoveValid(int, int, int, int)
	 */
	public boolean isMoveValid(int srcRow, int srcCol, int destRow, int destCol){
		if(((destCol - srcCol)==0) || ((destRow - srcRow)==0)){
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
		return 5;
	}
}
