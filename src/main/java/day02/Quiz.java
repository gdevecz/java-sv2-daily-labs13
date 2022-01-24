package day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Quiz {

    private Map<String, List<Character>> userAnswers = new HashMap<>();

    private String rightAnswers;

    public void loadFile(Path path) {
        try (BufferedReader bf = Files.newBufferedReader(path)) {
            rightAnswers = bf.readLine();
            String line;
            while ((line = bf.readLine()) != null) {
                String[] tmp = line.split(" ");
                if (userAnswers.keySet().contains(tmp[0])) {
                    userAnswers.get(tmp[0]).add((tmp[1]).charAt(0));
                } else {
                    userAnswers.put(tmp[0], new ArrayList<>());
                    userAnswers.get(tmp[0]).add((tmp[1]).charAt(0));
                }

            }
        } catch (IOException ioException) {
            throw new IllegalStateException("File can not read: " + path);
        }
    }

    public boolean isAswerRight(String user, int question) {
        userValidator(user);
        if(question<1||question>rightAnswers.length()) {
            throw new IllegalArgumentException("Invalid question: " + question);
        }
        Map.Entry<String, List<Character>> actualEntry = getUserAnswers(user);
        return rightAnswers.charAt(question - 1) == actualEntry.getValue().get(question - 1);
    }

    public int getUserPoints(String user){
        userValidator(user);
        return getUserPoints(getUserAnswers(user));
    }

    private Map.Entry<String, List<Character>> getUserAnswers(String user) {
        for (Map.Entry<String, List<Character>> actual : userAnswers.entrySet()) {
            if (user.equals(actual.getKey())) {
                return actual;
            }
        }
        throw new IllegalArgumentException("User can not found: " + user);
    }

    private int getUserPoints(Map.Entry<String, List<Character>> user) {
        int sum = 0;
        for (int i = 0; i < rightAnswers.length(); i++) {
            char userAnswer = user.getValue().get(i);
            if (rightAnswers.charAt(i) == userAnswer) {
                sum += i + 1;
            } else if (userAnswer != 'X') {
                sum -= 2;
            }
        }
        return sum;
    }

    public Map<String, List<Character>> getUserAnswers() {
        return userAnswers;
    }

    public String getRightAnswers() {
        return rightAnswers;
    }

    private boolean userValidator(String user) {
        if (user == null) {
            throw new IllegalArgumentException("User is null.");
        }
        if (user.isBlank()) {
            throw new IllegalArgumentException("User is empty.");
        }
        return true;
    }
}
