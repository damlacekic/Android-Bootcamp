package com.damla.finalproject.onBoardingScreen.onBoardingScreenFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.damla.finalproject.R
import com.damla.finalproject.databinding.FragmentOnBoardingScreenBinding
import com.damla.finalproject.onBoardingScreen.ViewPagerFragment

class OnBoardingScreenOne : Fragment() {
    private lateinit var binding: FragmentOnBoardingScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentOnBoardingScreenBinding.inflate(inflater,container,false)
        val buttontoSecondOnBoarding : Button = binding.buttonFirtsOnBoarding
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)
         buttontoSecondOnBoarding.setOnClickListener {
            viewPager?.currentItem = 1
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }


}