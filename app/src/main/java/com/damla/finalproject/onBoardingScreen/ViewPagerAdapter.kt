package com.damla.finalproject.onBoardingScreen

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(list : ArrayList<Fragment>, fm:FragmentManager, lifeCycler: Lifecycle):FragmentStateAdapter(fm,lifeCycler){
    private val fragmentList:ArrayList<Fragment> = list

    override fun getItemCount(): Int {
            return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
            return fragmentList[position]

    }

}