package com.example.servise_review_ui

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.core.view.GestureDetectorCompat
import androidx.fragment.app.Fragment
import com.example.servise_review_ui.databinding.FragmentServiseReviewBinding
import com.example.servise_review_ui.viewModel.ServiseReviewViewModel
import com.squareup.picasso.Picasso
import com.uaref.fragment.R
import org.koin.android.ext.android.inject

class ServiseReviewFragment : Fragment() {

    val viewModel: ServiseReviewViewModel by inject()

    private lateinit var mgestureDetector: GestureDetectorCompat
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = FragmentServiseReviewBinding.inflate(layoutInflater, container, false)

        val id = arguments?.getInt("id")
        val type = arguments?.getString("type")

        if (id == null || type == null) Toast.makeText(requireActivity(), "Download Error", Toast.LENGTH_LONG).show()
        else {
            viewModel.getComments(id, type)
            viewModel.getServiseInfo(id, type)
            viewModel.getUserInfo(id, type)
        }
        viewModel._userInfo.observe(requireActivity()) { user ->
            view.username.text = user.username
            Picasso.with(view.profileImage.context)
                .load(user.photo)
                .placeholder(R.drawable.loading_anim)
                .fit()
                .into(view.profileImage)
        }

        var chosenTime = "18:00 - 22:00 F"

        viewModel._serviseInfo.observe(requireActivity()) { servise ->
            view.Speciality.text = servise.specialities
            view.description.text = servise.description
            view.checkBox1.text = "${servise.dates.first.start}-${servise.dates.first.end} ${servise.dates.first.dayOfWeek}"
            view.checkBox2.text = "${servise.dates.second.start}-${servise.dates.second.end} ${servise.dates.second.dayOfWeek}"
            view.checkBox3.text = "${servise.dates.third.start}-${servise.dates.third.end} ${servise.dates.third.dayOfWeek}"
        }
        view.checkBox1.setOnClickListener {
            chosenTime = view.checkBox1.text.toString()
            if (view.checkBox2.isChecked)view.checkBox2.isChecked = false
            if (view.checkBox3.isChecked)view.checkBox3.isChecked = false
        }
        view.checkBox2.setOnClickListener {
            chosenTime = view.checkBox2.text.toString()
            if (view.checkBox1.isChecked)view.checkBox1.isChecked = false
            if (view.checkBox3.isChecked)view.checkBox3.isChecked = false
        }
        view.checkBox3.setOnClickListener {
            chosenTime = view.checkBox3.text.toString()
            if (view.checkBox3.isChecked)view.checkBox2.isChecked = false
            if (view.checkBox1.isChecked)view.checkBox1.isChecked = false
        }

        view.constraintLayout2.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionCompleted(motionLayout: MotionLayout?, currentId: Int) {
                if (view.comentsRecycler.visibility == View.GONE) {
                    view.comentsRecycler.visibility = View.VISIBLE
                    view.titleDescription.visibility = View.VISIBLE
                } else {
                    view.comentsRecycler.visibility = View.GONE
                    view.titleDescription.visibility = View.GONE
                }
            }

            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {
            }

            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
            }

            override fun onTransitionChange(motionLayout: MotionLayout?, startId: Int, endId: Int, progress: Float) {
            }
        })

        view.getStartedButton.setOnClickListener {
            if (id != null&&type!=null) {
                viewModel.takeServise(id,type,chosenTime)
                Toast.makeText(requireActivity(), "Success", Toast.LENGTH_LONG).show()
            }
            else Toast.makeText(requireActivity(), "Application Error", Toast.LENGTH_LONG).show()
        }

        return view.apply {
            viewModel = this@ServiseReviewFragment.viewModel
            lifecycleOwner = this@ServiseReviewFragment
        }.root
    }
}
