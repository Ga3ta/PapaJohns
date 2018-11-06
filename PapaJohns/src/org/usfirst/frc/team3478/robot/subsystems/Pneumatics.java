package org.usfirst.frc.team3478.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pneumatics extends Subsystem{
	private Compressor cp = new Compressor();
	private Solenoid sn1 = new Solenoid(0);
	private Joystick joystick = new Joystick(0);
	
	protected void initDefaultCommand() {		
	}
	
	public void neumat(){
		cp.start();
		int sw = 0;
		
		while(sw == 0){
			sn1.set(true);
			if(joystick.getRawButton(2)==true){
				sw = 1;
			}
		}
		while(sw == 1){
			sn1.set(false);
			if(joystick.getRawButton(2)==true){
				sw = 0;
			}
		}
		
		boolean pSwitch = cp.getPressureSwitchValue();
		if(pSwitch == true){
			cp.stop();
			Timer.delay(30);
			cp.start();
		}
	}
}
