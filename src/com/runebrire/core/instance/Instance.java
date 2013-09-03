package com.runebrire.core.instance;

import org.bukkit.World;

public class Instance {
	private static Integer _qCount = 0;
	private static Integer _dCount = 0;

	private Integer _id = null;
	private World _world = null;

	public Instance(World world, Integer id) {
		_world = world;
		_id = id;
	}

	public Integer getId() {
		return _id;
	}

	public World getWorld() {
		return _world;
	}

}
