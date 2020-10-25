Rule 06. Serialization (SER).
SER06-J. Make defensive copies of private mutable components during deserialization
Given the noncompliant code below:

class MutableSer implements Serializable {
  private static final Date epoch = new Date(0);
  private Date date = null; // Mutable component
   
  public MutableSer(Date d){
    date = new Date(d.getTime()); // Constructor performs defensive copying
  }
 
  private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
    ois.defaultReadObject();
    // Perform validation if necessary
  }
}

Correct the code as shown in the Compliant Solution below:

private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
  ObjectInputStream.GetField fields = ois.readFields();
  Date inDate = (Date) fields.get("date", epoch);
  // Defensively copy the mutable component
  date = new Date(inDate.getTime());
  // Perform validation if necessary
}

Refer to: Rule 06. Serializations (SER).
