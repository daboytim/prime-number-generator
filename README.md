# prime-number-generator

A basic prime number generator. Given an integral range, this application will generate all prime numbers within that range.

##Usage
1) Test the application using gradle:

    
    $ ./gradlew test

2) Build the application using gradle:


    $ ./gradlew jar
    
3) Execute the application:


    $ java -jar build/libs/prime-number-generator-0.0.1.jar
    
The application will ask for two input integers which specify the range. And then will calculate the prime numbers within that range.

Ex:
    
    $ java -jar build/libs/prime-number-generator-0.0.1.jar
    Enter an integral range.
    Start: 7900
    End: 7920
    [7901, 7907, 7919]
    Continue generating primes?[Y/n] n
    
See also [Prime number](#https://en.wikipedia.org/wiki/Prime_number)
