package streams;


import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String... args) {

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

    public static void streamGroupingBy(){
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Jeff Bezos", 10000),
                new Employee(2, "Bill Gates", 20000),
                new Employee(3, "Mark Zuckerberg", 30000)
        );

        Map<Integer, List<Employee>> collect = employees.stream().collect(Collectors.groupingBy(employee -> employee.getName().length()));
        System.out.println(collect);
    }

    public static void streamGroupingByParameter(){
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Jeff Bezos", 10000, new Organization("AMAZON")),
                new Employee(2, "Bill Gates", 20000, new Organization("MICROSOFT")),
                new Employee(3, "Mark Zuckerberg", 30000, new Organization("FACEBOOK"))
        );

        Map<String, List<Employee>> collect = employees.stream().collect(Collectors.groupingBy(employee -> employee.getOrganization().getName()));
        System.out.println(collect);


    }


}
