public class Room extends Place{
    private Thing.Door door;

    {
        System.out.println("Появилась комната!");
    }

    public Room() throws ExistException, CorrectNameException{
        super("Комната",true);
        door = new Thing.Door(true,false,0);
    }

    public Room(String name,Thing.Door door) {
        super(name, true);

        if (door == null){
            throw new ExistException("Дверь не может быть null");
        }

        this.door = door;
    }

    public void changeState(Person person){
       door.changeOpen(person);
       this.setState(door.isOpen());
    }

    public void changeLock(Thing.Key key){
        door.changeLock(key);
    }

    public Thing.Door getDoor() {
        return door;
    }

    public void setDoor(Thing.Door door) {
        this.door = door;
    }

    @Override
    public void describe() {
        System.out.println("Красивая комната Малыша, все как по книжке, канонично");
    }
}
