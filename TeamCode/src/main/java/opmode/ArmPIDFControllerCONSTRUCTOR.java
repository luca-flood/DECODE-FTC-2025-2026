package opmode;

import com.arcrobotics.ftclib.controller.PIDController;
import com.qualcomm.robotcore.hardware.DcMotorEx;

public class ArmPIDFControllerCONSTRUCTOR {
    private PIDController controller;
    private DcMotorEx liftRotateMotorRight, liftRotateMotorLeft;

    public static double p = 0.03, i = 0.0004, d = 0.0005;
    public static double f = 0.06;
    private final double ticks_in_degree = 700 / 180.0;

    private int targetPosition = 0;

    // Constructor that accepts motor parameters
    public ArmPIDFControllerCONSTRUCTOR(DcMotorEx rightMotor, DcMotorEx leftMotor) {
        liftRotateMotorRight = rightMotor;
        liftRotateMotorLeft = leftMotor;

        controller = new PIDController(p, i, d);
        liftRotateMotorRight.setDirection(DcMotorEx.Direction.REVERSE);
    }

    // method to set target pos
    public void setTargetPosition(int target) {
        this.targetPosition = target;
    }

    // see if the arm reached its target
    public boolean isAtTarget() {
        return Math.abs(liftRotateMotorLeft.getCurrentPosition() - targetPosition) < 10;
    }

    public int getCurrentPosition() {
        return liftRotateMotorLeft.getCurrentPosition();
    }

    // runs PID loop
    public void update() {
        int armPosition = liftRotateMotorLeft.getCurrentPosition();
        double pid = controller.calculate(armPosition, targetPosition);
        double ff = Math.cos(Math.toRadians(targetPosition / ticks_in_degree)) * f;
        double power = pid + ff;

        liftRotateMotorRight.setPower(power);
        liftRotateMotorLeft.setPower(power);
    }
}

