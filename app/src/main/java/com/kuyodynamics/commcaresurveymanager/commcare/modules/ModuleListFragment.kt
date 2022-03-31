package com.kuyodynamics.commcaresurveymanager.commcare.modules

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.kuyodynamics.commcaresurveymanager.R
import com.kuyodynamics.commcaresurveymanager.databinding.FragmentModuleListBinding
import timber.log.Timber

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ModuleListFragment : Fragment() {
    // binding
    private lateinit var binding: FragmentModuleListBinding

    //    reference to the ViewModel
    private lateinit var viewModel: ModuleListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_module_list, container, false)
        val adaptor = ModuleListAdaptor()
//      initialize the viewModel
        Timber.i("Called ViewModelProvider.get")
        viewModel = ViewModelProvider(this)[ModuleListViewModel::class.java]

//        Should I do this type of thing instead?
//        binding.commcareApp = viewModel.commCareApp
//        And connect the event listeners in the xaml as:
//        <Button
//              android:id="@+id/play_again_button"
//              ...
//              android:onClick="@{() -> scoreViewModel.onPlayAgain()}"
//         ... />
        binding.lifecycleOwner = viewLifecycleOwner
        viewModel.commCareApp.observe(
            viewLifecycleOwner,
            Observer { newCommCareApp -> binding.commCareApp = newCommCareApp })

        Timber.i("App Name", binding.commCareApp?.name)

        return binding.root
    }

    //    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        Log.i("TitleFragment", "onAttach called")
//    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.i("onCreate called")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Timber.i("onAttach called")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.i("onViewCreated called")
    }

    override fun onStart() {
        super.onStart()
        Timber.i("onStart called")
    }

    override fun onResume() {
        super.onResume()
        Timber.i("onResume called")
    }

    override fun onPause() {
        super.onPause()
        Timber.i("onPause called")
    }

    override fun onStop() {
        super.onStop()
        Timber.i("onStop called")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Timber.i("onDestroyView called")
    }

    override fun onDetach() {
        super.onDetach()
        Timber.i("onDetach called")
    }
}