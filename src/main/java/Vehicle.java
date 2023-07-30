public class Vehicle {

    public Vehicle(int initialAltitude) {
        // initialize the altitude AND previous altitude to initialAltitude
        this.altitude = initialAltitude;
        this.prevAltitude = initialAltitude;
    }

    int gravity = 100;
    int altitude = 8000;
    int prevAltitude = 8000;

    int velocity = 1000;
    int fuel = 12000;
    int burn = 0;
    int flying = FLYING;
    /* The rate in which the spaceship descents in free fall (in ten seconds) */

    // Various end-of-game messages and status result codes.
    String dead = "\nCRASH!!\n\tThere were no survivors.\n\n";
    public static final int DEAD = -3;
    String crashed = "\nThe Starship crashed. Good luck getting back home. Elon is pissed.\n\n";
    public static final int CRASHED = -2;
    String emptyfuel = "\nThere is no fuel left. You're floating around like Major Tom.\n\n";
    public static final int EMPTYFUEL = -1;
    String success = "\nYou made it! Good job!\n\n";
    public static final int SUCCESS = 0;
    public static final int FLYING = 1;

    // this is initial vehicle setup

    public Vehicle() {}

    public String checkFinalStatus() {
        String s = "";
        if (this.altitude <= 0) {
            if (this.velocity > 10) {
                s = crashed;
                flying = CRASHED;
            }
            if (this.velocity < 10 && this.velocity > 3) {
                s = dead;
                flying = DEAD;
            }
            if (this.velocity < 3) {
                s = success;
                flying = SUCCESS;
            }
        } else {
            if (this.altitude > 0) {
                s = emptyfuel;
                flying = EMPTYFUEL;
            } }
        return s;
    }


    public int computeDeltaV() {
        // return velocity + gravity - burn amount
        return velocity + (gravity - burn);
    }

    public void adjustForBurn(int burnAmount) {
        // set burn to burnamount requested
        this.burn = burnAmount;
        // save previousAltitude with current Altitude
        this.prevAltitude = altitude;
        // set new velocity to result of computeDeltaV function.
        this.velocity = computeDeltaV();
        // subtract speed from Altitude
        this.altitude -= velocity;
        // subtract burn amount fuel used from tank
        fuel -= burn;
    }

    public boolean stillFlying() {
        // return true if altitude is positive
        return altitude > 0;
    }
    public boolean outOfFuel() {
        // return true if fuel is less than or equal to zero
        return fuel <= 0;
    }

    public DescentEvent getStatus(int tick) {
        // create a return a new DescentEvent object
        // filled in with the state of the vehicle.
        return new DescentEvent(tick, this.velocity, this.fuel, this.altitude,this.flying );
    }

}
