import java.util.*;
public class SimpleMacro {
    public static void main(String[] args) {
        // Define macros: no arguments
        Map<String, String[]> macros = new HashMap<>();

        // Example MACRO definition (HELLO): no arguments
        macros.put("HELLO", new String[] {
            "LOAD A", 
            "PRINT A"
        });

        // Code using the macro
        String[] code = {
            "START", 
            "HELLO",   // This is the macro call
            "END"
        };

        // Expand macro during execution
        for (String line : code) {
            if (macros.containsKey(line)) {
                // If it's a macro call, expand its instructions
                for (String instruction : macros.get(line)) {
                    System.out.println(instruction);
                }
            } else {
                // Regular line, print as is
                System.out.println(line);
            }
        }
    }
}
