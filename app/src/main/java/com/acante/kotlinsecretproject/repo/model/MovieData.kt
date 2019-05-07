package com.acante.kotlinsecretproject.repo.model

class MovieData(val id:Int, val title:String,val year:String) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MovieData

        if (title != other.title) return false
        if (year != other.year) return false

        return true
    }

    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + year.hashCode()
        return result
    }

}
