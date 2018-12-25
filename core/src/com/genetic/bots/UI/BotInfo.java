package com.genetic.bots.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.genetic.bots.BotsHandling.Bot;
import com.genetic.bots.Paint;

public class BotInfo extends Actor implements Comparable<BotInfo> {
    protected Bot bot;

    float yOffset;

    protected static Texture botInfo = new Texture(Gdx.files.internal("botInfo.png")), selection = new Texture(Gdx.files.internal("selection.png"));
    protected static BitmapFont nameFont, pointsFont;

    public static void dispose() {
        nameFont.dispose();
        pointsFont.dispose();
        botInfo.dispose();
        selection.dispose();
    }

    static {
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.color = Color.DARK_GRAY;
        parameter.size = 14;
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("9522.ttf"));
        nameFont = generator.generateFont(parameter);
        parameter.size = 14;

        pointsFont = generator.generateFont(parameter);
        generator.dispose();
    }

    @Override
    public int compareTo(BotInfo o) {
        return bot.compareTo(o.bot);
    }

    public BotInfo(Bot bot, float yOffset) {
        this.bot = bot;
        this.yOffset = yOffset;
        bot.linkTo(this);

    }
    public BotInfo(){

    }

    public Bot getBot() {
        return bot;
    }

    protected void render() {
        Paint.drawBotInfo(botInfo,selection,yOffset,nameFont,pointsFont,bot);
    }
}
