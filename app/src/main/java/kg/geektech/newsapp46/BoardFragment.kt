package kg.geektech.newsapp46

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import kg.geektech.newsapp46.R
import kg.geektech.newsapp46.databinding.FragmentBoardBinding
import kotlinx.coroutines.NonDisposableHandle.parent

class BoardFragment : Fragment() {

    private lateinit var binding: FragmentBoardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewPager.adapter = BoardAdapter()
        TabLayoutMediator(binding.boardTabLayout, binding.viewPager) {tab, position ->

        }.attach()
    }
}