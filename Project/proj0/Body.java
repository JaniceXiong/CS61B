public class Body{
    public double xxPos; //its current x pos
    public double yyPos; //its current y pos
    public double xxVel; //its current velocity in the x direction
    public double yyVel; //its current velocity in the y direction
    public double mass; //its mass
    public String imgFileName;
    public static final double G =6.67e-11; //constant

    public Body(double xP, double yP, double xV,double yV, double m, String img){
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    public Body(Body b){
        //copy
        this.xxPos = b.xxPos;
        this.yyPos = b.yyPos;
        this.xxVel = b.xxVel;
        this.yyVel = b.yyVel;
        this.mass = b.mass;
        this.imgFileName = b.imgFileName;
    }

    public double calcDistance(Body b){
        double dx = this.xxPos - b.xxPos;
        double dy = this.yyPos - b.yyPos;
        
        return Math.sqrt(dx*dx+dy*dy);
    }

    public double calcForceExertedBy(Body b){
        double r = this.calcDistance(b);
        return (G * this.mass * b.mass) / (r * r);
    }

    public double calcForceExertedByX(Body b){
        double F = this.calcForceExertedBy(b);
        double dx = b.xxPos - this.xxPos;
        double r = this.calcDistance(b);
        return F*dx/r;
    }

    public double calcForceExertedByY(Body b){
        double F = this.calcForceExertedBy(b);
        double dy = b.yyPos - this.yyPos;
        double r = this.calcDistance(b);
        return F*dy/r;
    }

    public double calcNetForceExertedByX(Body[] bodies){
        double netForceX = 0.0;
        for(Body b:bodies){
            if(this.equals(b)) continue;
            netForceX += this.calcForceExertedByX(b);
        }
        return netForceX;

    }

    public double calcNetForceExertedByY(Body[] bodies){
        double netForceY = 0.0;
        for(Body b:bodies){
            if(this.equals(b)) continue;
            netForceY += this.calcForceExertedByY(b);
        }
        return netForceY;
    }

    public void update(double dt,double fX, double fY){
        double ax = fX / this.mass;
        double ay = fY / this.mass;
        this.xxVel += dt * ax;
        this.yyVel += dt * ay;
        this.xxPos += dt * this.xxVel;
        this.yyPos += dt * this.yyVel;
    }
}