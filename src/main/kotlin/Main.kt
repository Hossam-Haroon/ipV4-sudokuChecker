import jdk.incubator.vector.VectorOperators

import java.lang.reflect.Array.set
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap


fun main(args: Array<String>) {
   // isIPv4AddressValid("192.168.1.1")






}

fun isIPv4AddressValid(ipAddress:String):Boolean{
    var numberOfDots = 0
    if (ipAddress.isEmpty()){
        return false
    }
    else{
        for (i in ipAddress){
            if (i == '.'){
                numberOfDots+=1
                if (numberOfDots > 3){
                    return false
                }
            }
        }
        if ( numberOfDots < 3){
            return false
        }
        if (ipAddress.contains("[^0-9.]".toRegex())){
            return false
        }

        /*if (
        //doesn't work for some reason.
            ipAddress.contains("[a-z]".toRegex())
            || ipAddress.contains("[A-Z]".toRegex())
            || ipAddress.contains("[!\\\"#\$%&'()*+,-/:;\\\\\\\\<=>?@\\\\[\\\\]^_`{|}~]".toRegex())
            ){
            return false
        }*/
        val firstSegment = ipAddress.substringBefore(".")
        val lastSegment = ipAddress.substringAfterLast(".")
        val middleSegments =  ipAddress.substringAfter(".").substringBeforeLast(".")
        val secondSegment = middleSegments.substringBefore(".")
        val thirdSegment = middleSegments.substringAfter(".")
        if (
            (firstSegment.length > 1 && firstSegment[0] == '0')
            || (secondSegment.length > 1  && secondSegment[0] =='0')
            || (thirdSegment.length > 1 && thirdSegment[0]=='0')
            || (lastSegment.length > 1 && lastSegment[0]=='0')
            )
        {
            return false
        }
        if (firstSegment.toInt() !in 0..255 || secondSegment.toInt() !in 0..255
            || thirdSegment.toInt() !in 0..255 || lastSegment.toInt() !in 0..255)
        {
            return false
        }
    }

    return true

}

fun sudokuChecker(sudokuPuzzle : Array<CharArray>): Boolean{
    var rowIndex = 0
    var rowElementsIndex = 0
    val rowElement = sudokuPuzzle[rowIndex][rowElementsIndex]
    for (row in sudokuPuzzle){
        var rowElementsCount = 0
        while (rowElementsCount <= row.size-1){
            row.forEachIndexed { index, element ->
                if (index != rowElementsIndex){
                    if ( element == rowElement && element !='-'){
                        return false
                    }
                }
                if (element !in '1'..'9' || element != '-'){
                    return false
                }
            }
            rowElementsIndex+=1
            rowElementsCount+=1
        }

        rowElementsIndex=0
        rowIndex+=1
    }
    rowIndex = 0
    rowElementsIndex = 0

    // CAN'T FIGURE THE COLUMN CHECK
    //ALSO MISSING THE COLUMN PART IN THE FLOWCHART.
    while (rowIndex in 0..sudokuPuzzle.size-1){
        var rowIndexForColumnCheck = 0
        for (index in sudokuPuzzle[rowIndex].indices){
            if (index != rowElementsIndex){
                while (rowIndexForColumnCheck in 0..sudokuPuzzle.size-1 ){
                    if ( sudokuPuzzle[rowIndexForColumnCheck][rowElementsIndex] == rowElement &&
                        sudokuPuzzle[rowIndex][rowElementsIndex] !='-'){
                        return false
                    }

                    rowIndexForColumnCheck+=1
                }
                rowIndex+=1
            }
        }

    }


    return true
}










