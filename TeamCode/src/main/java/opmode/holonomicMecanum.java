package opmode;

import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.rowanmcalpin.nextftc.core.command.Command;
import com.rowanmcalpin.nextftc.ftc.hardware.controllables.MotorEx;

public class holonomicMecanum {

    public String frontLeft = "front_left";
    public String frontRight = "front_right";
    public String backLeft = "back_left";
    public String backRight = "back_right";

    public MotorEx frontLeftMotor;
    public MotorEx frontRightMotor;
    public MotorEx backLeftMotor;
    public MotorEx backRightMotor;

    public MotorEx[] motors;

    public Command driverControlled;

    public void onInit()
    {
        frontLeftMotor = new MotorEx(frontLeft);
        backLeftMotor = new MotorEx(backLeft);
        backRightMotor = new MotorEx(backRight);
        frontRightMotor = new MotorEx(frontRight);

// Change your motor directions to suit your robot.
        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        frontRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        backRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        motors = new MotorEx[]{frontLeftMotor, frontRightMotor, backLeftMotor, backRightMotor};
    }
    /*public void onStartButtonPressed(){
        driverControlled = new MecanumDriverControlled(motors, gamepadManager.getGamepad1());
        driverControlled.invoke();
    }
*/
}
