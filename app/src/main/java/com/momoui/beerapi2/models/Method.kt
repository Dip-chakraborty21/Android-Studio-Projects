package com.momoui.beerapi2.models

data class Method(
    val fermentation: Fermentation?,
    val mash_temp: List<MashTemp>?,
    val twist: String?
)