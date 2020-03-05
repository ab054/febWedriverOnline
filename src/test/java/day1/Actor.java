package day1;

public class Actor {

    String firstName;
    String lastName;

    public Actor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        System.out.println("actor " + this.firstName + " " + this.lastName + " created!!!");
    }

    public Actor(String firstName, String lastName, boolean isGood) {
        this.firstName = firstName;
        this.lastName = lastName;

        System.out.println("actor " + this.firstName + " " + this.lastName + " created!!! is it good?="+ isGood);
    }
}
