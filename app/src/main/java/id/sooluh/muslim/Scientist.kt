package id.sooluh.muslim

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Scientist(
    val name: String,
    val fullName: String,
    val description: String,
    val photo: Int
) : Parcelable
