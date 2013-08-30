package com.runebrire.core;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;

import org.bukkit.plugin.java.JavaPlugin;

import com.runebrire.core.data.DataHandler;
import com.runebrire.core.data.MySQL;

public class Core extends JavaPlugin {
	// registered subPlugins are stored here
	private static Map<String, JavaPlugin> SubPlugins = new HashMap<String, JavaPlugin>();
	// mySql Database
	private MySQL _mysql = new MySQL(this, "198.27.82.9", "3306", "mc_20", "mc_20", "3a2eb541ff");
	private static Connection _c = null;
	// DataHandler is for sending/retrieving data from database
	static DataHandler datahandler = new DataHandler(_c);

	@Override
	public void onEnable() {
		_c = _mysql.openConnection();
	}

	/**
	 * Grab the dataHandler instance for query and updating SQL
	 * 
	 * @return
	 */
	public static DataHandler getDataHandler() {
		return datahandler;
	}

	/**
	 * ALWAYS REGISTER A SUBPLUGIN THROUGH THIS!
	 * 
	 * @param PluginName - Exact Name of subplugin
	 * @param plugin - instance of the subPlugin
	 */
	public void registerSubPlugin(String PluginName, JavaPlugin plugin) {
		if (plugin != null) {
			SubPlugins.put(PluginName, plugin);
			return;
		}
		getLogger().log(Level.SEVERE, "Cannot load Ttor SubPlugin: " + PluginName);
	}

	/**
	 * Check what subplugins are registered here.
	 * 
	 * @return list of subplugins
	 */
	public List<String> getSubPlugins() {
		List<String> Plist = new ArrayList<String>();
		for (Entry<String, JavaPlugin> entry : SubPlugins.entrySet()) {
			Plist.add(entry.getKey());
		}
		return Plist;
	}

	/**
	 * Get an instance of a subPlugin to do whatever you need ;)
	 * 
	 * @param SubPlugin - name of the subplugin ur looking for
	 * @return instance of the plugin
	 */
	public JavaPlugin getSubPlugin(String SubPlugin) {
		if (SubPlugins.get(SubPlugin) != null) {
			return SubPlugins.get(SubPlugin);
		}
		return null;
	}
}
