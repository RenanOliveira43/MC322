package AulaLab1;

public class LongestName {

    public static void main(String[] args) {
        String[] names = {"Silvia", "Edgar", "Alexandre"};
        String longestName = findLongestName(names);
        
        System.out.println("Maior nome: " + longestName);
    }

    public static String findLongestName(String[] names) {
        String longest = null;
        for (int i = 0; i < names.length; i++) { // Bug: should be i < names.length
            if (longest == null || names[i].length() > longest.length()) {
                longest = names[i];
            }
        }
        return longest;
    }
}