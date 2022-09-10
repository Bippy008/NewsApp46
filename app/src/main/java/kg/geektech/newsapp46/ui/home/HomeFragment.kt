package kg.geektech.newsapp46.ui.home

import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kg.geektech.newsapp46.R
import kg.geektech.newsapp46.databinding.FragmentHomeBinding
import kg.geektech.newsapp46.models.News

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = NewsAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigate()
        parentFragmentManager.setFragmentResultListener("key_bundle",
            viewLifecycleOwner){requestkey, bundle ->
            val news = bundle.getSerializable("news") as News
            adapter.addItem(news)
            Log.e("Home", "text: $news")
        }
        binding.recyclerView.adapter = adapter

    }

    private fun navigate() {
        binding.btnNavigate.setOnClickListener {
            findNavController().navigate(R.id.secondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}