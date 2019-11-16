import java.util.*

fun main() {
    var flag: Boolean = true
    loop@ while (flag) {
        val random = (0..100).random()
        println("Please select the dificulty level")
        println("1 - Easy")
        println("2 - Medium")
        println("3 - Hard")

        val reader = Scanner(System.`in`)
        var input: Int = reader.nextInt()
        var i : Int
        when (input) {
            1 -> i = 7
            2 -> i = 5
            3 -> i = 3
            else -> {
                println("please select one of the options")
                continue@loop
            }
        }

        println("Select a number from 1-100")
        println("Note: you have $i steps")
        var myAnswer: Int
        while (i > 1) {
            myAnswer = reader.nextInt()
            i--;
            if (myAnswer > random)
                println("take lower")
            if (myAnswer < random)
                println("take higher")
            if (myAnswer == random) {
                println("You won!!! Congratulations...")
                return;
            }
            println("Note: you have $i steps")
        }

        myAnswer = reader.nextInt()
        if (myAnswer != random) {
            println("NOOOOOOOO  My number was $random")
            println("1 - Restart    2 - End")
            myAnswer = reader.nextInt()
            when (myAnswer) {
                1 -> continue@loop
                2 -> flag = false
                else -> println("Please select one of the options")
            }
        } else {
            println("You won!!! Congratulations...")
            flag = false
        }

    }
}
