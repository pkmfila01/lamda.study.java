package delegate;

import java.awt.Color;
import java.util.function.Consumer;

public class CameraTest {

    public static void main(String[] args) {
        final Camera camera = new Camera();
        final Consumer<String> printCaputred = (filterInfo) -> System.out.println(
                String.format("with %s: %s", filterInfo, camera.capture(new Color(200, 100, 200)))
        );
        printCaputred.accept("no filter");

        camera.setFilters(Color::brighter);
        printCaputred.accept("brighter filter");

        camera.setFilters(Color::darker);
        printCaputred.accept("darker fileter");

        camera.setFilters(Color::brighter, Color::darker);
        printCaputred.accept("brigher and darker filter");
    }
}
