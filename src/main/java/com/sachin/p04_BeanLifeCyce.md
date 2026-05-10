# Spring Bean Lifecycle Explained Simply

Understanding the Spring Bean Lifecycle means understanding how Spring manages objects step-by-step internally.

Think of Spring like a factory manager that:
- creates objects
- injects dependencies
- prepares them
- gives them for usage
- destroys them safely when application stops

---

# Complete Spring Bean Lifecycle

---

# 1. Bean Definition Loading

Spring first scans classes using annotations like:

- `@Component`
- `@Service`
- `@Repository`
- `@Controller`

Then Spring creates a **Bean Blueprint** internally.

## Example

```java
@Service
public class UserService {

}
```

Spring now knows:
> "Okay, I need to create an object of UserService."

---

# 2. Bean Instantiation (Object Creation)

Now Spring creates the actual object.

This is where:
- Constructor Injection happens
- `new Object()` internally happens

---

## Constructor Injection Example

```java
@Service
public class UserService {

    private final EmailService emailService;

    public UserService(EmailService emailService) {
        this.emailService = emailService;

        System.out.println("Constructor Called");
    }
}
```

## Important Point

Spring must first find `EmailService`
before creating `UserService`.

That is why Constructor Injection is best for:
- required dependencies
- immutable design
- `final` fields

---

# 3. Populate Properties (Dependency Injection Phase)

After object creation,
Spring fills remaining dependencies.

This is where:
- Field Injection happens
- Setter Injection happens

---

# Field Injection Example

```java
@Service
public class UserService {

    @Autowired
    private EmailService emailService;
}
```

Spring uses Reflection internally
to inject dependency into private field.

---

# Setter Injection Example

```java
@Service
public class UserService {

    private EmailService emailService;

    @Autowired
    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }
}
```

---

# Important Note

Constructor runs FIRST.

So inside constructor:

```java
System.out.println(emailService);
```

may print:

```text
null
```

for field/setter injection.

Because those injections happen AFTER constructor.

---

# 4. BeanNameAware / BeanFactoryAware

Spring can tell bean:
- its own name
- its factory/container details

Mostly used internally.

---

# Example

```java
@Component
public class MyBean implements BeanNameAware {

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean Name: " + name);
    }
}
```

Output:

```text
Bean Name: myBean
```

---

# 5. Pre-Initialization Phase

Spring checks:
- should bean be modified?
- should proxy be created?
- should additional logic apply?

This happens using:

- `BeanPostProcessor`

Used heavily in:
- AOP
- Security
- Transactions
- Logging

---

# Example

```java
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {

        System.out.println("Before Initialization: " + beanName);

        return bean;
    }
}
```

---

# 6. Initialization Phase

Now bean is almost ready.

This is where:
- `@PostConstruct`
- `afterPropertiesSet()`

run.

Now all dependencies are available.

---

# @PostConstruct Example

```java
@Service
public class UserService {

    @Autowired
    private EmailService emailService;

    @PostConstruct
    public void init() {

        System.out.println(emailService);

        System.out.println("Bean Initialized");
    }
}
```

Now `emailService` will NOT be null.

---

# InitializingBean Example

```java
@Service
public class UserService implements InitializingBean {

    @Override
    public void afterPropertiesSet() {

        System.out.println("afterPropertiesSet called");
    }
}
```

---

# 7. Post Initialization Phase

Now Spring may:
- wrap bean with proxy
- apply AOP
- apply `@Transactional`
- apply security logic

---

# Example

```java
@Transactional
@Service
public class PaymentService {

}
```

Spring creates a Proxy Object around this bean.

---

# 8. Bean Ready To Use

Now bean is fully ready.

Spring stores it inside:
- Application Context
- IoC Container

Whenever needed:

```java
@Autowired
private UserService userService;
```

Spring gives the ready-made bean.

---

# 9. Bean Destruction Phase

When application stops,
Spring destroys beans safely.

Used for:
- closing DB connections
- releasing resources
- stopping threads

---

# @PreDestroy Example

```java
@Service
public class UserService {

    @PreDestroy
    public void cleanup() {

        System.out.println("Bean Destroyed");
    }
}
```

---

# Full Lifecycle Flow

```text
1. Bean Definition Loading
2. Bean Instantiation
3. Dependency Injection
4. Aware Interfaces
5. Pre Initialization
6. Initialization
7. Post Initialization
8. Ready To Use
9. Destruction
```

---

# Simple Summary Table

| Step | What Happens | Main Feature |
|---|---|---|
| 1 | Spring scans classes | Bean Definition |
| 2 | Object created | Constructor Injection |
| 3 | Dependencies injected | Field / Setter Injection |
| 4 | Bean gets metadata | Aware Interfaces |
| 5 | Spring modifies bean if needed | BeanPostProcessor |
| 6 | Setup methods run | `@PostConstruct` |
| 7 | Proxy creation happens | AOP / Transactions |
| 8 | Bean ready for use | Application Context |
| 9 | Cleanup before shutdown | `@PreDestroy` |

---

# Best Practice Recommendation

## Use Constructor Injection For:
- Required dependencies
- `final` fields
- Better testing
- Immutable design

---

## Use Setter Injection For:
- Optional dependencies

---

## Avoid Field Injection Because:
- Hard to test
- Cannot use `final`
- Hidden dependencies
- Reflection-based injection

---

# Golden Rule

```text
Required Dependency -> Constructor Injection

Optional Dependency -> Setter Injection

Avoid Field Injection in production-grade applications
```

---

# Real Enterprise Insight

Most modern enterprise Spring Boot projects prefer:

- Constructor Injection
- Lombok `@RequiredArgsConstructor`
- Immutable services

Example:

```java
@Service
@RequiredArgsConstructor
public class UserService {

    private final EmailService emailService;
}
```

This is considered clean and professional Spring code.
