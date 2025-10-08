package opmode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.rowanmcalpin.nextftc.core.command.Command;
import com.rowanmcalpin.nextftc.core.command.utility.delays.Delay;
import com.rowanmcalpin.nextftc.ftc.hardware.controllables.MotorEx;
import com.rowanmcalpin.nextftc.pedro.PedroOpMode;
import com.rowanmcalpin.nextftc.core.command.groups.SequentialGroup;

@TeleOp(name="diddy.op")
public class nextFTCteleOP extends PedroOpMode {

    private final ElapsedTime runtime = new ElapsedTime();

    public Command driverControlled;
    public MotorEx FrontLeft;
    public MotorEx FrontRight;
    public MotorEx BackLeft;
    public MotorEx BackRight;
    public IMU imu;
    public MotorEx[] driveMotors;
    public String lastSequence;
    public int sequenceCount;
    public nextFTCteleOP() {
        super(clawSubsystem.INSTANCE);
    }
    clawSubsystem goon = new clawSubsystem();

    public void onStartButtonPressed () {
//        driverControlled = new MecanumDriverControlledFixed(driveMotors, gamepadManager.getGamepad1(), false, imu);
//        driverControlled.invoke();
        registerControls();
        runtime.reset();
    }
    private void registerControls() {
        gamepadManager.getGamepad1().getX().setPressedCommand(clawSubsystem.INSTANCE::extendIn);
        gamepadManager.getGamepad1().getY().setPressedCommand(clawSubsystem.INSTANCE::extendOut);
        gamepadManager.getGamepad1().getB().setPressedCommand(this::goon);
    }

    public Command goon() {
        return new SequentialGroup(
                clawSubsystem.INSTANCE.extendOut(),
                new Delay(1.67),
                clawSubsystem.INSTANCE.extendIn()
        );
    }
}
