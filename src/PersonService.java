import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class PersonService {
    public static void serializePerson(Person person) {
        FileOutputStream fos = null;
        XMLEncoder xmlEncoder = null;
        try {
            fos = new FileOutputStream("person.xml");
            xmlEncoder = new XMLEncoder(fos);
            xmlEncoder.writeObject(person);
            xmlEncoder.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Person deserializePerson() {
        Person p = null;
        FileInputStream fis = null;
        XMLDecoder xmlDecoder = null;
        try {
            fis = new FileInputStream("person.xml");
            xmlDecoder = new XMLDecoder(fis);
            p = (Person) xmlDecoder.readObject();
            xmlDecoder.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return p;
    }
}
