package com.fonfon.mvvmsample.data.domian.resource

import java.lang.RuntimeException

class Resource<T: DomianResource>(
    val state: ResourceState = ResourceState.NONE,
    val data: T? = null,
    val error: Throwable? = null
) {

    fun isLoad() = state == ResourceState.LOAD

    fun isData() = state == ResourceState.DATA

    fun isError() = state == ResourceState.ERROR

    fun requireData(): T = data ?: throw RuntimeException("Empty data")

    fun requireError() = error ?: throw RuntimeException("Empty error")

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Resource<*>

        if (state != other.state) return false
        if (data != other.data) return false
        if (error != other.error) return false

        return true
    }

    override fun hashCode(): Int {
        var result = state.hashCode()
        result = 31 * result + (data?.hashCode() ?: 0)
        result = 31 * result + (error?.hashCode() ?: 0)
        return result
    }


}