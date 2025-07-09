import java.util.*;

public class GitHubPracticeQ2 {

    public static Map<String, List<String>> getMessagesByUser(List<String> logs) {
        Map<String, List<String>> userMessages = new HashMap<>();

        for (String log : logs) {
            String[] parts = log.split(" - ");
            if (parts.length != 3) continue; // Skip if not formatted correctly

            String commitId = parts[0];
            String user = parts[1];
            String message = parts[2];

            String fullMessage = commitId + " - " + message;

            userMessages
                    .computeIfAbsent(user, k -> new ArrayList<>())
                    .add(fullMessage);
        }

        return userMessages;
    }

    public static void main(String[] args) {
        List<String> logs = Arrays.asList(
                "123abc - alice - Added login page",
                "456def - bob - Fixed bugs",
                "789ghi - alice - Updated UI"
        );

        Map<String, List<String>> result = getMessagesByUser(logs);

        for (Map.Entry<String, List<String>> entry : result.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
