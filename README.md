FOUR SQUARE CIPHER

Data Structures
After too many attempts at implementing a data structure like an ArrayList, ArrayDeque or LinkedList, I discovered I still have a lot to learn about them. I had difficulties with understanding how exactly they worked and figured I should get on with the project just using Arrays and see how I fair out, time and complexity wise and decided to make another attempt at one of these data structures if I had enough time and if my program was extremely slow. 

Parsing
After researching the ways of reading in files fast, I discovered a Buffered Input Stream should be the most efficient buffering approach for reading a file line by line, which was one of the specifications for parsing. 
Using a while loop read in each line of the file until a value of null is returned(until it reaches end of the file), the line is then converted to all uppercase letters, striped of any characters that isn’t a letter between A-Z and replaces any J’s with an I as specified. 
At the end of each iteration in the while loop, the bigramAndCipher() method is called. This method will take in the line as an argument and will make the line an even length by appending a space as I will be looping through each character of the line, incrementing by two. To pair the characters into bigrams each line requires an even amount of characters. 
Once the two characters are stored, a small switch statement is carried out which will call either the encrypt() or decrypt() method. The switch is based on data from the argument passed in the method which is pulled from the user and will store a value of 1 or 2 to call which cipher method they specified. 
To allow file writing, I could not see any other option but to pass the PrintWriter as an argument in the bigramAndCipher() method as I was having trouble with closing the PrintWriter because it would have had to be closed in a method which was being called in a loop. This meant the PrintWriter was closing after each iteration of either the while loop reading in the files, or after each bigram was ciphered. 
Once the encypt() method has been called and it’s processes are completed, then output() is called. This method pulls in the value of the encrypted letter variables statically from the cipher class and outputs them based on the users choice of 1 or 2. Choosing 1 will output the ciphered data to the console where 2 outputs it to the file created in the parseFile() method. 

Ciphering
During group brainstorming sessions, they following methods were suggested: 
1D Arrays: 
Storing the alphabet and the keys and dividing and using modulus to get the letters index for a row and column as if they were a 2D array to create the 5x5 matrix needed for encrypting and decrypting.
2D Arrays:
Storing the alphabet and the keys, using the index of the row and column for plotting the location of the letter for encryption or decryption back into the 2D array. 
3D Arrays:
Storing the alphabet and two squares of the key in one 3D array which is just storing the three 2D arrays in one array and referencing which arrays you need to use as a dimension. 
Maps and Sets: 
Mapping and storing all the possible index outcomes to pairs of letters and pulling the data of their indexes once the bigram is searched for.

Encryption
The route I chose to take was creating a 1D array for containing the alphabet, the first part of the key and the second part of the key. These arrays are only used for searching for the letter in the bigram as it has the fastest possible outcome when it comes to arrays. The searching is carried out in the getIndexesofLetterOne() and getIndexesofLetterTwo() methods. Once the letter has been found, the static variables storing the index of the row is assigned the value of the index divided by 5 and the column is the index modulus 5. This is to get index for the rows and columns of a 5x5 2D array without looping through a 2D array, cutting the possible running time in half. 
Once the two letters have a value for a row and a column, they become the indexes to reference a location of the 2D key array which will give the encrypted letter. Before the value of the letter encrypted variable is assigned to the value from the 2D array, an if statement checks if the character is a space and assigns the value to the variable. 

Decryption
Following the same processes as encryption, the first letter in the bigram is searched for in the 1D array storing the first part of the key and the rows are assigned the value of the index divided by 5 and the column is the index modulus 5. 
Then the decrypted letter is found by using the indexes stored from the getIndexesofLetterOneEnc() and getIndexesofLetterTwoEnc() methods, it checks if the character stored is a space and stores it otherwise it uses the indexes stored in the static variables to reference the location of the decrypted letter from the 2D alphabet array. 

Key Generation
Instead of generating a random string for the key and having to remove duplicates and J’s from the string, I figured I would work with what I already have and just shuffle the order of the letters in the arrays I already have. 
After searching Stack Overflow for methods of shuffling, I came across Fisher Yate’s algorithm for shuffling a 1D array, which was then modified to shuffle a 2D array and re-populated the key arrays.



