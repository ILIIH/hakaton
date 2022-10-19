package com.example.servise_review_ui

import android.os.Bundle
import android.view.*
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.core.view.GestureDetectorCompat
import androidx.fragment.app.Fragment
import com.example.servise_review_ui.databinding.FragmentServiseReviewBinding
import com.example.servise_review_ui.viewModel.serviseReviewViewModel
import org.koin.android.ext.android.inject

class ServiseReviewFragment : Fragment() {

    val username = "Joe"

    val viewModel: serviseReviewViewModel by inject()

    private lateinit var mgestureDetector: GestureDetectorCompat
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = FragmentServiseReviewBinding.inflate(layoutInflater, container, false)

        viewModel.getComments(username)
        viewModel.getServiseInfo(username)

        viewModel._serviseInfo.observe(requireActivity()) { servise ->
            view.username.text = servise.username
            view.Speciality.text = servise.specialities
            view.description.text = servise.description
            view.checkBox1.text = "${servise.dates.first.start}-${servise.dates.first.end} ${servise.dates.first.dayOfWeek}"
            view.checkBox2.text = "${servise.dates.second.start}-${servise.dates.second.end} ${servise.dates.second.dayOfWeek}"
            view.checkBox3.text = "${servise.dates.third.start}-${servise.dates.third.end} ${servise.dates.third.dayOfWeek}"
        }
        view.checkBox1.setOnClickListener {
            if (view.checkBox2.isChecked)view.checkBox2.isChecked = false
            if (view.checkBox3.isChecked)view.checkBox3.isChecked = false
        }
        view.checkBox2.setOnClickListener {
            if (view.checkBox1.isChecked)view.checkBox1.isChecked = false
            if (view.checkBox3.isChecked)view.checkBox3.isChecked = false
        }
        view.checkBox3.setOnClickListener {
            if (view.checkBox3.isChecked)view.checkBox2.isChecked = false
            if (view.checkBox1.isChecked)view.checkBox1.isChecked = false
        }

        view.constraintLayout2.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionCompleted(motionLayout: MotionLayout?, currentId: Int) {
                if (view.comentsRecycler.visibility == View.GONE) view.comentsRecycler.visibility = View.VISIBLE
                else view.comentsRecycler.visibility = View.GONE
            }

            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {
            }

            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
            }

            override fun onTransitionChange(motionLayout: MotionLayout?, startId: Int, endId: Int, progress: Float) {
            }
        })

        return view.root
    }
}
