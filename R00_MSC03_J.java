Rule 00. Input Validation and Data Sanitization (IDS).
IDS03-J. Do not log unsanitized user input Given thenon-compliant code below:

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


Refer to Rule 49. Miscellaneous (MSC).
