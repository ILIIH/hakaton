package com.uaref.viewModel

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.maxshop.model.RecyclerItem
import com.uaref.mapper.ServiceTimeMapper
import com.uaref.model.DaysOfWeek
import com.uaref.model.ServiceFreeTime
import com.uaref.model.ServiceTime

internal class NewServiceViewModel(private val serviceTimeMapper: ServiceTimeMapper) : ViewModel(),
    DefaultLifecycleObserver {
    private val _appointmentsList = MutableLiveData<List<RecyclerItem>>()
    val appointmentsList: LiveData<List<RecyclerItem>> get() = _appointmentsList

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        if (_appointmentsList.value?.size == null) {
            _appointmentsList.value = mutableListOf()
            addAppointment()
        }
    }

    fun addAppointment() {
        _appointmentsList.value = listOf(
            serviceTimeMapper.toRecyclerItem(
                ServiceTime(DaysOfWeek.NonSelected, ServiceFreeTime("00:00", "23:59"))
            )
        )
    }
}
