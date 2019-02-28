import java.util.ArrayList;

public class Build implements IBuild, IInfo
{
    private String name;
    ArrayList<Room> rooms =  new ArrayList<Room>();

    Build(String name)
    {
        this.name = name;
    }
    @Override
    public String getName()
    {
        return name;
    }
    @Override
    public void describe()
    {
        System.out.println("Build: " + this.getName());
        for(Room room: rooms)
        {
            room.describe();
        }
    }

    @Override
    public void addRoom(Room room) {
        rooms.add(room);
    }

    @Override
    public Room getRoom(String name) {
        int index = 0;
        while (!rooms.get(index).getName().equals(name))
        {
            index++;
        }
        return rooms.get(index);
    }
}
