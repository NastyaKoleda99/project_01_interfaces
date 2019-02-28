public class Table extends Furniture
{
Table(String name, String square)
{
    //Вызов конструктора базового класса
    super(name, square);
}
    @Override
    public void describe()
    {
        System.out.println("Name: " + super.getName() + ". \t" +"Square: " + super.getSquare());
    }
}
