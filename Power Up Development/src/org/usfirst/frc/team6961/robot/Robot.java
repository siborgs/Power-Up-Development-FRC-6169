package org.usfirst.frc.team6961.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;

public class Robot extends IterativeRobot
{
	/*
	 * 			    |SIGNAGE CHART| - Never Indicates programmatically fixes
	 * =============================================================
	 * 			    |Right Y Axis |Left Y Axis|
	 * Push Forward |    -1       |      -1   |
	 * Push Backward|     +1 	  |     +1    |
	 * 
	 * 			    |Left Drive Controller|Right Drive Controller|			
	 * Supply +1    |		Forwards	  |		Backwards		 |
	 * Supply -1    |		Backwards	  |		Forwards		 |
	 * Push Forward |		Backwards	  |		Forwards		 |
	 * Push Backward|		Forwards	  |		Backwards		 |
	 * =============================================================
	 */
	
	
	//Constants
	public int leftYAxis = 1;
	public int rightYAxis = 5;
	
	//PWM Constant
	public int leftDrivePort1 = 0;
	public int leftDrivePort2 = 1;
	public int rightDrivePort1 = 2;
	public int rightDrivePort2 = 3;
	
	//Object Models
	Joystick joystick;
	Joystick joystick2;
	
	Spark lSpark;
	Spark rSpark;
	Spark lSpark2;
	Spark rSpark2;
	
	public void robotInit()
	{
		joystick = new Joystick(0);
		joystick2 = new Joystick(1);
		
		lSpark = new Spark(leftDrivePort1);
		rSpark = new Spark(rightDrivePort1);
		lSpark2 = new Spark(leftDrivePort2);
		rSpark2 = new Spark(rightDrivePort2);
	}
	
	public void teleopPeriodic()
	{
		rSpark.set(joystick.getRawAxis(rightYAxis));
		lSpark.set(-1 * joystick.getRawAxis(leftYAxis));
		rSpark2.set(joystick.getRawAxis(rightYAxis));
		lSpark2.set(-1 * joystick.getRawAxis(leftYAxis));
	}
}