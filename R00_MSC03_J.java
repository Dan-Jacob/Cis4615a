MSC03-J. Never hard code sensitive information. given the noncompliant code below:
class IPaddress {
  String ipAddress = new String("172.16.254.1");
  public static void main(String[] args) {
    //...
  }
}

Correct the code as shown in the Compliant Solution below:

class IPaddress {
  public static void main(String[] args) throws IOException {
    char[] ipAddress = new char[100];
    int offset = 0;
    int charsRead = 0;
    BufferedReader br = null;
    try {
      br = new BufferedReader(new InputStreamReader(
             new FileInputStream("serveripaddress.txt")));
      while ((charsRead = br.read(ipAddress, offset, ipAddress.length - offset))
          != -1) {
        offset += charsRead;
        if (offset >= ipAddress.length) {
          break;
        }
      }
       
      // ... Work with IP address
 
    } finally {
      Arrays.fill(ipAddress,  (byte) 0);
      br.close();
    }
  }
}

Refer to Rule 49. Miscellaneous (MSC).
