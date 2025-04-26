# Sliding Window Pattern

The sliding window pattern is used to process sequential data, arrays, and strings,
for example, to efficiently solve subarray or substring problems.
It involves maintaining a dynamic window that slides through the array or string,
adjusting its boundaries as needed to track relevant elements or characters.
The window is used to slide over the data in chunks corresponding to the window size,
and this can be set according to the problem’s requirements. It may be viewed as a
variation of the two pointers pattern, with the pointers being used to set the window bounds.

## Does your problem match this pattern?

Yes, if all of these conditions are fulfilled:

### ✅ Contiguous Data
The input data is stored in a **contiguous manner**, such as an **array** or **string**.

### ✅ Processing Subsets of Elements
The problem requires **repeated computations on a contiguous subset** of data elements
(**a subarray or a substring**), such that the **window moves across the input** array
from one end to the other.
- The **size of the window** may be **fixed or variable**, depending on the problem requirements.

### ✅ Efficient Computation Time Complexity
The computations performed **every time the window moves take constant or very small time**.

---

## 🌍 Real-World Problems Using Sliding Window

### 📡 Telecommunications
Find the **maximum number of users** connected to a cellular network’s **base station**
in every **k-millisecond sliding window**.

### 🎥 Video Streaming
Given a **stream of numbers** representing the number of **buffering events** in a given user session,
**calculate the median buffering events** in each **one-minute interval**.

### 📱 Social Media Content Mining
Given the **lists of topics** that two users have posted about, find the **shortest sequence of posts**
by one user that **includes all the topics** that the other user has posted about.

---

### 🔥 Conclusion
The **Sliding Window Pattern** is an efficient approach to solve problems involving **contiguous subsets**
of data, reducing **time complexity** from **O(N²) to O(N)** in many cases.
