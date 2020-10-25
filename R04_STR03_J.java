Rule 04. Characters and Strings 
(STR)STR03-J. Do not encode noncharacter data as a string Given thenon-compliantcode
below:

BigInteger x = new BigInteger("530500452766");
byte[] byteArray = x.toByteArray();
String s = new String(byteArray);
byteArray = s.getBytes();
x = new BigInteger(byteArray);

Correct the code as shown in the Compliant Solution below:

BigInteger x = new BigInteger("530500452766");
String s = x.toString();  // Valid character data
byte[] byteArray = s.getBytes();
String ns = new String(byteArray); 
x = new BigInteger(ns);

Refer to:  Rule 04.  Characters and Strings (STR)
