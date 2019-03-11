package id.gits.unla

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class News(
    var id: Int? = 0,
    var title: String? = "",
    var description: String? = ""
) : Parcelable