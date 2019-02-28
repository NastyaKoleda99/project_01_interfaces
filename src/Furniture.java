//Базовый класс для мебели
public abstract class Furniture implements IInfo {
    private float square;
    private String name;

    Furniture(String name, String square)
    {
        this.name = name;
        // Получение числового значения площади из строки вида "4м2"
        this.square = Float.parseFloat(StringParser.getNumericData(square));

    }

    public float getSquare ()
    {
        return square;
    }
    @Override
    public String getName()
    {
        return  name;
    }
    public abstract void describe();
}
