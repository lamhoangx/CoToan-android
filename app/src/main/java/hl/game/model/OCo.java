package hl.game.model;

import hl.game.cotoan.GameBoard;
import hl.game.quanco.QuanCo;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.input.touch.TouchEvent;
import org.anddev.andengine.opengl.texture.Texture;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.texture.region.TextureRegionFactory;

import android.content.Context;
import android.widget.ImageButton;

public class OCo {
	public int Hang;
	public int Cot;
	public boolean Trong;
	public String Ten;
	public int Phe;
	public Sprite imgCanMove;
	public ImageButton img;
	
	// Image canmove
	private Texture ttCanMove;
	private TextureRegion ttRegionCanMove;
	
	public static OCo[][] ViTri = new OCo[10][12];
	
	public OCo() {
		Hang = 0;
		Cot = 0;
		Trong = true;
		Ten = "";
		Phe = 0;
		imgCanMove = null;
		img = null;
	}
	
	public void createCanMove(int hang, int cot, boolean trong, String ten,
			int phe) {
		Hang = hang;
		Cot = cot;
		Trong = trong;
		Ten = ten;
		Phe = phe;
	}
	
	public void loadResources(final Engine mEngine, final Context context) {
		TextureRegionFactory.setAssetBasePath("data/");
		
		ttCanMove = new Texture(64, 64,
				TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		ttRegionCanMove = TextureRegionFactory.createFromAsset(this.ttCanMove,
				context, "canmove.png", 0, 0);
		
		mEngine.getTextureManager().loadTexture(this.ttCanMove);
		
	}
	
	public void drawCanMove(final Engine mEngine, final Context context,
			final int iCot, final int iHang) {
		
		imgCanMove = new Sprite(iCot * 54 + 37, iHang * 54 + 40,
				ttRegionCanMove) {
			
			@Override
			public boolean onAreaTouched(TouchEvent pSceneTouchEvent,
					float pTouchAreaLocalX, float pTouchAreaLocalY) {
				if (pSceneTouchEvent.getAction() == TouchEvent.ACTION_DOWN
						&& QuanCo.DanhDau != null) {
					
					System.out.println("Hang = " + iHang);
					System.out.println("Cot = " + iCot);
					
					QuanCo.tempCot = iCot;
					QuanCo.tempHang = iHang;
					
					OCoTrong(QuanCo.DanhDau.Cot, QuanCo.DanhDau.Hang);
					
					// if (QuanCo.getChess(Cot, Hang) != null)
					// VanCo.eatChess(QuanCo.getChess(Cot, Hang));
					VanCo.putChess(mEngine, context, QuanCo.DanhDau, iCot,
							iHang);
					
					// if (VanCo.isAI == 1) {
					// VanCo.moveChessAI();
					// VanCo.changePlayer();
					// }
					
					// VanCo.changePlayer();
					// VanCo.isWin();
					System.out.println("Click CanMove ");
					// ViTri[Cot][Hang].imgCanMove.at
					QuanCo.isMove = true;
				}
				GameBoard.resetCanMove();
				
				return true;
			}
			
		};
		imgCanMove.setVisible(false);
	}
	
	public static void OCoTrong(int i, int j) {
		GameBoard.ViTri[i][j].Trong = true;
		GameBoard.ViTri[i][j].Ten = "";
		GameBoard.ViTri[i][j].Phe = 2;
	}
}
