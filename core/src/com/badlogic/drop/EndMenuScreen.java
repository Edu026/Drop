package com.badlogic.drop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;


public class EndMenuScreen implements Screen {

    final Drop game;
    OrthographicCamera camera;
    private Stage stage; // New Stage for UI elements



    public EndMenuScreen(final Drop game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        // Create a new Stage for UI elements
        stage = new Stage();
    }

    @Override
    public void show() {
        Label playAgainLabel = new Label("Volver a jugar", game.skin);
        Button playAgainButton = new Button(playAgainLabel, game.skin);

        // Establecer la posición del botón manualmente (ajustar según sea necesario)
        playAgainButton.setPosition((float) Gdx.graphics.getWidth() /2, (float) Gdx.graphics.getHeight() /2);
        playAgainButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Aquí colocas el código que deseas ejecutar cuando se hace clic en el botón
                // Por ejemplo, puedes iniciar una nueva pantalla o reiniciar el juego
                game.setScreen(new GameScreen(game)); // Cambia "GameScreen" por el nombre de tu pantalla de juego
                dispose();
            }
        });


        stage.addActor(playAgainButton);

        // Registrar el Stage para recibir eventos de entrada
        Gdx.input.setInputProcessor(stage);
    }


    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();

        game.font.draw(game.batch, "You have lost!", 250, 250);

        game.batch.end();

        // Draw the Stage with UI elements
        stage.draw();
    }

    // ... Rest of class omitted for succinctness.

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose(); // Dispose the Stage when screen is disposed
    }
}
