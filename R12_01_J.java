Rule 01. Thread-Safety Miscellaneous (TSM).
TSM01-J. Do not let the this reference escape during object construction. Given the noncompliant
code below:

final class Publisher {
  public static volatile Publisher published;
  int num;
 
  Publisher(int number) {
    published = this;
    // Initialization
    this.num = number;
    // ...
  }
}

final class Publisher {
  public static Publisher published;
  int num;
 
  Publisher(int number) {
    // Initialization
    this.num = number;
    // ...
    published = this;
  }
}

Correct the code as shown in the Compliant Solution below:

final class Publisher {
  static volatile Publisher published;
  int num;
 
  Publisher(int number) {
    // Initialization
    this.num = number;
    // ...
    published = this;
  }
}

Refer to: Rule 01. Thread-Safety Miscellaneous (TSM)
