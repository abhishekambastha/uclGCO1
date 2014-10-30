package pieces;

/*
 * Javadoc for Abstact Pieces
 */
public abstract class AbstractPiece {
	boolean isWhite;
	/*
	 * method
	 */
	public AbstractPiece(boolean isWhite){
		this.isWhite =isWhite;
	}

	/*
	 * method
	 */

	public boolean isWhite(){
		return isWhite;
	}

	/*
	 * method
	 */

	public abstract void draw();

	/*
	 * method
	 */

	public abstract boolean isMoveValid(int srcRow, int srcCol, int destRow, int destCol);

	/*
	 * method
	 */

	public abstract int relativeValue();

}
