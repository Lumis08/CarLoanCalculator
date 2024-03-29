package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*val btnCalc = findViewById<Button>(R.id.buttonCalculate)
        btnCalc.setOnClickListener { loanCalculation() }*/

        buttonCalculate.setOnClickListener { loanCalculation() }

        buttonReset.setOnClickListener {
            editTextCarPrice.text.clear()
            editTextDownPayment.text.clear()
            editTextLoanPeriod.text.clear()
            editTextInterestRate.text.clear()

            textViewLoan.text = "Loan :"
            textViewInterest.text = "Interest :"
            textViewMonthlyRepayment.text = "Monthly Repayment :"

            editTextCarPrice.requestFocus()
            Toast.makeText(applicationContext, "The form is clearred", Toast.LENGTH_SHORT).show()
        }
    }

    fun loanCalculation(){

        try {
            val carPrice:Double = editTextCarPrice.text.toString().toDouble()
            val downPay:Double = editTextDownPayment.text.toString().toDouble()
            val loanPeriod:Double = editTextLoanPeriod.text.toString().toDouble()
            val interestRate:Double = (editTextInterestRate.text.toString().toDouble() / 100)

            val carLoan:Double = carPrice - downPay
            val interest:Double = carLoan * interestRate * loanPeriod
            val monthRepay:Double = (carLoan + interest) / loanPeriod / 12

            displayResult(carLoan, interest, monthRepay)
        }
        catch(ex:Exception){
            Toast.makeText(applicationContext, "The form is incomplete !!!", Toast.LENGTH_SHORT).show()
        }

    }

    fun displayResult(carLoan:Double, interest:Double, monthRepay:Double){

        textViewLoan.text = "Loan : " + "%.2f".format(carLoan)
        textViewInterest.text = "Interest : " + "%.2f".format(interest)
        textViewMonthlyRepayment.text = "Monthly Repayment : " + "%.2f".format(monthRepay)

        Toast.makeText(applicationContext, "Calculated", Toast.LENGTH_SHORT).show()

    }

}
