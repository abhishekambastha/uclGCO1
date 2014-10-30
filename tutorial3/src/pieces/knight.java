package pieces;
/*
 * knight Class
 */
public class knight extends AbstractPiece {

	/*
	 * Cinstructor Notes
	 */
	public knight(boolean isWhite) {
		super(isWhite);
	}

	/*
	 * (non-Javadoc)
	 * @see pieces.AbstractPiece#draw()
	 */
	public void draw(){
		if(isWhite()){
			System.out.print("\u2658");
		}else{
			System.out.print("\u265E");
		}
	}
	/*
	 * (non-Javadoc)
	 * @see pieces.AbstractPiece#isMoveValid(int, int, int, int)
	 */
	public boolean isMoveValid(int srcRow, int srcCol, int destRow, int destCol){
		if((Math.abs(destCol-srcCol)==2)&& (Math.abs(destRow-srcRow)==1) || (Math.abs(destCol-srcCol)==1)&& (Math.abs(destRow-srcRow)==2)){
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
