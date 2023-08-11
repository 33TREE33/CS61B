public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public  String imgFileName;
    public static final double G = 6.67e-11;
    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img){
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    public Planet(Planet p){
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    /* Return the distance of two planet */
    public double calcDistance(Planet p){
        return  Math.sqrt( (this.xxPos - p.xxPos)* (this.xxPos - p.xxPos)+ (this.yyPos - p.yyPos) * (this.yyPos - p.yyPos) );
    }

    public double calcForceExertedBy(Planet p){
        return G * this.mass * p.mass / (calcDistance(p) * calcDistance(p));
    }

    public double calcForceExertedByX(Planet p){
        return calcForceExertedBy(p) * (p.xxPos - this.xxPos) / calcDistance(p);
    }

    public double calcForceExertedByY(Planet p){
        return calcForceExertedBy(p) * (p.yyPos - this.yyPos) / calcDistance(p);
    }

    public double calcNetForceExertedByX(Planet[] mutiplePlanet){
        double xxForce = 0;
        for (int i = 0 ; i < mutiplePlanet.length ; ++i){
            if(!this.equals(mutiplePlanet[i])){
                xxForce += calcForceExertedByX( mutiplePlanet[i] );
            }
        }
        return xxForce;
    }

    public double calcNetForceExertedByY(Planet[] mutiplePlanet){
        double yyForce = 0;
        for (int i = 0 ; i < mutiplePlanet.length ; ++i){
            if(!this.equals(mutiplePlanet[i])){
                yyForce += calcForceExertedByY( mutiplePlanet[i] );
            }
        }
        return yyForce;
    }

    public void update(double dt,double fX,double fY){
        double xxAcceleration = fX / this.mass ;
        double yyAcceleration = fY / this.mass ;
        this.xxVel += xxAcceleration * dt;
        this.yyVel += yyAcceleration * dt;
        this.xxPos += this.xxVel * dt;
        this.yyPos += this.yyVel * dt;
    }

    public void draw(){
        StdDraw.picture(this.xxPos, this.yyPos, "images/"+this.imgFileName);
    }
}
