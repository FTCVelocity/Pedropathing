package org.firstinspires.ftc.teamcode.pedroPathing;

import com.pedropathing.follower.Follower;
import com.pedropathing.follower.FollowerConstants;
import com.pedropathing.ftc.FollowerBuilder;
import com.pedropathing.paths.PathConstraints;
import com.pedropathing.ftc.drivetrains.MecanumConstants;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Constants for Pedro Pathing 2.0.0
 * Includes follower constants, path constraints, and mecanum drivetrain setup.
 */
public class Constants {

    // Follower constants (including robot mass for centripetal compensation)
    public static final FollowerConstants followerConstants = new FollowerConstants()
            .mass(10.7); // robot weight in kg

    // Path constraints — adjust to your robot's performance
    public static final PathConstraints pathConstraints = new PathConstraints(
            40,   // maxVelocity in in/sec
            100,  // maxAcceleration in in/sec^2
            1,    // positionTolerance in inches
            1     // headingTolerance in degrees
    );

    // Mecanum drivetrain configuration
    //need to rename motors and add direction and power
    public static final MecanumConstants driveConstants = new MecanumConstants()
            .maxPower(1)
            .rightFrontMotorName("frontright")
            .rightRearMotorName("backright")
            .leftRearMotorName("backleft")
            .leftFrontMotorName("backleft")
            .leftFrontMotorDirection(DcMotorSimple.Direction.REVERSE)
            .leftRearMotorDirection(DcMotorSimple.Direction.REVERSE)
            .rightFrontMotorDirection(DcMotorSimple.Direction.FORWARD)
            .rightRearMotorDirection(DcMotorSimple.Direction.FORWARD);

    /**
     * Creates and returns a Pedro Pathing Follower configured for a mecanum drive.
     */
    public static Follower createFollower(HardwareMap hardwareMap) {
        return new FollowerBuilder(followerConstants, hardwareMap)
                .pathConstraints(pathConstraints)
                .mecanumDrivetrain(driveConstants) // this method expects a MecanumConstants
                .build();
    }
}
