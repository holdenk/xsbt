/* sbt -- Simple Build Tool
 * Copyright 2008, 2009  Mark Harrah
 */
package xsbti;

import java.io.File;

public interface AnalysisCallback
{
	/** The names of classes that the analyzer should find subclasses of.*/
	public String[] superclassNames();
	/** Called when the the given superclass could not be found on the classpath by the compiler.*/
	public void superclassNotFound(String superclassName);
	/** Called before the source at the given location is processed. */
	public void beginSource(File source);
	/** Called when the a subclass of one of the classes given in <code>superclassNames</code> is
	* discovered.*/
	public void foundSubclass(File source, String subclassName, String superclassName, boolean isModule);
	/** Called to indicate that the source file <code>source</code> depends on the source file
	* <code>dependsOn</code>.*/
	public void sourceDependency(File dependsOn, File source);
	/** Called to indicate that the source file <code>source</code> depends on the jar
	* <code>jar</code>.*/
	public void jarDependency(File jar, File source);
	/** Called to indicate that the source file <code>source</code> depends on the class file
	* <code>clazz</code>.*/
	public void classDependency(File clazz, File source);
	/** Called to indicate that the source file <code>source</code> produces a class file at
	* <code>module</code>.*/
	public void generatedClass(File source, File module);
	/** Called after the source at the given location has been processed. */
	public void endSource(File sourcePath);
	/** Called when a module with a public 'main' method with the right signature is found.*/
	public void foundApplication(File source, String className);
}