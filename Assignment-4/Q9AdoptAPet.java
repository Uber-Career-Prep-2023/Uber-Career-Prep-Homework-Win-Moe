import java.util.HashMap;
import java.util.Map;

public class Q9AdoptAPet {
    private Map<String[], Integer> typeToDays;
    // technique: hashmap and save state
    // time complexity: O(n*m) where n is the size of the map, and m is how  many times the function is called
    // space complexity: O(n) where it is the size of how many pets there are

    public Q9AdoptAPet(Map<String[], Integer> userInput) {
        typeToDays = userInput;
    }

    public void addToShelter(String[] newPet) {
        typeToDays.put(newPet, 1);
    }

    public String adoptAPet(String[] personPet) {
        // invalid input
        if (personPet == null || typeToDays.size() == 0) return null;
        if (personPet.length < 2) return null;

        // this is an input, go elsewhere
        if (personPet.length == 2) {
            addToShelter(personPet);
            return null;
        }

        // assign var
        String person = personPet[0];
        String desiredPet = personPet[2];
        boolean pickOther = true;

        // they are assigned the animal of that species that has been in the shelter longest.
        int maxDays = 0;
        String[] toAdopt = null;
        for (String[] pair : typeToDays.keySet()) {
            String pet = pair[1];
            if (desiredPet.equals(pet) && typeToDays.get(pair) > maxDays) {
                maxDays = typeToDays.get(pair);
                toAdopt = pair;
                pickOther = false;
            }
        }
        //If there are no animals available of the desired species, they must take the other species.
        if (pickOther) {
            maxDays = 0;
            toAdopt = null;
            for (String[] pair: typeToDays.keySet()) {
                String pet = pair[1];
                if (!desiredPet.equals(pet) && typeToDays.get(pair) > maxDays) {
                    maxDays = typeToDays.get(pair);
                    toAdopt = pair;
                }
            }
        }
        // if didn't find anything return null
        // else put out from hashmap;
        if (toAdopt == null) {
            return null;
        } else {
            typeToDays.remove(toAdopt);
        }
        return toAdopt[0] + " " + toAdopt[1];
    }

    public static void main(String[] args) {
        Map<String[], Integer> input = new HashMap<>();
        String[] i1 = new String[]{"Sadie", "dog"};
        String[] i2 = new String[]{"Woof", "cat"};
        String[] i3 = new String[]{"Chirpy", "dog"};
        String[] i4 = new String[]{"Lola", "dog"};
        input.put(i1, 4);
        input.put(i2, 7);
        input.put(i3, 2);
        input.put(i4, 1);

        Q9AdoptAPet shelter = new Q9AdoptAPet(input);
        String[] p1 = new String[]{"Bob", "person", "dog"};
        String[] p2 = new String[]{"Floofy", "cat"};
        String[] p3 = new String[]{"Sally", "person", "cat"};
        String[] p4 = new String[]{"Ji", "person", "cat"};
        String[] p5 = new String[]{"Ali", "person", "cat"};

        System.out.println(shelter.adoptAPet(p1));
        System.out.println(shelter.adoptAPet(p2));
        System.out.println(shelter.adoptAPet(p3));
        System.out.println(shelter.adoptAPet(p4));
        System.out.println(shelter.adoptAPet(p5));
    }
    /*
    Question 9: AdoptAPet
An animal shelter that houses cats and dogs wants to ensure no pet has to wait too long for a forever home.
Therefore, anyone who comes to adopt a pet can pick the species (cat or dog) but not the specific animal;
they are assigned the animal of that species that has been in the shelter longest.
If there are no animals available of the desired species, they must take the other species.
You are given a list of pets in the shelter with their names, species,
and time in the shelter at the start of a week.

You receive a sequence of incoming people (to adopt pets) and animals
(new additions to the shelter) one at a time.
Print the names and species of the pets as they are adopted out.

Example (input and output forms one sequence of sample input):
Initial Input:
Sadie, dog, 4 days
Woof, cat, 7 days
Chirpy, dog, 2 days
Lola, dog, 1 day

Input: Bob, person, dog
Output: Sadie, dog

Input: Floofy, cat
Output:

Input: Sally, person, cat
Output: Woof, cat

Input: Ji, person, cat
Output: Floofy, cat

Input: Ali, person, cat
Output: Chirpy, dog

     */
}
