/*
*    ------ BEGIN LICENSE ATTRIBUTION ------
*    
*    Portions of this file have been appropriated or derived from the following project(s) and therefore require attribution to the original licenses and authors.
*    
*    Project: https://spring.io/projects/spring-boot
*    Release: https://github.com/spring-projects/spring-boot/releases/tag/v1.5.19.RELEASE
*    Source File: RunCommand.java
*    
*    Copyrights:
*      copyright 2012-2017 the original author or authors
*    
*    Licenses:
*      Apache License 2.0
*      SPDXId: Apache-2.0
*    
*    Auto-attribution by Threatrix, Inc.
*    
*    ------ END LICENSE ATTRIBUTION ------
*/
private class SpringApplicationRunnerConfigurationAdapter
        extends OptionSetGroovyCompilerConfiguration
    implements SpringApplicationRunnerConfiguration {

    SpringApplicationRunnerConfigurationAdapter(OptionSet options, CompilerOptionHandler optionHandler,
                                                List<RepositoryConfiguration> repositoryConfiguration) {
        super(options, optionHandler, repositoryConfiguration);
    }

    @Override
    public GroovyCompilerScope getScope() {
        return GroovyCompilerScope.DEFAULT;
    }

    @Override
    public boolean isWatchForFileChanges() {
        return getOptions().has(RunOptionHandler.this.watchOption);
    }

    @Override
    public Level getLogLevel() {
        if (isQuiet()) {
            return Level.OFF;
        }
        if (getOptions().has(RunOptionHandler.this.verboseOption)) {
            return Level.FINEST;
        }
        return Level.INFO;
    }

    @Override
    public boolean isQuiet() {
        return getOptions().has(RunOptionHandler.this.quietOption);
    }
