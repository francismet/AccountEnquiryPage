package com.example.accountenquiryscreen.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.accountenquiryscreen.R
import com.example.termdepositscreen.accountEnquiry.objects.CustomerDetails
import kotlinx.android.synthetic.main.layout_customer_details_list_item.view.*

class AccountEnquiryFragmentAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: List<CustomerDetails> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return AccountDetailsHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_customer_details_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is AccountDetailsHolder -> {
                holder.bind(items.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(detailList: List<CustomerDetails>){
        items = detailList
    }

    class AccountDetailsHolder
    constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView){

        val account_enquiry_value : TextView = itemView.account_enquiry_value
        val account_enquiry_name : TextView = itemView.account_enquiry_name

        fun bind(customerDetails: CustomerDetails){
            account_enquiry_value.text = customerDetails.amount.toString() + " " + customerDetails.currency
            account_enquiry_name.text = customerDetails.name

        }
    }

}