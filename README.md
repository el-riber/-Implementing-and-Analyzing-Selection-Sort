

# **Selection Sort Project**

This project was created for an assignment where I had to implement and analyze the Selection Sort algorithm. I wrote three versions of Selection Sort in Java and tested them with different types of inputs to see how they behave.

---

## 📌 **What’s Included**

* **Basic Selection Sort** (ascending)
* **Selection Sort in descending order** (optional enhancement)
* **Stable Selection Sort** (optional enhancement)
* Full test suite inside `main()`
  (random array, sorted array, descending array, all-equal array, empty array, and single-element array)

---

## 🚀 **How the Algorithm Works**

Selection Sort goes through the array and repeatedly picks the smallest element from the unsorted part and places it in the correct spot. It does this by finding the index of the minimum value and swapping it with the current index.

The descending version is basically the same, except it looks for the largest value instead.

The stable version doesn’t swap; it shifts elements instead, which keeps equal values in the same order they originally appeared.

---

## 🧪 **Test Cases Used**

The assignment required several different types of arrays to check correctness:

### ✔ Normal Cases

* Randomly generated array
* Already sorted array
* Descending array
* All elements equal

### ✔ Edge Cases

* Empty array
* Single-element array

For each test, the program prints the array before and after sorting and also checks if the final output is actually sorted.

---

## 📊 **Time & Space Complexity**

* **Time Complexity:**
  Selection Sort always uses **O(n²)** time because of the nested loops.

* **Space Complexity:**
  The algorithm sorts the array in-place, so it uses **O(1)** extra memory.

* **Stability:**
  The basic version is *not* stable.
  The stable version fixes this by shifting instead of swapping.

---

## 📁 **Files**

| File                        | Description                                                            |
| --------------------------- | ---------------------------------------------------------------------- |
| `SelectionSortDemo.java`    | Main Java file with all three selection sort implementations and tests |
| `Selection_Sort_Report.pdf` | Short written report included for submission                           |
| `README.md`                 | (This file)                                                            |

---

## ▶️ **How to Run the Program**

1. Compile the Java file:

```
javac SelectionSortDemo.java
```

2. Run it:

```
java SelectionSortDemo
```

3. The output will show all test cases and their results in the console.

---

## 💬 **Reflection**

Working on this helped me understand why Selection Sort isn’t used for large datasets but is still useful for learning sorting concepts. Adding the stable version also showed how algorithm behavior can change even if the time complexity stays the same.

