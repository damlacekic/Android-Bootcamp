package com.damla.finalproject.onBoardingScreen.onBoardingScreenFragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.damla.finalproject.R
import com.damla.finalproject.databinding.FragmentOnBoardingScreenLastBinding


class OnBoardingScreenLast : Fragment() {
    private lateinit var binding :  FragmentOnBoardingScreenLastBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentOnBoardingScreenLastBinding.inflate(inflater,container,false)
        val lastButtonOnBaordingScreen : Button = binding.buttonLastOnBoarding
        lastButtonOnBaordingScreen.setOnClickListener {
            findNavController().navigate(R.id.action_viewPagerFragment_to_mainFragment)
            onBoardingFinished()
        }
        return binding.root
    }
    private fun onBoardingFinished(){
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("Finished",true)
        editor.apply()
    }


}