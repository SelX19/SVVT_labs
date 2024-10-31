import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

public class PointConverter implements ArgumentConverter {
    @Override
    public Object convert(Object source, ParameterContext context) throws ArgumentConversionException {
        String[] coords = ((String) source).split(",");
        int x = Integer.valueOf(coords[0]);
        int y = Integer.valueOf(coords[1]);
        return new Point(x, y);
    }
}
