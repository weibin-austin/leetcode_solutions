Flexton.md

# Flexton (Vendor)
Adam Xie - 08/25/2021 - Flexton
### Question 1: Group Anagrams LC49
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
```
public static List<List<String>> group(List<String> strs) {
      Map<String, List<String>> map = new HashMap<>();
      for (String s: strs) {
          char[] temp = new char[26];
          for (char c: s.toCharArray()) {
              temp[Character.toLowerCase(c) - 'a']++;
          }
          String key = String.valueOf(temp);
          if (!map.containsKey(key))
              map.put(key, new ArrayList<>());
          map.get(key).add(s);
      }
      return new ArrayList<>(map.values());
}
```


### Given an array of integers, return an array of integers which contains
[1st integer, Sum of next 2 integers (2nd, 3rd), Sum of next 3 integers (4th, 5th, 6th)]
Input size n
[1,6,8,5,9,4,7,2]
Output size m
[1,14,18,9]
Solution:
```
import java.util.ArrayList;
import java.util.List;
public class Problem1 {
    public static List<Integer> solution( int [] arr){
        int count = 1;
        List<Integer> res = new ArrayList<>();
        int length = arr.length;
        for(int i = 0; i < length;){
            int sum = 0;
            for(int j = 0; j < count&& i< arr.length; j++){
                sum += arr[i];
                i++;
            }
            count++;
            res.add(sum);
        }
        return res;
    }
    public static void main(String args[]){
        int [] testcase1 = new int []{1,6,8,5,9,4,7,2};
        System.out.println(solution(testcase1));
    }
}
```




### Question 2: Make the changes inside the class to make it thread safe singleton:
```
class DemoStudent {
	private String name;
	private List<String> courses;

  	public DemoStudent() {
	}
	public String getName() {
		return name;
	}

	public void setName(String name) { // delete
		this.name = name;
	}

	public List<String> getCourses() {
		return courses;
	}

	public void setCourses(List<String> courses) { // delete
		this.courses = courses;
	}
}

```
Solution:
```
class DemoStudent {
    private volatile String name;
    private volatile List<String> courses;
    private static volatile DemoStudent instance = null;
    private DemoStudent() {
    }
    public static DemoStudent getInstance(){
        if(instance == null){
            synchronized (DemoStudent.class){
                if(instance == null){
                    instance = new DemoStudent();
                }
            }
        }
        return instance;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<String> getCourses() {
        return courses;
    }
    public void setCourses(List<String> courses) {
        this.courses = courses;
    }
}


```



### Total number of threads including the main thread for the code mentioned:
```
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for(int i=0;i<7;i++){
            Thread thread =new Thread(()->{
                System.out.println("T:1:"+Thread.currentThread().getName());
            });
            thread.start();
        }
        for(int i=0;i<10;i++){
            Thread thread=new Thread(()->{
                System.out.println("T:2:"+Thread.currentThread().getName());
            });
            executorService.execute(thread);
        }
    }
}

// Solution: main 1 + 7 + 4 = 13 ?
```

### Question 3: What is the output for the mentioned code and why?
Putting synchronized on an instance method means that the thread has to acquire the lock on the object instance that the method is called on before the thread can start executing any code in that method.
```
public class DemoExample {

    public static void main(String[] args) {
        ThreadDemo threadDemo=new ThreadDemo();
        threadDemo.start();
		
        for(int i=0;i<10;i++){
            System.out.println("Value of i is : "+i);
        }
    }
}

class ThreadDemo extends Thread{
    @Override
    public synchronized void start() {
        System.out.println("Inside the start method!!!");
    }

    @Override
    public void run() {
        System.out.println("Inside the run method!!!");
    }
}

**Solution:**
Inside the start method!!!
Value of i is : 0 - 9
```


### Bean Scope
singleton，prototype，request，session，global session


### what is immutable class
immutable classes define objects which, once created, never change their value.

### how to create immutable class
1. Declare the class as **final** so it can’t be extended.
2. Make all fields **private** so that direct access is not allowed.
3. **Don’t provide setter** methods for variables.
4. Make all mutable fields final so that its value can be assigned only once.
5. Initialize all the fields via a **constructor performing deep copy**.
6. Perform cloning of objects in the **getter** methods to **return a copy rather than the object reference.**

### How immutable clone (deep copy)
If you want to change an immutable object, you must clone it and change the clone while you are creating it. Use another constructor to clone your object.

### What is Singleton?
Singleton is design Pattern which means only one object can be created from the class. Usage for singleton: logger, drivers objects, caching, thread pool.

### What's the downside of singleton
One of the main disadvantages of singletons is that they **make unit testing very hard**. 
Singleton introduce global state to the application. The problem is that you cannot completely isolate classes dependent on singletons. When you are trying to test such a class, you will test the Singleton as well.
Moreover, since its reference is not completely transparent while passing to different methods, it becomes **difficult to track**.

### the latest version of Java: JDK 17
### What is optional
It's a new feature introduced in Java 8.
Optional is a container object used to contain not-null objects. Optional object represents null with absent value. It use available’ or ‘not available’ instead of checking null values.

### What is the difference between application context and beanfactory.
They are both IOC container. The BeanFactory is the most basic version of IOC containers, and the ApplicationContext extends the features of BeanFactory. including messaging functionality, event publication functionality, annotation-based dependency injection and easy integration with Spring AOP features. 


