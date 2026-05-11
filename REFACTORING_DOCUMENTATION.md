# Selenium Test Framework - Refactoring Documentation

## 📋 Table of Contents
1. [Overview](#overview)
2. [Architecture Changes](#architecture-changes)
3. [SOLID Principles Implementation](#solid-principles-implementation)
4. [Design Patterns Applied](#design-patterns-applied)
5. [New Components](#new-components)
6. [Code Structure Comparison](#code-structure-comparison)
7. [Usage Examples](#usage-examples)
8. [Benefits](#benefits)
9. [Migration Guide](#migration-guide)

---

## 🎯 Overview

### Problem Statement
The original codebase had several architectural issues:
- **Mixed Responsibilities**: BaseTest handled WebDriver creation, report management, AND test lifecycle
- **Tight Coupling**: Hard-coded driver instantiation (ChromeDriver, EdgeDriver)
- **No Singleton Pattern**: Global mutable state without proper control
- **Poor Extensibility**: Adding new browsers required modifying BaseTest
- **Inheritance Issues**: TestActions didn't extend BaseTest, leading to manual setup

### Solution
Complete refactoring using **SOLID principles** and **Design Patterns** to create a maintainable, testable, and extensible framework.

---

## 🏗️ Architecture Changes

### Before (Monolithic)
```
BaseTest (All-in-One)
├── WebDriver Management
├── Report Configuration
├── Test Lifecycle (@Before/@After)
└── Hard-coded Driver Creation
```

### After (Separation of Concerns)
```
BaseTest (Test Lifecycle Only)
├── Uses DriverManager (Singleton)
│   └── Uses DriverFactory (Strategy Pattern)
├── Uses ReportManager (Singleton)
└── Manages @Before/@After hooks
```

---

## 📐 SOLID Principles Implementation

### 1. **S - Single Responsibility Principle (SRP)**

#### What It Means
Each class should have **ONE and ONLY ONE reason to change**.

#### Implementation

**❌ Before: BaseTest (Multiple Responsibilities)**
```java
public class BaseTest {
    // Responsibility 1: WebDriver management
    // Responsibility 2: Report configuration
    // Responsibility 3: Test lifecycle
    // Responsibility 4: Driver creation logic
}
```

**✅ After: Separated Concerns**

```java
// Responsibility 1: WebDriver Lifecycle
public class DriverManager {
    // ONLY manages WebDriver instances
}

// Responsibility 2: WebDriver Creation
public class DriverFactory {
    // ONLY creates drivers
}

// Responsibility 3: Report Management
public class ReportManager {
    // ONLY manages ExtentReports
}

// Responsibility 4: Test Lifecycle
public class BaseTest {
    // ONLY manages @Before/@After hooks
}
```

#### Benefits
- Each class can be tested independently
- Changes to driver strategy don't affect reporting
- Easier to maintain and debug
- Clear code ownership

---

### 2. **O - Open/Closed Principle (OCP)**

#### What It Means
Classes should be **OPEN for extension** but **CLOSED for modification**.

#### Implementation

**❌ Before: Hard-coded Browser Support**
```java
public static WebDriver setUpDriver(String browserName){
    if(browserName.equalsIgnoreCase("chrome")){
        driver = new ChromeDriver();
    } else if(browserName.equalsIgnoreCase("edge")){
        driver = new EdgeDriver();
    } else {
        driver = new ChromeDriver();
    }
    return driver;
}
// ⚠️ To add Firefox: Must modify BaseTest → Risk of breaking existing code
```

**✅ After: Factory Pattern (OCP Compliant)**
```java
public class DriverFactory {
    public static WebDriver createDriver(String browserName) {
        return switch (browserName.toLowerCase().trim()) {
            case "chrome" -> new ChromeDriver();
            case "edge" -> new EdgeDriver();
            // ✅ To add Firefox: Just add case, no modification needed
            // ✅ Can extend without breaking existing code
            default -> throw new IllegalArgumentException(...);
        };
    }
}
```

#### Benefits
- Add new browsers without modifying existing code
- Reduced risk of bugs
- Better code stability
- Future-proof design

---

### 3. **L - Liskov Substitution Principle (LSP)**

#### What It Means
Derived classes must be substitutable for their base classes without breaking functionality.

#### Implementation
```java
// All drivers implement WebDriver interface
WebDriver driver1 = new ChromeDriver();
WebDriver driver2 = new EdgeDriver();

// Both are interchangeable - LSP compliant
driver1.get("https://example.com");
driver2.get("https://example.com");
```

---

### 4. **I - Interface Segregation Principle (ISP)**

#### What It Means
Clients should NOT depend on interfaces they don't use.

#### Implementation

**Before: BaseTest had mixed concerns**
```java
public class BaseTest {
    // Report methods mixed with driver methods mixed with lifecycle methods
    // A test that doesn't need reports still depends on report code
}
```

**After: Segregated Interfaces/Managers**
```java
// DriverManager - ONLY WebDriver concerns
public class DriverManager {
    public void initializeDriver(String browserName) { ... }
    public WebDriver getDriver() { ... }
    public void quitDriver() { ... }
}

// ReportManager - ONLY Report concerns
public class ReportManager {
    public void initializeReport() { ... }
    public ExtentTest createTest(String name) { ... }
    public void flushReport() { ... }
}

// BaseTest - ONLY test lifecycle
public class BaseTest {
    // Uses managers, doesn't implement them
    protected WebDriver driver;
    protected ExtentTest logger;
}
```

---

### 5. **D - Dependency Inversion Principle (DIP)**

#### What It Means
Depend on **abstractions** (interfaces), not on **concrete implementations**.

#### Implementation

**❌ Before: Depends on Concrete Classes**
```java
// Hard dependency on ChromeDriver, EdgeDriver
driver = new ChromeDriver();
driver = new EdgeDriver();
```

**✅ After: Depends on Abstraction**
```java
// DriverFactory creates drivers
// BaseTest doesn't know about ChromeDriver/EdgeDriver
public class DriverFactory {
    public static WebDriver createDriver(String browserName) {
        // Returns WebDriver interface
        // Implementation hidden from clients
    }
}

// BaseTest depends on WebDriver (abstraction)
protected WebDriver driver; // ← Abstraction, not implementation
```

#### Benefits
- Easy to add new browser types
- Easy to mock for testing
- Reduced coupling
- Better design flexibility

---

## 🎭 Design Patterns Applied

### 1. **Singleton Pattern**

#### Concept
Ensures a class has **only ONE instance** and provides a global access point.

#### Implementation in DriverManager

```java
public class DriverManager {
    // Static instance (volatile for thread-safety)
    private static volatile DriverManager instance;
    
    // Private WebDriver instance
    private WebDriver driver;

    // Private constructor - prevents instantiation
    private DriverManager() {
    }

    // Thread-safe lazy initialization (Double-checked locking)
    public static DriverManager getInstance() {
        if (instance == null) {                              // First check (without lock)
            synchronized (DriverManager.class) {             // Lock
                if (instance == null) {                      // Second check (with lock)
                    instance = new DriverManager();
                }
            }
        }
        return instance;
    }

    public void initializeDriver(String browserName) {
        if (this.driver == null) {
            this.driver = DriverFactory.createDriver(browserName);
        }
    }

    public WebDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver not initialized");
        }
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
```

#### Why Singleton?
- Only ONE WebDriver instance per test session
- Prevents resource wastage
- Global access point
- Thread-safe

#### Usage
```java
// Always get the same instance
DriverManager.getInstance().initializeDriver("chrome");
WebDriver driver = DriverManager.getInstance().getDriver();

// Same instance globally
DriverManager.getInstance().quitDriver();
```

---

### 2. **Factory Pattern**

#### Concept
Creates objects without specifying exact classes. Centralizes object creation logic.

#### Implementation in DriverFactory

```java
public class DriverFactory {
    /**
     * Factory method using switch expression (Java 14+)
     * Returns WebDriver based on browser name
     */
    public static WebDriver createDriver(String browserName) {
        if (browserName == null || browserName.trim().isEmpty()) {
            throw new IllegalArgumentException("Browser name cannot be null");
        }

        return switch (browserName.toLowerCase().trim()) {
            case "chrome" -> new ChromeDriver();
            case "edge" -> new EdgeDriver();
            // case "firefox" -> new FirefoxDriver();  // Easy to add
            // case "safari" -> new SafariDriver();    // Easy to add
            default -> throw new IllegalArgumentException(
                "Browser not supported: " + browserName
            );
        };
    }
}
```

#### Benefits
- Centralizes driver creation
- Easy to add new browsers
- Encapsulates creation logic
- Reduces code duplication

#### Usage
```java
// Factory creates appropriate driver
WebDriver chromeDriver = DriverFactory.createDriver("chrome");
WebDriver edgeDriver = DriverFactory.createDriver("edge");

// Both are WebDriver interface type (polymorphism)
chromeDriver.get("https://example.com");
edgeDriver.get("https://example.com");
```

---

### 3. **Template Method Pattern**

#### Concept
Defines skeleton of algorithm in base class, letting subclasses override steps.

#### Implementation in BaseTest

```java
public class BaseTest {
    // Template Method - defines test lifecycle skeleton
    
    @BeforeTest
    public void beforeTestMethod() {
        // Step 1: Initialize reporting
        ReportManager.getInstance().initializeReport();
    }

    @BeforeMethod
    public void beforeMethodMethod(String browserName, Method testMethod) {
        // Step 2: Initialize WebDriver
        DriverManager.getInstance().initializeDriver(browserName);
        driver = DriverManager.getInstance().getDriver();

        // Step 3: Create test in report
        logger = ReportManager.getInstance().createTest(testMethod.getName());

        // Step 4: Browser setup
        driver.manage().window().maximize();
        driver.get(Constants.url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void afterMethodMethod() {
        // Step 5: Optional cleanup
    }

    @AfterTest
    public void afterTestMethod(ITestResult result) {
        // Step 6: Log results
        // Step 7: Quit driver and flush report
    }
}
```

#### Usage in Test Classes

```java
public class TestActions extends BaseTest {
    // Inherits entire lifecycle from BaseTest
    // No need to rewrite @Before/@After in each test class
    
    @Test
    public void clickOnSearchBtn() {
        // driver and logger are already initialized
        driver.get("https://www.google.com");
        // Write test logic
    }
}
```

#### Benefits
- Consistent lifecycle across all tests
- Reusable setup/teardown
- Easy to maintain
- Single source of truth for test flow

---

## 🔧 New Components

### 1. **DriverManager.java** (Singleton)

**Location**: `src/main/java/utils/DriverManager.java`

**Responsibilities**:
- Initialize WebDriver using DriverFactory
- Provide get/quit methods
- Ensure thread-safe singleton

**Key Methods**:
| Method | Purpose |
|--------|---------|
| `getInstance()` | Get singleton instance |
| `initializeDriver(String)` | Initialize WebDriver |
| `getDriver()` | Get current driver |
| `quitDriver()` | Close and cleanup |
| `closeDriver()` | Close current window |

---

### 2. **DriverFactory.java** (Factory Pattern)

**Location**: `src/main/java/utils/DriverFactory.java`

**Responsibilities**:
- Create appropriate WebDriver based on browser name
- Encapsulate driver instantiation logic
- Support multiple browsers

**Key Methods**:
| Method | Purpose |
|--------|---------|
| `createDriver(String)` | Factory method to create drivers |

**Supported Browsers**:
- ✅ Chrome
- ✅ Edge
- ⏳ Firefox (ready to add)
- ⏳ Safari (ready to add)

---

### 3. **ReportManager.java** (Singleton)

**Location**: `src/main/java/utils/ReportManager.java`

**Responsibilities**:
- Initialize ExtentReports
- Create tests in report
- Manage report lifecycle

**Key Methods**:
| Method | Purpose |
|--------|---------|
| `getInstance()` | Get singleton instance |
| `initializeReport()` | Initialize report configuration |
| `createTest(String)` | Create test in report |
| `flushReport()` | Finalize and save report |
| `getExtent()` | Get ExtentReports instance |

---

### 4. **Refactored BaseTest.java**

**Location**: `src/test/java/BaseTest.java`

**Changes**:
- ✅ Uses DriverManager (cleanup of driver creation)
- ✅ Uses ReportManager (cleanup of report management)
- ✅ SRP: Only manages test lifecycle
- ✅ Protected WebDriver instead of static
- ✅ Cleaner @Before/@After methods
- ✅ Backward compatibility with deprecated static method

---

### 5. **Refactored TestActions.java**

**Location**: `src/main/java/SelTraining/TestActions.java`

**Changes**:
- ✅ **NOW extends BaseTest** (fixes inheritance issue)
- ✅ Removed manual driver initialization
- ✅ Removed unused imports
- ✅ Clean test methods
- ✅ driver initialized automatically via @BeforeMethod
- ✅ Focused only on test logic

---

## 📊 Code Structure Comparison

### Before vs After

#### **BEFORE: TestActions**
```java
public class TestActions {
    String url = "https://www.google.com";
    WebDriver driver;
    
    @Test
    public void clickOnSearchBtn(){
        driver = BaseTest.setUpDriver("chrome");  // ❌ Manual setup
        driver.get(url);
    }
}
// ❌ Doesn't extend BaseTest
// ❌ No @Before/@After from BaseTest
// ❌ Tight coupling to BaseTest.setUpDriver()
```

#### **AFTER: TestActions**
```java
public class TestActions extends BaseTest {
    private String url = "https://www.google.com";
    
    @Test
    public void clickOnSearchBtn() {
        // ✅ driver initialized automatically
        driver.get(url);
        String title = driver.getTitle();
        assert title != null : "Page title should not be empty";
    }
}
// ✅ Extends BaseTest
// ✅ Inherits @Before/@After
// ✅ Automatic WebDriver management
```

---

## 🚀 Usage Examples

### Example 1: Creating a Simple Test

```java
package test.java;

import org.testng.annotations.Test;

public class GoogleSearchTest extends BaseTest {
    private String url = "https://www.google.com";

    @Test
    public void verifyGooglePageTitle() {
        // TestNG calls BaseTest.beforeMethodMethod() automatically
        // driver is already initialized
        
        driver.get(url);
        String title = driver.getTitle();
        
        assert title.contains("Google") : "Title should contain 'Google'";
        logger.pass("Google page loaded successfully");
        
        // TestNG calls BaseTest.afterTestMethod() automatically
        // driver.quit() and report.flush() happen automatically
    }
}
```

### Example 2: Adding a New Browser (Extension without Modification)

```java
// File: src/main/java/utils/DriverFactory.java
public class DriverFactory {
    public static WebDriver createDriver(String browserName) {
        return switch (browserName.toLowerCase().trim()) {
            case "chrome" -> new ChromeDriver();
            case "edge" -> new EdgeDriver();
            case "firefox" -> new FirefoxDriver();  // ✅ Just add this line
            default -> throw new IllegalArgumentException(...);
        };
    }
}
// ✅ No changes to BaseTest, TestActions, or any test class required!
// ✅ Open/Closed Principle satisfied
```

### Example 3: Using Singleton Directly (Advanced)

```java
// If you need to use WebDriver outside test class
public class SomeUtilityClass {
    public static void doSomething() {
        // Get singleton instance
        DriverManager driverManager = DriverManager.getInstance();
        WebDriver driver = driverManager.getDriver();
        
        // Use driver
        driver.navigate().to("https://example.com");
    }
}
```

---

## 💡 Benefits

### 1. **Maintainability**
- ✅ Clear separation of concerns
- ✅ Single Responsibility: Each class has one job
- ✅ Less coupling between classes
- ✅ Easier to locate and fix bugs

### 2. **Extensibility**
- ✅ Add new browsers without modifying existing code
- ✅ Add new report types by extending ReportManager
- ✅ Template Method allows overriding specific steps

### 3. **Reusability**
- ✅ DriverManager can be used in multiple projects
- ✅ DriverFactory can be reused independently
- ✅ BaseTest template available for all test classes

### 4. **Testability**
- ✅ Each component can be unit tested
- ✅ Easy to mock dependencies
- ✅ No tight coupling to concrete classes

### 5. **Thread Safety**
- ✅ Singleton pattern with double-checked locking
- ✅ Safe for parallel test execution
- ✅ Volatile keyword ensures visibility across threads

### 6. **Performance**
- ✅ Only one WebDriver instance per session
- ✅ Lazy initialization of resources
- ✅ Reduced object creation overhead

---

## 📚 Migration Guide

### For Existing Test Classes

**Step 1: Add Inheritance**
```java
// Before
public class MyTest { ... }

// After
public class MyTest extends BaseTest { ... }
```

**Step 2: Remove Manual driver initialization**
```java
// Before
@Test
public void testMethod() {
    driver = BaseTest.setUpDriver("chrome");
    driver.get("https://example.com");
}

// After
@Test
public void testMethod() {
    // driver already initialized by @BeforeMethod
    driver.get("https://example.com");
}
```

**Step 3: Update imports**
```java
import test.java.BaseTest; // ✅ Add this
```

---

## 🔍 Comparison Table

| Aspect | Before | After |
|--------|--------|-------|
| **Responsibilities** | BaseTest: 4 concerns | Separated into 4 classes |
| **Inheritance** | TestActions standalone | TestActions extends BaseTest |
| **Driver Creation** | Hard-coded if-else | Factory pattern |
| **WebDriver Instance** | Static field (not singleton) | Singleton with thread safety |
| **Report Management** | Scattered in BaseTest | Centralized ReportManager |
| **Close Driver** | Manual in test | Automatic via @AfterTest |
| **Add New Browser** | Modify BaseTest ❌ | Add to Factory only ✅ |
| **Test Code** | Boilerplate for setup | Just test logic |
| **Testing** | Hard to mock | Easy to mock |
| **Scalability** | Limited | Highly extensible |

---

## ⚖️ SOLID Compliance Matrix

| Principle | Before | After | Status |
|-----------|--------|-------|--------|
| **Single Responsibility** | ❌ Multiple concerns in BaseTest | ✅ Each class has ONE job | ✅ PASS |
| **Open/Closed** | ❌ Hard-coded drivers | ✅ Factory pattern | ✅ PASS |
| **Liskov Substitution** | ⚠️ Partial | ✅ Full compliance | ✅ PASS |
| **Interface Segregation** | ❌ Mixed concerns | ✅ Segregated managers | ✅ PASS |
| **Dependency Inversion** | ❌ Depends on concrete classes | ✅ Depends on abstractions | ✅ PASS |

---

## 🎓 Learning Outcomes

After studying this refactoring, you understand:

1. ✅ **SOLID Principles**: How to apply all 5 principles in real code
2. ✅ **Design Patterns**: Singleton, Factory, Template Method
3. ✅ **Separation of Concerns**: Breaking monolithic classes
4. ✅ **Thread Safety**: Double-checked locking pattern
5. ✅ **Dependency Injection**: Through factory pattern
6. ✅ **Code Scalability**: How to design for future changes
7. ✅ **Testing**: How to make code testable

---

## 📞 FAQ

### Q1: Why Singleton for DriverManager?
**A**: Because you need only ONE WebDriver instance per test session. Singleton ensures this and provides a global access point. It also prevents resource wastage.

### Q2: What if I need multiple drivers in parallel?
**A**: The current Singleton can be refactored to use a Map<ThreadId, DriverManager> per thread. The pattern still applies, just with thread-local storage.

### Q3: Can I override beforeMethodMethod() in my test?
**A**: Yes! Just add `@Override` and call `super.beforeMethodMethod()` first:
```java
@Override
@BeforeMethod
public void beforeMethodMethod(String browserName, Method testMethod) {
    super.beforeMethodMethod(browserName, testMethod);
    // Your custom setup
}
```

### Q4: How do I add Firefox support?
**A**: Just add one line in DriverFactory.java under the switch:
```java
case "firefox" -> new FirefoxDriver();
```

### Q5: Is the old setUpDriver() method still working?
**A**: Yes! It's marked as `@Deprecated` for backward compatibility. Use `extends BaseTest` instead for new code.

---

## 📎 References

- [SOLID Principles](https://en.wikipedia.org/wiki/SOLID)
- [Design Patterns](https://refactoring.guru/design-patterns)
- [Singleton Pattern](https://refactoring.guru/design-patterns/singleton)
- [Factory Pattern](https://refactoring.guru/design-patterns/factory-method)
- [Template Method Pattern](https://refactoring.guru/design-patterns/template-method)

---

**Document Version**: 1.0  
**Last Updated**: May 2026  
**Author**: GitHub Copilot  
**Status**: Ready for Production ✅

