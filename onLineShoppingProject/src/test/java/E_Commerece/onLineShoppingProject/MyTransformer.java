package E_Commerece.onLineShoppingProject;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;

public class MyTransformer implements IAnnotationTransformer  {

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {


		
		annotation.setRetryAnalyzer(RetryFailedTest.class);
		
	}

}
