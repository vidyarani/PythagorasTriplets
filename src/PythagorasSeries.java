import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PythagorasSeries {
    public static void main(String[] args) {
        getPythagorasSeries1(20);
    }

    private static void getPythagorasSeries1(int limit) {
        Stream<Pair> pairStream = IntStream.rangeClosed(1, limit).boxed().flatMap(a -> generatePairList(a, limit));
        Stream<Triplet> tripletStream = pairStream.flatMap(b -> generateTriplet(b, limit));
        tripletStream.filter(Triplet::isPythagorean).forEach(triplet -> {
            System.out.println(triplet);
        });
    }

    private static Stream<Triplet> generateTriplet(Pair pair, int limit) {
        Stream<Triplet> tripletStream = IntStream.rangeClosed(pair.getNum2() + 1, limit).mapToObj(x ->
                new Triplet(pair.getNum1(), pair.getNum2(), x));
        return tripletStream;
    }

    static Stream<Pair> generatePairList(int number, int limit) {
        Stream<Pair> pairStream = IntStream.rangeClosed(number + 1, limit).mapToObj(x -> new Pair(number, x));
        return pairStream;
    }

    //Implement without lambdas
    private static void getPythagorasSeries(int limit) {
        for (int a = 1; a <= limit; a++) {
            for (int b = a + 1; b <= limit; b++) {
                for (int c = b + 1; c <= limit; c++) {
                    Triplet triplet = new Triplet(a, b, c);
                    if (triplet.isPythagorean())
                        System.out.println(a + " " + b + " " + c);
                }
            }
        }
    }

}


