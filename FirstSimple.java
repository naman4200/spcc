import java.util.*;
public class FirstSimple {
    public static void main(String[] args) {
char epsilon = '\u03B5';
        Map<String, String[]> grammar = new HashMap<>();
        grammar.put("S", new String[] {"AB"});
        grammar.put("A", new String[] {"a", String.valueOf(epsilon)});
        grammar.put("B", new String[] {"b"});
        Map<String, Set<String>> first = new HashMap<>();
        first.put("S", new HashSet<>());
        first.put("A", new HashSet<>(Set.of("a", "ε")));
        first.put("B", new HashSet<>(Set.of("b")));
        // S -> AB → first of A is a/ε → add first of B if A can be ε
        first.get("S").add("a");
        first.get("S").add("b");
        first.forEach((k, v) -> System.out.println("FIRST(" + k + ") = " + v));
    }
}
