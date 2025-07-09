import java.util.*;

public class GitHubCommitTracker {
    public static Map<String, Integer> trackCommits(List<String> logs) {
        Map<String, Integer> result = new HashMap<>();

        for (String log : logs) {
            String[] parts = log.split(" ");
            String user = parts[0];
            int lines = Integer.parseInt(parts[2]);

            result.put(user, result.getOrDefault(user, 0) + lines);
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> logs = Arrays.asList(
            "alice committed 10 lines",
            "bob committed 5 lines",
            "alice committed 3 lines",
            "carol committed 7 lines",
            "bob committed 2 lines"
        );

        Map<String, Integer> totals = trackCommits(logs);
        System.out.println(totals);
    }
}
