package subtask4

class StringParser {
    private var arr = arrayOf<String>()
    private val opn = arrayOf('[', '{', '(', '<')
    private val cls = arrayOf(']', '}', ')', '>')
    // TODO: Complete the following function
    fun getResult(inputString: String): Array<String> {
        var k:Int
        var m:Int
        for (i in inputString.indices)
            if (inputString[i] in opn) {
                k = arr.size
                res(i, inputString)
                arr.distinct()
                m = arr.size
                if (m - k > 1) {
                    while (k < k + (m - k) / 2) {
                        val tmp = arr[k]
                        arr[k++] = arr[m - 1]
                        arr[m-- - 1] = tmp
                    }
                }
            }
        return arr.distinct().toTypedArray()
    }
    private fun res(begin: Int, inputString: String) {
        var str = ""
        val char = inputString[begin]
        var count = 0
        for (i in begin + 1 until inputString.length) {
            if (inputString[i] in cls && opn.indexOf(char) == cls.indexOf(inputString[i]) && count == 0) {
                arr += str
                return
            } else if (opn.indexOf(char) == cls.indexOf(inputString[i]) && count != 0) count--
            str = inputString.substring(begin + 1, begin + 1 + (i - begin))
            if (inputString[i] in opn)
                res(i, inputString)
            if (char == inputString[i]) count++
        }
    }
}
