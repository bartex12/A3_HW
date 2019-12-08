package ru.barcats.a3l5_home;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;

public class FabBehaviorColor extends FloatingActionButton.Behavior  {

    public FabBehaviorColor(Context context, AttributeSet attrs) {
        super();
    }

    @Override
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout,
                               @NonNull FloatingActionButton child,
                               @NonNull View target,
                               int dxConsumed,
                               int dyConsumed,
                               int dxUnconsumed,
                               int dyUnconsumed,
                               int type) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type);
        if ( dyConsumed > 0) {
            child.setBackgroundTintList(ColorStateList.valueOf(target
                    .getContext().getResources().getColor(R.color.colorPrimary)));
            child.setImageResource(R.drawable.ic_arrow_upward_white_24dp);
        } else if (dyConsumed < 0) {
            child.setBackgroundTintList(ColorStateList.valueOf(target
                    .getContext().getResources().getColor(R.color.colorAccent)));
            child.setImageResource(R.drawable.ic_arrow_downward_white_24dp);
        }
    }

    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout,
                                       @NonNull FloatingActionButton child,
                                       @NonNull View directTargetChild,
                                       @NonNull View target,
                                       int axes,
                                       int type) {
        return axes == ViewCompat.SCROLL_AXIS_VERTICAL;
    }
}
