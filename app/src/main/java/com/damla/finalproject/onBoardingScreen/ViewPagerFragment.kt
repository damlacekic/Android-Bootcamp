package com.damla.finalproject.onBoardingScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.damla.finalproject.R
import com.damla.finalproject.databinding.FragmentViewPagerBinding
import com.damla.finalproject.onBoardingScreen.onBoardingScreenFragments.OnBoardingScreenLast
import com.damla.finalproject.onBoardingScreen.onBoardingScreenFragments.OnBoardingScreenOne
import com.damla.finalproject.onBoardingScreen.onBoardingScreenFragments.OnBoardingScreenTwo

class ViewPagerFragment : Fragment() {
    private lateinit var binding: FragmentViewPagerBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentViewPagerBinding.inflate(inflater,container,false)
        val fragmentList = arrayListOf<Fragment>(
            OnBoardingScreenOne(),
            OnBoardingScreenTwo(),
            OnBoardingScreenLast()

        )
        val adapter = ViewPagerAdapter(fragmentList,requireActivity().supportFragmentManager,lifecycle)
        binding.viewPager.adapter =  adapter
        return binding.root
    }


}