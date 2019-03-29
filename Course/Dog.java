public class Dog {
    //instance variable
    //d.weightInPounds
    public int weightInPounds; 
    
    //static variable: properties inherent to the class itself, rather than the instance
    //Dog.binomen
    //d.binomen is also ok, but it's a bad style
    public static String binomen = "Canis familiaris"; 

    //constructor
    public Dog(int w) {
        weightInPounds = w;
    }

    //instance method(non-static method)
    //invoked using an instance name: d.makeNoise();
    public void makeNoise() {
        if (weightInPounds < 10) {
            System.out.println("yipyipyip!");
        } else if (weightInPounds < 30) {
            System.out.println("bark. bark.");
        } else {
            System.out.println("woof!");
        }    
    }

    // public Dog maxDog(Dog d2) {
    //     if (this.weightInPounds > d2.weightInPounds) {
    //         return this;
    //     }
    //     return d2;
    // }

    //class method(static method)
    //invoke using the class name: Dog.maxDog(d1,d2);
    //static method can not access instance variables directly, because there is no "me"
    //static method can access instance variables via a specific instance, e.g. d1
    public static Dog maxDog(Dog d1, Dog d2) {
        if (d1.weightInPounds > d2.weightInPounds) {
            return d1;
        }
        return d2;
    }
}