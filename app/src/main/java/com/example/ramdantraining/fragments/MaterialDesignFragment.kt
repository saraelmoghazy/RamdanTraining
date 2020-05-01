package com.example.ramdantraining.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.customview.widget.ViewDragHelper

import com.example.ramdantraining.R
import com.google.android.material.card.MaterialCardView
import kotlinx.android.synthetic.main.fragment_material_design.*

/**
 * A simple [Fragment] subclass.
 */
class MaterialDesignFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_material_design, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        card.isDragged = true
       // card.setOnDragListener()
//        parentContainer.addDraggableChild(card)
//        parentContainer.setViewDragListener(object
//            : DraggableCoordinatorLayout.ViewDragListener {
//
//            override fun onViewCaptured(view: View, pointerId: Int) {
//                card.isDragged = true
//            }
//
//            override fun onViewReleased(view: View, vX: Float, vY: Float) {
//                card.isDragged = false
//            }
//        })
    }

    private inner class ViewDragHelperCallback : ViewDragHelper.Callback() {

        override fun onViewCaptured(capturedChild: View, activePointerId: Int) {
            if (capturedChild is MaterialCardView) {
                (card as MaterialCardView).isDragged = true
            }
        }

        override fun onViewReleased(releaseChild: View, xVel: Float, yVel: Float) {
            if (releaseChild is MaterialCardView) {
                (card as MaterialCardView).isDragged = false
            }
        }

        override fun tryCaptureView(child: View, pointerId: Int): Boolean {
            return true
        }
    }


}
