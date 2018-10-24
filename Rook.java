
public class Rook extends ChessPieces {
	public Rook(int color,int col, int row,String pieceType) {
		super(color,col,row,pieceType);
	}
	public boolean isAttacking(ChessPieces n){
        
		if( row == n.row || col == n.col){
			return true;
    
		}

		return false;
	}
}	
