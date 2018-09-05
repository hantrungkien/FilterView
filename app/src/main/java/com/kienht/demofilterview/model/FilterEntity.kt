package com.kienht.demofilterview.model

import com.google.gson.annotations.SerializedName

/**
 * @author kienht
 * @since 29/08/2018
 */
data class FilterEntity(@SerializedName("name") val name: String,
                        @SerializedName("color") val color: String,
                        @SerializedName("checked") var isChecked: Boolean)
