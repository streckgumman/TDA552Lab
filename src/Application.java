import com.company.*;
import controllers.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Application {

    // The delay (ms) corresponds to 59 updates a sec (hz)
    private final int delay = 17;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());
    private static VehicleController cc;

    public static void main(String[] args) {
        // Instance of this class
        Application application = new Application();
        //Creating a VehicleView
        //VehicleView view = new VehicleView("Carsim 1,0", cc);
        //Creating a VehicleController
        cc = new VehicleController();

        //cc.addVehicle(new Volvo240(0, 0, CardinalDirections.cardinalDirection.NORTH));
        //cc.addVehicle(new Saab95(100, 0, CardinalDirections.cardinalDirection.NORTH));
        //cc.addVehicle(new Scania(200, 0, cardinalDirection.NORTH));

        cc.cars.add(new Volvo240(0, 0, CardinalDirections.cardinalDirection.NORTH));
        cc.cars.add(new Saab95(100, 0, CardinalDirections.cardinalDirection.NORTH));
        cc.cars.add(new Scania(200, 0, CardinalDirections.cardinalDirection.NORTH.NORTH));

        // Start the timer
        application.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            moveAllCars();
        }
    }

    private void moveAllCars(){
        cc.moveAllCars();
    }
}