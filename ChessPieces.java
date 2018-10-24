public class ChessPieces {
	int col,row;
	 int color;
	 public boolean white;
	 public boolean black;
	 ChessPieces next;
	 ChessPieces head;
	 ChessPieces prev;
	 ChessPieces current;
	 public String pieceType;
	 
	 public ChessPieces() {
		 pieceType = "-";
	 }
	 
	  public ChessPieces(int color,int col, int row, String type){
		 this.color = color;
		 this.col = col;
		 this.row = row;
		 pieceType = type;
		
				 
		
	  }
		public boolean isAttacking(ChessPieces n) {
			return false;
		}
		
}
	  
	  
	 
	
