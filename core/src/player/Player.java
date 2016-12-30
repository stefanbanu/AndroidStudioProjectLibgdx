package player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import utils.GameProperties;

/**
 * Created by stefanbanu on 30.12.2016.
 */

public class Player extends Sprite{

    private World world;
    private Body body;

    public Player(World world, float x, float y){
        super(new Texture("player/Player 1.png"));
        this.world = world;
        setPosition(x, y);
        createBody();
    }

    void createBody(){

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(getX() / GameProperties.PPM, getY() / GameProperties.PPM);

        body = world.createBody(bodyDef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox((getWidth() / 2f - 10) / GameProperties.PPM, (getHeight() / 2f) / GameProperties.PPM);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.density = 4f;
        fixtureDef.friction = 2f;
        fixtureDef.shape = shape;

        Fixture fixture = body.createFixture(fixtureDef);

        shape.dispose();
    }

    public void drawPlayer(SpriteBatch batch){
        batch.draw(this, getX() + getWidth() / 2f - 5, getY() - getHeight() / 2f);
    }

    public void updatePlayer(){
        setPosition(body.getPosition().x * GameProperties.PPM, body.getPosition().y * GameProperties.PPM);
    }

}





