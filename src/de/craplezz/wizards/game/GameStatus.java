package de.craplezz.wizards.game;

import de.craplezz.wizards.Wizards;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Set;

/**
 * @author Overload
 * @version 1.0
 */
public abstract class GameStatus extends BukkitRunnable {

    private int counter;
    private Set<Integer> broadcastTimes;

    public GameStatus(int counter, Set<Integer> broadcastTimes) {
        this.counter = counter;
        this.broadcastTimes = broadcastTimes;
    }

    public void startCountdown() {
        if (counter > 0 && broadcastTimes != null) {
            super.runTaskTimer(Wizards.getInstance(), 0L, 20L);
        }
    }

    @Override
    public void run() {
        tickSecond();
        if (broadcastTimes.contains(counter--)) {
            tickBroadcast();
        }
    }

    public abstract void onEnter();

    public abstract void onLeave();

    public void tickSecond() {}

    public void tickBroadcast() {}

}
