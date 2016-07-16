package de.craplezz.wizards.util;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Map;

/**
 * Created by Schuckmann on 30.05.2016.
 */
public class InfinitePotionEffect extends PotionEffect {

    public InfinitePotionEffect(Map<String, Object> map) {
        super(map);
    }

    public InfinitePotionEffect(PotionEffectType type, int amplifier, boolean ambient, boolean particles) {
        super(type, Integer.MAX_VALUE, amplifier, ambient, particles);
    }

    public InfinitePotionEffect(PotionEffectType type, int amplifier, boolean ambient) {
        super(type, Integer.MAX_VALUE, amplifier, ambient);
    }

    public InfinitePotionEffect(PotionEffectType type, int amplifier) {
        super(type, Integer.MAX_VALUE, amplifier);
    }

}
