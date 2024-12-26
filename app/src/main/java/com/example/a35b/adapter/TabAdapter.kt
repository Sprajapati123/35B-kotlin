package com.example.a35b.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.a35b.ui.fragment.ActiveFragment
import com.example.a35b.ui.fragment.CancelledFragment
import com.example.a35b.ui.fragment.DeliveredFragment

class TabAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager,lifecycle) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0-> return CancelledFragment()
            1-> return ActiveFragment()
            2-> return DeliveredFragment()
            else-> return ActiveFragment()
        }
    }

}