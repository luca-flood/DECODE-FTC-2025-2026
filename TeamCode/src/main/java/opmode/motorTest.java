package opmode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name="motor.test", group="Linear Opmode")
public class motorTest extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {



        DcMotor leftLift = hardwareMap.get(DcMotor.class, "leftLift");

        //leftLift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftLift.setTargetPosition(0);
        //leftLift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
       // leftLift.setPower(0);
        leftLift.setDirection(DcMotorSimple.Direction.FORWARD);

        int pos = 0;


        waitForStart();

        while (opModeIsActive()) {
/*
          if (gamepad1.x) {
                pos -= 10;
                //pos = Math.max(-7935, Math.min(-135, pos));
              leftLift.setTargetPosition(pos);
              leftLift.setPower(1);
              telemetry.addData("Current Pos", leftLift.getCurrentPosition());
              telemetry.update();
            }

            if (gamepad1.y) {
                pos += 10;
                //pos = Math.max(-7935, Math.min(-135, pos));
                leftLift.setTargetPosition(pos);
                leftLift.setPower(1);
                telemetry.addData("Current Pos", leftLift.getCurrentPosition());
                telemetry.update();
            }
            */

if (gamepad1.a){
        leftLift.setPower(1);
}
if (gamepad1.b){
    leftLift.setPower(-1);
}


            }
        }
    }
