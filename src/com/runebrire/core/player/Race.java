package com.runebrire.core.player;

/**
 * Enum list of all races, each race with a string name
 * 
 * @author Desty
 * 
 */

public enum Race {
	Human("Human"), Elf("Elf"), Orc("Orc"), Dwarf("Dwarf"), Avian("Avian"), Neko("Neko");

	private final String _raceName;

	Race(String raceName) {
		_raceName = raceName;
	}

	public String getName() {
		return _raceName;
	}
}
