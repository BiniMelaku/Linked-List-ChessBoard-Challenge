//Biniam Melaku
//Cruz ID:1536609
//HW2
//stores input chesspieces on a board as a linked list with methods to find piece, determine validity, and check an attack




import java.io.*;
import java.lang.*;
import java.util.Scanner;

public class ChessBoard {
	public static PrintWriter writer;


	public static ChessPieces head = new ChessPieces();
	public static ChessPieces tail = head;
	public static int x,y;

	public static void ChessBoard() {
		head = new ChessPieces();
		tail = head;

	}
	public static boolean isEmpty() {
		return head == null;

	}

	public static void insert(ChessPieces p) {
		p.next = head;
		p.prev = head.prev;
		head.prev = p;
		head = p;
	}
	//checks if piece attacks another piece on the board
	public static boolean checkAttack(ChessPieces piece) {
		
	  	ChessPieces current = tail;
		while(current!=null) {
			if(piece.isAttacking(current) && current != piece)
			
			return true;
			
			current = current.prev;
		}
	
        	return false;
	}
	//checks through list to see if no 2 pieces are on the same square and there is at least one king of each color 
	public static boolean isValid() {
		ChessPieces current = tail;
		ChessPieces curr = tail.prev;
		int whiteKings = 0;
		int blackKings = 0;

		while(curr != null) {
			
			current = curr.prev;
			if(curr.pieceType == "k")
				whiteKings++;
			if(curr.pieceType == "K")
				blackKings++;
			while(current!= null) {
				if(current.col == curr.col && current.row == curr.row) {
					return false;
				}
				current = current.prev;
			}
			curr = curr.prev;
		}
		if(whiteKings != 1 || blackKings != 1) {
			return false;
		}
		return true;
	}
	public static ChessPieces findPiece(int col,int row) {
		ChessPieces current = tail;
		while(current != null) {
			if(current.col == col && current.row == row){
			
				return current;
			}
			
			current = current.prev;
		}
		return new ChessPieces();
	}

	public static void main(String[] args) throws IOException {

		int color;
		int lineNumber = 0;




		if(args.length < 2){
			System.out.println("Usage: java jar FileCopy.jar <input file> <output file>");

			System.exit(1);
		}
		Scanner input = new Scanner(new File(args[0]));
		PrintWriter out = new PrintWriter(new FileWriter(args[1]));


		//gets input from input file
		while(input.hasNextLine() ){
			
			head = new ChessPieces();
			tail = head;

			String line = input.nextLine().trim() + " ";
			System.out.println(line);
			String[]token = line.split("\\s+");
			int n = token.length;
			//tokenizes query (col,row)
			x = Integer.parseInt(token[0]);
			y = Integer.parseInt(""+token[1].charAt(0));
			//goes through line and inserts piece based off piecetype
			for(int j=2;j<n; j =j+3) {

				if(token[j].equals("q")) {
					color = 1;
					insert(new Queen(color,Integer.parseInt(token[j+1]),Integer.parseInt(token[j+2]),"q"));
					

				}  
				if(token[j].equals("Q")) {
					color = 0;
					insert(new Queen(color,Integer.parseInt(token[j+1]),Integer.parseInt(token[j+2]),"Q"));
					
				}   

				if(token[j].equals("k")) {
					color = 1;
					insert(new King(color,Integer.parseInt(token[j+1]),Integer.parseInt(token[j+2]),"k"));

				}	
				if(token[j].equals("K")) {
					color = 0;
					insert(new King(color,Integer.parseInt(token[j+1]),Integer.parseInt(token[j+2]),"K"));

				}	
				if(token[j].equals("b")) {
					color = 1;
					insert(new Bishop(color,Integer.parseInt(token[j+1]),Integer.parseInt(token[j+2]),"b"));

				}	
				if(token[j].equals("B")) {
					color = 0;
					insert(new Bishop(color,Integer.parseInt(token[j+1]),Integer.parseInt(token[j+2]),"B"));

				}	
				if(token[j].equals("r")) {
					color = 1;
					insert(new Rook(color,Integer.parseInt(token[j+1]),Integer.parseInt(token[j+2]),"r"));

				}	
				if(token[j].equals("R")){
					color = 0;
					insert(new Rook(color,Integer.parseInt(token[j+1]),Integer.parseInt(token[j+2]),"R"));

				}	

			}	// closes for loop
			if(isValid()) {
				if(!findPiece(x,y).pieceType.equals("-")){
				
					if(checkAttack(findPiece(x,y)))
						out.println(findPiece(x,y).pieceType+" y");
					else {
						
						out.println(findPiece(x,y).pieceType + " n");
						}
					
				}
				else 
					out.println(findPiece(x,y).pieceType);
			}else {
					out.println("Invalid");
				
			}		  
		} // closes while loop

		input.close();
		out.close();

		tail = tail.prev;
		

	} // closes main method

}





