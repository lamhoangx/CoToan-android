package hl.game.quanco;

public class Quan8 extends QuanCo {
	
	@Override
	public int checkChess(int i, int j) {
		turn = false;
		valueChess(i, j, this.GiaTri);
		if (turn == true)
			return 1;
		else
			return 0;
	}
	
}