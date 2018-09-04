
package com.controllers;

import java.util.Iterator;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Employee;
import com.model.Passport;
import com.model.Student;

@Controller
public class RegisterController implements Validator {
	private static final Logger LOGGER = LogManager.getLogger(RegisterController.class.getName());
	
	@Autowired
	Employee e1;
	@Autowired
	Employee e2;
	@Autowired
	Passport ppt1;

	public static SessionFactory getSessionFactory() {
		Configuration config = new Configuration().configure();
		StandardServiceRegistry build = new StandardServiceRegistryBuilder().applySettings(config.getProperties())
				.build();
		SessionFactory sf = config.buildSessionFactory(build);
		return sf;
	}

	@RequestMapping(value = "/registeruser", method = RequestMethod.POST)
	public String studentRegistration(Student std, Model model) {
		System.out.println("----------------------------------------------------");
		LOGGER.info("Entered registration controller :: RegisterController");
		e1.setEmpId(1);
		e1.setEmpName("Guna");
		//e1.getPpt().setPptNumber(123);
		e2.setEmpId(2);
		e2.setEmpName("Dhoni");
		//e2.setPpt(ppt1);
		//e2.getPpt().setPptNumber(891);
		System.out.println("Id : " + e1.getEmpId() + " " + " Name : " + e1.getEmpName() + " Company: " + e1.getCompany()
				+ " Passport Number : " + e1.getPpt() + " Location : " + ppt1.getCity());
		System.out.println("Id : " + e2.getEmpId() + " " + " Name : " + e2.getEmpName() + " Company: " + e2.getCompany()
				+ " Passport NUmber : " + e2.getPpt() + " " + " Location : " + ppt1.getCity());
		System.out.println("------------------------------Scope Test Ended");
		SessionFactory sf = RegisterController.getSessionFactory();
		Session session = sf.openSession();
		if (std != null) {
			session.save(std);
			session.beginTransaction().commit();
			System.out.println("Record insteted");
			model.addAttribute("succMsg", "Your Registration Is Done!!,Please Login...");
		} else {
			System.out.println("Record not insterted");
		}
		model.addAttribute("username", std.getEmail());
		return "home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginStudent(Student std, Model model) {
		SessionFactory sf = RegisterController.getSessionFactory();
		Session session = sf.openSession();
		Criteria crt = session.createCriteria(Student.class);
		crt.add(Restrictions.eq("email", std.getEmail()));
		crt.add(Restrictions.eq("pwd", std.getPwd()));
		List<Student> list = crt.list();
		System.out.println(list);
		if (list.isEmpty()) {
			model.addAttribute("message", "Inavalid Credentials!!");
			return "home";
		}
		model.addAttribute("username", std.getEmail());

		Criteria getAllQuery = session.createCriteria(Student.class);
		List<Student> getAllRcrds = getAllQuery.list();
		for (Student student : getAllRcrds) {
			System.out.println("Student Name: " + student.getStdName());
		}
		model.addAttribute("allStudents", getAllRcrds);

		return "profile";
	}

	@RequestMapping(value = "/deletestudent/{email:.+}", method = RequestMethod.GET)
	public String deleteStudentWIthHyperLink(Student std, @PathVariable("email") String email, Model model) {
		SessionFactory sf = RegisterController.getSessionFactory();
		Session session = sf.openSession();
		std.setEmail(email);
		System.out.println("Name: " + std.getEmail());
		Query delQry = session.createQuery("delete from Student where email =:email");
		delQry.setParameter("email", std.getEmail());
		int delCount = delQry.executeUpdate();
		session.beginTransaction().commit();
		System.out.println("record deleted : " + delCount);
		Criteria getAllQuery = session.createCriteria(Student.class);

		List<Student> getAllRcrds = getAllQuery.list();
		for (Student student : getAllRcrds) {
			System.out.println("User Info ------ >Student Name: " + student.getStdName());
		}
		model.addAttribute("allStudents", getAllRcrds);
		return "profile";
	}

	@RequestMapping(value = "/deleteStudent")
	public String deleteStudent(Student std, @RequestParam("email") String email, Model model) {
		System.out.println("Login email : " + std.getEmail());
		System.out.println("Email : " + email);
		SessionFactory sf = RegisterController.getSessionFactory();
		Session session = sf.openSession();
		/* std.setEmail(email); */
		/* System.out.println("Name: " +std.getEmail()); */
		Query delQry = session.createQuery("delete from Student where email =:email");
		delQry.setParameter("email", email);
		int delCount = delQry.executeUpdate();
		session.beginTransaction().commit();
		System.out.println("record deleted : " + delCount);
		Criteria getAllQuery = session.createCriteria(Student.class);
		List<Student> getAllRcrds = getAllQuery.list();
		for (Student student : getAllRcrds) {
			System.out.println("Student name :  " + student.getStdName());
		}
		/* model.addAttribute("username", std.getEmail()); */
		model.addAttribute("allStudents", getAllRcrds);
		return "profile";
	}
	@RequestMapping(value="/getallusers")
	public String getAllUsers(Model model){
		SessionFactory sf = RegisterController.getSessionFactory();
		Session session = sf.openSession();
		Criteria getAllQuery = session.createCriteria(Student.class);
		List<Student> getAllRcrds = getAllQuery.list();
		for (Student student : getAllRcrds) {
			System.out.println("Student name :  " + student.getStdName());
		}
		/* model.addAttribute("username", std.getEmail()); */
		model.addAttribute("allStudents", getAllRcrds);
		return "profile";
	}
	
