package com.runebrire.core;

import java.sql.Connection;

import org.bukkit.plugin.java.JavaPlugin;

import com.runebrire.core.data.MySQL;

public class main extends JavaPlugin {
	/*
	 * @author Desty
	 */
	MySQL mysql = new MySQL(this, "198.27.82.9", "3306", "mc_20", "mc_20", "3a2eb541ff");
	Connection c = null;

	@Override
	public void onEnable() {
		c = mysql.openConnection();
	}

	@Override
	public void onDisable() {

	}

}
