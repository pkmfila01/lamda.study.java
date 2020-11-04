package functional;

public class FuntionalInterfaceExample2 {

    public static void main(String[] args) {
        println(1, 2, 3, (i1, i2, i3) -> String.valueOf(i1 + i2 + i3) );
        println("Area is ", 2, 3, (message, length, width) -> String.valueOf(message + (length * width)) );
        println(1L, "Kebin", "test@email.com", (id, name, email) -> String.valueOf("User Info: ID:" + id + ", name:" + name + ", email:" + email ) );
    }

    private static <T1, T2, T3> void println(T1 t1, T2 t2, T3 t3, Funtion3<T1, T2, T3, String> function){
        System.out.println(function.apply(t1, t2, t3));
    }
}


@FunctionalInterface
interface Funtion3<T1, T2, T3, R> {
    R apply(T1 t1, T2 t2, T3 t3);
}
