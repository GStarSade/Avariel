package com.example.gideonsassoon.avariel.datamodels;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by scorchgid on 03/07/17.
 */

public class Sheet extends RealmObject {
    @PrimaryKey
    private int sheetID;

    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;

    private int experiencePoint;

    private String playerName;
    private String characterName;
    private String background;

    private String race;
    private String playerClass;
    private String alignment;

    private int temporaryHitPoints;
    private int currentHitPoints;
    private int inspration;

    private int successDeathSaves;
    private int failureDeathSaves;

    private boolean savingThrowStrengthProficiency;

    private boolean savingThrowDexterityProficiency;
    private boolean savingThrowConstitutionProficiency;
    private boolean savingThrowIntelligenceProficiency;
    private boolean savingThrowWisdomProficiency;
    private boolean savingThrowCharismaProficiency;

    private boolean acrobaticsProficiency = false;
    private boolean animalHealingProficiency = false;
    private boolean arcanaProficiency = false;
    private boolean athleticsProficiency = false;
    private boolean deceptionProficiency = false;
    private boolean historyProficiency = false;
    private boolean insightMaarked = false;
    private boolean intimidationProficiency = false;
    private boolean investigationProficiency = false;
    private boolean medicineProficiency = false;
    private boolean natureProficiency = false;
    private boolean perceptionProficiency = false;
    private boolean performanceProficiency = false;
    private boolean persuasionProficiency = false;
    private boolean religionProficiency = false;
    private boolean sleightOfHandProficiency = false;
    private boolean stealthProficiency = false;
    private boolean survivalProficiency = false;

    private String personalityTraits;
    private String ideals;
    private String bonds;
    private String flaws;

    private int copperCoins;
    private int silverCoins;
    private int electrumCoins;
    private int goldCoins;
    private int platniumCoins;

    private int abilityLv4;
    private int abilityLv8;
    private int abilityLv12;
    private int abilityLv16;
    private int abilityLv19;

    public int getSheetID() {
        return sheetID;
    }

