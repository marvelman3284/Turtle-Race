package shah.jeevan;

import java.awt.*;

public class Main {

    // Initialize all the global step variables
    public static int redSteps = 0;
    public static int blueSteps = 0;
    public static int greenSteps = 0;
    public static int orangeSteps = 0;
    public static int blackSteps = 0;
    public static int yellowSteps = 0;

    public static void main(String[] args) {

        // Initialize all the turtles while setting their position and color
        Turtle red = new Turtle();
        red.penColor(Color.red);
        red.up();
        red.setPosition(-200, 150);
        red.down();

        Turtle blue = new Turtle();
        blue.penColor(Color.blue);
        blue.up();
        blue.setPosition(-200, 100);
        blue.down();

        Turtle green = new Turtle();
        green.penColor(Color.green);
        green.up();
        green.setPosition(-200, 50);
        green.down();

        Turtle yellow = new Turtle();
        yellow.penColor(Color.yellow);
        yellow.up();
        yellow.setPosition(-200, 0);
        yellow.down();

        Turtle magenta = new Turtle();
        magenta.penColor(Color.magenta);
        magenta.up();
        magenta.setPosition(-200, -50);
        magenta.down();

        Turtle black = new Turtle();
        black.penColor(Color.black);
        black.up();
        black.setPosition(-200, -100);
        black.down();

        // Create an array of each turtle (needed for checkWin func
        Turtle[] turtArr = {red, blue, green, yellow, magenta, black};

        // game loop
        while (!checkWin(turtArr)) {

            // update the steps value for each move
            redSteps = move(red, redSteps);
            greenSteps = move(green, greenSteps);
            blueSteps = move(blue, blueSteps);
            blackSteps = move(black, blackSteps);
            yellowSteps = move(yellow, yellowSteps);
            orangeSteps = move(magenta, orangeSteps);

            // once a turtle has won
            if (checkWin(turtArr)) {

                // check which turtle has won and output the winner
                if (red.getX() >= 200 && redSteps >= 400) { System.out.println("Red Winner"); }
                else if (blue.getX() >= 200 && blueSteps >= 400) { System.out.println("Blue Winner"); }
                else if (green.getX() >= 200 && greenSteps >= 400) { System.out.println("Green Winner"); }
                else if (black.getX() >= 200 && blackSteps >= 400) { System.out.println("Black Winner"); }
                else if (yellow.getX() >= 200 && yellowSteps >= 400) { System.out.println("Yellow Winner"); }
                else if (magenta.getX() >= 200 && orangeSteps >= 400) { System.out.println("Magenta Winner"); }
            }
        }
    }

    public static int random(int min, int max) {
        // return a random number between min and max
        return (int) Math.floor(max*Math.random()) + min;
    }

    // move each turtle as well as incrementing their step count
    public static int move(Turtle t, int var) {

        int dir = random(-35, 80); // set a direction
        int move = random(10, 70); // set an amount for his name to move

        var += move; // increase the step count by the amount the turtle moved

        // prevent the turtle from going off the screen on the y-axis
        if (t.getY() >= 170 || t.getY() <= -170) {
            t.setDirection(45);
            t.forward(random(10, 30));
        }

        // prevent the turtle from off the screen on the x-axis
        // (prob not needed but im scared to remove it
        if (t.getX() <= -220 ) {
            t.setDirection(90);
            t.forward(random(10, 30));
        } else {
            // if the turtle isn't going to be off the screen then just move it randomly
            t.setDirection(dir);
            t.forward(move);
        }

        // return the new step count
        return var;
    }

    // check if a turtle has won the race
    public static boolean checkWin(Turtle[] arr) {
        // loop through every turtle in the race
        for (Turtle t : arr) {
            // if the turtle is 200 'steps' to the right then it has won the game
            if (t.getX() >= 200 ) {
                return true;
            }
        }
        // if no one has reached the end then the race isn't over
        return false;
    }
}
