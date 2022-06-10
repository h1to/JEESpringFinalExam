# Final Exam Project #
#### Prepared by Murzaliev Eldiiar ####
#### ITSE-1908 ####
## University Admission Management System ##

### Project Describtion ###
- Database PostgeSQL;
- 10 Entities created;
- JdbcTemplate is used to access data;
- Repository interface are implemented and called only in Service classes;
````
@Repository
public class DegreeRepoImpl implements DegreeRepo {
````
 - Lazy initialization annotation used;
````
@Lazy
@Repository
public class DegreeRepoImpl implements DegreeRepo {

````
 - Different types of Bean annotations are used;
````
@Component
@Repository
@Service
````
- Different scopes are used;
````
@Scope("singleton")
@Component
public class CurrentWeekAndYear
````
 - Oauth2 is configured;
````
@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {
````
 - Login via Google account is implemented;
````
        <div>
		<h2>Please Login</h2>
		<br/>
	</div>
	<div>
		<h4><a th:href="@{/oauth2/authorization/google}">Login with Google</a></h4>	
	</div>
````
 - Thymeleaf templating engine is used;
````
<a th:href="@{/oauth2/authorization/google}">Login with Google</a>
````
 - Different types of mapping annotations are used;
````
@GetMapping
@PostMapping
@PutMapping
@DeleteMapping
````
 - ResponseStatus annotation is used;
````
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
````
 - ResponseEntity in used;
````
public ResponseEntity<String> defaultP
````
 - AOP is configured and used with good business logic;
````
    @After("kz.iitu.itse1908.murzaliev.AOP.pointcut.Pointcuts.addGradeList(students,discipline)")
    public void createGradeList...
````
 - Scheduled tasks are running in parallel and implemented with business logic. Every 10 seconds the week in the system changes and teachers can put grades on previous weeks no more;
````
@Async("threadPoolTaskScheduler")
    @Scheduled(fixedDelayString = "${fixedDelay}", initialDelayString = "${initialDelay}")
    public void changeWeek ()
````
 - Tests are implemented;
````
    @Test
    void testUploadFile()
    
    @Test
    void testGetListFiles()
````
 - File uploading and downloading service implemented;
````
    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile
````
 - Custom converter and formatter are implemented;
````
    @Override
    public Degree convert(String source) {
        String[] attr = source.split(",");
        return new Degree(Long.valueOf(attr[0]),attr[1]);
    }
````
 - Custom validator is implemented;
````
public class EmailValidator implements ConstraintValidator
````
 - ResultSetExtractors and RowMappers are implemented for more convenient way to get data from DB;
````
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        DegreeRSExtractor extractor = new DegreeRSExtractor();
        return extractor.extractData(rs);
    }
````


Error codes:

- 10 - record already exists
- 11 - record doesn't exist
- 100 - it's examination session period. You can not change grades anymore!
- 1001 - no access to this controller!



