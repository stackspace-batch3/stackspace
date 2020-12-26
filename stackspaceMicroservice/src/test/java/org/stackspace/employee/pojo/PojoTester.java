package org.stackspace.employee.pojo;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.stackspace.employee.beans.PropertyConfigurationBean2;
import org.stackspace.employee.bindings.BgvPendingEmpInfo;
import org.stackspace.employee.bindings.Employees;
import org.stackspace.employee.bindings.PreviousExperienceInfos;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;

@ExtendWith(SpringExtension.class)
//@SpringBootTest
public class PojoTester {

	@Test
	@Disabled
	public void propertyConfigurationBean2Test() {

		Validator validator = ValidatorBuilder.create().with(new SetterTester()).with(new GetterTester()).build();

		PojoClass pojoClass = PojoClassFactory.getPojoClass(PropertyConfigurationBean2.class);

		validator.validate(pojoClass);
	}

	@Test
	public void pojoTest() {

		List<PojoClass> classes = PojoClassFactory.getPojoClasses("org.stackspace.employee.beans");
		List<PojoClass> classes1 = PojoClassFactory.getPojoClasses("org.stackspace.employee.bindings");
		List<PojoClass> classes2 = PojoClassFactory.getPojoClasses("org.stackspace.employee.entity");
		List<PojoClass> classes3 = PojoClassFactory.getPojoClasses("org.stackspace.employee.model");

		loop(Arrays.asList(classes, classes1, classes2, classes3));
	}

	public void loop(List<List<PojoClass>> pojos) {
		Validator validator = ValidatorBuilder.create().with(new SetterTester()).with(new GetterTester()).build();

		for (List<PojoClass> classes : pojos) {
			validator.validate(classes);
		}
	}

	@Test
	public void pojoEq_toString_Test() {
		new BgvPendingEmpInfo().toString();
		new Employees().toString();
		new PreviousExperienceInfos().toString();

		//EqualsVerifier.forClass(BenchEmployeeInfo.class).suppress(Warning.NULL_FIELDS).usingGetClass().verify();
	}
}
