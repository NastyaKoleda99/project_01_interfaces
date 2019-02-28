// Интерфейс для работы с мебелью и лампочками (вещами)
public interface IStuff  {
    void add (Bulb bulb);
    void add (Furniture furn);
    int getTotalIllumination();
    float getBusySquare();
}
