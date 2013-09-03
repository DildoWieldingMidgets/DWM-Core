package com.runebrire.core.instance;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.bukkit.World;
import org.bukkit.World.Environment;
import org.bukkit.WorldType;

import com.onarandombox.MultiverseCore.MultiverseCore;

/**
 * Grab this handler to create/delete instances
 * 
 * @author Desty
 * 
 */
public class InstanceHandler {
	private MultiverseCore _mvCore;
	private static Integer _iCount = 0;
	private static Map<Integer, Instance> _instances = new HashMap<Integer, Instance>();

	public InstanceHandler(MultiverseCore mvCore) {
		_mvCore = mvCore;
	}

	/**
	 * Makes a new instance from a baseWorld
	 * 
	 * @param baseWorld - world to copy from
	 * @return - true = sucess, false = failure
	 */
	public boolean createInstance(World baseWorld) {
		File worldFile = baseWorld.getWorldFolder();
		int id = genId();
		String name = baseWorld.getName() + id;
		try {
			FileUtils.copyDirectory(worldFile, new File(getInstanceFolderDir(name)), true);
			File uid = new File(_mvCore.getServerFolder() + "\\" + name + "\\uid.dat");
			uid.delete();
			_mvCore.getMVWorldManager().addWorld(name, Environment.NORMAL, "", WorldType.NORMAL, false, null);
			World w = _mvCore.getServer().getWorld(name);
			Instance is = new Instance(w, id);
			_instances.put(id, is);
			return true;
		} catch (IOException e) {
			return false;
		}
	}

	/**
	 * delete an instanced world
	 * 
	 * @param idKey - id of the instanced world
	 */
	public void deleteInstance(Integer idKey) {
		Instance i = _instances.get(idKey);
		if (i != null) {
			_instances.remove(idKey);
			_mvCore.getMVWorldManager().deleteWorld(i.getWorld().getName());
		}
	}

	/**
	 * delete an instanced
	 * 
	 * @param is - instance
	 */
	public void deleteInstance(Instance is) {
		deleteInstance(is.getId());
	}

	public Map<Integer, Instance> getInstances() {
		return _instances;
	}

	/**
	 * Dont worry bout these two methods ;) they just get the dir to save the world and gen a instance id
	 */
	private String getInstanceFolderDir(String worldName) {
		String s = _mvCore.getServerFolder().getAbsolutePath();
		s = s + worldName + "-";
		return s;
	}

	private int genId() {
		int i = _iCount;
		_iCount++;
		return i;
	}
}
