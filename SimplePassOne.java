import java.util.*;

public class SimplePassOne {
    public static void main(String[] args) {
        String[] code = {
            "START 100", "LOOP MOVER AREG, A", "ADD AREG, B", "A DS 1", "B DS 1", "END"
        };
        Map<String, Integer> symbolTable = new HashMap<>();
        int lc = 0;

        for (String line : code) {
            String[] parts = line.split(" ");
            if (parts[0].equals("START")) {
                lc = Integer.parseInt(parts[1]);
            } else if (parts[0].equals("END")) {
                break;
            } else {
                if (!parts[0].equals("MOVER") && !parts[0].equals("ADD")) {
                    symbolTable.put(parts[0], lc);
                }
                lc++;
            }
        }

        System.out.println("Symbol Table:");
        symbolTable.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}
