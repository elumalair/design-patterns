# design-patterns

Repository Pattern:

A simple example to provide a basic idea of how this pattern works.

Let's use an example of an MVC application, using the Entity Framework.

Fact is..: As long as we are getting the correct results, we are not concerned with how the application code is structured, what the various layers defined are, how they interact, how they pass the required data among them and so on

AS-IS Version: Most of the cases, we use the database context directly inside the controllers. This creates tight coupling between the controller and the data access layer and if we look closely into this type of code, it violates the Single Responsibility Principle as well as Open close principle.

Layer 1 is using the database context directly and connects with the SQL Server.

Problem: Any change related to the data-access layer can break the controller code.

Solution:

This is where the repository pattern can be implemented, to separate the layers. Our purpose will be to separate the controller and the data access layer (database context) using an intermediate layer, in other words, repository layer, for communication between the two.

My conclusion - repository pattern is better than DAO due its interfaces are closed to modification.

Now we can see an Example using Repository Pattern.

StudentController.java [Layer 1]

@RestController public class StudentController {

@Autowired private StudentRepository repository; public Student findStudentById() { return repository.findById(id); } }

StudentRepository.java[Layer 2]

@Repository public interface StudentRepository extends CrudRepository<Student, Long> { public Student findById(long id); }

Student.java[Layer 3]

@Entity public class Student { @Id @GeneratedValue @Column(name="ID") private long id;

@Column(name="NAME")  

private String name;

@Column(name="AGE")
private long age;

}


