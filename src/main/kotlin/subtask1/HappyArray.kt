package subtask1

class HappyArray {

    // TODO: Complete the following function
    fun convertToHappy(sadArray: IntArray): IntArray {
        var i = 0
        var n = 0
        var happyArray: IntArray = sadArray.copyOf()
        while (i < sadArray.size) {
            if (i != 0 && i != (sadArray.size - 1) && sadArray[i] > (sadArray[i - 1] + sadArray[i + 1])) {
                n = i
                while (n < sadArray.size - 1) sadArray[n] = sadArray[++n]
                happyArray = sadArray.copyOf(happyArray.size - 1)
                i -= 1
                continue
            }
            i++
        }
        return happyArray
        // throw NotImplementedError("Not implemented")
    }
}