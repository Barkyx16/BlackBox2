# White Box Testing Report - Assignment 3
**Student Name:** Alexander Rafalski
**ASU ID:** 1224381808
**Date:** 02-04-2026

---
---

## Part 1: Control Flow Graph for willFinish(int avgSpeed)

**Class:** RacecarExample  
**Method:** willFinish(int avgSpeed)

### Graph Description

The control flow graph (CFG) for `willFinish(int avgSpeed)` is based on conditional branches that determine fuel drain rate, pit behavior, and whether the racecar can finish the race.

**Nodes (line numbers from RacecarExample.java):**

- **N1 (46–48):** Method entry and declaration of `fuelDrainRate`
- **N2 (49):** Decision: `avgSpeed >= 150`
- **N3 (50):** Assign `fuelDrainRate = 0.20`
- **N4 (51):** Decision: `avgSpeed >= 100`
- **N5 (52):** Assign `fuelDrainRate = 0.10`
- **N6 (54):** Assign `fuelDrainRate = 0.05`
- **N7 (58):** Decision: `needToPit`
- **N8 (60–61):** Refuel to 100% and return `false`
- **N9 (65):** Subtract fuel drain based on laps completed
- **N10 (68):** Compute laps remaining
- **N11 (69):** Return comparison result

**Edges:**
- N1 → N2  
- N2(T) → N3 → N7  
- N2(F) → N4  
- N4(T) → N5 → N7  
- N4(F) → N6 → N7  
- N7(T) → N8  
- N7(F) → N9 → N10 → N11  

---

### Node Coverage Sequences

**Sequence 1:**
- **Path:** N1 → N2(T) → N3 → N7(F) → N9 → N10 → N11  
- **Purpose:** Covers high-speed branch (`avgSpeed >= 150`) and normal completion logic  
- **Test case:** `avgSpeed = 150`, `needToPit = false`

**Sequence 2:**
- **Path:** N1 → N2(F) → N4(T) → N5 → N7(T) → N8  
- **Purpose:** Covers mid-speed branch and early exit due to pit requirement  
- **Test case:** `avgSpeed = 100`, `needToPit = true`

**Sequence 3:**
- **Path:** N1 → N2(F) → N4(F) → N6 → N7(F) → N9 → N10 → N11  
- **Purpose:** Covers low-speed branch (`avgSpeed < 100`)  
- **Test case:** `avgSpeed = 99`, `needToPit = false`

---

### Edge Coverage Sequences

**Sequence 1:**
- **Edges covered:** N1→N2, N2(T)→N3, N3→N7, N7(F)→N9, N9→N10, N10→N11  
- **Test case:** `avgSpeed = 150`, `needToPit = false`

**Sequence 2:**
- **Edges covered:** N1→N2, N2(F)→N4, N4(T)→N5, N5→N7, N7(T)→N8  
- **Test case:** `avgSpeed = 100`, `needToPit = true`

**Sequence 3:**
- **Edges covered:** N1→N2, N2(F)→N4, N4(F)→N6, N6→N7, N7(F)→N9, N9→N10, N10→N11  
- **Test case:** `avgSpeed = 99`, `needToPit = false`

---

## Part 2: Code Coverage with JaCoCo

### Initial Coverage for Checkout.java

**Before adding tests:**
- **Line Coverage:** 93%
- **Branch Coverage:** 100%

### Coverage for countBooksByType()

**Before additional tests:**
- **Branch Coverage:** 100%

**After reaching 80% branch coverage:**
- **Branch Coverage:** 100%
- **Tests added:** Existing black-box and white-box tests already provided full branch coverage.

### Final Overall Coverage

- **Line Coverage:** 93%
- **Branch Coverage:** 100%

## Part 3: Bug Fix / Implementation Change (RacecarError1)

### Test-Driven Development Process

**Number of tests from BlackBox assignment:** 16+

**Implementation challenges:**
1. Identifying incorrect refueling behavior when `needToPit` was true  
2. Ensuring fixes did not break existing black-box tests  

**All tests passing:** Yes

---

## Part 4: Reflection

**How did white-box testing differ from black-box testing?**  
White-box testing required understanding the internal logic and control flow of the method, while black-box testing focused only on inputs and outputs without considering implementation details.

**Which approach do you find more effective? Why?**  
White-box testing is more effective for finding hidden logic errors and ensuring full coverage of branches, while black-box testing is better for validating expected behavior from a user perspective.

**Would you prefer TDD or implementation first then testing? Why?**  
Test-driven development is preferred because it helps define correct behavior early and reduces the likelihood of introducing regressions during implementation.
