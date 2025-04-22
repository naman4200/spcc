import java.util.*;
public class FollowSimple {
    public static void main(String[] args) {
        Map<String, String[]> grammar = new HashMap<>();
char epsilon = '\u03B5';
        grammar.put("S", new String[] {"AB"});
        grammar.put("A", new String[] {"a", String.valueOf(epsilon)});
        grammar.put("B", new String[] {"b"});
        Map<String, Set<String>> follow = new HashMap<>();
        follow.put("S", new HashSet<>(Set.of("$")));
        follow.put("A", new HashSet<>());
        follow.put("B", new HashSet<>());

        follow.get("A").add("b"); // Because B comes after A
        follow.get("B").add("$"); // Because B is at end
        follow.forEach((k, v) -> System.out.println("FOLLOW(" + k + ") = " + v));
    }
}
