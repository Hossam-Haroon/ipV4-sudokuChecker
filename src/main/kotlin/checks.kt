

fun main(){
   //valid IPv4 address:
    check(
        name = "when you have segment numbers between 0 to 255 and contains only 3 dots, it returns true",
        result = isIPv4AddressValid("192.168.1.1"),
        correctResult = true
    )
    //done
    check(
        name = "when you have more than 3 dots, it returns false",
        result = isIPv4AddressValid("192.168.1.1."),
        correctResult = false
    )
    //done
    check(
        name = "when you have a segment number bigger than 255, it returns false",
        result = isIPv4AddressValid("192.168.1.260"),
        correctResult = false
    )
    //done
    check(
        name = "when you have a leading zero in any of the segments except zero digit, it returns false",
        result = isIPv4AddressValid("192.168.1.01"),
        correctResult = false
    )
    //done
    check(
        name = "when you have a character or anything else except numbers, it returns false",
        result = isIPv4AddressValid("192.a68.1.1"),
        correctResult = false
    )
    //done
    check(
        name = "when you have a negative number it returns false (segment numbers are always positive)",
        result = isIPv4AddressValid("192.-168.1.1"),
        correctResult = false
    )
    //done
    check(
        name = "when you have less than 4 segment numbers, it returns false",
        result = isIPv4AddressValid("192.168.1"),
        correctResult = false
    )
    //done
    check(
        name = "when you have no address or only a space, it returns false",
        result = isIPv4AddressValid("   "),
        correctResult = false
    )

    //----------------------------------------------------------
    // sudoku checker
    check(
        name = "when there are no repeated numbers in any row or column, it returns true",
        result = sudokuChecker(
            arrayOf(
                charArrayOf('5', '-', '9', '7', '4', '3', '1', '-', '2'),
                charArrayOf('1', '8', '-', '6', '-', '-', '7', '-', '-'),
                charArrayOf('4', '-', '-', '2', '-', '1', '-', '9', '-'),
                charArrayOf('9', '-', '-', '3', '7', '-', '6', '-', '-'),
                charArrayOf('-', '3', '-', '1', '9', '-', '-', '7', '5'),
                charArrayOf('-', '-', '8', '-', '-', '-', '-', '3', '-'),
                charArrayOf('3', '-', '7', '4', '6', '-', '-', '1', '-'),
                charArrayOf('8', '-', '4', '9', '-', '5', '-', '6', '-'),
                charArrayOf('-', '9', '-', '8', '3', '-', '2', '-', '-')
            )

        ),
        correctResult = true
    )

    //done
    check(
        name = "when there is a repeated number in any row, it returns false",
        result = sudokuChecker(
            arrayOf(
                charArrayOf('5', '-', '9', '7', '4', '3', '1', '-', '2'),
                charArrayOf('1', '8', '-', '6', '-', '-', '7', '-', '1'),
                charArrayOf('4', '-', '-', '2', '-', '1', '-', '9', '-'),
                charArrayOf('9', '-', '-', '3', '7', '-', '6', '-', '-'),
                charArrayOf('-', '3', '-', '1', '9', '-', '-', '7', '5'),
                charArrayOf('-', '-', '8', '-', '-', '-', '-', '3', '-'),
                charArrayOf('3', '-', '7', '4', '6', '-', '-', '1', '-'),
                charArrayOf('8', '-', '4', '9', '-', '5', '-', '6', '-'),
                charArrayOf('-', '9', '-', '8', '3', '-', '2', '-', '-')
            )
        ),
        correctResult = false
    )
    check(
        name = "when there is a repeated number in any column, it returns false ",
        result = sudokuChecker(
            arrayOf(
                charArrayOf('5', '-', '9', '7', '4', '3', '1', '-', '2'),
                charArrayOf('1', '8', '-', '6', '-', '-', '7', '-', '-'),
                charArrayOf('4', '-', '-', '2', '-', '1', '-', '9', '-'),
                charArrayOf('9', '-', '-', '3', '7', '-', '6', '-', '-'),
                charArrayOf('-', '3', '-', '1', '9', '-', '-', '7', '5'),
                charArrayOf('9', '-', '8', '-', '-', '-', '-', '3', '-'),
                charArrayOf('3', '-', '7', '4', '6', '-', '-', '1', '-'),
                charArrayOf('8', '-', '4', '9', '-', '5', '-', '6', '-'),
                charArrayOf('-', '9', '-', '8', '3', '-', '2', '-', '-')
            )
        ),
        correctResult = false
    )
    //done
    check(
        name = "when there is a letter in any column or row, it returns false ",
        result = sudokuChecker(
            arrayOf(
                charArrayOf('5', '-', '9', '7', '4', '3', '1', '-', '2'),
                charArrayOf('1', '8', '-', '6', '-', '-', '7', '-', '-'),
                charArrayOf('4', '-', '-', '2', '-', '1', '-', '9', '-'),
                charArrayOf('9', '-', '-', '3', '7', 'a', '6', '-', '-'),
                charArrayOf('-', '3', '-', '1', '9', '-', '-', '7', '5'),
                charArrayOf('9', '-', '8', '-', '-', '-', '-', '3', '-'),
                charArrayOf('3', '-', '7', '4', '6', '-', '-', '1', '-'),
                charArrayOf('8', '-', '4', '9', '-', '5', '-', '6', '-'),
                charArrayOf('-', '9', '-', '8', '3', '-', '2', '-', '-')
            )

        ),
        correctResult = false
    )





}

fun <T> check(name: String, result : T, correctResult: T ){
    if (result == correctResult){
        println("Success - $name")
    }else{
        println("Failed - $name")
    }
}