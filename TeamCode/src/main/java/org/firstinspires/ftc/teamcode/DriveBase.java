package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.Range;

public class DriveBase {

    private DcMotor leftTopMotor;
    private DcMotor leftBottomMotor;
    private DcMotor rightTopMotor;
    private DcMotor rightBottomMotor;

    private double rightPower;
    private double leftPower;

    DriveBase(DcMotor leftTop, DcMotor leftBottom, DcMotor rightTop, DcMotor rightBottom) {
        this.leftTopMotor = leftTop;
        this.leftBottomMotor = leftBottom;
        this.rightTopMotor = rightTop;
        this.rightBottomMotor = rightBottom;
    }

    public double getRightPower() {
        return rightPower;
    }
    public double getLeftPower() {
        return leftPower;
    }

    public void drive(Gamepad joystick) {

        double drive = -joystick.left_stick_y;
        double turn = joystick.right_stick_x;

        leftPower = Range.clip(drive + turn, -1.0, 1);
        rightPower = Range.clip(drive - turn, -1.0, 1);



        if (joystick.left_stick_y > 0) {
            rightTopMotor.setPower(drive);
            rightBottomMotor.setPower(drive);
        }

        if (joystick.left_stick_y < 0) {
            leftTopMotor.setPower(drive);
            leftBottomMotor.setPower(drive);
        }

        if (joystick.right_stick_x > 0) {
            rightTopMotor.setPower(turn);
            rightBottomMotor.setPower(turn);
        }

        if (joystick.right_stick_x < 0) {
            leftTopMotor.setPower(turn);
            leftBottomMotor.setPower(turn);
        }

    }

}
