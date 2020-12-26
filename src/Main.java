public class Main {
    public static void main(String[] args) {
        System.out.println("Пришел Седымов А.А. из Р3112");

        World world = new World();
        Room room = new Room("Комната", new Thing.Door(true,false,1));

        Human kid = new Human("Малыш",Gender.MALE,Emotion.UNKNOWN,Speed.CRAWL,world,13,0,0,"");
        kid.showEmotion();

        Karlson karlson = new Karlson("Карлсон", Gender.MALE,Emotion.CALM,Speed.CRAWL,world,40,0,0,new Thing.Key(room.getDoor().getId()),"свалившись на Малыша"){
            @Override
            public void toBet(final Person ... persons){
                Conflict conflict = new Conflict();
                for (Person person : persons) {
                    conflict.winnerIs(this,person);
                }
            }
            //Конфликт - спор - пари
            class Conflict{
                public void winnerIs(Person firstPerson,Person secondPerson){
                    if (Math.random() * 100 >= 30){
                        System.out.println(firstPerson.getName() + " выиграл спор у " + secondPerson.getName());
                    } else{
                        System.out.println(firstPerson.getName() + " проиграл спор " + secondPerson.getName());
                    }
                }
            }
        };
        kid.changeEmotion(Emotion.FUN);
        karlson.showEmotion();

        Betan betan = new Betan("Бетан",Gender.BETAN,Emotion.EMBARRASSMENT,Speed.RUN,world,0,0,"стреляя глазами"){
            @Override
            public void showEmotion(){
                System.out.println("На самом деле, Бетан не знает ничего кроме ярости, только ярость, только хардкор!");
            }
        };

        kid.move();
        karlson.move();
        betan.move();

        kid.changeEmotion(Emotion.PANIC);
        karlson.changeEmotion(Emotion.PANIC);
        kid.setSpeed(Speed.BOOST);
        karlson.setSpeed(Speed.BOOST);

        betan.toCatch(kid,karlson);

        kid.changePlace(room);
        karlson.changePlace(room);
        room.changeState(karlson);
        room.changeLock(karlson.getKey());
        karlson.changeEmotion(Emotion.FUN);

        betan.changePlace(room);
        betan.banging(room.getDoor());
        betan.showEmotion();
        //
        karlson.toBet(betan,kid);
    }
}
