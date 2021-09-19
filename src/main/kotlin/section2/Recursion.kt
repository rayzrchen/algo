package section2

class Recursion {

    fun factorial(i: Int): Long {
        return factorialRecursive(i)
    }

    fun factorial2(i: Int): Long {
        return factorialRecursive(i, 1)
    }

    private fun factorialRecursive(i: Int): Long {
        return if (i == 1) {
            i.toLong()
        } else {
            i * factorialRecursive(i-1)
        }
    }

    private tailrec fun factorialRecursive(i: Int, res: Long): Long {
        return if (i == 1) {
            res * 1
        } else {
            factorialRecursive(i-1, res * i)
        }
    }

}