public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Main Week 3");

        BagInterface<String> statesBag = new ArrayBag<String>();

        System.out.println(statesBag.isEmpty());  // True
        statesBag.add("alaska");
        statesBag.add("california");
        statesBag.add("delaware");
        statesBag.add("california");
        statesBag.add("georgia");
        statesBag.add("delaware");
        statesBag.add("delaware");
        statesBag.add("iowa");
        System.out.println(statesBag.isEmpty()); // False
        System.out.println(statesBag.getCurrentSize()); // 8
        System.out.println(statesBag.remove("california")); // True
        System.out.println(statesBag.getCurrentSize()); // 7
        System.out.println(statesBag.remove("california")); // True
        System.out.println(statesBag.remove("california")); //False
        System.out.println(statesBag.remove("hawaii")); // False
        System.out.println(statesBag.getCurrentSize()); // 6
        System.out.println(statesBag.getFrequencyOf("delaware")); // 3
        System.out.println(statesBag.contains("hawaii")); // False
        System.out.println(statesBag.getFrequencyOf("hawaii")); // 0
        statesBag.clear();
        System.out.println(statesBag.getCurrentSize()); // 0
    }
}
