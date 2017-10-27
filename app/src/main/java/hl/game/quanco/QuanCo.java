package hl.game.quanco;

import hl.game.cotoan.GameBoard;
import hl.game.model.VanCo;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.input.touch.TouchEvent;
import org.anddev.andengine.opengl.texture.Texture;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.texture.region.TextureRegionFactory;

import android.content.Context;

public abstract class QuanCo {
	
	public static int tempHang = 0, tempCot = 0;
	
	public int Hang;
	public int Cot;
	public String Ten;
	public int Phe;
	public int GiaTri;
	public int TrangThai;
	public boolean Khoa = false;
	public boolean turn = false;
	public static QuanCo DanhDau;
	public Sprite imgChess;
	public static boolean isMove = false;
	// Cac gia tri de tinh toan nuoc di
	private int ch = 0, c = 0, t = 0, n = 0, d = 0; // chia, cong, tru, nhan, du
	// gia tri quan dem, gia tri quan tham chieu den, gia tri det qua cong,
	// chia, nhan, tru, du
	public int index1 = 0, index2 = 0, result_Add = 0, result_Add_Div = 0,
			result_Add_Mul = 0, result_Sub = 0, result_Du = 0;
	
	// Image canmove
	private Texture ttChess;
	private TextureRegion ttRegionChess;
	
	public QuanCo() {
		Hang = 7;
		Cot = 9;
		Ten = "";
		Phe = 2;
		GiaTri = 0;
		TrangThai = 0;
		Khoa = true;
		imgChess = null;
		
	}
	
	public void createChess(int phe, int giatri, String name, int stt,
			boolean khoa, int hang, int cot) {
		Hang = hang;
		Cot = cot;
		Ten = name;
		TrangThai = stt;
		Phe = phe;
		GiaTri = giatri;
		Khoa = khoa;
		
	}
	
	public abstract int checkChess(int i, int j);
	
