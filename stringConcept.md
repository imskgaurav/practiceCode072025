Interview Takeaway:
isEmpty() → checks only length.
isBlank() → checks length and whitespace (added in Java 11).
>>isBlank() (Java 11+) checks if the string is empty or only contains whitespace (spaces, tabs, newlines, etc.).
Since "\n" is whitespace only,
s4.isBlank() → true