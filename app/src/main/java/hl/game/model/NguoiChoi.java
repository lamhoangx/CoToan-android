package hl.game.model;

import hl.game.quanco.Quan0;
import hl.game.quanco.Quan1;
import hl.game.quanco.Quan2;
import hl.game.quanco.Quan3;
import hl.game.quanco.Quan4;
import hl.game.quanco.Quan5;
import hl.game.quanco.Quan6;
import hl.game.quanco.Quan7;
import hl.game.quanco.Quan8;
import hl.game.quanco.Quan9;

public class NguoiChoi {
	public Quan0 q0 = new Quan0();
	public Quan1 q1 = new Quan1();
	public Quan2 q2 = new Quan2();
	public Quan3 q3 = new Quan3();
	public Quan4 q4 = new Quan4();
	public Quan5 q5 = new Quan5();
	public Quan6 q6 = new Quan6();
	public Quan7 q7 = new Quan7();
	public Quan8 q8 = new Quan8();
	public Quan9 q9 = new Quan9();
	
	public NguoiChoi(int x) {
		if (x == 0) {
			
			q0.createChess(0, 0, "0", 1, false, 1, 4);
			q1.createChess(0, 1, "1", 1, false, 0, 8);
			q2.createChess(0, 2, "2", 1, false, 0, 7);
			q3.createChess(0, 3, "3", 1, false, 0, 6);
			q4.createChess(0, 4, "4", 1, false, 0, 5);
			q5.createChess(0, 5, "5", 1, false, 0, 4);
			q6.createChess(0, 6, "6", 1, false, 0, 3);
			q7.createChess(0, 7, "7", 1, false, 0, 2);
			q8.createChess(0, 8, "8", 1, false, 0, 1);
			q9.createChess(0, 9, "9", 1, false, 0, 0);
		}
		if (x == 1)// nguoi 2
		{
			q0.createChess(1, 0, "0", 1, false, 9, 4);
			q1.createChess(1, 1, "1", 1, false, 10, 0);
			q2.createChess(1, 2, "2", 1, false, 10, 1);
			q3.createChess(1, 3, "3", 1, false, 10, 2);
			q4.createChess(1, 4, "4", 1, false, 10, 3);
			q5.createChess(1, 5, "5", 1, false, 10, 4);
			q6.createChess(1, 6, "6", 1, false, 10, 5);
			q7.createChess(1, 7, "7", 1, false, 10, 6);
			q8.createChess(1, 8, "8", 1, false, 10, 7);
			q9.createChess(1, 9, "9", 1, false, 10, 8);
		}
	}
}
