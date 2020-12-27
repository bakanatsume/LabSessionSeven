package com.bipash.labsessionseven

import java.io.Serializable

class StudentDetails(
    var name :String,
    var address : String,
    var number : String,
    var gender : String,
):Serializable {

    override fun toString(): String {
        return name
    }
}