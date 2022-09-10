package kg.geektech.newsapp46

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kg.geektech.newsapp46.databinding.FragmentDashboardBinding
import kg.geektech.newsapp46.databinding.FragmentSecondBinding
import kg.geektech.newsapp46.models.News
import kg.geektech.newsapp46.ui.dashboard.DashboardViewModel


class SecondFragment : Fragment() {
    private var _binding: FragmentSecondBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSave.setOnClickListener {
            navigateWithBundle()
        }
    }

    private fun navigateWithBundle() {
        val bundle = Bundle()
        val text = binding.editText.text.toString()
        val news = News(text, System.currentTimeMillis())
        bundle.putSerializable("news", news)
        parentFragmentManager.setFragmentResult("key_bundle", bundle)
        findNavController().navigateUp()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}