	public class  Queen extends ChessPieces {
		public Queen(int color,int col, int row, String pieceType) {
			super(color,col,row,pieceType);
			
				
			}
		public boolean isAttacking(ChessPieces n) {
			if(row == n.row || col == n.row) {
				return true;
			}
			else if(Math.abs(n.col - col) == Math.abs(n.row - row)) {
				return true;
			}
		      	else if(Math.abs(n.col + col) == Math.abs(n.row + row)){
				return true;
			
			}	
		
			
			return false;
		}
}
	



