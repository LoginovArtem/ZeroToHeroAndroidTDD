package ru.easycode.zerotoheroandroidtdd

interface Count {
    fun increment(number: String): UiState
    fun initial(number: String): UiState
    fun decrement(number: String): UiState
    class Base(
        private val step: Int,
        private val max: Int,
        private val min: Int
    ) : Count {

        init {
            if (step < 1) throw IllegalStateException("step should be positive, but was $step")
            if (max < 1) throw IllegalStateException("max should be positive, but was $max")
            if (max < step) throw IllegalStateException("max should be more than step")
            if (max < min) throw IllegalStateException("max should be more than min")
        }

        override fun increment(number: String): UiState {
            val result = number.toInt() + step
            if (result >= max) return UiState.Max(max.toString())
            else return UiState.Base(result.toString())
        }

        override fun initial(number: String): UiState {
            if (number.toInt() == max) return UiState.Max(max.toString())
            else if (number.toInt() == min) return UiState.Min(min.toString())
            else return UiState.Base(number)
        }

        override fun decrement(number: String): UiState {
            val result = number.toInt() - step
            if (result <= min) return UiState.Min(min.toString())
            else return UiState.Base(result.toString())
        }

    }
}