	public void loadResources(final Engine mEngine, final Context context) {
		TextureRegionFactory.setAssetBasePath("data/");
		
		if (Phe == 0) {
			if (Ten == "0") {
				this.ttChess = new Texture(64, 64,
						TextureOptions.BILINEAR_PREMULTIPLYALPHA);
				this.ttRegionChess = TextureRegionFactory.createFromAsset(
						this.ttChess, context, "trang0.png", 0, 0);
				mEngine.getTextureManager().loadTexture(this.ttChess);
				// imgChess = new Sprite(Cot * 54 + 22, Hang * 54 + 28,
				// ttRegionChess);
				
			}
			if (Ten == "1") {
				this.ttChess = new Texture(64, 64,
						TextureOptions.BILINEAR_PREMULTIPLYALPHA);
				this.ttRegionChess = TextureRegionFactory.createFromAsset(
						this.ttChess, context, "trang1.png", 0, 0);
				mEngine.getTextureManager().loadTexture(this.ttChess);
				// imgChess = new Sprite(Cot * 54 + 22, Hang * 54 + 28,
				// ttRegionChess);
			}
			if (Ten == "2") {
				this.ttChess = new Texture(64, 64,
						TextureOptions.BILINEAR_PREMULTIPLYALPHA);
				this.ttRegionChess = TextureRegionFactory.createFromAsset(
						this.ttChess, context, "trang2.png", 0, 0);
				mEngine.getTextureManager().loadTexture(this.ttChess);
				// imgChess = new Sprite(Cot * 54 + 22, Hang * 54 + 28,
				// ttRegionChess);
			}
			if (Ten == "3") {
				this.ttChess = new Texture(64, 64,
						TextureOptions.BILINEAR_PREMULTIPLYALPHA);
				this.ttRegionChess = TextureRegionFactory.createFromAsset(
						this.ttChess, context, "trang3.png", 0, 0);
				mEngine.getTextureManager().loadTexture(this.ttChess);
				// imgChess = new Sprite(Cot * 54 + 22, Hang * 54 + 28,
				// ttRegionChess);
			}
			if (Ten == "4") {
				this.ttChess = new Texture(64, 64,
						TextureOptions.BILINEAR_PREMULTIPLYALPHA);
				this.ttRegionChess = TextureRegionFactory.createFromAsset(
						this.ttChess, context, "trang4.png", 0, 0);
				mEngine.getTextureManager().loadTexture(this.ttChess);
				// imgChess = new Sprite(Cot * 54 + 22, Hang * 54 + 28,
				// ttRegionChess);
			}
			if (Ten == "5") {
				this.ttChess = new Texture(64, 64,
						TextureOptions.BILINEAR_PREMULTIPLYALPHA);
				this.ttRegionChess = TextureRegionFactory.createFromAsset(
						this.ttChess, context, "trang5.png", 0, 0);
				mEngine.getTextureManager().loadTexture(this.ttChess);
				// imgChess = new Sprite(Cot * 54 + 22, Hang * 54 + 28,
				// ttRegionChess);
			}
			if (Ten == "6") {
				this.ttChess = new Texture(64, 64,
						TextureOptions.BILINEAR_PREMULTIPLYALPHA);
				this.ttRegionChess = TextureRegionFactory.createFromAsset(
						this.ttChess, context, "trang6.png", 0, 0);
				mEngine.getTextureManager().loadTexture(this.ttChess);
				// imgChess = new Sprite(Cot * 54 + 22, Hang * 54 + 28,
				// ttRegionChess);
			}
			if (Ten == "7") {
				this.ttChess = new Texture(64, 64,
						TextureOptions.BILINEAR_PREMULTIPLYALPHA);
				this.ttRegionChess = TextureRegionFactory.createFromAsset(
						this.ttChess, context, "trang7.png", 0, 0);
				mEngine.getTextureManager().loadTexture(this.ttChess);
				// imgChess = new Sprite(Cot * 54 + 22, Hang * 54 + 28,
				// ttRegionChess);
			}
			if (Ten == "8") {
				this.ttChess = new Texture(64, 64,
						TextureOptions.BILINEAR_PREMULTIPLYALPHA);
				this.ttRegionChess = TextureRegionFactory.createFromAsset(
						this.ttChess, context, "trang8.png", 0, 0);
				mEngine.getTextureManager().loadTexture(this.ttChess);
				// imgChess = new Sprite(Cot * 54 + 22, Hang * 54 + 28,
				// ttRegionChess);
			}
			if (Ten == "9") {
				this.ttChess = new Texture(64, 64,
						TextureOptions.BILINEAR_PREMULTIPLYALPHA);
				this.ttRegionChess = TextureRegionFactory.createFromAsset(
						this.ttChess, context, "trang9.png", 0, 0);
				mEngine.getTextureManager().loadTexture(this.ttChess);
				// imgChess = new Sprite(Cot * 54 + 22, Hang * 54 + 28,
				// ttRegionChess);
			}
		}
		if (Phe == 1) {
			if (Ten == "0") {
				this.ttChess = new Texture(64, 64,
						TextureOptions.BILINEAR_PREMULTIPLYALPHA);
				this.ttRegionChess = TextureRegionFactory.createFromAsset(
						this.ttChess, context, "den0.png", 0, 0);
				mEngine.getTextureManager().loadTexture(this.ttChess);
				// imgChess = new Sprite(Cot * 54 + 22, Hang * 54 + 28,
				// ttRegionChess);
			}
			if (Ten == "1") {
				this.ttChess = new Texture(64, 64,
						TextureOptions.BILINEAR_PREMULTIPLYALPHA);
				this.ttRegionChess = TextureRegionFactory.createFromAsset(
						this.ttChess, context, "den1.png", 0, 0);
				mEngine.getTextureManager().loadTexture(this.ttChess);
				// imgChess = new Sprite(Cot * 54 + 22, Hang * 54 + 28,
				// ttRegionChess);
			}
			if (Ten == "2") {
				this.ttChess = new Texture(64, 64,
						TextureOptions.BILINEAR_PREMULTIPLYALPHA);
				this.ttRegionChess = TextureRegionFactory.createFromAsset(
						this.ttChess, context, "den2.png", 0, 0);
				mEngine.getTextureManager().loadTexture(this.ttChess);
				// imgChess = new Sprite(Cot * 54 + 22, Hang * 54 + 28,
				// ttRegionChess);
			}
			if (Ten == "3") {
				this.ttChess = new Texture(64, 64,
						TextureOptions.BILINEAR_PREMULTIPLYALPHA);
				this.ttRegionChess = TextureRegionFactory.createFromAsset(
						this.ttChess, context, "den3.png", 0, 0);
				mEngine.getTextureManager().loadTexture(this.ttChess);
				// imgChess = new Sprite(Cot * 54 + 22, Hang * 54 + 28,
				// ttRegionChess);
			}
			if (Ten == "4") {
				this.ttChess = new Texture(64, 64,
						TextureOptions.BILINEAR_PREMULTIPLYALPHA);
				this.ttRegionChess = TextureRegionFactory.createFromAsset(
						this.ttChess, context, "den4.png", 0, 0);
				mEngine.getTextureManager().loadTexture(this.ttChess);
				// imgChess = new Sprite(Cot * 54 + 22, Hang * 54 + 28,
				// ttRegionChess);
			}
			if (Ten == "5") {
				this.ttChess = new Texture(64, 64,
						TextureOptions.BILINEAR_PREMULTIPLYALPHA);
				this.ttRegionChess = TextureRegionFactory.createFromAsset(
						this.ttChess, context, "den5.png", 0, 0);
				mEngine.getTextureManager().loadTexture(this.ttChess);
				// imgChess = new Sprite(Cot * 54 + 22, Hang * 54 + 28,
				// ttRegionChess);
			}
			if (Ten == "6") {
				this.ttChess = new Texture(64, 64,
						TextureOptions.BILINEAR_PREMULTIPLYALPHA);
				this.ttRegionChess = TextureRegionFactory.createFromAsset(
						this.ttChess, context, "den6.png", 0, 0);
				mEngine.getTextureManager().loadTexture(this.ttChess);
				// imgChess = new Sprite(Cot * 54 + 22, Hang * 54 + 28,
				// ttRegionChess);
			}
			if (Ten == "7") {
				this.ttChess = new Texture(64, 64,
						TextureOptions.BILINEAR_PREMULTIPLYALPHA);
				this.ttRegionChess = TextureRegionFactory.createFromAsset(
						this.ttChess, context, "den7.png", 0, 0);
				mEngine.getTextureManager().loadTexture(this.ttChess);
				// imgChess = new Sprite(Cot * 54 + 22, Hang * 54 + 28,
				// ttRegionChess);
			}
			if (Ten == "8") {
				this.ttChess = new Texture(64, 64,
						TextureOptions.BILINEAR_PREMULTIPLYALPHA);
				this.ttRegionChess = TextureRegionFactory.createFromAsset(
						this.ttChess, context, "den8.png", 0, 0);
				mEngine.getTextureManager().loadTexture(this.ttChess);
				// imgChess = new Sprite(Cot * 54 + 22, Hang * 54 + 28,
				// ttRegionChess);
			}
			if (Ten == "9") {
				this.ttChess = new Texture(64, 64,
						TextureOptions.BILINEAR_PREMULTIPLYALPHA);
				this.ttRegionChess = TextureRegionFactory.createFromAsset(
						this.ttChess, context, "den9.png", 0, 0);
				mEngine.getTextureManager().loadTexture(this.ttChess);
				
			}
		}
		GameBoard.ViTri[Cot][Hang].Hang = Hang;
		GameBoard.ViTri[Cot][Hang].Cot = Cot;
		GameBoard.ViTri[Cot][Hang].Trong = false;
		GameBoard.ViTri[Cot][Hang].Ten = Ten;
		GameBoard.ViTri[Cot][Hang].Phe = Phe;
	}
	
