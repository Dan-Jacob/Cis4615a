Rule 00. Input Validation and Data Sanitization (IDS)IDS03-J. Do not log unsanitized user input Given the non-compliantcode below:
if (loginSuccessful) {
  logger.severe("User login succeeded for: " + username);
} else {
  logger.severe("User login failed for: " + username);
}

Correct the code as shown in the Compliant Solution below:
if (loginSuccessful) {
  logger.severe("User login succeeded for: " + sanitizeUser(username));
} else {
  logger.severe("User login failed for: " + sanitizeUser(username));
}
public String sanitizeUser(String username) {
  return Pattern.matches("[A-Za-z0-9_]+", username))
      ? username : "unauthorized user";
}

Refer to:  Rule 00.  Input Validation and Data Sanitization (IDS)
