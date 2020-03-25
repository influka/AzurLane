package AzurLane.cards;

import AzurLane.AzurLane;
import AzurLane.relics.project_azure;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static AzurLane.AzurLane.*;
import static AzurLane.AzurLane.ship_curr;

public class al_menu_gold extends abs_al_core{

    public static final String ID = AzurLane.makeID(al_shipselect.class.getSimpleName());
    public static final String IMG = makeCardPath("null.png");
    private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.SPECIAL;
    private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.NONE;
    private static final AbstractCard.CardType TYPE = AbstractCard.CardType.POWER;
    public static final AbstractCard.CardColor COLOR = AbstractCard.CardColor.COLORLESS;
    public String Ship;
    public static final Logger logger = LogManager.getLogger(al_shipselect.class.getName());


    public al_menu_gold(String state, int amount) {
        super(ID, IMG, -2, TYPE, COLOR, RARITY, TARGET);
        Ship = index;
        this.name = state + " " + amount;

        switch (state){

            case "Deposit":
                this.name = state + " " + amount;
                this.rawDescription = state + " " + amount + " of your total gold. NL azurlane:investable";

                break;

            case "Withdraw":
                break;

            case "Interest":
                break;

            default:

        }
        logger.info(index);
        loadCardImage("AzurLaneResources/images/cards/" + index + ".png");
        initializeDescription();


    }

    @Override
    public float getTitleFontSize()
    {
        return 12;
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
        AbstractDungeon.getCurrRoom().spawnRelicAndObtain((Settings.WIDTH / 2), (Settings.HEIGHT / 2), new project_azure(ship_curr));

    }


    @Override
    public void upgrade() {
    }


}
