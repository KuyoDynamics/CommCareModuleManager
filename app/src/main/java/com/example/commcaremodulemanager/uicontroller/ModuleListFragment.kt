package com.example.commcaremodulemanager.uicontroller

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.commcaremodulemanager.ModuleAdaptor
import com.example.commcaremodulemanager.R
import com.example.commcaremodulemanager.viewmodel.ModuleListViewModel
import timber.log.Timber

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ModuleListFragment : Fragment() {

//    reference to the ViewModel
    private lateinit var viewModel: ModuleListViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val adaptor = ModuleAdaptor()
//      initialize the viewModel
        Timber.i("ModuleListFragment", "Called ViewModelProvider.get")
        viewModel = ViewModelProvider(this)[ModuleListViewModel::class.java]
        Timber.i("HomeFragment", "onCreateView called")
        return inflater.inflate(R.layout.fragment_module_list, container, false)
    }

//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        Log.i("TitleFragment", "onAttach called")
//    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.i("HomeFragment", "onCreate called")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Timber.i("HomeFragment", "onAttach called")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.i("HomeFragment", "onViewCreated called")
    }

    override fun onStart() {
        super.onStart()
        Timber.i("HomeFragment", "onStart called")
    }
    override fun onResume() {
        super.onResume()
        Timber.i("HomeFragment", "onResume called")
    }
    override fun onPause() {
        super.onPause()
        Timber.i("HomeFragment", "onPause called")
    }
    override fun onStop() {
        super.onStop()
        Timber.i("HomeFragment", "onStop called")
    }
    override fun onDestroyView() {
        super.onDestroyView()
        Timber.i("HomeFragment", "onDestroyView called")
    }
    override fun onDetach() {
        super.onDetach()
        Timber.i("HomeFragment", "onDetach called")
    }
}