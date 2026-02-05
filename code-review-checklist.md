# Code Review Checklist

**Reviewer Name:** Alexander Rafalski
**Date:** 2026-02-04
**Branch:** Review

## Instructions
Review ALL source files (in main not test) in the project and identify defects using the categories below. Log at least 5 defects total:
- At least 1 from CS (Coding Standards)
- At least 1 from CG (Code Quality/General)
- At least 1 from FD (Functional Defects)
- Remaining can be from any category

## Review Categories

- **CS**: Coding Standards (naming conventions, formatting, style violations)
- **CG**: Code Quality/General (design issues, code smells, maintainability)
- **FD**: Functional Defects (logic errors, incorrect behavior, bugs)
- **MD**: Miscellaneous (documentation, comments, other issues)

## Defect Log

| Defect ID | File | Line(s) | Category | Description | Severity |
|-----------|------|---------|----------|-------------|----------|
| 1 | RacecarError1.java | 1–6 | CS | Malformed constructor with misplaced conditional logic and broken formatting, making the code difficult to read and violating Java coding standards. | High |
| 2 | RacecarError1.java | 19–22 | FD | `fuelPercentageRemaining` is set to `48.0` instead of `100.0`, causing incorrect race outcome calculations when the car needs to pit. | Critical |
| 3 | RacecarError1.java | 8–16 | CG | Local variable `fuelDrainRate` shadows a class-level variable, which can confuse readers and lead to maintenance errors. | Medium |
| 4 | RacecarError2.java | 20–24 | FD | When `needToPit` is true, the method mutates state (`fuelPercentageRemaining = 100.0` and `needToPit = false`) but still returns `false`, leading to inconsistent object state across calls. | High |
| 5 | RacecarError2.java | 8–31 | CG | `willFinish()` has side effects by modifying object state. A method named “willFinish” should ideally be a pure check or clearly documented as mutating state. | Medium |
| 6 | RacecarError2.java | 1–7 | CS | Inconsistent formatting and misplaced tokens near the constructor and conditionals violate standard Java style and reduce readability. | Low |
| 7 | RacecarExample.java | class fields | CG | Uses shared mutable state (`fuelPercentageRemaining`, `lapsCompleted`, `needToPit`) across method calls, making behavior order-dependent and harder to test. | Medium |
| 8 | RacecarExample.java | fuel logic | FD | Fuel calculation logic subtracts `fuelDrainRate * lapsCompleted` and compares against `fuelDrainRate * lapsRemaining` without a clearly consistent model, potentially producing incorrect results. | Medium |
| 9 | Main.java | main() | CG | Main method mixes output/printing with simulation logic, lacking separation of concerns and reducing maintainability and testability. | Low |
| 10 | RacecarError1.java | 18–24 | CS | Duplicate and misleading comment “first check if car already needs to pit” appears twice, and overall formatting in the method reduces clarity. | Low |

**Severity Levels:**
- **Critical**: Causes system failure, data corruption, or security issues
- **High**: Major functional defect or significant quality issue
- **Medium**: Moderate issue affecting maintainability or minor functional problem
- **Low**: Minor style issue or cosmetic problem

## Example Entry

| Defect ID | File          | Line(s) | Category | Description                                | Severity |
|-----------|---------------|---------|----------|--------------------------------------------|----------|
| 1 | Checkout.java | 17      | CS       | Variable bookList misleading - Map not List | Medium |
| 2 | Book.java     | 107     | FD       | Magic number 100 should be totalCopies      | High |

## Notes
- Be specific with line numbers
- Provide clear, actionable descriptions
- Consider: readability, maintainability, correctness, performance, security
- Focus on issues that impact code quality or functionality