    public void setSheetID(int sheetID) {
        this.sheetID = sheetID;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getExperiencePoint() {
        return experiencePoint;
    }

    public void setExperiencePoint(int experiencePoint) {
        this.experiencePoint = experiencePoint;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(String playerClass) {
        this.playerClass = playerClass;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public int getTemporaryHitPoints() {
        return temporaryHitPoints;
    }

    public void setTemporaryHitPoints(int temporaryHitPoints) {
        this.temporaryHitPoints = temporaryHitPoints;
    }

    public int getCurrentHitPoints() {
        return currentHitPoints;
    }

    public void setCurrentHitPoints(int currentHitPoints) {
        this.currentHitPoints = currentHitPoints;
    }

    public int getInspration() {
        return inspration;
    }

    public void setInspration(int inspration) {
        this.inspration = inspration;
    }

    public int getSuccessDeathSaves() {
        return successDeathSaves;
    }

    public void setSuccessDeathSaves(int successDeathSaves) {
        this.successDeathSaves = successDeathSaves;
    }

    public int getFailureDeathSaves() {
        return failureDeathSaves;
    }

    public void setFailureDeathSaves(int failureDeathSaves) {
        this.failureDeathSaves = failureDeathSaves;
    }

    public boolean isSavingThrowStrengthProficiency() {
        return savingThrowStrengthProficiency;
    }

    public void setSavingThrowStrengthProficiency(boolean savingThrowStrengthProficiency) {
        this.savingThrowStrengthProficiency = savingThrowStrengthProficiency;
    }

    public boolean isSavingThrowDexterityProficiency() {
        return savingThrowDexterityProficiency;
    }

    public void setSavingThrowDexterityProficiency(boolean savingThrowDexterityProficiency) {
        this.savingThrowDexterityProficiency = savingThrowDexterityProficiency;
    }

    public boolean isSavingThrowConstitutionProficiency() {
        return savingThrowConstitutionProficiency;
    }

    public void setSavingThrowConstitutionProficiency(boolean savingThrowConstitutionProficiency) {
        this.savingThrowConstitutionProficiency = savingThrowConstitutionProficiency;
    }

    public boolean isSavingThrowIntelligenceProficiency() {
        return savingThrowIntelligenceProficiency;
    }

    public void setSavingThrowIntelligenceProficiency(boolean savingThrowIntelligenceProficiency) {
        this.savingThrowIntelligenceProficiency = savingThrowIntelligenceProficiency;
    }

    public boolean isSavingThrowWisdomProficiency() {
        return savingThrowWisdomProficiency;
    }

    public void setSavingThrowWisdomProficiency(boolean savingThrowWisdomProficiency) {
        this.savingThrowWisdomProficiency = savingThrowWisdomProficiency;
    }

    public boolean isSavingThrowCharismaProficiency() {
        return savingThrowCharismaProficiency;
    }

    public void setSavingThrowCharismaProficiency(boolean savingThrowCharismaProficiency) {
        this.savingThrowCharismaProficiency = savingThrowCharismaProficiency;
    }

    public boolean isAcrobaticsProficiency() {
        return acrobaticsProficiency;
    }

    public void setAcrobaticsProficiency(boolean acrobaticsProficiency) {
        this.acrobaticsProficiency = acrobaticsProficiency;
    }

    public boolean isAnimalHealingProficiency() {
        return animalHealingProficiency;
    }

    public void setAnimalHealingProficiency(boolean animalHealingProficiency) {
        this.animalHealingProficiency = animalHealingProficiency;
    }

    public boolean isArcanaProficiency() {
        return arcanaProficiency;
    }

    public void setArcanaProficiency(boolean arcanaProficiency) {
        this.arcanaProficiency = arcanaProficiency;
    }

    public boolean isAthleticsProficiency() {
        return athleticsProficiency;
    }

    public void setAthleticsProficiency(boolean athleticsProficiency) {
        this.athleticsProficiency = athleticsProficiency;
    }

    public boolean isDeceptionProficiency() {
        return deceptionProficiency;
    }

    public void setDeceptionProficiency(boolean deceptionProficiency) {
        this.deceptionProficiency = deceptionProficiency;
    }

    public boolean isHistoryProficiency() {
        return historyProficiency;
    }

    public void setHistoryProficiency(boolean historyProficiency) {
        this.historyProficiency = historyProficiency;
    }

    public boolean isInsightMaarked() {
        return insightMaarked;
    }

    public void setInsightMaarked(boolean insightMaarked) {
        this.insightMaarked = insightMaarked;
    }

    public boolean isIntimidationProficiency() {
        return intimidationProficiency;
    }

    public void setIntimidationProficiency(boolean intimidationProficiency) {
        this.intimidationProficiency = intimidationProficiency;
    }

    public boolean isInvestigationProficiency() {
        return investigationProficiency;
    }

    public void setInvestigationProficiency(boolean investigationProficiency) {
        this.investigationProficiency = investigationProficiency;
    }

    public boolean isMedicineProficiency() {
        return medicineProficiency;
    }

    public void setMedicineProficiency(boolean medicineProficiency) {
        this.medicineProficiency = medicineProficiency;
    }

    public boolean isNatureProficiency() {
        return natureProficiency;
    }

    public void setNatureProficiency(boolean natureProficiency) {
        this.natureProficiency = natureProficiency;
    }

    public boolean isPerceptionProficiency() {
        return perceptionProficiency;
    }

    public void setPerceptionProficiency(boolean perceptionProficiency) {
        this.perceptionProficiency = perceptionProficiency;
    }

    public boolean isPerformanceProficiency() {
        return performanceProficiency;
    }

    public void setPerformanceProficiency(boolean performanceProficiency) {
        this.performanceProficiency = performanceProficiency;
    }

    public boolean isPersuasionProficiency() {
        return persuasionProficiency;
    }

    public void setPersuasionProficiency(boolean persuasionProficiency) {
        this.persuasionProficiency = persuasionProficiency;
    }

    public boolean isReligionProficiency() {
        return religionProficiency;
    }

    public void setReligionProficiency(boolean religionProficiency) {
        this.religionProficiency = religionProficiency;
    }

    public boolean isSleightOfHandProficiency() {
        return sleightOfHandProficiency;
    }

    public void setSleightOfHandProficiency(boolean sleightOfHandProficiency) {
        this.sleightOfHandProficiency = sleightOfHandProficiency;
    }

    public boolean isStealthProficiency() {
        return stealthProficiency;
    }

    public void setStealthProficiency(boolean stealthProficiency) {
        this.stealthProficiency = stealthProficiency;
    }

    public boolean isSurvivalProficiency() {
        return survivalProficiency;
    }

    public void setSurvivalProficiency(boolean survivalProficiency) {
        this.survivalProficiency = survivalProficiency;
    }

    public String getPersonalityTraits() {
        return personalityTraits;
    }

    public void setPersonalityTraits(String personalityTraits) {
        this.personalityTraits = personalityTraits;
    }

    public String getIdeals() {
        return ideals;
    }

    public void setIdeals(String ideals) {
        this.ideals = ideals;
    }

    public String getBonds() {
        return bonds;
    }

    public void setBonds(String bonds) {
        this.bonds = bonds;
    }

    public String getFlaws() {
        return flaws;
    }

    public void setFlaws(String flaws) {
        this.flaws = flaws;
    }

    public int getCopperCoins() {
        return copperCoins;
    }

    public void setCopperCoins(int copperCoins) {
        this.copperCoins = copperCoins;
    }

    public int getSilverCoins() {
        return silverCoins;
    }

    public void setSilverCoins(int silverCoins) {
        this.silverCoins = silverCoins;
    }

    public int getElectrumCoins() {
        return electrumCoins;
    }

    public void setElectrumCoins(int electrumCoins) {
        this.electrumCoins = electrumCoins;
    }

    public int getGoldCoins() {
        return goldCoins;
    }

    public void setGoldCoins(int goldCoins) {
        this.goldCoins = goldCoins;
    }

    public int getPlatniumCoins() {
        return platniumCoins;
    }

    public void setPlatniumCoins(int platniumCoins) {
        this.platniumCoins = platniumCoins;
    }

    public int getAbilityLv4() {
        return abilityLv4;
    }

    public void setAbilityLv4(int abilityLv4) {
        this.abilityLv4 = abilityLv4;
    }

    public int getAbilityLv8() {
        return abilityLv8;
    }

    public void setAbilityLv8(int abilityLv8) {
        this.abilityLv8 = abilityLv8;
    }

    public int getAbilityLv12() {
        return abilityLv12;
    }

    public void setAbilityLv12(int abilityLv12) {
        this.abilityLv12 = abilityLv12;
    }

    public int getAbilityLv16() {
        return abilityLv16;
    }

    public void setAbilityLv16(int abilityLv16) {
        this.abilityLv16 = abilityLv16;
    }

    public int getAbilityLv19() {
        return abilityLv19;
    }

    public void setAbilityLv19(int abilityLv19) {
        this.abilityLv19 = abilityLv19;
    }

    public int getStrengthModified() {

        setModifer(strength);
        getCurrentLevel();
        getPlayerClass();

        return 0;
    }

    public int getDexterityModified() {

        setModifer(dexterity);
        getCurrentLevel();
        getPlayerClass();

        return 0;
    }

    public int getConstitutionModified() {

        setModifer(constitution);
        getCurrentLevel();
        getPlayerClass();

        return 0;
    }

    public int getIntelligenceModified() {

        setModifer(intelligence);
        getCurrentLevel();
        getPlayerClass();

        return 0;
    }

    public int getWisdomModified() {

        setModifer(wisdom);
        getCurrentLevel();
        getPlayerClass();

        return 0;
    }

    public int getCharismaModified() {

        setModifer(charisma);
        getCurrentLevel();
        getPlayerClass();

        return 0;
    }

    private int setModifer(int value) {
        switch (value) {
            case 1:
                return -5;
            case 2:
            case 3:
                return -4;
            case 4:
            case 5:
                return -3;
            case 6:
            case 7:
                return -2;
            case 8:
            case 9:
                return -1;
            case 10:
            case 11:
                return 0;
            case 12:
            case 13:
                return 1;
            case 14:
            case 15:
                return 2;
            case 16:
            case 17:
                return 3;
            case 18:
            case 19:
                return 4;
            default:
                return 0;
        }
    }

    private int getCurrentLevel() {
        if (experiencePoint < 300)
            return 1;
        else if (experiencePoint < 900)
            return 2;
        else if (experiencePoint < 2700)
            return 3;
        else if (experiencePoint < 6500)
            return 4;
        else if (experiencePoint < 14000)
            return 5;
        else if (experiencePoint < 23000)
            return 6;
        else if (experiencePoint < 34000)
            return 7;
        else if (experiencePoint < 48000)
            return 8;
        else if (experiencePoint < 64000)
            return 9;
        else if (experiencePoint < 85000)
            return 10;
        else if (experiencePoint < 100000)
            return 11;
        else if (experiencePoint < 120000)
            return 12;
        else if (experiencePoint < 140000)
            return 13;
        else if (experiencePoint < 165000)
            return 14;
        else if (experiencePoint < 195000)
            return 15;
        else if (experiencePoint < 225000)
            return 16;
        else if (experiencePoint < 265000)
            return 17;
        else if (experiencePoint < 305000)
            return 18;
        else if (experiencePoint < 355000)
            return 19;
        else
            return 20;
    }

    int getBaseProficiencyBonus() throws Exception {
        int currentLevel = getCurrentLevel();
        switch (currentLevel) {
            case 1:
            case 2:
            case 3:
            case 4:
                return 2;
            case 5:
            case 6:
            case 7:
            case 8:
                return 3;
            case 9:
            case 10:
            case 11:
            case 12:
                return 4;
            case 13:
            case 14:
            case 15:
            case 16:
                return 5;
            case 17:
            case 18:
            case 19:
            case 20:
                return 6;
            default:
                throw new Exception("getBaseProficiencyBonus Exception");
        }
    }

    void getRace(){

    }
    /*Dwarf */
    getHillDwarf(){
        switch(getCurrentLevel()){

            case 1:
                set
        }

    }



}
