public class NBody {

    public static int starNumber = 0;
    public static double readRadius(String filePath){
        In dataFile = new In(filePath);
        starNumber = dataFile.readInt();
        return dataFile.readDouble();
    }

    public static Planet[] readPlanets(String filePath){
        In dataFile = new In(filePath);
        starNumber = dataFile.readInt();
        Planet [] mutiplePlanet = new Planet[starNumber];
        double radius = dataFile.readDouble();
        for(int i = 0 ; i  < starNumber ; ++i ){
            double xPos = dataFile.readDouble();
            double yPos = dataFile.readDouble();
            double xVel = dataFile.readDouble();
            double yVel = dataFile.readDouble();
            double mass = dataFile.readDouble();
            String imgFileName = dataFile.readString();
            mutiplePlanet[i] = new Planet(xPos,yPos,xVel,yVel,mass,imgFileName);
        }
        return mutiplePlanet;
    }

    /*
        The first arg is T and the second arg is dt,they should be converted to double
        the third arg is a string which is filename
    */
    public static void main(String[] args){
        if (args.length != 3) {
            System.out.println("Please supply three args as a command line argument.");
            System.out.println("the first and second arg should be a number (double)");
            System.out.println("the third arg should be the file name");
            return;
        }

        /* Start reading in national_salt_production.txt */
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];

        double fieldRadius = readRadius(filename);
                /* Sets up the universe, so it goes from
         * -fieldRadius, -fieldRadius up to fieldRadius, fieldRadius */
        StdDraw.setScale(-fieldRadius, fieldRadius);

        /* Clears the drawing window. */
        StdDraw.clear();

        Planet [] planets = readPlanets(filename);

        StdDraw.enableDoubleBuffering();

        for (double nowT = 0 ; nowT < T ; nowT += dt){
            double [] xForces = new double[starNumber];
            double [] yForces = new double[starNumber];
            for (int i = 0 ; i < starNumber ; ++i){
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }
            for (int i = 0 ; i < starNumber ; ++i){
                planets[i].update(dt ,xForces[i] ,yForces[i]);
            }
            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (Planet planet : planets) {
                planet.draw();
            }
            /* Shows the drawing to the screen, and waits 20 milliseconds. */
            StdDraw.show();
            StdDraw.pause(10);
        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", fieldRadius);
        for (Planet planet : planets) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planet.xxPos, planet.yyPos, planet.xxVel,
                    planet.yyVel, planet.mass, planet.imgFileName);
        }
    }
}
