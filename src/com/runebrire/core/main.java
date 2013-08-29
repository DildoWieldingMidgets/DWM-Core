package com.runebrire.core;

import java.sql.Connection;

import org.bukkit.plugin.java.JavaPlugin;

import com.runebrire.core.data.MySQL;

public class main extends JavaPlugin {
	/*
	 * @author Desty
	 */
	MySQL MySQL = new MySQL(this, "host.name", "Ttor_database", "3119", "user", "pass");
	Connection c = null;

	@Override
	public void onEnable() {
		c = MySQL.openConnection();
	}

	@Override
	public void onDisable() {

	}

}
