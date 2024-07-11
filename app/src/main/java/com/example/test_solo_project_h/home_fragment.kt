package com.example.test_solo_project_h

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.test_solo_project_h.databinding.HomeFragmentBinding
import com.example.test_solo_project_h.ui.adapter.RickMortyAdapter
import com.example.test_solo_project_h.ui.viewmodel.RickMortyViewModel
import dagger.hilt.android.AndroidEntryPoint


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [home_fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class home_fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null




    private lateinit var binding: HomeFragmentBinding
    private lateinit var adapterMain: RickMortyAdapter
    private val viewModelMain: RickMortyViewModel by viewModels()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapterMain = RickMortyAdapter()

        binding.rcView.apply{
            adapter = adapterMain
            layoutManager = GridLayoutManager(requireContext(), 2)
            setHasFixedSize(true)
        }

        lifecycleScope.launchWhenCreated {
            viewModelMain.state.collect{
                when{
                    it.load -> binding.progressBar.visibility = View.VISIBLE
                    it.success.isNotEmpty()->{
                        binding.progressBar.visibility = View.GONE
                        adapterMain.submitList(it.success)
                    }
                    it.fail.isNotBlank()->{
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(requireContext(), it.fail, Toast.LENGTH_SHORT).show()

                    }
                }
            }
        }


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment home_fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            home_fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}