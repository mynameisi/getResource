/**
 * this code demonstrates the utilization of getResource method from class "java.lang.Class<T>"
 */
package wgz.test.getResource;

import java.net.URL;

public class GetResourceTest {

	public static void main(String[] args) {

		testBeforeServerStart();

	}
	
	public static void testBeforeServerStart() {
		/*
		 * The GetResourceTest.class returns an instance of the java.lang.Class
		 * class. This instance is automatically created by the JVM for every
		 * class loaded into the memory. This instance, also known as a meta
		 * object, contains the information about the class file such as class
		 * name,constructors, and methods. You can obtain the URL of a file in
		 * the class path by : invoking the getResource(filename) method on the
		 * meta object. --<<Introdcution to Java Programming 8th>>
		 */
		Class metaObject = GetResourceTest.class;

		/*
		 * how to access resource: 3 getResource searches for the current
		 * location of the class file
		 */
		URL u1 = metaObject.getResource("3");
		System.out.println("url for res \" 3 \" is: " + u1);

		/*
		 * "." is a file in the current directory when double click would go
		 * back up one directory
		 */
		URL u2 = metaObject.getResource(".");
		System.out.println("url for res \" . \" is: " + u2);

		URL u22 = metaObject.getClassLoader().getResource(".");
		System.out.println("url for res \" . \" is: " + u22
				+ " 【for class loader】");

		/*
		 * "/" is where all the class files resides in
		 */
		URL u3 = metaObject.getResource("/");
		System.out.println("url for res \" / \" is: " + u3);

		URL u33 = metaObject.getClassLoader().getResource("/");
		System.out.println("url for res \" . \" is: " + u33
				+ " 【for class loader】");

		URL u4 = metaObject.getResource("/_res/1");
		System.out.println("url for res \" 1 \" is: " + u4);
	}

	/**
	 * this method only happens when after the web app is deployed
	 */
	public static void testAfterServerStart() {
		//directly obtain resource would return null
		URL r1 = GetResourceTest.class.getResource(".");
		System.out.println("url for res \" . \" is: " + r1);

		//the locating of resource however still works
		URL r11 = GetResourceTest.class.getResource("3");
		System.out.println("url for res \" 3 \" is: " + r11);

		//the / still returns the main directory of all .class files
		URL r2 = GetResourceTest.class.getResource("/");
		System.out.println("url for res \" / \" is: " + r2);

		//with or without classloader is the same
		URL r3 = GetResourceTest.class.getClassLoader().getResource("/");
		System.out.println("url for res \" / \" is: " + r3
				+ " [for classLoader]");
	}

	

}
