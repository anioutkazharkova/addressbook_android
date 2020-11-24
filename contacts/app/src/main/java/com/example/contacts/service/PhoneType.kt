package com.example.contacts.service

enum class PhoneType(val value: String)  {
    MOBILE("Mobile"), HOME("Home"), WORK_MOBILE("Work mobile"), WORK("Work"),
    UNKNOWN("");

companion object  {
    fun getValue(value: Int): PhoneType{
        when (value) {
            PhoneTypes.HOME -> return HOME
            PhoneTypes.MOBILE -> return MOBILE
            PhoneTypes.WORK -> return WORK
            PhoneTypes.WORK_MOBILE -> return WORK_MOBILE
            else ->return UNKNOWN
        }
    }
}
}