package com.genetic.bots.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.genetic.bots.BotsHandling.Bot;
import com.genetic.bots.Paint;
import com.genetic.bots.WorldsHandling.World;

public class ChromosomeBot extends BotInfo {

    public ChromosomeBot(Bot bot, float yOffset) {
        super(bot, yOffset);

    }

    public ChromosomeBot() {
        yOffset = 0.28f;
        bot = null;
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
    public void setBot(Bot bot) {
        this.bot = bot;
    }

    @Override
    protected void render() {
        if(bot!=null)Paint.drawBotInfoForChromosome(botInfo,yOffset,nameFont,pointsFont,bot);
    }
}
