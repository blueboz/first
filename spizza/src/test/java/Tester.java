import java.util.stream.IntStream;

public class Tester {
    public static void main(String args[]){

        var range = IntStream.range(0, 100);
        range.map(it->it*2).forEach(it-> System.out.println(it));

        var i=1;
        System.out.println(i);

    }
}
