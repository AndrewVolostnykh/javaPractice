package com.binary_studio.fleet_commander.core.common;

public class NamedEntityImpl implements NamedEntity {

	private String name;

	public NamedEntityImpl(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

}