### How HashMap works
"HashMap": is a Hash Table based implementation of the Map interface. It store key-value pairs,implement the hashCode() and the equals() methods to determine the index of the key-value pairs and to detect duplicates. It makes no guarantees to the order of the map. It permits null values and null key. It permits duplicated values, but not duplicated keys. Asynchronized

### What is RB Tree( I mentioned it when introducing HashMap)
Red-Black Tree. It is a self-balancing binary search tree. Each node stores an extra bit representing "color" ("red" or "black"), used to ensure that the tree remains balanced during insertions and deletions.

### What is Lambda Expression
A lambda expression is a short block of code which takes in parameters and returns a value. Lambda expressions are similar to methods, but they do not need a name and they can be implemented right in the body of a method.

### Can we use Lambda Expression to create objects from non-Functional Interfaces?
If you assign a lambda expression to an interface having more than one abstract method (i.e. a non functional interface), the lambda expression could only implement one of the methods, leaving the other methods unimplemented.

### What is Microservices
Microservice is an architecture that **structures an application loosely from other services** so it is independent and modular. Each service running has its own process and database.


### Do you know any other disadvantages of MicroServices?
Complex architecture; challenge to design; DB for each service, challenge to share database (infact share API); Transaction data; DevOps challenge.


### PUT vs PATCH
PATCH: making partial changes to an existing resource. May have side-effects on other resources.

Different HTTP Response code

### What Collections API have you used
List, Set, Map

### What is Optional Class !!!!
Optional: can help to handle situations of getting the NullPointerException (NPE). It works as a container for the object of type T. If the return value is not a null, it can return a value of this object. When the value is null it allows doing some predefined actions instead of throwing NPE.


### Why do we use SpringBoot?
Spring Boot is an open source platform with auto configuration for Java developers to develop a stand-alone and production-grade spring application that you can just run. You can get started with minimum configurations without the need for an entire Spring configuration setup.

It helps you to get production-grade applications up and running quickly without having to worry about configuring your application correctly and safely.
It provides a flexible way to configure Java Beans, XML configurations, and Database Transactions.
It provides a powerful batch processing and manages REST endpoints.
In Spring Boot, everything is auto configured; no manual configurations are needed.
It offers annotation-based spring application.
Eases dependency management.
It includes Embedded Servlet Container.

### What Spring Annotations have you used?
@Repository, @Controller, @Service, @Component, @RestController, 
@RequestMapping, @GetMapping, @PostMapping, @PutMapping, @DeleteMapping, @RequestBody,
@PathVariable, @Validated @Valid
@Entity, @Id, @Column,

### What is an Actuator?
It belongs to Spring Cloud family, and provides **secured endpoints** for monitoring and managing your Spring Boot application.



### Question 4: Write a RestController to perform the mentioned operations: ???
--> Add a Student --> Return Entity with status CREATED.
--> Delete a Student By ID --> Return Entity with status OK.
--> Update a Student By ID --> Return Entity with status OK.
--> Get a Student By ID--> Return Entity with status FOUND.
--> Get All Students --> Return Entity with status OK.



@RestController
// @RequestMapping("/student")
public class StudentController{
    private static final Logger log = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    StudentRepository studentRepository;

    // add a student
    @PostMapping
    public ResponseEntity<Student> createNewStudent(@RequestBody @Valid Student student){
        Student saveStudent = studentRepository.save(student);
        return new ResponseEntity<>(saveStudent, HttpStatus.CREATED);
    }

    // delete by ID
    @DeleteMapping(value = "/student/{id}")
    // @RequestMapping(method = RequestMethod.DELETE, value = "/student/{id}")
    public ResponseEntity<Student> deleteStu(@PathVariable("id") String id){
        Student stu = studentRepository.findById(id);
        if(stu == null){
            throw new StudentNotFoundException(messages.getMessage("STUDENT_NOT_FOUND")); 
        }
        StudentRepository.deleteById(id);
        return new ResponseEntity<ResponseMessage>(new ResponseMessage(messages.getMessage("STUDENT_DELTETED"), stu), HttpStatus.OK);
    }


    // Update by ID
    @PutMapping(value = "/student/{id}")
    public ResponseEntity<Student> updateByID(@PathVariable("id") String id, @RequestBody Student student){ //@RequestBody convert the http request body into Customer Object.
        Student currStudent = studentRepository.findById(id);
        if(currStudent == null) {
            throw new StudentNotFoundException(messages.getMessage("STUDENT_NOT_FOUND"));
        }
        currStudent.setName(student.getName());
        currStudent.setAge(student.getAge());
        StudentRepository.updateByID(currStudent); // updateByID
        return new ResponseEntity<Student>(currStudent, HttpStatus.OK);

    }


    // read By ID
    @GetMapping(value = "/student/{id}")
    // @RequestMapping(method = RequestMethod.GET, value = "/student/{id}")
    public ResponseEntity<Student> getById(@PathVariable("id") String id){
        Student stu = studentRepository.findById(id);
        return new ResponseEntity<student>(stu, HttpStatus.FOUND);
        // return studentRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Invalid ride id %s", id)));
    }


    // get all
    @GetMapping(value = "/student")
    public ResponseEntity<Student> getAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        return new ResponseEntity<List<Studeng>> (studentList, HttpStatus.OK);
    }



    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorResponse> exceptionHandlerStudentNotFound(Exception ex) {
        logger.error("Cannot find student");
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.NOT_FOUND.value());
        error.setMessage(ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}

