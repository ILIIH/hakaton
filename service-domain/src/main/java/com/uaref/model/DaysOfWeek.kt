package com.uaref.model

sealed class DaysOfWeek {
    object Sunday : DaysOfWeek()
    object Monday : DaysOfWeek()
    object Tuesday : DaysOfWeek()
    object Wednesday : DaysOfWeek()
    object Thursday : DaysOfWeek()
    object Friday : DaysOfWeek()
    object Saturday : DaysOfWeek()
    object NonSelected : DaysOfWeek()
}
