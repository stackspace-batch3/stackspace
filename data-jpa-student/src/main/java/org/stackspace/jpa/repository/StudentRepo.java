package org.stackspace.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.stackspace.jpa.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

//	 @Query(value = "Select * from Student_Jpa where student_id=:id", nativeQuery
//	 = true)
	List<Student> findByStudentIdNative(@Param("id") int studentId);

	@Query(value = "from Student where studentId=:id and age=:age")
	Student findByStudentIDAndAge(@Param("age") int age, @Param("id") int studentId);

	@Query(value = "from Student where studentId=:id and age=:age")
	Student findByStudentID(@Param("id") int studentId);

	@Query(value = "from Student where studentId=?1 and age=?2")
	Student findByStudentIDAndAgePosition(int studentId, int age);

//	@Query(value = "from Student where studentName=:name")
	Student getByStudentName(@Param("name") String studentName);

	// Que
	Student findByStudentName(String studentName);

	List<Student> findByStudentNameStartingWith(String letter);

	List<Student> findByAgeLessThan(int age);

	List<Student> findByStudentNameAndAge(String studentName, int age);

	// Projection, projectors
	@Modifying
	@Query(value = "delete from Student where studentId=:id")
	void deleteById(@Param("id") int id);

}
