package com.example.gideonsassoon.avariel.datamodels;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Gideon Sassoon on 16/03/2017.
 */
public class Player extends RealmObject {
    //Time index 1:30

    //private String uuid;
    @PrimaryKey
    private long playerIdentifier;
    private String playerName;
    private String name;
    private String raceName;
    private String alignment;
    private String playerClass;
    private String background;
    private int currentHP;
    private int totalHP;
    private int experiencePoint;
    private Abilities abilities;
    private Armor armor;
    private Combat combat;
    private FeaturesAndTraits featuresAndTraits;
    private RealmList<Gear> gears;
    private RealmList<ProficienciesAndLanguages> proficienciesAndLanguages;
    private Skills skills; /* This must be 1 to 1 */
    private RealmList<Spell> spells;
    private RealmList<Weapon> weapons;

    @Ignore
    private int sessionId;

    /**
     * Gets player identifier.
     *
     * @return the player identifier
     */
    public long getPlayerIdentifier() {
        return playerIdentifier;
    }

    /**
     * Sets player identifier.
     *
     * @param playerIdentifier the player identifier
     */
    public void setPlayerIdentifier(long playerIdentifier) {
        this.playerIdentifier = playerIdentifier;
    }

    /**
     * Gets player name.
     *
     * @return the player name
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * Sets player name.
     *
     * @param playerName the player name
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets race name.
     *
     * @return the race name
     */
    public String getRaceName() {
        return raceName;
    }

    /**
     * Sets race name.
     *
     * @param raceName the race name
     */
    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    /**
     * Gets alignment.
     *
     * @return the alignment
     */
    public String getAlignment() {
        return alignment;
    }

    /**
     * Sets alignment.
     *
     * @param alignment the alignment
     */
    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    /**
     * Gets player class.
     *
     * @return the player class
     */
    public String getPlayerClass() {
        return playerClass;
    }

    /**
     * Sets player class.
     *
     * @param playerClass the player class
     */
    public void setPlayerClass(String playerClass) {
        this.playerClass = playerClass;
    }

    /**
     * Gets background.
     *
     * @return the background
     */
    public String getBackground() {
        return background;
    }

    /**
     * Sets background.
     *
     * @param background the background
     */
    public void setBackground(String background) {
        this.background = background;
    }

    /**
     * Gets current hp.
     *
     * @return the current hp
     */
    public int getCurrentHP() {
        return currentHP;
    }

    /**
     * Sets current hp.
     *
     * @param currentHP the current hp
     */
    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    /**
     * Gets total hp.
     *
     * @return the total hp
     */
    public int getTotalHP() {
        return totalHP;
    }

    /**
     * Sets total hp.
     *
     * @param totalHP the total hp
     */
    public void setTotalHP(int totalHP) {
        this.totalHP = totalHP;
    }

    /**
     * Gets experience point.
     *
     * @return the experience point
     */
    public int getExperiencePoint() {
        return experiencePoint;
    }

    /**
     * Sets experience point.
     *
     * @param experiencePoint the experience point
     */
    public void setExperiencePoint(int experiencePoint) {
        this.experiencePoint = experiencePoint;
    }

    /**
     * Gets session id.
     *
     * @return the session id
     */
    public int getSessionId() {
        return sessionId;
    }

    /**
     * Sets session id.
     *
     * @param sessionId the session id
     */
    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    //private final String abilitiesTableID; //Directly realm object or list as per example where there is a realm list of dogs
    //private final String combatTableID;
    //private final String skillsTableID;
    //private final String equipmentTableID;
    //private final String currencyTableID;
    //private final String armorTableID;
    //private final String proficienciesAndLanguagesTableID;
    //private final String featuresAndTraitsTableID;
    //private final String traitsTableID;

    /**
     * Create player.
     *
     * @param playerIdentifier          the player identifier
     * @param playerName                the player name
     * @param name                      the name
     * @param raceName                  the race name
     * @param alignment                 the alignment
     * @param playerClass               the player class
     * @param background                the background
     * @param currentHP                 the current hp
     * @param totalHP                   the total hp
     * @param experiencePoint           the experience point
     * @param abilities                 the abilities
     * @param armor                     the armor
     * @param combat                    the combat
     * @param featuresAndTraits         the features and traits
     * @param gears                     the gears
     * @param gearMount                 the gear mount
     * @param proficienciesAndLanguages the proficiencies and languages
     * @param skills                    the skills
     * @param spells                    the spells
     * @param weapons                   the weapons
     * @param sessionId                 the session id
     * @return the player
     */
    public static Player create(long playerIdentifier, String playerName, String name,
                                String raceName, String alignment, String playerClass,
                                String background, int currentHP, int totalHP, int experiencePoint,
                                Abilities abilities, Armor armor, Combat combat,
                                FeaturesAndTraits featuresAndTraits, RealmList<Gear> gears,
                                RealmList<ProficienciesAndLanguages> proficienciesAndLanguages,
                                Skills skills, RealmList<Spell> spells, RealmList<Weapon> weapons,
                                int sessionId) {
        Player player = new Player();
        player.playerIdentifier = playerIdentifier;
        player.playerName = playerName;
        player.name = name;
        player.raceName = raceName;
        player.alignment = alignment;
        player.playerClass = playerClass;
         player.currentHP = currentHP;
        player.totalHP = totalHP;
        player.experiencePoint = experiencePoint;
        player.abilities = abilities;
        player.armor = armor;
        player.combat = combat;
        player.featuresAndTraits = featuresAndTraits;
        player.gears = gears;
        player.proficienciesAndLanguages = proficienciesAndLanguages;
        player.skills = skills;
        player.spells = spells;
        player.weapons = weapons;
        player.sessionId = sessionId;
        return player;
    }
}
