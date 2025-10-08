package opmode;

import com.rowanmcalpin.nextftc.core.Subsystem;
import com.rowanmcalpin.nextftc.core.command.Command;
import com.rowanmcalpin.nextftc.core.control.controllers.PIDFController;
import com.rowanmcalpin.nextftc.core.control.controllers.feedforward.StaticFeedforward;
import com.rowanmcalpin.nextftc.ftc.hardware.controllables.MotorEx;
import com.rowanmcalpin.nextftc.ftc.hardware.controllables.RunToPosition;

public class subsystemDesign extends Subsystem {

    public static final subsystemDesign INSTANCE = new subsystemDesign();
    private subsystemDesign () {}

    public MotorEx motor;
    public PIDFController controller = new PIDFController(0.005, 0.0, 0.0, new StaticFeedforward(0.0));

    public String name = "lift_motor";


    @Override
    public void initialize(){
        motor = new MotorEx (name);
    }

    public Command toLow() {
        return new RunToPosition(motor,
               0.0, //the target position
                controller, /* pid controller motor/subsystem uses */
                this); //passing the subsystem for system control,
                        // in simple it does not allow multiple commands of same
                        // subsystem to be running at same time
    }
    public Command toMid() {
        return new RunToPosition(motor,
                50,
                controller,
                this);
    }

    public Command toHigh() {
        return new RunToPosition(motor,
                100,
                controller,
                this);
    }

}
