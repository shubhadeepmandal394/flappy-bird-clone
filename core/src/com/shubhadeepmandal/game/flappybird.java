package com.shubhadeepmandal.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class flappybird extends ApplicationAdapter {
	SpriteBatch batch;
	Texture background;

	Texture[] birds;
	int flapState = 0, gameState = 0;
	float birdY = 0, velocity = 0, gravity = 2;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Texture("bg.png");
		birds = new Texture[2];
		birds[0] = new Texture("bird.png");
		birds[1] = new Texture("bird2.png");
		birdY = Gdx.graphics.getHeight()/2 - birds[0].getHeight();
	}

	@Override
	public void render () {
		if(gameState != 0) {
            if(Gdx.input.justTouched()){
                velocity = -30;
            }

			velocity += gravity;
			birdY -= velocity;
		}
		else {
			if(Gdx.input.justTouched()){
				gameState = 1;
			}
		}

		if (flapState == 0) {
			flapState = 1;
		} else {
			flapState = 0;
		}

		batch.begin();
		batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.draw(birds[flapState], Gdx.graphics.getWidth() / 2 - birds[flapState].getWidth(), birdY);
		batch.end();
	}
}
