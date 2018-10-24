# Linked-List-ChessBoard-Challenge
Main objective: Store the chess pieces on an 8 x 8 chessboard as a linked list. 
Implement the following procedures for a given chessboard:
• Determine Validity: Verify that two pieces do not occupy the same square, and there is exactly one king of each color (white and black).
• Find Piece on square: Given a square, determine the chess piece at that square, if any.  As in HW1, squares are specified as (column, row). 
• Discover an Attack (by a particular piece): Find out if the piece (found by Find Piece) attacks another piece.  Note that the pieces must be of different colors.  
Do not worry about blocking--assume that pieces can “pass through” other pieces on the board.  This is not true for proper chess, but it makes coding much easier for this challenge.  
Thus a piece x on a square can attack another piece y on a different square if x would be able travel to y’s square (according to the rules of chess) if there were no other pieces on the board. 
