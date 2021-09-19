package section1

class MapExercise {
    fun getFirstNonRepeatedCharacter(s: String): String {
        val map = mutableMapOf<Char, Int>()
        val chars = s.toCharArray()
        chars.forEach {
            if (map.containsKey(it)) {
                map[it] = map[it]!! + 1
            } else {
                map[it] = 1
            }
        }
        chars.forEach {
            if (map[it] == 1) {
                return it.toString()
            }
        }

        return ""
    }

    fun getFirstRepeatedCharacter(s: String): String {
        val set = mutableSetOf<Char>()
        s.toCharArray().forEach {
            if (!set.contains(it)) {
                set.add(it)
            } else {
                return it.toString()
            }
        }
        return ""
    }

    fun mostFrequent(list: List<Int>): Int {
        val map = mutableMapOf<Int, Int>()
        list.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }
        var max = Int.MIN_VALUE
        var mostFrequentNum = Int.MIN_VALUE
        map.forEach { (k, v) ->
            if (v > max) {
                max = v
                mostFrequentNum = k
            }
        }

        return mostFrequentNum
    }

    fun countPairsWithDiff(list: List<Int>, k: Int): Int {
        var count = 0

        for (small in list) {
            for (big in list) {
                if (big - small == k) {
                    count++
                    break
                }
            }
        }

        return count
    }

    fun twoSum(list: List<Int>, target: Int): List<Int> {
        list.forEachIndexed { index, i ->
            list.forEachIndexed { index2, i2 ->
                if (i + i2 == target) {
                    return listOf(index, index2)
                }
            }
        }
        return emptyList()
    }
}