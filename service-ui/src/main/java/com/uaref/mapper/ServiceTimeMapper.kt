package com.uaref.mapper

import com.example.service_ui.BR
import com.example.service_ui.R
import com.maxshop.model.RecyclerItem
import com.uaref.model.ServiceTime

internal class ServiceTimeMapper {
    fun toRecyclerItem(serviceTime: ServiceTime) =
        RecyclerItem(serviceTime, R.layout.item_choose_time, BR.time)
}
