public class Main {

    public static void main(String[] args) {

        Build build = new Build("House");
        build.addRoom(new Room("Room 1","125 m2","3 windows"));
        build.addRoom(new Room("Room 2","15 m2","2 windows"));
        build.getRoom("Room 1").add(new Bulb(1000));
        build.getRoom("Room 1").add(new Bulb(901));
        build.getRoom("Room 1").add(new Table("desk","5 m^2"));
        build.getRoom("Room 1").add(new Sofa("soft sofa","25.02 m^2"));
        build.getRoom("Room 2").add(new Table("kitchen table","3.2 m2"));
        build.getRoom("Room 2").add(new Sofa("corner sofa","5.5m2"));
        build.describe();
    }
}
