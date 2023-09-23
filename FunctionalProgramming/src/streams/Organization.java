package streams;

public class Organization {

    private String name;
    private Country country;

    public Organization(String name, Country country) {
        this.name = name;
        this.country = country;
    }

    public Organization(String name) {
        this.name = name;
        this.country = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "name='" + name + '\'' +
                ", country=" + country +
                '}';
    }
}

