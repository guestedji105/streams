import java.io.*;

public class SerializationExample {

    public static void main(String[] args) {
        String filePath = "person.ser";
        //Person personToSerialize = new Person("John Doe", 25);
        //serializeObject(filePath, personToSerialize);
        Person deserializedPerson = deserializeObject(filePath);
        if (deserializedPerson != null) {
            System.out.println("Deserialized Person: " + deserializedPerson);
        }
    }

    private static void serializeObject(String filePath, Person person) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(person);
            System.out.println("Object serialized successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Person deserializeObject(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            Object obj = ois.readObject();
            if (obj instanceof Person) {
                return (Person) obj;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
