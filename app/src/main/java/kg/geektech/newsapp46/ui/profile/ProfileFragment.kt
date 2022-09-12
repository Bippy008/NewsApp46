package kg.geektech.newsapp46.ui.profile

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import kg.geektech.newsapp46.MainActivity
import kg.geektech.newsapp46.databinding.FragmentProfileBinding
import kg.geektech.newsapp46.ui.Prefs

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private lateinit var launcher: ActivityResultLauncher<Intent>

    private val binding get() = _binding!!
    private lateinit var prefs : Prefs

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        prefs = Prefs(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLauncher()
        binding.profileImage.setImageURI(Uri.parse(prefs.getAvatar()))
        binding.profileName.setText(prefs.getName())
        binding.profileName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                val name = binding.profileName.text.toString()
                prefs.saveName(name)
            }

        })
        binding.btnChooseImage.setOnClickListener {
            openGallery()
        }
    }

    private fun openGallery() {
        val intentAvatar = Intent(Intent.ACTION_PICK)
        intentAvatar.type = "image/*"
        launcher.launch(intentAvatar)
    }

    private fun initLauncher() {
        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == AppCompatActivity.RESULT_OK) {
                val image = it.data?.data
                binding.profileImage.setImageURI(image)
                prefs.saveAvatar(image?.path)
            }
        }
    }
}