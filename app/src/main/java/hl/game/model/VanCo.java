package hl.game.model;

import hl.game.cotoan.GameBoard;
import hl.game.quanco.QuanCo;

import org.anddev.andengine.engine.Engine;

import android.content.Context;

public class VanCo {
	public static NguoiChoi[] NguoiChoi = new NguoiChoi[2];
	public static int isPlaying = 0;
	public static int LuotDi = 1;
	
	public static void addChess(Engine mEngine, Context context) {
		
		switch (isPlaying) {
			case 1:
				
				NguoiChoi[0] = new NguoiChoi(0);
				
				NguoiChoi[0].q0.loadResources(mEngine, context);
				NguoiChoi[0].q1.loadResources(mEngine, context);
				NguoiChoi[0].q2.loadResources(mEngine, context);
				NguoiChoi[0].q3.loadResources(mEngine, context);
				NguoiChoi[0].q4.loadResources(mEngine, context);
				NguoiChoi[0].q5.loadResources(mEngine, context);
				NguoiChoi[0].q6.loadResources(mEngine, context);
				NguoiChoi[0].q7.loadResources(mEngine, context);
				NguoiChoi[0].q8.loadResources(mEngine, context);
				NguoiChoi[0].q9.loadResources(mEngine, context);
				
				NguoiChoi[1] = new NguoiChoi(1);
				NguoiChoi[1].q0.loadResources(mEngine, context);
				NguoiChoi[1].q1.loadResources(mEngine, context);
				NguoiChoi[1].q2.loadResources(mEngine, context);
				NguoiChoi[1].q3.loadResources(mEngine, context);
				NguoiChoi[1].q4.loadResources(mEngine, context);
				NguoiChoi[1].q5.loadResources(mEngine, context);
				NguoiChoi[1].q6.loadResources(mEngine, context);
				NguoiChoi[1].q7.loadResources(mEngine, context);
				NguoiChoi[1].q8.loadResources(mEngine, context);
				NguoiChoi[1].q9.loadResources(mEngine, context);
				break;
			case 0:
				NguoiChoi[0] = new NguoiChoi(0);
				
				NguoiChoi[0].q0.loadResources(mEngine, context);
				NguoiChoi[0].q1.loadResources(mEngine, context);
				NguoiChoi[0].q2.loadResources(mEngine, context);
				NguoiChoi[0].q3.loadResources(mEngine, context);
				NguoiChoi[0].q4.loadResources(mEngine, context);
				NguoiChoi[0].q5.loadResources(mEngine, context);
				NguoiChoi[0].q6.loadResources(mEngine, context);
				NguoiChoi[0].q7.loadResources(mEngine, context);
				NguoiChoi[0].q8.loadResources(mEngine, context);
				NguoiChoi[0].q9.loadResources(mEngine, context);
				
				NguoiChoi[1] = new NguoiChoi(1);
				NguoiChoi[1].q0.loadResources(mEngine, context);
				NguoiChoi[1].q1.loadResources(mEngine, context);
				NguoiChoi[1].q2.loadResources(mEngine, context);
				NguoiChoi[1].q3.loadResources(mEngine, context);
				NguoiChoi[1].q4.loadResources(mEngine, context);
				NguoiChoi[1].q5.loadResources(mEngine, context);
				NguoiChoi[1].q6.loadResources(mEngine, context);
				NguoiChoi[1].q7.loadResources(mEngine, context);
				NguoiChoi[1].q8.loadResources(mEngine, context);
				NguoiChoi[1].q9.loadResources(mEngine, context);
				break;
		}
	}
	
	/**
	 * Khoa toan bo quan co
	 */
	public static void lockChess() {
		NguoiChoi[0].q0.Khoa = true;
		NguoiChoi[0].q1.Khoa = true;
		NguoiChoi[0].q2.Khoa = true;
		NguoiChoi[0].q3.Khoa = true;
		NguoiChoi[0].q4.Khoa = true;
		NguoiChoi[0].q5.Khoa = true;
		NguoiChoi[0].q6.Khoa = true;
		NguoiChoi[0].q7.Khoa = true;
		NguoiChoi[0].q8.Khoa = true;
		NguoiChoi[0].q9.Khoa = true;
		
		NguoiChoi[1].q0.Khoa = true;
		NguoiChoi[1].q1.Khoa = true;
		NguoiChoi[1].q2.Khoa = true;
		NguoiChoi[1].q3.Khoa = true;
		NguoiChoi[1].q4.Khoa = true;
		NguoiChoi[1].q5.Khoa = false;
		NguoiChoi[1].q6.Khoa = true;
		NguoiChoi[1].q7.Khoa = true;
		NguoiChoi[1].q8.Khoa = true;
		NguoiChoi[1].q9.Khoa = true;
	}
	
