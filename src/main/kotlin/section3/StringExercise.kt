package section3

class StringExercise {

    companion object {
        fun reverse(str: String): String {
            val result = StringBuilder()

            for (i in str.toCharArray().size - 1 downTo 0) {
                result.append(str[i])
            }

            return result.toString()
        }

        fun findVowels(str: String): Int {
            val vowels = "aeiou".toCharArray()
            var result = 0
            str.lowercase().forEach {
                if (vowels.contains(it)) {
                    result++
                }
            }
            return result
        }

        fun reverseWordsInASentence(str: String): String {
            val list = str.trim().split(" ").toMutableList()
            for (i in 0 until list.size / 2) {
                swap(list, i, list.size - 1 - i)
            }
            return list.joinToString(" ")
        }

        private fun swap(list: MutableList<String>, a: Int, b: Int) {
            val temp = list[a]
            list[a] = list[b]
            list[b] = temp
        }

        fun reverseWordsInASentence2(str: String): String {
            return str.trim().split(" ").reversed().joinToString(" ")
        }

        fun checkRotation(str1: String, str2: String): Boolean {
            return str1.length == str2.length &&
                    (str1 + str1).contains(str2)
        }

        fun removeDuplicate(str: String): String {
            val result = StringBuilder()
            val seen = mutableSetOf<Char>()
            str.toCharArray().forEach {
                if (!seen.contains(it)) {
                    seen.add(it)
                    result.append(it)
                }
            }
            return result.toString()
        }

        fun mostRepeated(str: String): String {
            if (str.isEmpty()) {
                return ""
            }

            val frequencies = mutableMapOf<Char, Int>()
            str.toCharArray().forEach {
                frequencies[it] = frequencies.getOrDefault(it, 0) + 1
            }
            return frequencies.maxByOrNull { it.value }!!.key.toString()
        }

        fun capitalizeFirstLetterOfEachWord(str: String): String {
            return str
                .split(" +".toRegex())
                .filter { it.isNotEmpty() }
                .joinToString(" ") {
                    "${it[0].uppercase()}${it.substring(1).lowercase()}"
                }
        }

        fun checkAnagram(s1: String, s2: String): Boolean {
            if (s1.length != s2.length) {
                return false
            }
            val array1 = s1.toCharArray()
            array1.sort()
            val array2 = s2.toCharArray()
            array2.sort()
            return array1.contentEquals(array2)
        }

        fun checkPalindrome(str: String): Boolean {
            for (i in 0 until str.length / 2) {
                if (str[i] != str[str.length - 1 - i]) {
                    return false
                }
            }
            return true
        }


    }
}