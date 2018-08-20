package com.jxedu.plugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

@Mojo( name = "jxedu")
public class JxeduPlugin extends AbstractMojo {

     @Parameter
      private String name;

     @Parameter
      private  Integer age;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {


         getLog().info(String.format("参数信息：%s,%d",name,age));

    }
}
