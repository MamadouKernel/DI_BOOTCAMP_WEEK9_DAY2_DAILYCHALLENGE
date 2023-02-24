package exercice;

import java.util.HashMap;
import java.util.Map;

public class ItineraryFinder {

public static void printItinerary(String[][] tickets) {
    // Step 1: Create a HashMap of the given tickets
    Map<String, String> dataset = new HashMap<>();
    for (String[] ticket : tickets) {
        dataset.put(ticket[0], ticket[1]);
    }

    // Step 2: Find the starting point of the itinerary
    Map<String, String> reverseMap = new HashMap<>();
    for (String key : dataset.keySet()) {
        reverseMap.put(dataset.get(key), key);
    }
    String startPoint = null;
    for (String key : dataset.keySet()) {
        if (!reverseMap.containsKey(key)) {
            startPoint = key;
            break;
        }
    }

    // Step 3: Print the itinerary in order
    String nextPoint = dataset.get(startPoint);
    while (nextPoint != null) {
        System.out.print(startPoint + " -> " + nextPoint + ", ");
        startPoint = nextPoint;
        nextPoint = dataset.get(startPoint);
    }
    System.out.println();
}

public static void main(String[] args) {
    String[][] tickets = {
            {"Chennai", "Banglore"},
            {"Bombay", "Delhi"},
            {"Goa", "Chennai"},
            {"Delhi", "Goa"}
    };
    printItinerary(tickets); // Output: Bombay -> Delhi, Delhi -> Goa, Goa -> Chennai, Chennai -> Banglore,
}

}
