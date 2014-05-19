package in.kiranbagul.mojo;

import in.kiranbagul.batchless2css.core.CompilerEnv;
import in.kiranbagul.batchless2css.core.ConcurrentLessCompiler;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * @requiresProject false
 */
@Mojo(name = "compile", defaultPhase = LifecyclePhase.COMPILE)
public class BatchLessCompiler extends AbstractMojo {
	/**
	 * Input folder path
	 */
	@Parameter(defaultValue = "${project.build.directory}", property = "path")
	private static String path;
	
	/**
	 * Include file filter
	 */
	@Parameter(defaultValue = ".less", property = "include")
	private static String include;
	
	/**
	 * Exclude file filter
	 */
	@Parameter(defaultValue = "", property = "exclude")
	private static String exclude;
	
	/**
	 * Compile only if source changed
	 */
	@Parameter(defaultValue = "true", property = "force")
	private static boolean force;
	
	/**
	 * No of threads to be spawned
	 */
	@Parameter(defaultValue = "6", property = "noOfThreads")
	private static int noOfThreads;
	
	/**
	 * Generated output filename extension pattern
	 */
	@Parameter(defaultValue = ".gen.css", property = "outputAs")
	private static String outputAs;
	
	/**
	 * Compress generated CSS
	 */
	@Parameter(defaultValue = "false", property = "compress")
	private static boolean compress;
	
	/**
	 * Exit on compilation error
	 */
	@Parameter(defaultValue = "true", property = "failOnError")
	private static boolean failOnError;
	
	/**
	 * Map input folder patterns to different output folder
	 */
	@Parameter(defaultValue = "", property = "mapFolder")
	private static String mapFolder;

	public void execute() throws MojoExecutionException {
		CompilerEnv.setInputFilesPath(path);
		CompilerEnv.setIncludes(include);
		CompilerEnv.setNoOfThreads(noOfThreads);
		CompilerEnv.setOutputas(outputAs);
		CompilerEnv.setCompress(compress);
		CompilerEnv.setFailOnError(failOnError);
		CompilerEnv.setForceOverwrite(force);
		if(null != mapFolder){
			CompilerEnv.setFolderMap(mapFolder);
		}
		if(null != exclude){
			CompilerEnv.setExcludes(exclude);
		}
		new ConcurrentLessCompiler().start();
	}

}