	/**
	 * Thay doi luot di
	 */
	public static void changePlayer() {
		
		if (LuotDi == 0) {
			NguoiChoi[0].q0.Khoa = false;
			NguoiChoi[0].q1.Khoa = false;
			NguoiChoi[0].q2.Khoa = false;
			NguoiChoi[0].q3.Khoa = false;
			NguoiChoi[0].q4.Khoa = false;
			NguoiChoi[0].q5.Khoa = false;
			NguoiChoi[0].q6.Khoa = false;
			NguoiChoi[0].q7.Khoa = false;
			NguoiChoi[0].q8.Khoa = false;
			NguoiChoi[0].q9.Khoa = false;
			
			NguoiChoi[1].q0.Khoa = true;
			NguoiChoi[1].q1.Khoa = true;
			NguoiChoi[1].q2.Khoa = true;
			NguoiChoi[1].q3.Khoa = true;
			NguoiChoi[1].q4.Khoa = true;
			NguoiChoi[1].q5.Khoa = true;
			NguoiChoi[1].q6.Khoa = true;
			NguoiChoi[1].q7.Khoa = true;
			NguoiChoi[1].q8.Khoa = true;
			NguoiChoi[1].q9.Khoa = true;
			
		}
		if (LuotDi == 1) {
			NguoiChoi[1].q0.Khoa = false;
			NguoiChoi[1].q1.Khoa = false;
			NguoiChoi[1].q2.Khoa = false;
			NguoiChoi[1].q3.Khoa = false;
			NguoiChoi[1].q4.Khoa = false;
			NguoiChoi[1].q5.Khoa = false;
			NguoiChoi[1].q6.Khoa = false;
			NguoiChoi[1].q7.Khoa = false;
			NguoiChoi[1].q8.Khoa = false;
			NguoiChoi[1].q9.Khoa = false;
			
			NguoiChoi[0].q0.Khoa = true;
			NguoiChoi[0].q1.Khoa = true;
			NguoiChoi[0].q2.Khoa = true;
			NguoiChoi[0].q3.Khoa = true;
			NguoiChoi[0].q4.Khoa = true;
			NguoiChoi[0].q5.Khoa = true;
			NguoiChoi[0].q6.Khoa = true;
			NguoiChoi[0].q7.Khoa = true;
			NguoiChoi[0].q8.Khoa = true;
			NguoiChoi[0].q9.Khoa = true;
			
		}
		
	}
	
	/**
	 * Ham dat quan co den vi tri [i][j]
	 * 
	 * @param q
	 *            quan co duoc di
	 * @param i
	 *            cot
	 * @param j
	 *            hang
	 */
	public static void putChess(Engine mEngine, Context context, QuanCo q,
			int i, int j) {
		q.Hang = j;
		q.Cot = i;
		// q.loadResources(mEngine, context);
		
		// GameBoard.ViTri[j][i].Hang = j;
		// GameBoard.ViTri[j][i].Cot = i;
		// GameBoard.ViTri[j][i].Trong = false;
		// GameBoard.ViTri[j][i].Ten = q.Ten;
		// GameBoard.ViTri[j][i].Phe = q.Phe;
	}
	
	public static void updatePointChess(QuanCo q, int Cot, int Hang) {
		q.Cot = Cot;
		q.Hang = Hang;
		// q.loadResources(mEngine, context);
		// GameBoard.ViTri[Cot][Hang].Cot = Cot;
		// GameBoard.ViTri[Cot][Hang].Hang = Hang;
		GameBoard.ViTri[Cot][Hang].Ten = q.Ten;
		GameBoard.ViTri[Cot][Hang].Phe = q.Phe;
		GameBoard.ViTri[Cot][Hang].Trong = false;
	}
}
