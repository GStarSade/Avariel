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

    public long getPlayerIdentifier() {
        return playerIdentifier;
    }

    public void setPlayerIdentifier(long playerIdentifier) {
        this.playerIdentifier = playerIdentifier;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public String getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(String playerClass) {
        this.playerClass = playerClass;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public int getTotalHP() {
        return totalHP;
    }

    public void setTotalHP(int totalHP) {
        this.totalHP = totalHP;
    }

    public int getExperiencePoint() {
        return experiencePoint;
    }

    public void setExperiencePoint(int experiencePoint) {
        this.experiencePoint = experiencePoint;
    }

    public Abilities getAbilities() {
        return abilities;
    }

    public void setAbilities(Abilities abilities) {
        this.abilities = abilities;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Combat getCombat() {
        return combat;
    }

    public void setCombat(Combat combat) {
        this.combat = combat;
    }

    public FeaturesAndTraits getFeaturesAndTraits() {
        return featuresAndTraits;
    }

    public void setFeaturesAndTraits(FeaturesAndTraits featuresAndTraits) {
        this.featuresAndTraits = featuresAndTraits;
    }

    public RealmList<Gear> getGears() {
        return gears;
    }

    public void setGears(RealmList<Gear> gears) {
        this.gears = gears;
    }

    public RealmList<ProficienciesAndLanguages> getProficienciesAndLanguages() {
        return proficienciesAndLanguages;
    }

    public void setProficienciesAndLanguages(RealmList<ProficienciesAndLanguages> proficienciesAndLanguages) {
        this.proficienciesAndLanguages = proficienciesAndLanguages;
    }

    public Skills getSkills() {
        return skills;
    }

    public void setSkills(Skills skills) {
        this.skills = skills;
    }

    public RealmList<Spell> getSpells() {
        return spells;
    }

    public void setSpells(RealmList<Spell> spells) {
        this.spells = spells;
    }

    public RealmList<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(RealmList<Weapon> weapons) {
        this.weapons = weapons;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

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
        player.background = background;
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

    public static Player create(Player player, String playerName, String name,
                                String raceName, String alignment, String playerClass,
                                String background, int currentHP, int totalHP, int experiencePoint,
                                Abilities abilities, Armor armor, Combat combat,
                                FeaturesAndTraits featuresAndTraits, RealmList<Gear> gears,
                                RealmList<ProficienciesAndLanguages> proficienciesAndLanguages,
                                Skills skills, RealmList<Spell> spells, RealmList<Weapon> weapons,
                                int sessionId) {
        player.playerName = playerName;
        player.name = name;
        player.raceName = raceName;
        player.background = background;
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

    @Override
    public String toString() {
        return "Player{" +
                "playerIdentifier=" + playerIdentifier +
                ", playerName='" + playerName + '\'' +
                ", name='" + name + '\'' +
                ", raceName='" + raceName + '\'' +
                ", alignment='" + alignment + '\'' +
                ", playerClass='" + playerClass + '\'' +
                ", background='" + background + '\'' +
                ", currentHP=" + currentHP +
                ", totalHP=" + totalHP +
                ", experiencePoint=" + experiencePoint +
                ", abilities=" + abilities +
                ", armor=" + armor +
                ", combat=" + combat +
                ", featuresAndTraits=" + featuresAndTraits +
                ", gears=" + gears +
                ", proficienciesAndLanguages=" + proficienciesAndLanguages +
                ", skills=" + skills +
                ", spells=" + spells +
                ", weapons=" + weapons +
                ", sessionId=" + sessionId +
                '}';
    }

    public void createPlayerChild() {
        abilities = new Abilities();
        skills = new Skills();
        armor = new Armor();
        combat = new Combat();
        featuresAndTraits = new FeaturesAndTraits();
        /* The following are REALM objects as such it is not certain if they need to be initialised */
        //gears = new RealmList<Gear>;
        //proficienciesAndLanguages = new RealmList<ProficienciesAndLanguages> ;
        //spells = new RealmList<Spell>();
        //weapons = new RealmList<Weapon>();
    }
}
