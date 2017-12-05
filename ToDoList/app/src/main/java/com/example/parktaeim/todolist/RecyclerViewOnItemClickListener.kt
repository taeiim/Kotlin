package com.example.parktaeim.todolist

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View

/**
 * Created by parktaeim on 2017. 12. 2..
 */
class RecyclerViewOnItemClickListener(context: Context, recyclerView: RecyclerView, private val mListener: OnItemClickListener?) : RecyclerView.SimpleOnItemTouchListener() {
    private val mGestureDetector: GestureDetector

    init {
        mGestureDetector = GestureDetector(context, object : GestureDetector.SimpleOnGestureListener() {
            override fun onSingleTapUp(e: MotionEvent): Boolean {
                return true
            }

            override fun onLongPress(e: MotionEvent) {
                val childView = recyclerView.findChildViewUnder(e.x, e.y)
                if (childView != null && mListener != null) {
                    mListener.onItemLongClick(childView, recyclerView.getChildAdapterPosition(childView))
                }
            }
        })
    }

    override fun onInterceptTouchEvent(rv: RecyclerView?, e: MotionEvent?): Boolean {
        val child = rv!!.findChildViewUnder(e!!.x, e.y)
        if (child != null && mListener != null && mGestureDetector.onTouchEvent(e)) {
            mListener.onItemClick(child, rv.getChildAdapterPosition(child))
            return true
        }
        return false
    }

    interface OnItemClickListener {
        fun onItemClick(v: View, position: Int)
        fun onItemLongClick(v: View?, position: Int)
    }


}

