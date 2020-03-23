package com.example.termdepositscreen.accountEnquiry.objects

data class CustomerDetails (
    var amount: Int,
    var currency: String,
    var name: String
) {
    override fun toString(): String{
        return "CustomerDetails(amount='$amount', currency='$currency', name='$name')"
    }
}

