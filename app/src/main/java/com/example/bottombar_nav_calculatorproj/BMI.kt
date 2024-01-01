package com.example.bottombar_nav_calculatorproj

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.bottombar_nav_calculatorproj.databinding.ActivityMainBinding
import com.example.bottombar_nav_calculatorproj.databinding.FragmentBMIBinding

class BMI : Fragment() {

    private lateinit var binding:FragmentBMIBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        binding=FragmentBMIBinding.inflate(layoutInflater)

        binding = FragmentBMIBinding.inflate(layoutInflater,container,false)

        binding.calBtn.setOnClickListener {
            val height = binding.hightEt.text.toString()
            val weight = binding.wightEt.text.toString()


            if (height.isEmpty() && weight.isEmpty()){
                val alertDialog = AlertDialog.Builder(requireActivity())

                alertDialog.setIcon(android.R.drawable.ic_dialog_alert)
                alertDialog.setTitle("BMI Alert !")
                alertDialog.setMessage("Please enter your height and weight.")
                alertDialog.setNeutralButton("Cancel"){dialogInterface,which->
                    dialogInterface.cancel()
                }
                alertDialog.setPositiveButton("Ok"){
                        dialogInterface,which->
                    dialogInterface.dismiss()
                }
                val dialogCreate : AlertDialog = alertDialog.create()
                dialogCreate.show()
                dialogCreate.setCancelable(false)

            }
            else{
                val bmi = weight.toDouble()/((height.toDouble()/100)*(height.toDouble()/100))
                val bmiDigit = String.format("%.2f",bmi).toDouble()
                displayResult(bmiDigit)
            }
            binding.resultTxt.visibility = View.VISIBLE
        }


        return binding.root
    }

    private fun displayResult(bmi:Double) {
        binding.also {
            it.rangeTxt.text = bmi.toString()
            it.resultTxt.text = "Healthy"
            it.countTxt.text = "BMI range is 18.5 - 24.5"
        }

        var result = ""
        var color = 0
        var range = ""

        when{
            bmi<18.5->{
                result = "Underweight"
                color = R.color.un_weight
                range = "BMI range is less than 18.5"
            }
            bmi in 18.5 .. 24.5->{
                result = "Healthy"
                color = R.color.healt
                range = "BMI range is 18.5 - 24.5"
            }
            bmi in 24.5 .. 29.9->{
                result = "Overweight"
                color = R.color.overweight
                range = "BMI range is 24.5 - 29.9"
            }
            bmi >29.9->{
                result = "Obese"
                color = R.color.obese
                range = "BMI range is greater than 29.9"
            }
        }
        binding.apply {
           /* healthCondition.text = result
            healthCondition.setTextColor(ContextCompat.getColor(requireActivity(),color))
            bmiRange.text = range
            bmiRange.setTextColor(ContextCompat.getColor(requireActivity(),color))*/
        }

    }

}
