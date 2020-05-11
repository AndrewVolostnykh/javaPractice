package com.binary_studio.fleet_commander.core.ship;

import java.util.Optional;

import com.binary_studio.fleet_commander.core.actions.attack.AttackAction;
import com.binary_studio.fleet_commander.core.actions.defence.AttackResult;
import com.binary_studio.fleet_commander.core.actions.defence.RegenerateAction;
import com.binary_studio.fleet_commander.core.common.Attackable;
import com.binary_studio.fleet_commander.core.common.NamedEntityImpl;
import com.binary_studio.fleet_commander.core.common.PositiveInteger;
import com.binary_studio.fleet_commander.core.ship.contract.CombatReadyVessel;
import com.binary_studio.fleet_commander.core.subsystems.contract.AttackSubsystem;
import com.binary_studio.fleet_commander.core.subsystems.contract.DefenciveSubsystem;

public final class CombatReadyShip implements CombatReadyVessel {

	private final PositiveInteger originalShieldHP;

	private final PositiveInteger originalHullHP;

	private final PositiveInteger originalCapacitorAmount;

	private String shipName;

	private PositiveInteger shieldHP;

	private PositiveInteger hullHP;

	private PositiveInteger capacitorAmount;

	private PositiveInteger capacitorRechargeRate;

	private PositiveInteger speed;

	private PositiveInteger size;

	private DefenciveSubsystem defenciveSubsystem;

	private AttackSubsystem attackSubsystem;

	private boolean turn;

	CombatReadyShip(String shipName, PositiveInteger shieldHP, PositiveInteger hullHP, PositiveInteger capacitorAmount,
			PositiveInteger capacitorRechargeRate, PositiveInteger speed, PositiveInteger size,
			DefenciveSubsystem defenciveSubsystem, AttackSubsystem attackSubsystem) {
		this.shipName = shipName;
		this.shieldHP = shieldHP;
		this.hullHP = hullHP;
		this.capacitorAmount = capacitorAmount;
		this.capacitorRechargeRate = capacitorRechargeRate;
		this.speed = speed;
		this.size = size;
		this.defenciveSubsystem = defenciveSubsystem;
		this.attackSubsystem = attackSubsystem;

		this.originalShieldHP = shieldHP;
		this.originalHullHP = hullHP;
		this.originalCapacitorAmount = capacitorAmount;

	}

	@Override
	public void endTurn() {
		if (this.originalCapacitorAmount.value() > this.capacitorAmount.value()) {
			int recharging = this.capacitorAmount.value() + this.capacitorRechargeRate.value();
			if (recharging > this.originalCapacitorAmount.value()) {
				this.capacitorAmount = this.originalCapacitorAmount;
			}
			else {
				this.capacitorAmount = PositiveInteger.of(recharging);
			}
		}

		this.turn = false;
	}

	@Override
	public void startTurn() {

		this.turn = true;
	}

	@Override
	public String getName() {
		return this.shipName;
	}

	@Override
	public PositiveInteger getSize() {
		return this.size;
	}

	@Override
	public PositiveInteger getCurrentSpeed() {
		return this.speed;
	}

	@Override
	public Optional<AttackAction> attack(Attackable target) {
		if (this.turn) {
			if (this.capacitorAmount.value() >= this.attackSubsystem.getCapacitorConsumption().value()) {
				AttackAction underAttack = new AttackAction(this.attackSubsystem.attack(target),
						new NamedEntityImpl(this.shipName), new NamedEntityImpl(target.getName()),
						new NamedEntityImpl(this.attackSubsystem.getName()));

				this.capacitorAmount = PositiveInteger.of(0); // capacitor discharged
				System.out.println(this.capacitorAmount.value());

				return Optional.of(underAttack);
			}
		}
		return Optional.empty(); // when not turn and capacitor was discharged
	}

	@Override
	public AttackResult applyAttack(AttackAction attack) {
		AttackAction action = this.defenciveSubsystem.reduceDamage(attack);
		int tempDamageCalculating;

		if (this.shieldHP.value() > 0) {

			tempDamageCalculating = this.shieldHP.value() - action.damage.value();
			this.shieldHP = PositiveInteger.of(tempDamageCalculating < 0 ? 0 : tempDamageCalculating);

		}
		else {

			tempDamageCalculating = this.hullHP.value() - action.damage.value();
			this.hullHP = PositiveInteger.of(tempDamageCalculating < 0 ? 0 : tempDamageCalculating);

			if (this.hullHP.value() <= 0) {
				return new AttackResult.Destroyed();
			}
		}

		return new AttackResult.DamageRecived(action.weapon, action.damage, action.target);
	}

	@Override
	public Optional<RegenerateAction> regenerate() {
		int shieldRegenerated;
		int hullRegenerated;

		if (this.turn) {
			if (this.capacitorAmount.value() >= this.defenciveSubsystem.getCapacitorConsumption().value()) {
				if (this.shieldHP.value().equals(this.originalShieldHP.value())) {
					shieldRegenerated = 0;
				}
				else {
					shieldRegenerated = this.defenciveSubsystem.regenerate().shieldHPRegenerated.value();

					if (shieldRegenerated > this.originalShieldHP.value()) {
						this.shieldHP = PositiveInteger.of(this.originalShieldHP.value());
					}
					else {
						this.shieldHP = PositiveInteger.of(shieldRegenerated + this.shieldHP.value());
					}
				}

				if (this.hullHP.value().equals(this.originalHullHP.value())) {
					hullRegenerated = 0;
				}
				else {
					hullRegenerated = this.hullHP.value()
							+ this.defenciveSubsystem.regenerate().hullHPRegenerated.value();

					if (hullRegenerated > this.originalShieldHP.value()) {
						this.hullHP = PositiveInteger.of(this.originalHullHP.value());
					}
					else {
						this.hullHP = PositiveInteger.of(hullRegenerated);
					}
				}

				this.capacitorAmount = PositiveInteger
						.of(this.capacitorAmount.value() - this.defenciveSubsystem.getCapacitorConsumption().value());

				return Optional.of(new RegenerateAction(PositiveInteger.of(shieldRegenerated),
						PositiveInteger.of(hullRegenerated)));
			}
		}
		return Optional.empty();
	}

}
