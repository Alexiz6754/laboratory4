public class World extends Place{

    {
        System.out.println("Появился мир!");
    }

    public World(){
        this.setName("Мир");
    }

    public World(String name) {
        super(name,true);
    }

    @Override
    public void describe() {
        System.out.println("Обычный мир, видимо, существует только в этой лабе");
    }
}
