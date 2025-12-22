package com.spring.javabased;

import java.util.List;

// Note: We knowingly omit @Component annotation here (on top of Institute, Frontend & Backend classes).
// Because, we want to give bean definitions in our @Configuration annotated class AppConfig.
// This is done, in case if Institute, Frontend & Backend classes are present in 3rd-party
// (and maybe non-Spring) library whose code we can't control - and which won't have @Component annotation on them.
public class Frontend implements ICourse {

	@Override
	public List<String> showCourses() {
		return List.of("React", "Angular");
	}

}
