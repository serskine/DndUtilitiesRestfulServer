package com.soupthatisthick.dnd.utilities.server.client.model.util.sort;

import com.soupthatisthick.dnd.utilities.server.client.model.lookup.*;

import javax.annotation.Nullable;

/**
 * Created by Owner on 5/27/2017.
 * Copyright of Stuart Marr Erskine, all rights reserved.
 */


public enum Category
{
    DEFAULT(0),
    CONDITION(-1),
    CUSTOM_MONSTER(-2),
    STANDARD_MONSTER(-3),
    MAGIC_ITEM(-4),
    SPELL(-5),
    FEAT(-6),
    BACKGROUND(-7),
    ARMOR(-8),
    WEAPON(-9),
    EQUIPMENT(-10),
    NOTE(-11),
    CHALLENGE_RATING(-12),
    LEVEL(-13),
    GOD(-14),
    LIFESTYLE(-15),
    MOUNT(-16),
    ENTITY(-17),
    ENTITY_LIST(-18),
    SEASON(-19),
    ADVENTURE(-20)
    ;

    public final int orderValue;
    public final String tableName, primaryKey;

    private Category(int orderValue)
    {
        this.orderValue = orderValue;
        this.tableName = this.name() + ".tableName";
        this.primaryKey = this.name() + ".primaryKey";
    }

    public static final Category parse(@Nullable Object item)
    {
        if (item==null) {
            return DEFAULT;
        }
        if (item.getClass().equals(Condition.class)) {
            return CONDITION;
        }
        if (item.getClass().equals(Spell.class)) {
            return SPELL;
        }
        if (item.getClass().equals(CustomMonster.class)) {
            return CUSTOM_MONSTER;
        }
        if (item.getClass().equals(StandardMonster.class)) {
            return STANDARD_MONSTER;
        }
        if (item.getClass().equals(MagicItem.class)) {
            return MAGIC_ITEM;
        }
        if (item.getClass().equals(Feat.class)) {
            return FEAT;
        }
        if (item.getClass().equals(Background.class)) {
            return BACKGROUND;
        }
        if (item.getClass().equals(Armor.class)) {
            return ARMOR;
        }
        if (item.getClass().equals(Weapon.class)) {
            return WEAPON;
        }
        if (item.getClass().equals(Equipment.class)) {
            return EQUIPMENT;
        }
        if (item.getClass().equals(Note.class)) {
            return NOTE;
        }
        if (item.getClass().equals(ChallengeRating.class)) {
            return CHALLENGE_RATING;
        }
        if (item.getClass().equals(Level.class)) {
            return LEVEL;
        }
        if (item.getClass().equals(God.class)) {
            return GOD;
        }
        if (item.getClass().equals(LifeStyle.class)) {
            return LIFESTYLE;
        }
        if (item.getClass().equals(Mount.class)) {
            return MOUNT;
        }
        if (item.getClass().equals(Entity.class)) {
            return ENTITY;
        }
        if (item.getClass().equals(Season.class)) {
            return SEASON;
        }
        if (item.getClass().equals(Adventure.class)) {
            return ADVENTURE;
        }
        return DEFAULT;
    }
};
