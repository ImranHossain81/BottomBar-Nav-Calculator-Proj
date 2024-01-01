package com.example.bottombar_nav_calculatorproj

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.bottombar_nav_calculatorproj.databinding.FragmentBMIBinding


class BMI : Fragment() {

    private lateinit var weightTxt: EditText
    private lateinit var heightTxt: EditText
    private lateinit var calBtn: Button
    private lateinit var countTxt: TextView
    private lateinit var resultTxt: TextView
    private lateinit var rangeTxt: TextView

    /*private lateinit var FragmentBMIBinding binding*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_b_m_i, container, false)







    }




}