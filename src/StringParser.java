import java.util.regex.Matcher;
import java.util.regex.Pattern;
// Класс для парсинга строки
public class StringParser {

    //Метод для получения числовых значений в начале строки
    public static String getNumericData(String inputString)
    {
        Pattern pattern = Pattern.compile("^([0-9]+)([.][0-9]+)?");
        Matcher matcher = pattern.matcher(inputString);
        matcher.find();
        return matcher.group();
    }
}
