/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3478.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Chassis extends Subsystem {
	public double lx1, rt1, lt1, POWER, POWER0;
	TalonSRX L, R;
	private static Joystick joystick1 = new Joystick(0);
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	public void run(){
		lx1 = joystick1.getRawAxis(0);
		rt1 = -joystick1.getRawAxis(3);
		lt1 = -joystick1.getRawAxis(2);
		L = new TalonSRX(1);
		R = new TalonSRX(2);
		POWER = rt1 - lt1;
		if(POWER == 0) {
			POWER0 = -1;
		}
		else {
			POWER0 = POWER;
		}
		if(POWER >= -0.05 && POWER <= 0.05) {
			POWER = 0;
		}
		
		if(-0.05<lx1 && lx1<0.05){
			lx1 = 0;
		}
				
		L.set(ControlMode.PercentOutput, -POWER-POWER0*lx1*.8);
		R.set(ControlMode.PercentOutput, POWER-POWER0*0.8*lx1);

	}
	
}
