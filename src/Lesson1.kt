import java.util.*

fun main() {
    var flag: Boolean = true
    loop1@ while (flag) {
        val random = (1..100).random()
        println("Please select the dificulty level")
        println("1 - Easy")
        println("2 - Medium")
        println("3 - Hard")

        val reader = Scanner(System.`in`)
        val input: Int = reader.nextInt()
        var numberOfSteps: Int
        when (input) {
            1 -> numberOfSteps = 7
            2 -> numberOfSteps = 5
            3 -> numberOfSteps = 3
            else -> {
                println("please select one of the options")
                continue@loop1
            }
        }

        println("Select a number from 1-100")
        println("Note: you have $numberOfSteps steps")
        var myAnswer: Int
        while (numberOfSteps > 0) {
            try {
                myAnswer = reader.nextInt()
                if(myAnswer < 1 || myAnswer > 100){
                    throw NumberFormatException()
                }
            } catch (e: Exception) {
                println("Please select a number from 1-100")
                continue
            }

            numberOfSteps--
            if (numberOfSteps == 0) {
                if (myAnswer != random) {
                    println("NOOOOOOOO  My number was $random")
                    println("1 - Restart    2 - End")
                    myAnswer = reader.nextInt()
                    when (myAnswer) {
                        1 -> continue@loop1
                        2 -> flag = false
                        else -> println("Please select one of the options")
                    }
                } else {
                    println("You won!!! Congratulations...")
                    flag = false
                }
            } else {
                if (myAnswer > random)
                    println("take lower")
                if (myAnswer < random)
                    println("take higher")
                if (myAnswer == random) {
                    println("You won!!! Congratulations...")
                    return;
                }
                println("Note: you have $numberOfSteps steps")
            }
        }
    }
}
