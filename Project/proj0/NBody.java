public class NBody{
    public static double readRadius(String filename){
        In in = new In(filename);
        int N = in.readInt();
        double r = in.readDouble();
        return r;
    }

    public static Body[] readBodies(String filename){
    
        In in = new In(filename);
        int N = in.readInt();
        double r = in.readDouble();
        Body[] bodies = new Body[N];
        
        double xP,yP,xV,yV,m;
        String img;
        for(int i=0;i<N;i++){
            xP = in.readDouble();
            yP = in.readDouble();
            xV = in.readDouble();
            yV = in.readDouble();
            m = in.readDouble();
            img = in.readString();
            bodies[i] = new Body(xP,yP,xV,yV,m,img);
        }
        return bodies;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        Body[] bodies = readBodies(filename);
        double radius = readRadius(filename);
        double currentTime = 0.0;
        int N = bodies.length;
        double[] xForces = new double[N];
        double[] yForces = new double[N];

        StdDraw.enableDoubleBuffering();
		StdDraw.setScale(-radius, radius);
		StdDraw.clear();

        for( ; currentTime<T ; currentTime+=dt){
            for(int i=0;i<N;i++){
                xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
                yForces[i] = bodies[i].calcNetForceExertedByY(bodies);
            }
            StdDraw.picture(0, 0, "images/starfield.jpg");
            for(int i=0;i<N;i++){
                bodies[i].update(dt,xForces[i],yForces[i]);
                bodies[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
        }

    
        StdOut.printf("%d\n", bodies.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < bodies.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
                  bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);   
}

    }
}