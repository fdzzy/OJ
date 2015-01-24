/*
 * Valid Sudoku
 * 
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * 
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * 
 * A partially filled sudoku which is valid.
 * 
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 * 
 */

public class ValidSudoku {
	
	private boolean validCells(char[] cells) {
		if(cells.length != 9) return false;
		boolean[] shown = new boolean[9];
		for(char cell : cells) {
			if(cell != '.') {
				int num = cell - '0' - 1;
				if(num < 0 || num > 8 || shown[num]) return false;
				shown[num] = true;
			}
		}
		return true;
	}
	
	public boolean isValidSudoku(char[][] board) {
		// check rows
		for(int i=0; i<9 ; i++) {
			if(validCells(board[i]) == false)
				return false;
		}
		// check columns
		for(int i=0; i<9 ; i++) {
			char[] cells = new char[9];
			for(int j=0; j<9; j++) {
				cells[j] = board[j][i];
			}
			if(validCells(cells) == false)
				return false;
		}
		// check sub-box
		for(int i=0; i<3; i++) {
			for(int j=0; j<3 ; j++) {
				char[] cells = new char[9];
				int k = 0;
				for(int m=0; m<3; m++) {
					for(int n=0; n<3 ; n++) {
						cells[k++] = board[i*3 + m][j*3 + n];
					}
				}
				if(validCells(cells) == false)
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		char[][] board = {
				{'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}
		};
		ValidSudoku v = new ValidSudoku();
		System.out.println(v.isValidSudoku(board));
	}

}
