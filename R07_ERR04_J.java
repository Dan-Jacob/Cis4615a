Rule 07. Exceptional Behavior (ERR).
ERR04-J. Do not complete abruptly from a finally block. Given the noncompliant code:

class TryFinally {
  private static boolean doLogic() {
    try {
      throw new IllegalStateException();
    } finally {
      System.out.println("logic done");
      return true;
    }
  }
}

Correct the code as shown in the Compliant Solution below:

class TryFinally {
  private static boolean doLogic() {
    try {
      throw new IllegalStateException();
    } finally {
      System.out.println("logic done");
    }
    // Any return statements must go here;
    // applicable only when exception is thrown conditionally
  }
}

Refer to: Rule 07. Exceptional Behavior (ERR).
