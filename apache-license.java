private class SpringApplicationRunnerConfigurationAdapter extends OptionSetGroovyCompilerConfiguration
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
