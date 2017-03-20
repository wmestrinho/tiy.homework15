package com.example;

import com.example.data.*;
import com.example.repository.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	AddressRepo addressRepo;

	@Autowired
	BootcampRepo bootcampRepo;

	@Autowired
	CompanyRepo companyRepo;

	@Autowired
	InstructorRepo instructorRepo;

	@Autowired
	StudentRepo studentRepo;


	@Test
	public void Addresstest() {

		Address tiyAddress1 = new Address("102 Garland", "Orlando", "Florida", "CANADA");
		Address tiyAddress2 = new Address("103 Garland", "Orlando", "Florida", "AUSTRALIA");
		Address tiyAddress3 = new Address("104 Garland", "Orlando", "Florida", "CHINA");
		Address tiyAddress = new Address("101 Garland", "Orlando", "Florida", "USA");

		addressRepo.save(tiyAddress);
		addressRepo.save(tiyAddress1);
		addressRepo.save(tiyAddress2);
		addressRepo.save(tiyAddress3);

		Address fetchedAddress = addressRepo.findOne(tiyAddress.getId());

		Assert.assertEquals("Steet did not save!", tiyAddress.getStreet(), fetchedAddress.getStreet());
		System.out.println(tiyAddress.toString());

		Student tiyStudent = new Student("Carlos", "itscarlos@gmail.com", tiyAddress);
		Student tiyStudent3 = new Student("Luiz", "wmestrinho@live.com", tiyAddress2);
		Student tiyStudent1 = new Student("Wagner", "wmestrinho@live.com", tiyAddress3);
		Student tiyStudent2 = new Student("Mestrinho", "wmestrinho@live.com", tiyAddress1);

		studentRepo.save(tiyStudent);
		studentRepo.save(tiyStudent1);
		studentRepo.save(tiyStudent2);
		studentRepo.save(tiyStudent3);

		System.out.println(tiyStudent.getEmail());
		System.out.println(tiyStudent.getName());
		System.out.println(tiyStudent.getHomeAddress());

		List<Student> students = new ArrayList<>();
		students.add(tiyStudent);
		students.add(tiyStudent1);
		students.add(tiyStudent2);
		students.add(tiyStudent3);

		Instructor teach = new Instructor("Frank", "07102016", tiyAddress1, tiyAddress2);
		Instructor teach1 = new Instructor("John", "07102016", tiyAddress2, tiyAddress3);
		List<Instructor> instructors = new ArrayList<>();
		instructors.add(teach);
		instructors.add(teach1);

		instructorRepo.save(instructors);

		Bootcamp tiyJava = new Bootcamp("java cohort 17", "13012017", "29032017", instructors, students);

		bootcampRepo.save(tiyJava);

		System.out.println(tiyJava.toString());

		Company theironyard = new Company("the iron yard", "4074851769", tiyAddress, tiyJava, instructors);
		theironyard.setTeachers(instructors);

		companyRepo.save(theironyard);
		System.out.println(theironyard.toString());

	}
	@Test
	@Transactional
	public void CompanyInstructorsAddressTest(){

		//Arranging Address
		Address tiyAddress1 = new Address("102 Garland", "Orlando", "Florida", "CANADA");
		Address tiyAddress4 = new Address("102 Garland", "Orlando", "Florida", "BRAZIL");
		Address tiyAddress2 = new Address("103 Garland", "Orlando", "Florida", "AUSTRALIA");
		Address tiyAddress3 = new Address("104 Garland", "Orlando", "Florida", "CHINA");
		Address tiyAddress = new Address("101 Garland", "Orlando", "Florida", "USA");

		//Acting saving Address
		addressRepo.save(tiyAddress);
		addressRepo.save(tiyAddress1);
		addressRepo.save(tiyAddress2);
		addressRepo.save(tiyAddress3);
		addressRepo.save(tiyAddress4);

		Address fetchedAddress = addressRepo.findOne(tiyAddress.getId());

		Assert.assertEquals("Address not saved", tiyAddress.getStreet(),fetchedAddress.getStreet());
		//Arranging Instructors
		Instructor teach = new Instructor("Frank", "07102016", tiyAddress1, tiyAddress2);
		Instructor teach1 = new Instructor("John", "07102016", tiyAddress2, tiyAddress3);

		//Adding to Array of Instructors
		List<Instructor> instructors = new ArrayList<>();
		instructors.add(teach);
		instructors.add(teach1);

		//Acting Saving Instrucotrs
		instructorRepo.save(instructors);

		//Fetching data
		Instructor fetchedInstructor = instructorRepo.findOne(teach1.getId());

		//Assertion
		Assert.assertEquals("Instrcutors not saved", teach1.getName(), fetchedInstructor.getName());

		//Arranging Student
		Student tiyStudent1 = new Student("Wagner", "wmestrinho@live.com", tiyAddress3);
		Student tiyStudent2 = new Student("Mestrinho", "wmestrinho@live.com", tiyAddress1);

		//Adding to Array
		List<Student> students = new ArrayList<>();
		students.add(tiyStudent1);
		students.add(tiyStudent2);

		//Acting Saving Students
		studentRepo.save(tiyStudent1);
		studentRepo.save(tiyStudent2);

		//Fetching data
		Student fetchedStudent = studentRepo.findOne(tiyStudent1.getId());

		//Assertion
		Assert.assertEquals("Students not saved", tiyStudent1.getName(), fetchedStudent.getName());

		//Arranging Bootcamp
		Bootcamp tiyJava = new Bootcamp("java cohort 17", "13012017", "29032017", instructors, students);

		//Acting Saving Bootcamp
		bootcampRepo.save(tiyJava);

		//Fecthing data
		Bootcamp fetchedBootecamp = bootcampRepo.findOne(tiyJava.getId());

		//Assertion
		Assert.assertEquals("Bootcamp not saved", tiyJava.getName(), fetchedBootecamp.getName());

		//Arranging Company
		Company theironyard = new Company("the iron yard", "4074851769", tiyAddress, tiyJava, instructors);
		theironyard.setTeachers(instructors);

		//Acting Saving Company
		companyRepo.save(theironyard);

		//Fetching data
		Company fetchedCompany = companyRepo.findOne(theironyard.getId());

		//Assertion Companys Name
		Assert.assertEquals("Company did not saved!", theironyard.getName(), fetchedCompany.getName());
		//Assertion Instrcutors List
		Assert.assertEquals("Instructors did not saved!", 2  , fetchedCompany.getTeachers().size());
		//Assertion Comapnys Addreess
		Assert.assertEquals("Company's Address not saved",theironyard.getWorkAddress().getStreet(), fetchedAddress.getStreet());
		//Assertion Instructor 1
		Assert.assertEquals("Instrcutors did not saved", teach.getHomeAddress().getStreet(), fetchedCompany.getTeachers().get(0).getHomeAddress().getStreet());
		//Assertion Instructor 2
		Assert.assertEquals("Instrcutors did not saved", teach1.getWorkAddress().getStreet(), fetchedCompany.getTeachers().get(1).getWorkAddress().getStreet());

		//Print
		System.out.println(theironyard.getName());
		System.out.println(theironyard.getWorkAddress());
		System.out.println(theironyard.getTeachers().get(1).getHomeAddress().getStreet());
		System.out.println(theironyard.getTeachers().get(1).getWorkAddress().getStreet());
		System.out.println(theironyard.getTeachers().get(0).getHomeAddress().getStreet());
		System.out.println(theironyard.getTeachers().get(0).getWorkAddress().getStreet());
	}
		@Test
		public void StudentWithAddressTest(){
		//Address
		Address tiyAddress1 = new Address("102 Garland", "Orlando", "Florida", "CANADA");

			addressRepo.save(tiyAddress1);

			Address fetchedAddress = addressRepo.findOne(tiyAddress1.getId());

			Assert.assertEquals("Address not saved", tiyAddress1.getStreet(),fetchedAddress.getStreet());

			//Student
			Student tiyStudent1 = new Student("Wagner", "wmestrinho@live.com", tiyAddress1);

			studentRepo.save(tiyStudent1);

			Student fetchedStudent = studentRepo.findOne(tiyStudent1.getId());

			Assert.assertEquals("Student not saved", tiyStudent1.getName(), fetchedStudent.getName());
			Assert.assertEquals("Address for Student not saved", fetchedAddress.getStreet(), fetchedStudent.getHomeAddress().getStreet());

			//Print
			System.out.println(tiyStudent1.getHomeAddress());
			System.out.println(tiyStudent1.getName());
			System.out.println(tiyStudent1.getEmail());
			System.out.println(tiyStudent1.getId());

		}
}