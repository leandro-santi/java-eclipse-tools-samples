package solitudeworks.jni.simple.sample.hello;

public class HelloJNI {
	
	static {
		System.loadLibrary("libhello"); // Load native library hello.dll (Windows) or libhello.so (Unix)
		}

	// Declare an instance native method sayHello() which receives no parameter and returns void
	private native void sayHello();
	
	public static void main(String[] args) {
		new HelloJNI().sayHello();  // Create an instance and invoke the native method
	}

}
