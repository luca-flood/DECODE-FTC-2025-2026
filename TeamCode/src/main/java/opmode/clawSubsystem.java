package opmode;

import com.qualcomm.robotcore.hardware.Servo;
import com.rowanmcalpin.nextftc.core.Subsystem;
import com.rowanmcalpin.nextftc.core.command.Command;
import com.rowanmcalpin.nextftc.ftc.OpModeData;
import com.rowanmcalpin.nextftc.ftc.hardware.ServoToPosition;

public class clawSubsystem extends Subsystem {
    public static final clawSubsystem INSTANCE = new clawSubsystem();
    public clawSubsystem() {}

    public Servo servo;
    public String name = "axonMini";

    @Override
    public void initialize() {
        servo = OpModeData.INSTANCE.getHardwareMap().get(Servo.class, "axonMini");
    }

    public Command extendOut() {
        return new ServoToPosition(servo, // SERVO TO MOVE
                0.65, // POSITION TO MOVE TO
                this); // IMPLEMENTED SUBSYSTEM
    }

    public Command extendIn() {
        return new ServoToPosition(servo, // SERVO TO MOVE
                0.7767, // POSITION TO MOVE TO
                this); // IMPLEMENTED SUBSYSTEM
    }

}
