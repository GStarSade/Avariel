package com.example.gideonsassoon.avariel.data;

/**
 * Created by Gideon Sassoon on 16/03/2017.
 */
public class Player {

    private final String playerIdentifier;
    private String name;
    private String background;
    private String playerName;
    private String race;
    private String alignment;
    private final int experiencePoStrings;
    private final String abilitiesTableID;
    private final String combatTableID;
    private final String skillsTableID;
    private final String weaponsTableID;
    private final String magicTableID;
    private final String equipmentTableID;
    private final String currencyTableID;
    private final String armorTableID;
    private final String proficienciesAndLanguagesTableID;
    private final String featuresAndTraitsTableID;
    private final String traitsTableID;
    ;

    /**
     * Instantiates a new Player.
     *
     * @param playerIdentifier                 the player identifier
     * @param name                             the name
     * @param background                       the background
     * @param playerName                       the player name
     * @param race                             the race
     * @param alignment                        the alignment
     * @param experiencePoStrings                 the experience poStrings
     * @param abilitiesTableID                 the abilities table id
     * @param skillsTableID
     * @param combatTableID                    the combat table id
     * @param weaponsTableID                   the weapons table id
     * @param magicTableID                     the magic table id
     * @param equipmentTableID                 the equipment table id
     * @param currencyTableID                  the currency table id
     * @param armorTableID                     the armor table id
     * @param proficienciesAndLanguagesTableID the proficiencies and languages table id
     * @param featuresAndTraitsTableID         the features and traits table id
     * @param traitsTableID                    the traits table id          @paraplaym skillsTableID                the skills table id
     */
    public Player(String playerIdentifier, String name, String background, String playerName,
                  String race, String alignment, int experiencePoStrings,
                  String abilitiesTableID, String combatTableID, String skillsTableID,
                  String weaponsTableID, String magicTableID,
                  String equipmentTableID, String currencyTableID, String armorTableID,
                  String proficienciesAndLanguagesTableID,
                  String featuresAndTraitsTableID, String traitsTableID) {
        this.playerIdentifier = playerIdentifier;
        this.name = name;
        this.background = background;
        this.playerName = playerName;
        this.race = race;
        this.alignment = alignment;
        this.experiencePoStrings = experiencePoStrings;
        this.abilitiesTableID = abilitiesTableID;
        this.combatTableID = combatTableID;
        this.skillsTableID = skillsTableID;
        this.weaponsTableID = weaponsTableID; //01,06,03
        this.magicTableID = magicTableID;
        this.equipmentTableID = equipmentTableID;
        this.currencyTableID = currencyTableID;
        this.armorTableID = armorTableID;
        this.proficienciesAndLanguagesTableID = proficienciesAndLanguagesTableID;
        this.featuresAndTraitsTableID = featuresAndTraitsTableID;
        this.traitsTableID = traitsTableID;

    }

    public String getPlayerIdentifier() {
        return playerIdentifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public int getExperiencePoStrings() {
        return experiencePoStrings;
    }

    public String getAbilitiesTableID() {
        return abilitiesTableID;
    }

    public String getCombatTableID() {
        return combatTableID;
    }

    public String getSkillsTableID() {
        return skillsTableID;
    }

    public String getWeaponsTableID() {
        return weaponsTableID;
    }

    public String getMagicTableID() {
        return magicTableID;
    }

    public String getEquipmentTableID() {
        return equipmentTableID;
    }

    public String getCurrencyTableID() {
        return currencyTableID;
    }

    public String getArmorTableID() {
        return armorTableID;
    }

    public String getProficienciesAndLanguagesTableID() {
        return proficienciesAndLanguagesTableID;
    }

    public String getFeaturesAndTraitsTableID() {
        return featuresAndTraitsTableID;
    }

    public String getTraitsTableID() {
        return traitsTableID;
    }
}




