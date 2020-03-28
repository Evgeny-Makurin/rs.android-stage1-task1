package subtask5

class HighestPalindrome {

    // TODO: Complete the following function
    fun highestValuePalindrome(n: Int, k: Int, digitString: String): String {
        val str = StringBuilder(digitString)
        var count = 0
        for (i in 0 until digitString.length / 2)
            if (digitString[i] != digitString[digitString.length - i - 1]) count++
        var m = k - count
        val result = if (m >= 0) {
            for (i in 0..digitString.length / 2) {
                if (m > 1 && str[i] != '9') {
                    if (str[i] != '9') {
                        if (str[i] == str[str.length - i - 1]) m -= 2 else m--
                        str[i] = '9'
                        str[str.length - i - 1] = '9'
                    }
                } else if (str[i] != str[str.length - i - 1]) {
                    if (m == 1 && str[i] != '9') {
                        str[i] = '9'
                        str[str.length - i - 1] = '9'
                        m--
                    } else if (str[i] > str[str.length - i - 1]) str[str.length - i - 1] = str[i]
                    else str[i] = str[str.length - i - 1]
                }
            }
            if (str.length % 2 == 1 && m > 0) str[(str.length - 1) / 2] = '9'
            str.toString()
        } else "-1"
        return result
        // throw NotImplementedError("Not implemented")
    }
}
