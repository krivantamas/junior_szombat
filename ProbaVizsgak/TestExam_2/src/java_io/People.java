package java_io;

import java.util.Objects;

public class People {

    private final int id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final Gender gender;
    private final String ipAddress;

    public People(int id, String firstName, String lastName, String email, Gender gender, String ipAddress) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.ipAddress = ipAddress;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Gender getGender() {
        return gender;
    }

    public String getIpAddress() {
        return ipAddress;
    }


    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", ipAddress='" + ipAddress + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        People people = (People) o;
        return id == people.id && Objects.equals(firstName, people.firstName) && Objects.equals(lastName, people.lastName) && Objects.equals(email, people.email) && gender == people.gender && Objects.equals(ipAddress, people.ipAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, gender, ipAddress);
    }
}
