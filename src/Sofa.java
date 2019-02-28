public class Sofa extends Furniture
{
    Sofa(String name, String square)
    {
        //Вызов конструктора базового класса
        super(name, square);
    }
    @Override
    public void describe() {
        System.out.println("Name: " + super.getName() + ". \t" +"Square: " + super.getSquare());
    }
}
