package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the `libs` extension.
*/
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final JacksonLibraryAccessors laccForJacksonLibraryAccessors = new JacksonLibraryAccessors(owner);
    private final JunitLibraryAccessors laccForJunitLibraryAccessors = new JunitLibraryAccessors(owner);
    private final LambdaLibraryAccessors laccForLambdaLibraryAccessors = new LambdaLibraryAccessors(owner);
    private final Log4jLibraryAccessors laccForLog4jLibraryAccessors = new Log4jLibraryAccessors(owner);
    private final NvaLibraryAccessors laccForNvaLibraryAccessors = new NvaLibraryAccessors(owner);
    private final Slf4jLibraryAccessors laccForSlf4jLibraryAccessors = new Slf4jLibraryAccessors(owner);
    private final UrlLibraryAccessors laccForUrlLibraryAccessors = new UrlLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(providers, config);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers) {
        super(config, providers);
    }

        /**
         * Creates a dependency provider for assertj (org.assertj:assertj-core)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getAssertj() { return create("assertj"); }

        /**
         * Creates a dependency provider for kinesis (software.amazon.awssdk:kinesis)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getKinesis() { return create("kinesis"); }

        /**
         * Creates a dependency provider for mockito (org.mockito:mockito-core)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getMockito() { return create("mockito"); }

        /**
         * Creates a dependency provider for testutils (com.github.bibsysdev:nvatestutils)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getTestutils() { return create("testutils"); }

    /**
     * Returns the group of libraries at jackson
     */
    public JacksonLibraryAccessors getJackson() { return laccForJacksonLibraryAccessors; }

    /**
     * Returns the group of libraries at junit
     */
    public JunitLibraryAccessors getJunit() { return laccForJunitLibraryAccessors; }

    /**
     * Returns the group of libraries at lambda
     */
    public LambdaLibraryAccessors getLambda() { return laccForLambdaLibraryAccessors; }

    /**
     * Returns the group of libraries at log4j
     */
    public Log4jLibraryAccessors getLog4j() { return laccForLog4jLibraryAccessors; }

    /**
     * Returns the group of libraries at nva
     */
    public NvaLibraryAccessors getNva() { return laccForNvaLibraryAccessors; }

    /**
     * Returns the group of libraries at slf4j
     */
    public Slf4jLibraryAccessors getSlf4j() { return laccForSlf4jLibraryAccessors; }

    /**
     * Returns the group of libraries at url
     */
    public UrlLibraryAccessors getUrl() { return laccForUrlLibraryAccessors; }

    /**
     * Returns the group of versions at versions
     */
    public VersionAccessors getVersions() { return vaccForVersionAccessors; }

    /**
     * Returns the group of bundles at bundles
     */
    public BundleAccessors getBundles() { return baccForBundleAccessors; }

    /**
     * Returns the group of plugins at plugins
     */
    public PluginAccessors getPlugins() { return paccForPluginAccessors; }

    public static class JacksonLibraryAccessors extends SubDependencyFactory {

        public JacksonLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for annotations (com.fasterxml.jackson.core:jackson-annotations)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getAnnotations() { return create("jackson.annotations"); }

            /**
             * Creates a dependency provider for core (com.fasterxml.jackson.core:jackson-core)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() { return create("jackson.core"); }

            /**
             * Creates a dependency provider for databind (com.fasterxml.jackson.core:jackson-databind)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getDatabind() { return create("jackson.databind"); }

    }

    public static class JunitLibraryAccessors extends SubDependencyFactory {

        public JunitLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for api (org.junit.jupiter:junit-jupiter-api)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getApi() { return create("junit.api"); }

            /**
             * Creates a dependency provider for engine (org.junit.jupiter:junit-jupiter-engine)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getEngine() { return create("junit.engine"); }

            /**
             * Creates a dependency provider for params (org.junit.jupiter:junit-jupiter-params)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getParams() { return create("junit.params"); }

    }

    public static class LambdaLibraryAccessors extends SubDependencyFactory {

        public LambdaLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (com.amazonaws:aws-lambda-java-core)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() { return create("lambda.core"); }

            /**
             * Creates a dependency provider for log4j2 (com.amazonaws:aws-lambda-java-log4j2)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getLog4j2() { return create("lambda.log4j2"); }

    }

    public static class Log4jLibraryAccessors extends SubDependencyFactory {

        public Log4jLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (org.apache.logging.log4j:log4j-core)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() { return create("log4j.core"); }

    }

    public static class NvaLibraryAccessors extends SubDependencyFactory {

        public NvaLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (com.github.bibsysdev:core)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() { return create("nva.core"); }

            /**
             * Creates a dependency provider for json (com.github.bibsysdev:json)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getJson() { return create("nva.json"); }

    }

    public static class Slf4jLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public Slf4jLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for slf4j (org.slf4j:slf4j-api)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() { return create("slf4j"); }

            /**
             * Creates a dependency provider for binding (org.apache.logging.log4j:log4j-slf4j18-impl)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getBinding() { return create("slf4j.binding"); }

    }

    public static class UrlLibraryAccessors extends SubDependencyFactory {
        private final UrlConnectionLibraryAccessors laccForUrlConnectionLibraryAccessors = new UrlConnectionLibraryAccessors(owner);

        public UrlLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at url.connection
         */
        public UrlConnectionLibraryAccessors getConnection() { return laccForUrlConnectionLibraryAccessors; }

    }

    public static class UrlConnectionLibraryAccessors extends SubDependencyFactory {

        public UrlConnectionLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for client (software.amazon.awssdk:url-connection-client)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getClient() { return create("url.connection.client"); }

    }

    public static class VersionAccessors extends VersionFactory  {

        private final LambdaVersionAccessors vaccForLambdaVersionAccessors = new LambdaVersionAccessors(providers, config);
        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: assertj ({strictly 3.23.1})
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getAssertj() { return getVersion("assertj"); }

            /**
             * Returns the version associated to this alias: cdk ({strictly 2.55.1})
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getCdk() { return getVersion("cdk"); }

            /**
             * Returns the version associated to this alias: jackson ({strictly 2.14.1})
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getJackson() { return getVersion("jackson"); }

            /**
             * Returns the version associated to this alias: junit ({strictly 5.8.2})
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getJunit() { return getVersion("junit"); }

            /**
             * Returns the version associated to this alias: log4j ({strictly 2.17.2})
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getLog4j() { return getVersion("log4j"); }

            /**
             * Returns the version associated to this alias: log4jslf4j ({strictly 2.17.1})
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getLog4jslf4j() { return getVersion("log4jslf4j"); }

            /**
             * Returns the version associated to this alias: mockito ({strictly 4.10.0})
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getMockito() { return getVersion("mockito"); }

            /**
             * Returns the version associated to this alias: nva ({strictly 1.26.0})
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getNva() { return getVersion("nva"); }

            /**
             * Returns the version associated to this alias: sdk2 ({strictly 2.17.191})
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getSdk2() { return getVersion("sdk2"); }

            /**
             * Returns the version associated to this alias: slf4j ({strictly 2.0.6})
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getSlf4j() { return getVersion("slf4j"); }

        /**
         * Returns the group of versions at versions.lambda
         */
        public LambdaVersionAccessors getLambda() { return vaccForLambdaVersionAccessors; }

    }

    public static class LambdaVersionAccessors extends VersionFactory  implements VersionNotationSupplier {

        public LambdaVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the version associated to this alias: lambda ({strictly 1.2.2})
         * If the version is a rich version and that its not expressible as a
         * single version string, then an empty string is returned.
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> asProvider() { return getVersion("lambda"); }

            /**
             * Returns the version associated to this alias: lambda.log4j2 ({strictly 1.5.1})
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getLog4j2() { return getVersion("lambda.log4j2"); }

    }

    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a dependency bundle provider for json which is an aggregate for the following dependencies:
             * <ul>
             *    <li>com.fasterxml.jackson.core:jackson-core</li>
             *    <li>com.fasterxml.jackson.core:jackson-databind</li>
             *    <li>com.fasterxml.jackson.core:jackson-annotations</li>
             * </ul>
             * This bundle was declared in catalog libs.versions.toml
             */
            public Provider<ExternalModuleDependencyBundle> getJson() { return createBundle("json"); }

            /**
             * Creates a dependency bundle provider for logging which is an aggregate for the following dependencies:
             * <ul>
             *    <li>org.apache.logging.log4j:log4j-core</li>
             *    <li>org.apache.logging.log4j:log4j-slf4j18-impl</li>
             *    <li>org.slf4j:slf4j-api</li>
             *    <li>com.amazonaws:aws-lambda-java-log4j2</li>
             * </ul>
             * This bundle was declared in catalog libs.versions.toml
             */
            public Provider<ExternalModuleDependencyBundle> getLogging() { return createBundle("logging"); }

            /**
             * Creates a dependency bundle provider for testing which is an aggregate for the following dependencies:
             * <ul>
             *    <li>org.junit.jupiter:junit-jupiter-api</li>
             *    <li>org.junit.jupiter:junit-jupiter-engine</li>
             *    <li>org.junit.jupiter:junit-jupiter-params</li>
             *    <li>org.assertj:assertj-core</li>
             *    <li>com.github.bibsysdev:nvatestutils</li>
             *    <li>org.mockito:mockito-core</li>
             * </ul>
             * This bundle was declared in catalog libs.versions.toml
             */
            public Provider<ExternalModuleDependencyBundle> getTesting() { return createBundle("testing"); }

    }

    public static class PluginAccessors extends PluginFactory {

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

    }

}
