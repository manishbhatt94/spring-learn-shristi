package com.spring.javabased;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

// Note: We knowingly omit @Component annotation here (on top of Institute, Frontend & Backend classes).
// Because, we want to give bean definitions in our @Configuration annotated class AppConfig.
// This is done, in case if Institute, Frontend & Backend classes are present in 3rd-party
// (and maybe non-Spring) library whose code we can't control - and which won't have @Component annotation on them.
public class Institute {

	// Auto-wired by type ICourse
	// and add @Qualifier(<bean-name>) to specify out of the two implementation
	// classes of ICourse interface, the Spring bean corresponding to which
	// implementation class (specified by providing bean name inside
	// @Qualifier(<bean-name>) annotation) must be auto-wired into this field:
	// `private ICourse course;`
	@Autowired
	@Qualifier("getBackend") // Note: bean name is "getBackend" - as specified in AppConfig class
	private ICourse course;

	// Note: Suppose this Institute class is present in a 3rd-party library and for
	// this field `ICourse unqualifiedCourse`, this code only puts @Autowired, and
	// does not mention which implementation class's bean has to be wired.
	// In that case, we can use @Primary annotation in our AppConfig @Configuration
	// class on top of the bean definition which we want to be picked in case if
	// that information is not available with the @Autowired annotation in this
	// file.
	@Autowired
	private ICourse unqualifiedCourse;

	void courseDetails() {
		System.out.println("Courses offered:");
		course.showCourses().forEach(System.out::println);
		System.out.println();

		System.out.println("Courses offered:");
		unqualifiedCourse.showCourses().forEach(System.out::println);
	}

}
