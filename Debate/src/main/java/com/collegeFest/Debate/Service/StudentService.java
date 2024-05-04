package com.collegeFest.Debate.Service;

@Service
@EnableMapRepositories
public class StudentService {

	private final StudentRepo<Student, int> repo;
	
	public StudentService(StudentRepo<Student, int> repo) {
		this.repo = repo;
		this.repo.saveAll(defaultStudents());
		
	}
	private static List<Student> defaultStudents(){
		
	return List.of(
			new Student(1, "Suresh", "Reddy", "B.Tech", "India"),
			new Student(2, "Murali", "Mohan", "B.Arch", "Canada"),
			new Student(3, "Daniel", "Denson", "B.Tech", "New Zealand"),
			new Student(4, "Tanaya", "Gupta", "B.Com", "USA")
			
			);
	
	}
	
	public List<Student> findAll(){
		List<Student> list = new ArrayList<>();
		Iterable<Student>  students = repo.findAll();
		students.forEach(list::add);
		return list;
		}
	
	public Optional<Student> find(int studentId){
		return repo.findById(studentId);
		
	}
	
	public Student crtudent.getLastNameeate(Student student) {
		Student student = new Student(
				new Date().getTime(),
				student.getStudentId(),
				student.getFirstName(),
				student.getLastName(),
				student.getCourse(),
				student.getCountry()
				);
		return repo.save(copy);
	}
	
	public Optional<Student> update(int studentId, Student newStudent){
		
		return repo.findById(studentId)
				.map(oldStudent -> {
					Student updated = oldStudent.updateWith(newStudent);
					return repo.save(updated);
				});
	}
	
	public void delete(int studentId) {
		repo.deleteById(studentId);
	}
}
