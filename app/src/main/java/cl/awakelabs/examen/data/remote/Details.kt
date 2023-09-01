package cl.awakelabs.examen.data.remote

import com.google.gson.annotations.SerializedName

data class Details(
    val id: Int,
    @SerializedName("nombre") val name: String,
    @SerializedName("origen") val origin:String,
    @SerializedName("imagenLink") val image: String,
    @SerializedName("poder") val power:String,
    @SerializedName("año_creacion") val since: Int,
    val color: String,
    @SerializedName("traduccion") val translate: Boolean
)
