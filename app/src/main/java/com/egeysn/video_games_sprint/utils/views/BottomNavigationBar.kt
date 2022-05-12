package com.egeysn.video_games_sprint.utils.views

import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.PorterDuff
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.egeysn.video_games_sprint.R
import com.egeysn.video_games_sprint.databinding.NavigationBarBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BottomNavigationBar : LinearLayout, View.OnClickListener {

    private var listener: NavigationBarListener? = null

    var binding: NavigationBarBinding =
        NavigationBarBinding.inflate(LayoutInflater.from(context), this, true)

    private var selectedPos: Int = 0

    init {
        listeners()
    }

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private fun listeners() {
        binding.homeContainer.setOnClickListener(this)
        binding.favoritesContainer.setOnClickListener(this)
    }

    fun setListener(listener: NavigationBarListener) {
        this.listener = listener
    }

    @Synchronized
    fun selectItem(pos: Int) {
        if (selectedPos != pos) {
            selectedPos = pos
            makeSelected(pos)
        }
    }

    @Synchronized
    fun makeUnSelected() {
        binding.homeIv.setColorFilter(
            ContextCompat.getColor(
                context,
                R.color.white
            ),
            PorterDuff.Mode.SRC_IN
        )
        binding.homeTv.setTextColor(
            ContextCompat.getColor(
                context,
                R.color.white
            ),
        )
        binding.favoritesIv.setColorFilter(
            ContextCompat.getColor(
                context,
                R.color.white
            ),
            PorterDuff.Mode.SRC_IN
        )
        binding.favoritesTv.setTextColor(
            ContextCompat.getColor(
                context,
                R.color.white
            ),
        )
    }

    @Synchronized
    fun makeSelected(pos: Int) {
        makeUnSelected()
        val imageAnim = ValueAnimator()
        imageAnim.setIntValues(
            ContextCompat.getColor(context, R.color.white),
            ContextCompat.getColor(context, R.color.secondary)
        )
        imageAnim.setEvaluator(ArgbEvaluator())
        imageAnim.addUpdateListener { valueAnimator: ValueAnimator ->
            when (pos) {
                0 -> {
                    binding.homeIv.setColorFilter(
                        (valueAnimator.animatedValue as Int),
                        PorterDuff.Mode.SRC_IN
                    )
                    binding.homeTv.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.color.secondary
                        )
                    )
                }
                1 -> {
                    binding.favoritesIv.setColorFilter(
                        (valueAnimator.animatedValue as Int),
                        PorterDuff.Mode.SRC_IN
                    )
                    binding.favoritesTv.setTextColor(
                        ContextCompat.getColor(
                            context,
                            R.color.secondary
                        )
                    )
                }
            }
        }
        val textAnim = ValueAnimator()
        textAnim.setIntValues(
            ContextCompat.getColor(context, R.color.gray3),
            ContextCompat.getColor(context, R.color.gray8)
        )
        textAnim.setEvaluator(ArgbEvaluator())
        textAnim.addUpdateListener { valueAnimator: ValueAnimator ->
            when (pos) {
                0 -> binding.homeTv.setTextColor((valueAnimator.animatedValue as Int))
                2 -> binding.favoritesTv.setTextColor((valueAnimator.animatedValue as Int))
            }
        }
        textAnim.duration = 50
        textAnim.start()
        imageAnim.duration = 50
        imageAnim.start()
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        binding.homeIv.setColorFilter(
            ContextCompat.getColor(context, R.color.secondary),
            PorterDuff.Mode.SRC_IN
        )
        binding.homeTv.setTextColor(ContextCompat.getColor(context, R.color.secondary))
/*

        binding.basketIv.setColorFilter(
            ContextCompat.getColor(context, R.color.white),
            PorterDuff.Mode.SRC_IN
        )
        binding.basketTv.setTextColor(ContextCompat.getColor(context, R.color.white))
*/

        binding.favoritesIv.setColorFilter(
            ContextCompat.getColor(context, R.color.white),
            PorterDuff.Mode.SRC_IN
        )
        binding.favoritesTv.setTextColor(ContextCompat.getColor(context, R.color.white))
    }

    override fun onClick(v: View?) {
        synchronizedOnClicked(v!!)
    }

    @Synchronized
    private fun synchronizedOnClicked(view: View) {
        when (view.id) {
            R.id.home_container -> selectItem(0)
            R.id.favorites_container -> selectItem(1)
        }
        if (listener != null) listener!!.onNavigationClicked(selectedPos)
    }

    interface NavigationBarListener {
        fun onNavigationClicked(pos: Int)
    }
}
