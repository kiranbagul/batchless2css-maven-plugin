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
@Mojo(name = "batchLess2CssCompiler",defaultPhase = LifecyclePhase.COMPILE)
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
	private static String includes;
	
	/**
	 * Exclude file filter
	 */
	@Parameter(defaultValue = "", property = "exclude")
	private static String excludes;
	
	/**
	 * Compile only if source changed
	 */
	@Parameter(defaultValue = "true", property = "force")
	private static boolean forceOverwrite;
	
	/**
	 * No of threads to be spawned
	 */
	@Parameter(defaultValue = "6", property = "noOfThreads")
	private static int noOfThreads;
	
	/**
	 * Generated output filename extension pattern
	 */
	@Parameter(defaultValue = ".gen.css", property = "outputas")
	private static String outputas;
	
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
		CompilerEnv.setIncludes(includes);
		CompilerEnv.setNoOfThreads(noOfThreads);
		CompilerEnv.setOutputas(outputas);
		CompilerEnv.setCompress(compress);
		CompilerEnv.setFailOnError(failOnError);
		CompilerEnv.setForceOverwrite(forceOverwrite);
		if(null != mapFolder){
			CompilerEnv.setFolderMap(mapFolder);
		}
		if(null != excludes){
			CompilerEnv.setExcludes(excludes);
		}
		new ConcurrentLessCompiler().start();
	}

}
