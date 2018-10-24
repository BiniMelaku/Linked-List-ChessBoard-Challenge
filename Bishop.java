
public class Bishop extends ChessPieces {
	public Bishop(int color,int col, int row,String pieceType) {
		super(color,col,row,pieceType);
		
			
		}
	public boolean isAttacking(ChessPieces n){	
	
		 if( Math.abs(n.col - col) == Math.abs(n.row - row)){
			return true;
    		}else if(Math.abs(n.col +col) == Math.abs(n.row - row)){
			return true;
		}
		

		return false;
	}
}
