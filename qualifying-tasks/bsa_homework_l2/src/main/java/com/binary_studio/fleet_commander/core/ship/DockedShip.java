package com.binary_studio.fleet_commander.core.ship;

import com.binary_studio.fleet_commander.core.common.PositiveInteger;
import com.binary_studio.fleet_commander.core.exceptions.InsufficientPowergridException;
import com.binary_studio.fleet_commander.core.exceptions.NotAllSubsystemsFitted;
import com.binary_studio.fleet_commander.core.ship.contract.ModularVessel;
import com.binary_studio.fleet_commander.core.subsystems.contract.AttackSubsystem;
import com.binary_studio.fleet_commander.core.subsystems.contract.DefenciveSubsystem;

public final class DockedShip implements ModularVessel {

	private String name;

	private PositiveInteger shieldHP;

	private PositiveInteger hullHP;

	private PositiveInteger powergridOutput;

	private PositiveInteger capacitorAmount;

	private PositiveInteger capacitorRechargeRate;

	private PositiveInteger speed;

	private PositiveInteger size;

	private AttackSubsystem attackSubsystem;

	private DefenciveSubsystem defenciveSubsystem;

	public static DockedShip construct(String name, PositiveInteger shieldHP, PositiveInteger hullHP,
			PositiveInteger powergridOutput, PositiveInteger capacitorAmount, PositiveInteger capacitorRechargeRate,
			PositiveInteger speed, PositiveInteger size) {

		return new DockedShip(name, shieldHP, hullHP, powergridOutput, capacitorAmount, capacitorRechargeRate, speed,
				size);
	}

	public DockedShip(String name, PositiveInteger shieldHP, PositiveInteger hullHP, PositiveInteger powergridOutput,
			PositiveInteger capacitorAmount, PositiveInteger capacitorRechargeRate, PositiveInteger speed,
			PositiveInteger size) {
		this.name = name;
		this.shieldHP = shieldHP;
		this.hullHP = hullHP;
		this.powergridOutput = powergridOutput;
		this.capacitorAmount = capacitorAmount;
		this.capacitorRechargeRate = capacitorRechargeRate;
		this.speed = speed;
		this.size = size;
	}

	@Override
	public void fitAttackSubsystem(AttackSubsystem subsystem) throws InsufficientPowergridException {

		if (subsystem == null) {
			this.attackSubsystem = null;
		}
		else {

			if (this.defenciveSubsystem != null) {
				int tempSum = this.defenciveSubsystem.getPowerGridConsumption().value()
						+ subsystem.getPowerGridConsumption().value();

				if (tempSum > this.powergridOutput.value()) {
					throw new InsufficientPowergridException(tempSum - this.powergridOutput.value());
				}
				else {
					this.attackSubsystem = subsystem;
				}
			}
			else {
				if (subsystem.getPowerGridConsumption().value() >= this.powergridOutput.value()) {
					throw new InsufficientPowergridException(
							subsystem.getPowerGridConsumption().value() - this.powergridOutput.value());
				}
				else {
					this.attackSubsystem = subsystem;
				}
			}
		}
	}

	@Override
	public void fitDefensiveSubsystem(DefenciveSubsystem subsystem) throws InsufficientPowergridException {

		if (subsystem == null) {
			this.defenciveSubsystem = null;
		}
		else {

			if (this.attackSubsystem != null) {

				int tempSum = this.attackSubsystem.getPowerGridConsumption().value()
						+ subsystem.getPowerGridConsumption().value();

				if (tempSum > this.powergridOutput.value()) {
					throw new InsufficientPowergridException(tempSum - this.powergridOutput.value());
				}
				else {
					this.defenciveSubsystem = subsystem;
				}
			}
			else {
				if (subsystem.getPowerGridConsumption().value() > this.powergridOutput.value()) {
					throw new InsufficientPowergridException(
							subsystem.getPowerGridConsumption().value() - this.powergridOutput.value());
				}
				else {
					this.defenciveSubsystem = subsystem;
				}
			}
		}
	}

	public CombatReadyShip undock() throws NotAllSubsystemsFitted {
		// TODO: Ваш код здесь :)
		if (this.defenciveSubsystem == null && this.attackSubsystem == null) {
			throw NotAllSubsystemsFitted.bothMissing();
		}
		else if (this.defenciveSubsystem == null) {
			throw NotAllSubsystemsFitted.defenciveMissing();
		}
		else if (this.attackSubsystem == null) {
			throw NotAllSubsystemsFitted.attackMissing();
		}

		return new CombatReadyShip(this.name, this.shieldHP, this.hullHP, this.capacitorAmount,
				this.capacitorRechargeRate, this.speed, this.size, this.defenciveSubsystem, this.attackSubsystem);
	}

}
