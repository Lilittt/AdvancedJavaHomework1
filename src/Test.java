public class Test {
    public static void main(String[] args) {
        Person person = new Person("Ann", 30);
        PersonService.serializePerson(person);
        System.out.println(PersonService.deserializePerson().toString());
    }
}