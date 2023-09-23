package streams;


import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String... args) {

        List<Employee> employees = Arrays.asList(
                new Employee(1, "Jeff Bezos", 100000, new Organization("Amazon", new Country("USA", "US"))),
                new Employee(2, "John Smith", 20000, new Organization("Amazon", new Country("USA", "US"))),
                new Employee(3, "Bill Gates", 200000, new Organization("Microsoft", new Country("USA", "US"))),
                new Employee(4, "Paul Allen", 200000, new Organization("Microsoft", new Country("USA", "US"))),
                new Employee(5, "Mark Zuckerberg", 300000, new Organization("Facebook", new Country("Ireland", "IR"))),
                new Employee(6, "Bill Bow", 10000, new Organization("Facebook", new Country("Ireland", "IR"))),
                new Employee(7, "Elon Musk", 300000, new Organization("Twitter", new Country("USA", "US"))),
                new Employee(8, "Parag Agrawal", 300000, new Organization("Twitter", new Country("USA", "US"))),
                new Employee(9, "Tim Cook", 250000, new Organization("Apple", new Country("United Kingdom", "UK"))),
                new Employee(10, "Jony Ive", 50000, new Organization("Apple", new Country("United Kingdom", "UK"))),
                new Employee(11, "Steve Wozniak", 150000, new Organization("Apple", new Country("United Kingdom", "UK"))));


        //1. feladat
        List<Employee> employees_1 = employees.stream().filter(employee -> employee.getId() % 3 == 1).toList();

        //2. feladat

        Map<String, Double> employees_2 = employees.stream()
                .collect(Collectors.groupingBy(employee -> employee.getOrganization().getName()))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(stringListEntry -> stringListEntry.getKey(), stringListEntry -> {
                    List<Employee> employeeList = stringListEntry.getValue();

                    double average = 0;
                    for (Employee employee : employeeList) {
                        average += employee.getSalary();
                    }

                    return average / employeeList.size();
                }));

        employees_2 = employees.stream()
                .collect(
                        Collectors.groupingBy(
                                employee -> employee.getOrganization().getName(),
                                Collectors.averagingDouble(Employee::getSalary)));

        //3. feladat

        List<Employee> employees1 = employees.stream().sorted((o1, o2) -> {
            int compare = Integer.compare(o1.getSalary(), o2.getSalary());
            if (compare == 0) {
                return o1.getName().compareTo(o2.getName());
            }
            return compare;
        }).toList();

        //4. feladat

        List<Organization> usOrganizations = employees.stream()
                .map(Employee::getOrganization)
                .filter(organization -> organization.getCountry().getIsoCode().equals("US"))
                .distinct()
                .toList();

        //5. feladat

        //Map<Organization,List<Employee>> ->
        //Entry<Organization,List<Employee>>
        Map<Organization, Long> collect = employees.stream()
                .collect(Collectors.groupingBy(Employee::getOrganization))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        organizationListEntry -> organizationListEntry.getKey(),
                        organizationListEntry -> {
                            List<Employee> organizationListEntryValue = organizationListEntry.getValue();

                            return (long) organizationListEntryValue.size();
                        }
                ));

        Map<Organization, Long> collect_2 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getOrganization))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        organizationListEntry -> organizationListEntry.getKey(),
                        organizationListEntry -> organizationListEntry.getValue().stream().count()
                ));

        Map<Organization, Long> collect_3 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getOrganization))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        organizationListEntry -> (long) organizationListEntry.getValue().size()
                ));

        Map<Organization, Long> collect_4 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getOrganization, Collectors.counting()));


        //6. feladat

        Map<Organization, List<Employee>> organizationListMap = employees.stream().collect(Collectors.groupingBy(Employee::getOrganization));

        //7. feladat

        List<Employee> moreThanAverage = employees.stream()
                .filter(employee -> employee.getSalary() > employees
                        .stream()
                        .mapToDouble(Employee::getSalary)
                        .average()
                        .getAsDouble())
                .toList();

        //8. feladat
        employees.stream()
                .peek(employee -> System.out.println(employee.getName()))
                //.peek(employee -> employee.setName(employee.getName().split(" ")[0]))
                .forEach(employee -> System.out.println(employee.getName()));


        // 9. feladat
        Optional<Employee> max = employees.stream().max(Comparator.comparingInt(emp -> emp.getName().length()));


        // 10. feladat

        boolean match = employees
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getOrganization,
                                Collectors.counting()))
                .entrySet()
                .stream()
                .peek(System.out::println)
                .anyMatch(organizationLongEntry -> organizationLongEntry.getValue() > 3);
        System.out.println(match);
    }


    public static void createStreamFromArray() {

        Employee[] employees = new Employee[]{
                new Employee(1, "Jeff Bezos", 10000),
                new Employee(2, "Bill Gates", 20000),
                new Employee(3, "Mark Zuckerberg", 30000),
        };

        Arrays.stream(employees);
        Stream.of(employees);
        Stream.of(new Employee(1, "Jeff Bezos", 10000),
                new Employee(2, "Bill Gates", 20000),
                new Employee(3, "Mark Zuckerberg", 30000));

    }

    public static void createStreamFromList() {

        List<Employee> employees = Arrays.asList(new Employee(
                        1, "Jeff Bezos", 10000),
                new Employee(2, "Bill Gates", 20000),
                new Employee(3, "Mark Zuckerberg", 30000)

        );

        employees.stream();

    }

    public static void streamCollect() {

        List<Employee> employees = Arrays.asList(new Employee(
                        1, "Jeff Bezos", 10000),
                new Employee(2, "Bill Gates", 20000),
                new Employee(3, "Mark Zuckerberg", 30000)

        );

        employees.stream().collect(Collectors.toList());
        employees.stream().toList();

    }

    public static void streamForEach() {

        List<Employee> employees = Arrays.asList(
                new Employee(1, "Jeff Bezos", 10000),
                new Employee(2, "Bill Gates", 20000),
                new Employee(3, "Mark Zuckerberg", 30000)

        );
        //Terminális operátorral
        employees.stream().forEach(System.out::println);
        employees.stream().forEach(employee -> System.out.println(employee));
        employees.stream().forEach(new Consumer<Employee>() {
            @Override
            public void accept(Employee employee) {
                System.out.println(employee);
            }
        });
    }

    public static void streamMap() {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Jeff Bezos", 10000),
                new Employee(2, "Bill Gates", 20000),
                new Employee(3, "Mark Zuckerberg", 30000)

        );

        List<String> employeeNames = employees.stream().map(Employee::getName).toList();
    }

    public static void streamFilter() {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Jeff Bezos", 10000),
                new Employee(2, "Bill Gates", 20000),
                new Employee(3, "Mark Zuckerberg", 30000)

        );

        List<String> names_ = new ArrayList<>();

        for (Employee employee : employees) {
            if (employee.getSalary() > 15000) {
                names_.add(employee.getName());
            }
        }

        List<String> names = employees.stream()
                .filter(employee -> employee.getSalary() > 15000)
                .map(Employee::getName)
                .toList();
    }

    public static void streamFlatMap() {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Jeff Bezos", 10000),
                new Employee(2, "Bill Gates", 20000),
                new Employee(3, "Mark Zuckerberg", 30000)
        );

        Map<String, List<Employee>> employeesByOrganizations = new HashMap<>();

        employeesByOrganizations.put("AMAZON", Arrays.asList(employees.get(0)));
        employeesByOrganizations.put("MICROSOFT", Arrays.asList(employees.get(1)));
        employeesByOrganizations.put("FACEBOOK", Arrays.asList(employees.get(2)));

        List<Employee> employees_ = employeesByOrganizations.entrySet().stream().flatMap(entry -> entry.getValue().stream()).toList();

        System.out.println(employees_);
    }

    public static void streamPeek() {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Jeff Bezos", 10000),
                new Employee(2, "Bill Gates", 20000),
                new Employee(3, "Mark Zuckerberg", 30000)
        );

        List<Employee> employees_ = employees.stream()
                .peek(employee -> employee.increaseSalary(500))
                .toList();

        System.out.println(employees_);
    }

    public static void streamCount() {

        List<Employee> employees = Arrays.asList(
                new Employee(1, "Jeff Bezos", 10000),
                new Employee(2, "Bill Gates", 20000),
                new Employee(3, "Mark Zuckerberg", 30000)
        );

        long count = employees.stream().filter(employee -> employee.getSalary() > 15000).count();

    }

    public static void infinityStreamLimit() {

        Stream<Integer> iterate = Stream.iterate(1, i -> i * 2);

        iterate.skip(1).limit(10).forEach(System.out::println);

        Stream.iterate('A', ch -> (char) (ch.charValue() + 1)
        ).skip(0).limit(26).forEach(System.out::println);

        Stream.iterate(true, b -> !b).skip(0).limit(26).forEach(System.out::println);

    }

    public static void streamSort() {

        List<Employee> employees = Arrays.asList(
                new Employee(1, "Jeff Bezos", 10000),
                new Employee(2, "Bill Gates", 20000),
                new Employee(3, "Mark Zuckerberg", 30000)
        );

        employees.stream().sorted((o1, o2) -> o1.getName().compareTo(o2.getName())).forEach(System.out::println);
        employees.stream().sorted(Comparator.comparing(Employee::getName)).forEach(System.out::println);

    }

    public static void streamMinMax() {

        List<Employee> employees = Arrays.asList(
                new Employee(1, "Jeff Bezos", 10000),
                new Employee(2, "Bill Gates", 20000),
                new Employee(3, "Mark Zuckerberg", 30000)
        );

        System.out.println(employees.stream().min(Comparator.comparing(Employee::getSalary)));
        System.out.println(employees.stream().max(Comparator.comparing(Employee::getSalary).reversed()));


        System.out.println(employees.stream().max(Comparator.comparing(Employee::getSalary)));
        System.out.println(employees.stream().min(Comparator.comparing(Employee::getSalary).reversed()));

    }

    public static void streamJoin() {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Jeff Bezos", 10000),
                new Employee(2, "Bill Gates", 20000),
                new Employee(3, "Mark Zuckerberg", 30000)
        );

        String collect = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println(collect);

    }

    public static void streamPartitioningBy() {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Jeff Bezos", 10000),
                new Employee(2, "Bill Gates", 20000),
                new Employee(3, "Mark Zuckerberg", 30000)
        );

        Map<Boolean, List<Employee>> collect = employees.stream().collect(Collectors.partitioningBy(employee -> employee.getSalary() > 15000));

    }

    public static void streamGroupingBy() {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Jeff Bezos", 10000),
                new Employee(2, "Bill Gates", 20000),
                new Employee(3, "Mark Zuckerberg", 30000)
        );

        Map<Integer, List<Employee>> collect = employees.stream().collect(Collectors.groupingBy(employee -> employee.getName().length()));
        System.out.println(collect);
    }

    public static void streamGroupingByParameter() {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Jeff Bezos", 10000, new Organization("AMAZON")),
                new Employee(2, "Bill Gates", 20000, new Organization("MICROSOFT")),
                new Employee(3, "Mark Zuckerberg", 30000, new Organization("FACEBOOK"))
        );

        Map<String, List<Employee>> collect = employees.stream().collect(Collectors.groupingBy(employee -> employee.getOrganization().getName()));
        System.out.println(collect);


    }


}
