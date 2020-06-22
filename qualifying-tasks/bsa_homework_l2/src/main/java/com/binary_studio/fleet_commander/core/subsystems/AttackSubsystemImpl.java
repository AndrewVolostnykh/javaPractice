package com.binary_studio.fleet_commander.core.subsystems;

import com.binary_studio.fleet_commander.core.common.Attackable;
import com.binary_studio.fleet_commander.core.common.PositiveInteger;
import com.binary_studio.fleet_commander.core.subsystems.contract.AttackSubsystem;

public final class AttackSubsystemImpl implements AttackSubsystem {

	private String inputName;

	private PositiveInteger inputPowerGrid;

	private PositiveInteger inputCapacitorConsumption;

	private PositiveInteger inputOptimalSpeed;

	private PositiveInteger inputOptimalSize;

	private PositiveInteger inputBaseDamage;

	public static AttackSubsystemImpl construct(String name, PositiveInteger powergridRequirments,
			PositiveInteger capacitorConsumption, PositiveInteger optimalSpeed, PositiveInteger optimalSize,
			PositiveInteger baseDamage) throws IllegalArgumentException {

		if (!name.isBlank() && !name.isEmpty()) {
			return new AttackSubsystemImpl(name, powergridRequirments, capacitorConsumption, optimalSpeed, optimalSize,
					baseDamage);
		}
		else {
			throw new IllegalArgumentException("Name should be not null and not empty");
		}
	}

	public AttackSubsystemImpl(String name, PositiveInteger powergridRequirments, PositiveInteger capacitorConsumption,
			PositiveInteger optimalSpeed, PositiveInteger optimalSize, PositiveInteger baseDamage) {
		this.inputName = name;
		this.inputPowerGrid = powergridRequirments;
		this.inputCapacitorConsumption = capacitorConsumption;
		this.inputOptimalSize = optimalSize;
		this.inputOptimalSpeed = optimalSpeed;
		this.inputBaseDamage = baseDamage;
	}

	@Override
	public PositiveInteger getPowerGridConsumption() {
		return this.inputPowerGrid;
	}

	@Override
	public PositiveInteger getCapacitorConsumption() {
		return this.inputCapacitorConsumption;
	}

	@Override
	public PositiveInteger attack(Attackable target) {
		double sizeReductionModifier;
		double speedReductionModifier;

		if (target.getSize().value() <= 0) {
			return PositiveInteger.of(0);
		}

		if (target.getSize().value() >= this.inputOptimalSize.value()) {
			sizeReductionModifier = 1;
		}
		else {
			sizeReductionModifier = (double) target.getSize().value() / (double) this.inputOptimalSize.value();
		}

		if (target.getCurrentSpeed().value() <= this.inputOptimalSpeed.value()) {
			speedReductionModifier = 1;
		}
		else {
			speedReductionModifier = (double) this.inputOptimalSpeed.value()
					/ (2 * (double) target.getCurrentSpeed().value());
		}

		return PositiveInteger.of((int) Math
				.ceil(Math.min(speedReductionModifier, sizeReductionModifier) * this.inputBaseDamage.value()));
	}

	@Override
	public String getName() {
		return this.inputName;
	}

}
