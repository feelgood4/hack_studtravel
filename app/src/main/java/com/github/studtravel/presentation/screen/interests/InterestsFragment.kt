package com.github.studtravel.presentation.screen.interests

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.github.studtravel.R
import com.github.studtravel.databinding.FragmentInterestsBinding
import com.github.studtravel.presentation.screen.interests.model.Interest
import com.github.studtravel.presentation.screen.main_search.MainTabFragment
import com.github.studtravel.presentation.viewmodel.MainViewModel

class InterestsFragment : Fragment() {

  private val viewModel: MainViewModel by viewModels()
  private var _binding: FragmentInterestsBinding? = null
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {

    _binding = FragmentInterestsBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    hideSystemBar()

    val confirmButton = binding.confirm
    val skipButton = binding.skip
    val interestsList = binding.interestsList

    val interestsListData = mutableListOf(
      Interest(
        iconResId = R.drawable.img_art_interest,
        textResId = R.string.art_interest_name,
        isChecked = false
      ),
      Interest(
        iconResId = R.drawable.img_science_interest,
        textResId = R.string.science_interest_name,
        isChecked = false
      ),
      Interest(
        iconResId = R.drawable.img_travel_interest,
        textResId = R.string.travel_interest_name,
        isChecked = false
      ),
      Interest(
        iconResId = R.drawable.img_music_interest,
        textResId = R.string.music_interest_name,
        isChecked = false
      ),
      Interest(
        iconResId = R.drawable.img_festival_interest,
        textResId = R.string.fest_interest_name,
        isChecked = false
      ),
      Interest(
        iconResId = R.drawable.img_nature_interest,
        textResId = R.string.nature_interest_name,
        isChecked = false
      )
    )
    val interestsAdapter = InterestsAdapter(interestsListData) { itemId ->
      val newList = interestsListData.mapIndexed { index, interest ->
        if (index == itemId) interest.copy(isChecked = !interest.isChecked)
        else interest
      }
      interestsListData.clear()
      interestsListData.addAll(newList)
      interestsList.adapter?.notifyItemChanged(itemId)

      confirmButton.isEnabled = newList.find { it.isChecked } != null
    }

    interestsList.apply {
      layoutManager = GridLayoutManager(activity?.applicationContext, 2)
      adapter = interestsAdapter
    }

    val goMainScreen = View.OnClickListener {
      parentFragmentManager
        .beginTransaction()
        .replace(R.id.rootFragmentContainer, MainTabFragment(), "MainScreen")
        .commit()
    }

    confirmButton.setOnClickListener(goMainScreen)
    skipButton.setOnClickListener(goMainScreen)
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }

  private fun hideSystemBar() {
    val hideHandler = Handler(Looper.myLooper()!!)
    val hidePart2Runnable = Runnable {
      val flags =
        View.SYSTEM_UI_FLAG_LOW_PROFILE or
          View.SYSTEM_UI_FLAG_FULLSCREEN or
          View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
          View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
          View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
          View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
      activity?.window?.decorView?.systemUiVisibility = flags
      (activity as? AppCompatActivity)?.supportActionBar?.hide()
    }

    hideHandler.post(hidePart2Runnable)
  }
}