	@RequestMapping(value = "/editStudent")
	public String editStudent(@RequestParam("email") String email, Model model) {
		System.out.println("email");
		SessionFactory sf = RegisterController.getSessionFactory();
		Session session = sf.openSession();
		Query editQry = session.createQuery("from Student where email =:email");
		editQry.setParameter("email", email);
		List<Student> list = editQry.list();
		Student student = list.get(0);
		System.out.println("Student name : " + student.getStdName() + "Mobile : " + student.getMobile());
		model.addAttribute("editRecrd", list.get(0));
		return "editform";
	}

	@RequestMapping(value = "/updateStudent")
	public String updateStudent(Student std, @RequestParam("email") String email, Model model) {
		System.out.println("email" + email);
		System.out.println("Name : " + std.getStdName());
		SessionFactory sf = RegisterController.getSessionFactory();
		Session session = sf.openSession();
		Query updateQry = session
				.createQuery("update Student SET stdName=:stdName,pwd=:pwd,mobile=:mobile WHERE email=:email");
		updateQry.setParameter("stdName", std.getStdName());
		updateQry.setParameter("pwd", std.getPwd());
		updateQry.setParameter("mobile", std.getMobile());
		updateQry.setParameter("email", std.getEmail());
		int updateCount = updateQry.executeUpdate();
		session.beginTransaction().commit();
		System.out.println("Updated " + updateCount);
		Criteria getAllQuery = session.createCriteria(Student.class);
		List<Student> getAllRcrds = getAllQuery.list();
		/* model.addAttribute("username", std.getEmail()); */
		model.addAttribute("allStudents", getAllRcrds);
		return "profile";
	}

	@RequestMapping(value = "/deletemultiple")
	public String deleteMultipleRecords(Model model, @RequestParam("checkDeleteAll") List<String> checkDeleteAll) {
		String[] stringArray = checkDeleteAll.toArray(new String[0]);
		System.out.println("SELECTED VALUES : " + stringArray.length);
		for (String string : stringArray) {
			System.out.println("Inside loop " + string);
		}

		/*
		 * List<String> items =
		 * Arrays.asList(checkDeleteAll.split("\\s*,\\s*"));
		 * System.out.println(items);
		 */

		SessionFactory sf = RegisterController.getSessionFactory();
		Session session = sf.openSession();
		if (!checkDeleteAll.isEmpty()) {
			Query delMul = session.createQuery("delete from Student where email IN (:email)");

			delMul.setParameterList("email", stringArray);
			int delCount = delMul.executeUpdate();
			System.out.println("Deleted Count : " + delCount);
			session.beginTransaction().commit();
		}
		Criteria getAllQuery = session.createCriteria(Student.class);
		List<Student> getAllRcrds = getAllQuery.list();
		model.addAttribute("allStudents", getAllRcrds);
		return "profile";

	}

	/*
	 * public String deleteMultipleRecords(Model
	 * model, @RequestParam("checkDeleteAll") String checkDeleteAll){ String[]
	 * deleMultiple = checkDeleteAll.split(","); SessionFactory sf =
	 * RegisterController.getSessionFactory(); Session session =
	 * sf.openSession(); for (String emailList : deleMultiple) { Query delMulQry
	 * = session.createQuery("delete from Student WHERE email=:emailList1");
	 * delMulQry.setParameter("emailList1", emailList); int delRecrdCount =
	 * delMulQry.executeUpdate(); System.out.println("Deleted records count : "
	 * +delRecrdCount); session.beginTransaction().commit(); } Criteria
	 * getAllQuery = session.createCriteria(Student.class); List<Student>
	 * getAllRcrds = getAllQuery.list(); model.addAttribute("allStudents",
	 * getAllRcrds); return "profile"; }
	 */

	public static Student getStudentInfo(String email) {
		Student stdInfo = new Student();
		SessionFactory sf = RegisterController.getSessionFactory();
		Session session = sf.openSession();
		Query getStdInfo = session.createQuery("from Student WHERE email=:email");
		getStdInfo.setParameter("email", email);
		List<Student> list = getStdInfo.list();
		if (list != null && list.size() != 0) {
			System.out.println("Size : " + list.size());
			stdInfo = list.get(0);
			System.out.println("Name : " + stdInfo.getStdName() + stdInfo.getEmail());
			return stdInfo;
		} else {
			System.out.println("Your entered email not found,Please enter Correct Email");
			return null;
		}
	}

	@RequestMapping(value = "/getuserinfo", method = RequestMethod.POST)
	public String getStudentInfo1(@RequestParam("email") String email, Model model) {
		System.out.println("------Request Came-----");
		SessionFactory sf = RegisterController.getSessionFactory();
		Session session = sf.openSession();
		Student studentInfo = RegisterController.getStudentInfo(email);
		if (studentInfo != null) {
			model.addAttribute("getStdInfo", studentInfo);
			return "student-info";
		} else {
			model.addAttribute("msg", "Your entered email not found,Please enter Correct Email");
			Criteria getAllQuery = session.createCriteria(Student.class);
			List<Student> getAllRcrds = getAllQuery.list();
			model.addAttribute("allStudents", getAllRcrds);
			return "profile";
		}
	}

	@RequestMapping(value = "/viewstudent", method = RequestMethod.GET)
	public String viewStudent(@RequestParam("email") String email, Model model) {
		System.out.println("-----User Info Displaying here----");
		Student studentInfo = RegisterController.getStudentInfo(email);
		model.addAttribute("getStdInfo", studentInfo);
		return "student-info";
	}

	/*
	 * http://www.raistudies.com/spring/spring-mvc/spring-mvc-3-controller-for-
	 * performing-crud-operation-using-mybatisibatis-3/
	 */ public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub

	}

}
