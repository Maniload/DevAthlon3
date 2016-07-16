package de.craplezz.wizards.game;

import de.craplezz.wizards.Wizards;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Set;

/**
 * @author Overload
 * @version 1.0
 */
public abstract class GameStatus extends BukkitRunnable {

    protected final int initialCounter;
    protected int counter;
    private Set<Integer> broadcastTimes;

    public GameStatus(int counter, Set<Integer> broadcastTimes) {
        this.initialCounter = counter;
        this.counter = initialCounter;
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

        if (counter <= 0) {
            cancel();

            onCountdownFinished();
        }
    }

    public abstract void onEnter();

    public abstract void onLeave();

    public void tickSecond() {}

    public void tickBroadcast() {}

    public void onCountdownFinished() {}

}