	public void drawChess() {
		
		imgChess = new Sprite(Cot * 54 + 22, Hang * 54 + 28, ttRegionChess) {
			
			@Override
			public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
					final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
				if (pSceneTouchEvent.getAction() == TouchEvent.ACTION_DOWN) {
					
					System.out.println("Event Touch Image Chess :  " + Ten);
					System.out.println("Hang = " + Hang);
					System.out.println("Cot  = " + Cot);
					System.out.println("Phe  = " + Phe);
					
					GameBoard.resetBoardChess();
					// Set point move chess
					if (Khoa == false) {
						if (TrangThai == 1) {
							DanhDau = QuanCo.this;
							
							System.out.println("Quan Co duoc danh dau : "
									+ DanhDau.Ten + " Phe " + Phe + "Vi tri: "
									+ Cot + "Hang " + Hang);
							
							for (int i = 0; i <= 8; i++) {
								for (int j = 0; j <= 10; j++) {
									if (i != Cot || j != Hang)
										if (checkChess(i, j) == 1) {
											
											GameBoard.ViTri[i][j].imgCanMove
													.setVisible(true);
											
											GameBoard.scene
													.registerTouchArea(GameBoard.ViTri[i][j].imgCanMove);
											
											if (GameBoard.ViTri[i][j].Trong == false) {
												GameBoard.scene
														.unregisterTouchArea(QuanCo
																.getChess(
																		i,
																		j,
																		GameBoard.ViTri[i][j].Phe).imgChess);
											}
											System.out.println(i + "," + j);
										}
								}
							}
							
						}
					}
				}
				
				return true;
			}
			
		};
	}
	
	/**
	 * Xac dinh quan co tai vi tri[i][j]
	 * 
	 * @param hang
	 * @param cot
	 * @return
	 */
	public static QuanCo getChess(int cot, int hang, int index) {
		
		// if (DanhDau.Phe == 0)
		// index = 1;
		// else
		// index = 0;
		QuanCo temp = null;
		
		if (GameBoard.ViTri[cot][hang].Ten .equalsIgnoreCase( "0"))
			temp = VanCo.NguoiChoi[index].q0;
		if (GameBoard.ViTri[cot][hang].Ten .equalsIgnoreCase( "1"))
			temp = VanCo.NguoiChoi[index].q1;
		if (GameBoard.ViTri[cot][hang].Ten .equalsIgnoreCase( "2"))
			temp = VanCo.NguoiChoi[index].q2;
		if (GameBoard.ViTri[cot][hang].Ten .equalsIgnoreCase( "3"))
			temp = VanCo.NguoiChoi[index].q3;
		if (GameBoard.ViTri[cot][hang].Ten .equalsIgnoreCase( "4"))
			temp = VanCo.NguoiChoi[index].q4;
		if (GameBoard.ViTri[cot][hang].Ten .equalsIgnoreCase( "5"))
			temp = VanCo.NguoiChoi[index].q5;
		if (GameBoard.ViTri[cot][hang].Ten .equalsIgnoreCase( "6"))
			temp = VanCo.NguoiChoi[index].q6;
		if (GameBoard.ViTri[cot][hang].Ten .equalsIgnoreCase( "7"))
			temp = VanCo.NguoiChoi[index].q7;
		if (GameBoard.ViTri[cot][hang].Ten .equalsIgnoreCase( "8"))
			temp = VanCo.NguoiChoi[index].q8;
		if (GameBoard.ViTri[cot][hang].Ten .equalsIgnoreCase( "9"))
			temp = VanCo.NguoiChoi[index].q9;
		
		return temp;
	}
	
	public void drawChessSelect(Engine mEngine, Context context) {
		TextureRegionFactory.setAssetBasePath("data/");
		
		if (Phe == 0) {
			if (Ten == "0") {
				this.ttChess = new Texture(64, 64,
						TextureOptions.BILINEAR_PREMULTIPLYALPHA);
				this.ttRegionChess = TextureRegionFactory.createFromAsset(
						this.ttChess, context, "trang0select.png", 0, 0);
				mEngine.getTextureManager().loadTexture(this.ttChess);
				// imgChess = new Sprite(Cot * 54 + 22, Hang * 54 + 28,
				// ttRegionChess);
				
			}
			if (Ten == "1") {
				this.ttChess = new Texture(64, 64,
						TextureOptions.BILINEAR_PREMULTIPLYALPHA);
				this.ttRegionChess = TextureRegionFactory.createFromAsset(
						this.ttChess, context, "trang1select.png", 0, 0);
				mEngine.getTextureManager().loadTexture(this.ttChess);
				// imgChess = new Sprite(Cot * 54 + 22, Hang * 54 + 28,
				// ttRegionChess);
				
			}
			if (Ten == "2") {
				this.ttChess = new Texture(64, 64,
						TextureOptions.BILINEAR_PREMULTIPLYALPHA);
				this.ttRegionChess = TextureRegionFactory.createFromAsset(
						this.ttChess, context, "trang2select.png", 0, 0);
				mEngine.getTextureManager().loadTexture(this.ttChess);
				// imgChess = new Sprite(Cot * 54 + 22, Hang * 54 + 28,
				// ttRegionChess);
			}
			if (Ten == "3") {
				this.ttChess = new Texture(64, 64,
						TextureOptions.BILINEAR_PREMULTIPLYALPHA);
				this.ttRegionChess = TextureRegionFactory.createFromAsset(
						this.ttChess, context, "trang3select.png", 0, 0);
				mEngine.getTextureManager().loadTexture(this.ttChess);
				// imgChess = new Sprite(Cot * 54 + 22, Hang * 54 + 28,
				// ttRegionChess);
			}
			if (Ten == "4") {
				this.ttChess = new Texture(64, 64,
						TextureOptions.BILINEAR_PREMULTIPLYALPHA);
				this.ttRegionChess = TextureRegionFactory.createFromAsset(
						this.ttChess, context, "trang4select.png", 0, 0);
				mEngine.getTextureManager().loadTexture(this.ttChess);
				// imgChess = new Sprite(Cot * 54 + 22, Hang * 54 + 28,
				// ttRegionChess);
			}
			if (Ten == "5") {
				this.ttChess = new Texture(64, 64,
						TextureOptions.BILINEAR_PREMULTIPLYALPHA);
				this.ttRegionChess = TextureRegionFactory.createFromAsset(
						this.ttChess, context, "trang5select.png", 0, 0);
				mEngine.getTextureManager().loadTexture(this.ttChess);
				// imgChess = new Sprite(Cot * 54 + 22, Hang * 54 + 28,
				// ttRegionChess);
			}
			if (Ten == "6") {
				this.ttChess = new Texture(64, 64,
						TextureOptions.BILINEAR_PREMULTIPLYALPHA);
				this.ttRegionChess = TextureRegionFactory.createFromAsset(
						this.ttChess, context, "trang6select.png", 0, 0);
				mEngine.getTextureManager().loadTexture(this.ttChess);
				// imgChess = new Sprite(Cot * 54 + 22, Hang * 54 + 28,
				// ttRegionChess);
			}
			if (Ten == "7") {
				this.ttChess = new Texture(64, 64,
						TextureOptions.BILINEAR_PREMULTIPLYALPHA);
				this.ttRegionChess = TextureRegionFactory.createFromAsset(
						this.ttChess, context, "trang7select.png", 0, 0);
				mEngine.getTextureManager().loadTexture(this.ttChess);
				// imgChess = new Sprite(Cot * 54 + 22, Hang * 54 + 28,
				// ttRegionChess);
			}
			if (Ten == "8") {
				this.ttChess = new Texture(64, 64,
						TextureOptions.BILINEAR_PREMULTIPLYALPHA);
				this.ttRegionChess = TextureRegionFactory.createFromAsset(
						this.ttChess, context, "trang8select.png", 0, 0);
				mEngine.getTextureManager().loadTexture(this.ttChess);
				// imgChess = new Sprite(Cot * 54 + 22, Hang * 54 + 28,
				// ttRegionChess);
			}
			if (Ten == "9") {
				this.ttChess = new Texture(64, 64,
						TextureOptions.BILINEAR_PREMULTIPLYALPHA);
				this.ttRegionChess = TextureRegionFactory.createFromAsset(
						this.ttChess, context, "trang9select.png", 0, 0);
				mEngine.getTextureManager().loadTexture(this.ttChess);
				// imgChess = new Sprite(Cot * 54 + 22, Hang * 54 + 28,
				// ttRegionChess);
			}
		}
		if (Phe == 1) {
			if (Ten == "0") {
				this.ttChess = new Texture(64, 64,
						TextureOptions.BILINEAR_PREMULTIPLYALPHA);
				this.ttRegionChess = TextureRegionFactory.createFromAsset(
						this.ttChess, context, "den0select.png", 0, 0);
				mEngine.getTextureManager().loadTexture(this.ttChess);
				// imgChess = new Sprite(Cot * 54 + 22, Hang * 54 + 28,
				// ttRegionChess);
			}
			if (Ten == "1") {
				this.ttChess = new Texture(64, 64,
						TextureOptions.BILINEAR_PREMULTIPLYALPHA);
				this.ttRegionChess = TextureRegionFactory.createFromAsset(
						this.ttChess, context, "den1select.png", 0, 0);
				mEngine.getTextureManager().loadTexture(this.ttChess);
				// imgChess = new Sprite(Cot * 54 + 22, Hang * 54 + 28,
				// ttRegionChess);
			}
			if (Ten == "2") {
				this.ttChess = new Texture(64, 64,
						TextureOptions.BILINEAR_PREMULTIPLYALPHA);
				this.ttRegionChess = TextureRegionFactory.createFromAsset(
						this.ttChess, context, "den2select.png", 0, 0);
				mEngine.getTextureManager().loadTexture(this.ttChess);
				// imgChess = new Sprite(Cot * 54 + 22, Hang * 54 + 28,
				// ttRegionChess);
			}
			if (Ten == "3") {
				this.ttChess = new Texture(64, 64,
						TextureOptions.BILINEAR_PREMULTIPLYALPHA);
				this.ttRegionChess = TextureRegionFactory.createFromAsset(
						this.ttChess, context, "den3select.png", 0, 0);
				mEngine.getTextureManager().loadTexture(this.ttChess);
				// imgChess = new Sprite(Cot * 54 + 22, Hang * 54 + 28,
				// ttRegionChess);
			}
			if (Ten == "4") {
				this.ttChess = new Texture(64, 64,
						TextureOptions.BILINEAR_PREMULTIPLYALPHA);
				this.ttRegionChess = TextureRegionFactory.createFromAsset(
						this.ttChess, context, "den4select.png", 0, 0);
				mEngine.getTextureManager().loadTexture(this.ttChess);
				// imgChess = new Sprite(Cot * 54 + 22, Hang * 54 + 28,
				// ttRegionChess);
			}
			if (Ten == "5") {
				this.ttChess = new Texture(64, 64,
						TextureOptions.BILINEAR_PREMULTIPLYALPHA);
				this.ttRegionChess = TextureRegionFactory.createFromAsset(
						this.ttChess, context, "den5select.png", 0, 0);
				mEngine.getTextureManager().loadTexture(this.ttChess);
				// imgChess = new Sprite(Cot * 54 + 22, Hang * 54 + 28,
				// ttRegionChess);
			}
			if (Ten == "6") {
				this.ttChess = new Texture(64, 64,
						TextureOptions.BILINEAR_PREMULTIPLYALPHA);
				this.ttRegionChess = TextureRegionFactory.createFromAsset(
						this.ttChess, context, "den6select.png", 0, 0);
				mEngine.getTextureManager().loadTexture(this.ttChess);
				// imgChess = new Sprite(Cot * 54 + 22, Hang * 54 + 28,
				// ttRegionChess);
			}
			if (Ten == "7") {
				this.ttChess = new Texture(64, 64,
						TextureOptions.BILINEAR_PREMULTIPLYALPHA);
				this.ttRegionChess = TextureRegionFactory.createFromAsset(
						this.ttChess, context, "den7select.png", 0, 0);
				mEngine.getTextureManager().loadTexture(this.ttChess);
				// imgChess = new Sprite(Cot * 54 + 22, Hang * 54 + 28,
				// ttRegionChess);
			}
			if (Ten == "8") {
				this.ttChess = new Texture(64, 64,
						TextureOptions.BILINEAR_PREMULTIPLYALPHA);
				this.ttRegionChess = TextureRegionFactory.createFromAsset(
						this.ttChess, context, "den8select.png", 0, 0);
				mEngine.getTextureManager().loadTexture(this.ttChess);
				// imgChess = new Sprite(Cot * 54 + 22, Hang * 54 + 28,
				// ttRegionChess);
			}
			if (Ten == "9") {
				this.ttChess = new Texture(64, 64,
						TextureOptions.BILINEAR_PREMULTIPLYALPHA);
				this.ttRegionChess = TextureRegionFactory.createFromAsset(
						this.ttChess, context, "den8select.png", 0, 0);
				mEngine.getTextureManager().loadTexture(this.ttChess);
				
			}
		}
		imgChess = new Sprite(Cot * 54 + 22, Hang * 54 + 28, ttRegionChess);
	}
	
	/**
	 * Xac dinh vi tri di chuyen duoc cua quan co
	 * 
	 * @param i
	 *            cot
	 * @param j
	 *            hang
	 * @param n
	 *            so buoc di chuyen duoc cua quan co
	 */
	
	public void move(int i, int j, int n) {
		
		if (i >= 0 && i <= 8 && j >= 0 && j <= 10)
			turn = false;
		for (int x = 1; x <= n; x++) {
			
			if ((j == Hang - x && i == Cot - x)
					|| (j == Hang - x && i == Cot + x)) {
				if (GameBoard.ViTri[i][j].Trong == true)
					turn = true;
				// huong phia tren ben trai
				if (j < Hang && i < Cot) {
					int k, l;
					for (k = Hang - 1, l = Cot - 1; k >= j && l >= i; k--, l--) {
						if (GameBoard.ViTri[l][k].Trong == false) {
							turn = false;
							break;
						}
					}
				}
				// huong phia tren ben phai
				if (j < Hang && i > Cot) {
					int k, l;
					for (k = Hang - 1, l = Cot + 1; k >= j && l <= i; k--, l++) {
						if (GameBoard.ViTri[l][k].Trong == false) {
							turn = false;
							break;
						}
					}
				}
			}
			
			if ((j == Hang + x && i == Cot - x)
					|| (j == Hang + x && i == Cot + x)) {
				if (GameBoard.ViTri[i][j].Trong == true)
					turn = true;
				// cheo duoi trai
				if (j > Hang && i > Cot) {
					int k, l;
					for (k = Hang + 1, l = Cot + 1; k <= j && l <= i; k++, l++) {
						if (GameBoard.ViTri[l][k].Trong == false) {
							turn = false;
							break;
						}
					}
				}
				// cheo duoi phai
				if (j > Hang && i < Cot) {
					int k, l;
					for (k = Hang + 1, l = Cot - 1; k <= j && l >= i; k++, l--) {
						if (GameBoard.ViTri[l][k].Trong == false) {
							turn = false;
							break;
						}
					}
				}
			}
			// xet huong di thang theo hang
			if ((j == Hang - x && i == Cot) || (j == Hang + x && i == Cot)) {
				if (GameBoard.ViTri[i][j].Trong == true)
					turn = true;
				if (j > Hang)
					for (int k = Hang + 1; k <= j; k++) {
						
						if (GameBoard.ViTri[i][k].Trong == false) {
							turn = false;
							break;
						}
					}
				if (j < Hang)
					for (int k = j + 1; k <= Hang - 1; k++) {
						if (GameBoard.ViTri[i][k].Trong == false) {
							turn = false;
							break;
						}
					}
				
			}
			// xet huong di thang theo cot
			if ((j == Hang && i == Cot - x) || (j == Hang && i == Cot + x)) {
				//
				if (GameBoard.ViTri[i][j].Trong == true)
					turn = true;
				//
				if (i > Cot)
					for (int k = Cot + 1; k <= i; k++) {
						if (GameBoard.ViTri[k][j].Trong == false) {
							turn = false;
							break;
						}
					}
				if (i < Cot)
					for (int k = i + 1; k <= Cot - 1; k++) {
						if (GameBoard.ViTri[k][j].Trong == false) {
							turn = false;
							break;
						}
					}
			}
			
		}
	}
	
	/**
	 * Lay gia tri cua quan co trai vi tri[i][j]
	 * 
	 * @param i
	 * @param j
	 * @return
	 */
	public int GiaTri(int i, int j) {
		if (GameBoard.ViTri[i][j].Ten .equalsIgnoreCase( "0"))
			return 0;
		if (GameBoard.ViTri[i][j].Ten .equalsIgnoreCase( "1"))
			return 1;
		if (GameBoard.ViTri[i][j].Ten .equalsIgnoreCase( "2"))
			return 2;
		if (GameBoard.ViTri[i][j].Ten .equalsIgnoreCase( "3"))
			return 3;
		if (GameBoard.ViTri[i][j].Ten .equalsIgnoreCase( "4"))
			return 4;
		if (GameBoard.ViTri[i][j].Ten .equalsIgnoreCase( "5"))
			return 5;
		if (GameBoard.ViTri[i][j].Ten .equalsIgnoreCase( "6"))
			return 6;
		if (GameBoard.ViTri[i][j].Ten .equalsIgnoreCase( "7"))
			return 7;
		if (GameBoard.ViTri[i][j].Ten .equalsIgnoreCase( "8"))
			return 8;
		if (GameBoard.ViTri[i][j].Ten .equalsIgnoreCase( "9"))
			return 9;
		else
			return 0;
	}
	
	/**
	 * Xac dinh an quan theo huong cheo len trai
	 * 
	 * @param i
	 *            cot
	 * @param j
	 *            hang
	 */
	public void XDAnQuan1(int i, int j) {
		if (j == Hang - 2 && i == Cot - 2) {
			turn = true;
		} else {
			// kiem tra khong co quan chan trong nuoc an quan
			for (int k = Hang - 2, l = Cot - 2; k > j && l > i; k--, l--) {
				if (GameBoard.ViTri[l][k].Trong == false) {
					turn = false;
					break;
				} else
					turn = true;
			}
		}
	}
	
	/**
	 * Xac dinh an quan theo huong cheo len phai
	 * 
	 * @param i
	 *            cot
	 * @param j
	 *            hang
	 */
	public void XDAnQuan2(int i, int j) {
		if (j == Hang - 2 && i == Cot + 2) {
			turn = true;
		} else {
			for (int k = Hang - 2, l = Cot + 2; k > j && l < i; k--, l++) {
				if (GameBoard.ViTri[l][k].Trong == false) {
					turn = false;
					break;
				} else
					turn = true;
			}
		}
	}
	
	/**
	 * Xac dinh an quan theo huong cheo xuong phai
	 * 
	 * @param i
	 *            cot
	 * @param j
	 *            hang
	 */
	public void XDAnQuan3(int i, int j) {
		if (j == Hang + 2 && i == Cot + 2) {
			turn = true;
		} else {
			for (int k = Hang + 2, l = Cot + 2; k < j && l < i; k++, l++) {
				if (GameBoard.ViTri[l][k].Trong == false) {
					turn = false;
					break;
				} else
					turn = true;
			}
		}
	}
	
	/**
	 * Xac dinh an quan theo huong cheo xuong trai
	 * 
	 * @param i
	 *            cot
	 * @param j
	 *            hang
	 */
	public void XDAnQuan4(int i, int j) {
		if (j == Hang + 2 && i == Cot - 2) {
			turn = true;
		} else {
			for (int k = Hang + 2, l = Cot - 2; k < j && l > i; k++, l--) {
				if (GameBoard.ViTri[l][k].Trong == false) {
					turn = false;
					break;
				} else
					turn = true;
			}
		}
	}
	
	/**
	 * Xac dinh an quan theo huong cheo xuong duoi
	 * 
	 * @param i
	 *            cot
	 * @param j
	 *            hang
	 */
	public void XDAnQuan5(int i, int j) {
		if (j == Hang + 2 && i == Cot) {
			turn = true;
		} else {
			for (int k = Hang + 2; k < j; k++) {
				if (GameBoard.ViTri[i][k].Trong == false) {
					turn = false;
					break;
				} else
					turn = true;
			}
		}
	}
	
	/**
	 * Xac dinh an quan theo huong len tren
	 * 
	 * @param i
	 *            cot
	 * @param j
	 *            hang
	 */
	public void XDAnQuan6(int i, int j) {
		if (j == Hang - 2 && i == Cot) {
			turn = true;
		} else {
			for (int k = j + 1; k <= Hang - 2; k++) {
				if (GameBoard.ViTri[i][k].Trong == false) {
					turn = false;
					break;
				} else
					turn = true;
			}
		}
	}
	
	/**
	 * Xac dinh an quan theo huong sang phai
	 * 
	 * @param i
	 *            cot
	 * @param j
	 *            hang
	 */
	public void XDAnQuan7(int i, int j) {
		if (j == Hang && i == Cot + 2) {
			turn = true;
		} else {
			for (int k = Cot + 2; k < i; k++) {
				if (GameBoard.ViTri[k][j].Trong == false) {
					turn = false;
					break;
				} else
					turn = true;
			}
		}
	}
	
	/**
	 * Xac dinh an quan theo huong sang trai
	 * 
	 * @param i
	 *            cot
	 * @param j
	 *            hang
	 */
	public void XDAnQuan8(int i, int j) {
		if (j == Hang && i == Cot - 2) {
			turn = true;
		} else {
			for (int k = i + 1; k <= Cot - 2; k++) {
				if (GameBoard.ViTri[k][j].Trong == false) {
					turn = false;
					break;
				} else
					turn = true;
			}
		}
	}
	
	/**
	 * Vi tri an duoc cua quan co
	 * 
	 * @param i
	 *            cot
	 * @param j
	 *            hang
	 * @param result_Add
	 *            ket qua phep cong
	 * @param result_Add_Div
	 *            ket qua phep chia
	 * @param result_Add_Mul
	 *            ket qua phep nhan
	 * @param result_Sub
	 *            ket qua phep tru
	 * @param result_Du
	 *            ket qua phep du
	 */
	public void pointEatChess(int i, int j, int result_Add, int result_Add_Div,
			int result_Add_Mul, int result_Sub, int result_Du) {
		int pc = 0, pt = 0, pn = 0, pch = 0, pd = 0;
		// xac dinh vi tri duoc an cua quan co
		if ((j == Hang - result_Add && i == Cot)
				|| (j == Hang + result_Add && i == Cot)
				|| (j == Hang && i == Cot - result_Add)
				|| (j == Hang && i == Cot + result_Add)
				|| (j == Hang - result_Add && i == Cot - result_Add)
				|| (j == Hang - result_Add && i == Cot + result_Add)
				|| (j == Hang + result_Add && i == Cot - result_Add)
				|| (j == Hang + result_Add && i == Cot + result_Add)
				|| (j == Hang - result_Add_Div && i == Cot)
				|| (j == Hang + result_Add_Div && i == Cot)
				|| (j == Hang && i == Cot - result_Add_Div)
				|| (j == Hang && i == Cot + result_Add_Div)
				|| (j == Hang - result_Add_Div && i == Cot - result_Add_Div)
				|| (j == Hang - result_Add_Div && i == Cot + result_Add_Div)
				|| (j == Hang + result_Add_Div && i == Cot - result_Add_Div)
				|| (j == Hang + result_Add_Div && i == Cot + result_Add_Div)
				|| (j == Hang - result_Add_Mul && i == Cot)
				|| (j == Hang + result_Add_Mul && i == Cot)
				|| (j == Hang && i == Cot - result_Add_Mul)
				|| (j == Hang && i == Cot + result_Add_Mul)
				|| (j == Hang - result_Add_Mul && i == Cot - result_Add_Mul)
				|| (j == Hang - result_Add_Mul && i == Cot + result_Add_Mul)
				|| (j == Hang + result_Add_Mul & i == Cot - result_Add_Mul)
				|| (j == Hang + result_Add_Mul && i == Cot + result_Add_Mul)
				|| (j == Hang - result_Sub && i == Cot)
				|| (j == Hang + result_Sub && i == Cot)
				|| (j == Hang && i == Cot - result_Sub)
				|| (j == Hang && i == Cot + result_Sub)
				|| (j == Hang - result_Sub && i == Cot - result_Sub)
				|| (j == Hang - result_Sub && i == Cot + result_Sub)
				|| (j == Hang + result_Sub && i == Cot - result_Sub)
				|| (j == Hang + result_Sub && i == Cot + result_Sub)
				|| (j == Hang - result_Du && i == Cot)
				|| (j == Hang + result_Du && i == Cot)
				|| (j == Hang && i == Cot - result_Du)
				|| (j == Hang && i == Cot + result_Du)
				|| (j == Hang - result_Du && i == Cot - result_Du)
				|| (j == Hang - result_Du && i == Cot + result_Du)
				|| (j == Hang + result_Du && i == Cot - result_Du)
				|| (j == Hang + result_Du && i == Cot + result_Du)) {
			// kiem ra dieu kien duoc an
			if (GameBoard.ViTri[i][j].Trong == false) {
				if (GameBoard.ViTri[i][j].Phe != this.Phe) {
					if ((j == Hang - result_Add && i == Cot)
							|| (j == Hang + result_Add && i == Cot)
							|| (j == Hang && i == Cot - result_Add)
							|| (j == Hang && i == Cot + result_Add)
							|| (j == Hang - result_Add && i == Cot - result_Add)
							|| (j == Hang - result_Add && i == Cot + result_Add)
							|| (j == Hang + result_Add && i == Cot - result_Add)
							|| (j == Hang + result_Add && i == Cot + result_Add))
						pc = 1;
					if ((j == Hang - result_Add_Div && i == Cot)
							|| (j == Hang + result_Add_Div && i == Cot)
							|| (j == Hang && i == Cot - result_Add_Div)
							|| (j == Hang && i == Cot + result_Add_Div)
							|| (j == Hang - result_Add_Div && i == Cot
									- result_Add_Div)
							|| (j == Hang - result_Add_Div && i == Cot
									+ result_Add_Div)
							|| (j == Hang + result_Add_Div && i == Cot
									- result_Add_Div)
							|| (j == Hang + result_Add_Div && i == Cot
									+ result_Add_Div))
						pch = 1;
					if ((j == Hang - result_Add_Mul && i == Cot)
							|| (j == Hang + result_Add_Mul && i == Cot)
							|| (j == Hang && i == Cot - result_Add_Mul)
							|| (j == Hang && i == Cot + result_Add_Mul)
							|| (j == Hang - result_Add_Mul && i == Cot
									- result_Add_Mul)
							|| (j == Hang - result_Add_Mul && i == Cot
									+ result_Add_Mul)
							|| (j == Hang + result_Add_Mul & i == Cot
									- result_Add_Mul)
							|| (j == Hang + result_Add_Mul && i == Cot
									+ result_Add_Mul))
						pn = 1;
					if ((j == Hang - result_Sub && i == Cot)
							|| (j == Hang + result_Sub && i == Cot)
							|| (j == Hang && i == Cot - result_Sub)
							|| (j == Hang && i == Cot + result_Sub)
							|| (j == Hang - result_Sub && i == Cot - result_Sub)
							|| (j == Hang - result_Sub && i == Cot + result_Sub)
							|| (j == Hang + result_Sub && i == Cot - result_Sub)
							|| (j == Hang + result_Sub && i == Cot + result_Sub))
						pt = 1;
					if ((j == Hang - result_Du && i == Cot)
							|| (j == Hang + result_Du && i == Cot)
							|| (j == Hang && i == Cot - result_Du)
							|| (j == Hang && i == Cot + result_Du)
							|| (j == Hang - result_Du && i == Cot - result_Du)
							|| (j == Hang - result_Du && i == Cot + result_Du)
							|| (j == Hang + result_Du && i == Cot - result_Du)
							|| (j == Hang + result_Du && i == Cot + result_Du))
						pd = 1;
					
					// huong xet
					// cheo len trai
					if (j < Hang && i < Cot) {
						if (GameBoard.ViTri[Cot - 1][Hang - 1].Trong == false) {
							if (GameBoard.ViTri[Cot - 1][Hang - 1].Phe == this.Phe) {
								resultEat(GiaTri, GiaTri(Cot - 1, Hang - 1));
								if (pc == 1 && c == result_Add && c > 1)
									XDAnQuan1(i, j);
								if (pt == 1 && t == result_Sub && t > 1)
									XDAnQuan1(i, j);
								if (pn == 1 && n == result_Add_Mul && n > 1)
									XDAnQuan1(i, j);
								if (pch == 1 && ch == result_Add_Div && ch > 1)
									XDAnQuan1(i, j);
								if (pd == 1 && d == result_Du && d > 1)
									XDAnQuan1(i, j);
							}
						}
					}
					// cheo len phai
					if (j < Hang && i > Cot) {
						if (GameBoard.ViTri[Cot + 1][Hang - 1].Trong == false) {
							if (GameBoard.ViTri[Cot + 1][Hang - 1].Phe == this.Phe) {
								resultEat(GiaTri, GiaTri(Cot + 1, Hang - 1));
								if (pc == 1 && c == result_Add && c > 1)
									XDAnQuan2(i, j);
								if (pt == 1 && t == result_Sub && t > 1)
									XDAnQuan2(i, j);
								if (pn == 1 && n == result_Add_Mul && n > 1)
									XDAnQuan2(i, j);
								if (pch == 1 && ch == result_Add_Div && ch > 1)
									XDAnQuan2(i, j);
								if (pd == 1 && d == result_Du && d > 1)
									XDAnQuan2(i, j);
							}
						}
					}
					// cheo xuong phai
					if (j > Hang && i > Cot) {
						if (GameBoard.ViTri[Cot + 1][Hang + 1].Trong == false) {
							if (GameBoard.ViTri[Cot + 1][Hang + 1].Phe == this.Phe) {
								resultEat(GiaTri, GiaTri(Cot + 1, Hang + 1));
								if (pc == 1 && c == result_Add && c > 1)
									XDAnQuan3(i, j);
								if (pt == 1 && t == result_Sub && t > 1)
									XDAnQuan3(i, j);
								if (pn == 1 && n == result_Add_Mul && n > 1)
									XDAnQuan3(i, j);
								if (pch == 1 && ch == result_Add_Div && ch > 1)
									XDAnQuan3(i, j);
								if (pd == 1 && d == result_Du && d > 1)
									XDAnQuan3(i, j);
							}
						}
					}
					// cheo xuong trai
					if (j > Hang && i < Cot) {
						if (GameBoard.ViTri[Cot - 1][Hang + 1].Trong == false) {
							if (GameBoard.ViTri[Cot - 1][Hang + 1].Phe == this.Phe) {
								resultEat(GiaTri, GiaTri(Cot - 1, Hang + 1));
								if (pc == 1 && c == result_Add && c > 1)
									XDAnQuan4(i, j);
								if (pt == 1 && t == result_Sub && t > 1)
									XDAnQuan4(i, j);
								if (pn == 1 && n == result_Add_Mul && n > 1)
									XDAnQuan4(i, j);
								if (pch == 1 && ch == result_Add_Div && ch > 1)
									XDAnQuan4(i, j);
								if (pd == 1 & d == result_Du && d > 1)
									XDAnQuan4(i, j);
							}
						}
					}
					// xuong duoi
					if (j > Hang && i == Cot) {
						if (GameBoard.ViTri[Cot][Hang + 1].Trong == false) {
							if (GameBoard.ViTri[Cot][Hang + 1].Phe == this.Phe) {
								resultEat(GiaTri, GiaTri(Cot, Hang + 1));
								if (pc == 1 && c == result_Add && c > 1)
									XDAnQuan5(i, j);
								if (pt == 1 && t == result_Sub && t > 1)
									XDAnQuan5(i, j);
								if (pn == 1 && n == result_Add_Mul && n > 1)
									XDAnQuan5(i, j);
								if (pch == 1 && ch == result_Add_Div && ch > 1)
									XDAnQuan5(i, j);
								if (pd == 1 && d == result_Du && d > 1)
									XDAnQuan5(i, j);
							}
						}
					}
					// len tren
					if (j < Hang && i == Cot) {
						if (GameBoard.ViTri[Cot][Hang - 1].Trong == false) {
							if (GameBoard.ViTri[Cot][Hang - 1].Phe == this.Phe) {
								resultEat(GiaTri, GiaTri(Cot, Hang - 1));
								if (pc == 1 && c == result_Add && c > 1)
									XDAnQuan6(i, j);
								if (pt == 1 && t == result_Sub && t > 1)
									XDAnQuan6(i, j);
								if (pn == 1 && n == result_Add_Mul && n > 1)
									XDAnQuan6(i, j);
								if (pch == 1 && ch == result_Add_Div && ch > 1)
									XDAnQuan6(i, j);
								if (pd == 1 && d == result_Du && d > 1)
									XDAnQuan6(i, j);
							}
						}
					}
					// sang phai
					if (j == Hang && i > Cot) {
						if (GameBoard.ViTri[Cot + 1][Hang].Trong == false) {
							if (GameBoard.ViTri[Cot + 1][Hang].Phe == this.Phe) {
								resultEat(GiaTri, GiaTri(Cot + 1, Hang));
								if (pc == 1 && c == result_Add && c > 1)
									XDAnQuan7(i, j);
								if (pt == 1 && t == result_Sub && t > 1)
									XDAnQuan7(i, j);
								if (pn == 1 && n == result_Add_Mul && n > 1)
									XDAnQuan7(i, j);
								if (pch == 1 && ch == result_Add_Div && ch > 1)
									XDAnQuan7(i, j);
								if (pd == 1 && d == result_Du && d > 1)
									XDAnQuan7(i, j);
							}
						}
					}
					// sang trai
					if (j == Hang && i < Cot) {
						if (GameBoard.ViTri[Cot - 1][Hang].Trong == false) {
							if (GameBoard.ViTri[Cot - 1][Hang].Phe == this.Phe) {
								// int ch = 0, c = 0, t = 0, n = 0, d = 0;
								resultEat(GiaTri, GiaTri(Cot - 1, Hang));
								if (pc == 1 && c == result_Add && c > 1)
									XDAnQuan8(i, j);
								if (pt == 1 && t == result_Sub && t > 1)
									XDAnQuan8(i, j);
								if (pn == 1 && n == result_Add_Mul && n > 1)
									XDAnQuan8(i, j);
								if (pch == 1 && ch == result_Add_Div && ch > 1)
									XDAnQuan8(i, j);
								if (pd == 1 && d == result_Du && d > 1)
									XDAnQuan8(i, j);
							}
						}
					}
				}
			}
		}
	}
	
	/**
	 * Xac dinh cac gia tri cong, tru, nhan, chia, phep du
	 * 
	 * @param x
	 *            gia tri 1 (quan co tham chieu den)
	 * @param y
	 *            gia tri 2 (quan co lam buoc dem)
	 */
	private void resultEat(int x, int y) {
		if (x > y) {
			t = (x - y) + 1;
			c = (x + y);
			{
				if (c >= 10) {
					c = (c - 10) + 1;
				} else
					c = c + 1;
			}
			if (y != 0) {
				ch = ((x / y)) + 1;
				d = (x % y) + 1;
			}
			n = ((x * y));
			if (n > 10) {
				n = (n % 10) + 1;
			} else
				n = n + 1;
		}
		if (x < y) {
			int temp = y + x;
			if (temp > 10) {
				c = (temp - 10) + 1;
			} else
				c = temp + 1;
			if (y != 0) {
				ch = ((x / y)) + 1;
				d = (x % y) + 1;
			}
			n = ((x * y));
			if (n > 10) {
				n = (n % 10) + 1;
			} else
				n = n + 1;
		}
	}
	
	/**
	 * Xac dinh toan bo vi tri [i][j] di duoc cua quan co ke ca nuoc di an quan
	 * do
	 * 
	 * @param i
	 *            cot
	 * @param j
	 *            hang
	 * @param gtri
	 *            so buoc co the di
	 */
	public void valueChess(int i, int j, int gtri) {
		move(i, j, gtri);
		for (int m = 0; m <= 8; m++) {
			for (int n = 0; n <= 10; n++) { // xac dinh co quan ke vs
											// this.quanco
				if ((n == Hang - 1 && m == Cot) || (n == Hang + 1 && m == Cot)
						|| (n == Hang && m == Cot - 1)
						|| (n == Hang && m == Cot + 1)
						|| (n == Hang - 1 && m == Cot - 1)
						|| (n == Hang - 1 && m == Cot + 1)
						|| (n == Hang + 1 && m == Cot - 1)
						|| (n == Hang + 1 && m == Cot + 1)) {
					if (GameBoard.ViTri[m][n].Trong == false) {
						if (GameBoard.ViTri[m][n].Phe == this.Phe) {
							
							index2 = gtri;
							if (GameBoard.ViTri[m][n].Ten.equalsIgnoreCase("0"))
								index1 = 0;
							if (GameBoard.ViTri[m][n].Ten .equalsIgnoreCase( "1"))
								index1 = 1;
							if (GameBoard.ViTri[m][n].Ten .equalsIgnoreCase( "2"))
								index1 = 2;
							if (GameBoard.ViTri[m][n].Ten .equalsIgnoreCase( "3"))
								index1 = 3;
							if (GameBoard.ViTri[m][n].Ten .equalsIgnoreCase( "4"))
								index1 = 4;
							if (GameBoard.ViTri[m][n].Ten .equalsIgnoreCase( "5"))
								index1 = 5;
							if (GameBoard.ViTri[m][n].Ten .equalsIgnoreCase( "6"))
								index1 = 6;
							if (GameBoard.ViTri[m][n].Ten .equalsIgnoreCase( "7"))
								index1 = 7;
							if (GameBoard.ViTri[m][n].Ten .equalsIgnoreCase( "8"))
								index1 = 8;
							if (GameBoard.ViTri[m][n].Ten .equalsIgnoreCase( "9"))
								index1 = 9;
							
							if (index2 > index1) {
								result_Sub = (index2 - index1) + 1;
								
								result_Add = (index2 + index1);
								{
									if (result_Add >= 10) {
										result_Add = (result_Add - 10) + 1;
									} else
										result_Add = result_Add + 1;
								}
								if (index1 != 0) {
									result_Add_Div = (index2 / index1) + 1;
									result_Du = (index2 % index1) + 1;
								}
								result_Add_Mul = ((index2 * index1));
								if (result_Add_Mul > 10) {
									result_Add_Mul = (result_Add_Mul % 10) + 1;
								} else
									result_Add_Mul = result_Add_Mul + 1;
								pointEatChess(i, j, result_Add, result_Add_Div,
										result_Add_Mul, result_Sub, result_Du);
							}
							if (index2 < index1) {
								int temp = index1 + index2;
								if (temp > 10) {
									result_Add = (temp - 10) + 1;
								} else
									result_Add = temp + 1;
								if (index1 != 0) {
									result_Add_Div = (index2 / index1) + 1;
									result_Du = (index2 % index1) + 1;
								}
								result_Add_Mul = ((index2 * index1));
								if (result_Add_Mul > 10) {
									result_Add_Mul = (result_Add_Mul % 10) + 1;
								} else
									result_Add_Mul = result_Add_Mul + 1;
								pointEatChess(i, j, result_Add, result_Add_Div,
										result_Add_Mul, result_Sub, result_Du);
							}
							
						}
					}
				}
			}
		}
		
	}
}
