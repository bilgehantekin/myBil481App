This Java utility method `stringManipulation()` is designed to perform string manipulation tasks based on input arrays of integers, a multiplier and a character.

Parameters:
- firstArray: ArrayList of integers representing the first array of characters.
- secondArray: ArrayList of integers representing the second array of characters.
- multiplier: An integer representing the number of times the concatenated string is to be repeated.
- lastChar: A character representing the character to be appended to the end of the string.

Behavior:
1) Converts each integer in firstArray and secondArray to its corresponding ASCII character using a cast to char.
2) Concatenates these ASCII characters into a concatenatedString.
3) Repeats concatenatedString multiplier times and appends lastChar to the end.
4) Returns the resulting string.

Error Handling:
   Returns null in the following cases:
   1) Either firstArray or secondArray is empty.
   2) Any character in firstArray or secondArray is not defined.
   3) multiplier is negative.
   4) lastChar is not a defined character.

[![Build Status](https://app.travis-ci.com/bilgehantekin/myBil481App.svg?token=vKUFqQJccpqGUXCqYhpP&branch=master)](https://app.travis-ci.com/bilgehantekin/myBil481App)

Demo site: https://aqueous-taiga-00163-99aa5cd79d46.herokuapp.com/compute
