public class Cat {
    public String name; //各不相同
    public static String noise; //所有类的对象共用一个

    public Cat(String name, String noise) {
        System.out.println("default: noise = " + noise);
        this.name = name;
        this.noise = noise;
    }

    public void play() {
        System.out.println(noise + " I'm " + name + " the cat!");
    }

    public static void anger() {
        noise = noise.toUpperCase();
    }
    public static void calm() {
        noise = noise.toLowerCase();
    }

    public static void main(String[] args) {
        Cat a = new Cat("Cream", "Meow!");
        Cat b = new Cat("Tubbs", "Nyan!");
        a.play(); //Meow! I'm Cream the cat!
        b.play(); //Nyan! I'm Tubbs the cat!
        Cat.anger(); //Nyan -> NYAN
        a.calm(); //NYAN -> nyan
        a.play(); //nyan! I'm Cream the cat!
        b.play(); //nyan! I'm Tubbs the cat!
    }

}