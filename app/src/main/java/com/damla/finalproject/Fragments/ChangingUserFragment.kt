package com.damla.finalproject.Fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import androidx.navigation.Navigation
import com.damla.finalproject.Activity.MainActivity

import com.damla.finalproject.databinding.FragmentChangingUserBinding

class ChangingUserFragment : Fragment() {

    private lateinit var binding: FragmentChangingUserBinding
    var radioButtonChoice : Int = 0
    private lateinit var preferences : SharedPreferences
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = FragmentChangingUserBinding.inflate(inflater,container,false)
        val toolBarChangingUser : Toolbar = binding.toolBarChangingUser
        val buttonKaydet : Button = binding.buttonKaydet
        preferences = requireActivity().getSharedPreferences("com.damla.finalproject", Context.MODE_PRIVATE)
        (activity as MainActivity).setSupportActionBar(toolBarChangingUser)
        binding.radioGroupChangingUser.setOnCheckedChangeListener { group, checkedId ->
            var radioButton:View = binding.radioGroupChangingUser.findViewById(checkedId)
            var index = binding.radioGroupChangingUser.indexOfChild(radioButton)
            when(index){
                0 -> radioButtonChoice = 0
                1 -> radioButtonChoice = 1
                2 -> radioButtonChoice = 2
            }
        }
        buttonKaydet.setOnClickListener {
            val takeName = binding.TextInputeditTextName.text.toString()
            preferences?.edit()?.putString("user",takeName)?.apply()
            preferences?.edit()?.putInt("gender",radioButtonChoice)?.apply()



            val action = ChangingUserFragmentDirections.actionChangingUserFragmentToMainFragment()
            Navigation.findNavController(binding.root).navigate(action)

        }
        return binding.root

    }


}