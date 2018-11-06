package org.usfirst.frc.team3478.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem{
	private Joystick joystick = new Joystick(0);
	private TalonSRX spin = new TalonSRX(0);
	protected void initDefaultCommand() {
		
	}
	public void take(){
		if(joystick.getRawButton(3)==true){
			spin.set(ControlMode.PercentOutput, -1);
		}
		if(joystick.getRawButton(4)){
			spin.set(ControlMode.PercentOutput, 0);
		}
	}
}
