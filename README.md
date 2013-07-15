# JSR 303 Bean Validator to jQuery Validation Bridge
## Why I make this library
I work with spring, JPA, Bean Validation and jquery. 

I wrote validation rule twice every time. Java(Bean Validation) and Javascript(jQuery Validation)

If I change validation rule, write twice. Sometimes I forgot to modify another side, Application go wrong.

I hate this. 

So I make this library * ValidationBridge *.



## Setup 
ValidationBridge need some dependencies. 

In ``build.gradle``, dependencies is described.

```
def SLF4J_VERSION='1.7.5' 
def SPRING_RELEASE_VERSION='3.2.3.RELEASE'

dependencies {
    compile (
        [group: 'org.hibernate', name: 'hibernate-validator', version:'4.3.1.Final'],
        [group: 'org.slf4j', name: 'slf4j-api', version:SLF4J_VERSION],
        [group: 'org.slf4j', name: 'jcl-over-slf4j', version:SLF4J_VERSION],
        [group: 'org.slf4j', name: 'log4j-over-slf4j', version:SLF4J_VERSION],
        [group: 'ch.qos.logback', name: 'logback-core', version:'1.0.13'],
        [group: 'ch.qos.logback', name: 'logback-classic', version:'1.0.13'],
        [group: 'org.projectlombok', name: 'lombok', version:'0.11.8'],
        [group: 'org.apache.commons', name: 'commons-lang3', version:'3.1'],        
        [group: 'org.springframework', name: 'spring-context', version: SPRING_RELEASE_VERSION],
        [group: 'org.springframework', name: 'spring-context-support', version: SPRING_RELEASE_VERSION],
        [group: 'org.springframework', name: 'spring-core', version: SPRING_RELEASE_VERSION],
        [group: 'org.springframework', name: 'spring-expression', version: SPRING_RELEASE_VERSION],
        [group: 'org.springframework', name: 'spring-webmvc', version: SPRING_RELEASE_VERSION],
        [group: 'org.springframework', name: 'spring-test', version: SPRING_RELEASE_VERSION],
    )
    
    provided(
        [group: 'javax.servlet', name: 'servlet-api', version:'2.5'],
        [group: 'javax.servlet', name: 'jsp-api', version:'2.0'],
        [group: 'javax.servlet', name: 'jstl', version:'1.2'],
    )
    
}
``` 


ValidationBridge is JSTL Tag based on Spring.  Especially 3 bean is needed. 

It is LocalValidatorFactoryBean, and MessageSource. Next is sample spring configurations. 

``` 
@Configuration
public class ApplicationConfig {
    @Bean
    public LocalValidatorFactoryBean localValidator() {
        LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
        factoryBean.setValidationMessageSource(messageSource());
        return factoryBean;
    }
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource 
            = new ReloadableResourceBundleMessageSource();
        messageSource.setCacheSeconds(5);
        messageSource.setBasenames("classpath:config/validationMessage");
        return messageSource;
    }
}

```



