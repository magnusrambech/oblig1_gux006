public class Main {
    public static void main(String[] args) {
        ArrayDeque test = new ArrayDeque<Integer>(10);

        System.out.println("Legger til 1 first");  test.addFirst(1);
        System.out.println("Legger til 2 first"); test.addFirst(2);
        System.out.println("Legger til 3 first"); test.addFirst(3);
        System.out.println("Legger til 4 first"); test.addFirst(4);
        System.out.println("Legger til 5 first"); test.addFirst(5);
        System.out.println("Legger til 6 last"); test.addLast(6);
        System.out.println("Legger til 6 last"); test.addLast(7);
        System.out.println("Legger til 6 last"); test.addLast(8);
        System.out.println("Legger til 9 first"); test.addFirst(9);
        System.out.println("Legger til 10 furst"); test.addFirst(10);
        System.out.println("Fjerner første som er : " +test.pullFirst());
        System.out.println("Fjerner siste som er : " +test.pullLast());


        test.printDeque();

        System.out.println("-------------------------");
        System.out.println("Sjekk om alle metodene fungerer:");
        System.out.println("Det er totalt " + test.size() + " elementer i samlingen"); //Size metoden
        System.out.println("Det første elementet i samlingen er " + test.peekFirst()); //peekFirst metoden
        System.out.println("Det bakerste elementet i samlingen er " + test.peekLast());//peekLast metoden
        System.out.println("Finnes tallet 5 i samlingen: " + test.contains(5)); //contains metoden
        System.out.println("Fjerner det bakerste elementet som er: " + test.pullLast()); //pullLast metoden
        System.out.println("Det er nå totalt " + test.size() + " elementer i samlingen"); //Size metoden

       test.toArray();


    }
}
