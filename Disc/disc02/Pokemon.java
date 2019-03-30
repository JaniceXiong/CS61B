public class Pokemon {
    public String name;
    public int level; //instance variable

    public Pokemon(String name, int level) {
        this.name = name;
        this.level = level;
    }
    public static void main(String[] args) {
        Pokemon p = new Pokemon("Pikachu", 17); //p->(Pikachu,17)
        int level = 100; //局部变量
        change(p, level); //change(p,100);
        System.out.println("Name: " + p.name + ", Level: " + p.level);
        System.out.println("back to main, level = "+level);
        
    }

    public static void change(Pokemon poke, int level) {
        // poke = p -> (Pikachu,17)
        // level=100
        
        poke.level = level; 
        // poke = p -> (Pikachu,100)
        
        // 修改了局部变量level，但函数的传值的，所以不会影响main中的level
        level = 50;
        System.out.println("change inside: level = " + level);
        // 修改了poke的指向，但它的作用域只在change函数中
        // 所以(Gengar,1)会被回收
        poke = new Pokemon("Gengar", 1);

    }
}