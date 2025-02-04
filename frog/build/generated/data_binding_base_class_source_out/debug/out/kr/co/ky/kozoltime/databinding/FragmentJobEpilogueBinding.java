// Generated by view binder compiler. Do not edit!
package kr.co.ky.kozoltime.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import kr.co.ky.kozoltime.R;

public final class FragmentJobEpilogueBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final GridLayout gridButton;

  @NonNull
  public final LinearLayout homeLinear;

  @NonNull
  public final Button homeSearchBtn;

  @NonNull
  public final LinearLayout mainContent;

  @NonNull
  public final Button officeBtn;

  private FragmentJobEpilogueBinding(@NonNull ConstraintLayout rootView,
      @NonNull GridLayout gridButton, @NonNull LinearLayout homeLinear,
      @NonNull Button homeSearchBtn, @NonNull LinearLayout mainContent, @NonNull Button officeBtn) {
    this.rootView = rootView;
    this.gridButton = gridButton;
    this.homeLinear = homeLinear;
    this.homeSearchBtn = homeSearchBtn;
    this.mainContent = mainContent;
    this.officeBtn = officeBtn;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentJobEpilogueBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentJobEpilogueBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_job_epilogue, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentJobEpilogueBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.grid_button;
      GridLayout gridButton = ViewBindings.findChildViewById(rootView, id);
      if (gridButton == null) {
        break missingId;
      }

      id = R.id.home_linear;
      LinearLayout homeLinear = ViewBindings.findChildViewById(rootView, id);
      if (homeLinear == null) {
        break missingId;
      }

      id = R.id.home_search_btn;
      Button homeSearchBtn = ViewBindings.findChildViewById(rootView, id);
      if (homeSearchBtn == null) {
        break missingId;
      }

      id = R.id.main_content;
      LinearLayout mainContent = ViewBindings.findChildViewById(rootView, id);
      if (mainContent == null) {
        break missingId;
      }

      id = R.id.office_btn;
      Button officeBtn = ViewBindings.findChildViewById(rootView, id);
      if (officeBtn == null) {
        break missingId;
      }

      return new FragmentJobEpilogueBinding((ConstraintLayout) rootView, gridButton, homeLinear,
          homeSearchBtn, mainContent, officeBtn);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
