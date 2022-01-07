package com.drake.statelayout

import android.view.View
import java.io.Serializable

data class StatePair(
    var first: View,
    var second: Any?
) : Serializable {

    override fun toString(): String = "($first, $second)"
}