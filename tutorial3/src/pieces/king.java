package pieces;

/*
 * King Class 
 */
public class king extends AbstractPiece{

	/*
	 * Constructor
	 */
	public king(boolean isWhite) {
		super(isWhite);
	}

	/*
	 * (non-Javadoc)
	 * @see pieces.AbstractPiece#draw()
	 */
	public void draw(){
		if(this.isWhite()){
			System.out.print("\u2654");
		}else{
			System.out.print("\u265A");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see pieces.AbstractPiece#isMoveValid(int, int, int, int)
	 */
	public boolean isMoveValid(int srcRow, int srcCol, int destRow, int destCol){
		if((Math.abs(destCol - srcCol)<2) && (Math.abs(destRow - srcRow)<2)  ){
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
		return 0;
	}
}
