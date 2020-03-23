package com.example.accountenquiryscreen

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.accountenquiryscreen.adapter.AccountEnquiryFragmentAdapter
import com.example.accountenquiryscreen.data.DataSource
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var enquiryAdapter: AccountEnquiryFragmentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //display pie chart
        setUpPieChartData()

        //recycler view
        initRecyclerView()
        addDataSet()
    }

    private fun setUpPieChartData() {
        val pieChart = findViewById<PieChart>(R.id.pie_chart)

        pieChart.setHoleColor(Color.WHITE)
        pieChart.getDescription().setEnabled(false)
        pieChart.setDrawEntryLabels(false)
        pieChart.setEntryLabelTextSize(20f)

        val yVals = ArrayList<PieEntry>()
        yVals.add(PieEntry(43000f, "Savings"))
        yVals.add(PieEntry(40000f, "Deposit"))
        yVals.add(PieEntry(70000f, "Borrowings"))

        val dataSet = PieDataSet(yVals, "")
        dataSet.valueTextSize=0f
        val colors = java.util.ArrayList<Int>()
        colors.add(Color.BLUE)
        colors.add(Color.RED)
        colors.add(Color.GREEN)

        dataSet.setColors(colors)
        val data = PieData(dataSet)
        pieChart.data = data
    }

    private fun addDataSet(){
        val data = DataSource.createDataSet()
        enquiryAdapter.submitList(data)
    }

    private fun initRecyclerView(){

        account_enquiry_recyclerView.apply{
            layoutManager = GridLayoutManager(this@MainActivity, 3)
            enquiryAdapter = AccountEnquiryFragmentAdapter()
            adapter = enquiryAdapter
        }

    }

}
