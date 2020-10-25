Rule 09. Locking (LCK).
LCK09-J. Do not perform operations that can block while holding a lock. Given the noncompliant code:

public synchronized void doSomething(long time)
                         throws InterruptedException {
  // ...
  Thread.sleep(time);
}

Correct the code as shown in the Compliant Solution below:
public synchronized void doSomething(long timeout)
                                     throws InterruptedException {
// ...
  while (<condition does not hold>) {
    wait(timeout); // Immediately releases the current monitor
  }
}

Refer to: Rule 09. Locking (LCK).
