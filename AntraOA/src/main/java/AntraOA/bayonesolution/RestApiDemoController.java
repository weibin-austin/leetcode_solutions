package AntraOA.bayonesolution;
//@RestController
//@RequestMapping("/student")
public class RestApiDemoController {
/* private static final Logger log = LoggerFactory.getLogger(StudentController.class);
 *
 * @Autowired
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
 *
 *
 *
 *
 */
}
