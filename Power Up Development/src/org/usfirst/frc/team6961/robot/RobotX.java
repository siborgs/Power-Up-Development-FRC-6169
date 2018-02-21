package org.usfirst.frc.team6961.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Timer;

public class RobotX extends IterativeRobot
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
	
	
	//Logitech Drive Constants
	public int leftYAxis = 1;
	public int rightYAxis = 5;
	
	public int rightTrigger = 3;
	public int leftTrigger = 2;
	
	//PS4 Drive Constants
	public int YAxis = 1; 
	//Left Joystick
	public int ZRotate = 5; 
	//Right Joystick 
	
	//PWM Constant
	public int leftDrivePort1 = 0;
	public int leftDrivePort2 = 1;
	public int rightDrivePort1 = 2;
	public int rightDrivePort2 = 3;
	public int rightGrabberPort = 4;
	public int leftGrabberPort = 5;
	public int Lifter1Port = 6;
	public int Lifter2Port = 7;
	
	
	//Object Models
	Joystick joystick;
	Joystick joystick2;
	
	Spark lSpark;
	Spark rSpark;
	Spark lSpark2;
	Spark rSpark2;
	
	Spark lSparkGrabber;
	Spark rSparkGrabber;
	
	Spark SparkLifter1;
	Spark SparkLifter2;
	
	int nStateAuto;
	double dTimeAuto;
	
	
	public void robotInit()
	{
		joystick = new Joystick(0);
		joystick2 = new Joystick(1);
		
		lSpark = new Spark(leftDrivePort1);
		rSpark = new Spark(rightDrivePort1);
		lSpark2 = new Spark(leftDrivePort2);
		rSpark2 = new Spark(rightDrivePort2);
		
		rSparkGrabber = new Spark(rightGrabberPort);
		lSparkGrabber = new Spark(leftGrabberPort);
	
		SparkLifter1 = new Spark(Lifter1Port);
		SparkLifter2 = new Spark(Lifter2Port);
	}
	
	public void teleopPeriodic()
	{
		//basic tank drive system on Logitech controller
		rSpark.set(joystick.getRawAxis(rightYAxis));
		lSpark.set(-1 * joystick.getRawAxis(leftYAxis));
		rSpark2.set(joystick.getRawAxis(rightYAxis));
		lSpark2.set(-1 * joystick.getRawAxis(leftYAxis));
		
		//Grabber
		rSparkGrabber.set(joystick2.getRawAxis(YAxis));
		lSparkGrabber.set(-1 * joystick2.getRawAxis(YAxis));
		
		//Lifter

		SparkLifter1.set(.1 * joystick2.getRawAxis(ZRotate));
		SparkLifter2.set(.1 * joystick2.getRawAxis(ZRotate));

	
		//Autonomous Mode	
	}
	public void autonomousInit() {
		dTimeAuto= 0;
		nStateAuto= 0;
	}
	
	public void autonomousPeriodic() {
		if (nStateAuto== 0) {
			dTimeAuto= Timer.getFPGATimestamp();
			nStateAuto= 1;
			rSpark.set(0.4);
			lSpark.set(-0.4);
			rSpark2.set(0.4);
			lSpark2.set(-0.4);
		}
		if (nStateAuto== 1 && Timer.getFPGATimestamp()- dTimeAuto> 3) {
			dTimeAuto= Timer.getFPGATimestamp();
			nStateAuto= 2;
			rSpark.set(0.0);
			lSpark.set(0.0);
			rSpark2.set(0.0);
			lSpark2.set(0.0);
		}
	}
	
	
}