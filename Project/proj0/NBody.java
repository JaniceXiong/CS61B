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
}