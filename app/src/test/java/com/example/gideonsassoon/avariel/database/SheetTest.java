package com.example.gideonsassoon.avariel.database;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Gideon Sassoon on 10/06/2017.
 */
public class SheetTest {
    @Test
    public void createSetPlayerAbilityValues() throws Exception {
        Sheet sheet = new Sheet();
        sheet.createSetPlayerAbilityValues(14, 12, 6, 9, 11, 11);

        assertEquals("Avariel createSetPlayer STR " + new AssertionError(), 2, sheet.player.getAbilities().getStrength());
        assertEquals("Avariel createSetPlayer DEX " + new AssertionError(), 1, sheet.player.getAbilities().getDexterity());
        assertEquals("Avariel createSetPlayer CON " + new AssertionError(), -2, sheet.player.getAbilities().getConstitution());
        assertEquals("Avariel createSetPlayer INT " + new AssertionError(), -1, sheet.player.getAbilities().getIntelligence());
        assertEquals("Avariel createSetPlayer WIS " + new AssertionError(), 0, sheet.player.getAbilities().getWisdom());
        assertEquals("Avariel createSetPlayer CHA " + new AssertionError(), 0, sheet.player.getAbilities().getCharisma());
    }

    @Test
    public void setPlayerSkills() throws Exception {
        Sheet sheet = new Sheet();
        sheet.createSetPlayerAbilityValues(14, 12, 6, 9, 11, 11);
        setPlayerSkills();
        assertEquals("Avariel createSetPlayer Acrobatics DEX " + new AssertionError(), -1, sheet.player.getSkills().getAcrobaticsValue());
        assertEquals("Avariel createSetPlayer Animal Healing WIS " + new AssertionError(), 0, sheet.player.getSkills().getAnimalHealingValue());
        assertEquals("Avariel createSetPlayer Arcana INT " + new AssertionError(), -1, sheet.player.getSkills().getArcanaValue());
        assertEquals("Avariel createSetPlayer Athletics STR " + new AssertionError(), 2, sheet.player.getSkills().getAthleticsValue());
        assertEquals("Avariel createSetPlayer Deception CHA " + new AssertionError(), 0, sheet.player.getSkills().getDeceptionValue());
        assertEquals("Avariel createSetPlayer History INT " + new AssertionError(), -1, sheet.player.getSkills().getHistoryValue());
        assertEquals("Avariel createSetPlayer Insight WIS " + new AssertionError(), 0, sheet.player.getSkills().getInsightValue());
        assertEquals("Avariel createSetPlayer Intimidation CHA " + new AssertionError(), 0, sheet.player.getSkills().getIntimidationValue());
        assertEquals("Avariel createSetPlayer Investigation INT " + new AssertionError(), -1, sheet.player.getSkills().getInvestigationValue());
        assertEquals("Avariel createSetPlayer Medicine WIS " + new AssertionError(), 0, sheet.player.getSkills().getMedicineValue());
        assertEquals("Avariel createSetPlayer Nature INT " + new AssertionError(), -1, sheet.player.getSkills().getNatureValue());
        assertEquals("Avariel createSetPlayer Perception WIS " + new AssertionError(), 0, sheet.player.getSkills().getPerceptionValue());
        assertEquals("Avariel createSetPlayer Performance CHA " + new AssertionError(), 0, sheet.player.getSkills().getPerformanceValue());
        assertEquals("Avariel createSetPlayer Persuasion CHA " + new AssertionError(), 0, sheet.player.getSkills().getPersuasionValue());
        assertEquals("Avariel createSetPlayer Religion INT " + new AssertionError(), -1, sheet.player.getSkills().getReligionValue());
        assertEquals("Avariel createSetPlayer Sleight of Hand DEX " + new AssertionError(), 1, sheet.player.getSkills().getSleightOfHandValue());
        assertEquals("Avariel createSetPlayer Stealth DEX " + new AssertionError(), 1, sheet.player.getSkills().getStealthValue());
        assertEquals("Avariel createSetPlayer Survival WIS " + new AssertionError(), 0, sheet.player.getSkills().getSurvivalValue());
    }

}