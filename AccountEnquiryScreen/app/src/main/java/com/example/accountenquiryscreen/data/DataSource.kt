package com.example.accountenquiryscreen.data

import com.example.termdepositscreen.accountEnquiry.objects.CustomerDetails

class DataSource{

    companion object{

        fun createDataSet() : ArrayList<CustomerDetails>{
            val list = ArrayList<CustomerDetails>()
            list.add(
                CustomerDetails(
                    43000,
                    "GBP",
                    "Savings"
                    )
            )
            list.add(
                CustomerDetails(
                    40000,
                    "GBP",
                    "Deposits"
                )
            )
            list.add(
                CustomerDetails(
                    -70000,
                    "GBP",
                    "Borrowings"
                )
            )

            return list
        }
    }
}