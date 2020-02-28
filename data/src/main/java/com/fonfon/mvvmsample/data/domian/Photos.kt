package com.fonfon.mvvmsample.data.domian

import com.fonfon.mvvmsample.data.domian.resource.DomianResource

data class Photos(val items: List<Photo> = ArrayList()): DomianResource()