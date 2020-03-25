package AzurLane.cards;

import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import java.util.Random;

import static com.megacrit.cardcrawl.core.CardCrawlGame.languagePack;

public abstract class abs_al_core extends CustomCard {


    public abs_al_core(final String id,
                       final String img,
                       final int cost,
                       final CardType type,
                       final CardColor color,
                       final CardRarity rarity,
                       final CardTarget target) {

        super(id, languagePack.getCardStrings(id).NAME, img, cost, languagePack.getCardStrings(id).DESCRIPTION, type, color, rarity, target);

        this.isCostModified = false;
        this.isCostModifiedForTurn = false;
        this.isDamageModified = false;
        this.isBlockModified = false;
        this.isMagicNumberModified = false;
    }

}