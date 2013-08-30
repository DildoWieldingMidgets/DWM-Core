package com.runebrire.core;

import java.sql.Connection;

import org.bukkit.plugin.java.JavaPlugin;

import com.runebrire.core.data.DataHandler;
import com.runebrire.core.data.MySQL;

public class Core extends JavaPlugin {
	/*
	 * @author Desty
	 */
	private MySQL _mysql = new MySQL(this, "198.27.82.9", "3306", "mc_20", "mc_20", "3a2eb541ff");
	private static Connection _c = null;
	static DataHandler datahandler = new DataHandler(_c);

	@Override
	public void onEnable() {
		_c = _mysql.openConnection();
	}

	@Override
	public void onDisable() {

	}

	public static DataHandler getDataHandler() {
		return datahandler;
	}

}
