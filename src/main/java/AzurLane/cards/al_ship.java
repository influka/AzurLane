package AzurLane.cards;

import AzurLane.AzurLane;

import AzurLane.actions.utility.azur_pickmenu;
import basemod.AutoAdd;

import com.badlogic.gdx.Gdx;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;

import static AzurLane.AzurLane.*;

@AutoAdd.Ignore
public class al_ship extends abs_al {

    public static final String ID = AzurLane.makeID(al_ship.class.getSimpleName());
    public static final String IMG = makeCardPath("null.png");
    private static final CardRarity RARITY = CardRarity.SPECIAL;
    private static final CardTarget TARGET = CardTarget.NONE;
    private static final CardType TYPE = CardType.POWER;
    public static final CardColor COLOR = CardColor.COLORLESS;
    public String Ship;
    public static final Logger logger = LogManager.getLogger(al_ship.class.getName());


    public al_ship(String index, String name, String desc) {
        super(ID, IMG, -2, TYPE, COLOR, RARITY, TARGET);
        Ship = index;
        this.name = name;
        this.rawDescription = desc;
        logger.info(index);
        loadCardImage("AzurLaneResources/images/cards/" + index + ".png");
        initializeDescription();


    }

    @Override
    public float getTitleFontSize()
    {
        return 16;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        logger.info("SHIP SELECTED: " + Ship);
        ship_curr = Ship;
        ship_currskin = "default";

        try{
            AzurLane.saveData();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }


    @Override
    public void upgrade() {
    }


}