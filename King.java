
public class King extends ChessPieces {
	public King(int color,int col, int row,String pieceType) {
		super(color,col,row,pieceType);
		

}
	  public boolean isAttacking(ChessPieces n){
	        if(n.row == row || n.col == col){
			return true;
		}


		else if( Math.abs(row-n.row) == 1 || Math.abs(col-n.col) == 1){

			return true;
		
	    	}else if(Math.abs(row+n.row) == 1 || Math.abs(col+n.col) ==1){
			return true;
		}
		return false;

	}
}
