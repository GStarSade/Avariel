package com.example.gideonsassoon.avariel.datamodels;

/**
 * Created by Gideon Sassoon on 16/03/2017.
 */
public class Player { //extends Realm

    private final long playerIdentifier;
    private String uuid;
    private String playerName;
    private String name;
    private String raceName;
    private String alignment;
    private String playerClass;
    private String background;
    private int currentHP;
    private int totalHP;
    private int experiencePoint;
    private final String abilitiesTableID; //Directly relm object or list as per example where htereis a relm list of dogs
    private final String combatTableID;
    private final String skillsTableID;
    private final String equipmentTableID;
    private final String currencyTableID;
    private final String armorTableID;
    private final String proficienciesAndLanguagesTableID;
    private final String featuresAndTraitsTableID;
    private final String traitsTableID;

    /**
     * Instantiates a new Player.
     *
     * @param playerIdentifier                 the player identifier
     * @param uuid                             the uuid
     * @param playerName                       the player name
     * @param name                             the name
     * @param raceName                         the race name
     * @param alignment                        the alignment
     * @param playerClass                      the player class
     * @param background                       the background
     * @param currentHP                        the current hp
     * @param totalHP                          the total hp
     * @param experiencePoint                  the experience point
     * @param abilitiesTableID                 the abilities table id
     * @param combatTableID                    the combat table id
     * @param skillsTableID                    the skills table id
     * @param equipmentTableID                 the equipment table id
     * @param currencyTableID                  the currency table id
     * @param armorTableID                     the armor table id
     * @param proficienciesAndLanguagesTableID the proficiencies and languages table id
     * @param featuresAndTraitsTableID         the features and traits table id
     * @param traitsTableID                    the traits table id
     */
    public Player(long playerIdentifier, String uuid, String playerName, String name, String raceName,
                  String alignment, String playerClass, String background, int currentHP,
                  int totalHP, int experiencePoint, String abilitiesTableID, String combatTableID,
                  String skillsTableID, String equipmentTableID, String currencyTableID,
                  String armorTableID, String proficienciesAndLanguagesTableID,
                  String featuresAndTraitsTableID, String traitsTableID) {
        this.playerIdentifier = playerIdentifier;
        this.uuid = uuid;
        this.playerName = playerName;
        this.name = name;
        this.raceName = raceName;
        this.alignment = alignment;
        this.playerClass = playerClass;
        this.background = background;
        this.currentHP = currentHP;
        this.totalHP = totalHP;
        this.experiencePoint = experiencePoint;
        this.abilitiesTableID = abilitiesTableID;
        this.combatTableID = combatTableID;
        this.skillsTableID = skillsTableID;
        this.equipmentTableID = equipmentTableID;
        this.currencyTableID = currencyTableID;
        this.armorTableID = armorTableID;
        this.proficienciesAndLanguagesTableID = proficienciesAndLanguagesTableID;
        this.featuresAndTraitsTableID = featuresAndTraitsTableID;
        this.traitsTableID = traitsTableID;
    }



    /**
     * Gets player identifier.
     *
     * @return the player identifier
     */
    public long getPlayerIdentifier() {
        return playerIdentifier;
    }

    /**
     * Gets uuid.
     *
     * @return the uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * Sets uuid.
     *
     * @param uuid the uuid
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
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
     * Gets raceName.
     *
     * @return the raceName
     */
    public String getRaceName() {
        return raceName;
    }

    /**
     * Sets raceName.
     *
     * @param raceName the raceName
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
     * Gets abilities table id.
     *
     * @return the abilities table id
     */
    public String getAbilitiesTableID() {
        return abilitiesTableID;
    }

    /**
     * Gets combat table id.
     *
     * @return the combat table id
     */
    public String getCombatTableID() {
        return combatTableID;
    }

    /**
     * Gets skills table id.
     *
     * @return the skills table id
     */
    public String getSkillsTableID() {
        return skillsTableID;
    }

    /**
     * Gets equipment table id.
     *
     * @return the equipment table id
     */
    public String getEquipmentTableID() {
        return equipmentTableID;
    }

    /**
     * Gets currency table id.
     *
     * @return the currency table id
     */
    public String getCurrencyTableID() {
        return currencyTableID;
    }

    /**
     * Gets armor table id.
     *
     * @return the armor table id
     */
    public String getArmorTableID() {
        return armorTableID;
    }

    /**
     * Gets proficiencies and languages table id.
     *
     * @return the proficiencies and languages table id
     */
    public String getProficienciesAndLanguagesTableID() {
        return proficienciesAndLanguagesTableID;
    }

    /**
     * Gets features and traits table id.
     *
     * @return the features and traits table id
     */
    public String getFeaturesAndTraitsTableID() {
        return featuresAndTraitsTableID;
    }

    /**
     * Gets traits table id.
     *
     * @return the traits table id
     */
    public String getTraitsTableID() {
        return traitsTableID;
    }


}
