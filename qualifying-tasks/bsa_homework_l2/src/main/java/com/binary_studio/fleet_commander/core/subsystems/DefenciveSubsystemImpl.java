package com.binary_studio.fleet_commander.core.subsystems;

import com.binary_studio.fleet_commander.core.actions.attack.AttackAction;
import com.binary_studio.fleet_commander.core.actions.defence.RegenerateAction;
import com.binary_studio.fleet_commander.core.common.PositiveInteger;
import com.binary_studio.fleet_commander.core.subsystems.contract.DefenciveSubsystem;

public final class DefenciveSubsystemImpl implements DefenciveSubsystem {

	private String name;

	private PositiveInteger powerGridConsumption;

	private PositiveInteger capacitorConsumption;

	private PositiveInteger impactReductionPercent;

	private PositiveInteger shieldRegeneration;

	private PositiveInteger hullRegeneration;

	public static DefenciveSubsystemImpl construct(String name, PositiveInteger powergridConsumption,
			PositiveInteger capacitorConsumption, PositiveInteger impactReductionPercent,
			PositiveInteger shieldRegeneration, PositiveInteger hullRegeneration) throws IllegalArgumentException {

		if (!name.isBlank() && !name.isEmpty()) {
			return new DefenciveSubsystemImpl(name, powergridConsumption, capacitorConsumption, impactReductionPercent,
					shieldRegeneration, hullRegeneration);
		}
		else {
			throw new IllegalArgumentException("Name should be not null and not empty");
		}
	}

	public DefenciveSubsystemImpl(String name, PositiveInteger powergridConsumption,
			PositiveInteger capacitorConsumption, PositiveInteger impactReductionPercent,
			PositiveInteger shieldRegeneration, PositiveInteger hullRegeneration) {
		this.name = name;
		this.powerGridConsumption = powergridConsumption;
		this.capacitorConsumption = capacitorConsumption;
		this.hullRegeneration = hullRegeneration;

		if (impactReductionPercent.value() < 95) {
			this.impactReductionPercent = impactReductionPercent;
		}
		else {
			this.impactReductionPercent = PositiveInteger.of(95);
		}

		this.shieldRegeneration = shieldRegeneration;

	}

	@Override
	public PositiveInteger getPowerGridConsumption() {
		return this.powerGridConsumption;
	}

	@Override
	public PositiveInteger getCapacitorConsumption() {
		return this.capacitorConsumption;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public AttackAction reduceDamage(AttackAction incomingDamage) {
		double damage = (double) incomingDamage.damage.value()
				* (1.0d - ((double) this.impactReductionPercent.value()) / 100.0d);
		return new AttackAction(PositiveInteger.of((int) Math.ceil(damage)), incomingDamage.attacker,
				incomingDamage.target, incomingDamage.weapon);
	}

	@Override
	public RegenerateAction regenerate() {
		return new RegenerateAction(this.shieldRegeneration, this.hullRegeneration);
	}

}
