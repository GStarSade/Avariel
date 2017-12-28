package com.example.gideonsassoon.avariel.datamodels;

/**
 * Created by Gideon on 19/12/2017.
 */

public class WeaponEnum {
    public enum DamageDieType {
        d4(0), d6(1), d8(2), d10(3), d12(4), d20(5), d100(6);
        private int key;

        DamageDieType(int keyValue) {
            key = keyValue;
        }

        public int getKey() {
            return key;
        }

        public static DamageDieType getEnumValue(int keyValue) {
            for (DamageDieType value : DamageDieType.values()) {
                if (value.getKey() == keyValue) {
                    return value;
                }
            }
            throw new RuntimeException("Could not find DamageDieType for Key: " + keyValue);
        }
    }

    public enum DamageType {
        Piercing(0), Bludgeoning(1), Slashing(2), Piercing_Bludgeoning(3), Piercing_Slashing(4), Bludgeoning_Slashing(5), Piercing_Bludgeoning_Slashing(6);
        private int key;

        DamageType(int keyValue) {
            key = keyValue;
        }

        public int getKey() {
            return key;
        }

        public static DamageType getEnumValue(int keyValue) {
            for (DamageType value : DamageType.values()) {
                if (value.getKey() == keyValue) {
                    return value;
                }
            }
            throw new RuntimeException("Could not find DamageType for Key: " + keyValue);
        }
    }
}