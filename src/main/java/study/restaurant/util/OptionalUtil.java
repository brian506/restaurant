package study.restaurant.util;

import java.util.List;
import java.util.Optional;

public class OptionalUtil {
    public static <T> T getOrElseThrow(Optional<T> optional,String message) {
        return optional.orElseThrow(() -> new RuntimeException(message));
    }

}
