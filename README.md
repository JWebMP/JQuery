# JWebMP jQuery Plugin

[![Maven Central](https://img.shields.io/maven-central/v/com.jwebmp.plugins/jquery)](https://central.sonatype.com/artifact/com.jwebmp.plugins/jquery)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue)](https://www.apache.org/licenses/LICENSE-2.0)

![Java 25+](https://img.shields.io/badge/Java-25%2B-green)
![Modular](https://img.shields.io/badge/Modular-JPMS-green)
![Angular](https://img.shields.io/badge/Angular-21-DD0031?logo=angular)
![TypeScript](https://img.shields.io/badge/TypeScript-5-3178C6?logo=typescript)

<!-- Tech icons row -->
![jQuery](https://img.shields.io/badge/jQuery-4.0.0-0769AD?logo=jquery)
![JWebMP](https://img.shields.io/badge/JWebMP-2.0-0A7)

jQuery 4 integration for JWebMP with Angular 21. Provides jQuery and jQuery Migrate as global scripts for plugins and components that depend on jQuery APIs.

Built on [jQuery 4](https://jquery.com/) · [jQuery Migrate](https://github.com/jquery/jquery-migrate) · [JWebMP Core](https://jwebmp.com/) · JPMS module `com.jwebmp.plugins.jquery` · Java 25+

**Version: 4.0.0** — jQuery 4 with jQuery Migrate 4.0.2 for backward compatibility.

## Installation

```xml
<dependency>
  <groupId>com.jwebmp.plugins</groupId>
  <artifactId>jquery</artifactId>
  <version>2.0.3-SNAPSHOT</version>
</dependency>
```

<details>
<summary>Gradle (Kotlin DSL)</summary>

```kotlin
implementation("com.jwebmp.plugins:jquery:2.0.0-SNAPSHOT")
```
</details>

### NPM Dependencies

The plugin automatically includes jQuery dependencies:

```json
{
  "dependencies": {
    "jquery": "^4.0.0",
    "jquery-migrate": "^4.0.2"
  },
  "devDependencies": {
    "@types/jquery": "*"
  }
}
```

## Features

- **jQuery 4.0.0** — Latest major release with modern browser support
- **jQuery Migrate 4.0.2** — Backward compatibility layer for legacy jQuery plugins
- **TypeScript Types** — Full `@types/jquery` for IDE autocomplete and type safety
- **Automatic Script Loading** — jQuery and Migrate scripts auto-injected via Angular build
- **Zero Configuration** — Auto-registered via ServiceLoader SPI
- **JPMS Module** — Proper Java module with explicit dependencies
- **Angular Integration** — Scripts loaded as global scripts in the Angular build

## Quick Start

### Prerequisites

- **Java 25 LTS** (required)
- **Maven 3.8+**
- **Node.js 18+** (for frontend builds)
- **Angular 21+** (auto-integrated via JWebMP)

### Basic Usage

jQuery is automatically available as a global script when this plugin is on the classpath. No additional configuration is required.

```java
// module-info.java
module com.myapp {
    requires com.jwebmp.plugins.jquery;
}
```

jQuery will be loaded before any dependent plugins, ensuring `$` and `jQuery` are available globally in the browser.

### Using with Other Plugins

Many JWebMP plugins depend on jQuery. Simply add this dependency to your project and jQuery will be available:

```java
// jQuery is automatically loaded as a global script
// Other plugins that need jQuery can depend on this module
@NgScript(value = "node_modules/jquery/dist/jquery.js", sortOrder = 1)
@NgScript(value = "node_modules/jquery-migrate/dist/jquery-migrate.js", sortOrder = 2)
```

---

## Architecture

### Technology Stack

- **Backend**: Java 25 LTS, Maven, GuicedEE (IoC)
- **Frontend**: Angular 21, TypeScript, jQuery 4.0.0
- **Integration**: JWebMP Page Configurators, ServiceLoader SPI
- **Module System**: JPMS with explicit dependencies

### Module Structure

```
src/main/java/com/jwebmp/plugins/jquery/
├── JQueryPageConfigurator.java    # Auto-configuration and script injection
└── JQueryInclusionModule.java     # Guice module scan inclusion
```

### jQuery 4 Key Changes

jQuery 4.0.0 is a major update from the 3.x series:

- **Dropped IE support** — Modern browsers only
- **Removed deprecated APIs** — Cleaner, smaller API surface
- **ES module support** — Native ES module imports
- **FormData support** — Native FormData in AJAX
- **Trusted Types** — Content Security Policy compatibility
- **Smaller bundle** — Reduced file size with removed legacy code

> **Note**: jQuery Migrate 4.0.2 is included to help transition plugins that still use removed jQuery 3.x APIs.

---

## Configuration

### Auto-Configuration via PageConfigurator

The plugin is automatically configured when present on the classpath:

```java
@TsDependency(value = "jquery", version = "^4.0.0")
@TsDependency(value = "jquery-migrate", version = "^4.0.2")
@TsDevDependency(value = "@types/jquery", version = "*")
@NgScript(value = "node_modules/jquery/dist/jquery.js", sortOrder = 1)
@NgScript(value = "node_modules/jquery-migrate/dist/jquery-migrate.js", sortOrder = 2)
public class JQueryPageConfigurator implements IPageConfigurator {
    // Auto-loaded via ServiceLoader SPI
}
```

### Script Load Order

| Script | Sort Order | Purpose |
|--------|-----------|---------|
| `jquery.js` | 1 | Core jQuery library |
| `jquery-migrate.js` | 2 | Backward compatibility shim |

---

## Module Graph

```
com.jwebmp.plugins.jquery
 ├── com.jwebmp.core.base.angular.client  (Angular TypeScript client)
 └── com.jwebmp.client                     (JWebMP client contracts)
```

### Exported Packages

- `com.jwebmp.plugins.jquery` — Page configurator and module inclusion

---

## Testing

### Run Unit Tests

```bash
mvn clean test
```

---

## Documentation

### Core Resources

- **[jQuery 4 Docs](https://api.jquery.com/)** — Official jQuery API documentation
- **[jQuery Migrate](https://github.com/jquery/jquery-migrate)** — Migration helper plugin
- **[JWebMP Home](https://jwebmp.com/)** — JWebMP framework documentation

### Project Files

| File | Purpose |
|------|---------|
| `JQueryPageConfigurator.java` | Auto-configuration and script loading |
| `JQueryInclusionModule.java` | Guice module scan inclusion |
| `pom.xml` | Maven build configuration |
| `module-info.java` | JPMS module descriptor |

---

## Security

This project takes security seriously.

**Key Security Features**:
- jQuery loaded from local NPM packages (no CDN)
- jQuery 4 supports Trusted Types for CSP compatibility
- OWASP Dependency-Check in CI/CD
- GitHub Dependabot enabled
- No external network calls at runtime

---

## Contributing

Contributions are welcome! Please follow these guidelines:

1. **Fork** the repository
2. **Create a feature branch** (`git checkout -b feature/my-feature`)
3. **Commit with clear messages** (`git commit -m "feat: update jQuery version"`)
4. **Push to your fork** (`git push origin feature/my-feature`)
5. **Open a Pull Request**

### Code Standards

- **Java**: Follow JWebMP conventions (CRTP fluent API, proper null safety)
- **Tests**: JUnit 5
- **Formatting**: Maven Spotless plugin enforced
- **Documentation**: Update README for new features

---

## Project Status

| Aspect | Status |
|--------|--------|
| **Version** | 4.0.0 / 2.0.0-SNAPSHOT |
| **jQuery** | 4.0.0 |
| **jQuery Migrate** | 4.0.2 |
| **Java** | 25 LTS (required) |
| **Build** | Passing |
| **License** | Apache 2.0 |
| **Maintenance** | Active |

---

## Links

- **GitHub Repository**: https://github.com/JWebMP/JWebMP
- **Maven Central**: https://mvnrepository.com/artifact/com.jwebmp.plugins/jquery
- **jQuery Home**: https://jquery.com/
- **jQuery API**: https://api.jquery.com/
- **jQuery Migrate**: https://github.com/jquery/jquery-migrate
- **JWebMP Home**: https://jwebmp.com/

---

## License

Licensed under the [Apache License 2.0](LICENSE).

```
Copyright 2025 JWebMP Contributors

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

---

## Acknowledgments

- **[jQuery Foundation](https://jquery.com/)** — The ubiquitous JavaScript library
- **[JWebMP](https://jwebmp.com/)** — Server-driven web framework
- **[Angular](https://angular.dev/)** — Modern web framework

---

**Made with JWebMP**
