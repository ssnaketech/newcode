package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

// PROGRAM PRINCIPAL
@TeleOp(name="Bucuresti_v2", group="Linear OpMode")

public class faras_basculabil extends LinearOpMode {

    private DcMotor Motor_A1;
    private DcMotor Motor_A2;
    private DcMotor Motor_Basculanta;
    private DcMotor Motor_Aspirator;


    @Override
    public void runOpMode() {

        Motor_A1            = hardwareMap.dcMotor.get("Motor_A1");
        Motor_A2            = hardwareMap.dcMotor.get("Motor_A2");
        Motor_Basculanta    = hardwareMap.dcMotor.get("Motor_Brat");
        Motor_Aspirator     = hardwareMap.dcMotor.get("Motor_Aspirator");
        Motor_A1.setDirection(DcMotor.Direction.REVERSE);
        Motor_A2.setDirection(DcMotor.Direction.FORWARD);
        Motor_Basculanta.setDirection(DcMotor.Direction.REVERSE);
        Motor_Basculanta.setZeroPowerBehavior(BR);

        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {


            //--------------------------------------------------------------------------------------

                Motor_A1.setPower(-gamepad1.left_stick_y / 3);

                Motor_A2.setPower(-gamepad1.right_stick_y / 3);



            //--------------------------------------------------------------------------------------
            if (gamepad2.right_stick_y != 0)
                Motor_Basculanta.setPower(gamepad2.right_stick_y /4);

             if(gamepad2.left_stick_y == 0)
                 Motor_Basculanta.setPower(gamepad2.left_stick_y /10);

            if (gamepad2.right_bumper == true) {
                Motor_Aspirator.setPower(1);
            }
            if (gamepad2.left_bumper == true) {
                Motor_Aspirator.setPower(0);
            }
            //------------------------------------------------------------------------
        }
    }
}




