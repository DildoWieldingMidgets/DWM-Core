package com.runebrire.core.player;

import org.bukkit.entity.Player;

/**
 * This is our player file for saving very basic info about a player not 100% if this will be used very much
 * 
 * @author Desty
 * 
 */
public class TtorPlayer {

	private Player _player;
	private String _name;
	private Race _race;
	private Integer _balance;
	private Long _firstJoined; // see's when the first time they joined the server was

	/**
	 * Called when a player will first need to generate a player file after selecting their race
	 */
	public TtorPlayer(Player player, Race race) {
		_player = player;
		_name = player.getName();
		_race = race;
		_firstJoined = System.currentTimeMillis();
	}

	public void save() {

	}

	public String getName() {
		return _name;
	}

	public Race getRace() {
		return _race;
	}

	public Integer getBalance() {
		return _balance;
	}

	public void setBalance(int newBalance) {
		_balance = newBalance;
	}

	public Long getFirstJoinTime() {
		return _firstJoined;
	}
}
