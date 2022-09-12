package kg.geektech.newsapp46

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayoutMediator
import kg.geektech.newsapp46.databinding.FragmentBoardBinding
import kg.geektech.newsapp46.ui.Prefs

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
        binding.viewPager.adapter = BoardAdapter(requireContext(), findNavController())
        TabLayoutMediator(binding.boardTabLayout, binding.viewPager) {tab, position ->
        }.attach()
        binding.boardSkip.setOnClickListener{
            val prefs = Prefs(requireContext())
            prefs.saveState()
            findNavController().navigateUp()
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                requireActivity().finish()
            }

        })
    }
}


