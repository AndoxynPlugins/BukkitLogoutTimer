/*
 * Copyright (C) 2013 Dabo Ross <www.daboross.net>
 */
package net.daboross.bukkitdev.logouttimer;

import org.bukkit.scheduler.BukkitRunnable;

/**
 *
 * @author daboross
 */
public class LogoutTimerTimer extends BukkitRunnable {

    private final LogoutTimerPlugin plugin;
    private final String username;

    public LogoutTimerTimer(LogoutTimerPlugin plugin, String username) {
        this.plugin = plugin;
        this.username = username.toLowerCase();
        plugin.currentlyWaiting.add(this.username);
    }

    @Override
    public void run() {
        plugin.currentlyWaiting.remove(username);
    }

    public static void newTimer(String username, LogoutTimerPlugin plugin) {
        new LogoutTimerTimer(plugin, username).runTaskLater(plugin, plugin.getConfig().getInt("time-allowed"));
    }
}
