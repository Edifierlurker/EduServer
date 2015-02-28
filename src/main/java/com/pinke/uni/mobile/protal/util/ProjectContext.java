package com.pinke.uni.mobile.protal.util;

public class ProjectContext
{
    private static ProjectContext instance = new ProjectContext();

    private String rootPath;

    private String configPath;

    private String projectConfigFile;
    
    private String iproxyPath;
    
    private String loggerPath;
    
    private String category_images;
    
    public String getCategory_images() {
		return category_images;
	}

	public void setCategory_images(String category_images) {
		this.category_images = category_images;
	}

	public String getIproxyPath() {
		return iproxyPath;
	}

	public void setIproxyPath(String iproxyPath) {
		this.iproxyPath = iproxyPath;
	}

	private ProjectContext()
    {
        
    }

    public static ProjectContext getInstance()
    {
        return instance;
    }

    public String getRootPath()
    {
        return rootPath;
    }
    public void setRootPath(String rootPath)
    {
        this.rootPath = rootPath;
    }

    public String getConfigPath()
    {
        return configPath;
    }

    public void setConfigPath(String configPath)
    {
        this.configPath = configPath;
    }

    public String getProjectConfigFile()
    {
        return projectConfigFile;
    }

    public void setProjectConfigFile(String projectConfigPath)
    {
        this.projectConfigFile = projectConfigPath;
    }

	public String getLoggerPath() {
		return loggerPath;
	}

	public void setLoggerPath(String loggerPath) {
		this.loggerPath = loggerPath;
	}
    
    

}
