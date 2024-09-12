public class CustomTokenizer {

    // Function to split the input string by the delimiter
    public static String[] splitByDelimiter(String input, char delimiter) {
        return input.split(String.valueOf(delimiter));  // Split based on #
    }

    // Classify token
    public static String classifyToken(String token) {
        if (token.matches(" ")) {
            return "Space";
        } else if (token.matches("\\t")) {
            return "Tab";
        } else if (token.matches("\\R")) {
            return "End of Line";
        } else {
            token = token.trim();  // Trim spaces around the token for proper classification
    
            if (token.matches("[a-zA-Z\\p{Punct}]+")) {
                return "Word";
            } else if (token.matches("\\d+(\\.\\d+)?")) {
                return "Number";
            } else if (token.matches("[a-zA-Z0-9]+")) {
                return "Alphanumeric";
            } else if (token.matches("\\p{Punct}+")) {
                return "Punctuation";
            } else if (token.matches("[a-zA-Z0-9\\s\\p{Punct}]+") && token.contains(" ")) {
                return "Sentence";
            } else {
                return "Unknown";
            }
        }
    }

   // Custom tokenizer and classifier (Phase 1)
   public static void tokenizeAndClassify(String input) {
    String[] tokens = splitByDelimiter(input, '#');
    for (String token : tokens) {
        String type = classifyToken(token);
        System.out.println("Token: \"" + token + "\" - Type: " + type);
    }
}

    // Granular breakdown (Phase 2)
    public static void granularBreakdown(String input) {
        String[] tokens = splitByDelimiter(input, '#');
        for (String token : tokens) {
            System.out.print("Token: \"" + token + "\" -> ");
            for (char c : token.toCharArray()) {
                System.out.print("'" + c + "', ");
            }
            System.out.println();
        }
    }
}
