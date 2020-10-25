Rule 06. Methods
(MET)MET01-J. Never use assertions to validate method arguments Given thenon-compliant 
code below:

public static int getAbsAdd(int x, int y) {
  return Math.abs(x) + Math.abs(y);
}
getAbsAdd(Integer.MIN_VALUE, 1);

Correct the code as shown in the Compliant Solution below:

public static int getAbsAdd(int x, int y) {
  assert x != Integer.MIN_VALUE;
  assert y != Integer.MIN_VALUE;
  int absX = Math.abs(x);
  int absY = Math.abs(y);
  assert (absX <= Integer.MAX_VALUE - absY);
  return absX + absY;
}

Refer to:  Rule 06.  Methods (MET)
