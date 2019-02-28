import javax.sound.midi.SysexMessage;
import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.util.ArrayList;

public class Room implements IStuff,IInfo
{
    final int ILLUMINATION = 700;
    private String name;
    private  int numberOfWindows;
    private float square;
    private ArrayList<Bulb> bulbs = new ArrayList<Bulb>();
    private ArrayList<Furniture> furnitures = new ArrayList<Furniture>();

    Room(String name, String square, String numberOfWindows)
    {
        this.name = name;
        this.square = Float.parseFloat(StringParser.getNumericData(square));
        this.numberOfWindows = Integer.parseInt(StringParser.getNumericData(numberOfWindows));
    }
    public  float getSquare()
    { return square;}
    public  float getNumberOfWindows()
    { return numberOfWindows;}
    @Override
    public  String getName()
    {
        return name;
    }
    @Override
    public void describe()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Room: " + this.getName()+ "\n" + "Illuminance = " + this.getTotalIllumination() + "( " + this.getNumberOfWindows() + " windows by " + ILLUMINATION + " lk ");
        if(bulbs.size()!= 0 )
        {
            builder.append(", bulbs: ");
            for(int i=0; i < bulbs.size();i++)
            {
                if(i < bulbs.size()-1)
                builder.append(bulbs.get(i).getIllumination()+ " lk, ");
                else
                   builder.append(bulbs.get(i).getIllumination()+ " lk. ) \n");
            }
        }
        else
        {
            builder.append("). \n");
        }
        builder.append("Square = " + this.getSquare() + " m^2 ( Free " + (this.getSquare() - this.getBusySquare()) * 100 / this.getSquare() + " % )");
        System.out.println(builder.toString());
        if (furnitures.size() != 0) {
            System.out.println("Furniture: ");
            for (Furniture furniture : furnitures) {
                furniture.describe();
            }
        }
        else { System.out.println("No furniture. ");}
    }

    @Override
    public void add(Bulb bulb) {
        try {
            int newIlluminance =  getTotalIllumination() + bulb.getIllumination();
            if ( newIlluminance > 4000 )
                throw  new IlluminanceTooMuschException("Illuminance more than 4000 (" + newIlluminance + ")");
            bulbs.add(bulb);
        }

        //Обработка исключения превышения освещенности
        catch (IlluminanceTooMuschException ex)
        {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void add(Furniture furn)
    {
        float percentage = (getBusySquare() + furn.getSquare()) * 100 / square;
        try
        {
            if(percentage >70)
                throw  new SpaceUsageTooMuchException("Not enough space");
            furnitures.add(furn);
        }
        catch (SpaceUsageTooMuchException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public float getBusySquare() {
        float busySquare = 0f;
        for (Furniture furniture : furnitures)
        {
         busySquare += furniture.getSquare();
        }
        return busySquare;
    }

    @Override
    public int getTotalIllumination()
    {
        int illumination = 0;
        for(Bulb bulb: bulbs)
        {
            illumination += bulb.getIllumination();
        }
        illumination += this.getNumberOfWindows() * ILLUMINATION;
        return illumination;
    }
}
