package hl.game.cotoan;

import hl.game.model.OCo;
import hl.game.model.VanCo;
import hl.game.quanco.QuanCo;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.Scene.IOnSceneTouchListener;
import org.anddev.andengine.entity.scene.background.AutoParallaxBackground;
import org.anddev.andengine.entity.scene.background.ParallaxBackground.ParallaxEntity;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.entity.util.FPSLogger;
import org.anddev.andengine.input.touch.TouchEvent;
import org.anddev.andengine.opengl.texture.Texture;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.texture.region.TextureRegionFactory;
import org.anddev.andengine.sensor.accelerometer.AccelerometerData;
import org.anddev.andengine.sensor.accelerometer.IAccelerometerListener;
import org.anddev.andengine.ui.activity.BaseGameActivity;

public class GameBoard extends BaseGameActivity implements
        IOnSceneTouchListener, IAccelerometerListener {
    public static final int CAMERA_WIDTH = 529;
    public static final int CAMERA_HEIGHT = 646;
    private Camera mCamera;
    public static Scene scene;
    public static OCo[][] ViTri = new OCo[10][12];
    public static OCo pointChessMove = new OCo();
    // backgroud
    private Texture ttBackground;
    private TextureRegion ttRegionBackground;

    // Image canmove
    private Texture ttCanMove;
    private TextureRegion ttRegionCanMove;

    // public Engine mEngine;
    public static Engine engine;

    public static int tempHang = 0, tempCot = 0;
    public static int tempIndexHang = 0, tempIndexCot = 0;
    public static QuanCo chessIndex;

    @Override
    public Engine getEngine() {
        engine = super.getEngine();
        return super.getEngine();
    }

    @Override
    public Engine onLoadEngine() {
        this.mCamera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
        return new Engine(new EngineOptions(true, ScreenOrientation.PORTRAIT,
                new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT),
                this.mCamera));
    }

    @Override
    public void onLoadResources() {
        TextureRegionFactory.setAssetBasePath("data/");
        engine = super.getEngine();
        this.ttBackground = new Texture(1024, 1024,
                TextureOptions.BILINEAR_PREMULTIPLYALPHA);
        this.ttRegionBackground = TextureRegionFactory.createFromAsset(
                this.ttBackground, this, "banco.png", 0, 0);
        this.mEngine.getTextureManager().loadTexture(this.ttBackground);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 11; j++) {
                ViTri[i][j] = new OCo();
            }
        }
        VanCo.addChess(mEngine, this);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 11; j++) {
                if (ViTri[i][j].Trong) {
                    ViTri[i][j].createCanMove(i, j, true, "", 0);
                    ViTri[i][j].loadResources(engine, this);
                } else {
                    ViTri[i][j].createCanMove(i, j, false, ViTri[i][j].Ten,
                            ViTri[i][j].Phe);
                    ViTri[i][j].loadResources(engine, this);
                }
            }
        }

    }

    @Override
    public Scene onLoadScene() {
        this.mEngine.registerUpdateHandler(new FPSLogger());

        scene = new Scene();
        final AutoParallaxBackground autoParallaxBackground = new AutoParallaxBackground(
                0, 0, 0, 5);
        autoParallaxBackground.attachParallaxEntity(new ParallaxEntity(0.0f,
                new Sprite(0, CAMERA_HEIGHT
                        - this.ttRegionBackground.getHeight(),
                        this.ttRegionBackground)));

        scene.setBackground(autoParallaxBackground);

        // scene.setOnSceneTouchListenerBindingEnabled(false);
        scene.setOnSceneTouchListener(this);
        scene.setTouchAreaBindingEnabled(false);
        scene.setOnSceneTouchListener(new IOnSceneTouchListener() {
            @Override
            public boolean onSceneTouchEvent(Scene pScene,
                                             TouchEvent pSceneTouchEvent) {

                resetCanMove();
                System.out.println("EVENT TOUCH SCENE!!!");

                return false;
            }
        });

        updatePointChess(scene);
        addChess();
        registerSprite();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 11; j++) {
                ViTri[i][j].drawCanMove(engine, this, i, j);
                scene.attachChild(ViTri[i][j].imgCanMove);
            }
        }

        return scene;
    }

    public void updatePointChess(final Scene mScene) {
        mScene.registerUpdateHandler(new IUpdateHandler() {

            @Override
            public void reset() {
                // TODO Auto-generated method stub

            }

            @Override
            public void onUpdate(float pSecondsElapsed) {
                if (QuanCo.isMove) {
                    QuanCo.DanhDau.imgChess
                            .setPosition(QuanCo.tempCot * 54 + 22,
                                    QuanCo.tempHang * 54 + 28);
                    QuanCo.isMove = false;
                    System.out.println("AAAAAAAAAAAAAAAAAAAAA");
                    ViTri[QuanCo.tempCot][QuanCo.tempHang].Ten = QuanCo.DanhDau.Ten;
                    ViTri[QuanCo.tempCot][QuanCo.tempHang].Phe = QuanCo.DanhDau.Phe;
                    ViTri[QuanCo.tempCot][QuanCo.tempHang].Trong = false;
                    resetBoardChess();
                }

            }
        });

    }

    public void removeSprite1(final Sprite _sprite) {
        runOnUpdateThread(new Runnable() {

            @Override
            public void run() {
                scene.detachChild(_sprite);
            }
        });
        // it.remove();
    }

    @Override
    public void onLoadComplete() {

    }

    public void addChess() {

        // draw image canmove
        VanCo.NguoiChoi[0].q0.drawChess();
        VanCo.NguoiChoi[0].q1.drawChess();
        VanCo.NguoiChoi[0].q2.drawChess();
        VanCo.NguoiChoi[0].q3.drawChess();
        VanCo.NguoiChoi[0].q4.drawChess();
        VanCo.NguoiChoi[0].q5.drawChess();
        VanCo.NguoiChoi[0].q6.drawChess();
        VanCo.NguoiChoi[0].q7.drawChess();
        VanCo.NguoiChoi[0].q8.drawChess();
        VanCo.NguoiChoi[0].q9.drawChess();
        VanCo.NguoiChoi[1].q0.drawChess();
        VanCo.NguoiChoi[1].q1.drawChess();
        VanCo.NguoiChoi[1].q2.drawChess();
        VanCo.NguoiChoi[1].q3.drawChess();
        VanCo.NguoiChoi[1].q4.drawChess();
        VanCo.NguoiChoi[1].q5.drawChess();
        VanCo.NguoiChoi[1].q6.drawChess();
        VanCo.NguoiChoi[1].q7.drawChess();
        VanCo.NguoiChoi[1].q8.drawChess();
        VanCo.NguoiChoi[1].q9.drawChess();

        // Draw image to scene
        // Add Chess to Scene
        scene.attachChild(VanCo.NguoiChoi[0].q0.imgChess);
        scene.attachChild(VanCo.NguoiChoi[0].q1.imgChess);
        scene.attachChild(VanCo.NguoiChoi[0].q2.imgChess);
        scene.attachChild(VanCo.NguoiChoi[0].q3.imgChess);
        scene.attachChild(VanCo.NguoiChoi[0].q4.imgChess);
        scene.attachChild(VanCo.NguoiChoi[0].q5.imgChess);
        scene.attachChild(VanCo.NguoiChoi[0].q6.imgChess);
        scene.attachChild(VanCo.NguoiChoi[0].q7.imgChess);
        scene.attachChild(VanCo.NguoiChoi[0].q8.imgChess);
        scene.attachChild(VanCo.NguoiChoi[0].q9.imgChess);
        scene.attachChild(VanCo.NguoiChoi[1].q0.imgChess);
        scene.attachChild(VanCo.NguoiChoi[1].q1.imgChess);
        scene.attachChild(VanCo.NguoiChoi[1].q2.imgChess);
        scene.attachChild(VanCo.NguoiChoi[1].q3.imgChess);
        scene.attachChild(VanCo.NguoiChoi[1].q4.imgChess);
        scene.attachChild(VanCo.NguoiChoi[1].q5.imgChess);
        scene.attachChild(VanCo.NguoiChoi[1].q6.imgChess);
        scene.attachChild(VanCo.NguoiChoi[1].q7.imgChess);
        scene.attachChild(VanCo.NguoiChoi[1].q8.imgChess);
        scene.attachChild(VanCo.NguoiChoi[1].q9.imgChess);

    }

    public static void registerSprite() {
        // Regestry Event Touch on Image Chess
        scene.registerTouchArea(VanCo.NguoiChoi[0].q0.imgChess);
        scene.registerTouchArea(VanCo.NguoiChoi[0].q1.imgChess);
        scene.registerTouchArea(VanCo.NguoiChoi[0].q2.imgChess);
        scene.registerTouchArea(VanCo.NguoiChoi[0].q3.imgChess);
        scene.registerTouchArea(VanCo.NguoiChoi[0].q4.imgChess);
        scene.registerTouchArea(VanCo.NguoiChoi[0].q5.imgChess);
        scene.registerTouchArea(VanCo.NguoiChoi[0].q6.imgChess);
        scene.registerTouchArea(VanCo.NguoiChoi[0].q7.imgChess);
        scene.registerTouchArea(VanCo.NguoiChoi[0].q8.imgChess);
        scene.registerTouchArea(VanCo.NguoiChoi[0].q9.imgChess);
        scene.registerTouchArea(VanCo.NguoiChoi[1].q0.imgChess);
        scene.registerTouchArea(VanCo.NguoiChoi[1].q1.imgChess);
        scene.registerTouchArea(VanCo.NguoiChoi[1].q2.imgChess);
        scene.registerTouchArea(VanCo.NguoiChoi[1].q3.imgChess);
        scene.registerTouchArea(VanCo.NguoiChoi[1].q4.imgChess);
        scene.registerTouchArea(VanCo.NguoiChoi[1].q5.imgChess);
        scene.registerTouchArea(VanCo.NguoiChoi[1].q6.imgChess);
        scene.registerTouchArea(VanCo.NguoiChoi[1].q7.imgChess);
        scene.registerTouchArea(VanCo.NguoiChoi[1].q8.imgChess);
        scene.registerTouchArea(VanCo.NguoiChoi[1].q9.imgChess);
    }

    /**
     * Dinh dang lai ban co
     */
    public static void resetBoardChess() {
        for (int i = 0; i <= 8; i++) {
            for (int j = 0; j <= 10; j++) {
                if (GameBoard.ViTri[i][j].Trong == true) {
                    GameBoard.ViTri[i][j].Hang = j;
                    GameBoard.ViTri[i][j].Cot = i;
                    GameBoard.ViTri[i][j].Trong = true;
                    GameBoard.ViTri[i][j].Ten = "";
                    GameBoard.ViTri[i][j].Phe = 0;
                }
                GameBoard.ViTri[i][j].imgCanMove.setVisible(false);
            }
        }
    }

    /**
     * gan visible cac hinh anh jCanMove la false
     */
    public static void resetCanMove() {
        for (int i = 0; i <= 8; i++) {
            for (int j = 0; j <= 10; j++) {
                ViTri[i][j].imgCanMove.setVisible(false);
                scene.unregisterTouchArea(ViTri[i][j].imgCanMove);
            }
        }
    }

    /**
     * Khoi tao lai ban co tu dau
     */
    public static void reset() {
        for (int i = 0; i <= 8; i++) {
            for (int j = 0; j <= 10; j++) {
                GameBoard.ViTri[i][j].Hang = j;
                GameBoard.ViTri[i][j].Cot = i;
                GameBoard.ViTri[i][j].Trong = true;
                GameBoard.ViTri[i][j].Ten = "";
                GameBoard.ViTri[i][j].Phe = 0;

                // }
                GameBoard.ViTri[i][j].imgCanMove.setVisible(false);
            }
        }

    }

    /**
     * Khoa Ban Co
     */
    public static void lockBoard() {
        for (int i = 0; i <= 8; i++) {
            for (int j = 0; j <= 10; j++) {
                GameBoard.ViTri[i][j].Hang = j;
                GameBoard.ViTri[i][j].Cot = i;
                GameBoard.ViTri[i][j].Trong = false;
                GameBoard.ViTri[i][j].Ten = "";
                GameBoard.ViTri[i][j].Phe = 0;
                GameBoard.ViTri[i][j].imgCanMove.setVisible(false);
            }
        }
        VanCo.lockChess();

    }

    @Override
    public void onAccelerometerChanged(AccelerometerData pAccelerometerData) {

    }

    @Override
    public boolean onSceneTouchEvent(Scene pScene, TouchEvent pSceneTouchEvent) {
        // TODO Auto-generated method stub
        return false;
    }

    public static GameBoard getGameBoard() {
        return GameBoard.getGameBoard();

    }
}
